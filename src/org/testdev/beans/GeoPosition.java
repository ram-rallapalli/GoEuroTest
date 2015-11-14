package org.testdev.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ram on 14/11/15.
 */
public class GeoPosition {
    @JsonProperty("latitude")
    private double latitude = -1;

    @JsonProperty("longitude")
    private double longititude = -1;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongititude() {
        return longititude;
    }

    public void setLongititude(double longititude) {
        this.longititude = longititude;
    }
}
