/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Sensor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Arnab
 */
public class SensorDirectory {
    private ArrayList<Sensor> sensorList;
    
    private Map<String, Float> cycloneStormSensorResponseValues = new HashMap<>();
    private Map<String, Float> earthquakeSensorResponseValues = new HashMap<>();
    private Map<String, Float> floodSensorResponseValues = new HashMap<>();
    
    public SensorDirectory()
    {
        sensorList = new ArrayList<Sensor>();
    }
    
    public Sensor createSensor(Sensor.SensorType type)
    {
        Sensor sensor = null;
        
        if (type.getValue().equals(Sensor.SensorType.CycloneStormSensor.getValue())){
            sensor = new CycloneStormSensor();
            sensorList.add(sensor);
        }
        
        else if (type.getValue().equals(Sensor.SensorType.FloodSensor.getValue())){
            sensor = new FloodSensor();
            sensorList.add(sensor);
        }
        
        
        
        else if (type.getValue().equals(Sensor.SensorType.EarthquakeSensor.getValue())){
            sensor = new EarthquakeSensor();
            sensorList.add(sensor);
        }        
        return sensor;
    }

    public Map<String, Float> getCycloneStormSensorResponseValues() {
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof CycloneStormSensor)
            {
                CycloneStormSensor cs = (CycloneStormSensor) sensorList.get(i);
                cycloneStormSensorResponseValues.put(cs.getZipcode(), cs.getWindSpeed());
            }
        }
        return cycloneStormSensorResponseValues;
    }
    

    public Map<String, Float> getEarthquakeSensorResponseValues() {
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof EarthquakeSensor)
            {
                EarthquakeSensor eq = (EarthquakeSensor) sensorList.get(i);
                floodSensorResponseValues.put(eq.getZipcode(), eq.getSeismicReading());
            }
        }
        return floodSensorResponseValues;
    }

    public Map<String, Float> getFloodSensorResponseValues() {
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof FloodSensor)
            {
                FloodSensor f = (FloodSensor) sensorList.get(i);
                floodSensorResponseValues.put(f.getZipcode(), f.getCurrentlevel());
            }
        }
        return floodSensorResponseValues;
    }

   
    
   public boolean CycloneStormSensorExists(String zipcode)
    {
        boolean sensorAlreadyPresent = false;
        ArrayList<CycloneStormSensor> cycloneStormSensorList = new ArrayList<CycloneStormSensor>();
        
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof CycloneStormSensor)
            {
                CycloneStormSensor cs = (CycloneStormSensor) sensorList.get(i);
                cycloneStormSensorList.add(cs);
            }
        }
        
        for(int i=0; i<cycloneStormSensorList.size(); i++)
        {
            if(zipcode.equals(cycloneStormSensorList.get(i).getZipcode()))
            {
                sensorAlreadyPresent = true;
            }
        }
        return sensorAlreadyPresent;
    }
   
   public boolean EarthquakeSensorExists(String zipcode)
    {
        boolean sensorAlreadyPresent = false;
        ArrayList<EarthquakeSensor> earthquakeSensorList = new ArrayList<EarthquakeSensor>();
        
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof EarthquakeSensor)
            {
                EarthquakeSensor eq = (EarthquakeSensor) sensorList.get(i);
                earthquakeSensorList.add(eq);
            }
        }
        
        for(int i=0; i<earthquakeSensorList.size(); i++)
        {
            if(zipcode.equals(earthquakeSensorList.get(i).getZipcode()))
            {
                sensorAlreadyPresent = true;
            }
        }
        return sensorAlreadyPresent;
    }
   
   public boolean FloodSensorSensorExists(String zipcode)
    {
        boolean sensorAlreadyPresent = false;
        ArrayList<FloodSensor> floodSensorList = new ArrayList<FloodSensor>();
        
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof FloodSensor)
            {
                FloodSensor f = (FloodSensor) sensorList.get(i);
                floodSensorList.add(f);
            }
        }
        
        for(int i=0; i<floodSensorList.size(); i++)
        {
            if(zipcode.equals(floodSensorList.get(i).getZipcode()))
            {
                sensorAlreadyPresent = true;
            }
        }
        return sensorAlreadyPresent;
    }
 
    
    public ArrayList<Sensor> getSensorList() {
        return sensorList;
    }

    public void setSensorList(ArrayList<Sensor> sensorList) {
        this.sensorList = sensorList;
    }
}
