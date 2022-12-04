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
public class CycloneStormSensor extends Sensor{
    Random rndm = new Random();
    int minimum = 10;
    int maximum = 100;
    private float windSpeed = rndm.nextInt(maximum - minimum) + minimum;
    
    private Map<Date, Float> sensorResponseValues = new HashMap<Date, Float>();
    
    public CycloneStormSensor()
   {
       Date dat = new Date();
       sensorResponseValues.put(dat, windSpeed);
   }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }
    
    public void setWindSpeedOnRequest(float ws){
        windSpeed = ws;
    }

    public Map<Date, Float> getSensorResponseValues() {
        return sensorResponseValues;
    }

    public void setSensorResponseValues(Map<Date, Float> sensorResponseValues) {
        this.sensorResponseValues = sensorResponseValues;
    }
    
    
}
