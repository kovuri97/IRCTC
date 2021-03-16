package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Roles;
import com.example.repository.RolesRepo;

@Service
public class RolesServiceImpl implements RolesService {
	@Autowired
	private RolesRepo rolesRepo;

	@Override
	public Roles addRoles(Roles roles) {
		// TODO Auto-generated method stub
		return rolesRepo.save(roles);
	}

	@Override
	public Roles updateRoles(Roles roles) {
		// TODO Auto-generated method stub
		return rolesRepo.save(roles);
	}

	@Override
	public List<Roles> getRoles() {
		// TODO Auto-generated method stub
		return rolesRepo.findAll();
	}

}
