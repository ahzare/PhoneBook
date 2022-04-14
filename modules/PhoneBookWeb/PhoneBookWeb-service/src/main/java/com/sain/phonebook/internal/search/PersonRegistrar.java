package com.sain.phonebook.internal.search;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.sain.phonebook.model.Person;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, service = PersonRegistrar.class)
public class PersonRegistrar {
    @Reference(target
            = "(indexer.class.name=com.sain.phonebook.model.Person)")
    protected ModelSummaryContributor modelSummaryContributor;
    @Reference(target
            = "(indexer.class.name=com.sain.phonebook.model.Person)")
    protected ModelIndexerWriterContributor<Person> personModelIndexerWriterContributor;
    @Reference
    protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;
    private ServiceRegistration<?> serviceRegistration;

    @Activate
    public void activate(BundleContext bundleContext) {
        serviceRegistration = modelSearchRegistrarHelper.register(
                Person.class, bundleContext,
                modelSearchDefinition -> {
                    modelSearchDefinition.setDefaultSelectedFieldNames(
                            Field.COMPANY_ID,
                            Field.ENTRY_CLASS_NAME,
                            Field.ENTRY_CLASS_PK,
                            Field.GROUP_ID,
                            Field.SCOPE_GROUP_ID,
                            Field.UID,
                            "firstName",
                            "lastName"
                    );

                    modelSearchDefinition.setModelIndexWriteContributor(personModelIndexerWriterContributor);

                    modelSearchDefinition.setModelSummaryContributor(modelSummaryContributor);
                }
        );
        logger.error("person registrar for search");
    }

    Logger logger = LoggerFactory.getLogger(PersonRegistrar.class);

    @Deactivate
    public void deactivate() {
        serviceRegistration.unregister();
    }
}

