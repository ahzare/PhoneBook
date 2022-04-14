package com.sain.phonebook.internal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.sain.phonebook.model.Person;
import com.sain.phonebook.service.PersonLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property
                = "indexer.class.name=com.sain.phonebook.model.Person",
        service = ModelIndexerWriterContributor.class
)
public class PersonModelIndexerWriterContributor
        implements ModelIndexerWriterContributor<Person> {
    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable,
                          ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod((Person vitamin) -> {
            Document document = modelIndexerWriterDocumentHelper.getDocument(vitamin);
            batchIndexingActionable.addDocuments(document);
        });
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory
                .getBatchIndexingActionable(personLocalService
                        .getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(Person baseModel) {
        return baseModel.getCompanyId();
    }

    @Override
    public IndexerWriterMode getIndexerWriterMode(Person baseModel) {
        return IndexerWriterMode.UPDATE;
    }

    @Reference
    private PersonLocalService personLocalService;
    @Reference
    private DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;
}

