package com.samsung.service;

import com.samsung.domain.Person;
import com.samsung.domain.Problem;
import com.samsung.repository.PersonRepository;
import com.samsung.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonDemoService {

    private final PersonService personService;

    private final ProblemService problemService;

    public void personDemo(){

        List<Person> personList = personService.getAll();

        System.out.println("===============================================================");
        for (Person person : personList){

            System.out.println(person);
        }
        System.out.println("===============================================================");


        personService.update(1, "Элеонора", "Сагайдак", 58, 2);
        personList = personService.getAll();

        System.out.println("===============================================================");
        for (Person person1 : personList){

            System.out.println(person1);
        }
        System.out.println("===============================================================");


    }

    @Transactional
    public void problemDemo(){

        List<Problem> problemList = problemService.getAll();

        for (Problem problem : problemList){

            System.out.print(problem.getName()+ ": ");

            System.out.println(problem.getPerson().getName()+" "+ problem.getPerson().getSurname()
                    + "; палата: "+ problem.getPerson().getRoom_number()+ "; койка: "
                    + problem.getPerson().getBed_number());

            System.out.println();
        }

        problemService.insert("Требуется акт дефекации",
                "Ирина",
                "Рагулина",
                7,
                3);

        problemList = problemService.getAll();

        for (Problem problem : problemList){

            System.out.print(problem.getName()+ ": ");

            System.out.println(problem.getPerson().getName()+" "+ problem.getPerson().getSurname()
                    + "; палата: "+ problem.getPerson().getRoom_number()+ "; койка: "
                    + problem.getPerson().getBed_number());

            System.out.println();
        }

    }


}
