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

import com.sain.headless.phonebook.client.dto.v1_0.Person;
import com.sain.headless.phonebook.client.http.HttpInvoker;
import com.sain.headless.phonebook.client.pagination.Page;
import com.sain.headless.phonebook.client.pagination.Pagination;
import com.sain.headless.phonebook.client.resource.v1_0.PersonResource;
import com.sain.headless.phonebook.client.serdes.v1_0.PersonSerDes;

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
public abstract class BasePersonResourceTestCase {

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

		_personResource.setContextCompany(testCompany);

		PersonResource.Builder builder = PersonResource.builder();

		personResource = builder.authentication(
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

		Person person1 = randomPerson();

		String json = objectMapper.writeValueAsString(person1);

		Person person2 = PersonSerDes.toDTO(json);

		Assert.assertTrue(equals(person1, person2));
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

		Person person = randomPerson();

		String json1 = objectMapper.writeValueAsString(person);
		String json2 = PersonSerDes.toJSON(person);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Person person = randomPerson();

		person.setEmail(regex);
		person.setFaxNumber(regex);
		person.setFirstName(regex);
		person.setId(regex);
		person.setLastName(regex);
		person.setLocalPhoneNumber(regex);
		person.setPhoneNumber(regex);
		person.setRoomNumber(regex);
		person.setWebsite(regex);

		String json = PersonSerDes.toJSON(person);

		Assert.assertFalse(json.contains(regex));

		person = PersonSerDes.toDTO(json);

		Assert.assertEquals(regex, person.getEmail());
		Assert.assertEquals(regex, person.getFaxNumber());
		Assert.assertEquals(regex, person.getFirstName());
		Assert.assertEquals(regex, person.getId());
		Assert.assertEquals(regex, person.getLastName());
		Assert.assertEquals(regex, person.getLocalPhoneNumber());
		Assert.assertEquals(regex, person.getPhoneNumber());
		Assert.assertEquals(regex, person.getRoomNumber());
		Assert.assertEquals(regex, person.getWebsite());
	}

