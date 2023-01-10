package com.codehunter.enumrestapidemo;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PersonSexualEnumJpaConverter implements AttributeConverter<PersonDTO.Sex, String> {
    @Override
    public String convertToDatabaseColumn(PersonDTO.Sex sex) {
        return sex.getText();
    }

    @Override
    public PersonDTO.Sex convertToEntityAttribute(String s) {
        return PersonDTO.Sex.of(s);
    }
}
