package ProjectFrames;

import DBLinkers.FlavorLinker;
import DBLinkers.FlavorSimulatesLinker;
import DBLinkers.DiseaseLinker;
import BasicEntities.Disease;
import BasicEntities.Flavor;
import BasicEntities.FlavorSimulates;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class FlavorSimulatesFrame extends javax.swing.JFrame {

    /**
     * Creates new form FlavorSimulatesFrame
     */
    public FlavorSimulatesFrame() {
        flavorLinker = new FlavorLinker();
        flavorList = flavorLinker.getAllFlavors();
        flavorStrList = new LinkedList<>();        
        flavorList.forEach((f) -> {
            flavorStrList.add(f.getFlavorName() + "-" + f.getFlavorChineseName());
        });        
        flavorStrs = (String[])flavorStrList.toArray(new String[flavorStrList.size()]);
        updateDiseaseInfoStatus();
       
        initComponents();
        flavorSimulatesLinker = new FlavorSimulatesLinker();
        simulateReason.setText(flavorSimulatesLinker.getFlavorSimulates(flavorID, diseaseID).getReason());
        simulateChineseReason.setText(flavorSimulatesLinker.getFlavorSimulates(flavorID, diseaseID).getResonChinese());
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    private void updateDiseaseInfoStatus() {
        diseaseLinker = new DiseaseLinker();
        diseaseList = diseaseLinker.readAllDiseaseInfo();
        diseaseStrList = new LinkedList<>();
        diseaseList.forEach((d) -> {
            diseaseStrList.add(d.getDiseaseName() + "-" + d.getDiseaseChineseName());
        });
        diseaseStrs = (String[]) diseaseStrList.toArray(new String[diseaseStrList.size()]);
        //diseaseJCombo.setModel(new javax.swing.DefaultComboBoxModel<>(diseaseStrs));
    }//end method

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        flavorCombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        updateBt = new javax.swing.JButton();
        diseaseFrameBt = new javax.swing.JButton();
        diseaseJCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        simulateReason = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        simulateChineseReason = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        flavorCombo.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        flavorCombo.setModel(new javax.swing.DefaultComboBoxModel<>(flavorStrs));
        flavorID = flavorCombo.getSelectedIndex() + 1;
        flavorCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                flavorComboItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("楷体", 0, 24)); // NOI18N
        jLabel1.setText("Flavor:");

        jLabel2.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jLabel2.setText("Disease:");
        jLabel2.setToolTipText("");

        updateBt.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        updateBt.setText("Update Record");
        updateBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtActionPerformed(evt);
            }
        });

        diseaseFrameBt.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        diseaseFrameBt.setText("Add Disease");
        diseaseFrameBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diseaseFrameBtActionPerformed(evt);
            }
        });

        diseaseJCombo.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        diseaseJCombo.setModel(new javax.swing.DefaultComboBoxModel<>(diseaseStrs));
        diseaseJCombo.setToolTipText("This disease not found? Click add disease.");
        selectedDiseaseIndex = diseaseJCombo.getSelectedIndex();
        diseaseID = diseaseList.get(selectedDiseaseIndex).getIdDisease();
        diseaseJCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                diseaseJComboItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jLabel3.setText("Reason:");

        simulateReason.setColumns(20);
        simulateReason.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        simulateReason.setRows(5);
        simulateReason.setText("No serious problems has been discovered \nof the combination of those two.");
        jScrollPane2.setViewportView(simulateReason);

        jLabel4.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jLabel4.setText("原因（请输入中文）：");

        simulateChineseReason.setColumns(20);
        simulateChineseReason.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        simulateChineseReason.setRows(5);
        simulateChineseReason.setText("此种组合暂时未发现问题。");
        jScrollPane1.setViewportView(simulateChineseReason);

        jButton1.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jButton1.setText("Refresh");
        jButton1.setToolTipText("Need to be pressed after a new disease has been added.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(flavorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 12, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(diseaseJCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updateBt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(diseaseFrameBt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(flavorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateBt))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diseaseJCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diseaseFrameBt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void flavorComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_flavorComboItemStateChanged
        // TODO add your handling code here:
        flavorID = flavorCombo.getSelectedIndex() + 1;
        flavorSimulatesLinker = new FlavorSimulatesLinker();
        
        if(flavorSimulatesLinker.getFlavorSimulates(flavorID, diseaseID).getReason() != null)
            simulateReason.setText(flavorSimulatesLinker.getFlavorSimulates(flavorID, diseaseID).getReason());
        else
            simulateReason.setText("No serious problems has been discovered \nof the combination of those two.");
        
        if(flavorSimulatesLinker.getFlavorSimulates(flavorID, diseaseID).getResonChinese() != null)
            simulateChineseReason.setText(flavorSimulatesLinker.getFlavorSimulates(flavorID, diseaseID).getResonChinese());
        else
            simulateChineseReason.setText("此种组合暂时未被我国专家发现问题。");
    }//GEN-LAST:event_flavorComboItemStateChanged

    private void diseaseJComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_diseaseJComboItemStateChanged
        // TODO add your handling code here:
        selectedDiseaseIndex = diseaseJCombo.getSelectedIndex();
        diseaseID = diseaseList.get(selectedDiseaseIndex).getIdDisease();
        flavorSimulatesLinker = new FlavorSimulatesLinker();
        if(flavorSimulatesLinker.getFlavorSimulates(flavorID, diseaseID).getReason() != null)
            simulateReason.setText(flavorSimulatesLinker.getFlavorSimulates(flavorID, diseaseID).getReason());
        else
            simulateReason.setText("No serious problems has been discovered \nof the combination of those two.");
        
        if(flavorSimulatesLinker.getFlavorSimulates(flavorID, diseaseID).getResonChinese() != null)
            simulateChineseReason.setText(flavorSimulatesLinker.getFlavorSimulates(flavorID, diseaseID).getResonChinese());
        else
            simulateChineseReason.setText("此种组合暂时未被我国专家发现问题。");
    }//GEN-LAST:event_diseaseJComboItemStateChanged

    private void updateBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtActionPerformed
        // TODO add your handling code here:
        selectedDiseaseIndex = diseaseJCombo.getSelectedIndex();
        diseaseID = diseaseList.get(selectedDiseaseIndex).getIdDisease();
        flavorID = flavorCombo.getSelectedIndex() + 1;
        flavorSimulatesLinker = new FlavorSimulatesLinker();
        flavorSimulates = new FlavorSimulates();
        flavorSimulates.setFlavorID(flavorID);
        flavorSimulates.setDiseaseID(diseaseID);
        flavorSimulates.setReason(simulateReason.getText());
        flavorSimulates.setResonChinese(simulateChineseReason.getText());
        boolean success = flavorSimulatesLinker.setFlavorSimulates(flavorSimulates);
        String hint = "Update information " + (success ? "success!" : "failed!");
        JOptionPane.showMessageDialog(this, hint);
    }//GEN-LAST:event_updateBtActionPerformed

    private void diseaseFrameBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diseaseFrameBtActionPerformed
        // TODO add your handling code here:
        DiseaseFrame diseaseFrame = new DiseaseFrame();
        diseaseFrame.displayFrame();
    }//GEN-LAST:event_diseaseFrameBtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        updateDiseaseInfoStatus();
        diseaseJCombo.setModel(new javax.swing.DefaultComboBoxModel<>(diseaseStrs));
        this.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.removeAll();
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(FlavorSimulatesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlavorSimulatesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlavorSimulatesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlavorSimulatesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FlavorSimulatesFrame().setVisible(true);
        });
    }
    
    private final FlavorLinker flavorLinker;
    private final LinkedList<Flavor> flavorList;
    private LinkedList<String> flavorStrList;
    private final String[] flavorStrs;
    
    private DiseaseLinker diseaseLinker;
    private LinkedList<Disease> diseaseList;
    private LinkedList<String> diseaseStrList;
    private String[] diseaseStrs;
    
    private FlavorSimulatesLinker flavorSimulatesLinker;
    private FlavorSimulates flavorSimulates;
    
    private int flavorID;
    private int diseaseID;
    private int selectedDiseaseIndex;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton diseaseFrameBt;
    private javax.swing.JComboBox<String> diseaseJCombo;
    private javax.swing.JComboBox<String> flavorCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea simulateChineseReason;
    private javax.swing.JTextArea simulateReason;
    private javax.swing.JButton updateBt;
    // End of variables declaration//GEN-END:variables
}
