package edu.matc.entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a guest user
 *
 * @author mhill
 */
@Entity(name="GuestUser")
@Table(name="guestUser")
public class GuestUser {

    // Declare Class Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int guestUserId;
    @Column(name = "guestEmailAddress")
    private String guestEmailAddress;
    @Column(name = "guestPassword")
    private String guestPassword;
    @Column(name = "guestFirstName")
    private String guestFirstName;
    @Column(name = "guestLastName")
    private String guestLastName;
    @Column(name = "guestStreetAddress")
    private String guestStreetAddress;
    @Column(name = "guestCity")
    private String guestCity;
    @Column(name = "guestState")
    private String guestState;
    @Column(name = "guestZipCode")
    private String guestZipCode;
    @Column(name = "guestProfilePic")
    private String guestProfilePic;


    // Add logging to this class
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * Zero-Argument Constructor to Instantiate a New GuestUser
     */
    public GuestUser() {

    }

    /**
     *
     * @return the guestUserId
     */
    public int getGuestUserId() {
        return guestUserId;
    }

    /**
     * Sets the userId of the Guest
     * @param guestUserId the userId of the Guest
     */
    public void setGuestUserId(int guestUserId) {
        this.guestUserId = guestUserId;
    }

    /**
     *
     * @return
     */
    public String getGuestEmailAddress() {
        return guestEmailAddress;
    }

    /**
     *
     * @param guestEmailAddress
     */
    public void setGuestEmailAddress(String guestEmailAddress) {
        this.guestEmailAddress = guestEmailAddress;
    }

    /**
     *
     * @return
     */
    public String getGuestPassword() {
        return guestPassword;
    }

    /**
     *
     * @param guestPassword
     */
    public void setGuestPassword(String guestPassword) {
        this.guestPassword = guestPassword;
    }

    /**
     *
     * @return
     */
    public String getGuestFirstName() {
        return guestFirstName;
    }

    /**
     *
     * @param guestFirstName
     */
    public void setGuestFirstName(String guestFirstName) {
        this.guestFirstName = guestFirstName;
    }

    /**
     *
     * @return
     */
    public String getGuestLastName() {
        return guestLastName;
    }

    /**
     *
     * @param guestLastName
     */
    public void setGuestLastName(String guestLastName) {
        this.guestLastName = guestLastName;
    }

    /**
     *
     * @return
     */
    public String getGuestStreetAddress() {
        return guestStreetAddress;
    }

    /**
     *
     * @param guestStreetAddress
     */
    public void setGuestStreetAddress(String guestStreetAddress) {
        this.guestStreetAddress = guestStreetAddress;
    }

    /**
     *
     * @return
     */
    public String getGuestCity() {
        return guestCity;
    }

    /**
     *
     * @param guestCity
     */
    public void setGuestCity(String guestCity) {
        this.guestCity = guestCity;
    }

    /**
     *
     * @return
     */
    public String getGuestState() {
        return guestState;
    }

    /**
     *
     * @param guestState
     */
    public void setGuestState(String guestState) {
        this.guestState = guestState;
    }

    /**
     *
     * @return
     */
    public String getGuestZipCode() {
        return guestZipCode;
    }

    /**
     *
     * @param guestZipCode
     */
    public void setGuestZipCode(String guestZipCode) {
        this.guestZipCode = guestZipCode;
    }

    /**
     *
     * @return
     */
    public String getGuestProfilePic() {
        return guestProfilePic;
    }

    /**
     *
     * @param guestProfilePic
     */
    public void setGuestProfilePic(String guestProfilePic) {
        this.guestProfilePic = guestProfilePic;
    }


    /**
     *
     * @return the GuestUser Class instance variables as a String
     */
    @java.lang.Override
    public java.lang.String toString() {
        return "GuestUser{" +
                "guestUserId=" + guestUserId +
                ", guestEmailAddress='" + guestEmailAddress + '\'' +
                ", guestPassword='" + guestPassword + '\'' +
                ", guestFirstName='" + guestFirstName + '\'' +
                ", guestLastName='" + guestLastName + '\'' +
                ", guestStreetAddress='" + guestStreetAddress + '\'' +
                ", guestCity='" + guestCity + '\'' +
                ", guestState='" + guestState + '\'' +
                ", guestZipCode='" + guestZipCode + '\'' +
                ", guestProfilePic='" + guestProfilePic + '\'' +
                '}';
    }


    //logger.info("Some message you want logged");
    //logger.error("Some message you want logged", e);

}