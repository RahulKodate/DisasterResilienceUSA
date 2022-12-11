/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.DisasterSensorEnterprise.FloodManagement;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.FloodManagementOrganization;
import Business.Organization.SensorMonitorOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Sensor.FloodSensor;
import Business.Sensor.SensorDirectory;
import Business.Sensor.Sensor;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FloodWorkRequest;
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
public class NotifytoFloodSolutionDepartment extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private EcoSystem business;
    private Enterprise enterprise; 
    private UserAccount userAccount;
    private OrganizationDirectory organizationDirectory; 
    private SensorMonitorOrganization organization;
    /**
     * Creates new form NotifytoAirPolltuionSolutionDepartment
     */
    public NotifytoFloodSolutionDepartment(JPanel userProcessContainer, UserAccount userAccount, EcoSystem business, OrganizationDirectory organizationDirectory) throws IOException {
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
                                        if(sensedirect.FloodSensorExists(valuesOfArray2[1]))
                                        {
                                            break;
                                        }
                                        else
                                        {
                                        Sensor sense = sensedirect.createSensor(Sensor.SensorType.FloodSensor);
                                        FloodSensor fs = (FloodSensor) sense;
                                        String valuesOfArray[] = dataCsvArr.get(i);
                                        fs.setLocation(valuesOfArray[0]);
                                        fs.setZipcode(valuesOfArray[1]);
                                        fs.setLatitude(valuesOfArray[2]);
                                        fs.setLongitude(valuesOfArray[3]);
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
        ArrayList<FloodSensor> tempFloodSensorList = new ArrayList<FloodSensor>();

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
                    if(sense instanceof FloodSensor)
                    {
                        FloodSensor fs = (FloodSensor)sense;
                        tempFloodSensorList.add(fs);
                    }
                }
            }

            }
        }   }
            
            DefaultTableModel model = (DefaultTableModel) tblWaterLevel.getModel();
        model.setRowCount(0);
        
        for(FloodSensor fs : tempFloodSensorList)
                {
                Object[] row = new Object[3];
                row[0] = fs;
                row[1] = fs.getZipcode();
                row[2] = fs.getCurrentlevel();
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
        tblWaterLevel = new javax.swing.JTable();
        btnFlood = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFlood = new javax.swing.JTable();
        btnNotifyGov = new javax.swing.JButton();
        btnNotifyFlood = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(222, 222, 248));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Flood Sensor Readings");

        tblWaterLevel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sensor ID", "Zipcode", "Water Level"
            }
        ));
        jScrollPane1.setViewportView(tblWaterLevel);

        btnFlood.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnFlood.setText("Get Flooded Areas");
        btnFlood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFloodActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Flooded Areas");

        tblFlood.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sensor ID", "Zipcode", "Water Level"
            }
        ));
        jScrollPane2.setViewportView(tblFlood);

        btnNotifyGov.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnNotifyGov.setText("Send Sensor Information to Government");
        btnNotifyGov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotifyGovActionPerformed(evt);
            }
        });

        btnNotifyFlood.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnNotifyFlood.setText("Send Request to Flood Department");
        btnNotifyFlood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotifyFloodActionPerformed(evt);
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
                        .addGap(226, 226, 226)
                        .addComponent(btnFlood, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(97, 97, 97)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(82, 82, 82)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(53, 53, 53))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnNotifyFlood, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNotifyGov, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(102, 318, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnFlood, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNotifyGov, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNotifyFlood, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(218, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNotifyFloodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotifyFloodActionPerformed
        // TODO add your handling code here:
        int row = tblFlood.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }else{
        //AirPollutionSensor airPollutionSensor = (AirPollutionSensor)SensorReadingsjTable.getValueAt(row, 0);
        
        Sensor sensor = (Sensor)tblFlood.getValueAt(row, 0);
        
        FloodSensor floodSensor = (FloodSensor) sensor;
        FloodWorkRequest reques = new FloodWorkRequest();
        reques.setFloodSensor(floodSensor);
        reques.setSender(userAccount);
        reques.setStatus("Sent");
        reques.setMessage("Water Level is Rising! Please have a look");
        
        Organization orgzn = null;
        Organization orgzn1 = null;
        for(Network ntwk: business.getNetworkList())
        {
            for(Enterprise enterprise : ntwk.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization orgn : enterprise.getOrganizationDirectory().getOrganizationList())
                {
                    if (orgn instanceof FloodManagementOrganization){
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
                JOptionPane.showMessageDialog(null, "Request Successfully sent to Flood Solution Department"); 
                return;
                } catch (Exception e) {
                }
                JOptionPane.showMessageDialog(null, "Request Successfully sent to Flood Solution Department");
                }
            else
            {
            for(WorkRequest request1 : orgzn.getWorkQueue().getWorkRequestList())
            {
                if(request1 instanceof FloodWorkRequest)
                {
                    FloodWorkRequest reque = (FloodWorkRequest) request1; 
                    sensorIDsArray.add(reque.getFloodSensor().getSensorId());
                    for(int i=0; i<sensorIDsArray.size(); i++)
                    {
                        if(reques.getFloodSensor().getSensorId() == sensorIDsArray.get(i))
                        {
                            workRequestAlreadyPresent = true;
                        }
                    }
                }
            }
                    if(workRequestAlreadyPresent)   
                    {
                        JOptionPane.showMessageDialog(null, "Request has already been sent about the respective sensor to the Air Pollution Department");
                    }
                    else
                    {
                        try {
                        orgzn.getWorkQueue().getWorkRequestList().add(reques);
                        userAccount.getWorkQ().getWorkRequestList().add(reques);
                        JOptionPane.showMessageDialog(null, "Request sent to Flood Solution Department successfully");
                        return;
                        } catch (Exception e) {
                        }
                        JOptionPane.showMessageDialog(null, "Request sent to Flood Solution Department successfully");
                        
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
                
            }
            else
            {
            for(WorkRequest request1 : orgzn1.getWorkQueue().getWorkRequestList())
            {
                if(request1 instanceof FloodWorkRequest)
                {
                    FloodWorkRequest reque = (FloodWorkRequest) request1; 
                    sensorIDsArray.add(reque.getFloodSensor().getSensorId());
                    for(int i=0; i<sensorIDsArray.size(); i++)
                    {
                        if(reques.getFloodSensor().getSensorId() == sensorIDsArray.get(i))
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
                       // JOptionPane.showMessageDialog(null, "Request sent to Flood Solution Department successfully");
                        
                    }
                }
        }
        }
    }//GEN-LAST:event_btnNotifyFloodActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        JPanel panel = new FloodSensorJPanel(userProcessContainer,userAccount,organization,enterprise,business);
        //Component[] componentArray = userProcessContainer.getComponents();
        //Component component = componentArray[componentArray.length - 1];
        //SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnFloodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFloodActionPerformed
        // TODO add your handling code here:
        ArrayList<FloodSensor> tempFloodSensorList = new ArrayList<FloodSensor>();

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
                    if(sense instanceof FloodSensor)
                    {
                        FloodSensor airp = (FloodSensor)sense;
                        tempFloodSensorList.add(airp);
                    }
                }
            }

            }
        }   }
            
        DefaultTableModel model = (DefaultTableModel) tblFlood.getModel();
        model.setRowCount(0);
        
        for(FloodSensor airps : tempFloodSensorList)
                {
                    if(airps.getCurrentlevel()>150)
                    {
                        Object[] row = new Object[4];
                        row[0] = airps;
                        row[1] = airps.getZipcode();
                        row[2] = airps.getCurrentlevel();
                        model.addRow(row);
                    }
                }
    }//GEN-LAST:event_btnFloodActionPerformed

    private void btnNotifyGovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotifyGovActionPerformed
        // TODO add your handling code here:
        NotifyToGovernmentJPanel notifyToGovernmentJPanel = new NotifyToGovernmentJPanel(userProcessContainer, userAccount, business, organizationDirectory);
        userProcessContainer.add("sendRequestToGovernmentJPanel", notifyToGovernmentJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnNotifyGovActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFlood;
    private javax.swing.JButton btnNotifyFlood;
    private javax.swing.JButton btnNotifyGov;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblFlood;
    private javax.swing.JTable tblWaterLevel;
    // End of variables declaration//GEN-END:variables
}
