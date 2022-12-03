/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author Arnab
 */
public class CitizenOrganization extends Organization{
    public CitizenOrganization(){
    super (GovernmentAgencyType.Citizen.getValue());
   }
//    
//    @Override
//    public ArrayList<Roles> getSupportedRole() {
//        ArrayList<Roles> roles = new ArrayList();
//        roles.add(new CitizenRole());
//        return roles;
//    }
}
