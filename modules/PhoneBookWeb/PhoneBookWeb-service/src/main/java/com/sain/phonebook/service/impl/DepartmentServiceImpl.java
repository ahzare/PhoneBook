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
import com.liferay.portal.kernel.service.ServiceContext;

import com.sain.phonebook.model.Department;
import com.sain.phonebook.service.base.DepartmentServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=phonebook",
		"json.web.service.context.path=Department"
	},
	service = AopService.class
)
public class DepartmentServiceImpl extends DepartmentServiceBaseImpl {

	// todo: for permissions

	/*	@Reference(
				policy = ReferencePolicy.DYNAMIC,
				policyOption= ReferencePolicyOption.GREEDY,
				target ="(model.class.name=com.sain.phonebook.model.Department)"
		)
		private volatile ModelResourcePermission<Department>
				_departmentModelResourcePermission;*/

	public Department addDepartment(
			final String name, final ServiceContext serviceContext)
		throws PortalException {

		//        ModelResourcePermissionHelper.check(
		//        _departmentModelResourcePermission, getPermissionChecker(),
		//        serviceContext.getScopeGroupId(), 0, ActionKeys.ADD_ENTRY);

		return departmentLocalService.addDepartment(name, serviceContext);
	}

	public void deleteDepartment(final long departmentId)
		throws PortalException {

		//        _departmentModelResourcePermission.check(
		//        getPermissionChecker(),
		//        departmentLocalService.getDepartment(departmentId),
		//        ActionKeys.DELETE);

		departmentLocalService.deleteDepartment(departmentId);
	}

	public List<Department> getAll() {
		return departmentPersistence.findAll();
	}

	public Department getDepartment(final long departmentId)
		throws PortalException {

		Department department = departmentLocalService.getDepartment(
			departmentId);

		//        _departmentModelResourcePermission.check(
		//        getPermissionChecker(), department, ActionKeys.VIEW);

		return department;
	}

	public Department patchDepartment(
			final long id, final String name,
			final ServiceContext serviceContext)
		throws PortalException {

		//        _departmentModelResourcePermission.check(
		//        getPermissionChecker(),
		//        departmentLocalService.getDepartment(oldId),
		//        ActionKeys.UPDATE);

		return departmentLocalService.patchDepartment(id, name, serviceContext);
	}

	public Department updateDepartment(
			final long id, final String name,
			final ServiceContext serviceContext)
		throws PortalException {

		//        _departmentModelResourcePermission.check(
		//        getPermissionChecker(),
		//        departmentLocalService.getDepartment(oldId),
		//        ActionKeys.UPDATE);

		return departmentLocalService.updateDepartment(
			id, name, serviceContext);
	}

}