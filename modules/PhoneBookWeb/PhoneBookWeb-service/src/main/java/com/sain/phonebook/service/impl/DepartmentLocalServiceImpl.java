/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
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

import com.sain.phonebook.exception.DepartmentHasSomePersonsInRelationException;
import com.sain.phonebook.exception.NoSuchDepartmentException;
import com.sain.phonebook.exception.NoSuchRoleException;
import com.sain.phonebook.exception.RoleHasSomePersonsInRelationException;
import com.sain.phonebook.model.Department;
import com.sain.phonebook.model.Role;
import com.sain.phonebook.service.base.DepartmentLocalServiceBaseImpl;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.sain.phonebook.model.Department",
        service = AopService.class
)
public class DepartmentLocalServiceImpl extends DepartmentLocalServiceBaseImpl {

    @Indexable(type = IndexableType.REINDEX)
    @SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
    public Department addDepartment(
            final String name, final ServiceContext serviceContext)
            throws PortalException {

        try {
            return departmentPersistence.findByDepartmentName(name);
        } catch (NoSuchDepartmentException noSuchDepartmentException) {


            Department department = createDepartment(
                    counterLocalService.increment(Department.class.getName()));

            department.setDepartmentId(department.getDepartmentId());
            department.setName(name);

            Date current = DateUtil.newDate();

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
    }

    @Indexable(type = IndexableType.DELETE)
    @Override
    @SystemEvent(type = SystemEventConstants.TYPE_DELETE)
    public Department deleteDepartment(long departmentId)
            throws PortalException {

        Department department = departmentPersistence.findByPrimaryKey(
                departmentId);

        if (department != null) {

            _validateDepartmentForDeletion(department);

			/*resourceLocalService.deleteResource(
					department.getCompanyId(),
					Department.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL,
					department.getDepartmentId());*/

            return deleteDepartment(department);
        }

        return null;
    }

    private void _validateDepartmentForDeletion(Department department)
            throws PortalException {
        int personsCount = personPersistence.countByDepartmentId(
                department.getDepartmentId());
        if (personsCount > 0) {
            throw new DepartmentHasSomePersonsInRelationException(
                    "Department has Some Persons in relation.");
        }
    }

    public Department getDepartment(final long departmentId) {
        return departmentPersistence.fetchByDepartmentId(departmentId);
    }

    @Indexable(type = IndexableType.REINDEX)
    @SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
    public Department patchDepartment(
            final long departmentId, final String name,
            final ServiceContext serviceContext)
            throws PortalException {

        // find our instance using the old id

        Department department = fetchDepartment(departmentId);

        if (department == null) {
            _log.warn(
                    "Failed to find department using id [" + departmentId + "].");

            throw new NoSuchDepartmentException(
                    "Could not find department [" + departmentId + "].");
        }

        boolean changed = false;

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
            Date current = DateUtil.newDate();

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

    @Indexable(type = IndexableType.REINDEX)
    @SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
    public Department updateDepartment(
            final long departmentId, final String name,
            final ServiceContext serviceContext)
            throws PortalException {

        // find our instance using the old id

        Department department = fetchDepartment(departmentId);

        if (department == null) {
            _log.warn(
                    "Failed to find department using id [" + departmentId + "].");

            throw new NoSuchDepartmentException(
                    "Could not find department [" + departmentId + "].");
        }

        // an update means
        // that all fields are going to change to match what we are given.

        Date current = DateUtil.newDate();

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

    private static final Logger _log = LoggerFactory.getLogger(
            DepartmentLocalServiceImpl.class);

}