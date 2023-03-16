package com.codehunter.enumrestapidemo;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PersonSexualEnumJpaConverter implements AttributeConverter<Sex, String> {
    @Override
    public String convertToDatabaseColumn(Sex sex) {
        return sex.getText();
    }

    @Override
    public Sex convertToEntityAttribute(String s) {
        return Sex.of(s);
    }
}
