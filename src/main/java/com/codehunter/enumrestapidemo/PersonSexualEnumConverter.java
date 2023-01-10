package com.codehunter.enumrestapidemo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonSexualEnumConverter implements Converter<String, PersonDTO.Sex> {

    @Override
    public PersonDTO.Sex convert(String source) {
        return PersonDTO.Sex.of(source);
    }
}
