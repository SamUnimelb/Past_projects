/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectFrames;

import javax.swing.ListSelectionModel;
import DBLinkers.DiseaseLinker;
import DBLinkers.SuffersLinker;
import BasicEntities.Disease;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class RUserSuffersFrame extends javax.swing.JFrame{

    /**
     * Creates new form RUserSuffersFrame
     * @param userID
     */
    public RUserSuffersFrame(int userID) {
        this.userID = userID;
        
        //Read all the diseases available in database:
        diseaseLinker = new DiseaseLinker();
        diseaseList = new LinkedList<>();
        diseaseList = diseaseLinker.readAllDiseaseInfo();
        diseaseStrs = new LinkedList<>();    
        diseaseList.forEach((d) -> {
            diseaseStrs.add(d.getDiseaseName() + "-" + d.getDiseaseChineseName());
        });     
        
        //Read what user suffers from:
        userDiseaseList = new LinkedList<>();
        suffersLinker = new SuffersLinker();
        userDiseaseList = suffersLinker.getUserDiseaseList(userID);
        
        initComponents();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }//end constructor

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        diseaseJList = new javax.swing.JList<>();
        saveBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        diseaseJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        String[] diseaseNameStrs =
        (String[])diseaseStrs.toArray(new String[diseaseStrs.size()]);

        //for(int i = 0; i < diseaseStrs.size(); i++)
        //diseaseNameStrs[i] = diseaseStrs.get(i);
        diseaseJList.setFont(new java.awt.Font("楷体", 1, 24)); // NOI18N
        diseaseJList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = diseaseNameStrs;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        diseaseJList.setToolTipText("Press <ctrl> to select multiple diseases.");
        diseaseIndices = new int[userDiseaseList.size()];
        int index = 0;

        for(Disease d : userDiseaseList){
            for(int i = 0; i < diseaseStrs.size(); i++){
                if(diseaseNameStrs[i].startsWith(d.getDiseaseName())){
                    diseaseIndices[index] = i;
                    index++;
                }//end if
            }//end inner loop
        }//end outter loop

        diseaseJList.setSelectedIndices(diseaseIndices);
        diseaseJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                diseaseJListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(diseaseJList);

        saveBt.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        saveBt.setText("Save My Disease Info");
        saveBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveBt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtActionPerformed
        // TODO add your handling code here:
        suffersLinker = new SuffersLinker();
        boolean setUserSuffersInfo = suffersLinker.setUserSuffersInfo(userID, userDiseaseList);
        String hint = "Update your disease record " + ( setUserSuffersInfo ? " success. " : " fails. ");
        JOptionPane.showMessageDialog(this, hint);
    }//GEN-LAST:event_saveBtActionPerformed

    private void diseaseJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_diseaseJListValueChanged
        // TODO add your handling code here:
        diseaseIndices = diseaseJList.getSelectedIndices();
        userDiseaseList = new LinkedList<>();
        
        for(int eachIndex : diseaseIndices){
            diseaseLinker = new DiseaseLinker();
            String diseaseName = diseaseStrs.get(eachIndex).split("-")[0];
            Disease d = diseaseLinker.readDiseaseInfoFromDB(diseaseName, false);
            userDiseaseList.add(d);
        }//end loop
    }//GEN-LAST:event_diseaseJListValueChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.removeAll();
        this.setEnabled(false);
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
            java.util.logging.Logger.getLogger(RUserSuffersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RUserSuffersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RUserSuffersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RUserSuffersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RUserSuffersFrame(userID).setVisible(true);
        });
    }
    
    //User defined variables:
    private final int userID;
    private DiseaseLinker diseaseLinker;
    private LinkedList<String> diseaseStrs;
    private SuffersLinker suffersLinker;
    private LinkedList<Disease> diseaseList;
    private LinkedList<Disease> userDiseaseList;
    private int[] diseaseIndices;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> diseaseJList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveBt;
    // End of variables declaration//GEN-END:variables
}
