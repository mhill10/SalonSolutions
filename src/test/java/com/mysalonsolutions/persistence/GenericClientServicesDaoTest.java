package com.mysalonsolutions.persistence;

import com.mysalonsolutions.entity.*;
import com.mysalonsolutions.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class GenericClientServicesDaoTest {

    GenericDao clientServicesDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        clientServicesDao = new GenericDao<>(ClientServices.class);
    }

    /**
     * Fetch Client Service successfully
     */
    @Test
    void getByIdSuccess() {
        ClientServices clientServiceToCompare = new ClientServices();
        clientServiceToCompare.setClientServiceId(1);
        clientServiceToCompare.setAllServiceId(1);
        clientServiceToCompare.setClientId(3);
        clientServiceToCompare.setServiceDefaultStartDuration(60);
        assertEquals(clientServiceToCompare, (ClientServices) clientServicesDao.getById(1));
    }

    /**
     * Insert Client Service successfully
     */
    @Test
    void insertSuccess() {
        GenericDao userDao = new GenericDao(User.class);
        User user = (User) userDao.getById(5);

        GenericDao serviceDao = new GenericDao(Service.class);
        Service serviceReferenced = (Service) serviceDao.getById(3);

        ClientServices clientServiceToInsert = new ClientServices();
        clientServiceToInsert.setClientId(user.getId());
        clientServiceToInsert.setAllServiceId(serviceReferenced.getServiceId());
        clientServiceToInsert.setServiceDefaultStartDuration(45);
        clientServiceToInsert.setServiceDefaultProcessDuration(45);
        clientServiceToInsert.setServiceDefaultEndDuration(45);

        int id = clientServicesDao.insert(clientServiceToInsert);
        ClientServices insertedClientService = (ClientServices) clientServicesDao.getById(id);
        assertNotEquals(0, id);
        assertEquals(user, userDao.getById(insertedClientService.getClientId()));
        assertEquals(serviceReferenced, serviceDao.getById(insertedClientService.getAllServiceId()));
        assertEquals(clientServiceToInsert, clientServicesDao.getById(id));
    }

    /**
     * Delete a Client Service successfully
     */
    @Test
    void deleteSuccess() {
        ClientServices clientServiceToDelete = (ClientServices) clientServicesDao.getById(3);

        clientServicesDao.delete(clientServiceToDelete);

        assertNull(clientServicesDao.getById(3));
    }

    /**
     * Retrieve all Client Services successfully
     */
    @Test
    void getAllSuccess() {
        List<ClientServices> clientServicesList = clientServicesDao.getAll();
        assertEquals(3, clientServicesList.size());
    }

    /**
     * Get by property (matching equal values) successfully
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<ClientServices> clientServicesFound = clientServicesDao.getByPropertyEqual("serviceDefaultStartDuration", 60);
        assertEquals(1, clientServicesFound.size());
        assertEquals(3, clientServicesFound.get(0).getClientId());
        assertEquals(1, clientServicesFound.get(0).getAllServiceId());
    }

    /**
     * Get by property (matching similar values) successfully
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<ClientServices> clientServicesLikeList = clientServicesDao.getByPropertyLike("clientId", "3");
        assertEquals(2, clientServicesLikeList.size());
        assertEquals(1, clientServicesLikeList.get(0).getAllServiceId());
    }
}

