package com.example.luxmed.department;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	void deleteAllByIdIn(Set<Integer> ids);

}
