/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_fabricante_equipamento.n.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto_fabricante_equipamento.n.MODEL.Equipamento;

/**
 *
 * @author vitor
 */
public class EquipamentoDB {
    
    
    public ArrayList<Equipamento> getEquipamentos(){
        ArrayList<Equipamento> equipamentos = new ArrayList<Equipamento>();
        String sql = "select * from equipamento";
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();
        
        try {
            
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while(rs.next()){
                int idEquipamento = rs.getInt("idEquipamento");
                int idFabricante = rs.getInt("idFabricante");
                String nome = rs.getString("nome");
                float preco = rs.getFloat("preco");
                Equipamento equipamento = new Equipamento(idEquipamento, idFabricante, nome, preco);
                equipamentos.add(equipamento);
                
            }


        } catch (SQLException ex) {
            Logger.getLogger(EquipamentoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return equipamentos;
    }
    
    public boolean insert(Equipamento equipamento){
        boolean res = false;
        // INSERT INTO equipamento (nome, idFabricante, preco) VALUES ('"+equipamento.getNome()+"', '"+equipamento.getIdFabricante()+"', '"+equipamento.getPreco()+"')
        String sql = "INSERT INTO equipamento (nome, idFabricante, preco) VALUES ('"+equipamento.getNome()+"', '"+equipamento.getIdFabricante()+"', '"+equipamento.getPreco()+"')";
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();
        
        try {
            conn.createStatement().execute(sql);
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(EquipamentoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    public boolean delete(int idEquipamento){
        boolean res = false;
        // "DELETE FROM equipamento WHERE (idEquipamento = '1')"
        String sql = "DELETE FROM equipamento WHERE (idEquipamento = '"+idEquipamento+"')";
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();
        
        try {
            conn.createStatement().execute(sql);
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(EquipamentoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    public boolean update(Equipamento equipamento){
        boolean res = false;
        // UPDATE equipamento SET nome = '"+equipamento.getNome()+"', preco = '"+equipamento.getPreco()+"' WHERE (IdEquipamento = '"+equipamento.getIdEquipamento()+"')
        String sql = "UPDATE equipamento SET nome = '"+equipamento.getNome()+"', preco = '"+equipamento.getPreco()+"' WHERE (IdEquipamento = '"+equipamento.getIdEquipamento()+"')";
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();
        
        try {
            conn.createStatement().execute(sql);
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(EquipamentoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
}
