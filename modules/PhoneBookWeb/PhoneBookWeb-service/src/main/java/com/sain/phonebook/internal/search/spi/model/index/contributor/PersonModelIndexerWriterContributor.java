/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * @author Amir
 * @generated
 */

package com.sain.phonebook.internal.search.spi.model.index.contributor;

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
	property = "indexer.class.name=com.sain.phonebook.model.Person",
	service = ModelIndexerWriterContributor.class
)
public class PersonModelIndexerWriterContributor
	implements ModelIndexerWriterContributor<Person> {

	@Override
	public void customize(
		BatchIndexingActionable batchIndexingActionable,
		ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

		batchIndexingActionable.setPerformActionMethod(
			(Person person) -> {
				batchIndexingActionable.addDocuments(
						modelIndexerWriterDocumentHelper.getDocument(person));
			});
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return _dynamicQueryBatchIndexingActionableFactory.
			getBatchIndexingActionable(
				_personLocalService.getIndexableActionableDynamicQuery());
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
	private DynamicQueryBatchIndexingActionableFactory
			_dynamicQueryBatchIndexingActionableFactory;

	@Reference
	private PersonLocalService _personLocalService;

}