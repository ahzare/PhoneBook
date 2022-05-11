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
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.util.DateUtil;

import com.sain.phonebook.exception.NoSuchAddressException;
import com.sain.phonebook.model.Address;
import com.sain.phonebook.model.Person;
import com.sain.phonebook.service.base.AddressLocalServiceBaseImpl;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.sain.phonebook.model.Address",
	service = AopService.class
)
public class AddressLocalServiceImpl extends AddressLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public Address addAddress(
			final String name, final ServiceContext serviceContext)
		throws PortalException {

		Address address = createAddress(
			counterLocalService.increment(Address.class.getName()));

		address.setAddressId(address.getAddressId());
		address.setName(name);

		//        address.setDepartmentId(departmentId);

		Date current = DateUtil.newDate();

		address.setCompanyId(serviceContext.getCompanyId());
		address.setCreateDate(serviceContext.getCreateDate(current));
		address.setGroupId(serviceContext.getScopeGroupId());
		address.setModifiedDate(serviceContext.getModifiedDate(current));
		address.setUserId(serviceContext.getUserId());

		User user = userLocalService.fetchUser(serviceContext.getUserId());

		if (user != null) {
			address.setUserName(user.getFullName());
			address.setUserUuid(user.getUserUuid());
		}

		address = addAddress(address);

		/*resourceLocalService.addResources(
				serviceContext.getCompanyId(),
				serviceContext.getScopeGroupId(),
				serviceContext.getUserId(),
				Address.class.getName(),
				address.getAddressId(),
				false,
				serviceContext.isAddGroupPermissions(),
				serviceContext.isAddGuestPermissions());*/

		return address;
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	public Address deleteAddress(long addressId) throws PortalException {
		Address address = addressPersistence.findByPrimaryKey(addressId);

		if (address != null) {

			/*resourceLocalService.deleteResource(
					address.getCompanyId(),
					Address.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL,
					address.getAddressId());*/

			return deleteAddress(address);
		}

		return null;
	}

	public Address getAddress(final long addressId) {
		return addressPersistence.fetchByAddressId(addressId);
	}

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public Address patchAddress(
			final long addressId, final String name,
			final ServiceContext serviceContext)
		throws PortalException {

		// find our instance using the old id

		Address address = fetchAddress(addressId);

		if (address == null) {
			_log.warn("Failed to find address using id [" + addressId + "].");

			throw new NoSuchAddressException(
				"Could not find address [" + addressId + "].");
		}

		boolean changed = false;

		// a patch means that only provided fields are going to change
		// to match what we are given.

		if (name != null) {
			address.setName(name);
			changed = true;
		}
		/*if (departmentId != address.getDepartmentId()) {
		    address.setDepartmentId(departmentId);
		    changed = true;
		}*/
		if (addressId != address.getAddressId()) {
			address.setAddressId(addressId);
			changed = true;
		}

		if (changed) {
			Date current = DateUtil.newDate();

			address.setUserId(serviceContext.getUserId());
			address.setModifiedDate(serviceContext.getModifiedDate(current));

			User user = userLocalService.fetchUser(serviceContext.getUserId());

			if (user != null) {
				address.setUserName(user.getFullName());
				address.setUserUuid(user.getUserUuid());
			}

			address = updateAddress(address);
		}

		// good to go

		return address;
	}

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public Address updateAddress(
			final long addressId, final String name,
			final ServiceContext serviceContext)
		throws PortalException {

		// find our instance using the old id

		Address address = fetchAddress(addressId);

		if (address == null) {
			_log.warn("Failed to find address using id [" + addressId + "].");

			throw new NoSuchAddressException(
				"Could not find address [" + addressId + "].");
		}

		// an update means
		// that all fields are going to change to match what we are given.

		Date current = DateUtil.newDate();

		address.setAddressId(addressId);
		address.setName(name);

		//        address.setDepartmentId(departmentId);

		address.setModifiedDate(serviceContext.getModifiedDate(current));

		address.setUserId(serviceContext.getUserId());

		User user = userLocalService.fetchUser(serviceContext.getUserId());

		if (user != null) {
			address.setUserName(user.getFullName());
			address.setUserUuid(user.getUserUuid());
		}

		address = updateAddress(address);

		// good to go

		return address;
	}

	private static final Logger _log = LoggerFactory.getLogger(
		AddressLocalServiceImpl.class);

}