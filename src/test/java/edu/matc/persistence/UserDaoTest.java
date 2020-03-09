package edu.matc.persistence;

import edu.matc.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import edu.matc.test.util.Database;

import static org.junit.Assert.assertEquals;


class UserDaoTest {

    UserDao dao;


    /**
     * Creates a new UserDao Object and cleans and repopulates test database before each test
     */
    @BeforeEach
    void testSetUpSuccess() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Fetches User Object by id and verifies all data returned is accurate
     */
    @Test
    void getUserByIdSuccess() {
        User retrievedUser = dao.getUserById(2);
        assertEquals(2, retrievedUser.getUserId());
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
/*
    @Test
    void saveOrUpdateSuccess() {
        String newAuthor = "Paula Waite";
        Book bookToUpdate = dao.getById(2);
        bookToUpdate.setAuthor(newAuthor);
        dao.saveOrUpdate(bookToUpdate);
        Book retrievedBook = dao.getById(2);
        assertEquals(newAuthor, retrievedBook.getAuthor());
    }

    @Test
    void insertUserSuccess() {
        Book newBook = new Book("Fear & Loathing in Las Vegas", "Hunter Stockton Thompson", "8-675309", 1971);
        int id = dao.insert(newBook);
        assertNotEquals(0, id);
        Book insertedBook = dao.getById(id);
        assertEquals("Fear & Loathing in Las Vegas", insertedBook.getTitle());
        assertEquals("Hunter Stockton Thompson", insertedBook.getAuthor());
        assertEquals("8-675309", insertedBook.getIsbn());
        assertEquals(1971, insertedBook.getPublicationYear());
    }

    @Test
    void deleteUserSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    @Test
    void getAllUsersSuccess() {
        List<Book> books = dao.getAllBooks();
        assertEquals(3, books.size());
    }

    @Test
    void getUserByPropertyEqualSuccess() {
    }

    @Test
    void getUserByPropertyLikeSuccess() {
    }
    */

}