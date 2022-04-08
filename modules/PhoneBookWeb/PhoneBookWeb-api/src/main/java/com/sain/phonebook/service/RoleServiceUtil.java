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

import com.sain.phonebook.model.Role;

import java.util.List;

/**
 * Provides the remote service utility for Role. This utility wraps
 * <code>com.sain.phonebook.service.impl.RoleServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see RoleService
 * @generated
 */
public class RoleServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.sain.phonebook.service.impl.RoleServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Role addRole(
			String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addRole(name, serviceContext);
	}

	public static void deleteRole(long roleId) throws PortalException {
		getService().deleteRole(roleId);
	}

	public static List<Role> getAll() {
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

	public static Role getRole(long roleId) throws PortalException {
		return getService().getRole(roleId);
	}

	public static Role patchRole(
			long id, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().patchRole(id, name, serviceContext);
	}

	public static Role updateRole(
			long id, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateRole(id, name, serviceContext);
	}

	public static RoleService getService() {
		return _service;
	}

	private static volatile RoleService _service;

}