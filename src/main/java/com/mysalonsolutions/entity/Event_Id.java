package com.mysalonsolutions.entity;

import org.hibernate.annotations.GenericGenerator;
import com.google.DateTime;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;
import javax.persistence.*;
import java.util.Objects;



/**
 * A class to represent a salon reservation
 *
 * @author mhill
 */
@Entity(name="Event_Id")
@Table(name="event_id_base")
public class Event_Id {

    // Declare Class Instance Variables
    @Column(name = "prefix")
    private String prefix;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;


    /**
     * Zero-Argument Constructor to Instantiate a New Event Id
     */
    public Event_Id() {

    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event_Id)) return false;
        Event_Id event_id = (Event_Id) o;
        return getId() == event_id.getId() &&
                getPrefix().equals(event_id.getPrefix());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrefix(), getId());
    }
}