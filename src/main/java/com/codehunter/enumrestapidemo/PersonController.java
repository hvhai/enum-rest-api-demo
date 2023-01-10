package com.codehunter.enumrestapidemo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;
    @GetMapping
    public List<PersonDTO> getAll() {
        return personRepository.findAll()
                .stream()
                .map(PersonController::convertToDTO)
                .toList();
    }

    @PostMapping
    public PersonDTO create(@RequestBody PersonDTO personDTO) {
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setSex(personDTO.getSex());
        Person newPerson = personRepository.save(person);
        return convertToDTO(newPerson);
    }

    private static PersonDTO convertToDTO(Person newPerson) {
        return PersonDTO.builder().id(newPerson.getId())
                .name(newPerson.getName())
                .sex(newPerson.getSex())
                .build();
    }
}
