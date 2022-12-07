/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.CitizenOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UI.ResidentOrganization.ResidentWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Arnab
 */
public class CitizenRole extends Roles{
    @Override
public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
return new ResidentWorkAreaJPanel(userProcessContainer, account, (CitizenOrganization) organization, enterprise, system);
}
}
