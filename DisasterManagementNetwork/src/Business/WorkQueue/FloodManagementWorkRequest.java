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
public class FloodManagementWorkRequest extends WorkRequest {
    private ArrayList<FloodSensor> floodManagementsensor;
    private String msg;

    public ArrayList<FloodSensor> getFloodManagementSensor() {
        return floodManagementsensor;
    }

    public void setFloodManagementSensor(ArrayList<FloodSensor> floodManagementSensor) {
        this.floodManagementsensor = floodManagementsensor;
    }
    
    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = msg;
    }
   
}
