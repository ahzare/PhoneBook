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
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.vulcan.multipart.BinaryFile;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;

import com.sain.headless.phonebook.constants.PersonConstants;
import com.sain.headless.phonebook.dto.v1_0.Department;
import com.sain.headless.phonebook.dto.v1_0.Person;
import com.sain.headless.phonebook.dto.v1_0.Role;
import com.sain.headless.phonebook.resource.v1_0.PersonResource;
import com.sain.headless.phonebook.util.ServiceContextHelper;
import com.sain.phonebook.service.DepartmentService;
import com.sain.phonebook.service.PersonService;
import com.sain.phonebook.service.RoleService;

import java.io.InputStream;

import java.util.Locale;

import javax.validation.constraints.NotNull;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
	public Person deletePersonApi(Long siteId, Long personId) throws Exception {
		return toPerson(_personService.deletePerson(personId));
	}

	@Override
	public void deletePersons(Long siteId, Long[] longs) throws Exception {
		_personService.deletePersons(longs);
	}

	/*@Override
		public EntityModel getEntityModel(Map<String, List<String>> multivaluedMap)
			throws Exception {
			return _personEntityModel;
		}*/

	@Override
	public Person getPerson(Long personId) throws Exception {
		try {

			// fetch the entity class...

			com.sain.phonebook.model.Person persistedPerson =
				_personService.getPerson(personId);

			if (persistedPerson != null) {
				return toPerson(persistedPerson);
			}

			return null;
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
			Long siteId, String search, Filter filter, Pagination pagination,
			Sort[] sorts)
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
	}

	@Override
	public Person patchPerson(
			@NotNull Long personId, Long roleId, Long departmentId,
			Person person)
		throws Exception {

		com.sain.phonebook.model.Person persistedPerson1 =
			_personService.getPerson(personId);

		if (persistedPerson1 != null) {
			try {
				com.sain.phonebook.model.Person persistedPerson =
					_personService.patchPerson(
						personId, person.getFirstName(), person.getLastName(),
						person.getLocalPhoneNumber(), person.getPhoneNumber(),
						person.getFaxNumber(), person.getRoomNumber(),
						person.getEmail(), person.getWebsite(),
						(departmentId != null) ? departmentId : 0,
						(roleId != null) ? roleId : 0,
						_serviceContextHelper.getServiceContext(
							persistedPerson1.getGroupId()));

				return toPerson(persistedPerson);
			}
			catch (Exception exception) {
				_log.error(
					"Error patching person: " + exception.getMessage(),
					exception);

				throw exception;
			}
		}
		else {
			return null;
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

		try {
			com.sain.phonebook.model.Person persistedPerson =
				_personService.addPerson(
					person.getFirstName(), person.getLastName(),
					person.getLocalPhoneNumber(), person.getPhoneNumber(),
					person.getFaxNumber(), person.getRoomNumber(),
					person.getEmail(), person.getWebsite(),
					(departmentId != null) ? departmentId : 0,
					(roleId != null) ? roleId : 0,
					_serviceContextHelper.getServiceContext(siteId));

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

		BinaryFile binaryFile = multipartBody.getBinaryFile("file");

		InputStream inputStream = binaryFile.getInputStream();

		System.out.println(inputStream.toString());

		XSSFWorkbook wb = new XSSFWorkbook(inputStream);

		XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object

		int i = 1;
		int empties = 0;
		boolean first = true;

		for (Row row : sheet) {
			if (first) {
				first = false;

				continue;
			}

			Person person = new Person();

			person.setLastName(
				_getCellValue(row, PersonConstants.EXCEL_ROW_LAST_NAME));
			person.setFirstName(
				_getCellValue(row, PersonConstants.EXCEL_ROW_FIRST_NAME));
			person.setLocalPhoneNumber(
				_getCellValue(
					row, PersonConstants.EXCEL_ROW_LOCAL_PHONE_NUMBER));
			person.setPhoneNumber(
				_getCellValue(row, PersonConstants.EXCEL_ROW_PHONE_NUMBER));
			person.setFaxNumber(
				_getCellValue(row, PersonConstants.EXCEL_ROW_FAX_NUMBER));
			person.setRoomNumber(
				_getCellValue(row, PersonConstants.EXCEL_ROW_ROOM_NUMBER));
			person.setEmail(
				_getCellValue(row, PersonConstants.EXCEL_ROW_EMAIL));
			person.setWebsite(
				_getCellValue(row, PersonConstants.EXCEL_ROW_WEBSITE));

			String roleName = _getCellValue(
				row, PersonConstants.EXCEL_ROW_ROLE);

			String departmentName = _getCellValue(
				row, PersonConstants.EXCEL_ROW_DEPARTMENT);

			System.out.println(
				i + " -> " + person.getFirstName() + ", " +
					person.getLastName() + ", " + person.getLocalPhoneNumber() +
						", " + person.getPhoneNumber());

			if ((person.getLastName() == null) &&
				(person.getFirstName() == null) &&
				(person.getLocalPhoneNumber() == null) &&
				(person.getPhoneNumber() == null) &&
				(person.getFaxNumber() == null) &&
				(person.getRoomNumber() == null) &&
				(person.getEmail() == null) && (person.getWebsite() == null) &&
				(roleName == null) && (departmentName == null)) {

				System.out.println("row " + i + " is empty");
				empties++;

				continue;
			}

			Long roleId = 0L;
			Long departmentId = 0L;

			if (roleName != null) {
				Role role = RoleResourceImpl.toRole(
					_roleService.addRole(
						roleName,
						_serviceContextHelper.getServiceContext(siteId)));

				roleId = role.getId();
			}

			if (departmentName != null) {
				Department department = DepartmentResourceImpl.toDepartment(
					_departmentService.addDepartment(
						departmentName,
						_serviceContextHelper.getServiceContext(siteId)));

				departmentId = department.getId();
			}

			//			com.sain.phonebook.model.Person persistedPerson =
			_personService.addPerson(
				person.getFirstName(), person.getLastName(),
				person.getLocalPhoneNumber(), person.getPhoneNumber(),
				person.getFaxNumber(), person.getRoomNumber(),
				person.getEmail(), person.getWebsite(),
				(departmentId != null) ? departmentId : 0,
				(roleId != null) ? roleId : 0,
				_serviceContextHelper.getServiceContext(siteId));

			i++;

			//            return toPerson(persistedPerson);

		}

		System.out.println((i - 1) + " rows inserted.");
		System.out.println(empties + " rows empty.");
/*
        }
       */ /**/

		//		_personService.addPersonExcel(siteId, inputStream,
		//				_serviceContextHelper.getServiceContext(siteId));
	}

	@Override
	public Person putPersonApi(
			@NotNull Long personId, Long roleId, Long departmentId,
			Person person)
		throws Exception {

		com.sain.phonebook.model.Person persistedPerson1 =
			_personService.getPerson(personId);

		if (persistedPerson1 != null) {
			try {
				com.sain.phonebook.model.Person persistedPerson =
					_personService.updatePerson(
						personId, person.getFirstName(), person.getLastName(),
						person.getLocalPhoneNumber(), person.getPhoneNumber(),
						person.getFaxNumber(), person.getRoomNumber(),
						person.getEmail(), person.getWebsite(),
						(departmentId != null) ? departmentId : 0,
						(roleId != null) ? roleId : 0,
						_serviceContextHelper.getServiceContext(
							persistedPerson1.getGroupId()));

				return toPerson(persistedPerson);
			}
			catch (Exception exception) {
				_log.error(
					"Error putting person: " + exception.getMessage(),
					exception);

				throw exception;
			}
		}
		else {
			return null;
		}
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

	private String _getCellValue(Row row, int i) {
		if (row == null) {
			return null;
		}

		Cell cell = row.getCell(i);

		if (cell == null) {
			return null;
		}

		switch (cell.getCellType()) {
			case STRING:
				RichTextString cellValue = cell.getRichStringCellValue();

				System.out.println(cellValue.getString());

				if (i == 2) {

					// cell contains multiple numbers

					return _getMultipleNumbers(cellValue.getString());
				}

				return cellValue.getString();

			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					System.out.println(cell.getDateCellValue());

					return String.valueOf(cell.getDateCellValue());
				}

				System.out.println(cell.getNumericCellValue());

				return String.valueOf((int)cell.getNumericCellValue());

			//					case BOOLEAN: ... break;
			//					case FORMULA: ... break;
			default:
				System.out.println("default");

				return null;
		}
	}

	/*protected ServiceContext getServiceContext(Long siteId)
		throws PortalException {

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(contextCompany.getCompanyId());

		if (siteId != 0) {
			serviceContext.setScopeGroupId(siteId);
		}

		System.out.println("company id = " + contextCompany.getGroupId());

		// need the current user in the service context.
		// will get easier in newer version of the REST Builder plugin...
		// but for now, this is the only game in town.

		serviceContext.setUserId(PrincipalThreadLocal.getUserId());

		return serviceContext;
	}*/

	private String _getMultipleNumbers(String numbers) {
		numbers = numbers.toLowerCase(Locale.ROOT);
		numbers = numbers.replaceAll("\\s+", "");
		numbers = numbers.replaceAll("-", "\n");

		System.out.println(numbers);

		return numbers;
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
	private ServiceContextHelper _serviceContextHelper;

	@Reference
	private UserLocalService _userLocalService;

}