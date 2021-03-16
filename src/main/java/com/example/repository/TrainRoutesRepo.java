package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.TrainRoutes;
@Repository
public interface TrainRoutesRepo extends JpaRepository<TrainRoutes,Integer> {

}
