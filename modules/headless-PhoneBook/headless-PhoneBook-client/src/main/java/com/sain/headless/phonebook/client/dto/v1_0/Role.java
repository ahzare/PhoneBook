package com.sain.headless.phonebook.client.dto.v1_0;

import com.sain.headless.phonebook.client.function.UnsafeSupplier;
import com.sain.headless.phonebook.client.serdes.v1_0.RoleSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Amir
 * @generated
 */
@Generated("")
public class Role implements Cloneable, Serializable {

	public static Role toDTO(String json) {
		return RoleSerDes.toDTO(json);
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setDepartment(
		UnsafeSupplier<Department, Exception> departmentUnsafeSupplier) {

		try {
			department = departmentUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Department department;

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
	public Role clone() throws CloneNotSupportedException {
		return (Role)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Role)) {
			return false;
		}

		Role role = (Role)object;

		return Objects.equals(toString(), role.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return RoleSerDes.toJSON(this);
	}

}