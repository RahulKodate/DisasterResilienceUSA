/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.RNDMaps;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.RNDAnalysisOrganization;
import Business.UserAccount.UserAccount;
import UI.Waypoint.MyWaypoint;
import UI.Waypoint.WaypointRender;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;

/**
 *
 * @author moins
 */
public class RNDMapsJPanel extends javax.swing.JPanel {

    private final Set<MyWaypoint> waypoints = new HashSet<>();
    /**
     * Creates new form RNDMaps
     */
    private JPanel userProcessContainer; 
    private UserAccount account; 
    private RNDAnalysisOrganization organization;
    private Enterprise enterprise; 
    private EcoSystem business;
    public RNDMapsJPanel(JPanel userProcessContainer, UserAccount account, RNDAnalysisOrganization organization, Enterprise enterprise,  EcoSystem  business) {
        initComponents();
        init();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
        
    }

    private void init(){
        
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapViewer1.setTileFactory(tileFactory);
        GeoPosition geo = new GeoPosition(42.338093,-71.0916502);
        jXMapViewer1.setAddressLocation(geo);
        jXMapViewer1.setZoom(12);
        MouseInputListener mn = new PanMouseInputListener(jXMapViewer1);
        jXMapViewer1.addMouseListener(mn);
        jXMapViewer1.addMouseMotionListener(mn);
        jXMapViewer1.addMouseWheelListener(new ZoomMouseWheelListenerCenter(jXMapViewer1));
        
    }
    
    private void initWaypoint(){
        WaypointPainter<MyWaypoint> wp = new WaypointRender();
        wp.setWaypoints(waypoints);
        jXMapViewer1.setOverlayPainter(wp);
        for(MyWaypoint d : waypoints){
            jXMapViewer1.add(d.getButton());
        }
    }
    
    private void clearWaypoint(){
         for(MyWaypoint d : waypoints){
            jXMapViewer1.remove(d.getButton());
    }
         waypoints.clear();
         initWaypoint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXMapViewer1 = new org.jxmapviewer.JXMapViewer();
        BtnAddWaypoints = new javax.swing.JButton();
        btnClearWaypoint = new javax.swing.JButton();

        BtnAddWaypoints.setText("Add Waypoint");
        BtnAddWaypoints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddWaypointsActionPerformed(evt);
            }
        });

        btnClearWaypoint.setText("Clear Waypoint");

        javax.swing.GroupLayout jXMapViewer1Layout = new javax.swing.GroupLayout(jXMapViewer1);
        jXMapViewer1.setLayout(jXMapViewer1Layout);
        jXMapViewer1Layout.setHorizontalGroup(
            jXMapViewer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXMapViewer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnAddWaypoints)
                .addGap(29, 29, 29)
                .addComponent(btnClearWaypoint)
                .addContainerGap(741, Short.MAX_VALUE))
        );
        jXMapViewer1Layout.setVerticalGroup(
            jXMapViewer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXMapViewer1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXMapViewer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAddWaypoints)
                    .addComponent(btnClearWaypoint))
                .addContainerGap(568, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXMapViewer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXMapViewer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAddWaypointsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddWaypointsActionPerformed
        // TODO add your handling code here:
        
        waypoints.add(new MyWaypoint("Location 1", new GeoPosition(42.338093,-71.0916502)));
        initWaypoint();
    }//GEN-LAST:event_BtnAddWaypointsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAddWaypoints;
    private javax.swing.JButton btnClearWaypoint;
    private org.jxmapviewer.JXMapViewer jXMapViewer1;
    // End of variables declaration//GEN-END:variables
}
