package com.sain.phonebook.internal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.sain.phonebook.model.Person;
import org.osgi.service.component.annotations.Component;

import java.util.List;

@Component(immediate = true,
        property
                = "indexer.class.name=com.sain.phonebook.model.Person",
        service = ModelDocumentContributor.class)
public class PersonModelDocumentContributor
        implements ModelDocumentContributor<Person> {
    @Override
    public void contribute(Document document, Person baseModel) {
        document.addText("firstName", baseModel.getFirstName());
        document.addText("lastName", baseModel.getLastName());
    }
}

