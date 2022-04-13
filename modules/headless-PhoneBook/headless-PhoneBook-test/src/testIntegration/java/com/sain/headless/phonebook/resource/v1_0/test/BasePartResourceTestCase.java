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
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.search.test.util.SearchTestRule;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import com.sain.headless.phonebook.client.dto.v1_0.Part;
import com.sain.headless.phonebook.client.http.HttpInvoker;
import com.sain.headless.phonebook.client.pagination.Page;
import com.sain.headless.phonebook.client.pagination.Pagination;
import com.sain.headless.phonebook.client.resource.v1_0.PartResource;
import com.sain.headless.phonebook.client.serdes.v1_0.PartSerDes;

import java.lang.reflect.InvocationTargetException;

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
public abstract class BasePartResourceTestCase {

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

		_partResource.setContextCompany(testCompany);

		PartResource.Builder builder = PartResource.builder();

		partResource = builder.authentication(
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

		Part part1 = randomPart();

		String json = objectMapper.writeValueAsString(part1);

		Part part2 = PartSerDes.toDTO(json);

		Assert.assertTrue(equals(part1, part2));
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

		Part part = randomPart();

		String json1 = objectMapper.writeValueAsString(part);
		String json2 = PartSerDes.toJSON(part);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Part part = randomPart();

		part.setInternalPhone(regex);
		part.setName(regex);

		String json = PartSerDes.toJSON(part);

		Assert.assertFalse(json.contains(regex));

		part = PartSerDes.toDTO(json);

		Assert.assertEquals(regex, part.getInternalPhone());
		Assert.assertEquals(regex, part.getName());
	}

