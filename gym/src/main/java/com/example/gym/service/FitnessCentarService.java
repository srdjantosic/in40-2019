package com.example.gym.service;
import com.example.gym.entity.FitnessCentar;

import java.util.List;
public interface FitnessCentarService {
	FitnessCentar findOne(Long id);

    List<FitnessCentar> findAll();

    FitnessCentar create(FitnessCentar fitnesscentar) throws Exception;

    FitnessCentar update(FitnessCentar fitnesscentar) throws Exception;

    FitnessCentar nadji(String naziv);
    
    void delete(Long id);
	
	
}
