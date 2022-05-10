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
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;

import com.sain.headless.phonebook.dto.v1_0.Person;
import com.sain.headless.phonebook.resource.v1_0.PersonResource;
import com.sain.phonebook.service.DepartmentService;
import com.sain.phonebook.service.PersonService;
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
	properties = "OSGI-INF/liferay/rest/v1_0/person.properties",
	scope = ServiceScope.PROTOTYPE, service = PersonResource.class
)
public class PersonResourceImpl extends BasePersonResourceImpl {

	@Override
	public void deletePersonApi(Long siteId, Long personId) throws Exception {
		try {

			// super easy case, just pass through to the service layer.

			_personService.deletePerson(personId);
		}
		catch (Exception exception) {
			_log.error(
				"Error deleting person: " + exception.getMessage(), exception);

			throw exception;
		}
	}

	/*@Override
		public EntityModel getEntityModel(Map<String, List<String>> multivaluedMap)
			throws Exception {
			return _personEntityModel;
		}*/

	@Override
	public Person getPerson(Long siteId, Long personId) throws Exception {
		try {

			// fetch the entity class...

			com.sain.phonebook.model.Person persistedPerson =
				_personService.getPerson(personId);

			return toPerson(persistedPerson);
		}
		catch (Exception exception) {
			_log.error(
				"Error getting person [" + personId + "]: " +
					exception.getMessage(),
				exception);

			throw exception;
		}
	}

	@Override
	public Page<Person> getPersonsPage(
			Long siteId, Long departmentId, Long roleId, String search,
			Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception {

		System.out.println("getPersonsPage");

		Page<Person> personPage = SearchUtil.search(
			booleanQuery -> booleanQuery.getPreBooleanFilter(), filter,
			com.sain.phonebook.model.Person.class, search, pagination,
			queryConfig -> queryConfig.setSelectedFieldNames(
				Field.ENTRY_CLASS_PK),
			new UnsafeConsumer() {

				public void accept(Object object) throws Exception {
					SearchContext searchContext = (SearchContext)object;

					searchContext.setCompanyId(contextCompany.getCompanyId());
				}

			},
			document -> toPerson(
				_personService.getPerson(
					GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)))),
			sorts);

		System.out.println("person page = " + personPage);

		return personPage;

		/* if (departmentId != null && departmentId != 0) {
		     // get people of specific department
		 }
		 if (roleId != null && roleId != 0) {
		     // get people of specific role
		 }*/

		/*List<com.sain.phonebook.model.Person> persistedPersons =
			_personService.getAll();
		List<Person> list = new ArrayList<>();

		for (com.sain.phonebook.model.Person persistedPerson :
				persistedPersons) {

			Person person = toPerson(persistedPerson);

			if (search != null) {
				String fName = person.getFirstName();
				String lName = person.getLastName();

				String name = fName.concat(lName);

				name = name.toLowerCase(Locale.ROOT);

				if (name.contains(search.toLowerCase(Locale.ROOT))) {
					list.add(person);
				}
			}
			else {
				list.add(person);
			}

			if ((departmentId != null) && (departmentId != 0)) {
				Department department = person.getDepartment();
				Long dId = 0L;

				if (department != null) {
					dId = department.getId();
				}

				if ((person.getDepartment() == null) ||
					!dId.equals(departmentId)) {

					list.remove(person);
				}
			}

			if ((roleId != null) && (roleId != 0)) {
				Role role = person.getRole();
				Long rId = 0L;

				if (role != null) {
					rId = role.getId();
				}

				if ((person.getRole() == null) || !rId.equals(roleId)) {
					list.remove(person);
				}
			}
		}

		return Page.of(list);*/
	}

	@Override
	public Person patchPersonApi(
			@NotNull Long personId, Long roleId, Long departmentId,
			Person person)
		throws Exception {

		try {
			com.sain.phonebook.model.Person persistedPerson =
				_personService.patchPerson(
					personId, person.getFirstName(), person.getLastName(),
					person.getLocalPhoneNumber(), person.getPhoneNumber(),
					person.getFaxNumber(), person.getRoomNumber(),
					person.getEmail(), person.getWebsite(),
					(departmentId != null) ? departmentId : 0,
					(roleId != null) ? roleId : 0, getServiceContext());

			return toPerson(persistedPerson);
		}
		catch (Exception exception) {
			_log.error(
				"Error patching person: " + exception.getMessage(), exception);

			throw exception;
		}
	}

	@Override
	public Person postPerson(
			Long siteId, Long departmentId, Long roleId, Person person)
		throws Exception {

		System.out.println("postPerson");

		if (_log.isDebugEnabled()) {
			_log.debug("Need to create a new person: %s\n", person.toString());
		}

		_log.warn("hi ali");

		try {
			com.sain.phonebook.model.Person persistedPerson =
				_personService.addPerson(
					person.getFirstName(), person.getLastName(),
					person.getLocalPhoneNumber(), person.getPhoneNumber(),
					person.getFaxNumber(), person.getRoomNumber(),
					person.getEmail(), person.getWebsite(),
					(departmentId != null) ? departmentId : 0,
					(roleId != null) ? roleId : 0, getServiceContext());

			return toPerson(persistedPerson);
		}
		catch (Exception exception) {
			_log.error(
				"Error creating person: " + exception.getMessage(), exception);

			throw exception;
		}
	}

	@Override
	public void postPersonExcel(Long siteId, MultipartBody multipartBody)
		throws Exception {
	}

	@Override
	public Person putPersonApi(
			@NotNull Long personId, Long roleId, Long departmentId,
			Person person)
		throws Exception {

		try {
			com.sain.phonebook.model.Person persistedPerson =
				_personService.updatePerson(
					personId, person.getFirstName(), person.getLastName(),
					person.getLocalPhoneNumber(), person.getPhoneNumber(),
					person.getFaxNumber(), person.getRoomNumber(),
					person.getEmail(), person.getWebsite(),
					(departmentId != null) ? departmentId : 0,
					(roleId != null) ? roleId : 0, getServiceContext());

			return toPerson(persistedPerson);
		}
		catch (Exception exception) {
			_log.error(
				"Error putting person: " + exception.getMessage(), exception);

			throw exception;
		}
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

	protected Person toPerson(com.sain.phonebook.model.Person person)
		throws PortalException {

		return new Person() {
			{
				email = person.getEmail();
				faxNumber = person.getFaxNumber();
				firstName = person.getFirstName();
				id = person.getPersonId();
				lastName = person.getLastName();
				localPhoneNumber = person.getLocalPhoneNumber();
				phoneNumber = person.getPhoneNumber();
				roomNumber = person.getRoomNumber();
				website = person.getWebsite();

				if (person.getDepartmentId() != 0) {
					department = DepartmentResourceImpl.toDepartment(
						_departmentService.getDepartment(
							person.getDepartmentId()));
				}

				if (person.getRoleId() != 0) {
					role = RoleResourceImpl.toRole(
						_roleService.getRole(person.getRoleId()));
				}
			}
		};
	}

	private static final Logger _log = LoggerFactory.getLogger(
		PersonResourceImpl.class);

	/*private static final EntityModel _personEntityModel =
		new PersonEntityModel();*/
	@Reference
	private DepartmentService _departmentService;

	@Reference
	private PersonService _personService;

	@Reference
	private Portal _portal;

	@Reference
	private RoleService _roleService;

	@Reference
	private UserLocalService _userLocalService;

}