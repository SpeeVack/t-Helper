package com.samsung.repository;

import com.samsung.domain.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @DisplayName("должен добавлять пациента")
    @Test
    void shouldInsertAuthor() {

        Person expectedAuthor = Person.builder()
                .name("Иван")
                .surname("Орлов")
                .room_number(64)
                .bed_number(1)
                .build();

        personRepository.save(expectedAuthor);
        Person actualPerson = personRepository.getById(4);

        assertThat(actualPerson).isEqualTo(expectedAuthor);
    }

    @Test
    @DisplayName("должен удалять пациента по id")
    void shouldDeleteAuthorById(){

        int size = personRepository.findAll().size();

        personRepository.deleteById(1);


        int size1 = personRepository.findAll().size();

        assertThat(size).isEqualTo(size1 + 1);

    }
}