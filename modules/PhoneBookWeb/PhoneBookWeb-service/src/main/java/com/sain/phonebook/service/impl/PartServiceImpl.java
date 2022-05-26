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
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.service.ServiceContext;

import com.sain.phonebook.constants.PhoneBookConstants;
import com.sain.phonebook.model.Part;
import com.sain.phonebook.service.base.PartServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

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
    @Reference(
            policy = ReferencePolicy.DYNAMIC,
            policyOption = ReferencePolicyOption.GREEDY,
            target = "(model.class.name=com.sain.phonebook.model.Part)"
    )
    private volatile ModelResourcePermission<Part>
            _partModelResourcePermission;

    public Part addPart(
            final String name, final String internalPhone, final long addressId,
            final ServiceContext serviceContext)
            throws PortalException {

        //        ModelResourcePermissionHelper.check(
        //        _partModelResourcePermission, getPermissionChecker(),
        //        serviceContext.getScopeGroupId(), 0, ActionKeys.ADD_ENTRY);

        return partLocalService.addPart(
                name, internalPhone, addressId, serviceContext);
    }

    public Part deletePart(final long partId) throws PortalException {
        Part part = partLocalService.getPart(partId);

        if (part != null) {
            _partModelResourcePermission.check(
                    getPermissionChecker(), partId,
                    ActionKeys.DELETE);
        }
        return partLocalService.deletePart(partId);
    }

    public List<Part> getAll() {
        return partPersistence.findAll();
    }

    public Part getPart(final long partId) throws PortalException {
        Part part = partLocalService.getPart(partId);

        if (part != null) {

            _partModelResourcePermission.check(
                    getPermissionChecker(), part, ActionKeys.VIEW);
        }

        return part;
    }

    public Part patchPart(
            final long id, final String name, final String internalPhone,
            final long addressId, final ServiceContext serviceContext)
            throws PortalException {

        _partModelResourcePermission.check(
                getPermissionChecker(), id,
                ActionKeys.UPDATE);

        return partLocalService.patchPart(
                id, name, internalPhone, addressId, serviceContext);
    }

    public Part updatePart(
            final long id, final String name, final String internalPhone,
            final long addressId, final ServiceContext serviceContext)
            throws PortalException {

        _partModelResourcePermission.check(
                getPermissionChecker(), id,
                ActionKeys.UPDATE);

        return partLocalService.updatePart(
                id, name, internalPhone, addressId, serviceContext);
    }

    private static volatile PortletResourcePermission
            _portletResourcePermission =
            PortletResourcePermissionFactory.getInstance(
                    RoleServiceImpl.class, "_portletResourcePermission",
                    PhoneBookConstants.RESOURCE_NAME);

}