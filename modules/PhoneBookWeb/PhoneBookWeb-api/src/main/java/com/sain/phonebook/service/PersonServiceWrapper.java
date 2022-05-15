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
 * Provides a wrapper for {@link PersonService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersonService
 * @generated
 */
public class PersonServiceWrapper
	implements PersonService, ServiceWrapper<PersonService> {

	public PersonServiceWrapper(PersonService personService) {
		_personService = personService;
	}

	@Override
	public com.sain.phonebook.model.Person addPerson(
			String firstName, String lastName, String localPhoneNumber,
			String phoneNumber, String faxNumber, String roomNumber,
			String email, String website, long departmentId, long roleId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personService.addPerson(
			firstName, lastName, localPhoneNumber, phoneNumber, faxNumber,
			roomNumber, email, website, departmentId, roleId, serviceContext);
	}

	@Override
	public com.sain.phonebook.model.Person deletePerson(long personId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personService.deletePerson(personId);
	}

	@Override
	public void deletePersons(Long[] personIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		_personService.deletePersons(personIds);
	}

	@Override
	public java.util.List<com.sain.phonebook.model.Person> getAll() {
		return _personService.getAll();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _personService.getOSGiServiceIdentifier();
	}

	@Override
	public com.sain.phonebook.model.Person getPerson(long personId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personService.getPerson(personId);
	}

	@Override
	public com.sain.phonebook.model.Person patchPerson(
			long id, String firstName, String lastName, String localPhoneNumber,
			String phoneNumber, String faxNumber, String roomNumber,
			String email, String website, long departmentId, long roleId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personService.patchPerson(
			id, firstName, lastName, localPhoneNumber, phoneNumber, faxNumber,
			roomNumber, email, website, departmentId, roleId, serviceContext);
	}

	@Override
	public com.sain.phonebook.model.Person updatePerson(
			long id, String firstName, String lastName, String localPhoneNumber,
			String phoneNumber, String faxNumber, String roomNumber,
			String email, String website, long departmentId, long roleId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personService.updatePerson(
			id, firstName, lastName, localPhoneNumber, phoneNumber, faxNumber,
			roomNumber, email, website, departmentId, roleId, serviceContext);
	}

	@Override
	public PersonService getWrappedService() {
		return _personService;
	}

	@Override
	public void setWrappedService(PersonService personService) {
		_personService = personService;
	}

	private PersonService _personService;

}