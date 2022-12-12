/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.DisasterSensorEnterprise.CycloneStormManagement;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.CycloneStormManagementOrganization;
import Business.Organization.SensorMonitorOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Sensor.CycloneStormSensor;
import Business.Sensor.SensorDirectory;
import Business.Sensor.Sensor;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CycloneStormWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moins
 */
public class NotifytoCycloneStormSolutionDepartment extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private EcoSystem business;
    private Enterprise enterprise; 
    private UserAccount userAccount;
    private OrganizationDirectory organizationDirectory; 
    private SensorMonitorOrganization organization;
    /**
     * Creates new form NotifytoAirPolltuionSolutionDepartment
     */
    public NotifytoCycloneStormSolutionDepartment(JPanel userProcessContainer, UserAccount userAccount, EcoSystem business, OrganizationDirectory organizationDirectory) throws IOException {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.userAccount = userAccount;
        this.organizationDirectory = organizationDirectory;
        this.organization = organization;
        this.enterprise = enterprise;
        
        readFromCSV();
        populateTable();
    }
    public void readFromCSV() throws IOException
    {
        ArrayList<Sensor> sensorList = null;
        String csvFile = "src\\CSV_files\\AreaCodes.csv";
	        BufferedReader bufferedReader = null;
	        String line = "";
	        String cvsSplitBy = ",";
	        try {
	            bufferedReader = new BufferedReader(new FileReader(csvFile));
                    ArrayList<String[]> dataCsvArr = new ArrayList();
                    int count = 0;
	            while ((line = bufferedReader.readLine()) != null) {
	                String[] dataFromCsv = line.split(cvsSplitBy);
                        dataCsvArr.add(count,dataFromCsv);
                        count++;
	            }
                    for(int i=1;i<dataCsvArr.size();i++){ 
                                for(Organization orgn : organizationDirectory.getOrganizationList())
                                {
                                    if (orgn instanceof SensorMonitorOrganization){
                                        SensorMonitorOrganization envso = (SensorMonitorOrganization)orgn;
                                        SensorDirectory sensedirect = envso.getSensorDirectory();
                                        String valuesOfArray2[] = dataCsvArr.get(i);
                                        if(sensedirect.CycloneStormSensorExists(valuesOfArray2[1]))
                                        {
                                            break;
                                        }
                                        else
                                        {
                                        Sensor sense = sensedirect.createSensor(Sensor.SensorType.CycloneStormSensor);
                                        CycloneStormSensor airps = (CycloneStormSensor) sense;
                                        String valuesOfArray[] = dataCsvArr.get(i);
                                        airps.setLocation(valuesOfArray[0]);
                                        airps.setZipcode(valuesOfArray[1]);
                                        airps.setLatitude(valuesOfArray[2]);
                                        airps.setLongitude(valuesOfArray[3]);
                                        }                                        
                                        }
                                }
                            }
                        bufferedReader.close();
                }
	         catch (FileNotFoundException e) {
	            e.printStackTrace();
                }
    }
    public void populateTable()
    {
        ArrayList<CycloneStormSensor> tempCycloneStormSensorList = new ArrayList<CycloneStormSensor>();

        for(Network ntwk: business.getNetworkList())
        {
            for(Enterprise enterprise : ntwk.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization orgzn : enterprise.getOrganizationDirectory().getOrganizationList())
            {
            if(orgzn instanceof SensorMonitorOrganization)
            {
                SensorDirectory sensedirect;
                sensedirect = ((SensorMonitorOrganization) orgzn).getSensorDirectory();
                
                for(Sensor sense : sensedirect.getSensorList())
                {
                    if(sense instanceof CycloneStormSensor)
                    {
                        CycloneStormSensor airps = (CycloneStormSensor)sense;
                        tempCycloneStormSensorList.add(airps);
                    }
                }
            }

            }
        }   }
            
            DefaultTableModel model = (DefaultTableModel) tblWindSpeed.getModel();
        model.setRowCount(0);
        
        for(CycloneStormSensor airps : tempCycloneStormSensorList)
                {
                Object[] row = new Object[3];
                row[0] = airps;
                row[1] = airps.getZipcode();
                row[2] = airps.getWindSpeed();
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWindSpeed = new javax.swing.JTable();
        btnCycloneStormAreas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCycloneStorm = new javax.swing.JTable();
        btnNotifyGov = new javax.swing.JButton();
        btnNotifyCycloneStorm = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(222, 222, 248));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cyclone & Storm Sensor Readings");

        tblWindSpeed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sensor ID", "Zipcode", "Wind Speed"
            }
        ));
        jScrollPane1.setViewportView(tblWindSpeed);

        btnCycloneStormAreas.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnCycloneStormAreas.setText("Get Areas affected by Cyclone & Storm");
        btnCycloneStormAreas.setPreferredSize(new java.awt.Dimension(338, 23));
        btnCycloneStormAreas.setRolloverEnabled(false);
        btnCycloneStormAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCycloneStormAreasActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Areas facing Cyclone & Storm");

        tblCycloneStorm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sensor ID", "Zipcode", "Wind Speed"
            }
        ));
        jScrollPane2.setViewportView(tblCycloneStorm);

        btnNotifyGov.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnNotifyGov.setText("Send Sensor Information to Government");
        btnNotifyGov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotifyGovActionPerformed(evt);
            }
        });

        btnNotifyCycloneStorm.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnNotifyCycloneStorm.setText("Send Request to Cyclone Storm Department");
        btnNotifyCycloneStorm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotifyCycloneStormActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBack.setText("<<Back");
        btnBack.setSize(new java.awt.Dimension(120, 40));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnNotifyCycloneStorm, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnNotifyGov, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane1)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(193, 193, 193)
                                        .addComponent(btnCycloneStormAreas, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(502, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCycloneStormAreas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNotifyGov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNotifyCycloneStorm, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNotifyCycloneStormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotifyCycloneStormActionPerformed
        // TODO add your handling code here:
        int row = tblCycloneStorm.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }else{
        
        Sensor sensor = (Sensor)tblCycloneStorm.getValueAt(row, 0);
        
        CycloneStormSensor cycloneStormSensor = (CycloneStormSensor) sensor;
        CycloneStormWorkRequest reques = new CycloneStormWorkRequest();
        reques.setCycloneStormSensor(cycloneStormSensor);
        reques.setSender(userAccount);
        reques.setStatus("Sent");
        reques.setMessage("Wind Speed is increasing! Please have a look");
        
        Organization orgzn = null;
        Organization orgzn1 = null;
        for(Network ntwk: business.getNetworkList())
        {
            for(Enterprise enterprise : ntwk.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization orgn : enterprise.getOrganizationDirectory().getOrganizationList())
                {
                    if (orgn instanceof CycloneStormManagementOrganization){
                        orgzn = orgn;
                        break;
                    }
           
                } 
                for(Organization orgn1 : enterprise.getOrganizationDirectory().getOrganizationList())
                {
                    if(orgn1 instanceof SensorMonitorOrganization){
                    orgzn1 = orgn1;
                    break;
                    }
                }
            
            } }
        if (orgzn!=null){
            
            ArrayList<Integer> sensorIDsArray = new ArrayList<Integer>();
            boolean workRequestAlreadyPresent = false;
                    
            if(orgzn.getWorkQueue().getWorkRequestList().isEmpty())
            {
                
                try {
                orgzn.getWorkQueue().getWorkRequestList().add(reques);
                userAccount.getWorkQ().getWorkRequestList().add(reques);
                JOptionPane.showMessageDialog(null, "Request Successfully sent to Cyclone Storm Solution Department");
                return;
                } catch (Exception e) {
                }
                JOptionPane.showMessageDialog(null, "Request Successfully sent to Cyclone Storm Solution Department");
            }
            else
            {
            for(WorkRequest request1 : orgzn.getWorkQueue().getWorkRequestList())
            {
                if(request1 instanceof CycloneStormWorkRequest)
                {
                    CycloneStormWorkRequest reque = (CycloneStormWorkRequest) request1; 
                    sensorIDsArray.add(reque.getCycloneStormSensor().getSensorId());
                    for(int i=0; i<sensorIDsArray.size(); i++)
                    {
                        if(reques.getCycloneStormSensor().getSensorId() == sensorIDsArray.get(i))
                        {
                            workRequestAlreadyPresent = true;
                        }
                    }
                }
            }
                    if(workRequestAlreadyPresent)   
                    {
                        JOptionPane.showMessageDialog(null, "Request has already been sent about the respective sensor to the Cyclone Storm Department");
                    }
                    else
                    {
                        try {
                            orgzn.getWorkQueue().getWorkRequestList().add(reques);
                        userAccount.getWorkQ().getWorkRequestList().add(reques);
                        JOptionPane.showMessageDialog(null, "Request sent to Cyclone Storm Department successfully");
                        return;
                        } catch (Exception e) {
                        }
                        JOptionPane.showMessageDialog(null, "Request Successfully sent to Cyclone Storm Solution Department");
                    }
                }
            }

        if (orgzn1!=null){
            ArrayList<Integer> sensorIDsArray = new ArrayList<Integer>();
            boolean workRequestAlreadyPresent = false;
            if(orgzn1.getWorkQueue().getWorkRequestList().isEmpty())
            {
                try {
                orgzn1.getWorkQueue().getWorkRequestList().add(reques);
                userAccount.getWorkQ().getWorkRequestList().add(reques);
                return;
                } catch (Exception e) {
                }
             //   JOptionPane.showMessageDialog(null, "Request Successfully sent to Cyclone Storm Solution Department");
            }
            else
            {
            for(WorkRequest request1 : orgzn1.getWorkQueue().getWorkRequestList())
            {
                if(request1 instanceof CycloneStormWorkRequest)
                {
                    CycloneStormWorkRequest reque = (CycloneStormWorkRequest) request1; 
                    sensorIDsArray.add(reque.getCycloneStormSensor().getSensorId());
                    for(int i=0; i<sensorIDsArray.size(); i++)
                    {
                        if(reques.getCycloneStormSensor().getSensorId() == sensorIDsArray.get(i))
                        {
                            workRequestAlreadyPresent = true;
                        }
                    }
                }
            }
                    if(!(workRequestAlreadyPresent))                    
                    {
                        
                        try {
                        orgzn1.getWorkQueue().getWorkRequestList().add(reques);
                        userAccount.getWorkQ().getWorkRequestList().add(reques);
                        return;
                        } catch (Exception e) {
                        }
                   //     JOptionPane.showMessageDialog(null, "Request Successfully sent to Cyclone Storm Solution Department");
                    }
                }
        }
        }
    }//GEN-LAST:event_btnNotifyCycloneStormActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        JPanel panel = new CycloneStormSensorJPanel(userProcessContainer,userAccount,organization,enterprise,business);
        //Component[] componentArray = userProcessContainer.getComponents();
        //Component component = componentArray[componentArray.length - 1];
        //SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCycloneStormAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCycloneStormAreasActionPerformed
        // TODO add your handling code here:
        ArrayList<CycloneStormSensor> tempCycloneStormSensorList = new ArrayList<CycloneStormSensor>();

        for(Network ntwk: business.getNetworkList())
        {
            for(Enterprise enterprise : ntwk.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization orgzn : enterprise.getOrganizationDirectory().getOrganizationList())
            {
            if(orgzn instanceof SensorMonitorOrganization)
            {
                SensorDirectory sensedirect;
                sensedirect = ((SensorMonitorOrganization) orgzn).getSensorDirectory();
                
                for(Sensor sense : sensedirect.getSensorList())
                {
                    if(sense instanceof CycloneStormSensor)
                    {
                        CycloneStormSensor airp = (CycloneStormSensor)sense;
                        tempCycloneStormSensorList.add(airp);
                    }
                }
            }

            }
        }   }
            
        DefaultTableModel model = (DefaultTableModel) tblCycloneStorm.getModel();
        model.setRowCount(0);
        
        for(CycloneStormSensor airps : tempCycloneStormSensorList)
                {
                    if(airps.getWindSpeed()>30)
                    {
                        Object[] row = new Object[4];
                        row[0] = airps;
                        row[1] = airps.getZipcode();
                        row[2] = airps.getWindSpeed();
                        model.addRow(row);
                    }
                }
    }//GEN-LAST:event_btnCycloneStormAreasActionPerformed

    private void btnNotifyGovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotifyGovActionPerformed
        // TODO add your handling code here:
        NotifyToGovernmentJPanel notifyToGovernmentJPanel = new NotifyToGovernmentJPanel(userProcessContainer, userAccount, business, organizationDirectory);
        userProcessContainer.add("sendRequestToGovernmentJPanel", notifyToGovernmentJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnNotifyGovActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCycloneStormAreas;
    private javax.swing.JButton btnNotifyCycloneStorm;
    private javax.swing.JButton btnNotifyGov;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCycloneStorm;
    private javax.swing.JTable tblWindSpeed;
    // End of variables declaration//GEN-END:variables
}
