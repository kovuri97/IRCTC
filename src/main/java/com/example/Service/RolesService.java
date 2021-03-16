package com.example.Service;

import java.util.List;

import com.example.model.Roles;

public interface RolesService {
	Roles addRoles(Roles roles);
	Roles updateRoles(Roles roles);
	List<Roles> getRoles();
}
