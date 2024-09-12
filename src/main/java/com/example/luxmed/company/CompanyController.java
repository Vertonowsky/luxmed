package com.example.luxmed.company;

import com.example.luxmed.common.ConflictException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/local/companies")
public class CompanyController {

	private final CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	@GetMapping
	public List<CompanyDto> list() {
		return companyService.list().stream()
				.map(CompanySerializer::serialize)
				.toList();
	}

	@GetMapping("{id}")
	public CompanyDto get(@PathVariable int id) throws EntityNotFoundException {
		return CompanySerializer.serialize(companyService.get(id));
	}

	@PostMapping
	public void create(@RequestBody @Validated CompanyDto companyDto) throws ConflictException {
		companyService.create(companyDto);
	}

	@PutMapping("{id}")
	public CompanyDto edit(@PathVariable(value = "id") int id, @RequestBody @Validated CompanyDto companyDto) throws EntityNotFoundException, ConflictException {
		return CompanySerializer.serialize(companyService.edit(id, companyDto));
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable(value = "id") int id) throws EntityNotFoundException {
		companyService.delete(id);
	}

}
