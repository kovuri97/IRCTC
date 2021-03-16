package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Train;
import com.example.repository.TrainRepo;

@Service
public class TrainServiceImpl implements TrainService{
	@Autowired
	private TrainRepo trainRepo;

	@Override
	public Train addTrain(Train train) {
		// TODO Auto-generated method stub
		return trainRepo.save(train);
	}

	@Override
	public Train updateTrain(Train train) {
		// TODO Auto-generated method stub
		return trainRepo.save(train);
	}

	@Override
	public List<Train> getTrains() {
		// TODO Auto-generated method stub
		return trainRepo.findAll();
	}

}
