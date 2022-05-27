package com.samsung.service;

import com.samsung.domain.Problem;
import org.aspectj.weaver.patterns.PerObject;

import java.util.List;

public interface ProblemService {

    Problem insert(
            String nameProblem,
            String namePerson,
            String surnamePerson,
            int room_numberPerson,
            int bed_numberPerson
    );

    Problem update (
            int id,
            String nameProblem,
            String namePerson,
            String surnamePerson,
            int room_numberPerson,
            int bed_numberPerson
    );

    List<Problem> getAll();

    Problem getById(int id);

    List<Problem> getByName(String name);

    void deleteById(int id);

}
