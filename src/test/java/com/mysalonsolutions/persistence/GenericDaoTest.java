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
class GenericDaoTest {

    GenericDao dao;
    Database database;
    List users;


    /**
     * Creates a new UserDao Object and cleans and repopulates test database before each test
     */
    @BeforeEach
    void testSetUpSuccess() {
        dao = new GenericDao<>(User.class);
        database = Database.getInstance();
        database.runSQL("cleandb.sql");
        users = dao.getAll();
    }

    /**
     * Fetches User Object by id and verifies all data returned is accurate
     */
    @Test
    void getUserByIdSuccess() {
        User retrievedUser = (User) dao.getById(2);
        assertEquals(2, retrievedUser.getId());
        assertEquals("Kacy", retrievedUser.getUserFirstName());
        assertEquals("Bott", retrievedUser.getUserLastName());
        assertEquals("salonkb@gmail.com", retrievedUser.getUserEmailAddress());
        assertEquals("The Handy Hairdresser", retrievedUser.getUserDisplayName());
        assertEquals("6839 N. Old 92", retrievedUser.getUserStreetAddress());
        assertEquals("Evansville", retrievedUser.getUserCity());
        assertEquals("WI", retrievedUser.getUserState());
        assertEquals("53536", retrievedUser.getUserZipCode());
        assertEquals("smileyKacy.jpg", retrievedUser.getUserProfilePic());

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
        assertEquals("paulawaite@madisoncollege.edu", insertedUser.getUserEmailAddress());
        assertEquals("samplePassword6", insertedUser.getUserPassword());
        assertEquals("Paula Rocks", insertedUser.getUserDisplayName());
        assertEquals("Paula", insertedUser.getUserFirstName());
        assertEquals("Waite", insertedUser.getUserLastName());
        assertEquals("678 Easy Street", insertedUser.getUserStreetAddress());
        assertEquals("Hayward", insertedUser.getUserCity());
        assertEquals("WI", insertedUser.getUserState());
        assertEquals("54853", insertedUser.getUserZipCode());
        assertEquals("smileyPaula.jpg", insertedUser.getUserProfilePic());
    }

    @Test
    void deleteUserSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    @Test
    void getAllUsersSuccess() {
        assertNotEquals(0, users.size());
        assertEquals(5, users.size());
    }

    @Test
    void getUserByPropertyEqualSuccess() {
        List searchedUserList = dao.findByPropertyEqual("userLastName", "Bott");
        User searchedUser = (User) searchedUserList.get(0);
        assertEquals("Bott", searchedUser.getUserLastName());

    }

//    @Test
//    void getUserByPropertyLikeSuccess() {
//        List<User> users = dao.("userLastName", "H");
//        for (int userCounter = 0; userCounter < users.size(); userCounter++) {
//            assertEquals("Hill", users.get(userCounter).getUserLastName());
//        }
//
//    }


}