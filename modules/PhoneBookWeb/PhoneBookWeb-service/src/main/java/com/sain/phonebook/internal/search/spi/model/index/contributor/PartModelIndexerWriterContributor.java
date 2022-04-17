package com.sain.phonebook.internal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.sain.phonebook.model.Part;
import com.sain.phonebook.service.PartLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property
                = "indexer.class.name=com.sain.phonebook.model.Part",
        service = ModelIndexerWriterContributor.class
)
public class PartModelIndexerWriterContributor
        implements ModelIndexerWriterContributor<Part> {
    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable,
                          ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod((Part part) -> {
            Document document = modelIndexerWriterDocumentHelper.getDocument(part);
            batchIndexingActionable.addDocuments(document);
        });
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory
                .getBatchIndexingActionable(PartLocalService
                        .getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(Part baseModel) {
        return baseModel.getCompanyId();
    }

    @Override
    public IndexerWriterMode getIndexerWriterMode(Part baseModel) {
        return IndexerWriterMode.UPDATE;
    }

    @Reference
    private PartLocalService PartLocalService;
    @Reference
    private DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;
}

