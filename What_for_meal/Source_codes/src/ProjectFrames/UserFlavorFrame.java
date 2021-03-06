package ProjectFrames;

import BasicEntities.Flavor;
import BasicEntities.Disease;
import DBLinkers.FlavorLinker;
import DBLinkers.RegisteredUserLinker;
import DBLinkers.UserFlavorLinker;
import DBLinkers.SuffersLinker;
import DBLinkers.FlavorSimulatesLinker;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class UserFlavorFrame extends javax.swing.JFrame{

    /**
     * Creates new form UserFlavorFrame
     * @param rUserID
     */
    public UserFlavorFrame(int rUserID) {
        this.rUserID = rUserID;
        userFlavorLinker = new UserFlavorLinker();
        rUserLinker = new RegisteredUserLinker();
        flavorList = userFlavorLinker.getUserFlavorList(rUserID);

        String username = rUserLinker.readSingleUserFromDB(rUserID).getUsername();
        suffersLinker = new SuffersLinker();
        suffersList = suffersLinker.getUserDiseaseList(rUserID);
        
        initComponents();
        flavorList.forEach((f) -> {
            tickComboBox(f.getIdFlavor());
        }); //end loop
        
        usernameLabel.setText(username);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }//end cons

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox9 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        recordBt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();

        jCheckBox9.setText("jCheckBox9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("仿宋", 1, 24)); // NOI18N
        jLabel1.setText("User:");

        usernameLabel.setFont(new java.awt.Font("仿宋", 1, 24)); // NOI18N
        usernameLabel.setText("Username");

        jCheckBox1.setFont(new java.awt.Font("仿宋", 1, 24)); // NOI18N
        jCheckBox1.setText("Salty 咸");

        jCheckBox2.setFont(new java.awt.Font("仿宋", 1, 24)); // NOI18N
        jCheckBox2.setText("Bitter 苦");

        jCheckBox3.setFont(new java.awt.Font("仿宋", 1, 24)); // NOI18N
        jCheckBox3.setText("Sour 酸");

        jCheckBox4.setFont(new java.awt.Font("仿宋", 1, 24)); // NOI18N
        jCheckBox4.setText("Sweet 甜");

        jCheckBox5.setFont(new java.awt.Font("仿宋", 1, 24)); // NOI18N
        jCheckBox5.setText("Spicy 辣");

        jCheckBox6.setFont(new java.awt.Font("仿宋", 1, 24)); // NOI18N
        jCheckBox6.setText("Unami 鲜");

        jCheckBox7.setFont(new java.awt.Font("仿宋", 1, 24)); // NOI18N
        jCheckBox7.setText("Nice 香");

        jCheckBox8.setFont(new java.awt.Font("仿宋", 1, 24)); // NOI18N
        jCheckBox8.setText("Light 淡");

        recordBt.setFont(new java.awt.Font("仿宋", 1, 24)); // NOI18N
        recordBt.setText("Record My Flavor");
        recordBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordBtActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("仿宋", 1, 24)); // NOI18N
        jLabel2.setText("Choose the flavor you prefer:");

        jCheckBox10.setFont(new java.awt.Font("仿宋", 1, 24)); // NOI18N
        jCheckBox10.setText("Greasy 腻");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox1)
                                    .addComponent(jCheckBox2)
                                    .addComponent(jCheckBox3)
                                    .addComponent(jCheckBox4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox5)
                                    .addComponent(jCheckBox6)
                                    .addComponent(jCheckBox7)
                                    .addComponent(jCheckBox8)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(recordBt)
                                    .addComponent(jCheckBox10))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usernameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(recordBt)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void recordBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordBtActionPerformed
        // TODO add your handling code here:
        checkFlavorList();
        userFlavorLinker = new UserFlavorLinker();
        
        flavorList.stream().map((f) -> {
            flavorSimulatesLinker = new FlavorSimulatesLinker();
            return f;
        }).map((f) -> {
            FlavorLinker flavorLinker = new FlavorLinker();
            f = flavorLinker.readTheFlavorInfoFromDB(f.getIdFlavor());
            return f;
        }).forEachOrdered((f) -> {
            suffersList.stream().map((d) -> flavorSimulatesLinker.getFlavorSimulates(f.getIdFlavor(), d.getIdDisease())).filter((fs) -> (fs != null && fs.getReason() != null)).forEachOrdered((fs) -> {
                JOptionPane.showMessageDialog(this, "Flavor " + f.getFlavorName() + " may leads your disease to a more "
                        + "serious condition, \nbecause " + fs.getReason(), "Not recommend to choose this taste", JOptionPane.WARNING_MESSAGE);
            }); //end loop            
        }); //end for each loop
        
        boolean success = userFlavorLinker.storeUserFlavorInfo(flavorList, rUserID);
        String hint = "Update your flavor " + (success ? "succeed." : "failed.");
        JOptionPane.showMessageDialog(this, hint);
    }//GEN-LAST:event_recordBtActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(UserFlavorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserFlavorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserFlavorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFlavorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new UserFlavorFrame(rUserID).setVisible(true);
        });
    }//end method
    
    public void tickComboBox(int flavorID) {
        switch (flavorID) {
            case 1:
                jCheckBox1.setSelected(true);
                break;
            case 2:
                jCheckBox2.setSelected(true);
                break;
            case 3:
                jCheckBox3.setSelected(true);
                break;
            case 4:
                jCheckBox4.setSelected(true);
                break;
            case 5:
                jCheckBox5.setSelected(true);
                break;
            case 6:
                jCheckBox6.setSelected(true);
                break;
            case 7:
                jCheckBox7.setSelected(true);
                break;
            case 8:
                jCheckBox8.setSelected(true);
                break;
            default:
                jCheckBox9.setSelected(true);
                break;
        }//end switch
    }//end method
    
    public void checkFlavorList() {
        flavorList = new LinkedList<>();
        Flavor flavor;

        if (jCheckBox1.isSelected()) {
            flavor = new Flavor();
            flavor.setIdFlavor(1);
            flavorList.add(flavor);
        }

        if (jCheckBox2.isSelected()) {
            flavor = new Flavor();
            flavor.setIdFlavor(2);
            flavorList.add(flavor);
        }

        if (jCheckBox3.isSelected()) {
            flavor = new Flavor();
            flavor.setIdFlavor(3);
            flavorList.add(flavor);
        }

        if (jCheckBox4.isSelected()) {
            flavor = new Flavor();
            flavor.setIdFlavor(4);
            flavorList.add(flavor);
        }

        if (jCheckBox5.isSelected()) {
            flavor = new Flavor();
            flavor.setIdFlavor(5);
            flavorList.add(flavor);
        }

        if (jCheckBox6.isSelected()) {
            flavor = new Flavor();
            flavor.setIdFlavor(6);
            flavorList.add(flavor);
        }

        if (jCheckBox7.isSelected()) {
            flavor = new Flavor();
            flavor.setIdFlavor(7);
            flavorList.add(flavor);
        }

        if (jCheckBox8.isSelected()) {
            flavor = new Flavor();
            flavor.setIdFlavor(8);
            flavorList.add(flavor);
        }

    }//end method

    //User specified variable:
    private int rUserID;
    private LinkedList<Flavor> flavorList;
    private UserFlavorLinker userFlavorLinker;
    private RegisteredUserLinker rUserLinker;
    private SuffersLinker suffersLinker;
    private LinkedList<Disease> suffersList;
    private FlavorSimulatesLinker flavorSimulatesLinker;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton recordBt;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}//end class
