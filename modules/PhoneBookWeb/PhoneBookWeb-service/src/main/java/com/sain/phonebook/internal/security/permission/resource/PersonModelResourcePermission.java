package com.sain.phonebook.internal.security.permission.resource;

import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.sain.phonebook.constants.PhoneBookConstants;
import com.sain.phonebook.model.Person;
import com.sain.phonebook.service.PersonLocalService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.util.Dictionary;

@Component(immediate = true)
public class PersonModelResourcePermission {
    @Activate
    public void activate(BundleContext bundleContext) {
        Dictionary<String, Object> properties = new HashMapDictionary<>();
        properties.put("model.class.name", Person.class.getName());
        serviceRegistration = bundleContext.registerService(
                ModelResourcePermission.class,
                ModelResourcePermissionFactory.create(
                        Person.class,
                        Person::getPersonId,
                        _personLocalService::getPerson,
                        portletResourcePermission,
                        (modelResourcePermission, consumer) -> {
//nothing and idunnowhy !
                        }
                ), properties
        );
    }

    @Deactivate
    public void deactivate() {
        serviceRegistration.unregister();
    }

    @Reference
    private PersonLocalService _personLocalService;
    @Reference(target = "(resource.name=" + PhoneBookConstants.RESOURCE_NAME + ")")
    private PortletResourcePermission portletResourcePermission;
    private ServiceRegistration<?> serviceRegistration;
}

