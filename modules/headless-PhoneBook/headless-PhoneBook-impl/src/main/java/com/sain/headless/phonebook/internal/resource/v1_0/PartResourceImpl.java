package com.sain.headless.phonebook.internal.resource.v1_0;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.sain.headless.phonebook.dto.v1_0.Address;
import com.sain.headless.phonebook.dto.v1_0.Part;
import com.sain.headless.phonebook.resource.v1_0.PartResource;

import com.sain.phonebook.service.AddressService;
import com.sain.phonebook.service.PartService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amir
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/part.properties",
        scope = ServiceScope.PROTOTYPE, service = PartResource.class
)
public class PartResourceImpl extends BasePartResourceImpl {
    @Reference
    private Portal _portal;
    @Reference
    private UserLocalService _userLocalService;
    @Reference
    private PartService _partService;
    @Reference
    private AddressService _addressService;
    private static final Logger _log =
            LoggerFactory.getLogger(PartResourceImpl.class);

    protected ServiceContext _getServiceContext() throws PortalException {
        ServiceContext serviceContext =
                new ServiceContext();
        serviceContext.setCompanyId(contextCompany.getCompanyId());
// need the current user in the service context.
// will get easier in newer version of the REST Builder plugin...
// but for now, this is the only game in town.
        long userId = PrincipalThreadLocal.getUserId();
        serviceContext.setUserId(userId);
        return serviceContext;
    }

    protected Part _toPart(com.sain.phonebook.model.Part part) throws PortalException {

        return new Part() {{
            id = part.getPartId();
            name = part.getName();
            internalPhone = part.getInternalPhone();
            if (part.getAddressId() != 0)
                address = AddressResourceImpl._toAddress(
                        _addressService.getAddress(part.getAddressId()));
        }};
		/*return new Part() {{
			creator = CreatorUtil.toCreator(_portal,
					_userLocalService.getUser(pv.getUserId()));
			articleId = pv.getArticleId();
			group = pv.getGroupName();
			description = pv.getDescription();
			id = pv.getSurrogateId();
			name = pv.getName();
			type = _toPartType(pv.getType());
			attributes = ListUtil.toArray(pv.getAttributes(), VALUE_ACCESSOR);
			chemicalNames = ListUtil.toArray(pv.getChemicalNames(), VALUE_ACCESSOR);
			properties = ListUtil.toArray(pv.getProperties(), VALUE_ACCESSOR);
			risks = ListUtil.toArray(pv.getRisks(), VALUE_ACCESSOR);
			symptoms = ListUtil.toArray(pv.getSymptoms(), VALUE_ACCESSOR);
		}};*/
    }


	/*private PartEntityModel _partEntityModel = new PartEntityModel();

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap)
			throws Exception {
		return _partEntityModel;
	}*/

    @Override
    public Page<Part> getPartsPage(String search, Filter filter,
                                   Pagination pagination, Sort[] sorts)
            throws Exception {
        System.out.println("getPartsPage");


       /* return SearchUtil.search(
                null,
                booleanQuery -> {
                },
                filter, Part.class, search, pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(
                        Field.ENTRY_CLASS_PK),
                searchContext -> {
                    searchContext.setCompanyId(contextCompany.getCompanyId());
                    searchContext.setGroupIds(new long[] {contextCompany.getGroupId()});
                },
                sorts,
                document -> _toPart(_persistedPartService.getPersistedPart(document.get(Field.ENTRY_CLASS_PK))));
*/


       /* return SearchUtil.search(
              null,
                booleanQuery -> {
                },
                filter, Part.class, search, pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(
                        Field.ENTRY_CLASS_PK),
                searchContext -> {
                    searchContext.setAttribute(Field.NAME, search);
                    searchContext.setCompanyId(contextCompany.getCompanyId());
                    searchContext.setGroupIds(new long[] {contextCompany.getGroupId()});
                },
                sorts,
                document -> _toPart(
                        _persistedPartService.getPersistedPart(
                                GetterUtil.getString(document.get(Field.ENTRY_CLASS_PK)))));*/


       /* List<Part> list = _persistedPartService.getAll()
                .stream().map(persistedPart -> {
                    try {
                        // adding for search
                        Part part = _toPart(persistedPart);
                        if (search != null) {
                            if (part.getName().contains(search)) {
                                return part;
                            }
                        } else {
                            return part;
                        }

                        //                        return _toPart(persistedPart);
                    } catch (PortalException e) {
                        e.printStackTrace();
                    }
                    return new Part();
                }).collect(Collectors.toList());*/


        List<com.sain.phonebook.model.Part> persistedParts = _partService.getAll();
        List<Part> list = new ArrayList<>();

        for (com.sain.phonebook.model.Part persistedPart : persistedParts) {
            Part part = _toPart(persistedPart);
            if (search != null) {
                if (part.getName().contains(search)) {
                    list.add(part);
                }
            } else {
                list.add(part);
            }
        }

        return Page.of(list);
    }

    @Override
    public void deletePart(@NotNull Long partId) throws Exception {
        try {
// super easy case, just pass through to the service layer.
            _partService.deletePart(partId);
        } catch (Exception e) {
            _log.error("Error deleting part: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Part getPart(@NotNull Long partId) throws Exception {
        try {
// fetch the entity class...
            com.sain.phonebook.model.Part persistedPart = _partService.getPart(partId);
            return _toPart(persistedPart);
        } catch (Exception e) {
            _log.error("Error getting part [" + partId + "]: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Part postPart(Long addressId, Part part) throws Exception {
        System.out.println("postPart");
        if (_log.isDebugEnabled()) {
            _log.debug("Need to create a new part: %s\n", part.toString());
        }
        _log.warn("hi ali");
        try {

            com.sain.phonebook.model.Part persistedPart = _partService.addPart(part.getName(),
                    part.getInternalPhone(), (addressId != null ? addressId : 0), _getServiceContext());
            return _toPart(persistedPart);
        } catch (Exception e) {
            _log.error("Error creating part: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Part patchPartApi(@NotNull Long partId, Long addressId, Part part)
            throws Exception {
        try {
            com.sain.phonebook.model.Part persistedPart = _partService.patchPart(partId, part.getName(),
                    part.getInternalPhone(), (addressId != null ? addressId : 0), _getServiceContext());
            return _toPart(persistedPart);
        } catch (Exception e) {
            _log.error("Error patching part: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Part putPartApi(@NotNull Long partId, Long addressId, Part part) throws Exception {
        try {
            com.sain.phonebook.model.Part persistedPart = _partService.updatePart(partId, part.getName()
                    , part.getInternalPhone(), (addressId != null ? addressId : 0), _getServiceContext());
            return _toPart(persistedPart);
        } catch (Exception e) {
            _log.error("Error putting part: " + e.getMessage(), e);
            throw e;
        }
    }
}