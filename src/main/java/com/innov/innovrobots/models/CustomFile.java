package com.innov.innovrobots.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomFile extends AbstractEntity{

    private String fileName;

    @Lob
    private String data;

    public CustomFile(String fileName, String data){
        this.fileName = fileName;
        this.data = data;
    }

    @ManyToOne
    @JoinColumn(name="event_id")
    private Event event;
}
