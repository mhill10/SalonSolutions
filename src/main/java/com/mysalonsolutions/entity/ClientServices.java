package com.mysalonsolutions.entity;

import com.google.DateTime;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;


/**
 * A class to represent a guest's service timings
 *
 * @author mhill
 */
@Entity(name="ClientServices")
@Table(name="clientServices")
public class ClientServices {

    // Declare Class Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int clientServiceId;

    @JoinColumn(name = "clientId",
            foreignKey = @ForeignKey(name = "clientId__fk")
    )
    private int clientId;

    @JoinColumn(name = "allServiceId",
            foreignKey = @ForeignKey(name="proservices_ibfk_1"))
    private int allServiceId;

    @Column(name = "serviceDefaultStartDuration")
    private int serviceDefaultStartDuration;
    @Column(name = "serviceDefaultProcessDuration")
    private int serviceDefaultProcessDuration;
    @Column(name = "serviceDefaultEndDuration")
    private int serviceDefaultEndDuration;

    /**
     * Zero-Argument Constructor to Instantiate a New Reservation
     */
    public ClientServices() {

    }

    public int getClientServiceId() {
        return clientServiceId;
    }

    public void setClientServiceId(int clientServiceId) {
        this.clientServiceId = clientServiceId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getAllServiceId() {
        return allServiceId;
    }

    public void setAllServiceId(int allServiceId) {
        this.allServiceId = allServiceId;
    }

    public int getServiceDefaultStartDuration() {
        return serviceDefaultStartDuration;
    }

    public void setServiceDefaultStartDuration(int serviceDefaultStartDuration) {
        this.serviceDefaultStartDuration = serviceDefaultStartDuration;
    }

    public int getServiceDefaultProcessDuration() {
        return serviceDefaultProcessDuration;
    }

    public void setServiceDefaultProcessDuration(int serviceDefaultProcessDuration) {
        this.serviceDefaultProcessDuration = serviceDefaultProcessDuration;
    }

    public int getServiceDefaultEndDuration() {
        return serviceDefaultEndDuration;
    }

    public void setServiceDefaultEndDuration(int serviceDefaultEndDuration) {
        this.serviceDefaultEndDuration = serviceDefaultEndDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientServices)) return false;
        ClientServices that = (ClientServices) o;
        return getClientServiceId() == that.getClientServiceId() &&
                getClientId() == that.getClientId() &&
                getAllServiceId() == that.getAllServiceId() &&
                getServiceDefaultStartDuration() == that.getServiceDefaultStartDuration() &&
                getServiceDefaultProcessDuration() == that.getServiceDefaultProcessDuration() &&
                getServiceDefaultEndDuration() == that.getServiceDefaultEndDuration();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientServiceId(), getClientId(), getAllServiceId(), getServiceDefaultStartDuration(), getServiceDefaultProcessDuration(), getServiceDefaultEndDuration());
    }
}