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
 * Provides a wrapper for {@link RoleService}.
 *
 * @author Brian Wing Shun Chan
 * @see RoleService
 * @generated
 */
public class RoleServiceWrapper
	implements RoleService, ServiceWrapper<RoleService> {

	public RoleServiceWrapper(RoleService roleService) {
		_roleService = roleService;
	}

	@Override
	public com.sain.phonebook.model.Role addRole(
			String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleService.addRole(name, serviceContext);
	}

	@Override
	public void deleteRole(long roleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_roleService.deleteRole(roleId);
	}

	@Override
	public java.util.List<com.sain.phonebook.model.Role> getAll() {
		return _roleService.getAll();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _roleService.getOSGiServiceIdentifier();
	}

	@Override
	public com.sain.phonebook.model.Role getRole(long roleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleService.getRole(roleId);
	}

	@Override
	public com.sain.phonebook.model.Role patchRole(
			long id, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleService.patchRole(id, name, serviceContext);
	}

	@Override
	public com.sain.phonebook.model.Role updateRole(
			long id, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleService.updateRole(id, name, serviceContext);
	}

	@Override
	public RoleService getWrappedService() {
		return _roleService;
	}

	@Override
	public void setWrappedService(RoleService roleService) {
		_roleService = roleService;
	}

	private RoleService _roleService;

}