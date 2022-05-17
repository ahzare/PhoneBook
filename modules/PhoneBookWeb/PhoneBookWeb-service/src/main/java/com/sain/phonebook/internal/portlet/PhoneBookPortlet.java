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

package com.sain.phonebook.internal.portlet;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.PortletLocalService;
import com.liferay.portal.kernel.util.Portal;
import com.sain.phonebook.constants.PhoneBookConstants;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;

/**
 * @author Amir
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.show-portlet-inactive=false",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.display-name=PhoneBook Portlet",
		"javax.portlet.name=" + PhoneBookConstants.PORTLET_NAME,
		"javax.portlet.security-role-ref=administrator"
	},
	service = Portlet.class
)
public class PhoneBookPortlet extends MVCPortlet {

	@Activate
	protected void activate() {
		for (long companyId : _portal.getCompanyIds()) {
			_portletLocalService.updatePortlet(
				companyId, PhoneBookConstants.PORTLET_NAME,
				StringPool.BLANK, false);
		}
	}

	@Reference
	private Portal _portal;

	@Reference
	private PortletLocalService _portletLocalService;

}