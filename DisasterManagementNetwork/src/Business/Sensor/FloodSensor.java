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
public class FloodSensor extends Sensor{
    private float waterLevelThreshhold = 200;
     Random rndm = new Random();
    private float currentlevel= 50+rndm.nextInt(300);

    private Map<Date, Float> sensorResponseValues = new HashMap<Date, Float>();
    
    public FloodSensor()
   {
       Date dte = new Date();
       sensorResponseValues.put(dte, currentlevel);
   }
    
    public float getWaterLevelThreshhold () {
        return waterLevelThreshhold;
    }

    public void setWaterLevelThreshhold (float waterLevelThreshhold) {
        this. waterLevelThreshhold = waterLevelThreshhold;
    }   

    public float getCurrentlevel() {
        return currentlevel;
    }

    public void setCurrentlevel(float currentlevel) {
        Date dte = new Date();
        sensorResponseValues.put(dte, currentlevel);
        this.currentlevel = currentlevel;
    }

    public Map<Date, Float> getSensorResponseValues() {
        return sensorResponseValues;
    }

    public void setSensorResponseValues(Map<Date, Float> sensorResponseValues) {
        this.sensorResponseValues = sensorResponseValues;
    }
}
