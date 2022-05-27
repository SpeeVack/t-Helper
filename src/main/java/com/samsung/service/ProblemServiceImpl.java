package com.samsung.service;

import com.samsung.domain.Person;
import com.samsung.domain.Problem;
import com.samsung.repository.PersonRepository;
import com.samsung.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProblemServiceImpl implements ProblemService{

    private final PersonRepository personRepository;

    private final ProblemRepository problemRepository;

    @Override
    public Problem insert(String nameProblem, String namePerson, String surnamePerson, int room_numberPerson, int bed_numberPerson) {

        Person person = personRepository.findByName(namePerson);

        if (person == null){

           person = Person.builder()
                    .name(namePerson)
                   .surname(surnamePerson)
                   .room_number(room_numberPerson)
                   .bed_number(bed_numberPerson)
                   .build();
        }

        Problem problem = Problem.builder()
                .name(nameProblem)
                .person(person)
                .build();

        return problemRepository.save(problem);
    }

    @Override
    public Problem update(int id, String nameProblem, String namePerson, String surnamePerson, int room_numberPerson, int bed_numberPerson) {

        Person person = personRepository.findByName(namePerson);

        if (person == null){            //обновляем список проблем, возможно придётся удалять, т.к спринг будет менять проблему а не добавлять новую

            person = Person.builder()
                    .id(id)
                    .name(namePerson)
                    .surname(surnamePerson)
                    .room_number(room_numberPerson)
                    .bed_number(bed_numberPerson)
                    .build();
        }

        Problem problem = Problem.builder()
                .name(nameProblem)
                .person(person)
                .build();

        return problemRepository.save(problem);
    }

    @Override
    public List<Problem> getAll() {
        return problemRepository.findAll();
    }

    @Override
    public Problem getById(int id) {
        return problemRepository.getById(id);
    }

    @Override
    public List<Problem> getByName(String name) {
        return null;
                //problemRepository.findByName(nameProblem);
    }

    @Override
    public void deleteById(int id) {

           problemRepository.deleteById(id);
    }
}
