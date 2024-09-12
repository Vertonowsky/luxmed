package com.example.luxmed.project;

import com.example.luxmed.manager.Manager;
import com.example.luxmed.team.Team;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "team_id")
	private Team team;

	@OneToOne(mappedBy = "project")
	private Manager manager;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Project project = (Project) o;
		return Objects.equals(team, project.team) && Objects.equals(manager, project.manager);
	}

	@Override
	public int hashCode() {
		return Objects.hash(team, manager);
	}
}
