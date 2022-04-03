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
 * This class is a wrapper for {@link Part}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Part
 * @generated
 */
public class PartWrapper
	extends BaseModelWrapper<Part> implements ModelWrapper<Part>, Part {

	public PartWrapper(Part part) {
		super(part);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("partId", getPartId());
		attributes.put("groupId", getGroupId());
		attributes.put("addressId", getAddressId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("internalPhone", getInternalPhone());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long partId = (Long)attributes.get("partId");

		if (partId != null) {
			setPartId(partId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String internalPhone = (String)attributes.get("internalPhone");

		if (internalPhone != null) {
			setInternalPhone(internalPhone);
		}
	}

	/**
	 * Returns the address ID of this part.
	 *
	 * @return the address ID of this part
	 */
	@Override
	public long getAddressId() {
		return model.getAddressId();
	}

	/**
	 * Returns the company ID of this part.
	 *
	 * @return the company ID of this part
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this part.
	 *
	 * @return the create date of this part
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this part.
	 *
	 * @return the group ID of this part
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the internal phone of this part.
	 *
	 * @return the internal phone of this part
	 */
	@Override
	public String getInternalPhone() {
		return model.getInternalPhone();
	}

	/**
	 * Returns the modified date of this part.
	 *
	 * @return the modified date of this part
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this part.
	 *
	 * @return the name of this part
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the part ID of this part.
	 *
	 * @return the part ID of this part
	 */
	@Override
	public long getPartId() {
		return model.getPartId();
	}

	/**
	 * Returns the primary key of this part.
	 *
	 * @return the primary key of this part
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this part.
	 *
	 * @return the user ID of this part
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this part.
	 *
	 * @return the user name of this part
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this part.
	 *
	 * @return the user uuid of this part
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this part.
	 *
	 * @return the uuid of this part
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address ID of this part.
	 *
	 * @param addressId the address ID of this part
	 */
	@Override
	public void setAddressId(long addressId) {
		model.setAddressId(addressId);
	}

	/**
	 * Sets the company ID of this part.
	 *
	 * @param companyId the company ID of this part
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this part.
	 *
	 * @param createDate the create date of this part
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this part.
	 *
	 * @param groupId the group ID of this part
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the internal phone of this part.
	 *
	 * @param internalPhone the internal phone of this part
	 */
	@Override
	public void setInternalPhone(String internalPhone) {
		model.setInternalPhone(internalPhone);
	}

	/**
	 * Sets the modified date of this part.
	 *
	 * @param modifiedDate the modified date of this part
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this part.
	 *
	 * @param name the name of this part
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the part ID of this part.
	 *
	 * @param partId the part ID of this part
	 */
	@Override
	public void setPartId(long partId) {
		model.setPartId(partId);
	}

	/**
	 * Sets the primary key of this part.
	 *
	 * @param primaryKey the primary key of this part
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this part.
	 *
	 * @param userId the user ID of this part
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this part.
	 *
	 * @param userName the user name of this part
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this part.
	 *
	 * @param userUuid the user uuid of this part
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this part.
	 *
	 * @param uuid the uuid of this part
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected PartWrapper wrap(Part part) {
		return new PartWrapper(part);
	}

}