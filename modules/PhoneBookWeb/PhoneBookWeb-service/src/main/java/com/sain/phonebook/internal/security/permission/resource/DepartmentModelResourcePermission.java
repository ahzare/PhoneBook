package com.sain.phonebook.internal.security.permission.resource;

import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.sain.phonebook.constants.PhoneBookConstants;
import com.sain.phonebook.model.Department;
import com.sain.phonebook.service.DepartmentLocalService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.util.Dictionary;

@Component(immediate = true)
public class DepartmentModelResourcePermission {
    @Activate
    public void activate(BundleContext bundleContext) {
        Dictionary<String, Object> properties = new HashMapDictionary<>();
        properties.put("model.class.name", Department.class.getName());
        serviceRegistration = bundleContext.registerService(
                ModelResourcePermission.class,
                ModelResourcePermissionFactory.create(
                        Department.class,
                        Department::getDepartmentId,
                        _departmentLocalService::getDepartment,
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
    private DepartmentLocalService _departmentLocalService;
    @Reference(target = "(resource.name=" + PhoneBookConstants.RESOURCE_NAME + ")")
    private PortletResourcePermission portletResourcePermission;
    private ServiceRegistration<?> serviceRegistration;
}

