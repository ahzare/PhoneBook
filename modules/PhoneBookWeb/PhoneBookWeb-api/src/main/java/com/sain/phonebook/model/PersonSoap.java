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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sain.phonebook.service.http.PersonServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PersonSoap implements Serializable {

	public static PersonSoap toSoapModel(Person model) {
		PersonSoap soapModel = new PersonSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPersonId(model.getPersonId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setRoleId(model.getRoleId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setLocalPhoneNumber(model.getLocalPhoneNumber());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setFaxNumber(model.getFaxNumber());
		soapModel.setRoomNumber(model.getRoomNumber());
		soapModel.setEmail(model.getEmail());
		soapModel.setWebsite(model.getWebsite());

		return soapModel;
	}

	public static PersonSoap[] toSoapModels(Person[] models) {
		PersonSoap[] soapModels = new PersonSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PersonSoap[][] toSoapModels(Person[][] models) {
		PersonSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PersonSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PersonSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PersonSoap[] toSoapModels(List<Person> models) {
		List<PersonSoap> soapModels = new ArrayList<PersonSoap>(models.size());

		for (Person model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PersonSoap[soapModels.size()]);
	}

	public PersonSoap() {
	}

	public long getPrimaryKey() {
		return _personId;
	}

	public void setPrimaryKey(long pk) {
		setPersonId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPersonId() {
		return _personId;
	}

	public void setPersonId(long personId) {
		_personId = personId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	public long getRoleId() {
		return _roleId;
	}

	public void setRoleId(long roleId) {
		_roleId = roleId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getLocalPhoneNumber() {
		return _localPhoneNumber;
	}

	public void setLocalPhoneNumber(String localPhoneNumber) {
		_localPhoneNumber = localPhoneNumber;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public String getFaxNumber() {
		return _faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		_faxNumber = faxNumber;
	}

	public String getRoomNumber() {
		return _roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		_roomNumber = roomNumber;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	private String _uuid;
	private long _personId;
	private long _groupId;
	private long _departmentId;
	private long _roleId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _firstName;
	private String _lastName;
	private String _localPhoneNumber;
	private String _phoneNumber;
	private String _faxNumber;
	private String _roomNumber;
	private String _email;
	private String _website;

}