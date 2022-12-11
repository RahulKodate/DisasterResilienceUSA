/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.RNDAnalyst;

//import userinterface.EnvironmentSensorEnterprise.AirPollution.NotifytoAirPolltuionSolutionDepartment;
//import userinterface.EnvironmentSensorEnterprise.AirPollution.ViewAirPollutionWorkQueue;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.RNDAnalysisOrganization;
import Business.UserAccount.UserAccount;
import UI.RNDMaps.RNDMapsJPanel;
//import UI.DisasterSensorEnterprise.CycloneStormManagement.CycloneStormSensorJPanel;
//import UI.DisasterSensorEnterprise.EarthquakeManagement.EarthquakeSensorJPanel;
//import UI.DisasterSensorEnterprise.FloodManagement.FloodSensorJPanel;
//
//import userinterface.EnvironmentSensorEnterprise.NoisePollutionManagement.NoisePollutionManagementSensorJPanel;
import java.awt.CardLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
/**
 *
 * @author rahul
 */
public class RNDAnalystWorkArea extends javax.swing.JPanel {
    
    private JPanel userProcessContainer; 
    private UserAccount account; 
    private RNDAnalysisOrganization organization;
    private Enterprise enterprise; 
    private EcoSystem business;
    /**
     * Creates new form SensorManagementWorkArea
     */
    public RNDAnalystWorkArea(JPanel userProcessContainer, UserAccount account, RNDAnalysisOrganization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
        
        lblEnterprisevalue.setText(enterprise.getName());
        lblOrganizationvalue.setText(account.getEmp().getName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblEnterprise = new javax.swing.JLabel();
        lblOrganizationvalue = new javax.swing.JLabel();
        lblEnterprise2 = new javax.swing.JLabel();
        lblEnterprisevalue = new javax.swing.JLabel();
        btnCycloneStormManagement = new javax.swing.JButton();
        btnEarthquakeManagement = new javax.swing.JButton();
        btnFloodManagement = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 102));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Sensor Management Work Area");
        add(jLabel1);
        jLabel1.setBounds(279, 10, 399, 31);

        lblEnterprise.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEnterprise.setText("Enterprise");
        add(lblEnterprise);
        lblEnterprise.setBounds(233, 80, 110, 47);

        lblOrganizationvalue.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblOrganizationvalue.setText("<value>");
        add(lblOrganizationvalue);
        lblOrganizationvalue.setBounds(370, 140, 308, 30);

        lblEnterprise2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEnterprise2.setText("Organization");
        add(lblEnterprise2);
        lblEnterprise2.setBounds(190, 140, 140, 30);

        lblEnterprisevalue.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEnterprisevalue.setText("<value>");
        add(lblEnterprisevalue);
        lblEnterprisevalue.setBounds(370, 86, 308, 34);

        btnCycloneStormManagement.setBackground(new java.awt.Color(0, 102, 255));
        btnCycloneStormManagement.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCycloneStormManagement.setForeground(new java.awt.Color(255, 255, 255));
        btnCycloneStormManagement.setText("Cyclone Storm Management");
        btnCycloneStormManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCycloneStormManagementActionPerformed(evt);
            }
        });
        add(btnCycloneStormManagement);
        btnCycloneStormManagement.setBounds(460, 210, 340, 42);

        btnEarthquakeManagement.setBackground(new java.awt.Color(0, 51, 255));
        btnEarthquakeManagement.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEarthquakeManagement.setForeground(new java.awt.Color(255, 255, 255));
        btnEarthquakeManagement.setText("Earthquake Management");
        btnEarthquakeManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEarthquakeManagementActionPerformed(evt);
            }
        });
        add(btnEarthquakeManagement);
        btnEarthquakeManagement.setBounds(460, 280, 340, 42);

        btnFloodManagement.setBackground(new java.awt.Color(0, 51, 255));
        btnFloodManagement.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnFloodManagement.setForeground(new java.awt.Color(255, 255, 255));
        btnFloodManagement.setText("Flood Management");
        btnFloodManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFloodManagementActionPerformed(evt);
            }
        });
        add(btnFloodManagement);
        btnFloodManagement.setBounds(470, 350, 340, 42);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/airwatersound.jpg"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(-20, 50, 990, 660);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCycloneStormManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCycloneStormManagementActionPerformed
        // TODO add your handling code here:
        RNDMapsJPanel rNDMapsJPanel = new RNDMapsJPanel(userProcessContainer, account, organization, enterprise, business);
        userProcessContainer.add("RND Maps", rNDMapsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCycloneStormManagementActionPerformed

    private void btnEarthquakeManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEarthquakeManagementActionPerformed
        // TODO add your handling code here:
//        EarthquakeSensorJPanel earthquakeSensorJPanel = new EarthquakeSensorJPanel(userProcessContainer, account, organization, enterprise, business);
//        userProcessContainer.add("earthquakeSensorJPanel",earthquakeSensorJPanel );
//        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
//        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnEarthquakeManagementActionPerformed

    private void btnFloodManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFloodManagementActionPerformed
        // TODO add your handling code here:
//        FloodSensorJPanel floodSensorJPanel = new FloodSensorJPanel(userProcessContainer, account, organization, enterprise, business);
//        userProcessContainer.add("floodsensorJPanel", floodSensorJPanel);
//        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
//        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnFloodManagementActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCycloneStormManagement;
    private javax.swing.JButton btnEarthquakeManagement;
    private javax.swing.JButton btnFloodManagement;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblEnterprise;
    private javax.swing.JLabel lblEnterprise2;
    private javax.swing.JLabel lblEnterprisevalue;
    private javax.swing.JLabel lblOrganizationvalue;
    // End of variables declaration//GEN-END:variables
}
