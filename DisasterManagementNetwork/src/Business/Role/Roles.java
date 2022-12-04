/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Arnab
 */
public abstract class Roles {
    public enum RoleType{
        SystemAdmin("System Admin"),
        DisasterManagementAdmin("Disaster Management Admin"),
        CycloneStormManagement("Cyclone and Storm Management"),
        EarthquakeManagement("Earthquake Management"),
        FloodManagement("Flood Management"),
        GovernmentAgencyAdmin("Government Agency Admin"),
        GovernmentOfficial("Government Official"),
        Citizen("Citizen"),
        SensorManagementAdmin("Sensor Management Admin"),
        SensorMonitor("Sensor Management Admin");

        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
