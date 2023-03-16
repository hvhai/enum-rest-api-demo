package com.codehunter.enumrestapidemo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonSexualEnumConverter implements Converter<String, Sex> {

    @Override
    public Sex convert(String source) {
        return Sex.of(source);
    }
}
