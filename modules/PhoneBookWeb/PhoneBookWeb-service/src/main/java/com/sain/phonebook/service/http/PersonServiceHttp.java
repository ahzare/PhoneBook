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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.sain.phonebook.service.PersonServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>PersonServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonServiceSoap
 * @generated
 */
public class PersonServiceHttp {

	public static com.sain.phonebook.model.Person addPerson(
			HttpPrincipal httpPrincipal, String firstName, String lastName,
			String localPhoneNumber, String phoneNumber, String faxNumber,
			String roomNumber, String email, String website, long departmentId,
			long roleId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersonServiceUtil.class, "addPerson",
				_addPersonParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, firstName, lastName, localPhoneNumber, phoneNumber,
				faxNumber, roomNumber, email, website, departmentId, roleId,
				serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.sain.phonebook.model.Person)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void addPersonExcel(
			HttpPrincipal httpPrincipal, Long siteId,
			java.io.InputStream inputStream,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersonServiceUtil.class, "addPersonExcel",
				_addPersonExcelParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, siteId, inputStream, serviceContext);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.sain.phonebook.model.Person deletePerson(
			HttpPrincipal httpPrincipal, long personId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersonServiceUtil.class, "deletePerson",
				_deletePersonParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, personId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.sain.phonebook.model.Person)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.sain.phonebook.model.Person> getAll(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				PersonServiceUtil.class, "getAll", _getAllParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.sain.phonebook.model.Person>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.sain.phonebook.model.Person getPerson(
			HttpPrincipal httpPrincipal, long personId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersonServiceUtil.class, "getPerson",
				_getPersonParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, personId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.sain.phonebook.model.Person)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.sain.phonebook.model.Person patchPerson(
			HttpPrincipal httpPrincipal, long id, String firstName,
			String lastName, String localPhoneNumber, String phoneNumber,
			String faxNumber, String roomNumber, String email, String website,
			long departmentId, long roleId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersonServiceUtil.class, "patchPerson",
				_patchPersonParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, id, firstName, lastName, localPhoneNumber,
				phoneNumber, faxNumber, roomNumber, email, website,
				departmentId, roleId, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.sain.phonebook.model.Person)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.sain.phonebook.model.Person updatePerson(
			HttpPrincipal httpPrincipal, long id, String firstName,
			String lastName, String localPhoneNumber, String phoneNumber,
			String faxNumber, String roomNumber, String email, String website,
			long departmentId, long roleId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersonServiceUtil.class, "updatePerson",
				_updatePersonParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, id, firstName, lastName, localPhoneNumber,
				phoneNumber, faxNumber, roomNumber, email, website,
				departmentId, roleId, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.sain.phonebook.model.Person)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PersonServiceHttp.class);

	private static final Class<?>[] _addPersonParameterTypes0 = new Class[] {
		String.class, String.class, String.class, String.class, String.class,
		String.class, String.class, String.class, long.class, long.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _addPersonExcelParameterTypes1 =
		new Class[] {
			Long.class, java.io.InputStream.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deletePersonParameterTypes2 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getAllParameterTypes3 = new Class[] {};
	private static final Class<?>[] _getPersonParameterTypes4 = new Class[] {
		long.class
	};
	private static final Class<?>[] _patchPersonParameterTypes5 = new Class[] {
		long.class, String.class, String.class, String.class, String.class,
		String.class, String.class, String.class, String.class, long.class,
		long.class, com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _updatePersonParameterTypes6 = new Class[] {
		long.class, String.class, String.class, String.class, String.class,
		String.class, String.class, String.class, String.class, long.class,
		long.class, com.liferay.portal.kernel.service.ServiceContext.class
	};

}