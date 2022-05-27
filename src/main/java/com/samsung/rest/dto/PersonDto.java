package com.samsung.rest.dto;

import com.samsung.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDto {

    private int id;

    private String name;

    private String surname;

    private int room_number;

    private int bed_number;


    public static PersonDto toDto(Person person) {

        return new PersonDto(
                person.getId(),
                person.getName(),
                person.getSurname(),
                person.getRoom_number(),
                person.getBed_number()
        );
    }

    public static Person toDomainObject(PersonDto personDto) {

        return new Person(
                personDto.getId(),
                personDto.getName(),
                personDto.getSurname(),
                personDto.getRoom_number(),
                personDto.getBed_number()
        );
    }

}
