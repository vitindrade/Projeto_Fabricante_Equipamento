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
import projeto_fabricante_equipamento.n.MODEL.Fabricante;

/**
 *
 * @author vitor
 */
public class FabricanteDB {
    public boolean hasEquipamento(int idFabricante){
        boolean res = false;
        String sql = "select * from equipamento where idFabricante = " + idFabricante;
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();
        
        try {
            
            ResultSet rs = conn.createStatement().executeQuery(sql);
            
            while(rs.next()){
                res = true;
                break;
            }


        } catch (SQLException ex) {
            Logger.getLogger(FabricanteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    public Fabricante getFabricante (int idFabricante){
        Fabricante fabricante = null;
        String sql = "select * from equipamento where idFabricante = " + idFabricante;
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();
        
        try {
            
            ResultSet rs = conn.createStatement().executeQuery(sql);
            
            while(rs.next()){
                String nome = rs.getString("nome");
                String cnpj = rs.getString("cnpj");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                fabricante = new Fabricante(idFabricante, nome, cnpj, cidade, estado);
                
            }


        } catch (SQLException ex) {
            Logger.getLogger(FabricanteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return fabricante;
        
    }
    
    public ArrayList<Fabricante> getFabricantes(){
        ArrayList<Fabricante> fabricantes = new ArrayList<Fabricante>();
        String sql = "select * from fabricante";
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();
        
        try {
            
            ResultSet rs = conn.createStatement().executeQuery(sql);
            
            while(rs.next()){
                int idFabricante = rs.getInt("idFabricante");
                String nome = rs.getString("nome");
                String cnpj = rs.getString("cnpj");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                Fabricante fabricante = new Fabricante(idFabricante, nome, cnpj, cidade, estado);
                fabricantes.add(fabricante);
                
            }


        } catch (SQLException ex) {
            Logger.getLogger(FabricanteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return fabricantes;
    }
    
    public boolean insert(Fabricante fabricante){
        boolean res = false;
        // INSERT INTO fabricante (nome, cnpj, cidade, estado) VALUES ('IFSP', '63467834687638', 'Sertãozinho', 'SP')
        String sql = "INSERT INTO fabricante (nome, cnpj, cidade, estado) VALUES ('"+fabricante.getNome()+"', '"+fabricante.getCnpj()+"', '"+fabricante.getCidade()+"', '"+fabricante.getEstado()+"')";
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();
        
        try {
            conn.createStatement().execute(sql);
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(FabricanteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    public boolean delete(int idFabricante){
        boolean res = false;
        // "DELETE FROM fabricante WHERE (idFabricante = '1')"
        String sql = "DELETE FROM fabricante WHERE (idFabricante = '"+idFabricante+"')";
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();
        try {
            conn.createStatement().execute(sql);
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(FabricanteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public boolean update(Fabricante fabricante){
        boolean res = false;
        // UPDATE fabricante SET nome = '', cnpj = '', cidade = '', estado = '') WHERE (idFabricante = '1')
        String sql = "UPDATE fabricante SET nome = '"+fabricante.getNome()+"', cnpj = '"+fabricante.getCnpj()+"', cidade = '"+fabricante.getCidade()+"', estado = '"+fabricante.getEstado()+"' WHERE (idFabricante = '"+fabricante.getIdFabricante()+"')";
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();
        
        try {
            conn.createStatement().execute(sql);
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(FabricanteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
}
