package com.codehunter.enumrestapidemo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Sex {
        MALE("Male"), FEMALE("Female");
        final String text;

        @JsonValue
        public String getText() {
            return text;
        }

        Sex(String text) {
            this.text = text;
        }

        @JsonCreator
        public static Sex of(String value) {
            if (null == value) {
                return Sex.MALE;
            }

            for (Sex item : Sex.values()) {
                if (value.equals(item.getText())) {
                    return item;
                }
            }

            throw new UnknownEnumValueException("GenderEnum: unknown value: " + value);
        }
    }
