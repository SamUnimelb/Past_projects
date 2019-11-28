package ProjectFrames;

import BasicEntities.Activity;
import BasicEntities.Peforms;
import DBLinkers.ActivityLinker;
import DBLinkers.PerformsLinker;
import java.util.Calendar;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class ActivityFrame extends javax.swing.JFrame{

    /**
     * Creates new form ActivityFrame
     * @param rUserID
     */
    public ActivityFrame(int rUserID) {
        this.rUserID = rUserID;
        updateActivityList();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    private void updateActivityList() {
        activityLinker = new ActivityLinker();
        activityList = activityLinker.getAllActivities();
        activityStrList = new LinkedList<>();

        activityList.forEach((au) -> {
            activityStrList.add(au.getActivityName() + "-" + au.getActivityChineseName());
        });
        activityStrs = (String[]) activityStrList.toArray(new String[activityStrList.size()]);
        if (activityCombo != null) {
            activityCombo.setModel(new javax.swing.DefaultComboBoxModel<>(activityStrs));
        }
    }//end method

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        activityCombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        addBt = new javax.swing.JButton();
        startHour = new javax.swing.JTextField();
        startMinute = new javax.swing.JTextField();
        startSecond = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        endHour = new javax.swing.JTextField();
        endMinute = new javax.swing.JTextField();
        endSecond = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        recordBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        activityCombo.setFont(new java.awt.Font("仿宋", 0, 24)); // NOI18N
        activityCombo.setModel(new javax.swing.DefaultComboBoxModel<>(activityStrs));

        jLabel1.setFont(new java.awt.Font("仿宋", 0, 24)); // NOI18N
        jLabel1.setText("My activity today:");

        addBt.setFont(new java.awt.Font("仿宋", 0, 24)); // NOI18N
        addBt.setText("Add Activity");
        addBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtActionPerformed(evt);
            }
        });

        startHour.setFont(new java.awt.Font("仿宋", 0, 24)); // NOI18N
        startHour.setText("07");

        startMinute.setFont(new java.awt.Font("仿宋", 0, 24)); // NOI18N
        startMinute.setText("00");

        startSecond.setFont(new java.awt.Font("仿宋", 0, 24)); // NOI18N
        startSecond.setText("00");

        jLabel2.setFont(new java.awt.Font("仿宋", 0, 24)); // NOI18N
        jLabel2.setText("Start at:");

        jLabel3.setFont(new java.awt.Font("仿宋", 0, 24)); // NOI18N
        jLabel3.setText(":");

        jLabel4.setFont(new java.awt.Font("仿宋", 0, 24)); // NOI18N
        jLabel4.setText(":");

        jLabel5.setFont(new java.awt.Font("仿宋", 0, 24)); // NOI18N
        jLabel5.setText(":");

        jLabel6.setFont(new java.awt.Font("仿宋", 0, 24)); // NOI18N
        jLabel6.setText(":");

        endHour.setFont(new java.awt.Font("仿宋", 0, 24)); // NOI18N
        endHour.setText("07");

        endMinute.setFont(new java.awt.Font("仿宋", 0, 24)); // NOI18N
        endMinute.setText("00");

        endSecond.setFont(new java.awt.Font("仿宋", 0, 24)); // NOI18N
        endSecond.setText("00");

        jLabel7.setFont(new java.awt.Font("仿宋", 0, 24)); // NOI18N
        jLabel7.setText("Ends at:");

        recordBt.setFont(new java.awt.Font("仿宋", 0, 24)); // NOI18N
        recordBt.setText("Record Activity");
        recordBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(activityCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startSecond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(endHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endSecond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addComponent(recordBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(activityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addBt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startSecond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(11, 11, 11)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endSecond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(recordBt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void recordBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordBtActionPerformed
        // TODO add your handling code here:
        peforms = new Peforms();
        peforms.setRUserID(rUserID);
        peforms.setActivityID(activityList.get(activityCombo.getSelectedIndex()).getActivityID());
        
        Calendar calStart = Calendar.getInstance();
        calStart.set(Calendar.HOUR_OF_DAY, Integer.parseInt(startHour.getText()));
        calStart.set(Calendar.MINUTE, Integer.parseInt(startMinute.getText()));
        calStart.set(Calendar.SECOND, Integer.parseInt(startSecond.getText()));
        peforms.setStartTime(calStart);
        
        Calendar calEnd = Calendar.getInstance();
        calEnd.set(Calendar.HOUR_OF_DAY, Integer.parseInt(endHour.getText()));
        calEnd.set(Calendar.MINUTE, Integer.parseInt(endMinute.getText()));
        calEnd.set(Calendar.SECOND, Integer.parseInt(endSecond.getText()));
        peforms.setEndTime(calEnd);
        
        performsLinker = new PerformsLinker();
        boolean success = performsLinker.addPerformRecord(peforms);
        String hint = "Record activity " + (success ? "succeeded!" : "failed!");
        JOptionPane.showMessageDialog(this, hint);
    }//GEN-LAST:event_recordBtActionPerformed

    private void addBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtActionPerformed
        // TODO add your handling code here:
        AddActivityFrame aaf = new AddActivityFrame();
        aaf.displayFrame();
        JOptionPane.showMessageDialog(this, "You can reopen this dialog after adding the activity.");
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_addBtActionPerformed

    /**
     */
    public void displayFrame() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ActivityFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActivityFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActivityFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActivityFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ActivityFrame(rUserID).setVisible(true);
        });
    }

    private int rUserID;
    
    private ActivityLinker activityLinker;
    private LinkedList<Activity> activityList;
    private LinkedList<String> activityStrList;
    private String[] activityStrs;
    
    private Peforms peforms;
    private PerformsLinker performsLinker;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> activityCombo;
    private javax.swing.JButton addBt;
    private javax.swing.JTextField endHour;
    private javax.swing.JTextField endMinute;
    private javax.swing.JTextField endSecond;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton recordBt;
    private javax.swing.JTextField startHour;
    private javax.swing.JTextField startMinute;
    private javax.swing.JTextField startSecond;
    // End of variables declaration//GEN-END:variables
}//end class
