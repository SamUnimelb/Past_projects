package ProjectFrames;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import DBLinkers.RegisteredUserLinker;
import FunctionalClasses.RecommendDishes;
import javax.swing.JFrame;

/**
 *
 * @author Administrator
 */
public class RegisteredUserFrame extends javax.swing.JFrame implements Runnable{

    /**
     * Creates new form RegisteredUserFrame
     */
    public RegisteredUserFrame(int rUserID) {
        this.rUserID = rUserID;
        rgisteredUserLinker = new RegisteredUserLinker();
        username = rgisteredUserLinker.readSingleUserFromDB(rUserID).getUsername();
        initComponents();
        userNameLabel.setText(username);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userFlavorBt = new javax.swing.JButton();
        rUserBMIBt = new javax.swing.JButton();
        healthProfileBt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        recommendFoodBt = new javax.swing.JButton();
        recordDietBt = new javax.swing.JButton();
        activityBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        userFlavorBt.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        userFlavorBt.setText("Flavor Trends");
        userFlavorBt.setToolTipText("Check / Change your flavor");
        userFlavorBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userFlavorBtActionPerformed(evt);
            }
        });

        rUserBMIBt.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        rUserBMIBt.setText("MY BMI");
        rUserBMIBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rUserBMIBtActionPerformed(evt);
            }
        });

        healthProfileBt.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        healthProfileBt.setText("Health Profile");
        healthProfileBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                healthProfileBtActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Welcome! User:");

        userNameLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        userNameLabel.setText("Not specified");

        recommendFoodBt.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        recommendFoodBt.setText("Recommend Food");
        recommendFoodBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recommendFoodBtActionPerformed(evt);
            }
        });

        recordDietBt.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        recordDietBt.setText("Record Diet");
        recordDietBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordDietBtActionPerformed(evt);
            }
        });

        activityBt.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        activityBt.setText("Record Activity");
        activityBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activityBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userNameLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(activityBt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(recordDietBt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(recommendFoodBt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(healthProfileBt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rUserBMIBt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(userFlavorBt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userNameLabel))
                .addGap(18, 18, 18)
                .addComponent(userFlavorBt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rUserBMIBt)
                .addGap(18, 18, 18)
                .addComponent(healthProfileBt)
                .addGap(18, 18, 18)
                .addComponent(recommendFoodBt)
                .addGap(18, 18, 18)
                .addComponent(recordDietBt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(activityBt)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userFlavorBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userFlavorBtActionPerformed
        // TODO add your handling code here:               
        UserFlavorFrame uFlavorFrame = new UserFlavorFrame(rUserID);
        uFlavorFrame.displayFrame();
    }//GEN-LAST:event_userFlavorBtActionPerformed

    private void rUserBMIBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rUserBMIBtActionPerformed
        // TODO add your handling code here:
        RUserBMIFrame bmiFrame = new RUserBMIFrame(rUserID);
        bmiFrame.displayFrame();  
    }//GEN-LAST:event_rUserBMIBtActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void healthProfileBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_healthProfileBtActionPerformed
        // TODO add your handling code here:
        RUserSuffersFrame rUserSuffers = new RUserSuffersFrame(rUserID);
        rUserSuffers.displayFrame();
    }//GEN-LAST:event_healthProfileBtActionPerformed

    private void recommendFoodBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recommendFoodBtActionPerformed
        // TODO add your handling code here:
        RUserRecommendFoodFrame rd = new RUserRecommendFoodFrame(rUserID);
        rd.displayFrame();
    }//GEN-LAST:event_recommendFoodBtActionPerformed

    private void recordDietBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordDietBtActionPerformed
        // TODO add your handling code here:
        RUserRecordDiet rd = new RUserRecordDiet(rUserID);
        rd.displayFrame();
    }//GEN-LAST:event_recordDietBtActionPerformed

    private void activityBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activityBtActionPerformed
        // TODO add your handling code here:
        ActivityFrame acf = new ActivityFrame(rUserID);
        acf.displayFrame();
    }//GEN-LAST:event_activityBtActionPerformed

    /**
     */
    @Override
    public void run() {
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
            java.util.logging.Logger.getLogger(RegisteredUserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisteredUserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisteredUserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisteredUserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RegisteredUserFrame(rUserID).setVisible(true);
        });
    }

    //User added code, can modify:
    //private ExecutorService threads;
    private int rUserID;
    private String username;
    private RegisteredUserLinker rgisteredUserLinker;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton activityBt;
    private javax.swing.JButton healthProfileBt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton rUserBMIBt;
    private javax.swing.JButton recommendFoodBt;
    private javax.swing.JButton recordDietBt;
    private javax.swing.JButton userFlavorBt;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
