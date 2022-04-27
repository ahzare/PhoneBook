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
	property = "indexer.class.name=com.sain.phonebook.model.Part",
	service = ModelIndexerWriterContributor.class
)
public class PartModelIndexerWriterContributor
	implements ModelIndexerWriterContributor<Part> {

	@Override
	public void customize(
		BatchIndexingActionable batchIndexingActionable,
		ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

		batchIndexingActionable.setPerformActionMethod(
			(Part part) -> {
				Document document =
					modelIndexerWriterDocumentHelper.getDocument(part);

				batchIndexingActionable.addDocuments(document);
			});
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return _dynamicQueryBatchIndexingActionableFactory.
			getBatchIndexingActionable(
				_PartLocalService.getIndexableActionableDynamicQuery());
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
	private DynamicQueryBatchIndexingActionableFactory
			_dynamicQueryBatchIndexingActionableFactory;

	@Reference
	private PartLocalService _PartLocalService;

}