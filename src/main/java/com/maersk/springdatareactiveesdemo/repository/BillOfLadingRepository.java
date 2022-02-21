package com.maersk.springdatareactiveesdemo.repository;

import com.maersk.springdatareactiveesdemo.model.BillOfLading;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillOfLadingRepository extends ReactiveCrudRepository<BillOfLading, String> {

}
