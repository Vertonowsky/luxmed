package com.example.luxmed.project;

import com.example.luxmed.manager.ManagerSerializer;

public class ProjectSerializer {

	public static ProjectDto serialize(Project project) {
		if (project == null)
			return null;

		ProjectDto projectDto = new ProjectDto();
		projectDto.setId(project.getId());
		projectDto.setManager(ManagerSerializer.serialize(project.getManager()));
		return projectDto;
	}

}
