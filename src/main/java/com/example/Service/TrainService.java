package com.example.Service;

import java.util.List;

import com.example.model.Train;

public interface TrainService {
	Train addTrain(Train tain);
	Train updateTrain(Train tain);
	List<Train> getTrains();
}
