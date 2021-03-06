/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTestingPackage;

import DBLinkers.RegisteredUserLinker;
import BasicEntities.RegisteredUser;
import ProjectFrames.ExpertUser;
import ProjectFrames.RegisteredUserFrame;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author SamY
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        identityGroup = new javax.swing.ButtonGroup();
        rUserRadio = new javax.swing.JRadioButton();
        exptRadio = new javax.swing.JRadioButton();
        loginBt = new javax.swing.JButton();
        registerBt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();

        identityGroup.add(rUserRadio);
        identityGroup.add(exptRadio);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rUserRadio.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        rUserRadio.setSelected(true);
        rUserRadio.setText("Registered User");

        exptRadio.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        exptRadio.setText("Expert User");

        loginBt.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        loginBt.setText("Log In");
        loginBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtActionPerformed(evt);
            }
        });

        registerBt.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        registerBt.setText("Register");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("Username:");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setText("Password:");

        usernameField.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        usernameField.setText("John Zan");

        passwordField.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        passwordField.setText("123456");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rUserRadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(loginBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usernameField)
                    .addComponent(passwordField)
                    .addComponent(exptRadio, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(registerBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rUserRadio)
                    .addComponent(exptRadio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registerBt)
                    .addComponent(loginBt))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtActionPerformed
        // TODO add your handling code here:
        username = usernameField.getText();
        password = passwordField.getText();

        if (rUserRadio.isSelected()) {
            registeredUserLinker = new RegisteredUserLinker();
            if (registeredUserLinker.verifySingleUser(username, password)) {
                rUser = registeredUserLinker.getRegisteredUser();
                RegisteredUserFrame rUserFrame = new RegisteredUserFrame(rUser.getUserid());
                ExecutorService threads = Executors.newCachedThreadPool();
                threads.execute(rUserFrame);
                threads.shutdown();
                this.setVisible(false);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Username / password invalid!", "Warning!", JOptionPane.WARNING_MESSAGE);
            }                
        }//Registered user log in.
        
        else{
                ExpertUser exptFrame = new ExpertUser();
                ExecutorService threads = Executors.newCachedThreadPool();
                threads.execute(exptFrame);
                threads.shutdown();
                this.setVisible(false);
                this.dispose();
        }//end else
        
    }//GEN-LAST:event_loginBtActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    private String username, password;
    private RegisteredUser rUser;
    private RegisteredUserLinker registeredUserLinker;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton exptRadio;
    private javax.swing.ButtonGroup identityGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginBt;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JRadioButton rUserRadio;
    private javax.swing.JButton registerBt;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
