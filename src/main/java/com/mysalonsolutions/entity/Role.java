package com.mysalonsolutions.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;


/**
 * This class represents the role for a user of Salon Solutions
 *
 * @author Matt Hill
 */
@Entity(name = "Role")
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId",
            foreignKey = @ForeignKey(name = "role_ibfk_1")
    )
    private User user;

    @Column(name = "userEmailAddress")
    private String userEmailAddress;

    @Column(name = "roleName")
    private String roleName;


    /**
     * Instantiates a new Role (empty constructor)
     */
    public Role() {
    }


    /**
     * Instantiates a new user's Role.
     *
     * @param user     the user in question
     * @param roleName the name of the role
     * @param userEmailAddress the user's email address
     *
     */
    public Role(User user, String roleName, String userEmailAddress) {
        this.user = user;
        this.roleName = roleName;
        this.userEmailAddress = userEmailAddress;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets role name.
     *
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets role name.
     *
     * @param roleName the role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Gets user email address
     *
     * @return the user email address
     */
    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    /**
     * Sets user email address.
     *
     * @param userEmailAddress the user's email address
     */
    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }


    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", userName= '" + userEmailAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(userEmailAddress, role.userEmailAddress) &&
                Objects.equals(roleName, role.roleName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, roleName, userEmailAddress);
    }
}


