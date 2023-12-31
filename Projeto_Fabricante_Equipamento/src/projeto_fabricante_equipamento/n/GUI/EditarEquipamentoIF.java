/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package projeto_fabricante_equipamento.n.GUI;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projeto_fabricante_equipamento.n.DB.EquipamentoDB;
import projeto_fabricante_equipamento.n.MODEL.Equipamento;



/**
 *
 * @author vitor
 */
public class EditarEquipamentoIF extends javax.swing.JInternalFrame {
    private DefaultTableModel modelTableEquipamentos = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int colunm){
            if(colunm == 0 || colunm == 1){
                JOptionPane.showMessageDialog(rootPane, "Este valor não é editável!");
                return false;
            }
            return true;
        }  
    };
    /**
     * Creates new form EditarEquipamentoIF
     */
    public EditarEquipamentoIF() {
        initComponents();
        loadEquipamentosTable();
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
        equip_table = new javax.swing.JTable();
        editar_bt = new javax.swing.JButton();
        fechar_bt = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Editar Equipamento");
        setToolTipText("");

        equip_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(equip_table);

        editar_bt.setText("Editar");
        editar_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar_btActionPerformed(evt);
            }
        });

        fechar_bt.setText("Fechar");
        fechar_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechar_btActionPerformed(evt);
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
                .addGap(43, 43, 43)
                .addComponent(editar_bt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addComponent(fechar_bt)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechar_bt)
                    .addComponent(editar_bt))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fechar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechar_btActionPerformed
        this.dispose();
    }//GEN-LAST:event_fechar_btActionPerformed

    private void editar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar_btActionPerformed
        int linhaSelecionadaEquipamentos = equip_table.getSelectedRow();
        int idEquipamento = (int) equip_table.getValueAt(linhaSelecionadaEquipamentos, 0);
        int idFabricante = (int) equip_table.getValueAt(linhaSelecionadaEquipamentos, 1);
        String nome = (String) equip_table.getValueAt(linhaSelecionadaEquipamentos, 2);
        String preco = (String) equip_table.getValueAt(linhaSelecionadaEquipamentos, 3);
        
        float preco2 = Float.parseFloat(preco);
        
        Equipamento equipamento = new Equipamento(idEquipamento, idFabricante, nome, preco2);
        EquipamentoDB equipamentoDB = new EquipamentoDB();
        boolean res = equipamentoDB.update(equipamento);
        if(res){
            JOptionPane.showMessageDialog(rootPane, "Equipamento editado com sucesso!");
            equip_table.clearSelection();
        }
    }//GEN-LAST:event_editar_btActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editar_bt;
    private javax.swing.JTable equip_table;
    private javax.swing.JButton fechar_bt;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void loadEquipamentosTable() {
        modelTableEquipamentos.addColumn("idEquipamento");
        modelTableEquipamentos.addColumn("idFabricante");
        modelTableEquipamentos.addColumn("nome");
        modelTableEquipamentos.addColumn("preco");

        EquipamentoDB equipamentoDB = new EquipamentoDB();
        ArrayList<Equipamento> equipamentos = equipamentoDB.getEquipamentos();
        
        for(int i=0; i< equipamentos.size(); i++){
            Equipamento equipamento = (Equipamento) equipamentos.get(i);
            modelTableEquipamentos.addRow(new Object[]{
                equipamento.getIdEquipamento(), equipamento.getIdFabricante(), 
                equipamento.getNome(), equipamento.getPreco()
            });
        }
        equip_table.setModel(modelTableEquipamentos);
        jScrollPane1.setViewportView(equip_table);
    }
    
}
