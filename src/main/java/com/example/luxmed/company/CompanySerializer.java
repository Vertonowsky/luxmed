package com.example.luxmed.company;

import com.example.luxmed.department.DepartmentSerializer;
import java.util.stream.Collectors;

public class CompanySerializer {

	public static CompanyDto serialize(Company company) {
		CompanyDto companyDto = new CompanyDto();
		companyDto.setId(company.getId());
		companyDto.setName(company.getName());
		if (company.getDepartments() != null)
			companyDto.setDepartments(company.getDepartments().stream().map(DepartmentSerializer::serialize).collect(Collectors.toSet()));

		return companyDto;
	}

}
