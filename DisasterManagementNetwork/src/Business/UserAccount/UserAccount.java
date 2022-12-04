/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Roles;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author Arnab
 */
public class UserAccount {
    private String username;
    private String password;
    private Employee emp;
    private Roles role;
    private WorkQueue workQ;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public WorkQueue getWorkQ() {
        return workQ;
    }

    public void setWorkQ(WorkQueue workQ) {
        this.workQ = workQ;
    }
    
    
}
