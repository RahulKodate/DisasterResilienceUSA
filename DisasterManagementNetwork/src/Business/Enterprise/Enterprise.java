/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.Roles;
import java.util.ArrayList;

/**
 *
 * @author moins
 */
public class Enterprise extends Organization{
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }
    
    public Enterprise(String name, EnterpriseType type) {
        super(name);
        this.enterpriseType = type;
        organizationDirectory = new OrganizationDirectory();

    }
    
//    @Override
    public ArrayList<Roles> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public enum EnterpriseType {

        DisasterManagement("Disaster Management"),
        GovernmentAgency("Government Agency"), 
        SensorManagement("Sensor Management"),
        ResearchAndDevelopment("Research and Development");
        
        private String val;

        private EnterpriseType(String value) {
            this.val = value;
        }

        public String getValue() {
            return val;
        }

        @Override
        public String toString() {
            return val;
        }
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }


    @Override
    public String toString() {
        return getName();
    }
    

}
