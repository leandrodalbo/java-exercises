package com.csv.api.demo.service;

import com.csv.api.demo.model.CSVModel;
import com.csv.api.demo.repository.CSVModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CSVModelService {
    private final CSVModelRepository repository;

    public CSVModelService(CSVModelRepository repository) {
        this.repository = repository;
    }

    public void saveMany(List<CSVModel> items) {
        repository.saveAll(items);
    }

    public CSVModel findByCustomerRef(Long customerRef) {
        return repository.findByCustomerRef(customerRef);
    }
}
