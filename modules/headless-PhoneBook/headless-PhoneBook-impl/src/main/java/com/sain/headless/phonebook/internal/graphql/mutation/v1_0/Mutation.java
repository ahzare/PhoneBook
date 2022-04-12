package com.sain.headless.phonebook.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

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
public class Mutation {

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

	@GraphQLField(description = "Create a new address.")
	public Address createAddress(@GraphQLName("address") Address address)
		throws Exception {

		return _applyComponentServiceObjects(
			_addressResourceComponentServiceObjects,
			this::_populateResourceContext,
			addressResource -> addressResource.postAddress(address));
	}

	@GraphQLField
	public Response createAddressBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_addressResourceComponentServiceObjects,
			this::_populateResourceContext,
			addressResource -> addressResource.postAddressBatch(
				callbackURL, object));
	}

	@GraphQLField(
		description = "Deletes the address and returns a 204 if the operation succeeds."
	)
	public boolean deleteAddress(@GraphQLName("addressId") String addressId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_addressResourceComponentServiceObjects,
			this::_populateResourceContext,
			addressResource -> addressResource.deleteAddress(addressId));

		return true;
	}

	@GraphQLField
	public Response deleteAddressBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_addressResourceComponentServiceObjects,
			this::_populateResourceContext,
			addressResource -> addressResource.deleteAddressBatch(
				callbackURL, object));
	}

	@GraphQLField(
		description = "Replaces the address with the information sent in the request body. Any missing fields are deleted, unless they are required."
	)
	public Address patchAddress(
			@GraphQLName("addressId") String addressId,
			@GraphQLName("address") Address address)
		throws Exception {

		return _applyComponentServiceObjects(
			_addressResourceComponentServiceObjects,
			this::_populateResourceContext,
			addressResource -> addressResource.patchAddress(
				addressId, address));
	}

	@GraphQLField(
		description = "Replaces the address with the information sent in the request body. Any missing fields are deleted, unless they are required."
	)
	public Address updateAddress(
			@GraphQLName("addressId") String addressId,
			@GraphQLName("address") Address address)
		throws Exception {

		return _applyComponentServiceObjects(
			_addressResourceComponentServiceObjects,
			this::_populateResourceContext,
			addressResource -> addressResource.putAddress(addressId, address));
	}

	@GraphQLField
	public Response updateAddressBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_addressResourceComponentServiceObjects,
			this::_populateResourceContext,
			addressResource -> addressResource.putAddressBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Create a new department.")
	public Department createDepartment(
			@GraphQLName("department") Department department)
		throws Exception {

		return _applyComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> departmentResource.postDepartment(
				department));
	}

	@GraphQLField
	public Response createDepartmentBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> departmentResource.postDepartmentBatch(
				callbackURL, object));
	}

	@GraphQLField(
		description = "Deletes the department and returns a 204 if the operation succeeds."
	)
	public boolean deleteDepartment(
			@GraphQLName("departmentId") String departmentId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> departmentResource.deleteDepartment(
				departmentId));

		return true;
	}

	@GraphQLField
	public Response deleteDepartmentBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> departmentResource.deleteDepartmentBatch(
				callbackURL, object));
	}

	@GraphQLField(
		description = "Replaces the department with the information sent in the request body. Any missing fields are deleted, unless they are required."
	)
	public Department patchDepartment(
			@GraphQLName("departmentId") String departmentId,
			@GraphQLName("department") Department department)
		throws Exception {

		return _applyComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> departmentResource.patchDepartment(
				departmentId, department));
	}

	@GraphQLField(
		description = "Replaces the department with the information sent in the request body. Any missing fields are deleted, unless they are required."
	)
	public Department updateDepartment(
			@GraphQLName("departmentId") String departmentId,
			@GraphQLName("department") Department department)
		throws Exception {

		return _applyComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> departmentResource.putDepartment(
				departmentId, department));
	}

	@GraphQLField
	public Response updateDepartmentBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> departmentResource.putDepartmentBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Create a new part.")
	public Part createPart(@GraphQLName("part") Part part) throws Exception {
		return _applyComponentServiceObjects(
			_partResourceComponentServiceObjects,
			this::_populateResourceContext,
			partResource -> partResource.postPart(part));
	}

	@GraphQLField
	public Response createPartBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_partResourceComponentServiceObjects,
			this::_populateResourceContext,
			partResource -> partResource.postPartBatch(callbackURL, object));
	}

	@GraphQLField(
		description = "Deletes the part and returns a 204 if the operation succeeds."
	)
	public boolean deletePart(@GraphQLName("partId") String partId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_partResourceComponentServiceObjects,
			this::_populateResourceContext,
			partResource -> partResource.deletePart(partId));

		return true;
	}

	@GraphQLField
	public Response deletePartBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_partResourceComponentServiceObjects,
			this::_populateResourceContext,
			partResource -> partResource.deletePartBatch(callbackURL, object));
	}

	@GraphQLField(
		description = "Replaces the part with the information sent in the request body. Any missing fields are deleted, unless they are required."
	)
	public Part patchPart(
			@GraphQLName("partId") String partId,
			@GraphQLName("part") Part part)
		throws Exception {

		return _applyComponentServiceObjects(
			_partResourceComponentServiceObjects,
			this::_populateResourceContext,
			partResource -> partResource.patchPart(partId, part));
	}

	@GraphQLField(
		description = "Replaces the part with the information sent in the request body. Any missing fields are deleted, unless they are required."
	)
	public Part updatePart(
			@GraphQLName("partId") String partId,
			@GraphQLName("part") Part part)
		throws Exception {

		return _applyComponentServiceObjects(
			_partResourceComponentServiceObjects,
			this::_populateResourceContext,
			partResource -> partResource.putPart(partId, part));
	}

	@GraphQLField
	public Response updatePartBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_partResourceComponentServiceObjects,
			this::_populateResourceContext,
			partResource -> partResource.putPartBatch(callbackURL, object));
	}

	@GraphQLField(description = "Create a new person.")
	public Person createPerson(
			@GraphQLName("roleId") Long roleId,
			@GraphQLName("departmentId") Long departmentId,
			@GraphQLName("person") Person person)
		throws Exception {

		return _applyComponentServiceObjects(
			_personResourceComponentServiceObjects,
			this::_populateResourceContext,
			personResource -> personResource.postPerson(
				roleId, departmentId, person));
	}

	@GraphQLField
	public Response createPersonBatch(
			@GraphQLName("roleId") Long roleId,
			@GraphQLName("departmentId") Long departmentId,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_personResourceComponentServiceObjects,
			this::_populateResourceContext,
			personResource -> personResource.postPersonBatch(
				roleId, departmentId, callbackURL, object));
	}

	@GraphQLField(
		description = "Deletes the person and returns a 204 if the operation succeeds."
	)
	public boolean deletePerson(@GraphQLName("personId") String personId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_personResourceComponentServiceObjects,
			this::_populateResourceContext,
			personResource -> personResource.deletePerson(personId));

		return true;
	}

	@GraphQLField
	public Response deletePersonBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_personResourceComponentServiceObjects,
			this::_populateResourceContext,
			personResource -> personResource.deletePersonBatch(
				callbackURL, object));
	}

	@GraphQLField(
		description = "Replaces the person with the information sent in the request body. Any missing fields are deleted, unless they are required."
	)
	public Person patchPersonApi(
			@GraphQLName("personId") String personId,
			@GraphQLName("roleId") Long roleId,
			@GraphQLName("departmentId") Long departmentId,
			@GraphQLName("person") Person person)
		throws Exception {

		return _applyComponentServiceObjects(
			_personResourceComponentServiceObjects,
			this::_populateResourceContext,
			personResource -> personResource.patchPersonApi(
				personId, roleId, departmentId, person));
	}

	@GraphQLField(
		description = "Replaces the person with the information sent in the request body. Any missing fields are deleted, unless they are required."
	)
	public Person updatePersonApi(
			@GraphQLName("personId") String personId,
			@GraphQLName("roleId") Long roleId,
			@GraphQLName("departmentId") Long departmentId,
			@GraphQLName("person") Person person)
		throws Exception {

		return _applyComponentServiceObjects(
			_personResourceComponentServiceObjects,
			this::_populateResourceContext,
			personResource -> personResource.putPersonApi(
				personId, roleId, departmentId, person));
	}

	@GraphQLField(description = "Create a new role.")
	public Role createRole(@GraphQLName("role") Role role) throws Exception {
		return _applyComponentServiceObjects(
			_roleResourceComponentServiceObjects,
			this::_populateResourceContext,
			roleResource -> roleResource.postRole(role));
	}

	@GraphQLField
	public Response createRoleBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_roleResourceComponentServiceObjects,
			this::_populateResourceContext,
			roleResource -> roleResource.postRoleBatch(callbackURL, object));
	}

	@GraphQLField(
		description = "Deletes the role and returns a 204 if the operation succeeds."
	)
	public boolean deleteRole(@GraphQLName("roleId") String roleId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_roleResourceComponentServiceObjects,
			this::_populateResourceContext,
			roleResource -> roleResource.deleteRole(roleId));

		return true;
	}

	@GraphQLField
	public Response deleteRoleBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_roleResourceComponentServiceObjects,
			this::_populateResourceContext,
			roleResource -> roleResource.deleteRoleBatch(callbackURL, object));
	}

	@GraphQLField(
		description = "Replaces the role with the information sent in the request body. Any missing fields are deleted, unless they are required."
	)
	public Role patchRole(
			@GraphQLName("roleId") String roleId,
			@GraphQLName("role") Role role)
		throws Exception {

		return _applyComponentServiceObjects(
			_roleResourceComponentServiceObjects,
			this::_populateResourceContext,
			roleResource -> roleResource.patchRole(roleId, role));
	}

	@GraphQLField(
		description = "Replaces the role with the information sent in the request body. Any missing fields are deleted, unless they are required."
	)
	public Role updateRole(
			@GraphQLName("roleId") String roleId,
			@GraphQLName("role") Role role)
		throws Exception {

		return _applyComponentServiceObjects(
			_roleResourceComponentServiceObjects,
			this::_populateResourceContext,
			roleResource -> roleResource.putRole(roleId, role));
	}

	@GraphQLField
	public Response updateRoleBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_roleResourceComponentServiceObjects,
			this::_populateResourceContext,
			roleResource -> roleResource.putRoleBatch(callbackURL, object));
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

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
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
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}