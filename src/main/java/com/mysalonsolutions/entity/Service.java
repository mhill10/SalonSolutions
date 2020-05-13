package com.mysalonsolutions.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;



/**
 * A class to represent a salon reservation
 *
 * @author mhill
 */
@Entity(name="Service")
@Table(name="allServices")
public class Service {


    // Declare Class Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int serviceId;
    @Column(name = "serviceName")
    private String serviceName;
    @Column(name = "serviceDescription")
    private String serviceDescription;

    /**
     * Zero-Argument Constructor to Instantiate a New Service
     */
    public Service() {

    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Service)) return false;
        Service service = (Service) o;
        return getServiceId() == service.getServiceId() &&
                getServiceName().equals(service.getServiceName()) &&
                getServiceDescription().equals(service.getServiceDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getServiceId(), getServiceName(), getServiceDescription());
    }
}