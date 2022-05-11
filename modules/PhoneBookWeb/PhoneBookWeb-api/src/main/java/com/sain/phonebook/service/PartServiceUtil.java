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

import com.sain.phonebook.model.Part;

import java.util.List;

/**
 * Provides the remote service utility for Part. This utility wraps
 * <code>com.sain.phonebook.service.impl.PartServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PartService
 * @generated
 */
public class PartServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.sain.phonebook.service.impl.PartServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Part addPart(
			String name, String internalPhone, long addressId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addPart(
			name, internalPhone, addressId, serviceContext);
	}

	public static Part deletePart(long partId) throws PortalException {
		return getService().deletePart(partId);
	}

	public static List<Part> getAll() {
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

	public static Part getPart(long partId) throws PortalException {
		return getService().getPart(partId);
	}

	public static Part patchPart(
			long id, String name, String internalPhone, long addressId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().patchPart(
			id, name, internalPhone, addressId, serviceContext);
	}

	public static Part updatePart(
			long id, String name, String internalPhone, long addressId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updatePart(
			id, name, internalPhone, addressId, serviceContext);
	}

	public static PartService getService() {
		return _service;
	}

	private static volatile PartService _service;

}