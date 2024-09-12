package com.example.luxmed.department;

import com.example.luxmed.team.TeamSerializer;

import java.util.stream.Collectors;

public class DepartmentSerializer {

	public static DepartmentDto serialize(Department department) {
		if (department == null)
			return null;

		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setId(department.getId());
		departmentDto.setName(department.getName());
		if (department.getTeams() != null)
			departmentDto.setTeams(department.getTeams().stream().map(TeamSerializer::serialize).collect(Collectors.toSet()));

		return departmentDto;
	}

}
