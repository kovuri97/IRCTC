package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.TrainRoutes;
import com.example.repository.TrainRoutesRepo;

@Service
public class TrainRoutesServiceImpl implements TrainRoutesService {
	@Autowired
	private TrainRoutesRepo trainRoutesRepo;

	@Override
	public List<TrainRoutes> getTrainRoutes() {
		// TODO Auto-generated method stub
		return trainRoutesRepo.findAll();
	}

	@Override
	public void delete(int trainId) {
		trainRoutesRepo.deleteById(trainId);
		// TODO Auto-generated method stub
		
	}

	@Override
	public TrainRoutes updateTrainRoutes(TrainRoutes trainRoutes) {
		// TODO Auto-generated method stub
		return trainRoutesRepo.save(trainRoutes);
	}


}
