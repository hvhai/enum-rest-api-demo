package com.codehunter.enumrestapidemo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    Long id;
    String name;

    @Builder.Default
    Sex sex = Sex.MALE;


    public enum Sex {
        MALE("Male"), FEMALE("Female");
        public final String text;

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
}
