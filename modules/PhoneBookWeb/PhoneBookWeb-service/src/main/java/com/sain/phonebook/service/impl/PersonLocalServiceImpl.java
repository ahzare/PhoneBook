/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sain.phonebook.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.sain.phonebook.exception.NoSuchPersonException;
import com.sain.phonebook.model.Person;
import com.sain.phonebook.service.PersonLocalService;
import com.sain.phonebook.service.RoleLocalService;
import com.sain.phonebook.service.base.PersonLocalServiceBaseImpl;

import org.apache.commons.lang.RandomStringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

import static com.liferay.portal.kernel.util.DateUtil.newDate;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.sain.phonebook.model.Person",
        service = AopService.class
)
public class PersonLocalServiceImpl extends PersonLocalServiceBaseImpl {

    public Person getPerson(final long personId){
        return personPersistence.fetchByPersonId(personId);
    }

    @Indexable(type = IndexableType.REINDEX)
    @SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
    public Person addPerson(
                            final String firstName,
                            final String lastName,
                            final String localPhoneNumber,
                            final String phoneNumber,
                            final String faxNumber,
                            final String roomNumber,
                            final String email,
                            final String website,
                            final long departmentId,
                            final long roleId,
                            final ServiceContext serviceContext)
            throws PortalException {
        Person person = createPerson(counterLocalService.increment(Person.class.getName()));
        person.setPersonId(person.getPersonId());
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setLocalPhoneNumber(localPhoneNumber);
        person.setPhoneNumber(phoneNumber);
        person.setFaxNumber(faxNumber);
        person.setRoomNumber(roomNumber);
        person.setEmail(email);
        person.setWebsite(website);
        person.setDepartmentId(departmentId);
        person.setRoleId(roleId);

        Date current = newDate();
        person.setCompanyId(serviceContext.getCompanyId());
        person.setCreateDate(serviceContext.getCreateDate(current));
        person.setGroupId(serviceContext.getScopeGroupId());
        person.setModifiedDate(serviceContext.getModifiedDate(current));
        person.setUserId(serviceContext.getUserId());

        User user = userLocalService.fetchUser(serviceContext.getUserId());
        if (user != null) {
            person.setUserName(user.getFullName());
            person.setUserUuid(user.getUserUuid());
        }
        person = addPerson(person);

        resourceLocalService.addResources(
                serviceContext.getCompanyId(),
                serviceContext.getScopeGroupId(),
                serviceContext.getUserId(),
                Person.class.getName(),
                person.getPersonId(),
                false,
                serviceContext.isAddGroupPermissions(),
                serviceContext.isAddGuestPermissions());
        return person;
    }

    @Indexable(type = IndexableType.REINDEX)
    @SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
    public Person updatePerson(final long personId,
                               final String firstName,
                               final String lastName,
                               final String localPhoneNumber,
                               final String phoneNumber,
                               final String faxNumber,
                               final String roomNumber,
                               final String email,
                               final String website,
                               final long departmentId,
                               final long roleId,
                               final ServiceContext serviceContext)
            throws PortalException {
// find our instance using the old id
        Person person = fetchPerson(personId);
        if (person == null) {
            _log.warn("Failed to find person using id [" + personId + "].");
            throw new NoSuchPersonException("Could not find person [" + personId + "].");
        }

// an update means that all fields are going to change to match what we are given.
        Date current = newDate();
        person.setPersonId(personId);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setLocalPhoneNumber(localPhoneNumber);
        person.setPhoneNumber(phoneNumber);
        person.setFaxNumber(faxNumber);
        person.setRoomNumber(roomNumber);
        person.setEmail(email);
        person.setWebsite(website);
        person.setDepartmentId(departmentId);
        person.setRoleId(roleId);

        person.setModifiedDate(serviceContext.getModifiedDate(current));

        person.setUserId(serviceContext.getUserId());
        User user = userLocalService.fetchUser(serviceContext.getUserId());
        if (user != null) {
            person.setUserName(user.getFullName());
            person.setUserUuid(user.getUserUuid());
        }
        person = updatePerson(person);

// good to go
        return person;
    }

    @Indexable(type = IndexableType.REINDEX)
    @SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
    public Person patchPerson(final long personId,
                                        final String firstName,
                                        final String lastName,
                                        final String localPhoneNumber,
                                        final String phoneNumber,
                                        final String faxNumber,
                                        final String roomNumber,
                                        final String email,
                                        final String website,
                                        final long departmentId,
                                        final long roleId,
                                        final ServiceContext serviceContext)
            throws PortalException {
// find our instance using the old id
        Person person = fetchPerson(personId);
        boolean changed = false;
        if (person == null) {
            _log.warn("Failed to find person using id [" + personId + "].");
            throw new NoSuchPersonException("Could not find person [" + personId + "].");
        }

// a patch means that only provided fields are going to change
// to match what we are given.
        if (firstName != null) {
            person.setFirstName(firstName);
            changed = true;
        }
        if (lastName != null) {
            person.setLastName(lastName);
            changed = true;
        }
        if (localPhoneNumber != null) {
            person.setLastName(localPhoneNumber);
            changed = true;
        }
        if (phoneNumber != null) {
            person.setPhoneNumber(phoneNumber);
            changed = true;
        }
        if (faxNumber != null) {
            person.setFaxNumber(faxNumber);
            changed = true;
        }
        if (roomNumber != null) {
            person.setRoomNumber(roomNumber);
            changed = true;
        }
        if (email != null) {
            person.setEmail(email);
            changed = true;
        }
        if (website != null) {
            person.setWebsite(website);
            changed = true;
        }

        if (departmentId != person.getDepartmentId()) {
            person.setDepartmentId(departmentId);
            changed = true;
        }
        if (roleId != person.getRoleId()) {
            person.setRoleId(roleId);
            changed = true;
        }

        if (changed) {
            Date current = newDate();
            person.setUserId(serviceContext.getUserId());
            person.setModifiedDate(serviceContext.getModifiedDate(current));
            User user = userLocalService.fetchUser(serviceContext.getUserId());
            if (user != null) {
                person.setUserName(user.getFullName());
                person.setUserUuid(user.getUserUuid());
            }
            person = updatePerson(person);
        }
// good to go
        return person;
    }

    @Indexable(type =IndexableType.DELETE)
    @Override
    public Person deletePerson(long personId)
            throws PortalException{
        Person person =fetchPerson(personId);
        if(person !=null){
            return deletePerson(person);
        }
        return null;
    }
    @Indexable(type = IndexableType.DELETE)
    @SystemEvent(type = SystemEventConstants.TYPE_DELETE)
    @Override
    public Person deletePerson(Person person){
        try{
            resourceLocalService.deleteResource(
                    person.getCompanyId(),
                    Person.class.getName(),
                    ResourceConstants.SCOPE_INDIVIDUAL,
                    person.getPersonId());
        }catch(PortalException e){
            _log.warn("Error deleting persisted person permissions: "+
                    e.getMessage(), e);
        }

//        todo: delete person roles and departments

// call the super action method to try the delete.
        return personLocalService.deletePerson(person);
    }

    private static final Logger _log =
            LoggerFactory.getLogger(PersonLocalServiceImpl.class);
}