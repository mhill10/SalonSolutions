package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.persistence.UserDao;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import edu.matc.test.util.Database;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;


/**
 * This is the UserDaoTest Class, which will test each method pertaining to the User Data Access Object
 * to ensure 100% successful functionality.
 */
class UserDaoTest {

    UserDao dao;


    /**
     * Creates a new UserDao Object and cleans and repopulates test database before each test
     */
    @BeforeEach
    void testSetUpSuccess() {
        dao = new UserDao();
        edu.matc.test.util.Database database = edu.matc.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Fetches User Object by id and verifies all data returned is accurate
     */
    @Test
    void getUserByIdSuccess() {
        User retrievedUser = dao.getUserById(2);
        //assertEquals(2, retrievedUser.getUserId());
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
        User userToUpdate = dao.getUserById(2);
        userToUpdate.setUserFirstName(newFirstName);
        userToUpdate.setUserLastName(newLastName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = dao.getUserById(2);
        assertEquals(newFirstName, retrievedUser.getUserFirstName());
        assertEquals(newLastName, retrievedUser.getUserLastName());
    }
/*
    @Test
    void insertUserSuccess() {
        User newUser = new User(0, , "8-675309", 1971);
        int id = dao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = dao.getUserById(id);
        assertEquals("Fear & Loathing in Las Vegas", insertedBook.getTitle());
        assertEquals("Hunter Stockton Thompson", insertedBook.getAuthor());
        assertEquals("8-675309", insertedBook.getIsbn());
        assertEquals(1971, insertedBook.getPublicationYear());
    }
*/
    @Test
    void deleteUserSuccess() {
        dao.delete(dao.getUserById(2));
        assertNull(dao.getUserById(2));
    }

    @Test
    void getAllUsersSuccess() {
        List<User> users = dao.getAllUsers();
        assertEquals(5, users.size());
    }
/*
    @Test
    void getUserByPropertyEqualSuccess() {
    }

    @Test
    void getUserByPropertyLikeSuccess() {
    }
*/
}