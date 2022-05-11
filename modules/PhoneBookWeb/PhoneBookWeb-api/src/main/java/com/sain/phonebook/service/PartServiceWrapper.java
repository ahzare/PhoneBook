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
 * Provides a wrapper for {@link PartService}.
 *
 * @author Brian Wing Shun Chan
 * @see PartService
 * @generated
 */
public class PartServiceWrapper
	implements PartService, ServiceWrapper<PartService> {

	public PartServiceWrapper(PartService partService) {
		_partService = partService;
	}

	@Override
	public com.sain.phonebook.model.Part addPart(
			String name, String internalPhone, long addressId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _partService.addPart(
			name, internalPhone, addressId, serviceContext);
	}

	@Override
	public com.sain.phonebook.model.Part deletePart(long partId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _partService.deletePart(partId);
	}

	@Override
	public java.util.List<com.sain.phonebook.model.Part> getAll() {
		return _partService.getAll();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _partService.getOSGiServiceIdentifier();
	}

	@Override
	public com.sain.phonebook.model.Part getPart(long partId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _partService.getPart(partId);
	}

	@Override
	public com.sain.phonebook.model.Part patchPart(
			long id, String name, String internalPhone, long addressId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _partService.patchPart(
			id, name, internalPhone, addressId, serviceContext);
	}

	@Override
	public com.sain.phonebook.model.Part updatePart(
			long id, String name, String internalPhone, long addressId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _partService.updatePart(
			id, name, internalPhone, addressId, serviceContext);
	}

	@Override
	public PartService getWrappedService() {
		return _partService;
	}

	@Override
	public void setWrappedService(PartService partService) {
		_partService = partService;
	}

	private PartService _partService;

}