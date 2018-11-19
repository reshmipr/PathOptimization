package com.telstra.optimisepath.service.impl;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telstra.optimisepath.algorithm.BellmanHeldKarpAlgorithm;
import com.telstra.optimisepath.converter.OptimisePathConverter;
import com.telstra.optimisepath.dto.PathDTO;
import com.telstra.optimisepath.repository.PathRepository;
import com.telstra.optimisepath.service.OptimisePathService;


@Service
public class OptimisePathServiceimpl implements OptimisePathService {
	@Autowired
	PathRepository repo;



	@Override
	public void saveOptimalPath(PathDTO pathDTO) {
		repo.save(OptimisePathConverter.dtoToEntity(pathDTO));
	}

	

	@Override
	public PathDTO optimisePath(PathDTO pathDTO) {
		try {
			//call BellmanHeldKarpAlgorithm to get the optimal distance between cities
			BellmanHeldKarpAlgorithm algorithm = new BellmanHeldKarpAlgorithm();
			pathDTO = algorithm.getOptimisedPath(pathDTO);
			
			//save the optimal distance between cities into H2 database
			repo.save(OptimisePathConverter.dtoToEntity(pathDTO));
			System.out.println(pathDTO+"saved");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return pathDTO;
	}
}
