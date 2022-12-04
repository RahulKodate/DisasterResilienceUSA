/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Role.Roles;
import Business.Role.SensorManagementAdminRole;
import java.util.ArrayList;

/**
 *
 * @author moins
 */
public class SensorManagementEnterprise extends Enterprise{
    public SensorManagementEnterprise(String name, Enterprise.EnterpriseType type) {
        super(name, type.SensorManagement);
    }

    @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList<>();
        roles.add(new SensorManagementAdminRole());
        return roles; //To change body of generated methods, choose Tools | Templates.
    }
}
