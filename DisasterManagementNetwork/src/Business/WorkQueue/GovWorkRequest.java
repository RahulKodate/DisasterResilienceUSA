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
public class GovWorkRequest extends WorkRequest {
    private CycloneStormSensor cycloneStormSensor;
    private ArrayList<FloodSensor> floodSensorList;
    
    private String CycloneStormMessage;
    private String FloodMessage;

    

    public String getCycloneStormMessage() {
        return CycloneStormMessage;
    }

    public void setCycloneStormMessage(String CycloneStormMessage) {
        this.CycloneStormMessage = CycloneStormMessage;
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

    public ArrayList<FloodSensor> getFloodSensorList() {
        return floodSensorList;
    }

    public void setFloodSensorList(ArrayList<FloodSensor> floodSensorList) {
        this.floodSensorList = floodSensorList;
    }
    

}
