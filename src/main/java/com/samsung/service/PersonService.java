package com.samsung.service;

import com.samsung.domain.Person;

import java.util.List;

public interface PersonService {

    Person insert(Person person);

    List<Person> getAll();

    Person getById(int id);

    Person getByName(String name);

    Person update(int id, String namePerson, String surnamePerson, int room_numberPerson, int bed_numberPerson);

    void deleteById(int id);
}
