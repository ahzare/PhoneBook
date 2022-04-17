package com.sain.headless.phonebook.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import com.sain.headless.phonebook.internal.graphql.mutation.v1_0.Mutation;
import com.sain.headless.phonebook.internal.graphql.query.v1_0.Query;
import com.sain.headless.phonebook.resource.v1_0.AddressResource;
import com.sain.headless.phonebook.resource.v1_0.DepartmentResource;
import com.sain.headless.phonebook.resource.v1_0.PartResource;
import com.sain.headless.phonebook.resource.v1_0.PersonResource;
import com.sain.headless.phonebook.resource.v1_0.RoleResource;
import com.sain.headless.phonebook.resource.v1_0.TestResource;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Amir
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setAddressResourceComponentServiceObjects(
			_addressResourceComponentServiceObjects);
		Mutation.setDepartmentResourceComponentServiceObjects(
			_departmentResourceComponentServiceObjects);
		Mutation.setPartResourceComponentServiceObjects(
			_partResourceComponentServiceObjects);
		Mutation.setPersonResourceComponentServiceObjects(
			_personResourceComponentServiceObjects);
		Mutation.setRoleResourceComponentServiceObjects(
			_roleResourceComponentServiceObjects);

		Query.setAddressResourceComponentServiceObjects(
			_addressResourceComponentServiceObjects);
		Query.setDepartmentResourceComponentServiceObjects(
			_departmentResourceComponentServiceObjects);
		Query.setPartResourceComponentServiceObjects(
			_partResourceComponentServiceObjects);
		Query.setPersonResourceComponentServiceObjects(
			_personResourceComponentServiceObjects);
		Query.setRoleResourceComponentServiceObjects(
			_roleResourceComponentServiceObjects);
		Query.setTestResourceComponentServiceObjects(
			_testResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/headless-PhoneBook-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<AddressResource>
		_addressResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<DepartmentResource>
		_departmentResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<PartResource>
		_partResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<PersonResource>
		_personResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<RoleResource>
		_roleResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<TestResource>
		_testResourceComponentServiceObjects;

}