/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author moins
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;
    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<Enterprise>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type) {
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.DisasterManagement) {
            enterprise = new DisasterManagementEnterprise(name, type);
            enterpriseList.add(enterprise);
        }
        
        else if (type == Enterprise.EnterpriseType.GovernmentAgency) {
            enterprise = new GovernmentAgencyEnterprise(name, type);
            enterpriseList.add(enterprise);
        }
        
        else if (type == Enterprise.EnterpriseType.SensorManagement) {
            enterprise = new SensorManagementEnterprise(name, type);
            enterpriseList.add(enterprise);
        }
        
        else if (type == Enterprise.EnterpriseType.ResearchAndDevelopment) {
            enterprise = new ResearchAndDevelopmentEnterprise(name, type);
            enterpriseList.add(enterprise);
        }
        
        return enterprise;
    }

    public void Delete_Enterprise(Enterprise enterprise) {
       
        enterpriseList.remove(enterprise);
    }
}