	@Test
	public void testGetPersonsPage() throws Exception {
		Page<Person> page = personResource.getPersonsPage(
			null, null, null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Person person1 = testGetPersonsPage_addPerson(randomPerson());

		Person person2 = testGetPersonsPage_addPerson(randomPerson());

		page = personResource.getPersonsPage(
			null, null, null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(person1, (List<Person>)page.getItems());
		assertContains(person2, (List<Person>)page.getItems());
		assertValid(page);

		personResource.deletePerson(person1.getId());

		personResource.deletePerson(person2.getId());
	}

	@Test
	public void testGetPersonsPageWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Person person1 = randomPerson();

		person1 = testGetPersonsPage_addPerson(person1);

		for (EntityField entityField : entityFields) {
			Page<Person> page = personResource.getPersonsPage(
				null, null, null,
				getFilterString(entityField, "between", person1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(person1),
				(List<Person>)page.getItems());
		}
	}

	@Test
	public void testGetPersonsPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Person person1 = testGetPersonsPage_addPerson(randomPerson());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Person person2 = testGetPersonsPage_addPerson(randomPerson());

		for (EntityField entityField : entityFields) {
			Page<Person> page = personResource.getPersonsPage(
				null, null, null, getFilterString(entityField, "eq", person1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(person1),
				(List<Person>)page.getItems());
		}
	}

	@Test
	public void testGetPersonsPageWithPagination() throws Exception {
		Page<Person> totalPage = personResource.getPersonsPage(
			null, null, null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Person person1 = testGetPersonsPage_addPerson(randomPerson());

		Person person2 = testGetPersonsPage_addPerson(randomPerson());

		Person person3 = testGetPersonsPage_addPerson(randomPerson());

		Page<Person> page1 = personResource.getPersonsPage(
			null, null, null, null, Pagination.of(1, totalCount + 2), null);

		List<Person> persons1 = (List<Person>)page1.getItems();

		Assert.assertEquals(
			persons1.toString(), totalCount + 2, persons1.size());

		Page<Person> page2 = personResource.getPersonsPage(
			null, null, null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Person> persons2 = (List<Person>)page2.getItems();

		Assert.assertEquals(persons2.toString(), 1, persons2.size());

		Page<Person> page3 = personResource.getPersonsPage(
			null, null, null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(person1, (List<Person>)page3.getItems());
		assertContains(person2, (List<Person>)page3.getItems());
		assertContains(person3, (List<Person>)page3.getItems());
	}

	@Test
	public void testGetPersonsPageWithSortDateTime() throws Exception {
		testGetPersonsPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, person1, person2) -> {
				BeanUtils.setProperty(
					person1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetPersonsPageWithSortInteger() throws Exception {
		testGetPersonsPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, person1, person2) -> {
				BeanUtils.setProperty(person1, entityField.getName(), 0);
				BeanUtils.setProperty(person2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetPersonsPageWithSortString() throws Exception {
		testGetPersonsPageWithSort(
			EntityField.Type.STRING,
			(entityField, person1, person2) -> {
				Class<?> clazz = person1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						person1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						person2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						person1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						person2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						person1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						person2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetPersonsPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Person, Person, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Person person1 = randomPerson();
		Person person2 = randomPerson();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, person1, person2);
		}

		person1 = testGetPersonsPage_addPerson(person1);

		person2 = testGetPersonsPage_addPerson(person2);

		for (EntityField entityField : entityFields) {
			Page<Person> ascPage = personResource.getPersonsPage(
				null, null, null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(person1, person2),
				(List<Person>)ascPage.getItems());

			Page<Person> descPage = personResource.getPersonsPage(
				null, null, null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(person2, person1),
				(List<Person>)descPage.getItems());
		}
	}

	protected Person testGetPersonsPage_addPerson(Person person)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetPersonsPage() throws Exception {
		GraphQLField graphQLField = new GraphQLField(
			"persons",
			new HashMap<String, Object>() {
				{
					put("page", 1);
					put("pageSize", 10);
				}
			},
			new GraphQLField("items", getGraphQLFields()),
			new GraphQLField("page"), new GraphQLField("totalCount"));

		JSONObject personsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/persons");

		long totalCount = personsJSONObject.getLong("totalCount");

		Person person1 = testGraphQLPerson_addPerson();
		Person person2 = testGraphQLPerson_addPerson();

		personsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/persons");

		Assert.assertEquals(
			totalCount + 2, personsJSONObject.getLong("totalCount"));

		assertContains(
			person1,
			Arrays.asList(
				PersonSerDes.toDTOs(personsJSONObject.getString("items"))));
		assertContains(
			person2,
			Arrays.asList(
				PersonSerDes.toDTOs(personsJSONObject.getString("items"))));
	}

	@Test
	public void testPostPerson() throws Exception {
		Person randomPerson = randomPerson();

		Person postPerson = testPostPerson_addPerson(randomPerson);

		assertEquals(randomPerson, postPerson);
		assertValid(postPerson);
	}

	protected Person testPostPerson_addPerson(Person person) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeletePerson() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Person person = testDeletePerson_addPerson();

		assertHttpResponseStatusCode(
			204, personResource.deletePersonHttpResponse(person.getId()));

		assertHttpResponseStatusCode(
			404, personResource.getPersonHttpResponse(person.getId()));

		assertHttpResponseStatusCode(
			404, personResource.getPersonHttpResponse("-"));
	}

	protected Person testDeletePerson_addPerson() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeletePerson() throws Exception {
		Person person = testGraphQLPerson_addPerson();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deletePerson",
						new HashMap<String, Object>() {
							{
								put("personId", "\"" + person.getId() + "\"");
							}
						})),
				"JSONObject/data", "Object/deletePerson"));

		JSONArray errorsJSONArray = JSONUtil.getValueAsJSONArray(
			invokeGraphQLQuery(
				new GraphQLField(
					"person",
					new HashMap<String, Object>() {
						{
							put("personId", "\"" + person.getId() + "\"");
						}
					},
					new GraphQLField("id"))),
			"JSONArray/errors");

		Assert.assertTrue(errorsJSONArray.length() > 0);
	}

	@Test
	public void testGetPerson() throws Exception {
		Person postPerson = testGetPerson_addPerson();

		Person getPerson = personResource.getPerson(postPerson.getId());

		assertEquals(postPerson, getPerson);
		assertValid(getPerson);
	}

	protected Person testGetPerson_addPerson() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetPerson() throws Exception {
		Person person = testGraphQLPerson_addPerson();

		Assert.assertTrue(
			equals(
				person,
				PersonSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"person",
								new HashMap<String, Object>() {
									{
										put(
											"personId",
											"\"" + person.getId() + "\"");
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/person"))));
	}

	@Test
	public void testGraphQLGetPersonNotFound() throws Exception {
		String irrelevantPersonId = "\"" + RandomTestUtil.randomString() + "\"";

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"person",
						new HashMap<String, Object>() {
							{
								put("personId", irrelevantPersonId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPatchPersonApi() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testPutPersonApi() throws Exception {
		Person postPerson = testPutPersonApi_addPerson();

		Person randomPerson = randomPerson();

		Person putPerson = personResource.putPersonApi(
			postPerson.getId(), null, null, randomPerson);

		assertEquals(randomPerson, putPerson);
		assertValid(putPerson);

		Person getPerson = personResource.getPersonApi(putPerson.getId());

		assertEquals(randomPerson, getPerson);
		assertValid(getPerson);
	}

	protected Person testPutPersonApi_addPerson() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Person testGraphQLPerson_addPerson() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Person person, List<Person> persons) {
		boolean contains = false;

		for (Person item : persons) {
			if (equals(person, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(persons + " does not contain " + person, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Person person1, Person person2) {
		Assert.assertTrue(
			person1 + " does not equal " + person2, equals(person1, person2));
	}

	protected void assertEquals(List<Person> persons1, List<Person> persons2) {
		Assert.assertEquals(persons1.size(), persons2.size());

		for (int i = 0; i < persons1.size(); i++) {
			Person person1 = persons1.get(i);
			Person person2 = persons2.get(i);

			assertEquals(person1, person2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Person> persons1, List<Person> persons2) {

		Assert.assertEquals(persons1.size(), persons2.size());

		for (Person person1 : persons1) {
			boolean contains = false;

			for (Person person2 : persons2) {
				if (equals(person1, person2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				persons2 + " does not contain " + person1, contains);
		}
	}

	protected void assertValid(Person person) throws Exception {
		boolean valid = true;

		if (person.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("department", additionalAssertFieldName)) {
				if (person.getDepartment() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (person.getEmail() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("faxNumber", additionalAssertFieldName)) {
				if (person.getFaxNumber() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("firstName", additionalAssertFieldName)) {
				if (person.getFirstName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("lastName", additionalAssertFieldName)) {
				if (person.getLastName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("localPhoneNumber", additionalAssertFieldName)) {
				if (person.getLocalPhoneNumber() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("phoneNumber", additionalAssertFieldName)) {
				if (person.getPhoneNumber() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("role", additionalAssertFieldName)) {
				if (person.getRole() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("roomNumber", additionalAssertFieldName)) {
				if (person.getRoomNumber() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("website", additionalAssertFieldName)) {
				if (person.getWebsite() == null) {
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

	protected void assertValid(Page<Person> page) {
		boolean valid = false;

		java.util.Collection<Person> persons = page.getItems();

		int size = persons.size();

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
					com.sain.headless.phonebook.dto.v1_0.Person.class)) {

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

	protected boolean equals(Person person1, Person person2) {
		if (person1 == person2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("department", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						person1.getDepartment(), person2.getDepartment())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						person1.getEmail(), person2.getEmail())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("faxNumber", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						person1.getFaxNumber(), person2.getFaxNumber())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("firstName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						person1.getFirstName(), person2.getFirstName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(person1.getId(), person2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("lastName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						person1.getLastName(), person2.getLastName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("localPhoneNumber", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						person1.getLocalPhoneNumber(),
						person2.getLocalPhoneNumber())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("phoneNumber", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						person1.getPhoneNumber(), person2.getPhoneNumber())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("role", additionalAssertFieldName)) {
				if (!Objects.deepEquals(person1.getRole(), person2.getRole())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("roomNumber", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						person1.getRoomNumber(), person2.getRoomNumber())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("website", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						person1.getWebsite(), person2.getWebsite())) {

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

		if (!(_personResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_personResource;

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
		EntityField entityField, String operator, Person person) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("department")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("email")) {
			sb.append("'");
			sb.append(String.valueOf(person.getEmail()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("faxNumber")) {
			sb.append("'");
			sb.append(String.valueOf(person.getFaxNumber()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("firstName")) {
			sb.append("'");
			sb.append(String.valueOf(person.getFirstName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			sb.append("'");
			sb.append(String.valueOf(person.getId()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("lastName")) {
			sb.append("'");
			sb.append(String.valueOf(person.getLastName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("localPhoneNumber")) {
			sb.append("'");
			sb.append(String.valueOf(person.getLocalPhoneNumber()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("phoneNumber")) {
			sb.append("'");
			sb.append(String.valueOf(person.getPhoneNumber()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("role")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("roomNumber")) {
			sb.append("'");
			sb.append(String.valueOf(person.getRoomNumber()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("website")) {
			sb.append("'");
			sb.append(String.valueOf(person.getWebsite()));
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

	protected Person randomPerson() throws Exception {
		return new Person() {
			{
				email =
					StringUtil.toLowerCase(RandomTestUtil.randomString()) +
						"@liferay.com";
				faxNumber = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				firstName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = StringUtil.toLowerCase(RandomTestUtil.randomString());
				lastName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				localPhoneNumber = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				phoneNumber = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				roomNumber = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				website = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected Person randomIrrelevantPerson() throws Exception {
		Person randomIrrelevantPerson = randomPerson();

		return randomIrrelevantPerson;
	}

	protected Person randomPatchPerson() throws Exception {
		return randomPerson();
	}

	protected PersonResource personResource;
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
		LogFactoryUtil.getLog(BasePersonResourceTestCase.class);

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
	private com.sain.headless.phonebook.resource.v1_0.PersonResource
		_personResource;

}