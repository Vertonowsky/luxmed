package com.example.luxmed.team;

import com.example.luxmed.department.Department;
import com.example.luxmed.project.Project;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 128, nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "deparment_id")
	private Department department;

	@OneToOne(mappedBy = "team")
	private Project project;

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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Team team = (Team) o;
		return Objects.equals(name, team.name) && Objects.equals(department, team.department) && Objects.equals(project, team.project);
	}

}
