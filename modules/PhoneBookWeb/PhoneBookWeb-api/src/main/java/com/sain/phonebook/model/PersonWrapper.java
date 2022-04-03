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

package com.sain.phonebook.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Person}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Person
 * @generated
 */
public class PersonWrapper
	extends BaseModelWrapper<Person> implements ModelWrapper<Person>, Person {

	public PersonWrapper(Person person) {
		super(person);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("personId", getPersonId());
		attributes.put("groupId", getGroupId());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("roleId", getRoleId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("localPhoneNumber", getLocalPhoneNumber());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("faxNumber", getFaxNumber());
		attributes.put("roomNumber", getRoomNumber());
		attributes.put("email", getEmail());
		attributes.put("website", getWebsite());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long personId = (Long)attributes.get("personId");

		if (personId != null) {
			setPersonId(personId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String localPhoneNumber = (String)attributes.get("localPhoneNumber");

		if (localPhoneNumber != null) {
			setLocalPhoneNumber(localPhoneNumber);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String faxNumber = (String)attributes.get("faxNumber");

		if (faxNumber != null) {
			setFaxNumber(faxNumber);
		}

		String roomNumber = (String)attributes.get("roomNumber");

		if (roomNumber != null) {
			setRoomNumber(roomNumber);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String website = (String)attributes.get("website");

		if (website != null) {
			setWebsite(website);
		}
	}

	/**
	 * Returns the company ID of this person.
	 *
	 * @return the company ID of this person
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this person.
	 *
	 * @return the create date of this person
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the department ID of this person.
	 *
	 * @return the department ID of this person
	 */
	@Override
	public long getDepartmentId() {
		return model.getDepartmentId();
	}

	/**
	 * Returns the email of this person.
	 *
	 * @return the email of this person
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the fax number of this person.
	 *
	 * @return the fax number of this person
	 */
	@Override
	public String getFaxNumber() {
		return model.getFaxNumber();
	}

	/**
	 * Returns the first name of this person.
	 *
	 * @return the first name of this person
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the group ID of this person.
	 *
	 * @return the group ID of this person
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the last name of this person.
	 *
	 * @return the last name of this person
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the local phone number of this person.
	 *
	 * @return the local phone number of this person
	 */
	@Override
	public String getLocalPhoneNumber() {
		return model.getLocalPhoneNumber();
	}

	/**
	 * Returns the modified date of this person.
	 *
	 * @return the modified date of this person
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the person ID of this person.
	 *
	 * @return the person ID of this person
	 */
	@Override
	public long getPersonId() {
		return model.getPersonId();
	}

	/**
	 * Returns the phone number of this person.
	 *
	 * @return the phone number of this person
	 */
	@Override
	public String getPhoneNumber() {
		return model.getPhoneNumber();
	}

	/**
	 * Returns the primary key of this person.
	 *
	 * @return the primary key of this person
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role ID of this person.
	 *
	 * @return the role ID of this person
	 */
	@Override
	public long getRoleId() {
		return model.getRoleId();
	}

	/**
	 * Returns the room number of this person.
	 *
	 * @return the room number of this person
	 */
	@Override
	public String getRoomNumber() {
		return model.getRoomNumber();
	}

	/**
	 * Returns the user ID of this person.
	 *
	 * @return the user ID of this person
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this person.
	 *
	 * @return the user name of this person
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this person.
	 *
	 * @return the user uuid of this person
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this person.
	 *
	 * @return the uuid of this person
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the website of this person.
	 *
	 * @return the website of this person
	 */
	@Override
	public String getWebsite() {
		return model.getWebsite();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this person.
	 *
	 * @param companyId the company ID of this person
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this person.
	 *
	 * @param createDate the create date of this person
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the department ID of this person.
	 *
	 * @param departmentId the department ID of this person
	 */
	@Override
	public void setDepartmentId(long departmentId) {
		model.setDepartmentId(departmentId);
	}

	/**
	 * Sets the email of this person.
	 *
	 * @param email the email of this person
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the fax number of this person.
	 *
	 * @param faxNumber the fax number of this person
	 */
	@Override
	public void setFaxNumber(String faxNumber) {
		model.setFaxNumber(faxNumber);
	}

	/**
	 * Sets the first name of this person.
	 *
	 * @param firstName the first name of this person
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the group ID of this person.
	 *
	 * @param groupId the group ID of this person
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the last name of this person.
	 *
	 * @param lastName the last name of this person
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the local phone number of this person.
	 *
	 * @param localPhoneNumber the local phone number of this person
	 */
	@Override
	public void setLocalPhoneNumber(String localPhoneNumber) {
		model.setLocalPhoneNumber(localPhoneNumber);
	}

	/**
	 * Sets the modified date of this person.
	 *
	 * @param modifiedDate the modified date of this person
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the person ID of this person.
	 *
	 * @param personId the person ID of this person
	 */
	@Override
	public void setPersonId(long personId) {
		model.setPersonId(personId);
	}

	/**
	 * Sets the phone number of this person.
	 *
	 * @param phoneNumber the phone number of this person
	 */
	@Override
	public void setPhoneNumber(String phoneNumber) {
		model.setPhoneNumber(phoneNumber);
	}

	/**
	 * Sets the primary key of this person.
	 *
	 * @param primaryKey the primary key of this person
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role ID of this person.
	 *
	 * @param roleId the role ID of this person
	 */
	@Override
	public void setRoleId(long roleId) {
		model.setRoleId(roleId);
	}

	/**
	 * Sets the room number of this person.
	 *
	 * @param roomNumber the room number of this person
	 */
	@Override
	public void setRoomNumber(String roomNumber) {
		model.setRoomNumber(roomNumber);
	}

	/**
	 * Sets the user ID of this person.
	 *
	 * @param userId the user ID of this person
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this person.
	 *
	 * @param userName the user name of this person
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this person.
	 *
	 * @param userUuid the user uuid of this person
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this person.
	 *
	 * @param uuid the uuid of this person
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the website of this person.
	 *
	 * @param website the website of this person
	 */
	@Override
	public void setWebsite(String website) {
		model.setWebsite(website);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected PersonWrapper wrap(Person person) {
		return new PersonWrapper(person);
	}

}