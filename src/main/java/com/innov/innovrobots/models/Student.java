package com.innov.innovrobots.models;

import com.innov.innovrobots.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Student extends AbstractEntity{

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Date dob;
    private Gender gender;
    private String university;
    private String grade;

    @ManyToOne
    @JoinColumn(name="event_id", nullable=false)
    private Event event;
}
