package com.simple.rest.api.servicetranslator;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.simple.rest.api.constants.ErrorMessage;
import com.simple.rest.api.exception.ParameterNotFoundException;
import com.simple.rest.api.model.Contact;
import com.simple.rest.api.model.ContactResponse;
import com.simple.rest.api.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Override
    public ContactResponse getContactList() {
        try {
            ContactResponse response = new ContactResponse();
            InputStream is = getClass().getClassLoader().getResourceAsStream("people.csv");
            MappingIterator<Contact> peopleIteration = null;

            if(is != null) {
                peopleIteration = new CsvMapper().enable(CsvParser.Feature.IGNORE_TRAILING_UNMAPPABLE).readerWithTypedSchemaFor(Contact.class)
                        .readValues(is);
            }

            List<Contact> contacts = new ArrayList<>();
            if (peopleIteration != null) {
                contacts = peopleIteration.readAll();
            }
            contacts.remove(0);
            response.setContactList(contacts);
            return response;
        } catch (IOException e) {
            throw new ParameterNotFoundException(ErrorMessage.INVALID_PARAMETER_ERROR_CODE, ErrorMessage.INVALID_PARAMETER_ERROR_MESSAGE, HttpStatus.BAD_REQUEST);
        }
    }
}
