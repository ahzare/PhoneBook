package com.sain.phonebook.internal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.sain.phonebook.model.Part;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true,
        property
                = "indexer.class.name=com.sain.phonebook.model.Part",
        service = ModelDocumentContributor.class)
public class PartModelDocumentContributor
        implements ModelDocumentContributor<Part> {
    @Override
    public void contribute(Document document, Part baseModel) {
        document.addText("name", baseModel.getName());
    }
}

