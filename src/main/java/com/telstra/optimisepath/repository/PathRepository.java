package com.telstra.optimisepath.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.telstra.optimisepath.entity.Path;

@Repository
public interface PathRepository extends MongoRepository<Path, String>{
}
