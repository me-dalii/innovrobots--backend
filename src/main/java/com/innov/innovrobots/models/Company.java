package com.innov.innovrobots.models;

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
public class Company extends AbstractEntity{
    private String name;
    private String description;
    private String email;
    private String phone;
    private String address;
    @ManyToOne
    @JoinColumn(name="event_id", nullable=false)
    private Event event;
}
