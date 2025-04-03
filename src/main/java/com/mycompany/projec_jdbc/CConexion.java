/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projec_jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Personal
 */
public class CConexion {
    Connection conectar = null;
    
    String usuario = "root";
    String Contrasenia = "1234";
    String db = "dbescuelados";
    String ip = "localhost";
    String puerto = "3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+db;
    
    public Connection establecerConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario,Contrasenia);
            
            JOptionPane.showMessageDialog(null, "La conexión se realizo con exito");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la base de datos" + e.toString());
        }
    return conectar;
}
    
}


