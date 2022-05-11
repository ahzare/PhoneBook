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

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;

import com.sain.headless.phonebook.dto.v1_0.Part;
import com.sain.headless.phonebook.resource.v1_0.PartResource;
import com.sain.headless.phonebook.util.ServiceContextHelper;
import com.sain.phonebook.service.AddressService;
import com.sain.phonebook.service.PartService;

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
	properties = "OSGI-INF/liferay/rest/v1_0/part.properties",
	scope = ServiceScope.PROTOTYPE, service = PartResource.class
)
public class PartResourceImpl extends BasePartResourceImpl {

	@Override
	public Part deletePartApi(Long siteId, Long partId) throws Exception {
		return toPart(_partService.deletePart(partId));
	}

	@Override
	public Part getPart(Long partId) throws Exception {
		try {

			// fetch the entity class...

			com.sain.phonebook.model.Part persistedPart = _partService.getPart(
				partId);

			if (persistedPart != null) {
				return toPart(persistedPart);
			}

			return null;
		}
		catch (Exception exception) {
			_log.error(
				"Error getting part [" + partId + "]: " +
					exception.getMessage(),
				exception);

			throw exception;
		}
	}

	@Override
	public Page<Part> getPartsPage(
			Long siteId, String search, Filter filter, Pagination pagination,
			Sort[] sorts)
		throws Exception {

		System.out.println("getPartsPage");

		Page<Part> partPage = SearchUtil.search(
			booleanQuery -> booleanQuery.getPreBooleanFilter(), filter,
			com.sain.phonebook.model.Part.class, search, pagination,
			queryConfig -> queryConfig.setSelectedFieldNames(
				Field.ENTRY_CLASS_PK),
			new UnsafeConsumer() {

				public void accept(Object object) throws Exception {
					SearchContext searchContext = (SearchContext)object;

					searchContext.setCompanyId(contextCompany.getCompanyId());
				}

			},
			document -> toPart(
				_partService.getPart(
					GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)))),
			sorts);

		System.out.println("part page = " + partPage);

		return partPage;
	}

	@Override
	public Part patchPart(@NotNull Long partId, Long addressId, Part part)
		throws Exception {

		com.sain.phonebook.model.Part persistedPart1 = _partService.getPart(
			partId);

		if (persistedPart1 != null) {
			try {
				com.sain.phonebook.model.Part persistedPart =
					_partService.patchPart(
						partId, part.getName(), part.getInternalPhone(),
						(addressId != null) ? addressId : 0,
						_serviceContextHelper.getServiceContext(
							persistedPart1.getGroupId()));

				return toPart(persistedPart);
			}
			catch (Exception exception) {
				_log.error(
					"Error patching part: " + exception.getMessage(),
					exception);

				throw exception;
			}
		}
		else {
			return null;
		}
	}

	@Override
	public Part postPart(Long siteId, Long addressId, Part part)
		throws Exception {

		System.out.println("postPart");

		if (_log.isDebugEnabled()) {
			_log.debug("Need to create a new part: %s\n", part.toString());
		}

		try {
			com.sain.phonebook.model.Part persistedPart = _partService.addPart(
				part.getName(), part.getInternalPhone(),
				(addressId != null) ? addressId : 0,
				_serviceContextHelper.getServiceContext(siteId));

			return toPart(persistedPart);
		}
		catch (Exception exception) {
			_log.error(
				"Error creating part: " + exception.getMessage(), exception);

			throw exception;
		}
	}

	@Override
	public Part putPartApi(Long partId, Long addressId, Part part)
		throws Exception {

		com.sain.phonebook.model.Part persistedPart1 = _partService.getPart(
			partId);

		if (persistedPart1 != null) {
			try {
				com.sain.phonebook.model.Part persistedPart =
					_partService.updatePart(
						partId, part.getName(), part.getInternalPhone(),
						(addressId != null) ? addressId : 0,
						_serviceContextHelper.getServiceContext(
							persistedPart1.getGroupId()));

				return toPart(persistedPart);
			}
			catch (Exception exception) {
				_log.error(
					"Error putting part: " + exception.getMessage(), exception);

				throw exception;
			}
		}
		else {
			return null;
		}
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

	protected Part toPart(com.sain.phonebook.model.Part part)
		throws PortalException {

		return new Part() {
			{
				id = part.getPartId();
				internalPhone = part.getInternalPhone();
				name = part.getName();

				if (part.getAddressId() != 0) {
					address = AddressResourceImpl.toAddress(
						_addressService.getAddress(part.getAddressId()));
				}
			}
		};
	}

	private static final Logger _log = LoggerFactory.getLogger(
		PartResourceImpl.class);

	@Reference
	private AddressService _addressService;

	@Reference
	private PartService _partService;

	@Reference
	private Portal _portal;

	@Reference
	private ServiceContextHelper _serviceContextHelper;

	@Reference
	private UserLocalService _userLocalService;

}