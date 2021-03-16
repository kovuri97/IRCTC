package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Routes;
import com.example.repository.RotuesRepo;

@Service
public class RoutesServiceImpl implements RoutesService {
	
	@Autowired
	private RotuesRepo routesRepo;

	@Override
	public Routes  addRoutes(Routes routes) {
		// TODO Auto-generated method stub
		return routesRepo.save(routes);
	}

	@Override
	public Routes updateRoutes(Routes routes) {
		// TODO Auto-generated method stub
		return routesRepo.save(routes);
	}

	@Override
	public Routes getRoute(int id) {
		// TODO Auto-generated method stub
		Optional<Routes> r = routesRepo.findById(id);
		if(r.isPresent()) {
			return r.get();
		}
		return null;
	}

	@Override
	public List<Routes> getAll() {
		// TODO Auto-generated method stub
		return routesRepo.findAll();
	}

}
