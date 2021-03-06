package com.mysalonsolutions.entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A class to represent a salon user
 *
 * @author mhill
 */
@Entity(name="User")
@Table(name="user")
public class User {

    // Declare Class Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "userEmailAddress")
    private String userEmailAddress;
    @Column(name = "userPassword")
    private String userPassword;
    @Column(name = "userDisplayName")
    private String userDisplayName;
    @Column(name = "userFirstName")
    private String userFirstName;
    @Column(name = "userLastName")
    private String userLastName;
    @Column(name = "userPhone")
    private String userPhone;
    @Column(name = "userStreetAddress")
    private String userStreetAddress;
    @Column(name = "userCity")
    private String userCity;
    @Column(name = "userState")
    private String userState;
    @Column(name = "userZip")
    private String userZipCode;
    @Column(name = "userProfilePic")
    private String userProfilePic;


    /**
     * Zero-Argument Constructor to Instantiate a New User
     */
    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserDisplayName() {
        return userDisplayName;
    }

    public void setUserDisplayName(String userDisplayName) {
        this.userDisplayName = userDisplayName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserStreetAddress() {
        return userStreetAddress;
    }

    public void setUserStreetAddress(String userStreetAddress) {
        this.userStreetAddress = userStreetAddress;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getUserZipCode() {
        return userZipCode;
    }

    public void setUserZipCode(String userZipCode) {
        this.userZipCode = userZipCode;
    }

    public String getUserProfilePic() {
        return userProfilePic;
    }

    public void setUserProfilePic(String userProfilePic) {
        this.userProfilePic = userProfilePic;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + id +
                ", userEmailAddress='" + userEmailAddress + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userStreetAddress='" + userStreetAddress + '\'' +
                ", userCity='" + userCity + '\'' +
                ", userState='" + userState + '\'' +
                ", userZipCode='" + userZipCode + '\'' +
                ", userProfilePic='" + userProfilePic + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userEmailAddress, userPassword, userFirstName, userLastName, userPhone, userEmailAddress);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return id == user.id &&
                Objects.equals(userEmailAddress, user.userEmailAddress) &&
                Objects.equals(userPassword, user.userPassword) &&
                Objects.equals(userFirstName, user.userFirstName) &&
                Objects.equals(userLastName, user.userLastName) &&
                Objects.equals(userPhone, user.userPhone) &&
                Objects.equals(userStreetAddress, user.userStreetAddress) &&
                Objects.equals(userCity, user.userCity) &&
                Objects.equals(userState, user.userState) &&
                Objects.equals(userZipCode, user.userZipCode) &&
                Objects.equals(userProfilePic, user.userProfilePic);
    }
}