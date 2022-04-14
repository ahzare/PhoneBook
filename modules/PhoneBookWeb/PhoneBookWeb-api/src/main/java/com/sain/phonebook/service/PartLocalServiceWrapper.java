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

package com.sain.phonebook.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PartLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PartLocalService
 * @generated
 */
public class PartLocalServiceWrapper
	implements PartLocalService, ServiceWrapper<PartLocalService> {

	public PartLocalServiceWrapper(PartLocalService partLocalService) {
		_partLocalService = partLocalService;
	}

	/**
	 * Adds the part to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PartLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param part the part
	 * @return the part that was added
	 */
	@Override
	public com.sain.phonebook.model.Part addPart(
		com.sain.phonebook.model.Part part) {

		return _partLocalService.addPart(part);
	}

	@Override
	public com.sain.phonebook.model.Part addPart(
			String name, String internalPhone, long addressId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _partLocalService.addPart(
			name, internalPhone, addressId, serviceContext);
	}

	/**
	 * Creates a new part with the primary key. Does not add the part to the database.
	 *
	 * @param partId the primary key for the new part
	 * @return the new part
	 */
	@Override
	public com.sain.phonebook.model.Part createPart(long partId) {
		return _partLocalService.createPart(partId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _partLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the part with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PartLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param partId the primary key of the part
	 * @return the part that was removed
	 * @throws PortalException if a part with the primary key could not be found
	 */
	@Override
	public com.sain.phonebook.model.Part deletePart(long partId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _partLocalService.deletePart(partId);
	}

	/**
	 * Deletes the part from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PartLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param part the part
	 * @return the part that was removed
	 */
	@Override
	public com.sain.phonebook.model.Part deletePart(
		com.sain.phonebook.model.Part part) {

		return _partLocalService.deletePart(part);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _partLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _partLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _partLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sain.phonebook.model.impl.PartModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _partLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sain.phonebook.model.impl.PartModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _partLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _partLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _partLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.sain.phonebook.model.Part fetchPart(long partId) {
		return _partLocalService.fetchPart(partId);
	}

	/**
	 * Returns the part matching the UUID and group.
	 *
	 * @param uuid the part's UUID
	 * @param groupId the primary key of the group
	 * @return the matching part, or <code>null</code> if a matching part could not be found
	 */
	@Override
	public com.sain.phonebook.model.Part fetchPartByUuidAndGroupId(
		String uuid, long groupId) {

		return _partLocalService.fetchPartByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _partLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _partLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _partLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _partLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the part with the primary key.
	 *
	 * @param partId the primary key of the part
	 * @return the part
	 * @throws PortalException if a part with the primary key could not be found
	 */
	@Override
	public com.sain.phonebook.model.Part getPart(long partId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _partLocalService.getPart(partId);
	}

	/**
	 * Returns the part matching the UUID and group.
	 *
	 * @param uuid the part's UUID
	 * @param groupId the primary key of the group
	 * @return the matching part
	 * @throws PortalException if a matching part could not be found
	 */
	@Override
	public com.sain.phonebook.model.Part getPartByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _partLocalService.getPartByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the parts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sain.phonebook.model.impl.PartModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parts
	 * @param end the upper bound of the range of parts (not inclusive)
	 * @return the range of parts
	 */
	@Override
	public java.util.List<com.sain.phonebook.model.Part> getParts(
		int start, int end) {

		return _partLocalService.getParts(start, end);
	}

	/**
	 * Returns all the parts matching the UUID and company.
	 *
	 * @param uuid the UUID of the parts
	 * @param companyId the primary key of the company
	 * @return the matching parts, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.sain.phonebook.model.Part>
		getPartsByUuidAndCompanyId(String uuid, long companyId) {

		return _partLocalService.getPartsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of parts matching the UUID and company.
	 *
	 * @param uuid the UUID of the parts
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of parts
	 * @param end the upper bound of the range of parts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching parts, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.sain.phonebook.model.Part>
		getPartsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sain.phonebook.model.Part> orderByComparator) {

		return _partLocalService.getPartsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of parts.
	 *
	 * @return the number of parts
	 */
	@Override
	public int getPartsCount() {
		return _partLocalService.getPartsCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _partLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.sain.phonebook.model.Part patchPart(
			long partId, String name, String internalPhone, long addressId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _partLocalService.patchPart(
			partId, name, internalPhone, addressId, serviceContext);
	}

	@Override
	public com.sain.phonebook.model.Part updatePart(
			long partId, String name, String internalPhone, long addressId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _partLocalService.updatePart(
			partId, name, internalPhone, addressId, serviceContext);
	}

	/**
	 * Updates the part in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PartLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param part the part
	 * @return the part that was updated
	 */
	@Override
	public com.sain.phonebook.model.Part updatePart(
		com.sain.phonebook.model.Part part) {

		return _partLocalService.updatePart(part);
	}

	@Override
	public PartLocalService getWrappedService() {
		return _partLocalService;
	}

	@Override
	public void setWrappedService(PartLocalService partLocalService) {
		_partLocalService = partLocalService;
	}

	private PartLocalService _partLocalService;

}