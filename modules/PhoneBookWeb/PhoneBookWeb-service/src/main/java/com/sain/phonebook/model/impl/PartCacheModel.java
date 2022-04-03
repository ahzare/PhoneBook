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

import com.sain.phonebook.model.Part;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Part in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PartCacheModel implements CacheModel<Part>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PartCacheModel)) {
			return false;
		}

		PartCacheModel partCacheModel = (PartCacheModel)object;

		if (partId == partCacheModel.partId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, partId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", partId=");
		sb.append(partId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", addressId=");
		sb.append(addressId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", internalPhone=");
		sb.append(internalPhone);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Part toEntityModel() {
		PartImpl partImpl = new PartImpl();

		if (uuid == null) {
			partImpl.setUuid("");
		}
		else {
			partImpl.setUuid(uuid);
		}

		partImpl.setPartId(partId);
		partImpl.setGroupId(groupId);
		partImpl.setAddressId(addressId);
		partImpl.setCompanyId(companyId);
		partImpl.setUserId(userId);

		if (userName == null) {
			partImpl.setUserName("");
		}
		else {
			partImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			partImpl.setCreateDate(null);
		}
		else {
			partImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			partImpl.setModifiedDate(null);
		}
		else {
			partImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			partImpl.setName("");
		}
		else {
			partImpl.setName(name);
		}

		if (internalPhone == null) {
			partImpl.setInternalPhone("");
		}
		else {
			partImpl.setInternalPhone(internalPhone);
		}

		partImpl.resetOriginalValues();

		return partImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		partId = objectInput.readLong();

		groupId = objectInput.readLong();

		addressId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		internalPhone = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(partId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(addressId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (internalPhone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(internalPhone);
		}
	}

	public String uuid;
	public long partId;
	public long groupId;
	public long addressId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String internalPhone;

}