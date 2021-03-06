/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.Treasure;
import NapakalakiGame.TreasureKind;

/**
 *
 * @author emilio
 */
public class TreasureView extends javax.swing.JPanel {
    
    private Treasure treasureModel;
    private boolean selected = false;
    
    /**
     * Creates new form TreasureView
     */
    public TreasureView() {
        initComponents();
    }
    
    
    public boolean isSelected(){
        return selected;
    }
    
    public Treasure getTreasure(){
        return treasureModel;
    }
    
    public void setTreasure (Treasure aTreasure) {
         
    treasureModel = aTreasure;
    icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/treasures/"+this.treasureModel.getName()+".JPG")));

    repaint();
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        icon = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(136, 219));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        icon.setPreferredSize(new java.awt.Dimension(112, 191));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if(isSelected()){
            selected = false;
            this.setBorder(null);
        }
        else{
            selected = true;
            this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0,0), 2));
        }
        
        this.repaint();
    }//GEN-LAST:event_formMouseClicked
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon;
    // End of variables declaration//GEN-END:variables
}
