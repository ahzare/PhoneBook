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

package com.sain.phonebook.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sain.phonebook.service.PartServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>PartServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.sain.phonebook.model.PartSoap</code>. If the method in the
 * service utility returns a
 * <code>com.sain.phonebook.model.Part</code>, that is translated to a
 * <code>com.sain.phonebook.model.PartSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PartServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PartServiceSoap {

	public static com.sain.phonebook.model.PartSoap addPart(
			String name, String internalPhone, long addressId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.sain.phonebook.model.Part returnValue = PartServiceUtil.addPart(
				name, internalPhone, addressId, serviceContext);

			return com.sain.phonebook.model.PartSoap.toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void deletePart(long partId) throws RemoteException {
		try {
			PartServiceUtil.deletePart(partId);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.sain.phonebook.model.PartSoap[] getAll()
		throws RemoteException {

		try {
			java.util.List<com.sain.phonebook.model.Part> returnValue =
				PartServiceUtil.getAll();

			return com.sain.phonebook.model.PartSoap.toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.sain.phonebook.model.PartSoap getPart(long partId)
		throws RemoteException {

		try {
			com.sain.phonebook.model.Part returnValue = PartServiceUtil.getPart(
				partId);

			return com.sain.phonebook.model.PartSoap.toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.sain.phonebook.model.PartSoap patchPart(
			long id, String name, String internalPhone, long addressId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.sain.phonebook.model.Part returnValue =
				PartServiceUtil.patchPart(
					id, name, internalPhone, addressId, serviceContext);

			return com.sain.phonebook.model.PartSoap.toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.sain.phonebook.model.PartSoap updatePart(
			long id, String name, String internalPhone, long addressId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.sain.phonebook.model.Part returnValue =
				PartServiceUtil.updatePart(
					id, name, internalPhone, addressId, serviceContext);

			return com.sain.phonebook.model.PartSoap.toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PartServiceSoap.class);

}