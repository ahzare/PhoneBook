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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.sain.phonebook.exception.NoSuchRoleException;
import com.sain.phonebook.model.Role;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoleUtil
 * @generated
 */
@ProviderType
public interface RolePersistence extends BasePersistence<Role> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RoleUtil} to access the role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the roles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching roles
	 */
	public java.util.List<Role> findByUuid(String uuid);

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
	public java.util.List<Role> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Role> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Role>
			orderByComparator);

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
	public java.util.List<Role> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Role>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first role in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role
	 * @throws NoSuchRoleException if a matching role could not be found
	 */
	public Role findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Role>
				orderByComparator)
		throws NoSuchRoleException;

	/**
	 * Returns the first role in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role, or <code>null</code> if a matching role could not be found
	 */
	public Role fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Role>
			orderByComparator);

	/**
	 * Returns the last role in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role
	 * @throws NoSuchRoleException if a matching role could not be found
	 */
	public Role findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Role>
				orderByComparator)
		throws NoSuchRoleException;

	/**
	 * Returns the last role in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role, or <code>null</code> if a matching role could not be found
	 */
	public Role fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Role>
			orderByComparator);

	/**
	 * Returns the roles before and after the current role in the ordered set where uuid = &#63;.
	 *
	 * @param roleId the primary key of the current role
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role
	 * @throws NoSuchRoleException if a role with the primary key could not be found
	 */
	public Role[] findByUuid_PrevAndNext(
			long roleId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Role>
				orderByComparator)
		throws NoSuchRoleException;

	/**
	 * Removes all the roles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of roles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching roles
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the role where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRoleException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role
	 * @throws NoSuchRoleException if a matching role could not be found
	 */
	public Role findByUUID_G(String uuid, long groupId)
		throws NoSuchRoleException;

	/**
	 * Returns the role where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role, or <code>null</code> if a matching role could not be found
	 */
	public Role fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the role where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role, or <code>null</code> if a matching role could not be found
	 */
	public Role fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the role where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the role that was removed
	 */
	public Role removeByUUID_G(String uuid, long groupId)
		throws NoSuchRoleException;

	/**
	 * Returns the number of roles where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching roles
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the roles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching roles
	 */
	public java.util.List<Role> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Role> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Role> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Role>
			orderByComparator);

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
	public java.util.List<Role> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Role>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role
	 * @throws NoSuchRoleException if a matching role could not be found
	 */
	public Role findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Role>
				orderByComparator)
		throws NoSuchRoleException;

	/**
	 * Returns the first role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role, or <code>null</code> if a matching role could not be found
	 */
	public Role fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Role>
			orderByComparator);

	/**
	 * Returns the last role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role
	 * @throws NoSuchRoleException if a matching role could not be found
	 */
	public Role findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Role>
				orderByComparator)
		throws NoSuchRoleException;

	/**
	 * Returns the last role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role, or <code>null</code> if a matching role could not be found
	 */
	public Role fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Role>
			orderByComparator);

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
	public Role[] findByUuid_C_PrevAndNext(
			long roleId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Role>
				orderByComparator)
		throws NoSuchRoleException;

	/**
	 * Removes all the roles where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of roles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching roles
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the role where roleId = &#63; or throws a <code>NoSuchRoleException</code> if it could not be found.
	 *
	 * @param roleId the role ID
	 * @return the matching role
	 * @throws NoSuchRoleException if a matching role could not be found
	 */
	public Role findByRoleId(long roleId) throws NoSuchRoleException;

	/**
	 * Returns the role where roleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param roleId the role ID
	 * @return the matching role, or <code>null</code> if a matching role could not be found
	 */
	public Role fetchByRoleId(long roleId);

	/**
	 * Returns the role where roleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param roleId the role ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role, or <code>null</code> if a matching role could not be found
	 */
	public Role fetchByRoleId(long roleId, boolean useFinderCache);

	/**
	 * Removes the role where roleId = &#63; from the database.
	 *
	 * @param roleId the role ID
	 * @return the role that was removed
	 */
	public Role removeByRoleId(long roleId) throws NoSuchRoleException;

	/**
	 * Returns the number of roles where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the number of matching roles
	 */
	public int countByRoleId(long roleId);

	/**
	 * Returns the role where name = &#63; or throws a <code>NoSuchRoleException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching role
	 * @throws NoSuchRoleException if a matching role could not be found
	 */
	public Role findByRoleName(String name) throws NoSuchRoleException;

	/**
	 * Returns the role where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching role, or <code>null</code> if a matching role could not be found
	 */
	public Role fetchByRoleName(String name);

	/**
	 * Returns the role where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role, or <code>null</code> if a matching role could not be found
	 */
	public Role fetchByRoleName(String name, boolean useFinderCache);

	/**
	 * Removes the role where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the role that was removed
	 */
	public Role removeByRoleName(String name) throws NoSuchRoleException;

	/**
	 * Returns the number of roles where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching roles
	 */
	public int countByRoleName(String name);

	/**
	 * Caches the role in the entity cache if it is enabled.
	 *
	 * @param role the role
	 */
	public void cacheResult(Role role);

	/**
	 * Caches the roles in the entity cache if it is enabled.
	 *
	 * @param roles the roles
	 */
	public void cacheResult(java.util.List<Role> roles);

	/**
	 * Creates a new role with the primary key. Does not add the role to the database.
	 *
	 * @param roleId the primary key for the new role
	 * @return the new role
	 */
	public Role create(long roleId);

	/**
	 * Removes the role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roleId the primary key of the role
	 * @return the role that was removed
	 * @throws NoSuchRoleException if a role with the primary key could not be found
	 */
	public Role remove(long roleId) throws NoSuchRoleException;

	public Role updateImpl(Role role);

	/**
	 * Returns the role with the primary key or throws a <code>NoSuchRoleException</code> if it could not be found.
	 *
	 * @param roleId the primary key of the role
	 * @return the role
	 * @throws NoSuchRoleException if a role with the primary key could not be found
	 */
	public Role findByPrimaryKey(long roleId) throws NoSuchRoleException;

	/**
	 * Returns the role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roleId the primary key of the role
	 * @return the role, or <code>null</code> if a role with the primary key could not be found
	 */
	public Role fetchByPrimaryKey(long roleId);

	/**
	 * Returns all the roles.
	 *
	 * @return the roles
	 */
	public java.util.List<Role> findAll();

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
	public java.util.List<Role> findAll(int start, int end);

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
	public java.util.List<Role> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Role>
			orderByComparator);

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
	public java.util.List<Role> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Role>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the roles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of roles.
	 *
	 * @return the number of roles
	 */
	public int countAll();

}