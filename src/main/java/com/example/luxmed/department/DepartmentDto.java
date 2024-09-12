package com.example.luxmed.department;

import com.example.luxmed.company.CompanyDto;
import com.example.luxmed.team.TeamDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentDto {

	private int id;
	private String name;
	private CompanyDto company;
	private Set<TeamDto> teams;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CompanyDto getCompany() {
		return company;
	}

	public void setCompany(CompanyDto company) {
		this.company = company;
	}

	public Set<TeamDto> getTeams() {
		return teams;
	}

	public void setTeams(Set<TeamDto> teams) {
		this.teams = teams;
	}
}
