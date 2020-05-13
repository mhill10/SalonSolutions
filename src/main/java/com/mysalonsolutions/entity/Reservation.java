package com.mysalonsolutions.entity;

import com.google.api.client.util.DateTime;
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
    private int resSalonId;

    @JoinColumn(name = "resServiceId",
            foreignKey = @ForeignKey(name = "reservationinfo_ibfk_2")
    )
    private int resServiceId;

    @Column(name = "resDateTime")
    private String resDateTime;

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

    public int getResSalonId() {
        return resSalonId;
    }

    public void setResSalonId(int resSalonId) {
        this.resSalonId = resSalonId;
    }

    public int getResServiceId() {
        return resServiceId;
    }

    public void setResServiceId(int resServiceId) {
        this.resServiceId = resServiceId;
    }

    public String getResDateTime() {
        return resDateTime;
    }

    public void setResDateTime(String resDateTime) {
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
                getResSalonId() == that.getResSalonId() &&
                getResServiceId() == that.getResServiceId() &&
                getResDateTime().equals(that.getResDateTime()) &&
                Objects.equals(getGoogleConfirmation(), that.getGoogleConfirmation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResId(), getResSalonId(), getResServiceId(), getResDateTime(), getGoogleConfirmation());
    }
}