/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Main.java
 *
 * Created on 6/11/2013, 08:01:40 PM
 */
package sumaceroestrategiaaleatoria;

import javax.swing.table.TableColumn;

/**
 *
 * @author osfprieto
 */
public class Main extends javax.swing.JFrame {

    /** Creates new form Main */
    public Main() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        panelButtons = new javax.swing.JPanel();
        updateDataTableButton = new javax.swing.JButton();
        spinnerQuantityB = new javax.swing.JSpinner();
        spinnerQuantityB.setValue(4);
        buttonCalculateA = new javax.swing.JButton();
        buttonCalculateB = new javax.swing.JButton();
        labelQuantityA = new javax.swing.JLabel();
        labelQuantityCols = new javax.swing.JLabel();
        spinnerQuantityA = new javax.swing.JSpinner();
        spinnerQuantityA.setValue(4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        dataTable.getTableHeader().setReorderingAllowed(false);
        dataTable.setModel(new MyJTableModel());
        scrollPane.setViewportView(dataTable);

        updateDataTableButton.setText("Actualizar");
        updateDataTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDataTableButtonActionPerformed(evt);
            }
        });

        buttonCalculateA.setText("Calcular A");
        buttonCalculateA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCalculateAActionPerformed(evt);
            }
        });

        buttonCalculateB.setText("Calcular B");
        buttonCalculateB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCalculateBActionPerformed(evt);
            }
        });

        labelQuantityA.setText("Estrategias A");
        labelQuantityA.setToolTipText("The number of strategies to define for the players");

        labelQuantityCols.setText("Estrategias B");
        labelQuantityCols.setToolTipText("The number of strategies to define for the players");

        javax.swing.GroupLayout panelButtonsLayout = new javax.swing.GroupLayout(panelButtons);
        panelButtons.setLayout(panelButtonsLayout);
        panelButtonsLayout.setHorizontalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelButtonsLayout.createSequentialGroup()
                        .addComponent(buttonCalculateB, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonsLayout.createSequentialGroup()
                        .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelButtonsLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(spinnerQuantityA, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                            .addGroup(panelButtonsLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(spinnerQuantityB, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)))
                        .addGap(26, 26, 26))
                    .addGroup(panelButtonsLayout.createSequentialGroup()
                        .addComponent(labelQuantityA, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonsLayout.createSequentialGroup()
                        .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonCalculateA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(updateDataTableButton, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelButtonsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(labelQuantityCols, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addGap(22, 22, 22)))
        );
        panelButtonsLayout.setVerticalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonsLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(labelQuantityA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spinnerQuantityA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(spinnerQuantityB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateDataTableButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCalculateA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCalculateB))
            .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelButtonsLayout.createSequentialGroup()
                    .addGap(85, 85, 85)
                    .addComponent(labelQuantityCols)
                    .addContainerGap(150, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void updateDataTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDataTableButtonActionPerformed
    updateDataTable();
}//GEN-LAST:event_updateDataTableButtonActionPerformed

private void buttonCalculateAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCalculateAActionPerformed
    Controller.maxForA(((MyJTableModel)dataTable.getModel()).getData());
}//GEN-LAST:event_buttonCalculateAActionPerformed

private void buttonCalculateBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCalculateBActionPerformed
    Controller.maxForB(((MyJTableModel)dataTable.getModel()).getData());
}//GEN-LAST:event_buttonCalculateBActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    
    public void updateDataTable(){
        int newN = ((Integer)spinnerQuantityA.getValue()).intValue();
        int newM = ((Integer)spinnerQuantityB.getValue()).intValue();
        
        
        int prevN = ((MyJTableModel)dataTable.getModel()).getN();
        int prevM = ((MyJTableModel)dataTable.getModel()).getM();
        
        if(prevM<newM)
            for(int i=prevM;i<newM;i++)
                dataTable.addColumn(new TableColumn(i+1));
        else if(newM<prevM)
            for(int i=newM-1;i>=prevM;i--)
                dataTable.removeColumn(dataTable.getColumn(i));
                //dataTable.getColumn(i).setWidth(1);
                //dataTable.getColumn(i).setMaxWidth(1);
        
        ((MyJTableModel)dataTable.getModel()).setN(newN);
        ((MyJTableModel)dataTable.getModel()).setM(newM);
        
        ((MyJTableModel)dataTable.getModel()).fireTableStructureChanged();
        spinnerQuantityA.setValue(Math.max(newN, 2));
        spinnerQuantityB.setValue(Math.max(newM, 2));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCalculateA;
    private javax.swing.JButton buttonCalculateB;
    private javax.swing.JTable dataTable;
    private javax.swing.JLabel labelQuantityA;
    private javax.swing.JLabel labelQuantityCols;
    private javax.swing.JPanel panelButtons;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JSpinner spinnerQuantityA;
    private javax.swing.JSpinner spinnerQuantityB;
    private javax.swing.JButton updateDataTableButton;
    // End of variables declaration//GEN-END:variables
}
