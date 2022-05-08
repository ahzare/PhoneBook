package com.sain.headless.phonebook.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLTypeExtension;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import com.sain.headless.phonebook.dto.v1_0.Address;
import com.sain.headless.phonebook.dto.v1_0.Department;
import com.sain.headless.phonebook.dto.v1_0.Part;
import com.sain.headless.phonebook.dto.v1_0.Person;
import com.sain.headless.phonebook.dto.v1_0.Role;
import com.sain.headless.phonebook.resource.v1_0.AddressResource;
import com.sain.headless.phonebook.resource.v1_0.DepartmentResource;
import com.sain.headless.phonebook.resource.v1_0.PartResource;
import com.sain.headless.phonebook.resource.v1_0.PersonResource;
import com.sain.headless.phonebook.resource.v1_0.RoleResource;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Amir
 * @generated
 */
@Generated("")
public class Query {

	public static void setAddressResourceComponentServiceObjects(
		ComponentServiceObjects<AddressResource>
			addressResourceComponentServiceObjects) {

		_addressResourceComponentServiceObjects =
			addressResourceComponentServiceObjects;
	}

	public static void setDepartmentResourceComponentServiceObjects(
		ComponentServiceObjects<DepartmentResource>
			departmentResourceComponentServiceObjects) {

		_departmentResourceComponentServiceObjects =
			departmentResourceComponentServiceObjects;
	}

	public static void setPartResourceComponentServiceObjects(
		ComponentServiceObjects<PartResource>
			partResourceComponentServiceObjects) {

		_partResourceComponentServiceObjects =
			partResourceComponentServiceObjects;
	}

	public static void setPersonResourceComponentServiceObjects(
		ComponentServiceObjects<PersonResource>
			personResourceComponentServiceObjects) {

		_personResourceComponentServiceObjects =
			personResourceComponentServiceObjects;
	}

