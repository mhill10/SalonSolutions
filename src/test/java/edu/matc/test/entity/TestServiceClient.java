package edu.matc.test.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swapi.Results;
import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    @Test
    public void testswapiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://swapi.co/api/planets/1");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);


        ObjectMapper mapper = new ObjectMapper();
        Results planet  = mapper.readValue(response, Results.class);
        String expectedPlanetName = "Tatooine";
        assertEquals(expectedPlanetName, planet.getName());
    }
}