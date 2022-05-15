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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.sain.phonebook.model.Person;
import com.sain.phonebook.model.PersonModel;
import com.sain.phonebook.model.PersonSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Person service. Represents a row in the &quot;PhoneBook_Person&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>PersonModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PersonImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonImpl
 * @generated
 */
@JSON(strict = true)
public class PersonModelImpl
	extends BaseModelImpl<Person> implements PersonModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a person model instance should use the <code>Person</code> interface instead.
	 */
	public static final String TABLE_NAME = "PhoneBook_Person";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"personId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"departmentId", Types.BIGINT},
		{"roleId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"firstName", Types.VARCHAR}, {"lastName", Types.VARCHAR},
		{"localPhoneNumber", Types.VARCHAR}, {"phoneNumber", Types.VARCHAR},
		{"faxNumber", Types.VARCHAR}, {"roomNumber", Types.VARCHAR},
		{"email", Types.VARCHAR}, {"website", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("personId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("departmentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("roleId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("firstName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("localPhoneNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("phoneNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("faxNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("roomNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("website", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table PhoneBook_Person (uuid_ VARCHAR(75) null,personId LONG not null primary key,groupId LONG,departmentId LONG,roleId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,firstName VARCHAR(75) null,lastName VARCHAR(75) null,localPhoneNumber VARCHAR(75) null,phoneNumber VARCHAR(75) null,faxNumber VARCHAR(75) null,roomNumber VARCHAR(75) null,email VARCHAR(75) null,website VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table PhoneBook_Person";

	public static final String ORDER_BY_JPQL = " ORDER BY person.firstName ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY PhoneBook_Person.firstName ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DEPARTMENTID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PERSONID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ROLEID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FIRSTNAME_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static Person toModel(PersonSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Person model = new PersonImpl();

		model.setUuid(soapModel.getUuid());
		model.setPersonId(soapModel.getPersonId());
		model.setGroupId(soapModel.getGroupId());
		model.setDepartmentId(soapModel.getDepartmentId());
		model.setRoleId(soapModel.getRoleId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setFirstName(soapModel.getFirstName());
		model.setLastName(soapModel.getLastName());
		model.setLocalPhoneNumber(soapModel.getLocalPhoneNumber());
		model.setPhoneNumber(soapModel.getPhoneNumber());
		model.setFaxNumber(soapModel.getFaxNumber());
		model.setRoomNumber(soapModel.getRoomNumber());
		model.setEmail(soapModel.getEmail());
		model.setWebsite(soapModel.getWebsite());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<Person> toModels(PersonSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Person> models = new ArrayList<Person>(soapModels.length);

		for (PersonSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public PersonModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _personId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPersonId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _personId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Person.class;
	}

	@Override
	public String getModelClassName() {
		return Person.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Person, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Person, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Person, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Person)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Person, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Person, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Person)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Person, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Person, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Person>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Person.class.getClassLoader(), Person.class, ModelWrapper.class);

		try {
			Constructor<Person> constructor =
				(Constructor<Person>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Person, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Person, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Person, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Person, Object>>();
		Map<String, BiConsumer<Person, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Person, ?>>();

		attributeGetterFunctions.put("uuid", Person::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Person, String>)Person::setUuid);
		attributeGetterFunctions.put("personId", Person::getPersonId);
		attributeSetterBiConsumers.put(
			"personId", (BiConsumer<Person, Long>)Person::setPersonId);
		attributeGetterFunctions.put("groupId", Person::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Person, Long>)Person::setGroupId);
		attributeGetterFunctions.put("departmentId", Person::getDepartmentId);
		attributeSetterBiConsumers.put(
			"departmentId", (BiConsumer<Person, Long>)Person::setDepartmentId);
		attributeGetterFunctions.put("roleId", Person::getRoleId);
		attributeSetterBiConsumers.put(
			"roleId", (BiConsumer<Person, Long>)Person::setRoleId);
		attributeGetterFunctions.put("companyId", Person::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Person, Long>)Person::setCompanyId);
		attributeGetterFunctions.put("userId", Person::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Person, Long>)Person::setUserId);
		attributeGetterFunctions.put("userName", Person::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Person, String>)Person::setUserName);
		attributeGetterFunctions.put("createDate", Person::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Person, Date>)Person::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Person::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate", (BiConsumer<Person, Date>)Person::setModifiedDate);
		attributeGetterFunctions.put("firstName", Person::getFirstName);
		attributeSetterBiConsumers.put(
			"firstName", (BiConsumer<Person, String>)Person::setFirstName);
		attributeGetterFunctions.put("lastName", Person::getLastName);
		attributeSetterBiConsumers.put(
			"lastName", (BiConsumer<Person, String>)Person::setLastName);
		attributeGetterFunctions.put(
			"localPhoneNumber", Person::getLocalPhoneNumber);
		attributeSetterBiConsumers.put(
			"localPhoneNumber",
			(BiConsumer<Person, String>)Person::setLocalPhoneNumber);
		attributeGetterFunctions.put("phoneNumber", Person::getPhoneNumber);
		attributeSetterBiConsumers.put(
			"phoneNumber", (BiConsumer<Person, String>)Person::setPhoneNumber);
		attributeGetterFunctions.put("faxNumber", Person::getFaxNumber);
		attributeSetterBiConsumers.put(
			"faxNumber", (BiConsumer<Person, String>)Person::setFaxNumber);
		attributeGetterFunctions.put("roomNumber", Person::getRoomNumber);
		attributeSetterBiConsumers.put(
			"roomNumber", (BiConsumer<Person, String>)Person::setRoomNumber);
		attributeGetterFunctions.put("email", Person::getEmail);
		attributeSetterBiConsumers.put(
			"email", (BiConsumer<Person, String>)Person::setEmail);
		attributeGetterFunctions.put("website", Person::getWebsite);
		attributeSetterBiConsumers.put(
			"website", (BiConsumer<Person, String>)Person::setWebsite);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getPersonId() {
		return _personId;
	}

	@Override
	public void setPersonId(long personId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_personId = personId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalPersonId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("personId"));
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getDepartmentId() {
		return _departmentId;
	}

	@Override
	public void setDepartmentId(long departmentId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_departmentId = departmentId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalDepartmentId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("departmentId"));
	}

	@JSON
	@Override
	public long getRoleId() {
		return _roleId;
	}

	@Override
	public void setRoleId(long roleId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_roleId = roleId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalRoleId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("roleId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return "";
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_firstName = firstName;
	}

	@JSON
	@Override
	public String getLastName() {
		if (_lastName == null) {
			return "";
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lastName = lastName;
	}

	@JSON
	@Override
	public String getLocalPhoneNumber() {
		if (_localPhoneNumber == null) {
			return "";
		}
		else {
			return _localPhoneNumber;
		}
	}

	@Override
	public void setLocalPhoneNumber(String localPhoneNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_localPhoneNumber = localPhoneNumber;
	}

	@JSON
	@Override
	public String getPhoneNumber() {
		if (_phoneNumber == null) {
			return "";
		}
		else {
			return _phoneNumber;
		}
	}

	@Override
	public void setPhoneNumber(String phoneNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_phoneNumber = phoneNumber;
	}

	@JSON
	@Override
	public String getFaxNumber() {
		if (_faxNumber == null) {
			return "";
		}
		else {
			return _faxNumber;
		}
	}

	@Override
	public void setFaxNumber(String faxNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_faxNumber = faxNumber;
	}

	@JSON
	@Override
	public String getRoomNumber() {
		if (_roomNumber == null) {
			return "";
		}
		else {
			return _roomNumber;
		}
	}

	@Override
	public void setRoomNumber(String roomNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_roomNumber = roomNumber;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_email = email;
	}

	@JSON
	@Override
	public String getWebsite() {
		if (_website == null) {
			return "";
		}
		else {
			return _website;
		}
	}

	@Override
	public void setWebsite(String website) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_website = website;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Person.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Person.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Person toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Person>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PersonImpl personImpl = new PersonImpl();

		personImpl.setUuid(getUuid());
		personImpl.setPersonId(getPersonId());
		personImpl.setGroupId(getGroupId());
		personImpl.setDepartmentId(getDepartmentId());
		personImpl.setRoleId(getRoleId());
		personImpl.setCompanyId(getCompanyId());
		personImpl.setUserId(getUserId());
		personImpl.setUserName(getUserName());
		personImpl.setCreateDate(getCreateDate());
		personImpl.setModifiedDate(getModifiedDate());
		personImpl.setFirstName(getFirstName());
		personImpl.setLastName(getLastName());
		personImpl.setLocalPhoneNumber(getLocalPhoneNumber());
		personImpl.setPhoneNumber(getPhoneNumber());
		personImpl.setFaxNumber(getFaxNumber());
		personImpl.setRoomNumber(getRoomNumber());
		personImpl.setEmail(getEmail());
		personImpl.setWebsite(getWebsite());

		personImpl.resetOriginalValues();

		return personImpl;
	}

	@Override
	public int compareTo(Person person) {
		int value = 0;

		value = getFirstName().compareTo(person.getFirstName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Person)) {
			return false;
		}

		Person person = (Person)object;

		long primaryKey = person.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Person> toCacheModel() {
		PersonCacheModel personCacheModel = new PersonCacheModel();

		personCacheModel.uuid = getUuid();

		String uuid = personCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			personCacheModel.uuid = null;
		}

		personCacheModel.personId = getPersonId();

		personCacheModel.groupId = getGroupId();

		personCacheModel.departmentId = getDepartmentId();

		personCacheModel.roleId = getRoleId();

		personCacheModel.companyId = getCompanyId();

		personCacheModel.userId = getUserId();

		personCacheModel.userName = getUserName();

		String userName = personCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			personCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			personCacheModel.createDate = createDate.getTime();
		}
		else {
			personCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			personCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			personCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		personCacheModel.firstName = getFirstName();

		String firstName = personCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			personCacheModel.firstName = null;
		}

		personCacheModel.lastName = getLastName();

		String lastName = personCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			personCacheModel.lastName = null;
		}

		personCacheModel.localPhoneNumber = getLocalPhoneNumber();

		String localPhoneNumber = personCacheModel.localPhoneNumber;

		if ((localPhoneNumber != null) && (localPhoneNumber.length() == 0)) {
			personCacheModel.localPhoneNumber = null;
		}

		personCacheModel.phoneNumber = getPhoneNumber();

		String phoneNumber = personCacheModel.phoneNumber;

		if ((phoneNumber != null) && (phoneNumber.length() == 0)) {
			personCacheModel.phoneNumber = null;
		}

		personCacheModel.faxNumber = getFaxNumber();

		String faxNumber = personCacheModel.faxNumber;

		if ((faxNumber != null) && (faxNumber.length() == 0)) {
			personCacheModel.faxNumber = null;
		}

		personCacheModel.roomNumber = getRoomNumber();

		String roomNumber = personCacheModel.roomNumber;

		if ((roomNumber != null) && (roomNumber.length() == 0)) {
			personCacheModel.roomNumber = null;
		}

		personCacheModel.email = getEmail();

		String email = personCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			personCacheModel.email = null;
		}

		personCacheModel.website = getWebsite();

		String website = personCacheModel.website;

		if ((website != null) && (website.length() == 0)) {
			personCacheModel.website = null;
		}

		return personCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Person, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Person, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Person, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Person)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Person, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Person, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Person, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Person)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Person>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

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
	private boolean _setModifiedDate;
	private String _firstName;
	private String _lastName;
	private String _localPhoneNumber;
	private String _phoneNumber;
	private String _faxNumber;
	private String _roomNumber;
	private String _email;
	private String _website;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Person, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Person)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("personId", _personId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("departmentId", _departmentId);
		_columnOriginalValues.put("roleId", _roleId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("firstName", _firstName);
		_columnOriginalValues.put("lastName", _lastName);
		_columnOriginalValues.put("localPhoneNumber", _localPhoneNumber);
		_columnOriginalValues.put("phoneNumber", _phoneNumber);
		_columnOriginalValues.put("faxNumber", _faxNumber);
		_columnOriginalValues.put("roomNumber", _roomNumber);
		_columnOriginalValues.put("email", _email);
		_columnOriginalValues.put("website", _website);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("personId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("departmentId", 8L);

		columnBitmasks.put("roleId", 16L);

		columnBitmasks.put("companyId", 32L);

		columnBitmasks.put("userId", 64L);

		columnBitmasks.put("userName", 128L);

		columnBitmasks.put("createDate", 256L);

		columnBitmasks.put("modifiedDate", 512L);

		columnBitmasks.put("firstName", 1024L);

		columnBitmasks.put("lastName", 2048L);

		columnBitmasks.put("localPhoneNumber", 4096L);

		columnBitmasks.put("phoneNumber", 8192L);

		columnBitmasks.put("faxNumber", 16384L);

		columnBitmasks.put("roomNumber", 32768L);

		columnBitmasks.put("email", 65536L);

		columnBitmasks.put("website", 131072L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Person _escapedModel;

}