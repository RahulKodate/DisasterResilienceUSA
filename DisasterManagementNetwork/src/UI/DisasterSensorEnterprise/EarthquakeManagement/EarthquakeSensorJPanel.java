/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.DisasterSensorEnterprise.EarthquakeManagement;


import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.SensorMonitorOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
//import userinterface.EnvManagementRoles.NoisePollutionWorkAreaJPanel;
import UI.DisasterSensorEnterprise.SensorManagement.SensorMonitorWorkArea;
/**
 *
 * @author moins
 */
public class EarthquakeSensorJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer; 
    private UserAccount account; 
    private SensorMonitorOrganization organization; 
    private Enterprise enterprise; 
    private EcoSystem business;

    /**
     * Creates new form AirPollutionSensorJPanel
     */
    public EarthquakeSensorJPanel(JPanel userProcessContainer, UserAccount account, SensorMonitorOrganization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
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
        btnSendRequest = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Air Pollution Sensor");
        add(jLabel1);
        jLabel1.setBounds(110, 10, 527, 61);

        btnSendRequest.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSendRequest.setForeground(new java.awt.Color(51, 51, 255));
        btnSendRequest.setText("Send Request");
        btnSendRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendRequestActionPerformed(evt);
            }
        });
        add(btnSendRequest);
        btnSendRequest.setBounds(490, 100, 180, 38);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 51, 255));
        jButton2.setText("View Sent Requests");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(490, 190, 190, 38);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back_Final.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(20, 30, 100, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/maxresdefault.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, 0, 840, 450);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendRequestActionPerformed
        // TODO add your handling code here:
       NotifytoEarthquakeSolutionDepartment notifytoEarthquakeSolutionDepartment;
       try{
            notifytoEarthquakeSolutionDepartment = new NotifytoEarthquakeSolutionDepartment(userProcessContainer, account, business, enterprise.getOrganizationDirectory());
            userProcessContainer.add("NotifytoEarthquakeSolutionDepartment", notifytoEarthquakeSolutionDepartment);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } catch (IOException ex) {
            Logger.getLogger(EarthquakeSensorJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSendRequestActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         ViewEarthquakeWorkQueue viewWorkQueueJPanel = new ViewEarthquakeWorkQueue(userProcessContainer, account, enterprise.getOrganizationDirectory(), business);
        userProcessContainer.add("viewWorkQueueJPanel", viewWorkQueueJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        JPanel panel = new SensorMonitorWorkArea(userProcessContainer,account,organization, enterprise,business);
        //Component[] componentArray = userProcessContainer.getComponents();
        //Component component = componentArray[componentArray.length - 1];
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendRequest;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
