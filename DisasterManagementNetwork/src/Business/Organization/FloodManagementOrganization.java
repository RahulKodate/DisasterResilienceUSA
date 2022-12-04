/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Role.FloodManagementRole;
import Business.Role.Roles;
import java.util.ArrayList;

/**
 *
 * @author Arnab
 */
public class FloodManagementOrganization extends Organization{
    
     public FloodManagementOrganization() {
        super(DisasterManagementType.FloodManagement.getValue());
    }
    
    @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList();
        roles.add(new FloodManagementRole());
        return roles;
    }
    
}
