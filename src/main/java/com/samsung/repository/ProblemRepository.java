package com.samsung.repository;

import com.samsung.domain.Problem;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProblemRepository extends JpaRepository<Problem, Integer> {

    @Override
    @EntityGraph(attributePaths = {"person"})
    List<Problem> findAll();
}
