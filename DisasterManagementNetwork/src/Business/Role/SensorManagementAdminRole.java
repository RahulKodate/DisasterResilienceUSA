/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UI.SensorWorkArea.SensorManagementAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Arnab
 */
public class SensorManagementAdminRole extends Roles{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new SensorManagementAdminWorkAreaJPanel(userProcessContainer, enterprise, business);
    }
}
