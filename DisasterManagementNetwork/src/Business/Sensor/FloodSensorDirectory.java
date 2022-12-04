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
public class FloodSensorDirectory {
    private ArrayList<FloodSensor>  FloodSensor;
    
    public FloodSensorDirectory()
    {
        FloodSensor = new ArrayList<FloodSensor>();
    }

    public ArrayList<FloodSensor> getFloodSensor() {
        return FloodSensor;
    }

    public void setFloodSensor(ArrayList<FloodSensor> FloodSensor) {
        this.FloodSensor = FloodSensor;
    }
    
    public FloodSensor addFloodSensor()
    {
        FloodSensor floodSensor = new FloodSensor();
        FloodSensor.add(floodSensor);
        return floodSensor;
    }
    
}
