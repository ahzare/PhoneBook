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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import com.sain.headless.phonebook.dto.v1_0.Role;
import com.sain.headless.phonebook.resource.v1_0.RoleResource;
import com.sain.phonebook.service.RoleService;

import java.util.ArrayList;
import java.util.List;

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
	public void deleteRole(@NotNull Long roleId) throws Exception {
		try {

			// super easy case, just pass through to the service layer.

			_roleService.deleteRole(roleId);
		}
		catch (Exception exception) {
			_log.error(
				"Error deleting role: " + exception.getMessage(), exception);

			throw exception;
		}
	}

	@Override
	public Role getRole(@NotNull Long roleId) throws Exception {
		try {

			// fetch the entity class...

			com.sain.phonebook.model.Role persistedRole = _roleService.getRole(
				roleId);

			return toRole(persistedRole);
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
			String search, Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception {

		System.out.println("getRolesPage");

		/* return SearchUtil.search(
		         null,
		         booleanQuery -> {
		         },
		         filter, Role.class, search, pagination,
		         queryConfig -> queryConfig.setSelectedFieldNames(
		                 Field.ENTRY_CLASS_PK),
		         searchContext -> {
		             searchContext.setCompanyId(contextCompany.getCompanyId());
		             searchContext.setGroupIds(new long[] {contextCompany.getGroupId()});
		         },
		         sorts,
		         document -> _toRole(_persistedRoleService.getPersistedRole(document.get(Field.ENTRY_CLASS_PK))));
*/

		/* return SearchUtil.search(
		       null,
		         booleanQuery -> {
		         },
		         filter, Role.class, search, pagination,
		         queryConfig -> queryConfig.setSelectedFieldNames(
		                 Field.ENTRY_CLASS_PK),
		         searchContext -> {
		             searchContext.setAttribute(Field.NAME, search);
		             searchContext.setCompanyId(contextCompany.getCompanyId());
		             searchContext.setGroupIds(new long[] {contextCompany.getGroupId()});
		         },
		         sorts,
		         document -> _toRole(
		                 _persistedRoleService.getPersistedRole(
		                         GetterUtil.getString(document.get(Field.ENTRY_CLASS_PK)))));*/

		/* List<Role> list = _persistedRoleService.getAll()
		         .stream().map(persistedRole -> {
		             try {
		                 // adding for search
		                 Role role = _toRole(persistedRole);
		                 if (search != null) {
		                     if (role.getName().contains(search)) {
		                         return role;
		                     }
		                 } else {
		                     return role;
		                 }
		                 // return _toRole(persistedRole);
		             } catch (PortalException exception) {
		                 exception.printStackTrace();
		             }
		             return new Role();
		         }).collect(Collectors.toList());*/

		List<com.sain.phonebook.model.Role> persistedRoles =
			_roleService.getAll();
		List<Role> list = new ArrayList<>();

		for (com.sain.phonebook.model.Role persistedRole : persistedRoles) {
			Role role = toRole(persistedRole);

			if (search != null) {
				String roleName = role.getName();

				if (roleName.contains(search)) {
					list.add(role);
				}
			}
			else {
				list.add(role);
			}
		}

		return Page.of(list);
	}

	@Override
	public Role patchRole(@NotNull Long roleId, Role role) throws Exception {
		try {
			com.sain.phonebook.model.Role persistedRole =
				_roleService.patchRole(
					roleId, role.getName(), getServiceContext());

			return toRole(persistedRole);
		}
		catch (Exception exception) {
			_log.error(
				"Error patching role: " + exception.getMessage(), exception);

			throw exception;
		}
	}

	@Override
	public Role postRole(Role role) throws Exception {
		System.out.println("postRole");

		if (_log.isDebugEnabled()) {
			_log.debug("Need to create a new role: %s\n", role.toString());
		}

		_log.warn("hi ali");

		try {
			com.sain.phonebook.model.Role persistedRole = _roleService.addRole(
				role.getName(), getServiceContext());

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
		try {
			com.sain.phonebook.model.Role persistedRole =
				_roleService.updateRole(
					roleId, role.getName(), getServiceContext());

			return toRole(persistedRole);
		}
		catch (Exception exception) {
			_log.error(
				"Error putting role: " + exception.getMessage(), exception);

			throw exception;
		}
	}

	/*private RoleEntityModel _roleEntityModel = new RoleEntityModel();

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap)
			throws Exception {
		return _roleEntityModel;
	}*/

	protected static Role toRole(com.sain.phonebook.model.Role role)
		throws PortalException {

		return new Role() {
			{
				id = role.getRoleId();
				name = role.getName();
			}
		};
		/*return new Role() {{
			creator = CreatorUtil.toCreator(_portal,
					_userLocalService.getUser(pv.getUserId()));
			articleId = pv.getArticleId();
			group = pv.getGroupName();
			description = pv.getDescription();
			id = pv.getSurrogateId();
			name = pv.getName();
			type = _toRoleType(pv.getType());
			attributes = ListUtil.toArray(pv.getAttributes(), VALUE_ACCESSOR);
			chemicalNames = ListUtil.toArray(pv.getChemicalNames(), VALUE_ACCESSOR);
			properties = ListUtil.toArray(pv.getProperties(), VALUE_ACCESSOR);
			risks = ListUtil.toArray(pv.getRisks(), VALUE_ACCESSOR);
			symptoms = ListUtil.toArray(pv.getSymptoms(), VALUE_ACCESSOR);
		}};*/
	}

	protected ServiceContext getServiceContext() throws PortalException {
		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(contextCompany.getCompanyId());

		// need the current user in the service context.
		// will get easier in newer version of the REST Builder plugin...
		// but for now, this is the only game in town.

		serviceContext.setUserId(PrincipalThreadLocal.getUserId());

		return serviceContext;
	}

	private static final Logger _log = LoggerFactory.getLogger(
		RoleResourceImpl.class);

	@Reference
	private Portal _portal;

	@Reference
	private RoleService _roleService;

	@Reference
	private UserLocalService _userLocalService;

}