package com.innov.innovrobots.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Speaker extends AbstractEntity{
    private String firstName;
    private String lastName;
    private String cin;
    private String email;
    private String phone;
    private Date dob;
    private Gender gender;

    @ManyToOne
    @JoinColumn(name="event_id", nullable=false)
    @JsonIgnore
    private Event event;
}
