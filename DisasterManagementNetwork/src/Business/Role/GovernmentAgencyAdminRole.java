/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UI.GovernmentAgencyWorkArea.GovernmentAgencyAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Arnab
 */
public class GovernmentAgencyAdminRole extends Roles{
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new GovernmentAgencyAdminWorkAreaJPanel(userProcessContainer, enterprise, business); //To change body of generated methods, choose Tools | Templates.
    }
}
