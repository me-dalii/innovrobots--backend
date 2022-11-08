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

    private String description;
    private Date eventDate;
    private Date endDate;
    private Long numberOfDays;
    private String place;
    private Long participantsEstimation;

    //planning

    @OneToMany(mappedBy="event")
    private List<Speaker> speakers;

    @OneToMany(mappedBy="event")
    private List<Committee> committees;

    @OneToMany(mappedBy="event")
    private List<Sponsor> sponsors;


}