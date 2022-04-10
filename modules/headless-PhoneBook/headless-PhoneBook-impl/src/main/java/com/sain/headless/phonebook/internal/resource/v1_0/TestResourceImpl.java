package com.sain.headless.phonebook.internal.resource.v1_0;

import com.sain.headless.phonebook.dto.v1_0.Test;
import com.sain.headless.phonebook.resource.v1_0.TestResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Amir
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/test.properties",
	scope = ServiceScope.PROTOTYPE, service = TestResource.class
)
public class TestResourceImpl extends BaseTestResourceImpl {
	@Override
	public Test test(String pathParam, String queryParam) throws Exception {
		System.out.println("pathParam = " + pathParam);
		System.out.println("queryParam = " + queryParam);
		Test test = new Test();
		test.setText("Path Param: "+pathParam+" | Query Param:"+queryParam);
		return test;
	}
}