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

package com.sain.phonebook.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.service.ServiceContext;

import com.sain.phonebook.constants.PhoneBookConstants;
import com.sain.phonebook.model.Person;
import com.sain.phonebook.service.base.PersonServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=phonebook",
		"json.web.service.context.path=Person"
	},
	service = AopService.class
)
public class PersonServiceImpl extends PersonServiceBaseImpl {

	public Person addPerson(
			final String firstName, final String lastName,
			final String localPhoneNumber, final String phoneNumber,
			final String faxNumber, final String roomNumber, final String email,
			final String website, final long departmentId, final long roleId,
			final ServiceContext serviceContext)
		throws PortalException {

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.ADD_ENTRY);

		return personLocalService.addPerson(
			firstName, lastName, localPhoneNumber, phoneNumber, faxNumber,
			roomNumber, email, website, departmentId, roleId, serviceContext);
	}

	public Person deletePerson(final long personId) throws PortalException {
		Person person = personLocalService.getPerson(personId);

		if (person != null) {
			_personModelResourcePermission.check(
				getPermissionChecker(), personId, ActionKeys.DELETE);
		}

		return personLocalService.deletePerson(personId);
	}

	public void deletePersons(Long[] personIds) throws PortalException {
		for (Long personId : personIds) {
			deletePerson(personId);
		}
	}

	public List<Person> getAll() {
		return personPersistence.findAll();
	}

	public Person getPerson(final long personId) throws PortalException {
		Person person = personLocalService.getPerson(personId);

		if (person != null) {
			_personModelResourcePermission.check(
				getPermissionChecker(), person, ActionKeys.VIEW);
		}

		return person;
	}

	public Person patchPerson(
			final long id, final String firstName, final String lastName,
			final String localPhoneNumber, final String phoneNumber,
			final String faxNumber, final String roomNumber, final String email,
			final String website, final long departmentId, final long roleId,
			final ServiceContext serviceContext)
		throws PortalException {

		_personModelResourcePermission.check(
			getPermissionChecker(), id, ActionKeys.UPDATE);

		return personLocalService.patchPerson(
			id, firstName, lastName, localPhoneNumber, phoneNumber, faxNumber,
			roomNumber, email, website, departmentId, roleId, serviceContext);
	}

	public Person updatePerson(
			final long id, final String firstName, final String lastName,
			final String localPhoneNumber, final String phoneNumber,
			final String faxNumber, final String roomNumber, final String email,
			final String website, final long departmentId, final long roleId,
			final ServiceContext serviceContext)
		throws PortalException {

		_personModelResourcePermission.check(
			getPermissionChecker(), id, ActionKeys.UPDATE);

		return personLocalService.updatePerson(
			id, firstName, lastName, localPhoneNumber, phoneNumber, faxNumber,
			roomNumber, email, website, departmentId, roleId, serviceContext);
	}

	private static volatile PortletResourcePermission
		_portletResourcePermission =
			PortletResourcePermissionFactory.getInstance(
				PersonServiceImpl.class, "_portletResourcePermission",
				PhoneBookConstants.RESOURCE_NAME);

	@Reference(
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		target = "(model.class.name=com.sain.phonebook.model.Person)"
	)
	private volatile ModelResourcePermission<Person>
		_personModelResourcePermission;

}