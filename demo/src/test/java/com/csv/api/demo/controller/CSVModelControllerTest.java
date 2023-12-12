package com.csv.api.demo.controller;

import com.csv.api.demo.model.CSVModel;
import com.csv.api.demo.service.CSVModelService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CSVModelController.class)
public class CSVModelControllerTest {

    private final List<CSVModel> values = List.of(new CSVModel(3L,
            "customer-z",
            "address line 1",
            "address line 2",
            "any town",
            "unknown",
            "any",
            "any"));

    @Autowired
    private MockMvc mvc;
    @MockBean
    private CSVModelService service;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void willSaveItemsAndReturn201() throws Exception {
        doNothing().when(service).saveMany(any());

        mvc.perform(post("/csv/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(values)))
                .andExpect(status().is2xxSuccessful());

        verify(service, times(1)).saveMany(any());
    }

    @Test
    public void willFindItUsingCustomerRef() throws Exception {
        when(service.findByCustomerRef(anyLong())).thenReturn(values.get(0));

        mvc.perform(get("/csv/3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());


        verify(service, times(1)).findByCustomerRef(anyLong());
    }
}
