/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;


import Business.Sensor.FloodSensor;
import java.util.ArrayList;
/**
 *
 * @author aishw
 */
public class ResidentWorkRequest extends WorkRequest{
   
    private ArrayList<FloodSensor> floodManagementSensorList;
    private String AirPollutionMessage;
    private String FloodManagementMessage; 

 

    public String getFloodManagementMessage() {
        return FloodManagementMessage;
    }

    public void setFloodManagementMessage(String FloodManagementMessage) {
        this.FloodManagementMessage = FloodManagementMessage;
    }
    
    public ArrayList<FloodSensor> getFloodManagementSensorList() {
        return floodManagementSensorList;
    }

    public void setFloodManagementSensorList(ArrayList<FloodSensor> floodManagementSensorList) {
        this.floodManagementSensorList = floodManagementSensorList;
    }
    
}
