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
public class CycloneStormSensorDirectory {
    private ArrayList<CycloneStormSensor>  CycloneStormSensor;
    
    public CycloneStormSensorDirectory()
    {
        CycloneStormSensor = new ArrayList<CycloneStormSensor>();
    }

    public ArrayList<CycloneStormSensor> getCycloneStormSensor() {
        return CycloneStormSensor;
    }

    public void setCycloneStormSensor(ArrayList<CycloneStormSensor> CycloneStormSensor) {
        this.CycloneStormSensor = CycloneStormSensor;
    }
    
    public CycloneStormSensor addCycloneStormSensor()
    {
        CycloneStormSensor cycloneStormSensor = new CycloneStormSensor();
        CycloneStormSensor.add(cycloneStormSensor);
        return cycloneStormSensor;
    }
}
