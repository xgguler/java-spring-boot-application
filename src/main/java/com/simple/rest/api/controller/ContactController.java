package com.simple.rest.api.controller;

import com.simple.rest.api.exception.ParameterNotFoundException;
import com.simple.rest.api.model.ContactResponse;
import com.simple.rest.api.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
@Validated
@AllArgsConstructor
public class ContactController {
    private final ContactService service;

    @GetMapping(value = "/contact-list", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContactResponse> play() {
        try {
            ContactResponse contactResponse = service.getContactList();
            return new ResponseEntity<>(contactResponse, HttpStatus.OK);
        } catch (ParameterNotFoundException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getErrorCode(), e);
        }
    }
}
