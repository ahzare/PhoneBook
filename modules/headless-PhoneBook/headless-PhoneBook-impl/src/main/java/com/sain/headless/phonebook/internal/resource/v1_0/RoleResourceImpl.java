package com.sain.headless.phonebook.internal.resource.v1_0;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.sain.headless.phonebook.dto.v1_0.Role;
import com.sain.headless.phonebook.resource.v1_0.RoleResource;

import com.sain.phonebook.service.RoleService;
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
        properties = "OSGI-INF/liferay/rest/v1_0/role.properties",
        scope = ServiceScope.PROTOTYPE, service = RoleResource.class
)
public class RoleResourceImpl extends BaseRoleResourceImpl {
    @Reference
    private Portal _portal;
    @Reference
    private UserLocalService _userLocalService;
    @Reference
    private RoleService _roleService;
    private static final Logger _log =
            LoggerFactory.getLogger(RoleResourceImpl.class);

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

    protected static Role _toRole(com.sain.phonebook.model.Role role) throws PortalException {

        return new Role() {{
            id = String.valueOf(role.getRoleId());
            name = role.getName();
        }};
		/*return new Role() {{
			creator = CreatorUtil.toCreator(_portal,
					_userLocalService.getUser(pv.getUserId()));
			articleId = pv.getArticleId();
			group = pv.getGroupName();
			description = pv.getDescription();
			id = pv.getSurrogateId();
			name = pv.getName();
			type = _toRoleType(pv.getType());
			attributes = ListUtil.toArray(pv.getAttributes(), VALUE_ACCESSOR);
			chemicalNames = ListUtil.toArray(pv.getChemicalNames(), VALUE_ACCESSOR);
			properties = ListUtil.toArray(pv.getProperties(), VALUE_ACCESSOR);
			risks = ListUtil.toArray(pv.getRisks(), VALUE_ACCESSOR);
			symptoms = ListUtil.toArray(pv.getSymptoms(), VALUE_ACCESSOR);
		}};*/
    }


	/*private RoleEntityModel _roleEntityModel = new RoleEntityModel();

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap)
			throws Exception {
		return _roleEntityModel;
	}*/

    @Override
    public Page<Role> getRolesPage(String search, Filter filter,
                                   Pagination pagination, Sort[] sorts)
            throws Exception {
        System.out.println("getRolesPage");


       /* return SearchUtil.search(
                null,
                booleanQuery -> {
                },
                filter, Role.class, search, pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(
                        Field.ENTRY_CLASS_PK),
                searchContext -> {
                    searchContext.setCompanyId(contextCompany.getCompanyId());
                    searchContext.setGroupIds(new long[] {contextCompany.getGroupId()});
                },
                sorts,
                document -> _toRole(_persistedRoleService.getPersistedRole(document.get(Field.ENTRY_CLASS_PK))));
*/


       /* return SearchUtil.search(
              null,
                booleanQuery -> {
                },
                filter, Role.class, search, pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(
                        Field.ENTRY_CLASS_PK),
                searchContext -> {
                    searchContext.setAttribute(Field.NAME, search);
                    searchContext.setCompanyId(contextCompany.getCompanyId());
                    searchContext.setGroupIds(new long[] {contextCompany.getGroupId()});
                },
                sorts,
                document -> _toRole(
                        _persistedRoleService.getPersistedRole(
                                GetterUtil.getString(document.get(Field.ENTRY_CLASS_PK)))));*/


       /* List<Role> list = _persistedRoleService.getAll()
                .stream().map(persistedRole -> {
                    try {
                        // adding for search
                        Role role = _toRole(persistedRole);
                        if (search != null) {
                            if (role.getName().contains(search)) {
                                return role;
                            }
                        } else {
                            return role;
                        }

                        //                        return _toRole(persistedRole);
                    } catch (PortalException e) {
                        e.printStackTrace();
                    }
                    return new Role();
                }).collect(Collectors.toList());*/


        List<com.sain.phonebook.model.Role> persistedRoles = _roleService.getAll();
        List<Role> list = new ArrayList<>();

        for (com.sain.phonebook.model.Role persistedRole : persistedRoles) {
            Role role = _toRole(persistedRole);
            if (search != null) {
                if (role.getName().contains(search)) {
                    list.add(role);
                }
            } else {
                list.add(role);
            }
        }

        return Page.of(list);
    }

    @Override
    public void deleteRole(@NotNull String roleId) throws Exception {
        try {
// super easy case, just pass through to the service layer.
            _roleService.deleteRole(Long.parseLong(roleId));
        } catch (Exception e) {
            _log.error("Error deleting role: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Role getRole(@NotNull String roleId) throws Exception {
        try {
// fetch the entity class...
            com.sain.phonebook.model.Role persistedRole = _roleService.getRole(Long.parseLong(roleId));
            return _toRole(persistedRole);
        } catch (Exception e) {
            _log.error("Error getting role [" + roleId + "]: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Role postRole(Role role) throws Exception {
        System.out.println("postRole");
        if (_log.isDebugEnabled()) {
            _log.debug("Need to create a new role: %s\n", role.toString());
        }
        _log.warn("hi ali");
        try {

            com.sain.phonebook.model.Role persistedRole =
                    _roleService.addRole(role.getName(), _getServiceContext());
            return _toRole(persistedRole);
        } catch (Exception e) {
            _log.error("Error creating role: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Role patchRole(@NotNull String roleId, Role role)
            throws Exception {
        try {
            com.sain.phonebook.model.Role persistedRole =
                    _roleService.patchRole(Long.parseLong(roleId), role.getName(),
                            _getServiceContext());
            return _toRole(persistedRole);
        } catch (Exception e) {
            _log.error("Error patching role: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Role putRole(@NotNull String roleId, Role role) throws Exception {
        try {
            com.sain.phonebook.model.Role persistedRole =
                    _roleService.updateRole(Long.parseLong(roleId), role.getName(), _getServiceContext());
            return _toRole(persistedRole);
        } catch (Exception e) {
            _log.error("Error putting role: " + e.getMessage(), e);
            throw e;
        }
    }
}