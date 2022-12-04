/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Sensor;

import java.util.ArrayList;

/**
 *
 * @author Arnab
 */
public class EarthquakeSensorDirectory {
    private ArrayList<EarthquakeSensor>  EarthquakeSensor;
    
    public EarthquakeSensorDirectory()
    {
        EarthquakeSensor = new ArrayList<EarthquakeSensor>();
    }

    public ArrayList<EarthquakeSensor> getEarthquakeSensor() {
        return EarthquakeSensor;
    }

    public void setEarthquakeSensor(ArrayList<EarthquakeSensor> EarthquakeSensor) {
        this.EarthquakeSensor = EarthquakeSensor;
    }
    
    public EarthquakeSensor addEarthquakeSensor()
    {
        EarthquakeSensor earthquakeSensor = new EarthquakeSensor();
        EarthquakeSensor.add(earthquakeSensor);
        return earthquakeSensor;
    }
}
