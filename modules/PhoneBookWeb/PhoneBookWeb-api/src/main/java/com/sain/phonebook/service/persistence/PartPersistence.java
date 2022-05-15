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

import com.sain.phonebook.exception.NoSuchPartException;
import com.sain.phonebook.model.Part;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the part service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PartUtil
 * @generated
 */
@ProviderType
public interface PartPersistence extends BasePersistence<Part> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PartUtil} to access the part persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the parts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching parts
	 */
	public java.util.List<Part> findByUuid(String uuid);

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
	public java.util.List<Part> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Part> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Part>
			orderByComparator);

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
	public java.util.List<Part> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Part>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first part in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching part
	 * @throws NoSuchPartException if a matching part could not be found
	 */
	public Part findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Part>
				orderByComparator)
		throws NoSuchPartException;

	/**
	 * Returns the first part in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching part, or <code>null</code> if a matching part could not be found
	 */
	public Part fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Part>
			orderByComparator);

	/**
	 * Returns the last part in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching part
	 * @throws NoSuchPartException if a matching part could not be found
	 */
	public Part findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Part>
				orderByComparator)
		throws NoSuchPartException;

	/**
	 * Returns the last part in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching part, or <code>null</code> if a matching part could not be found
	 */
	public Part fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Part>
			orderByComparator);

	/**
	 * Returns the parts before and after the current part in the ordered set where uuid = &#63;.
	 *
	 * @param partId the primary key of the current part
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next part
	 * @throws NoSuchPartException if a part with the primary key could not be found
	 */
	public Part[] findByUuid_PrevAndNext(
			long partId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Part>
				orderByComparator)
		throws NoSuchPartException;

	/**
	 * Removes all the parts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of parts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching parts
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the part where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPartException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching part
	 * @throws NoSuchPartException if a matching part could not be found
	 */
	public Part findByUUID_G(String uuid, long groupId)
		throws NoSuchPartException;

	/**
	 * Returns the part where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching part, or <code>null</code> if a matching part could not be found
	 */
	public Part fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the part where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching part, or <code>null</code> if a matching part could not be found
	 */
	public Part fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the part where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the part that was removed
	 */
	public Part removeByUUID_G(String uuid, long groupId)
		throws NoSuchPartException;

	/**
	 * Returns the number of parts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching parts
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the parts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching parts
	 */
	public java.util.List<Part> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Part> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Part> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Part>
			orderByComparator);

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
	public java.util.List<Part> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Part>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first part in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching part
	 * @throws NoSuchPartException if a matching part could not be found
	 */
	public Part findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Part>
				orderByComparator)
		throws NoSuchPartException;

	/**
	 * Returns the first part in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching part, or <code>null</code> if a matching part could not be found
	 */
	public Part fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Part>
			orderByComparator);

	/**
	 * Returns the last part in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching part
	 * @throws NoSuchPartException if a matching part could not be found
	 */
	public Part findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Part>
				orderByComparator)
		throws NoSuchPartException;

	/**
	 * Returns the last part in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching part, or <code>null</code> if a matching part could not be found
	 */
	public Part fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Part>
			orderByComparator);

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
	public Part[] findByUuid_C_PrevAndNext(
			long partId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Part>
				orderByComparator)
		throws NoSuchPartException;

	/**
	 * Removes all the parts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of parts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching parts
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the part where partId = &#63; or throws a <code>NoSuchPartException</code> if it could not be found.
	 *
	 * @param partId the part ID
	 * @return the matching part
	 * @throws NoSuchPartException if a matching part could not be found
	 */
	public Part findByPartId(long partId) throws NoSuchPartException;

	/**
	 * Returns the part where partId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param partId the part ID
	 * @return the matching part, or <code>null</code> if a matching part could not be found
	 */
	public Part fetchByPartId(long partId);

	/**
	 * Returns the part where partId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param partId the part ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching part, or <code>null</code> if a matching part could not be found
	 */
	public Part fetchByPartId(long partId, boolean useFinderCache);

	/**
	 * Removes the part where partId = &#63; from the database.
	 *
	 * @param partId the part ID
	 * @return the part that was removed
	 */
	public Part removeByPartId(long partId) throws NoSuchPartException;

	/**
	 * Returns the number of parts where partId = &#63;.
	 *
	 * @param partId the part ID
	 * @return the number of matching parts
	 */
	public int countByPartId(long partId);

	/**
	 * Returns all the parts where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @return the matching parts
	 */
	public java.util.List<Part> findByAddressId(long addressId);

	/**
	 * Returns a range of all the parts where addressId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PartModelImpl</code>.
	 * </p>
	 *
	 * @param addressId the address ID
	 * @param start the lower bound of the range of parts
	 * @param end the upper bound of the range of parts (not inclusive)
	 * @return the range of matching parts
	 */
	public java.util.List<Part> findByAddressId(
		long addressId, int start, int end);

	/**
	 * Returns an ordered range of all the parts where addressId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PartModelImpl</code>.
	 * </p>
	 *
	 * @param addressId the address ID
	 * @param start the lower bound of the range of parts
	 * @param end the upper bound of the range of parts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching parts
	 */
	public java.util.List<Part> findByAddressId(
		long addressId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Part>
			orderByComparator);

	/**
	 * Returns an ordered range of all the parts where addressId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PartModelImpl</code>.
	 * </p>
	 *
	 * @param addressId the address ID
	 * @param start the lower bound of the range of parts
	 * @param end the upper bound of the range of parts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching parts
	 */
	public java.util.List<Part> findByAddressId(
		long addressId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Part>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first part in the ordered set where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching part
	 * @throws NoSuchPartException if a matching part could not be found
	 */
	public Part findByAddressId_First(
			long addressId,
			com.liferay.portal.kernel.util.OrderByComparator<Part>
				orderByComparator)
		throws NoSuchPartException;

	/**
	 * Returns the first part in the ordered set where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching part, or <code>null</code> if a matching part could not be found
	 */
	public Part fetchByAddressId_First(
		long addressId,
		com.liferay.portal.kernel.util.OrderByComparator<Part>
			orderByComparator);

	/**
	 * Returns the last part in the ordered set where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching part
	 * @throws NoSuchPartException if a matching part could not be found
	 */
	public Part findByAddressId_Last(
			long addressId,
			com.liferay.portal.kernel.util.OrderByComparator<Part>
				orderByComparator)
		throws NoSuchPartException;

	/**
	 * Returns the last part in the ordered set where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching part, or <code>null</code> if a matching part could not be found
	 */
	public Part fetchByAddressId_Last(
		long addressId,
		com.liferay.portal.kernel.util.OrderByComparator<Part>
			orderByComparator);

	/**
	 * Returns the parts before and after the current part in the ordered set where addressId = &#63;.
	 *
	 * @param partId the primary key of the current part
	 * @param addressId the address ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next part
	 * @throws NoSuchPartException if a part with the primary key could not be found
	 */
	public Part[] findByAddressId_PrevAndNext(
			long partId, long addressId,
			com.liferay.portal.kernel.util.OrderByComparator<Part>
				orderByComparator)
		throws NoSuchPartException;

	/**
	 * Removes all the parts where addressId = &#63; from the database.
	 *
	 * @param addressId the address ID
	 */
	public void removeByAddressId(long addressId);

	/**
	 * Returns the number of parts where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @return the number of matching parts
	 */
	public int countByAddressId(long addressId);

	/**
	 * Caches the part in the entity cache if it is enabled.
	 *
	 * @param part the part
	 */
	public void cacheResult(Part part);

	/**
	 * Caches the parts in the entity cache if it is enabled.
	 *
	 * @param parts the parts
	 */
	public void cacheResult(java.util.List<Part> parts);

	/**
	 * Creates a new part with the primary key. Does not add the part to the database.
	 *
	 * @param partId the primary key for the new part
	 * @return the new part
	 */
	public Part create(long partId);

	/**
	 * Removes the part with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param partId the primary key of the part
	 * @return the part that was removed
	 * @throws NoSuchPartException if a part with the primary key could not be found
	 */
	public Part remove(long partId) throws NoSuchPartException;

	public Part updateImpl(Part part);

	/**
	 * Returns the part with the primary key or throws a <code>NoSuchPartException</code> if it could not be found.
	 *
	 * @param partId the primary key of the part
	 * @return the part
	 * @throws NoSuchPartException if a part with the primary key could not be found
	 */
	public Part findByPrimaryKey(long partId) throws NoSuchPartException;

	/**
	 * Returns the part with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param partId the primary key of the part
	 * @return the part, or <code>null</code> if a part with the primary key could not be found
	 */
	public Part fetchByPrimaryKey(long partId);

	/**
	 * Returns all the parts.
	 *
	 * @return the parts
	 */
	public java.util.List<Part> findAll();

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
	public java.util.List<Part> findAll(int start, int end);

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
	public java.util.List<Part> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Part>
			orderByComparator);

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
	public java.util.List<Part> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Part>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the parts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of parts.
	 *
	 * @return the number of parts
	 */
	public int countAll();

}