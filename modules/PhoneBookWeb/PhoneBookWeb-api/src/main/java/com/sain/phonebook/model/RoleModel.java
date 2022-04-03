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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Role service. Represents a row in the &quot;PhoneBook_Role&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.sain.phonebook.model.impl.RoleModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.sain.phonebook.model.impl.RoleImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Role
 * @generated
 */
@ProviderType
public interface RoleModel
	extends BaseModel<Role>, GroupedModel, ShardedModel, StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a role model instance should use the {@link Role} interface instead.
	 */

	/**
	 * Returns the primary key of this role.
	 *
	 * @return the primary key of this role
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this role.
	 *
	 * @param primaryKey the primary key of this role
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this role.
	 *
	 * @return the uuid of this role
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this role.
	 *
	 * @param uuid the uuid of this role
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the role ID of this role.
	 *
	 * @return the role ID of this role
	 */
	public long getRoleId();

	/**
	 * Sets the role ID of this role.
	 *
	 * @param roleId the role ID of this role
	 */
	public void setRoleId(long roleId);

	/**
	 * Returns the group ID of this role.
	 *
	 * @return the group ID of this role
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this role.
	 *
	 * @param groupId the group ID of this role
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the department ID of this role.
	 *
	 * @return the department ID of this role
	 */
	public long getDepartmentId();

	/**
	 * Sets the department ID of this role.
	 *
	 * @param departmentId the department ID of this role
	 */
	public void setDepartmentId(long departmentId);

	/**
	 * Returns the company ID of this role.
	 *
	 * @return the company ID of this role
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this role.
	 *
	 * @param companyId the company ID of this role
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this role.
	 *
	 * @return the user ID of this role
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this role.
	 *
	 * @param userId the user ID of this role
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this role.
	 *
	 * @return the user uuid of this role
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this role.
	 *
	 * @param userUuid the user uuid of this role
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this role.
	 *
	 * @return the user name of this role
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this role.
	 *
	 * @param userName the user name of this role
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this role.
	 *
	 * @return the create date of this role
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this role.
	 *
	 * @param createDate the create date of this role
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this role.
	 *
	 * @return the modified date of this role
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this role.
	 *
	 * @param modifiedDate the modified date of this role
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this role.
	 *
	 * @return the name of this role
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this role.
	 *
	 * @param name the name of this role
	 */
	public void setName(String name);

}