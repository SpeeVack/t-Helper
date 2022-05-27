package com.samsung.rest.controller;

import com.samsung.domain.Problem;
import com.samsung.rest.dto.ProblemDto;
import com.samsung.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProblemController {

    private final ProblemService problemService;

    @GetMapping("/problem")
    public List<ProblemDto> getAllProblem() {

        List<ProblemDto> problemDtoList = problemService.getAll().stream().map(ProblemDto::toDto).collect(Collectors.toList());

        return problemDtoList;
    }

    @PostMapping("/problem")
    public ProblemDto insertProblem(@RequestParam String nameProblem, @RequestParam String namePerson,
                                    @RequestParam String surnamePerson, @RequestParam int room_number,
                                    @RequestParam int bed_number) {

        Problem problem = problemService.insert(nameProblem, namePerson, surnamePerson, room_number, bed_number);

        System.out.println(problem.toString());

        return ProblemDto.toDto(problem);
    }

    @PutMapping("/problem/{id}")
    public ProblemDto updateProblem(@PathVariable int id,
                                    @RequestParam String nameProblem, @RequestParam String namePerson,
                                    @RequestParam String surnamePerson, @RequestParam int room_number,
                                    @RequestParam int bed_number) {

        Problem problem = problemService.update(id, nameProblem, namePerson, surnamePerson, room_number, bed_number);
        return ProblemDto.toDto(problem);
    }

    @GetMapping("/problem/{id}")
    public ProblemDto getProblemById(@PathVariable int id){

        return ProblemDto.toDto(problemService.getById(id));
    }

    @DeleteMapping("problem/{id}")
    public void deleteProblem(@PathVariable int id){
        problemService.deleteById(id);
    }

}
