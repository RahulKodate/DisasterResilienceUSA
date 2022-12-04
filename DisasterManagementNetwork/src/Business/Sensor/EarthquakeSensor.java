/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Sensor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Arnab
 */
public class EarthquakeSensor extends Sensor{
    Random rndm = new Random();
    int minimum = 1;
    int maximum = 10;
    private float seismicReading = rndm.nextInt(maximum - minimum) + minimum;
    
    private Map<Date, Float> sensorResponseValues = new HashMap<Date, Float>();
    
    public EarthquakeSensor()
   {
       Date dat = new Date();
       sensorResponseValues.put(dat, seismicReading);
   }

    public float getSeismicReading() {
        return seismicReading;
    }

    public void setSeismicReading(float seismicReading) {
        this.seismicReading = seismicReading;
    }
    
    public void setSeismicReadingOnRequest(float sr){
        seismicReading = sr;
    }

    public Map<Date, Float> getSensorResponseValues() {
        return sensorResponseValues;
    }

    public void setSensorResponseValues(Map<Date, Float> sensorResponseValues) {
        this.sensorResponseValues = sensorResponseValues;
    }
}
