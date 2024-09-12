package com.example.luxmed.manager;

import com.example.luxmed.project.Project;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 64, nullable = false)
	private String name;

	@Column(length = 64, nullable = false)
	private String surname;

	@Column(length = 64, nullable = false)
	private String email;

	@Column(length = 11, nullable = false)
	private long phone;

	@OneToOne
	@JoinColumn(name = "project_id")
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
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
		Manager manager = (Manager) o;
		return phone == manager.phone && Objects.equals(name, manager.name) && Objects.equals(surname, manager.surname) && Objects.equals(email, manager.email) && Objects.equals(project, manager.project);
	}

}
