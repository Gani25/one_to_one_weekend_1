package com.sprk.one_to_one.controller;

import com.sprk.one_to_one.entity.Instructor;
import com.sprk.one_to_one.entity.InstructorDetail;
import com.sprk.one_to_one.repository.InstructorDetailRepository;
import com.sprk.one_to_one.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstructorDetailController {

    @Autowired
    private InstructorDetailRepository instructorDetailRepository;

    @GetMapping("/instructor-detail/{ins_detail_id}")
    public InstructorDetail getInstructorDetailById(@PathVariable int ins_detail_id) {

        InstructorDetail dbInstructorDetail = instructorDetailRepository.findById(ins_detail_id).get();

        return dbInstructorDetail;


    }

    @GetMapping("/instructor_by_detail/{ins_detail_id}")
    public Instructor getInstructorByDetailId(@PathVariable int ins_detail_id) {

        InstructorDetail dbInstructorDetail = instructorDetailRepository.findById(ins_detail_id).get();

        Instructor instructor = dbInstructorDetail.getInstructor();

        return instructor;


    }

}
