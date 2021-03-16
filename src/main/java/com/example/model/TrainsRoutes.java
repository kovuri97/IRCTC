package com.example.model;

import java.util.ArrayList;
import java.util.List;


public class TrainsRoutes {
	private int routeId;
	private String source;
	private String destination;
	private List<Train> trainList = new ArrayList<>();
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public List<Train> getTrainList() {
		return trainList;
	}
	public void setTrainList(List<Train> trainList) {
		this.trainList = trainList;
	}
}
