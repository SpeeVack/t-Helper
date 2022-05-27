package com.samsung.rest.dto;

import com.samsung.domain.Problem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProblemDto {

    private int id;

    private String name;

    private PersonDto personDto;

    public static ProblemDto toDto(Problem problem){

        return new ProblemDto(
                problem.getId(),
                problem.getName(),
                PersonDto.toDto(problem.getPerson()));
    }



}
