package com.innov.innovrobots.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Event extends AbstractEntity{

    private String name;;
    private String description;
    private Date eventDate;
    private Date endDate;
    private Long numberOfDays;
    private String place;

    private boolean status;

    //planning

    @OneToMany(mappedBy="event")
    @JsonIgnore
    private List<Speaker> speakers;

    @OneToMany(mappedBy="event")
    @JsonIgnore
    private List<Committee> committees;

    @OneToMany(mappedBy="event")
    @JsonIgnore
    private List<Sponsor> sponsors;

    @OneToMany(mappedBy="event")
    @JsonIgnore
    private List<Student> students;
    private Long numberOfAllowedStudents;
    private Long studentsPrice;


    @OneToMany(mappedBy="event")
    @JsonIgnore
    private List<Teacher> teachers;
    private Long numberOfAllowedTeachers;
    private Long teachersPrice;

    @OneToMany(mappedBy="event")
    @JsonIgnore
    private List<Company> companies;
    private Long numberOfAllowedCompanies;
    private Long companiesPrice;


}
