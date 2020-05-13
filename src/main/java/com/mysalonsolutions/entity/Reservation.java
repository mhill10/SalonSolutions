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

    @JoinColumn(name = "resSalonId",
            foreignKey = @ForeignKey(name = "reservationinfo_ibfk_1")
    )
    private String resSalonId;

    @JoinColumn(name = "resServiceId",
            foreignKey = @ForeignKey(name = "reservationinfo_ibfk_2")
    )
    private String resServiceId;
    @Column(name = "resDateTime")
    private DateTime resDateTime;
    @Column(name="googleConfirmation")
    private String googleConfirmation;


    /**
     * Zero-Argument Constructor to Instantiate a New Reservation
     */
    public Reservation() {

    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
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

    public String getGoogleConfirmation() {
        return googleConfirmation;
    }

    public void setGoogleConfirmation(String googleConfirmation) {
        this.googleConfirmation = googleConfirmation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return getResId() == that.getResId() &&
                getResSalonId().equals(that.getResSalonId()) &&
                getResServiceId().equals(that.getResServiceId()) &&
                getResDateTime().equals(that.getResDateTime()) &&
                Objects.equals(getGoogleConfirmation(), that.getGoogleConfirmation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResId(), getResSalonId(), getResServiceId(), getResDateTime(), getGoogleConfirmation());
    }
}