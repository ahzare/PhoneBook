package com.sain.headless.phonebook.internal.resource.v1_0;

import com.sain.headless.phonebook.resource.v1_0.AddressResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Amir
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/address.properties",
	scope = ServiceScope.PROTOTYPE, service = AddressResource.class
)
public class AddressResourceImpl extends BaseAddressResourceImpl {
}