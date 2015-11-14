package org.testdev.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ram on 14/11/15.
 */
public class HttpUtils {

    /**
     * send a GET request to the end point and returns the response as String
     * @param endpoint
     * @return
     */
    public static String getData(String endpoint) throws Exception {
        String data = null;

        try {
            URL url = new URL(Constants.API_URL + endpoint);
            //create http connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(Constants.METHOD_GET);

            if (connection.getResponseCode() == Constants.RESONSE_OK) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String  tempData = "";
                StringBuilder dataBuff = new StringBuilder();

                while ((tempData = bufferedReader.readLine()) != null) {
                    dataBuff.append(tempData);
                }
                data = dataBuff.toString();
            } else {
                throw new Exception("HTTP Error with response code : " + connection.getResponseCode());
            }

        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return data;
    }
}