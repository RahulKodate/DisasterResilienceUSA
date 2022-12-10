/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Sensor.CycloneStormSensor;
/**
 *
 * @author moins
 */
public class CycloneStormWorkRequest extends WorkRequest{
    private CycloneStormSensor cycloneStormSensor;

    public CycloneStormSensor getCycloneStormSensor() {
        return cycloneStormSensor;
    }

    public void setCycloneStormSensor(CycloneStormSensor cycloneStormSensor) {
        this.cycloneStormSensor = cycloneStormSensor;
    }
    
}
