package com.sain.phonebook.internal.search.spi.model.result.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
        immediate = true,
        property
                = "indexer.class.name=com.sain.phonebook.model.Person",
        service = ModelSummaryContributor.class
)
public class PersonModelSummaryContributor
        implements ModelSummaryContributor {
    @Override
    public Summary getSummary(Document document, Locale locale, String snippet) {
        Summary summary = new Summary(document.get("firstName"),
                document.get("lastName"));
        summary.setMaxContentLength(200);
        return summary;
    }
}

