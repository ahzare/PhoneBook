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

import com.sain.phonebook.model.Role;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Role in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RoleCacheModel implements CacheModel<Role>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RoleCacheModel)) {
			return false;
		}

		RoleCacheModel roleCacheModel = (RoleCacheModel)object;

		if (roleId == roleCacheModel.roleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, roleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", unitId=");
		sb.append(unitId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Role toEntityModel() {
		RoleImpl roleImpl = new RoleImpl();

		if (uuid == null) {
			roleImpl.setUuid("");
		}
		else {
			roleImpl.setUuid(uuid);
		}

		roleImpl.setRoleId(roleId);
		roleImpl.setGroupId(groupId);
		roleImpl.setUnitId(unitId);
		roleImpl.setCompanyId(companyId);
		roleImpl.setUserId(userId);

		if (userName == null) {
			roleImpl.setUserName("");
		}
		else {
			roleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			roleImpl.setCreateDate(null);
		}
		else {
			roleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			roleImpl.setModifiedDate(null);
		}
		else {
			roleImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			roleImpl.setName("");
		}
		else {
			roleImpl.setName(name);
		}

		roleImpl.resetOriginalValues();

		return roleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		roleId = objectInput.readLong();

		groupId = objectInput.readLong();

		unitId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(roleId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(unitId);

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
	}

	public String uuid;
	public long roleId;
	public long groupId;
	public long unitId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;

}