/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.DisasterManagementRole;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.CycloneStormManagementOrganization;
import Business.Organization.Organization;
import Business.WorkQueue.CycloneStormWorkRequest;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author apurv
 */
public class CycloneStormManagementWorkQueueJPanel extends javax.swing.JPanel {
private OrganizationDirectory directory;
    private UserAccount userAccount;
    private CycloneStormManagementOrganization organization;
    private Enterprise enterprise; 
    private EcoSystem business;
    private JPanel userProcessContainer;
    /**
     * Creates new form AirPollutionManagementWorkQueueJPanel
     * @param userProcessContainer
     */
    public CycloneStormManagementWorkQueueJPanel(JPanel userProcessContainer, UserAccount userAccount, OrganizationDirectory directory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.directory = directory;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
        
        populateTable();
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
        tbl_WorkQueue = new javax.swing.JTable();
        btn_Back = new javax.swing.JButton();
        btn_Resolve = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 102));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Air Pollution Management Work Queue");
        add(jLabel1);
        jLabel1.setBounds(0, 10, 500, 44);

        tbl_WorkQueue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Work_Request", "Sender", "Sensor_Id", "Zip"
            }
        ));
        jScrollPane1.setViewportView(tbl_WorkQueue);

        add(jScrollPane1);
        jScrollPane1.setBounds(24, 60, 452, 99);

        btn_Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back_Final.png"))); // NOI18N
        btn_Back.setText("<<Back");
        btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BackActionPerformed(evt);
            }
        });
        add(btn_Back);
        btn_Back.setBounds(24, 220, 91, 50);

        btn_Resolve.setBackground(new java.awt.Color(0, 0, 255));
        btn_Resolve.setForeground(new java.awt.Color(255, 255, 255));
        btn_Resolve.setText("Resolve");
        btn_Resolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ResolveActionPerformed(evt);
            }
        });
        add(btn_Resolve);
        btn_Resolve.setBounds(300, 220, 122, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/air-pollution.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, 0, 500, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BackActionPerformed
        // TODO add your handling code here:
                                                   
        userProcessContainer.remove(this);
         JPanel panel = new CycloneStormManagementWorkJPanel(userProcessContainer,userAccount,organization, enterprise,business);

        //Component[] componentArray = userProcessContainer.getComponents();
        //Component component = componentArray[componentArray.length - 1];
        //SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
       
    }//GEN-LAST:event_btn_BackActionPerformed

    private void btn_ResolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ResolveActionPerformed
        // TODO add your handling code here:
        int getSelectedRow = tbl_WorkQueue.getSelectedRow();
        if(getSelectedRow <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }else{
        Random rn = new Random();
        
        WorkRequest workRequest = (WorkRequest) tbl_WorkQueue.getValueAt(getSelectedRow, 0);
        
        CycloneStormWorkRequest airPollutionSolutionWorkRequest = (CycloneStormWorkRequest)workRequest;
        airPollutionSolutionWorkRequest.setStatus("Resolved");
        airPollutionSolutionWorkRequest.setResolveDate(new Date());
        
        airPollutionSolutionWorkRequest.getCycloneStormSensor().setWindSpeed(rn.nextInt(75));
        
        populateTable();
        
        JOptionPane.showMessageDialog(null, "Problem Resolved");
        }
    }//GEN-LAST:event_btn_ResolveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Back;
    private javax.swing.JButton btn_Resolve;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_WorkQueue;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
          CycloneStormWorkRequest air_wrs = null;
        DefaultTableModel model = (DefaultTableModel) tbl_WorkQueue.getModel();
        model.setRowCount(0);
        
        for(Organization organization : directory.getOrganizationList())
        {
        for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) {
            if (wr instanceof CycloneStormWorkRequest) {
                air_wrs = (CycloneStormWorkRequest)wr;
            
                Object[] row = new Object[8];
                row[0] = air_wrs;
                row[1] = air_wrs.getSender();
                row[2] = air_wrs.getCycloneStormSensor().getSensorId();
                row[3] = air_wrs.getCycloneStormSensor().getZipcode();
                row[4] = air_wrs.getStatus();
                row[5] = air_wrs.getMessage();
                row[6] = air_wrs.getRequestDate();
                row[7] = air_wrs.getResolveDate();
                model.addRow(row);
            }
        }
        }

    }
    
}
