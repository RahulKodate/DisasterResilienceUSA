/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Roles;
import java.util.ArrayList;

/**
 *
 * @author Arnab
 */
public class UserAccountDirectory {
    private ArrayList<UserAccount> userAccountList;
    
    public UserAccountDirectory() {
        userAccountList = new ArrayList();
    }
    
    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount useracc : userAccountList)
            if (useracc.getUsername().equals(username) && useracc.getPassword().equals(password)){
                return useracc;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Employee employee, Roles role){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmp(employee);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public boolean CheckUniqueUsername(String username){
        for (UserAccount useracc : userAccountList){
            if (useracc.getUsername().equals(username))
                return false;
        }
        return true;
    }
}
