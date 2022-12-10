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
 * @author moins
 */
public class FloodWorkRequest extends WorkRequest {
    private FloodSensor floodsensor;
    private String msg;

    public FloodSensor getFloodSensor() {
        return floodsensor;
    }

    public void setFloodSensor(FloodSensor floodsensor) {
        this.floodsensor = floodsensor;
    }
    
    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = msg;
    }
   
}
