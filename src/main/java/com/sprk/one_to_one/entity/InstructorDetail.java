package com.sprk.one_to_one.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int instructorDetailId;

    private String hobby;

    private String education;

    @OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST})
    @JsonBackReference
    private Instructor instructor;
}
