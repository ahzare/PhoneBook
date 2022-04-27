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
import com.sain.phonebook.exception.NoSuchPartException;
import com.sain.phonebook.model.Part;
import com.sain.phonebook.service.base.PartLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import static com.liferay.portal.kernel.util.DateUtil.newDate;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.sain.phonebook.model.Part",
	service = AopService.class
)
public class PartLocalServiceImpl extends PartLocalServiceBaseImpl {

	public Part getPart(final long partId) {
		return partPersistence.fetchByPartId(partId);
	}

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public Part addPart(final String name,
						final String internalPhone,
						final long addressId,
						final ServiceContext serviceContext)
			throws PortalException {
		Part part = createPart(counterLocalService.increment(Part.class.getName()));
		part.setPartId(part.getPartId());
		part.setName(name);
		part.setInternalPhone(internalPhone);
        part.setAddressId(addressId);

		Date current = newDate();
		part.setCompanyId(serviceContext.getCompanyId());
		part.setCreateDate(serviceContext.getCreateDate(current));
		part.setGroupId(serviceContext.getScopeGroupId());
		part.setModifiedDate(serviceContext.getModifiedDate(current));
		part.setUserId(serviceContext.getUserId());

		User user = userLocalService.fetchUser(serviceContext.getUserId());
		if (user != null) {
			part.setUserName(user.getFullName());
			part.setUserUuid(user.getUserUuid());
		}
		part = addPart(part);

        /*resourceLocalService.addResources(
                serviceContext.getCompanyId(),
                serviceContext.getScopeGroupId(),
                serviceContext.getUserId(),
                Part.class.getName(),
                part.getPartId(),
                false,
                serviceContext.isAddGroupPermissions(),
                serviceContext.isAddGuestPermissions());*/
		return part;
	}

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public Part updatePart(final long partId,
						   final String name,
						   final String internalPhone,
						   final long addressId,
						   final ServiceContext serviceContext)
			throws PortalException {
// find our instance using the old id
		Part part = fetchPart(partId);
		if (part == null) {
			_log.warn("Failed to find part using id [" + partId + "].");
			throw new NoSuchPartException("Could not find part [" + partId + "].");
		}

// an update means that all fields are going to change to match what we are given.
		Date current = newDate();
		part.setPartId(partId);
		part.setName(name);
		part.setInternalPhone(internalPhone);
        part.setAddressId(addressId);

		part.setModifiedDate(serviceContext.getModifiedDate(current));

		part.setUserId(serviceContext.getUserId());
		User user = userLocalService.fetchUser(serviceContext.getUserId());
		if (user != null) {
			part.setUserName(user.getFullName());
			part.setUserUuid(user.getUserUuid());
		}
		part = updatePart(part);

// good to go
		return part;
	}

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public Part patchPart(final long partId,
						  final String name,
						  final String internalPhone,
						  final long addressId,
						  final ServiceContext serviceContext)
			throws PortalException {
// find our instance using the old id
		Part part = fetchPart(partId);
		boolean changed = false;
		if (part == null) {
			_log.warn("Failed to find part using id [" + partId + "].");
			throw new NoSuchPartException("Could not find part [" + partId + "].");
		}

// a patch means that only provided fields are going to change
// to match what we are given.
		if (name != null) {
			part.setName(name);
			changed = true;
		}
		if (internalPhone != null) {
			part.setInternalPhone(internalPhone);
			changed = true;
		}

        if (addressId != 0 && addressId != part.getAddressId()) {
            part.setAddressId(addressId);
            changed = true;
        }
		if (partId != part.getPartId()) {
			part.setPartId(partId);
			changed = true;
		}

		if (changed) {
			Date current = newDate();
			part.setUserId(serviceContext.getUserId());
			part.setModifiedDate(serviceContext.getModifiedDate(current));
			User user = userLocalService.fetchUser(serviceContext.getUserId());
			if (user != null) {
				part.setUserName(user.getFullName());
				part.setUserUuid(user.getUserUuid());
			}
			part = updatePart(part);
		}
// good to go
		return part;
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public Part deletePart(long partId)
			throws PortalException {
		Part part = fetchPart(partId);
		if (part != null) {
			return deletePart(part);
		}
		return null;
	}

	@Indexable(type = IndexableType.DELETE)
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	@Override
	public Part deletePart(Part part) {
		/*try{
			resourceLocalService.deleteResource(
					part.getCompanyId(),
					Part.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL,
					part.getPartId());
		}catch(PortalException exception){
			_log.warn("Error deleting persisted part permissions: "+
					exception.getMessage(), exception);
		}*/

//        todo: delete part parts and departments

// call the super action method to try the delete.
		return super.deletePart(part);
//        return partLocalService.deletePart(part);
	}

	private static final Logger _log =
			LoggerFactory.getLogger(PartLocalServiceImpl.class);
}