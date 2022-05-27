package com.samsung.service;

import com.samsung.domain.Person;
import com.samsung.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    @Override
    public Person insert(Person person) {

        return personRepository.save(person);
    }

    @Override
    public List<Person> getAll() {

        return personRepository.findAll();
    }

    @Override
    public Person getById(int id) {

        return personRepository.getById(id);
    }

    @Override
    public Person getByName(String name) {

        return personRepository.findByName(name);
    }

    @Override
    public Person update(int id, String namePerson, String surnamePerson, int room_numberPerson, int bed_numberPerson) {

        Person person = Person.builder()
                .id(id)
                .name(namePerson)
                .surname(surnamePerson)
                .room_number(room_numberPerson)
                .bed_number(bed_numberPerson)
                .build();

        return personRepository.save(person);
    }

    @Override
    public void deleteById(int id) {

        personRepository.deleteById(id);
    }
}
