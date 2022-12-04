/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.CycloneStormManagementOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Arnab
 */
public class CycloneStormManagementRole extends Roles{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new CycloneStormManagementWorkJPanel(userProcessContainer, account, (CycloneStormManagementOrganization)organization, enterprise, business);
    }
}