	@Test
	public void testGetPartPage() throws Exception {
		Page<Part> page = partResource.getPartPage(
			null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Part part1 = testGetPartPage_addPart(randomPart());

		Part part2 = testGetPartPage_addPart(randomPart());

		page = partResource.getPartPage(null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(part1, (List<Part>)page.getItems());
		assertContains(part2, (List<Part>)page.getItems());
		assertValid(page);

		partResource.deletePart(part1.getId());

		partResource.deletePart(part2.getId());
	}

	@Test
	public void testGetPartPageWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Part part1 = randomPart();

		part1 = testGetPartPage_addPart(part1);

		for (EntityField entityField : entityFields) {
			Page<Part> page = partResource.getPartPage(
				null, getFilterString(entityField, "between", part1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(part1), (List<Part>)page.getItems());
		}
	}

	@Test
	public void testGetPartPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Part part1 = testGetPartPage_addPart(randomPart());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Part part2 = testGetPartPage_addPart(randomPart());

		for (EntityField entityField : entityFields) {
			Page<Part> page = partResource.getPartPage(
				null, getFilterString(entityField, "eq", part1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(part1), (List<Part>)page.getItems());
		}
	}

	@Test
	public void testGetPartPageWithPagination() throws Exception {
		Page<Part> totalPage = partResource.getPartPage(null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Part part1 = testGetPartPage_addPart(randomPart());

		Part part2 = testGetPartPage_addPart(randomPart());

		Part part3 = testGetPartPage_addPart(randomPart());

		Page<Part> page1 = partResource.getPartPage(
			null, null, Pagination.of(1, totalCount + 2), null);

		List<Part> parts1 = (List<Part>)page1.getItems();

		Assert.assertEquals(parts1.toString(), totalCount + 2, parts1.size());

		Page<Part> page2 = partResource.getPartPage(
			null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Part> parts2 = (List<Part>)page2.getItems();

		Assert.assertEquals(parts2.toString(), 1, parts2.size());

		Page<Part> page3 = partResource.getPartPage(
			null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(part1, (List<Part>)page3.getItems());
		assertContains(part2, (List<Part>)page3.getItems());
		assertContains(part3, (List<Part>)page3.getItems());
	}

	@Test
	public void testGetPartPageWithSortDateTime() throws Exception {
		testGetPartPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, part1, part2) -> {
				BeanUtils.setProperty(
					part1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetPartPageWithSortInteger() throws Exception {
		testGetPartPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, part1, part2) -> {
				BeanUtils.setProperty(part1, entityField.getName(), 0);
				BeanUtils.setProperty(part2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetPartPageWithSortString() throws Exception {
		testGetPartPageWithSort(
			EntityField.Type.STRING,
			(entityField, part1, part2) -> {
				Class<?> clazz = part1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						part1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						part2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						part1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						part2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						part1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						part2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetPartPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Part, Part, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Part part1 = randomPart();
		Part part2 = randomPart();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, part1, part2);
		}

		part1 = testGetPartPage_addPart(part1);

		part2 = testGetPartPage_addPart(part2);

		for (EntityField entityField : entityFields) {
			Page<Part> ascPage = partResource.getPartPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(part1, part2), (List<Part>)ascPage.getItems());

			Page<Part> descPage = partResource.getPartPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(part2, part1), (List<Part>)descPage.getItems());
		}
	}

	protected Part testGetPartPage_addPart(Part part) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPostPart() throws Exception {
		Part randomPart = randomPart();

		Part postPart = testPostPart_addPart(randomPart);

		assertEquals(randomPart, postPart);
		assertValid(postPart);
	}

	protected Part testPostPart_addPart(Part part) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeletePart() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Part part = testDeletePart_addPart();

		assertHttpResponseStatusCode(
			204, partResource.deletePartHttpResponse(part.getId()));

		assertHttpResponseStatusCode(
			404, partResource.getPartHttpResponse(part.getId()));

		assertHttpResponseStatusCode(404, partResource.getPartHttpResponse(0L));
	}

	protected Part testDeletePart_addPart() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeletePart() throws Exception {
		Part part = testGraphQLPart_addPart();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deletePart",
						new HashMap<String, Object>() {
							{
								put("partId", part.getId());
							}
						})),
				"JSONObject/data", "Object/deletePart"));

		JSONArray errorsJSONArray = JSONUtil.getValueAsJSONArray(
			invokeGraphQLQuery(
				new GraphQLField(
					"part",
					new HashMap<String, Object>() {
						{
							put("partId", part.getId());
						}
					},
					new GraphQLField("id"))),
			"JSONArray/errors");

		Assert.assertTrue(errorsJSONArray.length() > 0);
	}

	@Test
	public void testGetPart() throws Exception {
		Part postPart = testGetPart_addPart();

		Part getPart = partResource.getPart(postPart.getId());

		assertEquals(postPart, getPart);
		assertValid(getPart);
	}

	protected Part testGetPart_addPart() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetPart() throws Exception {
		Part part = testGraphQLPart_addPart();

		Assert.assertTrue(
			equals(
				part,
				PartSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"part",
								new HashMap<String, Object>() {
									{
										put("partId", part.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/part"))));
	}

	@Test
	public void testGraphQLGetPartNotFound() throws Exception {
		Long irrelevantPartId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"part",
						new HashMap<String, Object>() {
							{
								put("partId", irrelevantPartId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPatchPart() throws Exception {
		Part postPart = testPatchPart_addPart();

		Part randomPatchPart = randomPatchPart();

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Part patchPart = partResource.patchPart(
			postPart.getId(), randomPatchPart);

		Part expectedPatchPart = postPart.clone();

		_beanUtilsBean.copyProperties(expectedPatchPart, randomPatchPart);

		Part getPart = partResource.getPart(patchPart.getId());

		assertEquals(expectedPatchPart, getPart);
		assertValid(getPart);
	}

	protected Part testPatchPart_addPart() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPutPart() throws Exception {
		Part postPart = testPutPart_addPart();

		Part randomPart = randomPart();

		Part putPart = partResource.putPart(postPart.getId(), randomPart);

		assertEquals(randomPart, putPart);
		assertValid(putPart);

		Part getPart = partResource.getPart(putPart.getId());

		assertEquals(randomPart, getPart);
		assertValid(getPart);
	}

	protected Part testPutPart_addPart() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Part testGraphQLPart_addPart() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Part part, List<Part> parts) {
		boolean contains = false;

		for (Part item : parts) {
			if (equals(part, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(parts + " does not contain " + part, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Part part1, Part part2) {
		Assert.assertTrue(
			part1 + " does not equal " + part2, equals(part1, part2));
	}

	protected void assertEquals(List<Part> parts1, List<Part> parts2) {
		Assert.assertEquals(parts1.size(), parts2.size());

		for (int i = 0; i < parts1.size(); i++) {
			Part part1 = parts1.get(i);
			Part part2 = parts2.get(i);

			assertEquals(part1, part2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Part> parts1, List<Part> parts2) {

		Assert.assertEquals(parts1.size(), parts2.size());

		for (Part part1 : parts1) {
			boolean contains = false;

			for (Part part2 : parts2) {
				if (equals(part1, part2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(parts2 + " does not contain " + part1, contains);
		}
	}

	protected void assertValid(Part part) throws Exception {
		boolean valid = true;

		if (part.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("address", additionalAssertFieldName)) {
				if (part.getAddress() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("internalPhone", additionalAssertFieldName)) {
				if (part.getInternalPhone() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (part.getName() == null) {
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

	protected void assertValid(Page<Part> page) {
		boolean valid = false;

		java.util.Collection<Part> parts = page.getItems();

		int size = parts.size();

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

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					com.sain.headless.phonebook.dto.v1_0.Part.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
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

	protected boolean equals(Part part1, Part part2) {
		if (part1 == part2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("address", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						part1.getAddress(), part2.getAddress())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(part1.getId(), part2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("internalPhone", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						part1.getInternalPhone(), part2.getInternalPhone())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(part1.getName(), part2.getName())) {
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

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_partResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_partResource;

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
		EntityField entityField, String operator, Part part) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("address")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("internalPhone")) {
			sb.append("'");
			sb.append(String.valueOf(part.getInternalPhone()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(part.getName()));
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

	protected Part randomPart() throws Exception {
		return new Part() {
			{
				id = RandomTestUtil.randomLong();
				internalPhone = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected Part randomIrrelevantPart() throws Exception {
		Part randomIrrelevantPart = randomPart();

		return randomIrrelevantPart;
	}

	protected Part randomPatchPart() throws Exception {
		return randomPart();
	}

	protected PartResource partResource;
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

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BasePartResourceTestCase.class);

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
	private com.sain.headless.phonebook.resource.v1_0.PartResource
		_partResource;

}