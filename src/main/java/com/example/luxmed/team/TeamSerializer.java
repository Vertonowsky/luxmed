package com.example.luxmed.team;

import com.example.luxmed.project.ProjectSerializer;

public class TeamSerializer {

	public static TeamDto serialize(Team team) {
		if (team == null)
			return null;

		TeamDto teamDto = new TeamDto();
		teamDto.setId(team.getId());
		teamDto.setName(team.getName());
		teamDto.setProject(ProjectSerializer.serialize(team.getProject()));
		return teamDto;
	}

}
