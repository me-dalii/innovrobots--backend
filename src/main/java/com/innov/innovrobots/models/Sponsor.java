package com.innov.innovrobots.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Sponsor extends AbstractEntity{

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name="event_id", nullable=false)
    private Event event;
}
