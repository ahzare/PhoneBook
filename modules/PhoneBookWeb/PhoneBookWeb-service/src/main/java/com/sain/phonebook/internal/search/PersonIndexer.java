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
 */

package com.sain.phonebook.internal.search;

import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import com.sain.phonebook.model.Person;
import com.sain.phonebook.service.PersonLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alessio Antonio Rendina
 */
@Component(immediate = true, service = Indexer.class)
public class PersonIndexer extends BaseIndexer<Person> {

    public static final String CLASS_NAME = Person.class.getName();

//    public static final String FIELD_ACTIVE = "active";

    @Override
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override
    public void postProcessContextBooleanFilter(
            BooleanFilter contextBooleanFilter, SearchContext searchContext)
            throws Exception {

     /*   Boolean active = (Boolean)searchContext.getAttribute(FIELD_ACTIVE);

        if (active != null) {
            contextBooleanFilter.addTerm(
                    FIELD_ACTIVE, String.valueOf(active), BooleanClauseOccur.MUST);
        }

        int type = GetterUtil.getInteger(
                searchContext.getAttribute(Field.TYPE), -1);

        if (type > -1) {
            contextBooleanFilter.addRequiredTerm(Field.TYPE, type);
        }*/
    }

    @Override
    public void postProcessSearchQuery(
            BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter,
            SearchContext searchContext)
            throws Exception {

        addSearchTerm(searchQuery, searchContext, Field.ENTRY_CLASS_PK, false);
        addSearchTerm(searchQuery, searchContext, "firstName", true);
        addSearchTerm(searchQuery, searchContext, "lastName", true);
//        addSearchTerm(searchQuery, searchContext, Field.NAME, true);
    }

    @Override
    protected void doDelete(Person person) throws Exception {
        deleteDocument(
                person.getCompanyId(), person.getPersonId());
    }

    @Override
    protected Document doGetDocument(Person person)
            throws Exception {

        if (_log.isDebugEnabled()) {
            _log.debug("Indexing person " + person);
        }

        Document document = getBaseModelDocument(CLASS_NAME, person);

//        document.addText(Field.NAME, person.getFirstName());
        document.addText("firstName", person.getFirstName());
        document.addText("lastName", person.getLastName());
        document.addDate(Field.MODIFIED_DATE, person.getModifiedDate());
//        document.addKeyword(
//                ClubCampaignFieldConstant.C_CAMPAIGN_FIELD_ACTIVE,
//                person.getActive());

        if (_log.isDebugEnabled()) {
            _log.debug("Document " + person + " indexed successfully");
        }

        return document;
    }

    @Override
    protected Summary doGetSummary(
            Document document, Locale locale, String snippet,
            PortletRequest portletRequest, PortletResponse portletResponse) {

//        Summary summary = createSummary(document, Field.ENTRY_CLASS_PK, Field.NAME);
        Summary summary = createSummary(document,
                Field.ENTRY_CLASS_PK,"firstName");

        summary.setMaxContentLength(200);

        return summary;
    }

    @Override
    protected void doReindex(Person person) throws Exception {
        _indexWriterHelper.updateDocument(
                getSearchEngineId(), person.getCompanyId(),
                getDocument(person), isCommitImmediately());
    }

    @Override
    protected void doReindex(String className, long classPK) throws Exception {
        doReindex(_personLocalService.getPerson(classPK));
    }

    @Override
    protected void doReindex(String[] ids) throws Exception {
        long companyId = GetterUtil.getLong(ids[0]);

        reindexPersons(companyId);
    }

    protected void reindexPersons(long companyId) throws PortalException {
        final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
                _personLocalService.getIndexableActionableDynamicQuery();

        indexableActionableDynamicQuery.setCompanyId(companyId);
        indexableActionableDynamicQuery.setPerformActionMethod(
                (Person person) -> {
                    try {
                        indexableActionableDynamicQuery.addDocuments(
                                getDocument(person));
                    }
                    catch (PortalException portalException) {
                        if (_log.isWarnEnabled()) {
                            _log.warn(
                                    "Unable to index person " +
                                            person.getPersonId(),
                                    portalException);
                        }
                    }
                });
        indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());

        indexableActionableDynamicQuery.performActions();
    }

    private static final Log _log = LogFactoryUtil.getLog(
            PersonIndexer.class);

    @Reference
    private PersonLocalService _personLocalService;

    @Reference
    private IndexWriterHelper _indexWriterHelper;

}