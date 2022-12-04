/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Role.GovernmentAgencyAdminRole;
import Business.Role.Roles;
import java.util.ArrayList;

/**
 *
 * @author moins
 */
public class GovernmentAgencyEnterprise extends Enterprise{
    public GovernmentAgencyEnterprise(String name, Enterprise.EnterpriseType type) {
        super(name, type.GovernmentAgency);
    }

    @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList<>();
        roles.add(new GovernmentAgencyAdminRole());
        return roles; //To change body of generated methods, choose Tools | Templates.
    }
}
