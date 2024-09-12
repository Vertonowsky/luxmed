package com.example.luxmed.company;

import com.example.luxmed.common.ErrorCode;
import com.example.luxmed.department.DepartmentDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyDto {

	private int id;

	@Size(min = 1, max = 128, message = ErrorCode.COMPANY_NAME_INVALID)
	@NotEmpty(message = ErrorCode.COMPANY_NAME_EMPTY)
	private String name;

	private Set<DepartmentDto> departments;

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

	public Set<DepartmentDto> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<DepartmentDto> departments) {
		this.departments = departments;
	}
}
