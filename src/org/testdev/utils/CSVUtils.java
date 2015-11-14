package org.testdev.utils;

import org.testdev.beans.City;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ram on 14/11/15.
 */
public class CSVUtils {
    /**
     * creates a csv file with data prvided for list of cities
     * @param cityList
     */
    public static void createCSV(List<City> cityList) {
        try {
            //Date to append it to the file
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            Date currDate = new Date(System.currentTimeMillis());

            //open the csv file for writing the data
            File file = new File(Constants.FILE_NAME + (df.format(currDate)).toString() + ".csv");
            FileWriter writer;

            //Write the header row in the csv file if its a new file
            if (!file.exists()) {
                file.createNewFile();
                writer = new FileWriter(file);

                writer.append("_id, ");
                writer.append("type, ");
                writer.append("name, ");
                writer.append("latitude, ");
                writer.append("longitude");
                writer.append("\n");
            } else {
                writer = new FileWriter(file, true);
            }

            //write the data to the csv
            for (City thisCity : cityList) {
                writer.write(thisCity.getId() + ", ");
                writer.append(thisCity.getType() + ", ");
                writer.append(thisCity.getName() + ", ");
                writer.append(thisCity.getGeoPosition().getLatitude() + ", ");
                writer.append(Double.toString(thisCity.getGeoPosition().getLongititude()));
                writer.append("\n");
            }

            writer.flush();
            writer.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
