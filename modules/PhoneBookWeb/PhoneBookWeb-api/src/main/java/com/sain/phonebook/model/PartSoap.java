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
 * This class is used by SOAP remote services, specifically {@link com.sain.phonebook.service.http.PartServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PartSoap implements Serializable {

	public static PartSoap toSoapModel(Part model) {
		PartSoap soapModel = new PartSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPartId(model.getPartId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setAddressId(model.getAddressId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setInternalPhone(model.getInternalPhone());

		return soapModel;
	}

	public static PartSoap[] toSoapModels(Part[] models) {
		PartSoap[] soapModels = new PartSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PartSoap[][] toSoapModels(Part[][] models) {
		PartSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PartSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PartSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PartSoap[] toSoapModels(List<Part> models) {
		List<PartSoap> soapModels = new ArrayList<PartSoap>(models.size());

		for (Part model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PartSoap[soapModels.size()]);
	}

	public PartSoap() {
	}

	public long getPrimaryKey() {
		return _partId;
	}

	public void setPrimaryKey(long pk) {
		setPartId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPartId() {
		return _partId;
	}

	public void setPartId(long partId) {
		_partId = partId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getAddressId() {
		return _addressId;
	}

	public void setAddressId(long addressId) {
		_addressId = addressId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getInternalPhone() {
		return _internalPhone;
	}

	public void setInternalPhone(String internalPhone) {
		_internalPhone = internalPhone;
	}

	private String _uuid;
	private long _partId;
	private long _groupId;
	private long _addressId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _internalPhone;

}