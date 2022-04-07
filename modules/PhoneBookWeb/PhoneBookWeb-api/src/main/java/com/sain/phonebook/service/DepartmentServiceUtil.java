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

import com.sain.phonebook.model.Department;

import java.util.List;

/**
 * Provides the remote service utility for Department. This utility wraps
 * <code>com.sain.phonebook.service.impl.DepartmentServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentService
 * @generated
 */
public class DepartmentServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.sain.phonebook.service.impl.DepartmentServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Department addDepartment(
			String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addDepartment(name, serviceContext);
	}

	public static void deleteDepartment(long departmentId)
		throws PortalException {

		getService().deleteDepartment(departmentId);
	}

	public static List<Department> getAll() {
		return getService().getAll();
	}

	public static Department getDepartment(long departmentId)
		throws PortalException {

		return getService().getDepartment(departmentId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Department patchDepartment(
			long id, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().patchDepartment(id, name, serviceContext);
	}

	public static Department updateDepartment(
			long id, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateDepartment(id, name, serviceContext);
	}

	public static DepartmentService getService() {
		return _service;
	}

	private static volatile DepartmentService _service;

}