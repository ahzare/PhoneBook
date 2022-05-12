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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.sain.phonebook.model.Department;
import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = "indexer.class.name=com.sain.phonebook.model.Department",
	service = ModelDocumentContributor.class
)
public class DepartmentModelDocumentContributor
	implements ModelDocumentContributor<Department> {

	@Override
	public void contribute(Document document, Department baseModel) {
		document.addText("name", baseModel.getName());


		/*try {
			document.addDate(Field.MODIFIED_DATE, baseModel.getModifiedDate());

			Locale defaultLocale = PortalUtil.getSiteDefaultLocale(
					baseModel.getGroupId());

			String localizedTitle = LocalizationUtil.getLocalizedName(
					Field.TITLE, defaultLocale.toString());

			document.addText(localizedTitle, baseModel.getFirstName());

			document.addText("firstName", baseModel.getFirstName());
			document.addText("lastName", baseModel.getLastName());
		} catch (PortalException portalException) {
			if (_log.isWarnEnabled()) {
				_log.warn(
						"Unable to index baseModel " + baseModel.getDepartmentId(), portalException);
			}
		}*/
	}

	private static final Log _log = LogFactoryUtil.getLog(
			DepartmentModelDocumentContributor.class);

}