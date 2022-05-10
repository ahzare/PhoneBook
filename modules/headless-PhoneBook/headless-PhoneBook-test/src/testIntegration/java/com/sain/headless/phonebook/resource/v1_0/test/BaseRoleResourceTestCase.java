package com.sain.headless.phonebook.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.function.UnsafeTriConsumer;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.search.test.util.SearchTestRule;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import com.sain.headless.phonebook.client.dto.v1_0.Role;
import com.sain.headless.phonebook.client.http.HttpInvoker;
import com.sain.headless.phonebook.client.pagination.Page;
import com.sain.headless.phonebook.client.pagination.Pagination;
import com.sain.headless.phonebook.client.resource.v1_0.RoleResource;
import com.sain.headless.phonebook.client.serdes.v1_0.RoleSerDes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.time.DateUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Amir
 * @generated
 */
@Generated("")
public abstract class BaseRoleResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_roleResource.setContextCompany(testCompany);

		RoleResource.Builder builder = RoleResource.builder();

		roleResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Role role1 = randomRole();

		String json = objectMapper.writeValueAsString(role1);

		Role role2 = RoleSerDes.toDTO(json);

		Assert.assertTrue(equals(role1, role2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Role role = randomRole();

		String json1 = objectMapper.writeValueAsString(role);
		String json2 = RoleSerDes.toJSON(role);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Role role = randomRole();

		role.setName(regex);

		String json = RoleSerDes.toJSON(role);

		Assert.assertFalse(json.contains(regex));

		role = RoleSerDes.toDTO(json);

		Assert.assertEquals(regex, role.getName());
	}

	@Test
	public void testPatchRole() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testPutRole() throws Exception {
		Role postRole = testPutRole_addRole();

		Role randomRole = randomRole();

		Role putRole = roleResource.putRole(postRole.getId(), randomRole);

		assertEquals(randomRole, putRole);
		assertValid(putRole);

		Role getRole = roleResource.getRole(putRole.getId());

		assertEquals(randomRole, getRole);
		assertValid(getRole);
	}

	protected Role testPutRole_addRole() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetRolesPage() throws Exception {
		Page<Role> page = roleResource.getRolesPage(
			testGetRolesPage_getSiteId(), RandomTestUtil.randomString(), null,
			Pagination.of(1, 2), null);

		Assert.assertEquals(0, page.getTotalCount());

		Long siteId = testGetRolesPage_getSiteId();
		Long irrelevantSiteId = testGetRolesPage_getIrrelevantSiteId();

		if (irrelevantSiteId != null) {
			Role irrelevantRole = testGetRolesPage_addRole(
				irrelevantSiteId, randomIrrelevantRole());

			page = roleResource.getRolesPage(
				irrelevantSiteId, null, null, Pagination.of(1, 2), null);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantRole), (List<Role>)page.getItems());
			assertValid(page);
		}

		Role role1 = testGetRolesPage_addRole(siteId, randomRole());

		Role role2 = testGetRolesPage_addRole(siteId, randomRole());

		page = roleResource.getRolesPage(
			siteId, null, null, Pagination.of(1, 2), null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(role1, role2), (List<Role>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetRolesPageWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Long siteId = testGetRolesPage_getSiteId();

		Role role1 = randomRole();

		role1 = testGetRolesPage_addRole(siteId, role1);

		for (EntityField entityField : entityFields) {
			Page<Role> page = roleResource.getRolesPage(
				siteId, null, getFilterString(entityField, "between", role1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(role1), (List<Role>)page.getItems());
		}
	}

	@Test
	public void testGetRolesPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Long siteId = testGetRolesPage_getSiteId();

		Role role1 = testGetRolesPage_addRole(siteId, randomRole());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Role role2 = testGetRolesPage_addRole(siteId, randomRole());

		for (EntityField entityField : entityFields) {
			Page<Role> page = roleResource.getRolesPage(
				siteId, null, getFilterString(entityField, "eq", role1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(role1), (List<Role>)page.getItems());
		}
	}

	@Test
	public void testGetRolesPageWithPagination() throws Exception {
		Long siteId = testGetRolesPage_getSiteId();

		Role role1 = testGetRolesPage_addRole(siteId, randomRole());

		Role role2 = testGetRolesPage_addRole(siteId, randomRole());

		Role role3 = testGetRolesPage_addRole(siteId, randomRole());

		Page<Role> page1 = roleResource.getRolesPage(
			siteId, null, null, Pagination.of(1, 2), null);

		List<Role> roles1 = (List<Role>)page1.getItems();

		Assert.assertEquals(roles1.toString(), 2, roles1.size());

		Page<Role> page2 = roleResource.getRolesPage(
			siteId, null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<Role> roles2 = (List<Role>)page2.getItems();

		Assert.assertEquals(roles2.toString(), 1, roles2.size());

		Page<Role> page3 = roleResource.getRolesPage(
			siteId, null, null, Pagination.of(1, 3), null);

		assertEqualsIgnoringOrder(
			Arrays.asList(role1, role2, role3), (List<Role>)page3.getItems());
	}

	@Test
	public void testGetRolesPageWithSortDateTime() throws Exception {
		testGetRolesPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, role1, role2) -> {
				BeanUtils.setProperty(
					role1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetRolesPageWithSortInteger() throws Exception {
		testGetRolesPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, role1, role2) -> {
				BeanUtils.setProperty(role1, entityField.getName(), 0);
				BeanUtils.setProperty(role2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetRolesPageWithSortString() throws Exception {
		testGetRolesPageWithSort(
			EntityField.Type.STRING,
			(entityField, role1, role2) -> {
				Class<?> clazz = role1.getClass();

				String entityFieldName = entityField.getName();

				Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						role1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						role2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						role1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						role2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						role1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						role2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetRolesPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Role, Role, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Long siteId = testGetRolesPage_getSiteId();

		Role role1 = randomRole();
		Role role2 = randomRole();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, role1, role2);
		}

		role1 = testGetRolesPage_addRole(siteId, role1);

		role2 = testGetRolesPage_addRole(siteId, role2);

		for (EntityField entityField : entityFields) {
			Page<Role> ascPage = roleResource.getRolesPage(
				siteId, null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(role1, role2), (List<Role>)ascPage.getItems());

			Page<Role> descPage = roleResource.getRolesPage(
				siteId, null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(role2, role1), (List<Role>)descPage.getItems());
		}
	}

	protected Role testGetRolesPage_addRole(Long siteId, Role role)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetRolesPage_getSiteId() throws Exception {
		return testGroup.getGroupId();
	}

	protected Long testGetRolesPage_getIrrelevantSiteId() throws Exception {
		return irrelevantGroup.getGroupId();
	}

	@Test
	public void testGraphQLGetRolesPage() throws Exception {
		Long siteId = testGetRolesPage_getSiteId();

		GraphQLField graphQLField = new GraphQLField(
			"roles",
			new HashMap<String, Object>() {
				{
					put("page", 1);
					put("pageSize", 2);

					put("siteKey", "\"" + siteId + "\"");
				}
			},
			new GraphQLField("items", getGraphQLFields()),
			new GraphQLField("page"), new GraphQLField("totalCount"));

		JSONObject rolesJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/roles");

		Assert.assertEquals(0, rolesJSONObject.get("totalCount"));

		Role role1 = testGraphQLRole_addRole();
		Role role2 = testGraphQLRole_addRole();

		rolesJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/roles");

		Assert.assertEquals(2, rolesJSONObject.get("totalCount"));

		assertEqualsIgnoringOrder(
			Arrays.asList(role1, role2),
			Arrays.asList(
				RoleSerDes.toDTOs(rolesJSONObject.getString("items"))));
	}

	@Test
	public void testPostRole() throws Exception {
		Role randomRole = randomRole();

		Role postRole = testPostRole_addRole(randomRole);

		assertEquals(randomRole, postRole);
		assertValid(postRole);
	}

	protected Role testPostRole_addRole(Role role) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteRoleApi() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Role role = testDeleteRoleApi_addRole();

		assertHttpResponseStatusCode(
			204, roleResource.deleteRoleApiHttpResponse(null, role.getId()));

		assertHttpResponseStatusCode(
			404, roleResource.getRoleApiHttpResponse(null, role.getId()));

		assertHttpResponseStatusCode(
			404, roleResource.getRoleApiHttpResponse(null, 0L));
	}

	protected Role testDeleteRoleApi_addRole() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetRoleApi() throws Exception {
		Role postRole = testGetRoleApi_addRole();

		Role getRole = roleResource.getRoleApi(null, postRole.getId());

		assertEquals(postRole, getRole);
		assertValid(getRole);
	}

	protected Role testGetRoleApi_addRole() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetRoleApi() throws Exception {
		Role role = testGraphQLRole_addRole();

		Assert.assertTrue(
			equals(
				role,
				RoleSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"roleApi",
								new HashMap<String, Object>() {
									{
										put(
											"siteKey",
											"\"" + role.getSiteId() + "\"");
										put("roleId", role.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/roleApi"))));
	}

	@Test
	public void testGraphQLGetRoleApiNotFound() throws Exception {
		Long irrelevantRoleId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"roleApi",
						new HashMap<String, Object>() {
							{
								put(
									"siteKey",
									"\"" + irrelevantGroup.getGroupId() + "\"");
								put("roleId", irrelevantRoleId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Role testGraphQLRole_addRole() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Role role1, Role role2) {
		Assert.assertTrue(
			role1 + " does not equal " + role2, equals(role1, role2));
	}

	protected void assertEquals(List<Role> roles1, List<Role> roles2) {
		Assert.assertEquals(roles1.size(), roles2.size());

		for (int i = 0; i < roles1.size(); i++) {
			Role role1 = roles1.get(i);
			Role role2 = roles2.get(i);

			assertEquals(role1, role2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Role> roles1, List<Role> roles2) {

		Assert.assertEquals(roles1.size(), roles2.size());

		for (Role role1 : roles1) {
			boolean contains = false;

			for (Role role2 : roles2) {
				if (equals(role1, role2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(roles2 + " does not contain " + role1, contains);
		}
	}

	protected void assertValid(Role role) throws Exception {
		boolean valid = true;

		if (role.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (role.getName() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Role> page) {
		boolean valid = false;

		java.util.Collection<Role> roles = page.getItems();

		int size = roles.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field :
				getDeclaredFields(
					com.sain.headless.phonebook.dto.v1_0.Role.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(Role role1, Role role2) {
		if (role1 == role2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(role1.getId(), role2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(role1.getName(), role2.getName())) {
					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected Field[] getDeclaredFields(Class clazz) throws Exception {
		Stream<Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_roleResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_roleResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Role role) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(role.getName()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected Role randomRole() throws Exception {
		return new Role() {
			{
				id = RandomTestUtil.randomLong();
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected Role randomIrrelevantRole() throws Exception {
		Role randomIrrelevantRole = randomRole();

		return randomIrrelevantRole;
	}

	protected Role randomPatchRole() throws Exception {
		return randomRole();
	}

	protected RoleResource roleResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final Log _log = LogFactoryUtil.getLog(
		BaseRoleResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.sain.headless.phonebook.resource.v1_0.RoleResource
		_roleResource;

}