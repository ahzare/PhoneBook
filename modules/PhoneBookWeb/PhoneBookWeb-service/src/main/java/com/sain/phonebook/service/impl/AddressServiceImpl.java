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

package com.sain.phonebook.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;

import com.sain.phonebook.model.Address;
import com.sain.phonebook.service.DepartmentLocalService;
import com.sain.phonebook.service.base.AddressServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=phonebook",
		"json.web.service.context.path=Address"
	},
	service = AopService.class
)
public class AddressServiceImpl extends AddressServiceBaseImpl {
	@Reference(
			policy = ReferencePolicy.DYNAMIC,
			policyOption= ReferencePolicyOption.GREEDY,
			target ="(model.class.name=com.sain.phonebook.model.Address)"
	)
	private volatile ModelResourcePermission<Address>
			_addressModelResourcePermission;

	public Address addAddress(
			final String name, final ServiceContext serviceContext)
		throws PortalException {

		//        ModelResourcePermissionHelper.check(
		//        _addressModelResourcePermission, getPermissionChecker(),
		//        serviceContext.getScopeGroupId(), 0, ActionKeys.ADD_ENTRY);

		return addressLocalService.addAddress(name, serviceContext);
	}

	public Address deleteAddress(final long addressId) throws PortalException {
		Address address = addressLocalService.getAddress(addressId);

				if (address != null) {
					_addressModelResourcePermission.check(
							getPermissionChecker(), addressId,
							ActionKeys.DELETE);
				}

		return addressLocalService.deleteAddress(addressId);
	}

	public Address getAddress(final long addressId) throws PortalException {
		Address address = addressLocalService.getAddress(addressId);

				if (address != null) {
		        _addressModelResourcePermission.check(
		        getPermissionChecker(), address, ActionKeys.VIEW);
		}
		return address;
	}

	public List<Address> getAll() {
		return addressPersistence.findAll();
	}

	public Address patchAddress(
			final long id, final String name,
			final ServiceContext serviceContext)
		throws PortalException {

		        _addressModelResourcePermission.check(
		        getPermissionChecker(),id,
		        ActionKeys.UPDATE);

		return addressLocalService.patchAddress(id, name, serviceContext);
	}

	public Address updateAddress(
			final long id, final String name,
			final ServiceContext serviceContext)
		throws PortalException {

		        _addressModelResourcePermission.check(
		        getPermissionChecker(),id,
		        ActionKeys.UPDATE);

		return addressLocalService.updateAddress(id, name, serviceContext);
	}

}