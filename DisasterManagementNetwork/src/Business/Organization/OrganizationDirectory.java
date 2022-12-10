/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Organization.Organization.DisasterManagementType;
import Business.Organization.Organization.GovernmentAgencyType;
import Business.Organization.Organization.ResearchAndDevelopmentType;
import Business.Organization.Organization.SensorManagementType;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Arnab
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;
    
    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }
    
    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
     public Organization createDisasterManagement(DisasterManagementType type){
        Organization organization = null; 


        boolean doesCycloneStormManagementExist = false;
        boolean doesEartquakeManagementExist = false;
        boolean doesFloodManagementExist = false;
        
        for (Organization org : organizationList) {
            if (org instanceof CycloneStormManagementOrganization) {
                doesCycloneStormManagementExist = true;
                break;
            } else {
                doesCycloneStormManagementExist = false;
            }
        }
        
        for (Organization org : organizationList) {
            if (org instanceof EarthquakeManagementOrganization) {
                doesEartquakeManagementExist = true;
                break;
            } else {
                doesEartquakeManagementExist = false;
            }
        }
        
       
        
        for (Organization org : organizationList) {
            if (org instanceof FloodManagementOrganization) {
                doesFloodManagementExist = true;
                break;
            } else {
                doesFloodManagementExist = false;
            }
        }
        
        if (type.getValue().equals(DisasterManagementType.CycloneStormManagement.getValue())){
            if (!doesCycloneStormManagementExist) {
            organization = new CycloneStormManagementOrganization();
            organizationList.add(organization);
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Cyclone and Storm Management Organization for an Enterprise.");
            }
        }
        else if (type.getValue().equals(DisasterManagementType.EarthquakeManagement.getValue())){
            if(!doesEartquakeManagementExist) {
            organization = new EarthquakeManagementOrganization();
            organizationList.add(organization);
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Eartquake Management Organization for an Enterprise");
            }
        }
        
        else if (type.getValue().equals(DisasterManagementType.FloodManagement.getValue())){
            if(!doesFloodManagementExist) {
            organization = new FloodManagementOrganization();
            organizationList.add(organization);
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Flood Management Organization for an Enterprise");
            }
        }
        return organization;
    }
     
     public Organization createGovernmentAgency(GovernmentAgencyType type){
         Organization organization = null;
         
         boolean doesGovernmentOrganizationExist = false;
         boolean doesCitizenOrganizationExist = false;
         
         for (Organization org : organizationList) {
            if (org instanceof GovernmentOfficialOrganization) {
                doesGovernmentOrganizationExist = true;
                break;
            } else {
                doesGovernmentOrganizationExist = false;
            }
        }
         
         for (Organization org : organizationList) {
            if (org instanceof CitizenOrganization) {
                doesCitizenOrganizationExist = true;
                break;
            } else {
                doesCitizenOrganizationExist = false;
            }
        }
         
        if (type.getValue().equals(GovernmentAgencyType.GovernmentOfficial.getValue())){
            if(!doesGovernmentOrganizationExist) {
            organization = new GovernmentOfficialOrganization();
            organizationList.add(organization);
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Government Officials Organization for an Enterprise");
            }
        }
        
        else if (type.getValue().equals(GovernmentAgencyType.Citizen.getValue())){
            if(!doesCitizenOrganizationExist) {
            organization = new CitizenOrganization();
            organizationList.add(organization);
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Citizen Organization for an Enterprise");
            }
        }
        
        return organization;
     }

    public Organization createSensorManagement(SensorManagementType type){
         Organization organization = null;
         
         boolean doesSensorMonitorOrganizationExist = false;
         
         for (Organization org : organizationList) {
            if (org instanceof SensorMonitorOrganization) {
                doesSensorMonitorOrganizationExist = true;
                break;
            } else {
                doesSensorMonitorOrganizationExist = false;
            }
        }
         
        if (type.getValue().equals(SensorManagementType.SensorMonitor.getValue())){
            if(!doesSensorMonitorOrganizationExist) {
            organization = new SensorMonitorOrganization();
            organizationList.add(organization);
            //JOptionPane.showMessageDialog(null, "Organization added Succesfully");
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Sensor Monitoring Organization for an Enterprise");
            }
        }
        return organization;
     }
     
    public Organization createRND(ResearchAndDevelopmentType type){
         Organization organization = null;
         
         boolean doesRNDOrganizationExist = false;
         
         for (Organization org : organizationList) {
            if (org instanceof RNDAnalysisOrganization) {
                doesRNDOrganizationExist = true;
                break;
            } else {
                doesRNDOrganizationExist = false;
            }
        }
         
        if (type.getValue().equals(ResearchAndDevelopmentType.RNDAnalyst.getValue())){
            if(!doesRNDOrganizationExist) {
            organization = new RNDAnalysisOrganization();
            organizationList.add(organization);
            //JOptionPane.showMessageDialog(null, "Organization added Succesfully");
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one RND Analysis Organization for an Enterprise");
            }
        }
        return organization;
     }
    
     public void DeleteOrganization(Organization org) {
        organizationList.remove(org);
    }
}
