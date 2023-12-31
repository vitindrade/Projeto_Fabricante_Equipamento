/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package projeto_fabricante_equipamento.n.GUI;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projeto_fabricante_equipamento.n.DB.FabricanteDB;
import projeto_fabricante_equipamento.n.MODEL.Fabricante;

/**
 *
 * @author vitor
 */
public class RemoverFabricanteIF extends javax.swing.JInternalFrame {
    private DefaultTableModel modelTableFabricantes = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int colunm){
            return false;
        }  
    };

    /**
     * Creates new form RemoverFabricanteIF
     */
    public RemoverFabricanteIF() {
        initComponents();
        loadFabricantesTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        fab_table = new javax.swing.JTable();
        fechar_bt = new javax.swing.JButton();
        remover_bt = new javax.swing.JButton();

        fab_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(fab_table);

        fechar_bt.setText("Fechar");
        fechar_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechar_btActionPerformed(evt);
            }
        });

        remover_bt.setText("Remover");
        remover_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remover_btActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(remover_bt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(fechar_bt)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechar_bt)
                    .addComponent(remover_bt))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fechar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechar_btActionPerformed
        this.dispose();
    }//GEN-LAST:event_fechar_btActionPerformed

    private void remover_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remover_btActionPerformed
        int linhaSelecionadaFabricantes = fab_table.getSelectedRow();
        int idFabricante = (int) fab_table.getValueAt(linhaSelecionadaFabricantes, 0);
        
        FabricanteDB fabricanteDB = new FabricanteDB();
        
        if(fabricanteDB.hasEquipamento(idFabricante)){
            int res = JOptionPane.showConfirmDialog(rootPane, "Este fabricante contém equipamentos.\n"
                +"Se ele for removido, seus equipamentos também serão.\n"
                +"Deseja prosseguir?");
            if(res == JOptionPane.YES_OPTION){
                boolean resp = fabricanteDB.delete(idFabricante);
                if(resp){
                    JOptionPane.showMessageDialog(rootPane, "Fabricante removido com sucesso!");
                    modelTableFabricantes.removeRow(linhaSelecionadaFabricantes);
                    fab_table.setModel(modelTableFabricantes);
                    jScrollPane1.setViewportView(fab_table);
                }
            } else{
                return;
            } 
        } else{
            boolean resp = fabricanteDB.delete(idFabricante);
            if(resp){
                JOptionPane.showMessageDialog(rootPane, "Fabricante removido com sucesso!");
                modelTableFabricantes.removeRow(linhaSelecionadaFabricantes);
                fab_table.setModel(modelTableFabricantes);
                jScrollPane1.setViewportView(fab_table);
            }
            
        }
    }//GEN-LAST:event_remover_btActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable fab_table;
    private javax.swing.JButton fechar_bt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton remover_bt;
    // End of variables declaration//GEN-END:variables

    private void loadFabricantesTable() {
        modelTableFabricantes.addColumn("idFabricante");
        modelTableFabricantes.addColumn("nome");
        modelTableFabricantes.addColumn("cnpj");
        modelTableFabricantes.addColumn("cidade");
        modelTableFabricantes.addColumn("estado");

        FabricanteDB fabricanteDB = new FabricanteDB();
        ArrayList<Fabricante> fabricantes = fabricanteDB.getFabricantes();
        
        for(int i=0; i< fabricantes.size(); i++){
            Fabricante fabricante = (Fabricante) fabricantes.get(i);
            modelTableFabricantes.addRow(new Object[]{
                fabricante.getIdFabricante(), fabricante.getNome(), 
                fabricante.getCnpj(), fabricante.getCidade(),
                fabricante.getEstado()
            });
        }
        fab_table.setModel(modelTableFabricantes);
        jScrollPane1.setViewportView(fab_table);
    }
}
