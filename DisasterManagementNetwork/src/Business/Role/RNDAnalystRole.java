/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.RNDAnalysisOrganization;
import Business.UserAccount.UserAccount;
import UI.RNDAnalyst.RNDAnalystWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author Arnab
 */
public class RNDAnalystRole extends Roles{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
    return new RNDAnalystWorkArea(userProcessContainer, account, (RNDAnalysisOrganization)organization, enterprise, business);
    }
}
