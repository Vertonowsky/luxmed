

import com.example.luxmed.common.ConflictException
import com.example.luxmed.company.Company
import com.example.luxmed.company.CompanyDto
import com.example.luxmed.company.CompanyRepository
import com.example.luxmed.company.CompanyService
import com.example.luxmed.department.DepartmentRepository
import jakarta.persistence.EntityNotFoundException
import spock.lang.Specification

class CompanyServiceSpec extends Specification {

    CompanyRepository companyRepository = Mock(CompanyRepository)
    DepartmentRepository departmentRepository = Mock(DepartmentRepository)
    CompanyService companyService = new CompanyService(companyRepository, departmentRepository)

    def "should return company by id"() {
        given:
        Company company = new Company(id: 1, name: "Company 1")
        companyRepository.findByIdWithFulfilledData(1) >> Optional.of(company)

        when:
        def result = companyService.get(1)

        then:
        result == company
    }

    def "should throw EntityNotFoundException if company not found by id"() {
        given:
        companyRepository.findByIdWithFulfilledData(1) >> Optional.empty()

        when:
        companyService.get(1)

        then:
        thrown(EntityNotFoundException)
    }

    def "should create new company"() {
        given:
        CompanyDto companyDto = new CompanyDto(name: "New Company", departments: [])
        companyRepository.existsByName("New Company") >> false

        when:
        companyService.create(companyDto)

        then:
        1 * companyRepository.save(_ as Company)
    }

    def "should throw ConflictException when company name already exists on create"() {
        given:
        CompanyDto companyDto = new CompanyDto(name: "Existing Company", departments: [])
        companyRepository.existsByName("Existing Company") >> true

        when:
        companyService.create(companyDto)

        then:
        thrown(ConflictException)
    }

    def "should delete company by id"() {
        given:
        Company company = new Company(id: 1, name: "Company 1")
        companyRepository.findByIdWithFulfilledData(1) >> Optional.of(company)

        when:
        companyService.delete(1)

        then:
        1 * companyRepository.delete(company)
    }
}