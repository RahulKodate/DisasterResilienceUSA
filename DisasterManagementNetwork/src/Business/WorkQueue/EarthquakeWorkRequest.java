/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Sensor.EarthquakeSensor;
/**
 *
 * @author moins
 */
public class EarthquakeWorkRequest extends WorkRequest{
    private  EarthquakeSensor  earthquakeSensor;

    public EarthquakeSensor getEarthquakeSensor() {
        return earthquakeSensor;
    }

    public void setEarthquakeSensor(EarthquakeSensor earthquakeSensor) {
        this.earthquakeSensor = earthquakeSensor;
    }
    
}
