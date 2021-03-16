package com.example.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Routes {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	//@Size(min=3,max=3)
	private int routeId;
	@NotNull(message="source is required")
	@Pattern(regexp = "^[a-zA-Z]*$", message="source should contain only alphabates")
	private String source;
	@NotNull(message="destination is required")
	@Pattern(regexp = "^[a-zA-Z]*$", message="destination should contain only alphabates")
	private String destination;

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
	@Override
	public String toString() {
		return "Routes [routeId=" + routeId + ", source=" + source + ", destination=" + destination + ", train=" + "]";
	}

}
