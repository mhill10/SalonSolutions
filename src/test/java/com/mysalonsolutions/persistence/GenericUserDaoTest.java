package com.mysalonsolutions.persistence;

import com.mysalonsolutions.entity.User;
import com.mysalonsolutions.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;


/**
 * This is the UserDaoTest Class, which will test each method pertaining to the User Data Access Object
 * to ensure 100% successful functionality.
 */
class GenericUserDaoTest {

    GenericDao dao;
    Database database;
    List<User> users;


    /**
     * Creates a new UserDao Object and cleans and repopulates test database before each test
     */
    @BeforeEach
    void testSetUpSuccess() {
        dao = new GenericDao<>(User.class);
        database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Fetches User Object by id and verifies all data returned is accurate
     */
    @Test
    void getUserByIdSuccess() {
        User retrievedUser = (User) dao.getById(2);
        assertNotNull(retrievedUser);
        assertEquals("matthewbhill@gmail.com", retrievedUser.getUserEmailAddress());
        assertEquals("samplePassword1", retrievedUser.getUserPassword());
    }

    @Test
    void saveOrUpdateSuccess() {
        String newFirstName = "Paula";
        String newLastName = "Waite";
        User userToUpdate = (User) dao.getById(2);
        userToUpdate.setUserFirstName(newFirstName);
        userToUpdate.setUserLastName(newLastName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User) dao.getById(2);
        assertEquals(newFirstName, retrievedUser.getUserFirstName());
        assertEquals(newLastName, retrievedUser.getUserLastName());
    }

    @Test
    void insertUserSuccess() {
        User newUser = new User();
        newUser.setUserEmailAddress("paulawaite@madisoncollege.edu");
        newUser.setUserPassword("samplePassword6");
        newUser.setUserDisplayName("Paula Rocks");
        newUser.setUserFirstName("Paula");
        newUser.setUserLastName("Waite");
        newUser.setUserStreetAddress("678 Easy Street");
        newUser.setUserCity("Hayward");
        newUser.setUserState("WI");
        newUser.setUserZipCode("54853");
        newUser.setUserProfilePic("smileyPaula.jpg");
        int id = dao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = (User) dao.getById(id);
        assertEquals(newUser, insertedUser);
    }

    @Test
    void deleteUserSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    @Test
    void getAllUsersSuccess() {
        users = dao.getAll();
        assertNotEquals(0, users.size());
        assertEquals(5, users.size());
    }

    @Test
    void getUserByPropertyEqualSuccess() {
        users = dao.getByPropertyEqual("userLastName", "Bott");
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getId());
        assertEquals(dao.getById(1), users.get(0));

    }

    @Test
    void getUserByPropertyLikeSuccess() {
        users = dao.getByPropertyLike("userLastName", "H");
        for (int userCounter = 0; userCounter < users.size(); userCounter++) {
            assertEquals("Hill", users.get(userCounter).getUserLastName());
        }

    }


}