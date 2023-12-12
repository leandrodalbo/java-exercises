package com.csv.api.demo.repository;

import com.csv.api.demo.model.CSVModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class CSVModelRepositoryTest {

    @Autowired
    private CSVModelRepository repository;

    @BeforeEach
    public void setup() {
        repository.saveAll(List.of(
                new CSVModel(
                        1L,
                        "customer-x",
                        "address line 1",
                        "address line 2",
                        "any town",
                        "unknown",
                        "any",
                        "any"
                ),
                new CSVModel(
                        2L,
                        "customer-y",
                        "address line 1",
                        "address line 2",
                        "any town",
                        "unknown",
                        "any",
                        "any"),
                new CSVModel(
                        3L,
                        "customer-z",
                        "address line 1",
                        "address line 2",
                        "any town",
                        "unknown",
                        "any",
                        "any")));
    }

    @Test
    public void shouldFindItByCustomerRef() {
        var result = repository.findById(2L);

        assertThat(result.get().getCustomerRef()).isEqualTo(2L);
        assertThat(result.get().getCustomerName()).isEqualTo("customer-y");

    }
}
