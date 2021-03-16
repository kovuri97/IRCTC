package com.example.Service;

import java.util.List;

import com.example.model.Routes;
import com.example.model.Train;

public interface RoutesService {
	Routes addRoutes(Routes routes);
	Routes updateRoutes(Routes routes);
	Routes getRoute(int id);
	List<Routes> getAll();
}
