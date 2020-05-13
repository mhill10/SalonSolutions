package com.mysalonsolutions.persistence;

import com.mysalonsolutions.entity.Role;
import com.mysalonsolutions.entity.User;
import com.mysalonsolutions.test.util.Database;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


public class GenericRoleDaoTest {

    GenericDao roleDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        roleDao = new GenericDao<>(Role.class);
    }

    /**
     * Fetch role of user successfully
     */
    @Test
    void getByIdSuccess() {
        GenericDao userDao = new GenericDao(User.class);
        User user = (User) userDao.getById(3);
        Role role = (Role) roleDao.getById(2);
        assertNotNull(role);
        assertEquals(user, role.getUser());
    }

    /**
     * Insert role successfully
     */
    @Test
    void insertSuccess() {
        GenericDao userDao = new GenericDao(User.class);
        User user = (User)userDao.getById(5);
        Role newRole = new Role(user, "guest", user.getUserEmailAddress());

        int id = roleDao.insert(newRole);
        Role insertedRole = (Role) roleDao.getById(id);
        assertNotEquals(0, id);
        assertEquals(user, insertedRole.getUser());
    }

    /**
     * Delete a user's role successfully
     */
    @Test
    void deleteSuccess() {
        Role role = (Role) roleDao.getById(3);

        roleDao.delete(role);

        assertNull(roleDao.getById(3));
    }

    /**
     * Retrieve all roles successfully
     */
    @Test
    void getAllSuccess() {
        List<Role> roleList = roleDao.getAll();
        assertEquals(7, roleList.size());
    }

    /**
     * Get by property (matching equal values) successfully
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Role> roles = roleDao.getByPropertyEqual("roleName", "guest");
        assertEquals(6, roles.size());
        assertEquals(2, roles.get(0).getId());
    }

    /**
     * Get by property (matching similar values) successfully
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Role> roleList = roleDao.getByPropertyLike("roleName", "a");
        assertEquals(1, roleList.size());
        assertEquals(1, roleList.get(0).getId());
    }
}

