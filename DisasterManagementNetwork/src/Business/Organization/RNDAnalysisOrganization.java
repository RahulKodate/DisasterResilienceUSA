/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Role.RNDAnalystRole;
import Business.Role.Roles;
import Business.Sensor.SensorDirectory;
import java.util.ArrayList;

/**
 *
 * @author Arnab
 */
public class RNDAnalysisOrganization extends Organization{
    private SensorDirectory sensorDirectory;
        
    public RNDAnalysisOrganization() {
    super(ResearchAndDevelopmentType.RNDAnalyst.getValue());
    sensorDirectory = new SensorDirectory();
    }
        
    public SensorDirectory getSensorDirectory() {
        return sensorDirectory;
    }

    public void setSensorDirectory(SensorDirectory sensorDirectory) {
        this.sensorDirectory = sensorDirectory;
    }
    
    @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList();
        roles.add(new RNDAnalystRole());
        return roles;
    }
}
