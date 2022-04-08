create table PhoneBook_Address (
	uuid_ VARCHAR(75) null,
	addressId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null
);

create table PhoneBook_Department (
	uuid_ VARCHAR(75) null,
	departmentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null
);

create table PhoneBook_Part (
	uuid_ VARCHAR(75) null,
	partId LONG not null primary key,
	groupId LONG,
	addressId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	internalPhone VARCHAR(75) null
);

create table PhoneBook_Person (
	uuid_ VARCHAR(75) null,
	personId LONG not null primary key,
	groupId LONG,
	departmentId LONG,
	roleId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	localPhoneNumber VARCHAR(75) null,
	phoneNumber VARCHAR(75) null,
	faxNumber VARCHAR(75) null,
	roomNumber VARCHAR(75) null,
	email VARCHAR(75) null,
	website VARCHAR(75) null
);

create table PhoneBook_Role (
	uuid_ VARCHAR(75) null,
	roleId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null
);