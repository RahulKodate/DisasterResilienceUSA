/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Role.RNDAdminRole;
import Business.Role.Roles;
import java.util.ArrayList;

/**
 *
 * @author Arnab
 */
public class ResearchAndDevelopmentEnterprise extends Enterprise{
    
    public ResearchAndDevelopmentEnterprise(String name, Enterprise.EnterpriseType type) {
        super(name, type.ResearchAndDevelopment);
    }
    
    @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList<>();
        roles.add(new RNDAdminRole());
        return roles; //To change body of generated methods, choose Tools | Templates.
    }
}
