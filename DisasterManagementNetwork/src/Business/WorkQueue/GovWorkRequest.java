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
    
    private String AirPollutionMessage;
    private String FloodManagementMessage;

    

    public String getAirPollutionMessage() {
        return AirPollutionMessage;
    }

    public void setAirPollutionMessage(String AirPollutionMessage) {
        this.AirPollutionMessage = AirPollutionMessage;
    }

    public String getFloodManagementMessage() {
        return FloodManagementMessage;
    }

    public void setFloodManagementMessage(String FloodManagementMessage) {
        this.FloodManagementMessage = FloodManagementMessage;
    }

    	public ArrayList<FloodSensor> getFloodSensorList() {
        return floodSensorList;
    }

    public void setFloodManagementSensorList(ArrayList<FloodSensor> floodSensorList) {
        this.floodSensorList = floodSensorList;
    }
    

}
