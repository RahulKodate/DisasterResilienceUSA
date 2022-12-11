/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.DisasterManagementWorkArea;

import Business.Employee.Employee;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moins
 */
public class DisasterManagementEmployeeJPanel extends javax.swing.JPanel {

    private OrganizationDirectory organizationDir;
    private JPanel userProcessContainer;
    /**
     * Creates new form EnvironmentManagementEmployeeJPanel
     */
    public DisasterManagementEmployeeJPanel(JPanel userProcessContainer, OrganizationDirectory organizationDir) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organizationDir = organizationDir;

        populateOrganizationComboBox();
        populateOrganizationEmpComboBox();
    }

    public void populateOrganizationComboBox() {
        cmbOrg.removeAllItems();

        for (Organization organization : organizationDir.getOrganizationList()) {
            cmbOrg.addItem(organization);
        }
    }

    public void populateOrganizationEmpComboBox() {
        cmbOrganization.removeAllItems();

        for (Organization organization : organizationDir.getOrganizationList()) {
            cmbOrganization.addItem(organization);
        }
    }
    
    private void populateTable(Organization organization) {
        DefaultTableModel model = (DefaultTableModel) tblOrganization.getModel();

        model.setRowCount(0);

        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
            Object[] row = new Object[1];

            row[0] = employee.getName();
            model.addRow(row);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbOrg = new javax.swing.JComboBox();
        lblOrganization = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrganization = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cmbOrganization = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblAddEmployee = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        cmbOrg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbOrg.setForeground(new java.awt.Color(0, 0, 51));
        cmbOrg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrgActionPerformed(evt);
            }
        });
        add(cmbOrg);
        cmbOrg.setBounds(230, 100, 184, 23);

        lblOrganization.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblOrganization.setText("Organization");
        add(lblOrganization);
        lblOrganization.setBounds(10, 90, 160, 22);

        tblOrganization.setBackground(new java.awt.Color(234, 234, 249));
        tblOrganization.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblOrganization.setForeground(new java.awt.Color(0, 0, 51));
        tblOrganization.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblOrganization);

        add(jScrollPane1);
        jScrollPane1.setBounds(110, 150, 480, 92);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Organization");
        add(jLabel3);
        jLabel3.setBounds(10, 400, 160, 22);

        cmbOrganization.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbOrganization.setForeground(new java.awt.Color(0, 0, 51));
        cmbOrganization.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cmbOrganization);
        cmbOrganization.setBounds(220, 390, 250, 23);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Name");
        add(jLabel2);
        jLabel2.setBounds(10, 450, 120, 22);

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(20, 510, 130, 50);

        txtName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 0, 51));
        add(txtName);
        txtName.setBounds(220, 460, 250, 30);

        btnCreate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        add(btnCreate);
        btnCreate.setBounds(390, 500, 150, 50);

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setText("View Employees");
        add(lblTitle);
        lblTitle.setBounds(10, 10, 310, 29);

        lblAddEmployee.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAddEmployee.setText("Add Employee");
        add(lblAddEmployee);
        lblAddEmployee.setBounds(0, 330, 180, 29);

        jLabel6.setBackground(new java.awt.Color(222, 222, 248));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/view_employee.jpg"))); // NOI18N
        add(jLabel6);
        jLabel6.setBounds(0, 0, 780, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrgActionPerformed
        Organization organization = (Organization) cmbOrg.getSelectedItem();
        if (organization != null) {
            populateTable(organization);
        }
    }//GEN-LAST:event_cmbOrgActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        if(txtName.equals("")){
        JOptionPane.showMessageDialog(null, "ENTER A NAME");
        }
        else{
        Organization organization = (Organization) cmbOrganization.getSelectedItem();
//        if (organization instanceof ConsumerOrganization) {
//            JOptionPane.showMessageDialog(null, "You cannot add the consumer that is responsiblity of Global Manager");
//        } else {
            String name = txtName.getText();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "An Employee must have a name");
            } else {
                organization.getEmployeeDirectory().createEmployee(name);
                
                JOptionPane.showMessageDialog(null, "Employee created succesfully");
                txtName.setText("");
            }
    }
        //}
    }//GEN-LAST:event_btnCreateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox cmbOrg;
    private javax.swing.JComboBox cmbOrganization;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddEmployee;
    private javax.swing.JLabel lblOrganization;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblOrganization;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
