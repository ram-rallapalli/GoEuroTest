package org.testdev.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testdev.beans.City;
import org.testdev.utils.CSVUtils;
import org.testdev.utils.HttpUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ram on 14/11/15.
 */
public class TestDev {
    public static void main(String [] args) throws Exception {
        String endpoint = "/position/suggest/en/";

        if (args.length == 0 || args[0].isEmpty()) {
            throw new Exception("City argument missing..");
        } else {
            String city = args[0];
            endpoint = endpoint + city;

            //request data
            String response = HttpUtils.getData(endpoint);
            if (response != null) {
                //process data
                ObjectMapper mapper = new ObjectMapper();
                List<City> cities = mapper.readValue(response, mapper.getTypeFactory().constructCollectionType(LinkedList.class, City.class));

                //test output
                for(City thisCity : cities) {
                    System.out.println("Name: " + thisCity.getFullName() + " Lat: " + thisCity.getGeoPosition().getLatitude() + " Lon: " + thisCity.getGeoPosition().getLongititude());
                }
                
                //generate csv
                CSVUtils.createCSV(cities);
            } else {
                System.out.println("Error with request.");
            }
        }
    }
}
