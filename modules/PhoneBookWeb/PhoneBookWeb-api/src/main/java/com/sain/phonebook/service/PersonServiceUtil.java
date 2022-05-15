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

import com.liferay.portal.kernel.exception.PortalException;

import com.sain.phonebook.model.Person;

import java.util.List;

/**
 * Provides the remote service utility for Person. This utility wraps
 * <code>com.sain.phonebook.service.impl.PersonServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PersonService
 * @generated
 */
public class PersonServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.sain.phonebook.service.impl.PersonServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Person addPerson(
			String firstName, String lastName, String localPhoneNumber,
			String phoneNumber, String faxNumber, String roomNumber,
			String email, String website, long departmentId, long roleId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addPerson(
			firstName, lastName, localPhoneNumber, phoneNumber, faxNumber,
			roomNumber, email, website, departmentId, roleId, serviceContext);
	}

	public static Person deletePerson(long personId) throws PortalException {
		return getService().deletePerson(personId);
	}

	public static void deletePersons(Long[] personIds) throws PortalException {
		getService().deletePersons(personIds);
	}

	public static List<Person> getAll() {
		return getService().getAll();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Person getPerson(long personId) throws PortalException {
		return getService().getPerson(personId);
	}

	public static Person patchPerson(
			long id, String firstName, String lastName, String localPhoneNumber,
			String phoneNumber, String faxNumber, String roomNumber,
			String email, String website, long departmentId, long roleId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().patchPerson(
			id, firstName, lastName, localPhoneNumber, phoneNumber, faxNumber,
			roomNumber, email, website, departmentId, roleId, serviceContext);
	}

	public static Person updatePerson(
			long id, String firstName, String lastName, String localPhoneNumber,
			String phoneNumber, String faxNumber, String roomNumber,
			String email, String website, long departmentId, long roleId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updatePerson(
			id, firstName, lastName, localPhoneNumber, phoneNumber, faxNumber,
			roomNumber, email, website, departmentId, roleId, serviceContext);
	}

	public static PersonService getService() {
		return _service;
	}

	private static volatile PersonService _service;

}