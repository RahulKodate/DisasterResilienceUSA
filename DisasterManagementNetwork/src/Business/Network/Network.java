/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Network;

import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;

/**
 *
 * @author Arnab
 */
public class Network {
    private String name;
    private EnterpriseDirectory enterpriseDirectory;
    
    public Network(){
        enterpriseDirectory=new EnterpriseDirectory();
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }
    
    public boolean setEnterprise(String name) {
        for (Enterprise ent : enterpriseDirectory.getEnterpriseList()) {
            if (ent.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString(){
        return name;
    }

}
