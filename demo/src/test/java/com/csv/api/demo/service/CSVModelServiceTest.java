package com.csv.api.demo.service;

import com.csv.api.demo.model.CSVModel;
import com.csv.api.demo.repository.CSVModelRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CSVModelServiceTest {

    private final List<CSVModel> items = List.of(new CSVModel(3L,
            "customer-z",
            "addres line 1",
            "address line 2",
            "any town",
            "unknown",
            "any",
            "any"));
    @Mock
    private CSVModelRepository repository;
    @InjectMocks
    private CSVModelService service;

    @Test
    public void willDelegateSavingToTheRepository() {
        when(repository.saveAll(any())).thenReturn(items);

        service.saveMany(items);

        verify(repository, times(1)).saveAll(any());
    }

    @Test
    public void willFindItByCustomerRef() {
        when(repository.findById(any())).thenReturn(Optional.of(items.get(0)));

        CSVModel result = service.findByCustomerRef(3L);

        assertThat(result).isEqualTo(items.get(0));
        verify(repository, times(1)).findById(any());
    }
}
