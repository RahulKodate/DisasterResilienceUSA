/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Role.Roles;
import Business.Role.SensorMonitorRole;
import Business.Sensor.SensorDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Arnab
 */
public class SensorMonitorOrganization extends Organization{
    
    private SensorDirectory sensorDirectory;
    private WorkQueue GovernmentworkQueue;
    
    public SensorMonitorOrganization() {
        super(SensorManagementType.SensorMonitor.getValue());
        sensorDirectory = new SensorDirectory();
    }

    public SensorDirectory getSensorDirectory() {
        return sensorDirectory;
    }

    public void setSensorDirectory(SensorDirectory sensorDirectory) {
        this.sensorDirectory = sensorDirectory;
    }

    public WorkQueue getGovernmentworkQueue() {
        return GovernmentworkQueue;
    }

    public void setGovernmentworkQueue(WorkQueue GovernmentworkQueue) {
        this.GovernmentworkQueue = GovernmentworkQueue;
    }
    
    @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList();
        roles.add(new SensorMonitorRole());
        return roles;
    }
}
