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
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import com.sain.phonebook.model.Part;
import com.sain.phonebook.service.base.PartServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = {
                "json.web.service.context.name=phonebook",
                "json.web.service.context.path=Part"
        },
        service = AopService.class
)
public class PartServiceImpl extends PartServiceBaseImpl {
	/*@Reference(
			policy = ReferencePolicy.DYNAMIC,
			policyOption= ReferencePolicyOption.GREEDY,
			target ="(model.class.name=com.sain.phonebook.model.Part)"
	)
	private volatile ModelResourcePermission<Part>
			_partModelResourcePermission;*/

    public Part getPart(final long partId) throws PortalException {
        Part part = partLocalService.getPart(partId);
//        _partModelResourcePermission.check(getPermissionChecker(), part, ActionKeys.VIEW);
        return part;
    }

    public Part addPart(final String name,
                        final String internalPhone,
                        final long addressId, final ServiceContext serviceContext) throws PortalException {
//        ModelResourcePermissionHelper.check(_partModelResourcePermission, getPermissionChecker(),
//        serviceContext.getScopeGroupId(), 0, ActionKeys.ADD_ENTRY);
        return partLocalService.addPart(name, internalPhone, addressId, serviceContext);
    }

    public Part updatePart(final long id,
                           final String name,
                           final String internalPhone,
                           final long addressId, final ServiceContext serviceContext) throws PortalException {
//        _partModelResourcePermission.check(getPermissionChecker(), partLocalService.getPart(oldId), ActionKeys.UPDATE);
        return partLocalService.updatePart(id, name, internalPhone, addressId, serviceContext);
    }

    public Part patchPart(final long id,
                          final String name,
                          final String internalPhone,
                          final long addressId, final ServiceContext serviceContext)
            throws PortalException {
//        _partModelResourcePermission.check(getPermissionChecker(), partLocalService.getPart(oldId), ActionKeys.UPDATE);
        return partLocalService.patchPart(id, name, internalPhone, addressId, serviceContext);
    }

    public void deletePart(final long partId)
            throws PortalException {
//        _partModelResourcePermission.check(getPermissionChecker(), partLocalService.getPart(partId), ActionKeys.DELETE);
        partLocalService.deletePart(partId);
    }

    public List<Part> getAll() {
        return partPersistence.findAll();
    }

    private static final Logger _log =
            LoggerFactory.getLogger(PartServiceImpl.class);

}