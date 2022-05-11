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

package com.sain.headless.phonebook.internal.resource.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import com.liferay.portal.vulcan.util.SearchUtil;
import com.sain.headless.phonebook.dto.v1_0.Department;
import com.sain.headless.phonebook.dto.v1_0.Person;
import com.sain.headless.phonebook.resource.v1_0.DepartmentResource;
import com.sain.headless.phonebook.util.ServiceContextHelper;
import com.sain.phonebook.service.DepartmentService;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Amir
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/department.properties",
        scope = ServiceScope.PROTOTYPE, service = DepartmentResource.class
)
public class DepartmentResourceImpl extends BaseDepartmentResourceImpl {

    @Override
    public Department deleteDepartmentApi(Long siteId, Long departmentId)
            throws Exception {
        return toDepartment(_departmentService.deleteDepartment(departmentId));
    }

    @Override
    public Department getDepartmentApi( Long departmentId)
            throws Exception {

        try {

            // fetch the entity class...

            com.sain.phonebook.model.Department persistedDepartment =
                    _departmentService.getDepartment(departmentId);

            if (persistedDepartment != null) {
                return toDepartment(persistedDepartment);
            } else {
                return null;
            }
        } catch (Exception exception) {
            _log.error(
                    "Error getting department [" + departmentId + "]: " +
                            exception.getMessage(),
                    exception);

            throw exception;
        }
    }

    @Override
    public Page<Department> getDepartmentsPage(
            Long siteId, String search, Filter filter, Pagination pagination,
            Sort[] sorts)
            throws Exception {

        System.out.println("getDepartmentsPage");

        Page<Department> departmentPage = SearchUtil.search(
                booleanQuery -> booleanQuery.getPreBooleanFilter(), filter,
                com.sain.phonebook.model.Department.class, search, pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(
                        Field.ENTRY_CLASS_PK),
                new UnsafeConsumer() {

                    public void accept(Object object) throws Exception {
                        SearchContext searchContext = (SearchContext) object;

                        searchContext.setCompanyId(contextCompany.getCompanyId());
                    }

                },
                document -> toDepartment(
                        _departmentService.getDepartment(
                                GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)))),
                sorts);

        System.out.println("department page = " + departmentPage);

        return departmentPage;
    }

	/*@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap)
		throws Exception {

		return _departmentEntityModel;
	}*/

    @Override
    public Department patchDepartment(
            @NotNull Long departmentId, Department department)
            throws Exception {

        com.sain.phonebook.model.Department persistedDepartment1 =
                _departmentService.getDepartment(departmentId);

        if (persistedDepartment1 != null) {
            try {
                com.sain.phonebook.model.Department persistedDepartment =
                        _departmentService.patchDepartment(
                                departmentId, department.getName(),
                                _serviceContextHelper.getServiceContext(
                                        persistedDepartment1.getGroupId()));

                return toDepartment(persistedDepartment);
            } catch (Exception exception) {
                _log.error(
                        "Error patching department: " + exception.getMessage(),
                        exception);

                throw exception;
            }
        } else {
            return null;
        }
    }

    @Override
    public Department postDepartment(Long siteId, Department department)
            throws Exception {

        System.out.println("postDepartment");

        if (_log.isDebugEnabled()) {
            _log.debug(
                    "Need to create a new department: %s\n", department.toString());
        }

        try {
            com.sain.phonebook.model.Department persistedDepartment =
                    _departmentService.addDepartment(
                            department.getName(),
                            _serviceContextHelper.getServiceContext(siteId));

            return toDepartment(persistedDepartment);
        } catch (Exception exception) {
            _log.error(
                    "Error creating department: " + exception.getMessage(),
                    exception);

            throw exception;
        }
    }

    @Override
    public Department putDepartment(
            @NotNull Long departmentId, Department department)
            throws Exception {

        com.sain.phonebook.model.Department persistedDepartment1 =
                _departmentService.getDepartment(departmentId);

        if (persistedDepartment1 != null) {
            try {
                com.sain.phonebook.model.Department persistedDepartment =
                        _departmentService.updateDepartment(
                                departmentId, department.getName(),
                                _serviceContextHelper.getServiceContext(
                                        persistedDepartment1.getGroupId()));

                return toDepartment(persistedDepartment);
            } catch (Exception exception) {
                _log.error(
                        "Error putting department: " + exception.getMessage(),
                        exception);

                throw exception;
            }
        } else {
            return null;
        }
    }

    protected static Department toDepartment(
            com.sain.phonebook.model.Department department)
            throws PortalException {

        return new Department() {
            {
                id = department.getDepartmentId();
                name = department.getName();
            }
        };
    }

    private static final Logger _log = LoggerFactory.getLogger(
            DepartmentResourceImpl.class);

    @Reference
    private DepartmentService _departmentService;

    @Reference
    private Portal _portal;

    @Reference
    private UserLocalService _userLocalService;

    @Reference
    private ServiceContextHelper _serviceContextHelper;
}