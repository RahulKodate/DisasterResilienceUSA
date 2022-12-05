/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.DisasterManagementRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.FloodManagementOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Sensor.FloodSensor;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FloodManagementWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moins
 */
public class FloodPollutionManagementWorkQueueJPanel extends javax.swing.JPanel {
private OrganizationDirectory organizationdirectory;
private FloodManagementOrganization organization;
private Enterprise enterprise; 
    private EcoSystem business;
    private UserAccount userAccount;
    private JPanel userProcessContainer;
    /**
     * Creates new form FloodPollutionManagementWorkQueueJPanel
     */
    public FloodPollutionManagementWorkQueueJPanel(JPanel userProcessContainer, UserAccount account, OrganizationDirectory organizationDirectory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.organizationdirectory = organizationDirectory;
        this.organization = organization;
        this.business = business;
        this.enterprise = enterprise;
        populateTable();
    }
 public String convertListToCSV(ArrayList<String> ZipcodeList)
    {       
        String zipcodesCommaSeparated = ZipcodeList.stream().collect(Collectors.joining(","));
        return zipcodesCommaSeparated;
      
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_fooldTable = new javax.swing.JTable();
        btn_Back = new javax.swing.JButton();
        btn_Resolve = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 102));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Flood Management Work Queue ");
        add(jLabel1);
        jLabel1.setBounds(10, 20, 480, 29);

        tbl_fooldTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Work_Request_ID", "Sender", "Zipcode", "Status"
            }
        ));
        jScrollPane1.setViewportView(tbl_fooldTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 67, 452, 91);

        btn_Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back_Final.png"))); // NOI18N
        btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BackActionPerformed(evt);
            }
        });
        add(btn_Back);
        btn_Back.setBounds(65, 217, 95, 50);

        btn_Resolve.setBackground(new java.awt.Color(0, 0, 255));
        btn_Resolve.setForeground(new java.awt.Color(255, 255, 255));
        btn_Resolve.setText("Resolve");
        btn_Resolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ResolveActionPerformed(evt);
            }
        });
        add(btn_Resolve);
        btn_Resolve.setBounds(270, 220, 144, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BackActionPerformed
        // TODO add your handling code here:
             userProcessContainer.remove(this);
        //Component[] componentArray = userProcessContainer.getComponents();
        //Component component = componentArray[componentArray.length - 1];
        JPanel panel = new FloodAlertManagementWorkAreaJPanel(userProcessContainer,userAccount,organization, enterprise,business);
        //SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btn_BackActionPerformed
public void populateTable(){
        ArrayList<String> ZipcodeList = new ArrayList<String>();
        ArrayList<FloodManagementWorkRequest> floodAlertWorkRequest = new ArrayList<FloodManagementWorkRequest>();
        FloodManagementWorkRequest noise_wrs = null;
        DefaultTableModel model = (DefaultTableModel) tbl_fooldTable.getModel();
        model.setRowCount(0);
        
        for(Organization organization : organizationdirectory.getOrganizationList())
        {
        for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) {
            if (wr instanceof FloodManagementWorkRequest){
                noise_wrs = (FloodManagementWorkRequest)wr;
            
                for(FloodSensor fas : noise_wrs.getFloodManagementSensor())
                {
                ZipcodeList.add(fas.getZipcode());
                }
                Object[] row = new Object[8];
                row[0] = noise_wrs;
                row[1] = noise_wrs.getSender();
                row[2] = convertListToCSV(ZipcodeList);
                //row[2] = noise_wrs.getFloodAlertSensor().getZipcode();
                row[3] = noise_wrs.getStatus();
                row[4] = noise_wrs.getMessage();
                row[5] = noise_wrs.getRequestDate();
                row[6] = noise_wrs.getResolveDate();
                model.addRow(row);
            }
        }
    }
    }

    private void btn_ResolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ResolveActionPerformed
        // TODO add your handling code here:
         FloodManagementWorkRequest noise_wrs = null;
        int row = tbl_fooldTable.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }else{
        Random rn = new Random();

        WorkRequest workRequest = (WorkRequest) tbl_fooldTable.getValueAt(row, 0);

        FloodManagementWorkRequest floodSolutionWorkRequest = (FloodManagementWorkRequest)workRequest;
        floodSolutionWorkRequest.setStatus("Resolved");
        floodSolutionWorkRequest.getResolveDate();

        for(Organization organization : organizationdirectory.getOrganizationList())
        {
        for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) {
            if (wr instanceof FloodManagementWorkRequest){
                noise_wrs = (FloodManagementWorkRequest)wr;
                for(int i=0; i<noise_wrs.getFloodManagementSensor().size(); i++)
                {
                    noise_wrs.getFloodManagementSensor().get(i).setCurrentlevel(rn.nextInt(60));
                }
            }
        }
        }
        populateTable();
        }
    }//GEN-LAST:event_btn_ResolveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Back;
    private javax.swing.JButton btn_Resolve;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_fooldTable;
    // End of variables declaration//GEN-END:variables
}
