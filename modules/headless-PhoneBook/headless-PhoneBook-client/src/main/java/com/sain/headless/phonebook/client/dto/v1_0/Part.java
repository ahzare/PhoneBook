package com.sain.headless.phonebook.client.dto.v1_0;

import com.sain.headless.phonebook.client.function.UnsafeSupplier;
import com.sain.headless.phonebook.client.serdes.v1_0.PartSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Amir
 * @generated
 */
@Generated("")
public class Part implements Cloneable, Serializable {

	public static Part toDTO(String json) {
		return PartSerDes.toDTO(json);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setAddress(
		UnsafeSupplier<Address, Exception> addressUnsafeSupplier) {

		try {
			address = addressUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Address address;

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

	public String getInternalPhone() {
		return internalPhone;
	}

	public void setInternalPhone(String internalPhone) {
		this.internalPhone = internalPhone;
	}

	public void setInternalPhone(
		UnsafeSupplier<String, Exception> internalPhoneUnsafeSupplier) {

		try {
			internalPhone = internalPhoneUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String internalPhone;

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
	public Part clone() throws CloneNotSupportedException {
		return (Part)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Part)) {
			return false;
		}

		Part part = (Part)object;

		return Objects.equals(toString(), part.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return PartSerDes.toJSON(this);
	}

}