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
 * The base model interface for the Person service. Represents a row in the &quot;PhoneBook_Person&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.sain.phonebook.model.impl.PersonModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.sain.phonebook.model.impl.PersonImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Person
 * @generated
 */
@ProviderType
public interface PersonModel
	extends BaseModel<Person>, GroupedModel, ShardedModel, StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a person model instance should use the {@link Person} interface instead.
	 */

	/**
	 * Returns the primary key of this person.
	 *
	 * @return the primary key of this person
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this person.
	 *
	 * @param primaryKey the primary key of this person
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this person.
	 *
	 * @return the uuid of this person
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this person.
	 *
	 * @param uuid the uuid of this person
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the person ID of this person.
	 *
	 * @return the person ID of this person
	 */
	public long getPersonId();

	/**
	 * Sets the person ID of this person.
	 *
	 * @param personId the person ID of this person
	 */
	public void setPersonId(long personId);

	/**
	 * Returns the group ID of this person.
	 *
	 * @return the group ID of this person
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this person.
	 *
	 * @param groupId the group ID of this person
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the unit ID of this person.
	 *
	 * @return the unit ID of this person
	 */
	public long getUnitId();

	/**
	 * Sets the unit ID of this person.
	 *
	 * @param unitId the unit ID of this person
	 */
	public void setUnitId(long unitId);

	/**
	 * Returns the role ID of this person.
	 *
	 * @return the role ID of this person
	 */
	public long getRoleId();

	/**
	 * Sets the role ID of this person.
	 *
	 * @param roleId the role ID of this person
	 */
	public void setRoleId(long roleId);

	/**
	 * Returns the company ID of this person.
	 *
	 * @return the company ID of this person
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this person.
	 *
	 * @param companyId the company ID of this person
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this person.
	 *
	 * @return the user ID of this person
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this person.
	 *
	 * @param userId the user ID of this person
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this person.
	 *
	 * @return the user uuid of this person
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this person.
	 *
	 * @param userUuid the user uuid of this person
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this person.
	 *
	 * @return the user name of this person
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this person.
	 *
	 * @param userName the user name of this person
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this person.
	 *
	 * @return the create date of this person
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this person.
	 *
	 * @param createDate the create date of this person
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this person.
	 *
	 * @return the modified date of this person
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this person.
	 *
	 * @param modifiedDate the modified date of this person
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the first name of this person.
	 *
	 * @return the first name of this person
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this person.
	 *
	 * @param firstName the first name of this person
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the last name of this person.
	 *
	 * @return the last name of this person
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this person.
	 *
	 * @param lastName the last name of this person
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the local phone number of this person.
	 *
	 * @return the local phone number of this person
	 */
	@AutoEscape
	public String getLocalPhoneNumber();

	/**
	 * Sets the local phone number of this person.
	 *
	 * @param localPhoneNumber the local phone number of this person
	 */
	public void setLocalPhoneNumber(String localPhoneNumber);

	/**
	 * Returns the phone number of this person.
	 *
	 * @return the phone number of this person
	 */
	@AutoEscape
	public String getPhoneNumber();

	/**
	 * Sets the phone number of this person.
	 *
	 * @param phoneNumber the phone number of this person
	 */
	public void setPhoneNumber(String phoneNumber);

	/**
	 * Returns the fax number of this person.
	 *
	 * @return the fax number of this person
	 */
	@AutoEscape
	public String getFaxNumber();

	/**
	 * Sets the fax number of this person.
	 *
	 * @param faxNumber the fax number of this person
	 */
	public void setFaxNumber(String faxNumber);

	/**
	 * Returns the room number of this person.
	 *
	 * @return the room number of this person
	 */
	@AutoEscape
	public String getRoomNumber();

	/**
	 * Sets the room number of this person.
	 *
	 * @param roomNumber the room number of this person
	 */
	public void setRoomNumber(String roomNumber);

	/**
	 * Returns the email of this person.
	 *
	 * @return the email of this person
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this person.
	 *
	 * @param email the email of this person
	 */
	public void setEmail(String email);

	/**
	 * Returns the website of this person.
	 *
	 * @return the website of this person
	 */
	@AutoEscape
	public String getWebsite();

	/**
	 * Sets the website of this person.
	 *
	 * @param website the website of this person
	 */
	public void setWebsite(String website);

}