package com.example.luxmed.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	@Query("SELECT c FROM Company c LEFT JOIN FETCH c.departments d LEFT JOIN FETCH d.teams t LEFT JOIN FETCH t.project p LEFT JOIN FETCH p.manager WHERE c.id = :id")
	Optional<Company> findByIdWithFulfilledData(@Param(value = "id") int id);

	@Query("SELECT c FROM Company c LEFT JOIN FETCH c.departments d LEFT JOIN FETCH d.teams t LEFT JOIN FETCH t.project p LEFT JOIN FETCH p.manager")
	Set<Company> findAllWithFulfilledData();

	boolean existsByName(@Param(value = "name") String name);

}
