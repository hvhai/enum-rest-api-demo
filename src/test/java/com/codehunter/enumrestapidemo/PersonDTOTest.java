package com.codehunter.enumrestapidemo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonDTOTest {
    @Test
    void emptyConstructor(){
        PersonDTO personDTO = new PersonDTO();
        assertThat(personDTO.sex).isEqualTo(Sex.MALE);
    }

    @Test
    void emptyBuilder(){
        PersonDTO personDTO = PersonDTO.builder().build();
        assertThat(personDTO.sex).isEqualTo(Sex.MALE);
    }

    @Test
    void builderWithName(){
        PersonDTO personDTO = PersonDTO.builder().name("Hai").build();
        assertThat(personDTO.sex).isEqualTo(Sex.MALE);
    }

    @Test
    void fullBuilder(){
        PersonDTO personDTO = PersonDTO.builder().id(1L).name("Han").sex(Sex.FEMALE).build();
        assertThat(personDTO.sex).isEqualTo(Sex.FEMALE);
    }

    @Test
    void fullArgConstructor(){
        PersonDTO personDTO = new PersonDTO(1L,"Han", Sex.FEMALE);
        assertThat(personDTO.sex).isEqualTo(Sex.FEMALE);
    }
}
