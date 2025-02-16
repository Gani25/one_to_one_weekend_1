package com.sprk.one_to_one.controller;

import com.sprk.one_to_one.entity.Instructor;
import com.sprk.one_to_one.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;

    @PostMapping("/instructor")
    public Instructor saveInstructor(@RequestBody Instructor instructor) {

//        System.out.println("Instructor: "+instructor);
//        System.out.println("Instructor Detail: "+instructor.getInstructorDetail());

        Instructor instructorSaved = instructorRepository.save(instructor);

        return instructorSaved;
    }
}
