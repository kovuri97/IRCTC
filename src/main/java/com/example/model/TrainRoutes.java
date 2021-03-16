package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class TrainRoutes {
	@Id
	private int trainId;
	@NotNull(message="train name is required")
	private String trainName;
	private int routeId;
	private double amount;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	@Override
	public String toString() {
		return "TrainRoutes [trainId=" + trainId + ", trainName=" + trainName + ", routeId=" + routeId + "]";
	}
	
}
