/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author rahulkodate
 */
public class ConfigureASystem {
    
     public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        Employee employee = system.getEmployeeDirectory().createEmployee("RRH");
        
        UserAccount user = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        return system;
    }
    
    
}
