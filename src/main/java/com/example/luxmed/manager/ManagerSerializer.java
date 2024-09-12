package com.example.luxmed.manager;

public class ManagerSerializer {

	public static ManagerDto serialize(Manager manager) {
		if (manager == null)
			return null;

		ManagerDto managerDto = new ManagerDto();
		managerDto.setId(manager.getId());
		managerDto.setName(manager.getName());
		managerDto.setSurname(manager.getSurname());
		managerDto.setEmail(manager.getEmail());
		managerDto.setPhone(manager.getPhone());
		return managerDto;
	}

}
