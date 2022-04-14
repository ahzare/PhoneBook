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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AddressService}.
 *
 * @author Brian Wing Shun Chan
 * @see AddressService
 * @generated
 */
public class AddressServiceWrapper
	implements AddressService, ServiceWrapper<AddressService> {

	public AddressServiceWrapper(AddressService addressService) {
		_addressService = addressService;
	}

	@Override
	public com.sain.phonebook.model.Address addAddress(
			String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressService.addAddress(name, serviceContext);
	}

	@Override
	public void deleteAddress(long addressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_addressService.deleteAddress(addressId);
	}

	@Override
	public com.sain.phonebook.model.Address getAddress(long addressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressService.getAddress(addressId);
	}

	@Override
	public java.util.List<com.sain.phonebook.model.Address> getAll() {
		return _addressService.getAll();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _addressService.getOSGiServiceIdentifier();
	}

	@Override
	public com.sain.phonebook.model.Address patchAddress(
			long id, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressService.patchAddress(id, name, serviceContext);
	}

	@Override
	public com.sain.phonebook.model.Address updateAddress(
			long id, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressService.updateAddress(id, name, serviceContext);
	}

	@Override
	public AddressService getWrappedService() {
		return _addressService;
	}

	@Override
	public void setWrappedService(AddressService addressService) {
		_addressService = addressService;
	}

	private AddressService _addressService;

}