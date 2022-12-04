/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Role.EarthquakeManagementRole;
import Business.Role.Roles;
import java.util.ArrayList;

/**
 *
 * @author Arnab
 */
public class EarthquakeManagementOrganization extends Organization{
    
     public EarthquakeManagementOrganization() {
        super(DisasterManagementType.EarthquakeManagement.getValue());
    }
    
    @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList();
        roles.add(new EarthquakeManagementRole());
        return roles;
    }
    
}
