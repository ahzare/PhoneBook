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
 *
 * @author Amir
 * @generated
 */

package com.sain.headless.phonebook.internal.v1_0;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonEntityModel implements EntityModel {

	public PersonEntityModel() {
        _entityFieldsMap = Stream.of(
                /*// chemicalNames is a string array of the chemical names of the vitamins/minerals
                new CollectionEntityField(
                        new StringEntityField(
                                "chemicalNames",
                                locale -> Field.
                                getSortableFieldName("chemicalNames"))),

                 // we'll support filtering based upon user creator id.
                new IntegerEntityField("creatorId", locale -> Field.USER_ID),*/

                // sorting/filtering on name is okay too
                new StringEntityField(
                        "firstName",
						locale -> Field.getSortableFieldName("firstName")),

                // as is sorting/filtering on the vitamin group
                new StringEntityField(
                        "lastName",
						locale -> Field.getSortableFieldName("lastName"))

        ).collect(
                Collectors.toMap(EntityField::getName, Function.identity())
        );
	}

	@Override
	public Map<String, EntityField> getEntityFieldsMap() {
		return _entityFieldsMap;
	}

	private final Map<String, EntityField> _entityFieldsMap;

}