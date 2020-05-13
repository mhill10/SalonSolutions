package com.mysalonsolutions.persistence;

import com.mysalonsolutions.entity.Reservation;
import com.mysalonsolutions.entity.Role;
import com.mysalonsolutions.entity.Service;
import com.mysalonsolutions.entity.User;
import com.mysalonsolutions.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


public class GenericServiceDaoTest {

    GenericDao serviceDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        serviceDao = new GenericDao(Service.class);
    }

    /**
     * Fetch service successfully
     */
    @Test
    void getByIdSuccess() {
        Service serviceFetched = (Service) serviceDao.getById(1);
        assertNotNull(serviceFetched);
        assertEquals("Haircut", serviceFetched.getServiceName());
    }

    /**
     * Insert Service successfully
     */
    @Test
    void insertSuccess() {
       Service newService = new Service();
       newService.setServiceName("Foil, Color & Style");
       newService.setServiceDescription("Careful Custom Color Application, Processing Time, and Blow-Dry Style to Suit");

        int id = serviceDao.insert(newService);
        Service insertedService = (Service) serviceDao.getById(id);
        assertNotEquals(0, id);
        assertEquals(newService, insertedService);
    }

    /**
     * Delete a service successfully
     */
    @Test
    void deleteSuccess() {
        Service serviceToDelete = (Service) serviceDao.getById(3);

        serviceDao.delete(serviceToDelete);

        assertNull(serviceDao.getById(3));
    }

    /**
     * Retrieve all roles successfully
     */
    @Test
    void getAllSuccess() {
        List<Service> serviceList = serviceDao.getAll();
        assertEquals(3, serviceList.size());
    }

    /**
     * Get by property (matching equal values) successfully
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Service> equalServices = serviceDao.getByPropertyEqual("serviceName", "Foil, Color, Cut");
        assertEquals(1, equalServices.size());
        assertEquals(2, equalServices.get(0).getServiceId());
    }

    /**
     * Get by property (matching similar values) successfully
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Service> serviceList = serviceDao.getByPropertyLike("serviceName", "foil");
        assertEquals(2, serviceList.size());
        assertEquals(2, serviceList.get(0).getServiceId());
    }
}

