package com.sain.headless.phonebook.client.dto.v1_0;

import com.sain.headless.phonebook.client.function.UnsafeSupplier;
import com.sain.headless.phonebook.client.serdes.v1_0.AddressSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Amir
 * @generated
 */
@Generated("")
public class Address implements Cloneable, Serializable {

	public static Address toDTO(String json) {
		return AddressSerDes.toDTO(json);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setId(UnsafeSupplier<String, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String name;

	@Override
	public Address clone() throws CloneNotSupportedException {
		return (Address)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Address)) {
			return false;
		}

		Address address = (Address)object;

		return Objects.equals(toString(), address.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return AddressSerDes.toJSON(this);
	}

}