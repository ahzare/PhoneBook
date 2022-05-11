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

import com.sain.phonebook.exception.NoSuchRoleException;
import com.sain.phonebook.model.Role;
import com.sain.phonebook.service.base.RoleLocalServiceBaseImpl;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.sain.phonebook.model.Role",
	service = AopService.class
)
public class RoleLocalServiceImpl extends RoleLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public Role addRole(final String name, final ServiceContext serviceContext)
		throws PortalException {

		Role role = createRole(
			counterLocalService.increment(Role.class.getName()));

		role.setRoleId(role.getRoleId());
		role.setName(name);

		//        role.setDepartmentId(departmentId);

		Date current = DateUtil.newDate();

		role.setCompanyId(serviceContext.getCompanyId());
		role.setCreateDate(serviceContext.getCreateDate(current));
		role.setGroupId(serviceContext.getScopeGroupId());
		role.setModifiedDate(serviceContext.getModifiedDate(current));
		role.setUserId(serviceContext.getUserId());

		User user = userLocalService.fetchUser(serviceContext.getUserId());

		if (user != null) {
			role.setUserName(user.getFullName());
			role.setUserUuid(user.getUserUuid());
		}

		role = addRole(role);

		resourceLocalService.addResources(
			serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
			serviceContext.getUserId(), Role.class.getName(), role.getRoleId(),
			false, serviceContext.isAddGroupPermissions(),
			serviceContext.isAddGuestPermissions());

		return role;
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	public Role deleteRole(long roleId) throws PortalException {
		Role role = rolePersistence.findByPrimaryKey(roleId);

		if (role != null) {

			/*resourceLocalService.deleteResource(
					role.getCompanyId(),
					Role.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL,
					role.getRoleId());*/

			return deleteRole(role);
		}

		return null;
	}

	public Role getRole(final long roleId) {
		return rolePersistence.fetchByRoleId(roleId);
	}

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public Role patchRole(
			final long roleId, final String name,
			final ServiceContext serviceContext)
		throws PortalException {

		// find our instance using the old id

		Role role = fetchRole(roleId);

		if (role == null) {
			_log.warn("Failed to find role using id [" + roleId + "].");

			throw new NoSuchRoleException(
				"Could not find role [" + roleId + "].");
		}

		boolean changed = false;

		// a patch means that only provided fields are going to change
		// to match what we are given.

		if (name != null) {
			role.setName(name);
			changed = true;
		}
		/*if (departmentId != role.getDepartmentId()) {
		    role.setDepartmentId(departmentId);
		    changed = true;
		}*/
		if (roleId != role.getRoleId()) {
			role.setRoleId(roleId);
			changed = true;
		}

		if (changed) {
			Date current = DateUtil.newDate();

			role.setUserId(serviceContext.getUserId());
			role.setModifiedDate(serviceContext.getModifiedDate(current));

			User user = userLocalService.fetchUser(serviceContext.getUserId());

			if (user != null) {
				role.setUserName(user.getFullName());
				role.setUserUuid(user.getUserUuid());
			}

			role = updateRole(role);
		}

		// good to go

		return role;
	}

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public Role updateRole(
			final long roleId, final String name,
			final ServiceContext serviceContext)
		throws PortalException {

		// find our instance using the old id

		Role role = fetchRole(roleId);

		if (role == null) {
			_log.warn("Failed to find role using id [" + roleId + "].");

			throw new NoSuchRoleException(
				"Could not find role [" + roleId + "].");
		}

		// an update means that
		// all fields are going to change to match what we are given.

		Date current = DateUtil.newDate();

		role.setRoleId(roleId);
		role.setName(name);

		//        role.setDepartmentId(departmentId);

		role.setModifiedDate(serviceContext.getModifiedDate(current));

		role.setUserId(serviceContext.getUserId());

		User user = userLocalService.fetchUser(serviceContext.getUserId());

		if (user != null) {
			role.setUserName(user.getFullName());
			role.setUserUuid(user.getUserUuid());
		}

		role = updateRole(role);

		// good to go

		return role;
	}

	private static final Logger _log = LoggerFactory.getLogger(
		RoleLocalServiceImpl.class);

}