package com.jj.spring.assign4;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeRepository extends ReactiveMongoRepository<Fee, String> {
}