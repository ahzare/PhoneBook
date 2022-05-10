/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sain.headless.phonebook.internal.resource.v1_0;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import com.sain.headless.phonebook.dto.v1_0.Address;
import com.sain.headless.phonebook.resource.v1_0.AddressResource;
import com.sain.phonebook.service.AddressService;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Amir
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/address.properties",
	scope = ServiceScope.PROTOTYPE, service = AddressResource.class
)
public class AddressResourceImpl extends BaseAddressResourceImpl {

	@Override
	public void deleteAddressApi(Long siteId, Long addressId) throws Exception {
		try {

			// super easy case, just pass through to the service layer.

			_addressService.deleteAddress(addressId);
		}
		catch (Exception exception) {
			_log.error(
				"Error deleting address: " + exception.getMessage(), exception);

			throw exception;
		}
	}

	@Override
	public Address getAddressApi(Long siteId, Long addressId) throws Exception {
		try {

			// fetch the entity class...

			com.sain.phonebook.model.Address persistedAddress =
				_addressService.getAddress(addressId);

			return toAddress(persistedAddress);
		}
		catch (Exception exception) {
			_log.error(
				"Error getting address [" + addressId + "]: " +
					exception.getMessage(),
				exception);

			throw exception;
		}
	}

	@Override
	public Page<Address> getAddressesPage(
			Long siteId, String search, Filter filter, Pagination pagination,
			Sort[] sorts)
		throws Exception {

		System.out.println("getAddressesPage");

		/* return SearchUtil.search(
		         null,
		         booleanQuery -> {
		         },
		         filter, Address.class, search, pagination,
		         queryConfig -> queryConfig.setSelectedFieldNames(
		                 Field.ENTRY_CLASS_PK),
		         searchContext -> {
		             searchContext.setCompanyId(contextCompany.getCompanyId());
		             searchContext.setGroupIds(new long[] {contextCompany.getGroupId()});
		         },
		         sorts,
		         document -> _toAddress(_persistedAddressService.getPersistedAddress(document.get(Field.ENTRY_CLASS_PK))));
*/

		/* return SearchUtil.search(
		       null,
		         booleanQuery -> {
		         },
		         filter, Address.class, search, pagination,
		         queryConfig -> queryConfig.setSelectedFieldNames(
		                 Field.ENTRY_CLASS_PK),
		         searchContext -> {
		             searchContext.setAttribute(Field.NAME, search);
		             searchContext.setCompanyId(contextCompany.getCompanyId());
		             searchContext.setGroupIds(new long[] {contextCompany.getGroupId()});
		         },
		         sorts,
		         document -> _toAddress(
		                 _persistedAddressService.getPersistedAddress(
		                         GetterUtil.getString(
		                         document.get(Field.ENTRY_CLASS_PK)))));*/

		/* List<Address> list = _persistedAddressService.getAll()
		         .stream().map(persistedAddress -> {
		             try {
		                 // adding for search
		                 Address address = _toAddress(persistedAddress);
		                 if (search != null) {
		                     if (address.getName().contains(search)) {
		                         return address;
		                     }
		                 } else {
		                     return address;
		                 }
		                 //return _toAddress(persistedAddress);
		             } catch (PortalException exception) {
		                 exception.printStackTrace();
		             }
		             return new Address();
		         }).collect(Collectors.toList());*/

		List<com.sain.phonebook.model.Address> persistedAddresses =
			_addressService.getAll();
		List<Address> list = new ArrayList<>();

		for (com.sain.phonebook.model.Address persistedAddress :
				persistedAddresses) {

			Address address = toAddress(persistedAddress);

			if (search != null) {
				String name = address.getName();

				if (name.contains(search)) {
					list.add(address);
				}
			}
			else {
				list.add(address);
			}
		}

		return Page.of(list);
	}

	@Override
	public Address patchAddress(@NotNull Long addressId, Address address)
		throws Exception {

		try {
			com.sain.phonebook.model.Address persistedAddress =
				_addressService.patchAddress(
					addressId, address.getName(), getServiceContext());

			return toAddress(persistedAddress);
		}
		catch (Exception exception) {
			_log.error(
				"Error patching address: " + exception.getMessage(), exception);

			throw exception;
		}
	}

	@Override
	public Address postAddress(Long siteId, Address address) throws Exception {
		System.out.println("postAddress");

		if (_log.isDebugEnabled()) {
			_log.debug(
				"Need to create a new address: %s\n", address.toString());
		}

		_log.warn("hi ali");

		try {
			com.sain.phonebook.model.Address persistedAddress =
				_addressService.addAddress(
					address.getName(), getServiceContext());

			return toAddress(persistedAddress);
		}
		catch (Exception exception) {
			_log.error(
				"Error creating address: " + exception.getMessage(), exception);

			throw exception;
		}
	}

	@Override
	public Address putAddress(@NotNull Long addressId, Address address)
		throws Exception {

		try {
			com.sain.phonebook.model.Address persistedAddress =
				_addressService.updateAddress(
					addressId, address.getName(), getServiceContext());

			return toAddress(persistedAddress);
		}
		catch (Exception exception) {
			_log.error(
				"Error putting address: " + exception.getMessage(), exception);

			throw exception;
		}
	}

	/*private AddressEntityModel _addressEntityModel = new AddressEntityModel();

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap)
			throws Exception {
		return _addressEntityModel;
	}*/

	protected static Address toAddress(com.sain.phonebook.model.Address address)
		throws PortalException {

		return new Address() {
			{
				id = address.getAddressId();
				name = address.getName();
			}
		};
		/*return new Address() {{
			creator = CreatorUtil.toCreator(_portal,
					_userLocalService.getUser(pv.getUserId()));
			articleId = pv.getArticleId();
			group = pv.getGroupName();
			description = pv.getDescription();
			id = pv.getSurrogateId();
			name = pv.getName();
			type = _toAddressType(pv.getType());
			attributes = ListUtil.toArray(pv.getAttributes(), VALUE_ACCESSOR);
			chemicalNames = ListUtil.toArray(pv.getChemicalNames(), VALUE_ACCESSOR);
			properties = ListUtil.toArray(pv.getProperties(), VALUE_ACCESSOR);
			risks = ListUtil.toArray(pv.getRisks(), VALUE_ACCESSOR);
			symptoms = ListUtil.toArray(pv.getSymptoms(), VALUE_ACCESSOR);
		}};*/
	}

	protected ServiceContext getServiceContext() throws PortalException {
		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(contextCompany.getCompanyId());

		// need the current user in the service context.
		// will get easier in newer version of the REST Builder plugin...
		// but for now, this is the only game in town.

		serviceContext.setUserId(PrincipalThreadLocal.getUserId());

		return serviceContext;
	}

	private static final Logger _log = LoggerFactory.getLogger(
		AddressResourceImpl.class);

	@Reference
	private AddressService _addressService;

	@Reference
	private Portal _portal;

	@Reference
	private UserLocalService _userLocalService;

}