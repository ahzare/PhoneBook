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
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.sain.phonebook.exception.NoSuchDepartmentException;
import com.sain.phonebook.model.Department;
import com.sain.phonebook.service.base.DepartmentLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import static com.liferay.portal.kernel.util.DateUtil.newDate;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.sain.phonebook.model.Department",
	service = AopService.class
)
public class DepartmentLocalServiceImpl extends DepartmentLocalServiceBaseImpl {

	public Department getDepartment(final long departmentId){
		return departmentPersistence.fetchByDepartmentId(departmentId);
	}

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public Department addDepartment(
						final String name,
						final ServiceContext serviceContext)
			throws PortalException {
		Department department = createDepartment(counterLocalService.increment(Department.class.getName()));
		department.setDepartmentId(department.getDepartmentId());
		department.setName(name);

		Date current = newDate();
		department.setCompanyId(serviceContext.getCompanyId());
		department.setCreateDate(serviceContext.getCreateDate(current));
		department.setGroupId(serviceContext.getScopeGroupId());
		department.setModifiedDate(serviceContext.getModifiedDate(current));
		department.setUserId(serviceContext.getUserId());

		User user = userLocalService.fetchUser(serviceContext.getUserId());
		if (user != null) {
			department.setUserName(user.getFullName());
			department.setUserUuid(user.getUserUuid());
		}
		department = addDepartment(department);

		System.out.println("dep = " + department);
		/*resourceLocalService.addResources(
				serviceContext.getCompanyId(),
				serviceContext.getScopeGroupId(),
				serviceContext.getUserId(),
				Department.class.getName(),
				department.getDepartmentId(),
				false,
				serviceContext.isAddGroupPermissions(),
				serviceContext.isAddGuestPermissions());*/

		System.out.println(department);
		return department;
	}

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public Department updateDepartment(final long departmentId,
						   final String name,
						   final ServiceContext serviceContext)
			throws PortalException {
// find our instance using the old id
		Department department = fetchDepartment(departmentId);
		if (department == null) {
			_log.warn("Failed to find department using id [" + departmentId + "].");
			throw new NoSuchDepartmentException("Could not find department [" + departmentId + "].");
		}

// an update means that all fields are going to change to match what we are given.
		Date current = newDate();
		department.setDepartmentId(departmentId);
		department.setName(name);

		department.setModifiedDate(serviceContext.getModifiedDate(current));

		department.setUserId(serviceContext.getUserId());
		User user = userLocalService.fetchUser(serviceContext.getUserId());
		if (user != null) {
			department.setUserName(user.getFullName());
			department.setUserUuid(user.getUserUuid());
		}
		department = updateDepartment(department);

// good to go
		return department;
	}

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public Department patchDepartment(final long departmentId,
									  final String name,
									  final ServiceContext serviceContext)
			throws PortalException {
// find our instance using the old id
		Department department = fetchDepartment(departmentId);
		boolean changed = false;
		if (department == null) {
			_log.warn("Failed to find department using id [" + departmentId + "].");
			throw new NoSuchDepartmentException("Could not find department [" + departmentId + "].");
		}

// a patch means that only provided fields are going to change
// to match what we are given.
		if (name != null) {
			department.setName(name);
			changed = true;
		}
		if (departmentId != department.getDepartmentId()) {
			department.setDepartmentId(departmentId);
			changed = true;
		}

		if (changed) {
			Date current = newDate();
			department.setUserId(serviceContext.getUserId());
			department.setModifiedDate(serviceContext.getModifiedDate(current));
			User user = userLocalService.fetchUser(serviceContext.getUserId());
			if (user != null) {
				department.setUserName(user.getFullName());
				department.setUserUuid(user.getUserUuid());
			}
			department = updateDepartment(department);
		}
// good to go
		return department;
	}

	@Indexable(type =IndexableType.DELETE)
	@Override
	public Department deleteDepartment(long departmentId)
			throws PortalException{
		Department department =fetchDepartment(departmentId);
		if(department !=null){
			return deleteDepartment(department);
		}
		return null;
	}
	@Indexable(type = IndexableType.DELETE)
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	@Override
	public Department deleteDepartment(Department department){
		/*try{
			resourceLocalService.deleteResource(
					department.getCompanyId(),
					Department.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL,
					department.getDepartmentId());
		}catch(PortalException e){
			_log.warn("Error deleting persisted department permissions: "+
					e.getMessage(), e);
		}*/

//        todo: delete department departments and departments

// call the super action method to try the delete.
		return super.deleteDepartment(department);
//		return departmentPersistence.remove(department);
	}

	private static final Logger _log =
			LoggerFactory.getLogger(DepartmentLocalServiceImpl.class);
}