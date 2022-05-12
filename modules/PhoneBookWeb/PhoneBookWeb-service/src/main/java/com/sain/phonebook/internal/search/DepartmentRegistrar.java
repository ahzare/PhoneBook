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

package com.sain.phonebook.internal.search;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.sain.phonebook.model.Department;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, service = DepartmentRegistrar.class)
public class DepartmentRegistrar {

	@Activate
	public void activate(BundleContext bundleContext) {
		_serviceRegistration = modelSearchRegistrarHelper.register(
			Department.class, bundleContext,
			modelSearchDefinition -> {
				modelSearchDefinition.setDefaultSelectedFieldNames(
					Field.COMPANY_ID, Field.ENTRY_CLASS_NAME,
					Field.ENTRY_CLASS_PK, Field.GROUP_ID, Field.SCOPE_GROUP_ID,
					Field.UID, Field.NAME);

				modelSearchDefinition.setModelIndexWriteContributor(
						departmentModelIndexerWriterContributor);

				modelSearchDefinition.setModelSummaryContributor(
					modelSummaryContributor);
			});
		_logger.error("Department registrar for search");
	}

	@Deactivate
	public void deactivate() {
		_serviceRegistration.unregister();
	}

	@Reference
	protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

	@Reference(target = "(indexer.class.name=com.sain.phonebook.model.Department)")
	protected ModelSummaryContributor modelSummaryContributor;

	@Reference(target = "(indexer.class.name=com.sain.phonebook.model.Department)")
	protected ModelIndexerWriterContributor<Department>
			departmentModelIndexerWriterContributor;

	private final Logger _logger = LoggerFactory.getLogger(DepartmentRegistrar.class);

	private ServiceRegistration<?> _serviceRegistration;

}