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

package com.sain.phonebook.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.sain.phonebook.model.Person;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Person in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PersonCacheModel implements CacheModel<Person>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PersonCacheModel)) {
			return false;
		}

		PersonCacheModel personCacheModel = (PersonCacheModel)object;

		if (personId == personCacheModel.personId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, personId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", personId=");
		sb.append(personId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", unitId=");
		sb.append(unitId);
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", localPhoneNumber=");
		sb.append(localPhoneNumber);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", faxNumber=");
		sb.append(faxNumber);
		sb.append(", roomNumber=");
		sb.append(roomNumber);
		sb.append(", email=");
		sb.append(email);
		sb.append(", website=");
		sb.append(website);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Person toEntityModel() {
		PersonImpl personImpl = new PersonImpl();

		if (uuid == null) {
			personImpl.setUuid("");
		}
		else {
			personImpl.setUuid(uuid);
		}

		personImpl.setPersonId(personId);
		personImpl.setGroupId(groupId);
		personImpl.setUnitId(unitId);
		personImpl.setRoleId(roleId);
		personImpl.setCompanyId(companyId);
		personImpl.setUserId(userId);

		if (userName == null) {
			personImpl.setUserName("");
		}
		else {
			personImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			personImpl.setCreateDate(null);
		}
		else {
			personImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			personImpl.setModifiedDate(null);
		}
		else {
			personImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (firstName == null) {
			personImpl.setFirstName("");
		}
		else {
			personImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			personImpl.setLastName("");
		}
		else {
			personImpl.setLastName(lastName);
		}

		if (localPhoneNumber == null) {
			personImpl.setLocalPhoneNumber("");
		}
		else {
			personImpl.setLocalPhoneNumber(localPhoneNumber);
		}

		if (phoneNumber == null) {
			personImpl.setPhoneNumber("");
		}
		else {
			personImpl.setPhoneNumber(phoneNumber);
		}

		if (faxNumber == null) {
			personImpl.setFaxNumber("");
		}
		else {
			personImpl.setFaxNumber(faxNumber);
		}

		if (roomNumber == null) {
			personImpl.setRoomNumber("");
		}
		else {
			personImpl.setRoomNumber(roomNumber);
		}

		if (email == null) {
			personImpl.setEmail("");
		}
		else {
			personImpl.setEmail(email);
		}

		if (website == null) {
			personImpl.setWebsite("");
		}
		else {
			personImpl.setWebsite(website);
		}

		personImpl.resetOriginalValues();

		return personImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		personId = objectInput.readLong();

		groupId = objectInput.readLong();

		unitId = objectInput.readLong();

		roleId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		localPhoneNumber = objectInput.readUTF();
		phoneNumber = objectInput.readUTF();
		faxNumber = objectInput.readUTF();
		roomNumber = objectInput.readUTF();
		email = objectInput.readUTF();
		website = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(personId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(unitId);

		objectOutput.writeLong(roleId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (localPhoneNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(localPhoneNumber);
		}

		if (phoneNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phoneNumber);
		}

		if (faxNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(faxNumber);
		}

		if (roomNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(roomNumber);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (website == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(website);
		}
	}

	public String uuid;
	public long personId;
	public long groupId;
	public long unitId;
	public long roleId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String firstName;
	public String lastName;
	public String localPhoneNumber;
	public String phoneNumber;
	public String faxNumber;
	public String roomNumber;
	public String email;
	public String website;

}