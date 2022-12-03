/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import java.util.ArrayList;


/**
 *
 * @author Arnab
 */
public abstract class Organization {
    
    private String name;
    private int organizationId;
    private static int counter;
    
    private EmployeeDirectory employeeDirectory;
//    private UserAccountDirectory userAccountDirectory;
//        private WorkQueue workQueue;

    
    public enum DisasterManagementType {

        DisasterManagementAdmin("Disaster Management Admin Organization"), 
        CycloneStormManagement("Cyclone and Storm Management Organization"), 
        EarthquakeManagement(" Earthquake Alert Management Organization"),
        FloodManagement("Flood Management Organization");
        private String value;

        private DisasterManagementType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum GovernmentAgencyType {

        GovernmentAdmin("Government Admin Organization"), 
        GovernmentOfficial("Government Officials Organization"),
        Citizen("Citizen Organization");
        
        private String value;

        private GovernmentAgencyType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    
    public enum SensorManagementType {

        SensorAdmin("Sensor Admin Organization"), 
        SensorMonitor("Sensor Monitoring Organization");
        private String value;

        private SensorManagementType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    
    public Organization(String name) {
        this.name = name;
        employeeDirectory = new EmployeeDirectory();
        organizationId = counter;
        ++counter;
    }
    
//    public abstract ArrayList<Roles> getSupportedRole();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }


    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
