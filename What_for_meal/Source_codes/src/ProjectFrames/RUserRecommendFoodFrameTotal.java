/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectFrames;

import BasicEntities.FoodDrink;
import java.util.LinkedList;
import javax.swing.JFrame;

/**
 *
 * @author SamY
 */
public class RUserRecommendFoodFrameTotal extends javax.swing.JFrame {

    /**
     * Creates new form RUserRecommendFoodFrameTotal
     * @param recommendFoodDrinkList
     */
    public RUserRecommendFoodFrameTotal(LinkedList<FoodDrink> recommendFoodDrinkList) {
        this.recommendFoodDrinkList = recommendFoodDrinkList;
        initComponents();
        protein = fat = carbo = cal = vitamin = mineral = water = 0.0;
        calculateSetParameters();
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        proteinLabel = new javax.swing.JLabel();
        fatLabel = new javax.swing.JLabel();
        carboLabel = new javax.swing.JLabel();
        calLabel = new javax.swing.JLabel();
        vitaminLabel = new javax.swing.JLabel();
        mineralLabel = new javax.swing.JLabel();
        waterLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Shonar Bangla", 2, 24)); // NOI18N
        jLabel2.setText("Protein (g):");

        jLabel3.setFont(new java.awt.Font("Shonar Bangla", 2, 24)); // NOI18N
        jLabel3.setText("Fat (g):");

        jLabel4.setFont(new java.awt.Font("Shonar Bangla", 2, 24)); // NOI18N
        jLabel4.setText("Carbo (g):");
        jLabel4.setToolTipText("Carbo stands for carbohydrate");

        jLabel5.setFont(new java.awt.Font("Shonar Bangla", 2, 24)); // NOI18N
        jLabel5.setText("Cal (g):");
        jLabel5.setToolTipText("Cal stands for calorie");

        jLabel6.setFont(new java.awt.Font("Shonar Bangla", 2, 24)); // NOI18N
        jLabel6.setText("Vitamin (g):");

        jLabel7.setFont(new java.awt.Font("Shonar Bangla", 2, 24)); // NOI18N
        jLabel7.setText("Mineral (g):");

        jLabel8.setFont(new java.awt.Font("Shonar Bangla", 2, 24)); // NOI18N
        jLabel8.setText("Water (g):");

        proteinLabel.setFont(new java.awt.Font("Shonar Bangla", 2, 24)); // NOI18N
        proteinLabel.setText("jLabel9");

        fatLabel.setFont(new java.awt.Font("Shonar Bangla", 2, 24)); // NOI18N
        fatLabel.setText("jLabel9");

        carboLabel.setFont(new java.awt.Font("Shonar Bangla", 2, 24)); // NOI18N
        carboLabel.setText("jLabel9");

        calLabel.setFont(new java.awt.Font("Shonar Bangla", 2, 24)); // NOI18N
        calLabel.setText("jLabel9");

        vitaminLabel.setFont(new java.awt.Font("Shonar Bangla", 2, 24)); // NOI18N
        vitaminLabel.setText("jLabel9");

        mineralLabel.setFont(new java.awt.Font("Shonar Bangla", 2, 24)); // NOI18N
        mineralLabel.setText("jLabel9");

        waterLabel.setFont(new java.awt.Font("Shonar Bangla", 2, 24)); // NOI18N
        waterLabel.setText("jLabel9");

        jLabel1.setFont(new java.awt.Font("Shonar Bangla", 2, 24)); // NOI18N
        jLabel1.setText("Overall paramters for this meal: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(calLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(vitaminLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mineralLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(waterLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(carboLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                            .addComponent(proteinLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fatLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(proteinLabel))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fatLabel))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(carboLabel))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(calLabel))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(vitaminLabel))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(mineralLabel))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(waterLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(RUserRecommendFoodFrameTotal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RUserRecommendFoodFrameTotal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RUserRecommendFoodFrameTotal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RUserRecommendFoodFrameTotal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RUserRecommendFoodFrameTotal(recommendFoodDrinkList).setVisible(true);
        });
    }//end method
    
    private void calculateSetParameters(){
        for(FoodDrink fd : recommendFoodDrinkList){
            protein += fd.getProtein();
            fat += fd.getFat();
            carbo += fd.getCarbohydrate();
            cal += fd.getCalorie();
            vitamin += fd.getVitamin();
            mineral += fd.getMineral();
            water += fd.getWater();
        }//end loop
        
        proteinLabel.setText(String.format("%.2f", protein));
        fatLabel.setText(String.format("%.2f", fat));
        carboLabel.setText(String.format("%.2f", carbo));
        calLabel.setText(String.format("%.2f", cal));
        vitaminLabel.setText(String.format("%.2f", vitamin));
        mineralLabel.setText(String.format("%.2f", mineral));
        waterLabel.setText(String.format("%.2f", water));
    }

    private LinkedList<FoodDrink> recommendFoodDrinkList;
    private double protein, fat, carbo, cal, vitamin, mineral, water;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel calLabel;
    private javax.swing.JLabel carboLabel;
    private javax.swing.JLabel fatLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel mineralLabel;
    private javax.swing.JLabel proteinLabel;
    private javax.swing.JLabel vitaminLabel;
    private javax.swing.JLabel waterLabel;
    // End of variables declaration//GEN-END:variables
}
