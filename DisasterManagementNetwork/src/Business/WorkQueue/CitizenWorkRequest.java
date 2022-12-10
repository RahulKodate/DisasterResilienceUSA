/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Sensor.CycloneStormSensor;
import Business.Sensor.EarthquakeSensor;
import Business.Sensor.FloodSensor;
import java.util.ArrayList;
/**
 *
 * @author moins
 */
public class CitizenWorkRequest extends WorkRequest{
   
    private CycloneStormSensor cycloneStormSensor;
    private EarthquakeSensor EarthquakeSensor;
    private FloodSensor floodSensor;
    private String CycloneStormMessage;
    private String EarthquakeMessage;
    private String FloodMessage; 

    public CycloneStormSensor getCycloneStormSensor() {
        return cycloneStormSensor;
    }

    public void setCycloneStormSensor(CycloneStormSensor cycloneStormSensor) {
        this.cycloneStormSensor = cycloneStormSensor;
    }

    public EarthquakeSensor getEarthquakeSensor() {
        return EarthquakeSensor;
    }

    public void setEarthquakeSensor(EarthquakeSensor EarthquakeSensor) {
        this.EarthquakeSensor = EarthquakeSensor;
    }

    public FloodSensor getFloodSensor() {
        return floodSensor;
    }

    public void setFloodSensor(FloodSensor floodSensor) {
        this.floodSensor = floodSensor;
    }

    public String getCycloneStormMessage() {
        return CycloneStormMessage;
    }

    public void setCycloneStormMessage(String CycloneStormMessage) {
        this.CycloneStormMessage = CycloneStormMessage;
    }

    public String getEarthquakeMessage() {
        return EarthquakeMessage;
    }

    public void setEarthquakeMessage(String EarthquakeMessage) {
        this.EarthquakeMessage = EarthquakeMessage;
    }

    public String getFloodMessage() {
        return FloodMessage;
    }

    public void setFloodMessage(String FloodMessage) {
        this.FloodMessage = FloodMessage;
    }

    
}
