package com.example.luxmed.project;

import com.example.luxmed.manager.ManagerDto;
import com.example.luxmed.team.TeamDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDto {

	private int id;
	private TeamDto team;
	private ManagerDto manager;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TeamDto getTeam() {
		return team;
	}

	public void setTeam(TeamDto team) {
		this.team = team;
	}

	public ManagerDto getManager() {
		return manager;
	}

	public void setManager(ManagerDto manager) {
		this.manager = manager;
	}
}
