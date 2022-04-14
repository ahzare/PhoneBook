package com.sain.headless.phonebook.internal.odata.entity.v1_0;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.*;

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
                                "chemicalNames", locale -> Field.getSortableFieldName("chemicalNames"))),

                 // we'll support filtering based upon user creator id.
                new IntegerEntityField("creatorId", locale -> Field.USER_ID),*/

                // sorting/filtering on name is okay too
                new StringEntityField(
                        "firstName", locale -> Field.getSortableFieldName("firstName")),

                // as is sorting/filtering on the vitamin group
                new StringEntityField(
                        "lastName", locale -> Field.getSortableFieldName("lastName"))

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
