package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.RolesService;
import com.example.Service.RoutesService;
import com.example.Service.TrainRoutesService;
import com.example.Service.TrainService;
import com.example.model.Roles;
import com.example.model.Routes;
import com.example.model.Train;
import com.example.model.TrainRoutes;
import com.example.model.TrainsRoutes;

@RestController
@RequestMapping("/IRCTC")
public class TrainRouteSearchingController {
	@Autowired
	private RolesService rolesService;
	@Autowired
	private TrainService trainService;
	@Autowired
	private RoutesService routesService;
	@Autowired
	private TrainRoutesService trainRoutesService;

	@PostMapping("/register")
	public String addUsers(@RequestBody Roles roles) {
		if(!rolesService.getRoles().contains(roles)) {
			rolesService.addRoles(roles);
			return "successfully registered";
		}
		return "User alreay existed in IRCTC app";
	}
	@PostMapping("/login")
	public String login(String emailId,String password) {
		rolesService.getRoles().forEach(data->{
			if(data.getEmailId().equals(emailId) && data.getPassword().equals(password)) {
				return;
			}
		});
		return "unsuccessful login";
	}

	@PostMapping("/trains")
	public int addTrain(@RequestBody Train train) {
		return trainService.addTrain(train).getTrainId();
	}
	@PutMapping("/trains/{trainId}")
	public String updateTrain(@PathVariable int trainId,@RequestBody Train train)
	{
		trainService.updateTrain(train);
		return "Successfully updated";
	}
	@GetMapping("/getTrains")
	public List<Train> getTrains()
	{
		return trainService.getTrains();
	}
	@PostMapping("/routes")
	public int addRoute(@RequestBody Routes roles) {
		return routesService.addRoutes(roles).getRouteId();
	}
	@GetMapping("routesget")
	public List<Routes> getttRoute() {
		return routesService.getAll();
	}
	@PutMapping("routes1/{routeId}")
	public TrainsRoutes updateRoute(@PathVariable int routeId, String source, String destination ) {
		Routes r = new Routes();
		r.setRouteId(routeId);
		r.setSource(source);
		r.setDestination(destination);
		routesService.updateRoutes(r);
		TrainsRoutes t = new TrainsRoutes();
		t.setRouteId(routeId);
		t.setSource(source);
		t.setDestination(destination);
		List<Train> trains = new ArrayList<>();
		trainRoutesService.getTrainRoutes().forEach(values->{
			if(values.getRouteId()==routeId) {
				Train t2 = new Train();
				t2.setTrainId(values.getTrainId());
				t2.setTrainName(values.getTrainName());
				t2.setAmount(values.getAmount());
				trains.add(t2);
			}
		});
		t.setTrainList(trains);
		return t;
	}
	@GetMapping("routes/{routeid}")
	public TrainsRoutes getRoute(@PathVariable int routeid)
	{
		Routes r1= routesService.getRoute(routeid);
		Routes r = new Routes();
		r.setRouteId(r1.getRouteId());
		r.setSource(r1.getSource());
		r.setDestination(r1.getDestination());
		routesService.updateRoutes(r);
		TrainsRoutes t = new TrainsRoutes();
		t.setRouteId(routeid);
		t.setSource(r1.getSource());
		t.setDestination(r1.getDestination());
		List<Train> trains = new ArrayList<>();
		trainRoutesService.getTrainRoutes().forEach(values->{
			if(values.getRouteId()==routeid) {
				Train t2 = new Train();
				t2.setTrainId(values.getTrainId());
				t2.setTrainName(values.getTrainName());
				t2.setAmount(values.getAmount());
				trains.add(t2);
			}
		});
		t.setTrainList(trains);
		return t;
	}

	@DeleteMapping("routes/{routeid}/{trainid}")
	public void delete(@PathVariable int routeid, @PathVariable int trainid) {
		trainRoutesService.delete(trainid);
	}
	@GetMapping("routes/trains")
	public TrainsRoutes get(String source,String destination ){
		TrainsRoutes t = new TrainsRoutes();

		routesService.getAll().forEach(data->{
			if(data.getSource().equals(source) && data.getDestination().equals(destination)) {
				t.setSource(source);
				t.setDestination(destination);
				t.setRouteId(data.getRouteId());
				List<Train> trains = new ArrayList<>();
				trainRoutesService.getTrainRoutes().forEach(values->{
					if(values.getRouteId()==data.getRouteId()) {
						Train t2 = new Train();
						t2.setTrainId(values.getTrainId());
						t2.setTrainName(values.getTrainName());
						t2.setAmount(values.getAmount());
						trains.add(t2);
					}
				});
				t.setTrainList(trains);
			}
		});
		return t;
	}


	@PutMapping("routes/{routeId}")
	public TrainRoutes updateTrainRoutes(@PathVariable int routeId, @RequestBody Train train) {
		TrainRoutes trainRoutes = new TrainRoutes();
		trainRoutes.setRouteId(routeId);
		trainRoutes.setTrainId(train.getTrainId());
		trainRoutes.setTrainName(train.getTrainName());
		trainRoutes.setAmount(train.getAmount());
		return trainRoutesService.updateTrainRoutes(trainRoutes);
	}
}
