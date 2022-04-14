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
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import com.sain.phonebook.model.Role;
import com.sain.phonebook.service.base.RoleServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = {
                "json.web.service.context.name=phonebook",
                "json.web.service.context.path=Role"
        },
        service = AopService.class
)
public class RoleServiceImpl extends RoleServiceBaseImpl {
    // todo: for permissions
	@Reference(
			policy = ReferencePolicy.DYNAMIC,
			policyOption= ReferencePolicyOption.GREEDY,
			target ="(model.class.name=com.sain.phonebook.model.Role)"
	)
	private volatile ModelResourcePermission<Role>
			_roleModelResourcePermission;

    public Role getRole(final long roleId) throws PortalException {
        Role role = roleLocalService.getRole(roleId);
//        _roleModelResourcePermission.check(getPermissionChecker(), role, ActionKeys.VIEW);
        return role;
    }

    public Role addRole( final String name, final ServiceContext serviceContext) throws PortalException {
//        ModelResourcePermissionHelper.check(_roleModelResourcePermission, getPermissionChecker(),
//        serviceContext.getScopeGroupId(), 0, ActionKeys.ADD_ENTRY);
        return roleLocalService.addRole( name, serviceContext);
    }

    public Role updateRole(final long id, final String name, final ServiceContext serviceContext) throws PortalException {
//        _roleModelResourcePermission.check(getPermissionChecker(), roleLocalService.getRole(oldId), ActionKeys.UPDATE);
        return roleLocalService.updateRole(id, name, serviceContext);
    }

    public Role patchRole(final long id, final String name, final ServiceContext serviceContext)
            throws PortalException {
//        _roleModelResourcePermission.check(getPermissionChecker(), roleLocalService.getRole(oldId), ActionKeys.UPDATE);
        return roleLocalService.patchRole(id, name,  serviceContext);
    }

    public void deleteRole(final long roleId)
            throws PortalException {
//        _roleModelResourcePermission.check(getPermissionChecker(), roleLocalService.getRole(roleId), ActionKeys.DELETE);
        roleLocalService.deleteRole(roleId);
    }

    public List<Role> getAll() {
        return rolePersistence.findAll();
    }

    private static final Logger _log =
            LoggerFactory.getLogger(RoleServiceImpl.class);

}