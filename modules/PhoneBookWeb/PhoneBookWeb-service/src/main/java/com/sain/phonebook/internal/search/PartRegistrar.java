package com.sain.phonebook.internal.search;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.sain.phonebook.model.Part;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, service = PartRegistrar.class)
public class PartRegistrar {
    @Reference(target
            = "(indexer.class.name=com.sain.phonebook.model.Part)")
    protected ModelSummaryContributor modelSummaryContributor;
    @Reference(target
            = "(indexer.class.name=com.sain.phonebook.model.Part)")
    protected ModelIndexerWriterContributor<Part> PartModelIndexerWriterContributor;
    @Reference
    protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;
    private ServiceRegistration<?> serviceRegistration;

    @Activate
    public void activate(BundleContext bundleContext) {
        serviceRegistration = modelSearchRegistrarHelper.register(
                Part.class, bundleContext,
                modelSearchDefinition -> {
                    modelSearchDefinition.setDefaultSelectedFieldNames(
                            Field.COMPANY_ID,
                            Field.ENTRY_CLASS_NAME,
                            Field.ENTRY_CLASS_PK,
                            Field.GROUP_ID,
                            Field.SCOPE_GROUP_ID,
                            Field.UID,
                            Field.NAME
                    );

                    modelSearchDefinition.setModelIndexWriteContributor(PartModelIndexerWriterContributor);

                    modelSearchDefinition.setModelSummaryContributor(modelSummaryContributor);
                }
        );
        logger.error("Part registrar for search");
    }

    Logger logger = LoggerFactory.getLogger(PartRegistrar.class);

    @Deactivate
    public void deactivate() {
        serviceRegistration.unregister();
    }
}

