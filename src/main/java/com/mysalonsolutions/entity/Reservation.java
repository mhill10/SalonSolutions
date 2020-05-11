package com.mysalonsolutions.entity;

import com.google.DateTime;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;


/**
 * A class to represent a salon reservation
 *
 * @author mhill
 */
@Entity(name="Reservation")
@Table(name="reservationInfo")
public class Reservation {

    // Declare Class Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int resId;
    @Column(name = "resSalonId")
    private String resSalonId;
    @Column(name = "resServiceId")
    private String resServiceId;
    @Column(name = "resDateTime")
    private DateTime resDateTime;


    /**
     * Zero-Argument Constructor to Instantiate a New Reservation
     */
    public Reservation() {

    }

    public int getId() {
        return resId;
    }

    public void setId(int resId) {
        this.resId = resId;
    }



    public String getResSalonId() {
        return resSalonId;
    }

    public void setResSalonId(String resSalonId) {
        this.resSalonId = resSalonId;
    }

    public String getResServiceId() {
        return resServiceId;
    }

    public void setResServiceId(String resServiceId) {
        this.resServiceId = resServiceId;
    }

    public DateTime getResDateTime() {
        return resDateTime;
    }

    public void setResDateTime(DateTime resDateTime) {
        this.resDateTime = resDateTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return resId == that.resId &&
                getResSalonId().equals(that.getResSalonId()) &&
                getResServiceId().equals(that.getResServiceId()) &&
                getResDateTime().equals(that.getResDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(resId, getResSalonId(), getResServiceId(), getResDateTime());
    }

}