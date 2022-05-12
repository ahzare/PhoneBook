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

package com.sain.phonebook.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sain.phonebook.model.Role;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the role service. This utility wraps <code>com.sain.phonebook.service.persistence.impl.RolePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RolePersistence
 * @generated
 */
public class RoleUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Role role) {
		getPersistence().clearCache(role);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Role> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Role> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Role> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Role> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Role> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Role update(Role role) {
		return getPersistence().update(role);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Role update(Role role, ServiceContext serviceContext) {
		return getPersistence().update(role, serviceContext);
	}

	/**
	 * Returns all the roles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching roles
	 */
	public static List<Role> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the roles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of roles
	 * @param end the upper bound of the range of roles (not inclusive)
	 * @return the range of matching roles
	 */
	public static List<Role> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the roles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of roles
	 * @param end the upper bound of the range of roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching roles
	 */
	public static List<Role> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Role> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the roles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of roles
	 * @param end the upper bound of the range of roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching roles
	 */
	public static List<Role> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Role> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first role in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role
	 * @throws NoSuchRoleException if a matching role could not be found
	 */
	public static Role findByUuid_First(
			String uuid, OrderByComparator<Role> orderByComparator)
		throws com.sain.phonebook.exception.NoSuchRoleException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first role in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role, or <code>null</code> if a matching role could not be found
	 */
	public static Role fetchByUuid_First(
		String uuid, OrderByComparator<Role> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last role in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role
	 * @throws NoSuchRoleException if a matching role could not be found
	 */
	public static Role findByUuid_Last(
			String uuid, OrderByComparator<Role> orderByComparator)
		throws com.sain.phonebook.exception.NoSuchRoleException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last role in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role, or <code>null</code> if a matching role could not be found
	 */
	public static Role fetchByUuid_Last(
		String uuid, OrderByComparator<Role> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the roles before and after the current role in the ordered set where uuid = &#63;.
	 *
	 * @param roleId the primary key of the current role
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role
	 * @throws NoSuchRoleException if a role with the primary key could not be found
	 */
	public static Role[] findByUuid_PrevAndNext(
			long roleId, String uuid, OrderByComparator<Role> orderByComparator)
		throws com.sain.phonebook.exception.NoSuchRoleException {

		return getPersistence().findByUuid_PrevAndNext(
			roleId, uuid, orderByComparator);
	}

	/**
	 * Removes all the roles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of roles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching roles
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the role where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRoleException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role
	 * @throws NoSuchRoleException if a matching role could not be found
	 */
	public static Role findByUUID_G(String uuid, long groupId)
		throws com.sain.phonebook.exception.NoSuchRoleException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the role where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role, or <code>null</code> if a matching role could not be found
	 */
	public static Role fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the role where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role, or <code>null</code> if a matching role could not be found
	 */
	public static Role fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the role where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the role that was removed
	 */
	public static Role removeByUUID_G(String uuid, long groupId)
		throws com.sain.phonebook.exception.NoSuchRoleException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of roles where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching roles
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the roles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching roles
	 */
	public static List<Role> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the roles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of roles
	 * @param end the upper bound of the range of roles (not inclusive)
	 * @return the range of matching roles
	 */
	public static List<Role> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the roles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of roles
	 * @param end the upper bound of the range of roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching roles
	 */
	public static List<Role> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Role> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the roles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of roles
	 * @param end the upper bound of the range of roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching roles
	 */
	public static List<Role> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Role> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role
	 * @throws NoSuchRoleException if a matching role could not be found
	 */
	public static Role findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Role> orderByComparator)
		throws com.sain.phonebook.exception.NoSuchRoleException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role, or <code>null</code> if a matching role could not be found
	 */
	public static Role fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Role> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role
	 * @throws NoSuchRoleException if a matching role could not be found
	 */
	public static Role findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Role> orderByComparator)
		throws com.sain.phonebook.exception.NoSuchRoleException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role, or <code>null</code> if a matching role could not be found
	 */
	public static Role fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Role> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the roles before and after the current role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param roleId the primary key of the current role
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role
	 * @throws NoSuchRoleException if a role with the primary key could not be found
	 */
	public static Role[] findByUuid_C_PrevAndNext(
			long roleId, String uuid, long companyId,
			OrderByComparator<Role> orderByComparator)
		throws com.sain.phonebook.exception.NoSuchRoleException {

		return getPersistence().findByUuid_C_PrevAndNext(
			roleId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the roles where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of roles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching roles
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the role where roleId = &#63; or throws a <code>NoSuchRoleException</code> if it could not be found.
	 *
	 * @param roleId the role ID
	 * @return the matching role
	 * @throws NoSuchRoleException if a matching role could not be found
	 */
	public static Role findByRoleId(long roleId)
		throws com.sain.phonebook.exception.NoSuchRoleException {

		return getPersistence().findByRoleId(roleId);
	}

	/**
	 * Returns the role where roleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param roleId the role ID
	 * @return the matching role, or <code>null</code> if a matching role could not be found
	 */
	public static Role fetchByRoleId(long roleId) {
		return getPersistence().fetchByRoleId(roleId);
	}

	/**
	 * Returns the role where roleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param roleId the role ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role, or <code>null</code> if a matching role could not be found
	 */
	public static Role fetchByRoleId(long roleId, boolean useFinderCache) {
		return getPersistence().fetchByRoleId(roleId, useFinderCache);
	}

	/**
	 * Removes the role where roleId = &#63; from the database.
	 *
	 * @param roleId the role ID
	 * @return the role that was removed
	 */
	public static Role removeByRoleId(long roleId)
		throws com.sain.phonebook.exception.NoSuchRoleException {

		return getPersistence().removeByRoleId(roleId);
	}

	/**
	 * Returns the number of roles where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the number of matching roles
	 */
	public static int countByRoleId(long roleId) {
		return getPersistence().countByRoleId(roleId);
	}

	/**
	 * Returns the role where name = &#63; or throws a <code>NoSuchRoleException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching role
	 * @throws NoSuchRoleException if a matching role could not be found
	 */
	public static Role findByRoleName(String name)
		throws com.sain.phonebook.exception.NoSuchRoleException {

		return getPersistence().findByRoleName(name);
	}

	/**
	 * Returns the role where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching role, or <code>null</code> if a matching role could not be found
	 */
	public static Role fetchByRoleName(String name) {
		return getPersistence().fetchByRoleName(name);
	}

	/**
	 * Returns the role where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role, or <code>null</code> if a matching role could not be found
	 */
	public static Role fetchByRoleName(String name, boolean useFinderCache) {
		return getPersistence().fetchByRoleName(name, useFinderCache);
	}

	/**
	 * Removes the role where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the role that was removed
	 */
	public static Role removeByRoleName(String name)
		throws com.sain.phonebook.exception.NoSuchRoleException {

		return getPersistence().removeByRoleName(name);
	}

	/**
	 * Returns the number of roles where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching roles
	 */
	public static int countByRoleName(String name) {
		return getPersistence().countByRoleName(name);
	}

	/**
	 * Caches the role in the entity cache if it is enabled.
	 *
	 * @param role the role
	 */
	public static void cacheResult(Role role) {
		getPersistence().cacheResult(role);
	}

	/**
	 * Caches the roles in the entity cache if it is enabled.
	 *
	 * @param roles the roles
	 */
	public static void cacheResult(List<Role> roles) {
		getPersistence().cacheResult(roles);
	}

	/**
	 * Creates a new role with the primary key. Does not add the role to the database.
	 *
	 * @param roleId the primary key for the new role
	 * @return the new role
	 */
	public static Role create(long roleId) {
		return getPersistence().create(roleId);
	}

	/**
	 * Removes the role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roleId the primary key of the role
	 * @return the role that was removed
	 * @throws NoSuchRoleException if a role with the primary key could not be found
	 */
	public static Role remove(long roleId)
		throws com.sain.phonebook.exception.NoSuchRoleException {

		return getPersistence().remove(roleId);
	}

	public static Role updateImpl(Role role) {
		return getPersistence().updateImpl(role);
	}

	/**
	 * Returns the role with the primary key or throws a <code>NoSuchRoleException</code> if it could not be found.
	 *
	 * @param roleId the primary key of the role
	 * @return the role
	 * @throws NoSuchRoleException if a role with the primary key could not be found
	 */
	public static Role findByPrimaryKey(long roleId)
		throws com.sain.phonebook.exception.NoSuchRoleException {

		return getPersistence().findByPrimaryKey(roleId);
	}

	/**
	 * Returns the role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roleId the primary key of the role
	 * @return the role, or <code>null</code> if a role with the primary key could not be found
	 */
	public static Role fetchByPrimaryKey(long roleId) {
		return getPersistence().fetchByPrimaryKey(roleId);
	}

	/**
	 * Returns all the roles.
	 *
	 * @return the roles
	 */
	public static List<Role> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of roles
	 * @param end the upper bound of the range of roles (not inclusive)
	 * @return the range of roles
	 */
	public static List<Role> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of roles
	 * @param end the upper bound of the range of roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of roles
	 */
	public static List<Role> findAll(
		int start, int end, OrderByComparator<Role> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of roles
	 * @param end the upper bound of the range of roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of roles
	 */
	public static List<Role> findAll(
		int start, int end, OrderByComparator<Role> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the roles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of roles.
	 *
	 * @return the number of roles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RolePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RolePersistence, RolePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RolePersistence.class);

		ServiceTracker<RolePersistence, RolePersistence> serviceTracker =
			new ServiceTracker<RolePersistence, RolePersistence>(
				bundle.getBundleContext(), RolePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}