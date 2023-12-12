package com.csv.api.demo.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CSVModelTest {

    @Test
    public void willCreateAnInstanceWithEveryField() {

        var model = new CSVModel(
                3L,
                "customer-z",
                "address line 1",
                "address line 2",
                "any town",
                "unknown",
                "any",
                "any");

        assertThat(model.getCustomerRef()).isNotNull();
        assertThat(model.getCustomerName()).isNotNull();
        assertThat(model.getAddressLine1()).isNotNull();
        assertThat(model.getAddressLine2()).isNotNull();
        assertThat(model.getCounty()).isNotNull();
        assertThat(model.getCountry()).isNotNull();
        assertThat(model.getTown()).isNotNull();
        assertThat(model.getPostcode()).isNotNull();
    }
}
