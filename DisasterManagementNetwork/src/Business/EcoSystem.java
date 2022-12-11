    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Roles;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author rahulkodate
 */
public class EcoSystem extends Organization{
    
   private static EcoSystem business;
    private ArrayList<Network> networkList;
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }
    
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    }
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roleList=new ArrayList<Roles>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    private EcoSystem(){
        super(null);
        networkList=new ArrayList<Network>();
    }
    
    public ArrayList<Network> getNetworkList() {
        return networkList;
    }
    
    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public boolean UniqueUserName(String username) {

        for (UserAccount user : this.getUserAccountDirectory().getUserAccountList()) {
          
            if (user.getUsername().equals(username)) {
                return false;
            }
            for (Network network : this.getNetworkList()) {
                for (Enterprise entprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    for (UserAccount useracc : entprise.getUserAccountDirectory().getUserAccountList()) {
                    
                        if (useracc.getUsername().equals(username)) {
                            return false;
                        }
                        for (Organization org : entprise.getOrganizationDirectory().getOrganizationList()) {
                            for (UserAccount accOrgn : org.getUserAccountDirectory().getUserAccountList()) {
                               
                                if (accOrgn.getUsername().equals(username)) {
                                    return false;
                                }
                            }

                        }
                    }

                }
            }

        }
        return true;
    }
    
    public boolean checkIfCityNameisUnique(String cityName) {

        for (Network nwk : this.networkList) {
            if (nwk.getName().equals(cityName)) {
                return true;
            }
        }
        return false;
    }
    
    public void DeleteCity(Network net) {
        networkList.remove(net);
    }
    
}
