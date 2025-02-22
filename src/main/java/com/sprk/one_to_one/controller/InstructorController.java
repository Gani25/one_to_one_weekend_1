package com.sprk.one_to_one.controller;

import com.sprk.one_to_one.entity.Instructor;
import com.sprk.one_to_one.entity.InstructorDetail;
import com.sprk.one_to_one.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/instructor/{insId}")
    public Instructor updateInstructor(@PathVariable int insId, @RequestBody Instructor updatedInstructor) {
        Instructor dbInstructor = instructorRepository.findById(insId).orElse(null);
        InstructorDetail dbInstructorDetail = dbInstructor.getInstructorDetail(); // Db Detail
        InstructorDetail newInstructorDetail = updatedInstructor.getInstructorDetail(); // From API Call
        if(dbInstructor != null) {
            // Logic For Update
            if(updatedInstructor.getFirstName() != null && !updatedInstructor.getFirstName().isBlank()){
                dbInstructor.setFirstName(updatedInstructor.getFirstName());
            }
            if(updatedInstructor.getLastName() != null && !updatedInstructor.getLastName().isBlank()){
                dbInstructor.setLastName(updatedInstructor.getLastName());
            }
            if(updatedInstructor.getPhone() != null && !updatedInstructor.getPhone().isBlank()){
                dbInstructor.setPhone(updatedInstructor.getPhone());
            }

            if(newInstructorDetail != null){

                if (dbInstructorDetail != null)
                {
                    if(newInstructorDetail.getHobby() != null && !newInstructorDetail.getHobby().isBlank()){
                        dbInstructorDetail.setHobby(newInstructorDetail.getHobby());
                    }
                    if (newInstructorDetail.getEducation() != null && !newInstructorDetail.getEducation().isBlank()){
                        dbInstructorDetail.setEducation(newInstructorDetail.getEducation());
                    }


                    // dbInstructorDetail will be having detail id so this will also update
                    dbInstructor.setInstructorDetail(dbInstructorDetail);
                }else{
                    dbInstructor.setInstructorDetail(newInstructorDetail);
                }



            }

            // Update
            // db instructor will be having id so it will update
            Instructor postUpdatedInstructor = instructorRepository.save(dbInstructor);

            return postUpdatedInstructor;

        }
        else {
            return null;
        }
    }

    @DeleteMapping("/instructor/{insId}")
    public Instructor deleteInstructor(@PathVariable int insId) {
        Instructor dbInstructor = instructorRepository.findById(insId).orElse(null);
        if (dbInstructor != null) {
            instructorRepository.delete(dbInstructor);
            return dbInstructor;
        } else {
            return null;
        }
    }

    @GetMapping("/instructor/{ins_id}")
    public Instructor getInstructorById(@PathVariable int ins_id) {

        Instructor dbInstructor = instructorRepository.findById(ins_id).get();

        return dbInstructor;


    }
}
