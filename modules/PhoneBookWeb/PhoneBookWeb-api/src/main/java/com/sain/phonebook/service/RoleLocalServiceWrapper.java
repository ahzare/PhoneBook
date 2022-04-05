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
 * Provides a wrapper for {@link RoleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RoleLocalService
 * @generated
 */
public class RoleLocalServiceWrapper
	implements RoleLocalService, ServiceWrapper<RoleLocalService> {

	public RoleLocalServiceWrapper(RoleLocalService roleLocalService) {
		_roleLocalService = roleLocalService;
	}

	@Override
	public com.sain.phonebook.model.Role addRole(
			long roleId, String name, long departmentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleLocalService.addRole(
			roleId, name, departmentId, serviceContext);
	}

	/**
	 * Adds the role to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param role the role
	 * @return the role that was added
	 */
	@Override
	public com.sain.phonebook.model.Role addRole(
		com.sain.phonebook.model.Role role) {

		return _roleLocalService.addRole(role);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new role with the primary key. Does not add the role to the database.
	 *
	 * @param roleId the primary key for the new role
	 * @return the new role
	 */
	@Override
	public com.sain.phonebook.model.Role createRole(long roleId) {
		return _roleLocalService.createRole(roleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleId the primary key of the role
	 * @return the role that was removed
	 * @throws PortalException if a role with the primary key could not be found
	 */
	@Override
	public com.sain.phonebook.model.Role deleteRole(long roleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleLocalService.deleteRole(roleId);
	}

	/**
	 * Deletes the role from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param role the role
	 * @return the role that was removed
	 */
	@Override
	public com.sain.phonebook.model.Role deleteRole(
		com.sain.phonebook.model.Role role) {

		return _roleLocalService.deleteRole(role);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _roleLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _roleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sain.phonebook.model.impl.RoleModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _roleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sain.phonebook.model.impl.RoleModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _roleLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _roleLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _roleLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.sain.phonebook.model.Role fetchRole(long roleId) {
		return _roleLocalService.fetchRole(roleId);
	}

	/**
	 * Returns the role matching the UUID and group.
	 *
	 * @param uuid the role's UUID
	 * @param groupId the primary key of the group
	 * @return the matching role, or <code>null</code> if a matching role could not be found
	 */
	@Override
	public com.sain.phonebook.model.Role fetchRoleByUuidAndGroupId(
		String uuid, long groupId) {

		return _roleLocalService.fetchRoleByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _roleLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _roleLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _roleLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _roleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the role with the primary key.
	 *
	 * @param roleId the primary key of the role
	 * @return the role
	 * @throws PortalException if a role with the primary key could not be found
	 */
	@Override
	public com.sain.phonebook.model.Role getRole(long roleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleLocalService.getRole(roleId);
	}

	/**
	 * Returns the role matching the UUID and group.
	 *
	 * @param uuid the role's UUID
	 * @param groupId the primary key of the group
	 * @return the matching role
	 * @throws PortalException if a matching role could not be found
	 */
	@Override
	public com.sain.phonebook.model.Role getRoleByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleLocalService.getRoleByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sain.phonebook.model.impl.RoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of roles
	 * @param end the upper bound of the range of roles (not inclusive)
	 * @return the range of roles
	 */
	@Override
	public java.util.List<com.sain.phonebook.model.Role> getRoles(
		int start, int end) {

		return _roleLocalService.getRoles(start, end);
	}

	/**
	 * Returns all the roles matching the UUID and company.
	 *
	 * @param uuid the UUID of the roles
	 * @param companyId the primary key of the company
	 * @return the matching roles, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.sain.phonebook.model.Role>
		getRolesByUuidAndCompanyId(String uuid, long companyId) {

		return _roleLocalService.getRolesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of roles matching the UUID and company.
	 *
	 * @param uuid the UUID of the roles
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of roles
	 * @param end the upper bound of the range of roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching roles, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.sain.phonebook.model.Role>
		getRolesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sain.phonebook.model.Role> orderByComparator) {

		return _roleLocalService.getRolesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of roles.
	 *
	 * @return the number of roles
	 */
	@Override
	public int getRolesCount() {
		return _roleLocalService.getRolesCount();
	}

	@Override
	public com.sain.phonebook.model.Role patchPersistedVitamin(
			long roleId, String name, long departmentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleLocalService.patchPersistedVitamin(
			roleId, name, departmentId, serviceContext);
	}

	@Override
	public com.sain.phonebook.model.Role updateRole(
			long roleId, String name, long departmentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleLocalService.updateRole(
			roleId, name, departmentId, serviceContext);
	}

	/**
	 * Updates the role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param role the role
	 * @return the role that was updated
	 */
	@Override
	public com.sain.phonebook.model.Role updateRole(
		com.sain.phonebook.model.Role role) {

		return _roleLocalService.updateRole(role);
	}

	@Override
	public RoleLocalService getWrappedService() {
		return _roleLocalService;
	}

	@Override
	public void setWrappedService(RoleLocalService roleLocalService) {
		_roleLocalService = roleLocalService;
	}

	private RoleLocalService _roleLocalService;

}