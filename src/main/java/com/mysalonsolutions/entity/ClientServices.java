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

    @JoinColumn(name = "userId",
            foreignKey = @ForeignKey(name = "role_ibfk_1")
    )

    @JoinColumn(name = "allServiceId",
            foreignKey = @ForeignKey(name="proservices_ibfk_1"))
    private String allServiceId;

    @Column(name = "serviceDefaultStartDuration")
    private String serviceDefaultStartDuration;
    @Column(name = "serviceDefaultProcessDuration")
    private DateTime serviceDefaultProcessDuration;
    @Column(name = "serviceDefaultEndDuration")
    private DateTime serviceDefaultEndDuration;

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

    public String getAllServiceId() {
        return allServiceId;
    }

    public void setAllServiceId(String allServiceId) {
        this.allServiceId = allServiceId;
    }

    public String getServiceDefaultStartDuration() {
        return serviceDefaultStartDuration;
    }

    public void setServiceDefaultStartDuration(String serviceDefaultStartDuration) {
        this.serviceDefaultStartDuration = serviceDefaultStartDuration;
    }

    public DateTime getServiceDefaultProcessDuration() {
        return serviceDefaultProcessDuration;
    }

    public void setServiceDefaultProcessDuration(DateTime serviceDefaultProcessDuration) {
        this.serviceDefaultProcessDuration = serviceDefaultProcessDuration;
    }

    public DateTime getServiceDefaultEndDuration() {
        return serviceDefaultEndDuration;
    }

    public void setServiceDefaultEndDuration(DateTime serviceDefaultEndDuration) {
        this.serviceDefaultEndDuration = serviceDefaultEndDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientServices)) return false;
        ClientServices that = (ClientServices) o;
        return getClientServiceId() == that.getClientServiceId() &&
                getAllServiceId().equals(that.getAllServiceId()) &&
                getServiceDefaultStartDuration().equals(that.getServiceDefaultStartDuration()) &&
                Objects.equals(getServiceDefaultProcessDuration(), that.getServiceDefaultProcessDuration()) &&
                Objects.equals(getServiceDefaultEndDuration(), that.getServiceDefaultEndDuration());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientServiceId(), getAllServiceId(), getServiceDefaultStartDuration(), getServiceDefaultProcessDuration(), getServiceDefaultEndDuration());
    }
}