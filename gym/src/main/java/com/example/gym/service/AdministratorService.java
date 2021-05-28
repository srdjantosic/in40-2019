package com.example.gym.service;
import com.example.gym.entity.Administrator;

import java.util.List;

public interface AdministratorService {

	 Administrator findOne(Long id);

	    List<Administrator> findAll();

	    Administrator create(Administrator administrator) throws Exception;

	    Administrator update(Administrator administrator) throws Exception;

	    void delete(Long id);
}
