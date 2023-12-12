package com.csv.api.demo.repository;

import com.csv.api.demo.model.CSVModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CSVModelRepository extends CrudRepository<CSVModel, Long> {

    CSVModel findByCustomerRef(Long customerRef);
}
