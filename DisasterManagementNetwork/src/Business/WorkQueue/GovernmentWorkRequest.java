/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Sensor.CycloneStormSensor;
import Business.Sensor.FloodSensor;
import Business.Sensor.EarthquakeSensor;
import java.util.ArrayList;

/**
 *
 * @author moins
 */
public class GovernmentWorkRequest extends WorkRequest {
    private CycloneStormSensor cycloneStormSensor;
    private FloodSensor floodSensor;
    private EarthquakeSensor earthquakeSensor;
    private String CycloneStormMessage;
    private String FloodMessage;
    private String EarthquakeMessage;

    
    public String getEarthquakeMessage() {
        return EarthquakeMessage;
    }

    public void setEarthquakeMessage(String EarthquakeMessage) {
        this.EarthquakeMessage = EarthquakeMessage;
    }

    

    public String getCycloneStormMessage() {
        return CycloneStormMessage;
    }

    public void setCycloneStormMessage(String CycloneStormMessage) {
        this.CycloneStormMessage = CycloneStormMessage;
    }
    public EarthquakeSensor getEarthquakeSensor() {
        return earthquakeSensor;
    }

    public void setEarthquakeSensor(EarthquakeSensor earthquakeSensor) {
        this.earthquakeSensor = earthquakeSensor;
    }

    public String getFloodMessage() {
        return FloodMessage;
    }

    public void setFloodMessage(String FloodMessage) {
        this.FloodMessage = FloodMessage;
    }

    public CycloneStormSensor getCycloneStormSensor() {
        return cycloneStormSensor;
    }

    public void setCycloneStormSensor(CycloneStormSensor cycloneStormSensor) {
        this.cycloneStormSensor = cycloneStormSensor;
    }

    public FloodSensor getFloodSensor() {
        return floodSensor;
    }

    public void setFloodSensor(FloodSensor floodSensor) {
        this.floodSensor = floodSensor;
    }
    

}
