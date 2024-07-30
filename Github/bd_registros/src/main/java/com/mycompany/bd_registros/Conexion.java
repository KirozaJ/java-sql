package com.mycompany.bd_registros;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    
    private Conexion(){
        
    }
    
    private static Connection conexion;
    
    private static Conexion instancia;
    
    private static final String URL = "jdbc:mysql://localhost:3306/registroestudiantes";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    public Connection conectar(){
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            
            return conexion;
            
        }catch (Exception e){
         JOptionPane.showMessageDialog(null, "Error: " +e);       
      }
        return conexion;
    }
    
    public void cerrarConexion() throws SQLException {
        try{
            
            conexion.close();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: " +e);
            conexion.close();
        }finally{
            conexion.close();
        }
    }
    
    public static Conexion getInstance(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    } 
}


