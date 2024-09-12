package com.example.luxmed.company;

import com.example.luxmed.common.ErrorCode;
import com.example.luxmed.common.ConflictException;
import com.example.luxmed.department.Department;
import com.example.luxmed.department.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CompanyService {

	private final CompanyRepository companyRepository;

	private final DepartmentRepository departmentRepository;

	public CompanyService(CompanyRepository companyRepository, DepartmentRepository departmentRepository) {
		this.companyRepository = companyRepository;
		this.departmentRepository = departmentRepository;
	}

	public Set<Company> list() {
		return companyRepository.findAllWithFulfilledData();
	}

	public Company get(int id) throws EntityNotFoundException {
		return companyRepository.findByIdWithFulfilledData(id)
				.orElseThrow(() -> new EntityNotFoundException(ErrorCode.COMPANY_NOT_FOUND));
	}

	public void create(CompanyDto companyDto) throws ConflictException {
		validateCompanyName(companyDto.getName());

		Company company = new Company();
		company.setName(companyDto.getName());
		companyRepository.save(company);

		fillDepartments(company, companyDto);
	}

	public Company edit(int id, CompanyDto companyDto) throws EntityNotFoundException, ConflictException {
		Company company = get(id);
		validateCompanyName(companyDto.getName());

		company.setName(companyDto.getName());
		company.setDepartments(null);

		company = companyRepository.save(company);

		fillDepartments(company, companyDto);
		return company;
	}

	public void delete(int id) throws EntityNotFoundException {
		Company company = get(id);
		companyRepository.delete(company);
	}

	private void validateCompanyName(String name) throws ConflictException {
		if (companyRepository.existsByName(name))
			throw new ConflictException(ErrorCode.COMPANY_NAME_ALREADY_EXISTS);
	}

	private void fillDepartments(Company company, CompanyDto inputCompany) {
		if (inputCompany.getDepartments() != null) {
			Set<Department> departments = inputCompany.getDepartments().stream().map(departmentDto -> {
				Department department = new Department();
				department.setName(departmentDto.getName());
				department.setCompany(company);
				return department;
			}).collect(Collectors.toSet());
			departmentRepository.saveAll(departments);
		}
	}

}
