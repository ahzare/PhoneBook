create index IX_89DEEB26 on PhoneBook_Address (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_88540328 on PhoneBook_Address (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_3979D05F on PhoneBook_Department (name[$COLUMN_LENGTH:300$]);
create index IX_13FE1294 on PhoneBook_Department (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_59522E16 on PhoneBook_Department (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_C0B47A7E on PhoneBook_Part (addressId);
create index IX_D1523EB5 on PhoneBook_Part (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_CC54EE77 on PhoneBook_Part (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_7A4D7164 on PhoneBook_Person (departmentId);
create index IX_12CF2C48 on PhoneBook_Person (roleId);
create index IX_6598F17 on PhoneBook_Person (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_7258EF59 on PhoneBook_Person (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_93C84F83 on PhoneBook_Role (name[$COLUMN_LENGTH:300$]);
create index IX_F3F2FBB8 on PhoneBook_Role (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_EF7103A on PhoneBook_Role (uuid_[$COLUMN_LENGTH:75$], groupId);