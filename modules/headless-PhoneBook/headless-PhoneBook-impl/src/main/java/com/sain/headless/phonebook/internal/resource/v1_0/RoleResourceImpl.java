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

package com.sain.headless.phonebook.internal.resource.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;

import com.sain.headless.phonebook.dto.v1_0.Role;
import com.sain.headless.phonebook.resource.v1_0.RoleResource;
import com.sain.headless.phonebook.util.ServiceContextHelper;
import com.sain.phonebook.service.RoleService;

import javax.validation.constraints.NotNull;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Amir
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/role.properties",
	scope = ServiceScope.PROTOTYPE, service = RoleResource.class
)
public class RoleResourceImpl extends BaseRoleResourceImpl {

	@Override
	public Role deleteRoleApi(Long siteId, Long roleId) throws Exception {
		return toRole(_roleService.deleteRole(roleId));
	}

	@Override
	public Role getRole(Long roleId) throws Exception {
		try {

			// fetch the entity class...

			com.sain.phonebook.model.Role persistedRole = _roleService.getRole(
				roleId);

			if (persistedRole != null) {
				return toRole(persistedRole);
			}

			return null;
		}
		catch (Exception exception) {
			_log.error(
				"Error getting role [" + roleId + "]: " +
					exception.getMessage(),
				exception);

			throw exception;
		}
	}

	@Override
	public Page<Role> getRolesPage(
			Long siteId, String search, Filter filter, Pagination pagination,
			Sort[] sorts)
		throws Exception {

		System.out.println("getRolesPage");

		Page<Role> rolePage = SearchUtil.search(
			booleanQuery -> booleanQuery.getPreBooleanFilter(), filter,
			com.sain.phonebook.model.Role.class, search, pagination,
			queryConfig -> queryConfig.setSelectedFieldNames(
				Field.ENTRY_CLASS_PK),
			new UnsafeConsumer() {

				public void accept(Object object) throws Exception {
					SearchContext searchContext = (SearchContext)object;

					searchContext.setCompanyId(contextCompany.getCompanyId());
				}

			},
			document -> toRole(
				_roleService.getRole(
					GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)))),
			sorts);

		System.out.println("role page = " + rolePage);

		return rolePage;
	}

	@Override
	public Role patchRole(@NotNull Long roleId, Role role) throws Exception {
		com.sain.phonebook.model.Role persistedRole1 = _roleService.getRole(
			roleId);

		if (persistedRole1 != null) {
			try {
				com.sain.phonebook.model.Role persistedRole =
					_roleService.patchRole(
						roleId, role.getName(),
						_serviceContextHelper.getServiceContext(
							persistedRole1.getGroupId()));

				return toRole(persistedRole);
			}
			catch (Exception exception) {
				_log.error(
					"Error patching role: " + exception.getMessage(),
					exception);

				throw exception;
			}
		}
		else {
			return null;
		}
	}

	@Override
	public Role postRole(Long siteId, Role role) throws Exception {
		System.out.println("postRole");

		if (_log.isDebugEnabled()) {
			_log.debug("Need to create a new role: %s\n", role.toString());
		}

		try {
			com.sain.phonebook.model.Role persistedRole = _roleService.addRole(
				role.getName(),
				_serviceContextHelper.getServiceContext(siteId));

			return toRole(persistedRole);
		}
		catch (Exception exception) {
			_log.error(
				"Error creating role: " + exception.getMessage(), exception);

			throw exception;
		}
	}

	@Override
	public Role putRole(@NotNull Long roleId, Role role) throws Exception {
		com.sain.phonebook.model.Role persistedRole1 = _roleService.getRole(
			roleId);

		if (persistedRole1 != null) {
			try {
				com.sain.phonebook.model.Role persistedRole =
					_roleService.updateRole(
						roleId, role.getName(),
						_serviceContextHelper.getServiceContext(
							persistedRole1.getGroupId()));

				return toRole(persistedRole);
			}
			catch (Exception exception) {
				_log.error(
					"Error putting role: " + exception.getMessage(), exception);

				throw exception;
			}
		}
		else {
			return null;
		}
	}

	protected static Role toRole(com.sain.phonebook.model.Role role)
		throws PortalException {

		return new Role() {
			{
				id = role.getRoleId();
				name = role.getName();
			}
		};
	}

	private static final Logger _log = LoggerFactory.getLogger(
		RoleResourceImpl.class);

	@Reference
	private Portal _portal;

	@Reference
	private RoleService _roleService;

	@Reference
	private ServiceContextHelper _serviceContextHelper;

	@Reference
	private UserLocalService _userLocalService;

}