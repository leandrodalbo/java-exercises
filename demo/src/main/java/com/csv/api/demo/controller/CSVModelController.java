package com.csv.api.demo.controller;

import com.csv.api.demo.model.CSVModel;
import com.csv.api.demo.service.CSVModelService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/csv")
public class CSVModelController {

    private final CSVModelService service;

    public CSVModelController(CSVModelService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public void addMany(@RequestBody List<CSVModel> items) {
        service.saveMany(items);
    }

    @GetMapping("/{customerRef}")
    public CSVModel findByCustomerRef(@PathVariable Long customerRef) {
        return service.findByCustomerRef(customerRef);
    }

}
