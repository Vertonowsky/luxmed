package com.example.luxmed.company;

import com.example.luxmed.department.Department;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 128, nullable = false, unique = true)
	private String name;

	@OneToMany(mappedBy = "company")
	private Set<Department> departments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Company company = (Company) o;
		return Objects.equals(name, company.name) && Objects.equals(departments, company.departments);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, departments);
	}
}
