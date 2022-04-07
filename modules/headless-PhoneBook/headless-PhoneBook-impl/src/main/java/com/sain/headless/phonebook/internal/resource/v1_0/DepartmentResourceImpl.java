package com.sain.headless.phonebook.internal.resource.v1_0;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.sain.headless.phonebook.dto.v1_0.Department;
import com.sain.headless.phonebook.internal.odata.entity.v1_0.DepartmentEntityModel;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.sain.headless.phonebook.resource.v1_0.DepartmentResource;

import com.sain.phonebook.service.DepartmentService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MultivaluedMap;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amir
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/department.properties",
        scope = ServiceScope.PROTOTYPE, service = DepartmentResource.class
)
public class DepartmentResourceImpl extends BaseDepartmentResourceImpl {
    @Reference
    private Portal _portal;
    @Reference
    private UserLocalService _userLocalService;
    @Reference
    private DepartmentService _departmentService;
    private static final Logger _log =
            LoggerFactory.getLogger(DepartmentResourceImpl.class);

    protected ServiceContext _getServiceContext() throws PortalException {
        ServiceContext serviceContext =
                new ServiceContext();
        serviceContext.setCompanyId(contextCompany.getCompanyId());
// need the current user in the service context.
// will get easier in newer version of the REST Builder plugin...
// but for now, this is the only game in town.
        long userId = PrincipalThreadLocal.getUserId();
        serviceContext.setUserId(userId);
        return serviceContext;
    }

    protected Department _toDepartment(com.sain.phonebook.model.Department department) throws PortalException {

        return new Department() {{
            id = String.valueOf(department.getDepartmentId());
            name = department.getName();
        }};
		/*return new Department() {{
			creator = CreatorUtil.toCreator(_portal,
					_userLocalService.getUser(pv.getUserId()));
			articleId = pv.getArticleId();
			group = pv.getGroupName();
			description = pv.getDescription();
			id = pv.getSurrogateId();
			name = pv.getName();
			type = _toDepartmentType(pv.getType());
			attributes = ListUtil.toArray(pv.getAttributes(), VALUE_ACCESSOR);
			chemicalNames = ListUtil.toArray(pv.getChemicalNames(), VALUE_ACCESSOR);
			properties = ListUtil.toArray(pv.getProperties(), VALUE_ACCESSOR);
			risks = ListUtil.toArray(pv.getRisks(), VALUE_ACCESSOR);
			symptoms = ListUtil.toArray(pv.getSymptoms(), VALUE_ACCESSOR);
		}};*/
    }


    private DepartmentEntityModel _departmentEntityModel = new DepartmentEntityModel();

    @Override
    public EntityModel getEntityModel(MultivaluedMap multivaluedMap)
            throws Exception {
        return _departmentEntityModel;
    }

    @Override
    public Page<Department> getDepartmentsPage(String search, Filter filter,
                                               Pagination pagination, Sort[] sorts)
            throws Exception {
        System.out.println("getDepartmentsPage");


       /* return SearchUtil.search(
                null,
                booleanQuery -> {
                },
                filter, Department.class, search, pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(
                        Field.ENTRY_CLASS_PK),
                searchContext -> {
                    searchContext.setCompanyId(contextCompany.getCompanyId());
                    searchContext.setGroupIds(new long[] {contextCompany.getGroupId()});
                },
                sorts,
                document -> _toDepartment(_persistedDepartmentService.getPersistedDepartment(document.get(Field.ENTRY_CLASS_PK))));
*/


       /* return SearchUtil.search(
              null,
                booleanQuery -> {
                },
                filter, Department.class, search, pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(
                        Field.ENTRY_CLASS_PK),
                searchContext -> {
                    searchContext.setAttribute(Field.NAME, search);
                    searchContext.setCompanyId(contextCompany.getCompanyId());
                    searchContext.setGroupIds(new long[] {contextCompany.getGroupId()});
                },
                sorts,
                document -> _toDepartment(
                        _persistedDepartmentService.getPersistedDepartment(
                                GetterUtil.getString(document.get(Field.ENTRY_CLASS_PK)))));*/


       /* List<Department> list = _persistedDepartmentService.getAll()
                .stream().map(persistedDepartment -> {
                    try {
                        // adding for search
                        Department department = _toDepartment(persistedDepartment);
                        if (search != null) {
                            if (department.getName().contains(search)) {
                                return department;
                            }
                        } else {
                            return department;
                        }

                        //                        return _toDepartment(persistedDepartment);
                    } catch (PortalException e) {
                        e.printStackTrace();
                    }
                    return new Department();
                }).collect(Collectors.toList());*/


        List<com.sain.phonebook.model.Department> persistedDepartments = _departmentService.getAll();
        List<Department> list = new ArrayList<>();

        for (com.sain.phonebook.model.Department persistedDepartment : persistedDepartments) {
            Department department = _toDepartment(persistedDepartment);
            if (search != null) {
                if (department.getName().contains(search)) {
                    list.add(department);
                }
            } else {
                list.add(department);
            }
        }

        return Page.of(list);
    }

    @Override
    public void deleteDepartment(@NotNull String departmentId) throws Exception {
        try {
// super easy case, just pass through to the service layer.
            _departmentService.deleteDepartment(Long.parseLong(departmentId));
        } catch (Exception e) {
            _log.error("Error deleting department: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Department getDepartment(@NotNull String departmentId) throws Exception {
        try {
// fetch the entity class...
            com.sain.phonebook.model.Department persistedDepartment = _departmentService.getDepartment(Long.parseLong(departmentId));
            return _toDepartment(persistedDepartment);
        } catch (Exception e) {
            _log.error("Error getting department [" + departmentId + "]: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Department postDepartment(Department department) throws Exception {
        System.out.println("postDepartment");
        if (_log.isDebugEnabled()) {
            _log.debug("Need to create a new department: %s\n", department.toString());
        }
        _log.warn("hi ali");
        try {

            com.sain.phonebook.model.Department persistedDepartment = _departmentService.addDepartment(department.getName(), _getServiceContext());
            return _toDepartment(persistedDepartment);
        } catch (Exception e) {
            _log.error("Error creating department: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Department patchDepartment(@NotNull String departmentId, Department department)
            throws Exception {
        try {
            com.sain.phonebook.model.Department persistedDepartment =
                    _departmentService.patchDepartment(Long.parseLong(departmentId), department.getName(), _getServiceContext());
            return _toDepartment(persistedDepartment);
        } catch (Exception e) {
            _log.error("Error patching department: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Department putDepartment(@NotNull String departmentId, Department department) throws Exception {
        try {
            com.sain.phonebook.model.Department persistedDepartment =
                    _departmentService.updateDepartment(Long.parseLong(departmentId), department.getName(), _getServiceContext());
            return _toDepartment(persistedDepartment);
        } catch (Exception e) {
            _log.error("Error putting department: " + e.getMessage(), e);
            throw e;
        }
    }
}