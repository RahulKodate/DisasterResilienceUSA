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
public class HeadSensorDirectory {
    private ArrayList<Sensor>  Sensor;
    
    public HeadSensorDirectory()
    {
        Sensor = new ArrayList<Sensor>();
    }

    public ArrayList<Sensor> getSensor() {
        return Sensor;
    }

    public void setSensor(ArrayList<Sensor> Sensor) {
        this.Sensor = Sensor;
    }
}
