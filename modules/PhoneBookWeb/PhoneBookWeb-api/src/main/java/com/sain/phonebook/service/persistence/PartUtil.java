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

import com.sain.phonebook.model.Part;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the part service. This utility wraps <code>com.sain.phonebook.service.persistence.impl.PartPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PartPersistence
 * @generated
 */
public class PartUtil {

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
	public static void clearCache(Part part) {
		getPersistence().clearCache(part);
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
	public static Map<Serializable, Part> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Part> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Part> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Part> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Part> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Part update(Part part) {
		return getPersistence().update(part);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Part update(Part part, ServiceContext serviceContext) {
		return getPersistence().update(part, serviceContext);
	}

	/**
	 * Returns all the parts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching parts
	 */
	public static List<Part> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the parts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PartModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of parts
	 * @param end the upper bound of the range of parts (not inclusive)
	 * @return the range of matching parts
	 */
	public static List<Part> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the parts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PartModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of parts
	 * @param end the upper bound of the range of parts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching parts
	 */
	public static List<Part> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Part> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the parts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PartModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of parts
	 * @param end the upper bound of the range of parts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching parts
	 */
	public static List<Part> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Part> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first part in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching part
	 * @throws NoSuchPartException if a matching part could not be found
	 */
	public static Part findByUuid_First(
			String uuid, OrderByComparator<Part> orderByComparator)
		throws com.sain.phonebook.exception.NoSuchPartException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first part in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching part, or <code>null</code> if a matching part could not be found
	 */
	public static Part fetchByUuid_First(
		String uuid, OrderByComparator<Part> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last part in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching part
	 * @throws NoSuchPartException if a matching part could not be found
	 */
	public static Part findByUuid_Last(
			String uuid, OrderByComparator<Part> orderByComparator)
		throws com.sain.phonebook.exception.NoSuchPartException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last part in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching part, or <code>null</code> if a matching part could not be found
	 */
	public static Part fetchByUuid_Last(
		String uuid, OrderByComparator<Part> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the parts before and after the current part in the ordered set where uuid = &#63;.
	 *
	 * @param partId the primary key of the current part
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next part
	 * @throws NoSuchPartException if a part with the primary key could not be found
	 */
	public static Part[] findByUuid_PrevAndNext(
			long partId, String uuid, OrderByComparator<Part> orderByComparator)
		throws com.sain.phonebook.exception.NoSuchPartException {

		return getPersistence().findByUuid_PrevAndNext(
			partId, uuid, orderByComparator);
	}

	/**
	 * Removes all the parts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of parts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching parts
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the part where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPartException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching part
	 * @throws NoSuchPartException if a matching part could not be found
	 */
	public static Part findByUUID_G(String uuid, long groupId)
		throws com.sain.phonebook.exception.NoSuchPartException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the part where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching part, or <code>null</code> if a matching part could not be found
	 */
	public static Part fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the part where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching part, or <code>null</code> if a matching part could not be found
	 */
	public static Part fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the part where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the part that was removed
	 */
	public static Part removeByUUID_G(String uuid, long groupId)
		throws com.sain.phonebook.exception.NoSuchPartException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of parts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching parts
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the parts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching parts
	 */
	public static List<Part> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the parts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PartModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of parts
	 * @param end the upper bound of the range of parts (not inclusive)
	 * @return the range of matching parts
	 */
	public static List<Part> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the parts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PartModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of parts
	 * @param end the upper bound of the range of parts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching parts
	 */
	public static List<Part> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Part> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the parts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PartModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of parts
	 * @param end the upper bound of the range of parts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching parts
	 */
	public static List<Part> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Part> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first part in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching part
	 * @throws NoSuchPartException if a matching part could not be found
	 */
	public static Part findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Part> orderByComparator)
		throws com.sain.phonebook.exception.NoSuchPartException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first part in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching part, or <code>null</code> if a matching part could not be found
	 */
	public static Part fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Part> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last part in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching part
	 * @throws NoSuchPartException if a matching part could not be found
	 */
	public static Part findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Part> orderByComparator)
		throws com.sain.phonebook.exception.NoSuchPartException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last part in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching part, or <code>null</code> if a matching part could not be found
	 */
	public static Part fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Part> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the parts before and after the current part in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param partId the primary key of the current part
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next part
	 * @throws NoSuchPartException if a part with the primary key could not be found
	 */
	public static Part[] findByUuid_C_PrevAndNext(
			long partId, String uuid, long companyId,
			OrderByComparator<Part> orderByComparator)
		throws com.sain.phonebook.exception.NoSuchPartException {

		return getPersistence().findByUuid_C_PrevAndNext(
			partId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the parts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of parts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching parts
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the part where partId = &#63; or throws a <code>NoSuchPartException</code> if it could not be found.
	 *
	 * @param partId the part ID
	 * @return the matching part
	 * @throws NoSuchPartException if a matching part could not be found
	 */
	public static Part findByPartId(long partId)
		throws com.sain.phonebook.exception.NoSuchPartException {

		return getPersistence().findByPartId(partId);
	}

	/**
	 * Returns the part where partId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param partId the part ID
	 * @return the matching part, or <code>null</code> if a matching part could not be found
	 */
	public static Part fetchByPartId(long partId) {
		return getPersistence().fetchByPartId(partId);
	}

	/**
	 * Returns the part where partId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param partId the part ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching part, or <code>null</code> if a matching part could not be found
	 */
	public static Part fetchByPartId(long partId, boolean useFinderCache) {
		return getPersistence().fetchByPartId(partId, useFinderCache);
	}

	/**
	 * Removes the part where partId = &#63; from the database.
	 *
	 * @param partId the part ID
	 * @return the part that was removed
	 */
	public static Part removeByPartId(long partId)
		throws com.sain.phonebook.exception.NoSuchPartException {

		return getPersistence().removeByPartId(partId);
	}

	/**
	 * Returns the number of parts where partId = &#63;.
	 *
	 * @param partId the part ID
	 * @return the number of matching parts
	 */
	public static int countByPartId(long partId) {
		return getPersistence().countByPartId(partId);
	}

	/**
	 * Caches the part in the entity cache if it is enabled.
	 *
	 * @param part the part
	 */
	public static void cacheResult(Part part) {
		getPersistence().cacheResult(part);
	}

	/**
	 * Caches the parts in the entity cache if it is enabled.
	 *
	 * @param parts the parts
	 */
	public static void cacheResult(List<Part> parts) {
		getPersistence().cacheResult(parts);
	}

	/**
	 * Creates a new part with the primary key. Does not add the part to the database.
	 *
	 * @param partId the primary key for the new part
	 * @return the new part
	 */
	public static Part create(long partId) {
		return getPersistence().create(partId);
	}

	/**
	 * Removes the part with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param partId the primary key of the part
	 * @return the part that was removed
	 * @throws NoSuchPartException if a part with the primary key could not be found
	 */
	public static Part remove(long partId)
		throws com.sain.phonebook.exception.NoSuchPartException {

		return getPersistence().remove(partId);
	}

	public static Part updateImpl(Part part) {
		return getPersistence().updateImpl(part);
	}

	/**
	 * Returns the part with the primary key or throws a <code>NoSuchPartException</code> if it could not be found.
	 *
	 * @param partId the primary key of the part
	 * @return the part
	 * @throws NoSuchPartException if a part with the primary key could not be found
	 */
	public static Part findByPrimaryKey(long partId)
		throws com.sain.phonebook.exception.NoSuchPartException {

		return getPersistence().findByPrimaryKey(partId);
	}

	/**
	 * Returns the part with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param partId the primary key of the part
	 * @return the part, or <code>null</code> if a part with the primary key could not be found
	 */
	public static Part fetchByPrimaryKey(long partId) {
		return getPersistence().fetchByPrimaryKey(partId);
	}

	/**
	 * Returns all the parts.
	 *
	 * @return the parts
	 */
	public static List<Part> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the parts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PartModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parts
	 * @param end the upper bound of the range of parts (not inclusive)
	 * @return the range of parts
	 */
	public static List<Part> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the parts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PartModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parts
	 * @param end the upper bound of the range of parts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of parts
	 */
	public static List<Part> findAll(
		int start, int end, OrderByComparator<Part> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the parts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PartModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parts
	 * @param end the upper bound of the range of parts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of parts
	 */
	public static List<Part> findAll(
		int start, int end, OrderByComparator<Part> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the parts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of parts.
	 *
	 * @return the number of parts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PartPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PartPersistence, PartPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PartPersistence.class);

		ServiceTracker<PartPersistence, PartPersistence> serviceTracker =
			new ServiceTracker<PartPersistence, PartPersistence>(
				bundle.getBundleContext(), PartPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}