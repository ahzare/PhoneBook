package com.sain.headless.phonebook.internal.resource.v1_0;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Accessor;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import com.sain.headless.phonebook.dto.v1_0.Person;
import com.sain.headless.phonebook.internal.odata.entity.v1_0.PersonEntityModel;
import com.sain.headless.phonebook.resource.v1_0.PersonResource;

import com.sain.phonebook.service.DepartmentService;
import com.sain.phonebook.service.PersonService;
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
import java.util.stream.Collectors;

/**
 * @author Amir
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/person.properties",
        scope = ServiceScope.PROTOTYPE, service = PersonResource.class
)
public class PersonResourceImpl extends BasePersonResourceImpl {
    @Reference
    private Portal _portal;
    @Reference
    private UserLocalService _userLocalService;
    @Reference
    private PersonService _personService;
    @Reference
    private DepartmentService _departmentService;
    @Reference
    private RoleService _roleService;

    private static final Logger _log =
            LoggerFactory.getLogger(PersonResourceImpl.class);

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

    protected Person _toPerson(com.sain.phonebook.model.Person person) throws PortalException {

        return new Person() {{
            id = person.getPersonId();
            firstName = person.getFirstName();
            lastName = person.getLastName();
            localPhoneNumber = person.getLocalPhoneNumber();
            phoneNumber = person.getPhoneNumber();
            faxNumber = person.getFaxNumber();
            roomNumber = person.getRoomNumber();
            email = person.getEmail();
            website = person.getWebsite();
            if (person.getDepartmentId() != 0)
                department = DepartmentResourceImpl._toDepartment(
                        _departmentService.getDepartment(person.getDepartmentId()));
            if (person.getRoleId() != 0)
                role = RoleResourceImpl._toRole(_roleService.getRole(person.getRoleId()));
        }};
		/*return new Person() {{
			creator = CreatorUtil.toCreator(_portal,
					_userLocalService.getUser(pv.getUserId()));
			articleId = pv.getArticleId();
			group = pv.getGroupName();
			description = pv.getDescription();
			id = pv.getSurrogateId();
			name = pv.getName();
			type = _toPersonType(pv.getType());
			attributes = ListUtil.toArray(pv.getAttributes(), VALUE_ACCESSOR);
			chemicalNames = ListUtil.toArray(pv.getChemicalNames(), VALUE_ACCESSOR);
			properties = ListUtil.toArray(pv.getProperties(), VALUE_ACCESSOR);
			risks = ListUtil.toArray(pv.getRisks(), VALUE_ACCESSOR);
			symptoms = ListUtil.toArray(pv.getSymptoms(), VALUE_ACCESSOR);
		}};*/
    }

    private PersonEntityModel _personEntityModel = new PersonEntityModel();

    @Override
    public EntityModel getEntityModel(MultivaluedMap multivaluedMap)
            throws Exception {
        return _personEntityModel;
    }

    @Override
    public Page<Person> getPersonsPage(String search, Long departmentId,
                                       Long roleId, Filter filter,
                                       Pagination pagination, Sort[] sorts)
            throws Exception {
        System.out.println("getPersonsPage");


        /*return SearchUtil.search(
                null,
                booleanQuery -> {
                },
                filter, Person.class, search, pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(
                        Field.ENTRY_CLASS_PK),
                searchContext -> {
                    searchContext.setCompanyId(contextCompany.getCompanyId());
                    searchContext.setGroupIds(new long[] {contextCompany.getGroupId()});
                },
                sorts,
                document -> _toPerson(_personService.getPerson(Long.parseLong(document.get(Field.ENTRY_CLASS_PK)))));
*/

        /*return SearchUtil.search(
              null,
                booleanQuery -> {
                },
                filter, Person.class, search, pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(
                        Field.ENTRY_CLASS_PK),
                searchContext -> {
                    searchContext.setAttribute(Field.NAME, search);
                    searchContext.setCompanyId(contextCompany.getCompanyId());
                    searchContext.setGroupIds(new long[] {contextCompany.getGroupId()});
                },
                sorts,
                document -> _toPerson(
                        _personService.getPerson(
                                Long.parseLong(GetterUtil.getString(document.get(Field.ENTRY_CLASS_PK))))));
*/

       /* if (departmentId != null && departmentId != 0) {
            // get people of specific department
        }
        if (roleId != null && roleId != 0) {
            // get people of specific role
        }*/

        List<com.sain.phonebook.model.Person> persistedPersons = _personService.getAll();
        List<Person> list = new ArrayList<>();

        for (com.sain.phonebook.model.Person persistedPerson : persistedPersons) {
            Person person = _toPerson(persistedPerson);
            if (search != null) {
                if (person.getFirstName().concat(person.getLastName()).contains(search)) {
                    list.add(person);
                }
            } else {
                list.add(person);
            }
            if (departmentId != null && departmentId != 0) {
                if (person.getDepartment() == null || !person.getDepartment().getId().equals(departmentId)) {
                    list.remove(person);
                }
            }
            if (roleId != null && roleId != 0) {
                if (person.getRole() == null || !person.getRole().getId().equals(roleId)) {
                    list.remove(person);
                }
            }
        }

        return Page.of(list);
    }

    @Override
    public void deletePerson(@NotNull Long personId) throws Exception {
        try {
// super easy case, just pass through to the service layer.
            _personService.deletePerson(personId);
        } catch (Exception e) {
            _log.error("Error deleting person: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Person getPerson(@NotNull Long personId) throws Exception {
        try {
// fetch the entity class...
            com.sain.phonebook.model.Person persistedPerson = _personService.getPerson(personId);
            return _toPerson(persistedPerson);
        } catch (Exception e) {
            _log.error("Error getting person [" + personId + "]: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Person postPerson(Long roleId, Long departmentId, Person person) throws Exception {
        System.out.println("postPerson");
        if (_log.isDebugEnabled()) {
            _log.debug("Need to create a new person: %s\n", person.toString());
        }
        _log.warn("hi ali");
        try {

            com.sain.phonebook.model.Person persistedPerson =
                    _personService.addPerson(person.getFirstName(),
                            person.getLastName(),
                            person.getLocalPhoneNumber(),
                            person.getPhoneNumber(),
                            person.getFaxNumber(),
                            person.getRoomNumber(),
                            person.getEmail(),
                            person.getWebsite(),
                            (departmentId != null ? departmentId : 0),
                            (roleId != null ? roleId : 0),
                            _getServiceContext());
            return _toPerson(persistedPerson);
        } catch (Exception e) {
            _log.error("Error creating person: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Person patchPersonApi(@NotNull Long personId, Long roleId,
                                 Long departmentId, Person person)
            throws Exception {
        try {
            com.sain.phonebook.model.Person persistedPerson =
                    _personService.patchPerson(personId,
                            person.getFirstName(),
                            person.getLastName(),
                            person.getLocalPhoneNumber(),
                            person.getPhoneNumber(),
                            person.getFaxNumber(),
                            person.getRoomNumber(),
                            person.getEmail(),
                            person.getWebsite(),
                            (departmentId != null ? departmentId : 0),
                            (roleId != null ? roleId : 0),
                            _getServiceContext());
            return _toPerson(persistedPerson);
        } catch (Exception e) {
            _log.error("Error patching person: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Person putPersonApi(@NotNull Long personId, Long roleId,
                               Long departmentId, Person person) throws Exception {
        try {
            com.sain.phonebook.model.Person persistedPerson =
                    _personService.updatePerson(personId,
                            person.getFirstName(),
                            person.getLastName(),
                            person.getLocalPhoneNumber(),
                            person.getPhoneNumber(),
                            person.getFaxNumber(),
                            person.getRoomNumber(),
                            person.getEmail(),
                            person.getWebsite(),
                            (departmentId != null ? departmentId : 0),
                            (roleId != null ? roleId : 0),
                            _getServiceContext());
            return _toPerson(persistedPerson);
        } catch (Exception e) {
            _log.error("Error putting person: " + e.getMessage(), e);
            throw e;
        }
    }
}