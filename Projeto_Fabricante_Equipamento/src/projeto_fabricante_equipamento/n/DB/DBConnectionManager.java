/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_fabricante_equipamento.n.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitor
 */
public class DBConnectionManager {
    private static Connection connection = null;
    
    public static Connection getConnection(){
        try {
            if(connection == null){
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    String url = "jdbc:mysql://localhost:3306/FabricanteEquipamento";
                    connection = DriverManager.getConnection(url, "root","root");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DBConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(DBConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(DBConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(DBConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else if(connection.isClosed()){
                connection = null;
                return getConnection();
            } else if(connection != null){
                return connection;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }
        
    public static void closeConnection(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}