	public static void setRoleResourceComponentServiceObjects(
		ComponentServiceObjects<RoleResource>
			roleResourceComponentServiceObjects) {

		_roleResourceComponentServiceObjects =
			roleResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {addresses(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the list of addresses. Results can be paginated, filtered, searched, and sorted."
	)
	public AddressPage addresses(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_addressResourceComponentServiceObjects,
			this::_populateResourceContext,
			addressResource -> new AddressPage(
				addressResource.getAddressesPage(
					search,
					_filterBiFunction.apply(addressResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(addressResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {address(addressId: ___){id, name}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the address via its ID.")
	public Address address(@GraphQLName("addressId") Long addressId)
		throws Exception {

		return _applyComponentServiceObjects(
			_addressResourceComponentServiceObjects,
			this::_populateResourceContext,
			addressResource -> addressResource.getAddress(addressId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {departments(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the list of departments. Results can be paginated, filtered, searched, and sorted."
	)
	public DepartmentPage departments(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> new DepartmentPage(
				departmentResource.getDepartmentsPage(
					search,
					_filterBiFunction.apply(departmentResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(departmentResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {department(departmentId: ___){id, name}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the department via its ID.")
	public Department department(@GraphQLName("departmentId") Long departmentId)
		throws Exception {

		return _applyComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> departmentResource.getDepartment(
				departmentId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {parts(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the list of parts. Results can be paginated, filtered, searched, and sorted."
	)
	public PartPage parts(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_partResourceComponentServiceObjects,
			this::_populateResourceContext,
			partResource -> new PartPage(
				partResource.getPartsPage(
					search, _filterBiFunction.apply(partResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(partResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {part(partId: ___){address, id, internalPhone, name}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the part via its ID.")
	public Part part(@GraphQLName("partId") Long partId) throws Exception {
		return _applyComponentServiceObjects(
			_partResourceComponentServiceObjects,
			this::_populateResourceContext,
			partResource -> partResource.getPart(partId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {persons(departmentId: ___, filter: ___, page: ___, pageSize: ___, roleId: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the list of persons. Results can be paginated, filtered, searched, and sorted."
	)
	public PersonPage persons(
			@GraphQLName("departmentId") Long departmentId,
			@GraphQLName("roleId") Long roleId,
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_personResourceComponentServiceObjects,
			this::_populateResourceContext,
			personResource -> new PersonPage(
				personResource.getPersonsPage(
					departmentId, roleId, search,
					_filterBiFunction.apply(personResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(personResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {person(personId: ___){department, email, faxNumber, firstName, id, lastName, localPhoneNumber, phoneNumber, role, roomNumber, website}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the person via its ID.")
	public Person person(@GraphQLName("personId") Long personId)
		throws Exception {

		return _applyComponentServiceObjects(
			_personResourceComponentServiceObjects,
			this::_populateResourceContext,
			personResource -> personResource.getPerson(personId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {personsExcel(filter: ___, search: ___, sorts: ___){}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves all Persons to excel")
	public Response personsExcel(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_personResourceComponentServiceObjects,
			this::_populateResourceContext,
			personResource -> personResource.getPersonsExcel(
				search, _filterBiFunction.apply(personResource, filterString),
				_sortsBiFunction.apply(personResource, sortsString)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {roles(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the list of roles. Results can be paginated, filtered, searched, and sorted."
	)
	public RolePage roles(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_roleResourceComponentServiceObjects,
			this::_populateResourceContext,
			roleResource -> new RolePage(
				roleResource.getRolesPage(
					search, _filterBiFunction.apply(roleResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(roleResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {role(roleId: ___){id, name}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the role via its ID.")
	public Role role(@GraphQLName("roleId") Long roleId) throws Exception {
		return _applyComponentServiceObjects(
			_roleResourceComponentServiceObjects,
			this::_populateResourceContext,
			roleResource -> roleResource.getRole(roleId));
	}

	@GraphQLTypeExtension(Department.class)
	public class GetPersonsPageTypeExtension {

		public GetPersonsPageTypeExtension(Department department) {
			_department = department;
		}

		@GraphQLField(
			description = "Retrieves the list of persons. Results can be paginated, filtered, searched, and sorted."
		)
		public PersonPage persons(
				@GraphQLName("roleId") Long roleId,
				@GraphQLName("search") String search,
				@GraphQLName("filter") String filterString,
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page,
				@GraphQLName("sort") String sortsString)
			throws Exception {

			return _applyComponentServiceObjects(
				_personResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				personResource -> new PersonPage(
					personResource.getPersonsPage(
						_department.getId(), roleId, search,
						_filterBiFunction.apply(personResource, filterString),
						Pagination.of(page, pageSize),
						_sortsBiFunction.apply(personResource, sortsString))));
		}

		private Department _department;

	}

	@GraphQLName("AddressPage")
	public class AddressPage {

		public AddressPage(Page addressPage) {
			actions = addressPage.getActions();

			items = addressPage.getItems();
			lastPage = addressPage.getLastPage();
			page = addressPage.getPage();
			pageSize = addressPage.getPageSize();
			totalCount = addressPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Address> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("DepartmentPage")
	public class DepartmentPage {

		public DepartmentPage(Page departmentPage) {
			actions = departmentPage.getActions();

			items = departmentPage.getItems();
			lastPage = departmentPage.getLastPage();
			page = departmentPage.getPage();
			pageSize = departmentPage.getPageSize();
			totalCount = departmentPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Department> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("PartPage")
	public class PartPage {

		public PartPage(Page partPage) {
			actions = partPage.getActions();

			items = partPage.getItems();
			lastPage = partPage.getLastPage();
			page = partPage.getPage();
			pageSize = partPage.getPageSize();
			totalCount = partPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Part> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("PersonPage")
	public class PersonPage {

		public PersonPage(Page personPage) {
			actions = personPage.getActions();

			items = personPage.getItems();
			lastPage = personPage.getLastPage();
			page = personPage.getPage();
			pageSize = personPage.getPageSize();
			totalCount = personPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Person> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("RolePage")
	public class RolePage {

		public RolePage(Page rolePage) {
			actions = rolePage.getActions();

			items = rolePage.getItems();
			lastPage = rolePage.getLastPage();
			page = rolePage.getPage();
			pageSize = rolePage.getPageSize();
			totalCount = rolePage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Role> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(AddressResource addressResource)
		throws Exception {

		addressResource.setContextAcceptLanguage(_acceptLanguage);
		addressResource.setContextCompany(_company);
		addressResource.setContextHttpServletRequest(_httpServletRequest);
		addressResource.setContextHttpServletResponse(_httpServletResponse);
		addressResource.setContextUriInfo(_uriInfo);
		addressResource.setContextUser(_user);
		addressResource.setGroupLocalService(_groupLocalService);
		addressResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(DepartmentResource departmentResource)
		throws Exception {

		departmentResource.setContextAcceptLanguage(_acceptLanguage);
		departmentResource.setContextCompany(_company);
		departmentResource.setContextHttpServletRequest(_httpServletRequest);
		departmentResource.setContextHttpServletResponse(_httpServletResponse);
		departmentResource.setContextUriInfo(_uriInfo);
		departmentResource.setContextUser(_user);
		departmentResource.setGroupLocalService(_groupLocalService);
		departmentResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(PartResource partResource)
		throws Exception {

		partResource.setContextAcceptLanguage(_acceptLanguage);
		partResource.setContextCompany(_company);
		partResource.setContextHttpServletRequest(_httpServletRequest);
		partResource.setContextHttpServletResponse(_httpServletResponse);
		partResource.setContextUriInfo(_uriInfo);
		partResource.setContextUser(_user);
		partResource.setGroupLocalService(_groupLocalService);
		partResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(PersonResource personResource)
		throws Exception {

		personResource.setContextAcceptLanguage(_acceptLanguage);
		personResource.setContextCompany(_company);
		personResource.setContextHttpServletRequest(_httpServletRequest);
		personResource.setContextHttpServletResponse(_httpServletResponse);
		personResource.setContextUriInfo(_uriInfo);
		personResource.setContextUser(_user);
		personResource.setGroupLocalService(_groupLocalService);
		personResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(RoleResource roleResource)
		throws Exception {

		roleResource.setContextAcceptLanguage(_acceptLanguage);
		roleResource.setContextCompany(_company);
		roleResource.setContextHttpServletRequest(_httpServletRequest);
		roleResource.setContextHttpServletResponse(_httpServletResponse);
		roleResource.setContextUriInfo(_uriInfo);
		roleResource.setContextUser(_user);
		roleResource.setGroupLocalService(_groupLocalService);
		roleResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<AddressResource>
		_addressResourceComponentServiceObjects;
	private static ComponentServiceObjects<DepartmentResource>
		_departmentResourceComponentServiceObjects;
	private static ComponentServiceObjects<PartResource>
		_partResourceComponentServiceObjects;
	private static ComponentServiceObjects<PersonResource>
		_personResourceComponentServiceObjects;
	private static ComponentServiceObjects<RoleResource>
		_roleResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}