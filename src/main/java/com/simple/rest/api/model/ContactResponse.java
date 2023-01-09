package com.simple.rest.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.List;

@Validated
@Getter
@Setter
public class ContactResponse {

    @JsonProperty("contactList")
    private List<Contact> contactList;
}
