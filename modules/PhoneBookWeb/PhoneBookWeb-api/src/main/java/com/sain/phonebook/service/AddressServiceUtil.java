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

package com.sain.phonebook.service;

import com.liferay.portal.kernel.exception.PortalException;

import com.sain.phonebook.model.Address;

import java.util.List;

/**
 * Provides the remote service utility for Address. This utility wraps
 * <code>com.sain.phonebook.service.impl.AddressServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AddressService
 * @generated
 */
public class AddressServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.sain.phonebook.service.impl.AddressServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Address addAddress(
			String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addAddress(name, serviceContext);
	}

	public static Address deleteAddress(long addressId) throws PortalException {
		return getService().deleteAddress(addressId);
	}

	public static Address getAddress(long addressId) throws PortalException {
		return getService().getAddress(addressId);
	}

	public static List<Address> getAll() {
		return getService().getAll();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Address patchAddress(
			long id, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().patchAddress(id, name, serviceContext);
	}

	public static Address updateAddress(
			long id, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateAddress(id, name, serviceContext);
	}

	public static AddressService getService() {
		return _service;
	}

	private static volatile AddressService _service;

}