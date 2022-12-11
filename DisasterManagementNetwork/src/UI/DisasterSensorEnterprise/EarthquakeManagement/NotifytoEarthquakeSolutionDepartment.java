/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.DisasterSensorEnterprise.EarthquakeManagement;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.EarthquakeManagementOrganization;
import Business.Organization.SensorMonitorOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Sensor.EarthquakeSensor;
import Business.Sensor.SensorDirectory;
import Business.Sensor.Sensor;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EarthquakeWorkRequest;
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
public class NotifytoEarthquakeSolutionDepartment extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private EcoSystem business;
    private Enterprise enterprise; 
    private UserAccount userAccount;
    private OrganizationDirectory organizationDirectory; 
    private SensorMonitorOrganization organization;
    /**
     * Creates new form NotifytoAirPolltuionSolutionDepartment
     */
    public NotifytoEarthquakeSolutionDepartment(JPanel userProcessContainer, UserAccount userAccount, EcoSystem business, OrganizationDirectory organizationDirectory) throws IOException {
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
                                        if(sensedirect.EarthquakeSensorExists(valuesOfArray2[1]))
                                        {
                                            break;
                                        }
                                        else
                                        {
                                        Sensor sense = sensedirect.createSensor(Sensor.SensorType.EarthquakeSensor);
                                        EarthquakeSensor eqs = (EarthquakeSensor) sense;
                                        String valuesOfArray[] = dataCsvArr.get(i);
                                        eqs.setLocation(valuesOfArray[0]);
                                        eqs.setZipcode(valuesOfArray[1]);
                                        eqs.setLatitude(valuesOfArray[2]);
                                        eqs.setLongitude(valuesOfArray[3]);
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
        ArrayList<EarthquakeSensor> tempEarthquakeSensorList = new ArrayList<EarthquakeSensor>();

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
                    if(sense instanceof EarthquakeSensor)
                    {
                        EarthquakeSensor eqs = (EarthquakeSensor)sense;
                        tempEarthquakeSensorList.add(eqs);
                    }
                }
            }

            }
        }   }
            
            DefaultTableModel model = (DefaultTableModel) tblSeismicReadings.getModel();
        model.setRowCount(0);
        
        for(EarthquakeSensor eqs :tempEarthquakeSensorList)
                {
                Object[] row = new Object[3];
                row[0] = eqs;
                row[1] = eqs.getZipcode();
                row[2] = eqs.getSeismicReading();
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
        tblSeismicReadings = new javax.swing.JTable();
        btnHighlyAirPollutedAreas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEarthquake = new javax.swing.JTable();
        btnNotifyGov = new javax.swing.JButton();
        btnNotifyEarthquake = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(222, 222, 248));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Earthquake Sensor Readings");

        tblSeismicReadings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sensor ID", "Zipcode", "Seismic Readings"
            }
        ));
        jScrollPane1.setViewportView(tblSeismicReadings);

        btnHighlyAirPollutedAreas.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnHighlyAirPollutedAreas.setText("Get Earthquake Prone Areas");
        btnHighlyAirPollutedAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHighlyAirPollutedAreasActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Areas prone to Earthquake");

        tblEarthquake.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sensor ID", "Zipcode", "Seismic Reading"
            }
        ));
        jScrollPane2.setViewportView(tblEarthquake);

        btnNotifyGov.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnNotifyGov.setText("Send Sensor Information to Government");
        btnNotifyGov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotifyGovActionPerformed(evt);
            }
        });

        btnNotifyEarthquake.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnNotifyEarthquake.setText("Send Request to Earthquake Department");
        btnNotifyEarthquake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotifyEarthquakeActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBack.setText("<<Back");
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
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(157, 157, 157)
                                        .addComponent(btnHighlyAirPollutedAreas, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnNotifyEarthquake)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNotifyGov, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(289, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHighlyAirPollutedAreas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNotifyEarthquake, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNotifyGov, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(139, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNotifyEarthquakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotifyEarthquakeActionPerformed
        // TODO add your handling code here:
        int row = tblEarthquake.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }else{
       
        
        Sensor sensor = (Sensor)tblEarthquake.getValueAt(row, 0);
        
        EarthquakeSensor earthquakeSensor = (EarthquakeSensor) sensor;
        EarthquakeWorkRequest reques = new EarthquakeWorkRequest();
        reques.setEarthquakeSensor(earthquakeSensor);
        reques.setSender(userAccount);
        reques.setStatus("Sent");
        reques.setMessage("Earthquake Alert! Please have a look");
        
        Organization orgzn = null;
        Organization orgzn1 = null;
        for(Network ntwk: business.getNetworkList())
        {
            for(Enterprise enterprise : ntwk.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization orgn : enterprise.getOrganizationDirectory().getOrganizationList())
                {
                    if (orgn instanceof EarthquakeManagementOrganization){
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
                JOptionPane.showMessageDialog(null, "Request Successfully sent to Earthquake Solution Department");
                return;
                } catch (Exception e) {
                }
                JOptionPane.showMessageDialog(null, "Request Successfully sent to Earthquake Solution Department");
                
               }
            else
            {
            for(WorkRequest request1 : orgzn.getWorkQueue().getWorkRequestList())
            {
                if(request1 instanceof EarthquakeWorkRequest)
                {
                    EarthquakeWorkRequest reque = (EarthquakeWorkRequest) request1; 
                    sensorIDsArray.add(reque.getEarthquakeSensor().getSensorId());
                    for(int i=0; i<sensorIDsArray.size(); i++)
                    {
                        if(reques.getEarthquakeSensor().getSensorId() == sensorIDsArray.get(i))
                        {
                            workRequestAlreadyPresent = true;
                        }
                    }
                }
            }
                    if(workRequestAlreadyPresent)   
                    {
                        JOptionPane.showMessageDialog(null, "Request has already been sent about the respective sensor to the Earthquake Department");
                    }
                    else
                    {
                        try {
                        orgzn.getWorkQueue().getWorkRequestList().add(reques);
                        userAccount.getWorkQ().getWorkRequestList().add(reques);
                        JOptionPane.showMessageDialog(null, "Request sent to Earthquake Department successfully");
                        return;
                        } catch (Exception e) {
                        }
                        JOptionPane.showMessageDialog(null, "Request sent to Earthquake Department successfully");
                        
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
                if(request1 instanceof EarthquakeWorkRequest)
                {
                    EarthquakeWorkRequest reque = (EarthquakeWorkRequest) request1; 
                    sensorIDsArray.add(reque.getEarthquakeSensor().getSensorId());
                    for(int i=0; i<sensorIDsArray.size(); i++)
                    {
                        if(reques.getEarthquakeSensor().getSensorId() == sensorIDsArray.get(i))
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
                     //   JOptionPane.showMessageDialog(null, "Request sent to Earthquake Department successfully");
                        
                    }
                }
        }
        }
    }//GEN-LAST:event_btnNotifyEarthquakeActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        JPanel panel = new EarthquakeSensorJPanel(userProcessContainer,userAccount,organization,enterprise,business);
        //Component[] componentArray = userProcessContainer.getComponents();
        //Component component = componentArray[componentArray.length - 1];
        //SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnHighlyAirPollutedAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHighlyAirPollutedAreasActionPerformed
        // TODO add your handling code here:
        ArrayList<EarthquakeSensor> tempEarthquakeSensorList = new ArrayList<EarthquakeSensor>();

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
                    if(sense instanceof EarthquakeSensor)
                    {
                        EarthquakeSensor eqs = (EarthquakeSensor)sense;
                        tempEarthquakeSensorList.add(eqs);
                    }
                }
            }

            }
        }   }
            
        DefaultTableModel model = (DefaultTableModel) tblEarthquake.getModel();
        model.setRowCount(0);
        
        for(EarthquakeSensor eqs : tempEarthquakeSensorList)
                {
                    if(eqs.getSeismicReading()>5)
                    {
                        Object[] row = new Object[4];
                        row[0] = eqs;
                        row[1] = eqs.getZipcode();
                        row[2] = eqs.getSeismicReading();
                        model.addRow(row);
                    }
                }
    }//GEN-LAST:event_btnHighlyAirPollutedAreasActionPerformed

    private void btnNotifyGovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotifyGovActionPerformed
        // TODO add your handling code here:
        NotifyToGovernmentJPanel notifyToGovernmentJPanel = new NotifyToGovernmentJPanel(userProcessContainer, userAccount, business, organizationDirectory);
        userProcessContainer.add("sendRequestToGovernmentJPanel", notifyToGovernmentJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnNotifyGovActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnHighlyAirPollutedAreas;
    private javax.swing.JButton btnNotifyEarthquake;
    private javax.swing.JButton btnNotifyGov;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblEarthquake;
    private javax.swing.JTable tblSeismicReadings;
    // End of variables declaration//GEN-END:variables
}
