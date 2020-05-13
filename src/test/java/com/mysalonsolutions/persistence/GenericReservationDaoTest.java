package com.mysalonsolutions.persistence;

import com.mysalonsolutions.entity.Reservation;
import com.mysalonsolutions.entity.Role;
import com.mysalonsolutions.entity.User;
import com.mysalonsolutions.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class GenericReservationDaoTest {

    GenericDao reservationDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        reservationDao = new GenericDao<>(Reservation.class);
    }

    /**
     * Fetch Reservation successfully
     */
    @Test
    void getByIdSuccess() {
        GenericDao reservationDao = new GenericDao(Reservation.class);
        Reservation reservationToFetch = (Reservation) reservationDao.getById(3);
        assertNotNull(reservationToFetch);
        assertEquals(, reservationToFetch);
    }

    /**
     * Insert role successfully
     */
    @Test
    void insertSuccess() {
        GenericDao userDao = new GenericDao(User.class);
        User user = (User)userDao.getById(5);
        Role newRole = new Role(user, "guest", user.getUserEmailAddress());

        int id = reservationDao.insert(newRole);
        Role insertedRole = (Role) reservationDao.getById(id);
        assertNotEquals(0, id);
        assertEquals(user, insertedRole.getUser());
    }

    /**
     * Delete a user's role successfully
     */
    @Test
    void deleteSuccess() {
        Role role = (Role) reservationDao.getById(3);

        reservationDao.delete(role);

        assertNull(reservationDao.getById(3));
    }

    /**
     * Retrieve all roles successfully
     */
    @Test
    void getAllSuccess() {
        List<Role> roleList = reservationDao.getAll();
        assertEquals(3, roleList.size());
    }

    /**
     * Get by property (matching equal values) successfully
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Role> roles = reservationDao.getByPropertyEqual("roleName", "guest");
        assertEquals(1, roles.size());
        assertEquals(3, roles.get(0).getId());
    }

    /**
     * Get by property (matching similar values) successfully
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Role> roleList = reservationDao.getByPropertyLike("roleName", "a");
        assertEquals(2, roleList.size());
        assertEquals(1, roleList.get(0).getId());
    }
}

