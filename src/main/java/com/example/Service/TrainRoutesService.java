package com.example.Service;

import java.util.List;

import com.example.model.TrainRoutes;

public interface TrainRoutesService {
	List<TrainRoutes> getTrainRoutes();
	void delete(int trainId);
	TrainRoutes updateTrainRoutes(TrainRoutes trainRoutes);
}
