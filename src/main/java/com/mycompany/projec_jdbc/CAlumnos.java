/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projec_jdbc;

import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Personal
 */
public class CAlumnos {
    int codigo;
    String nombreAlumno;
    String  apellidoAlumno;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }

    public void setApellidoAlumno(String apellidoAlumno) {
        this.apellidoAlumno = apellidoAlumno;
    }
    public void InsertarAlumno(JTextField paramNombres, JTextField paramApellidos){
        setNombreAlumno(paramNombres.getSelectedText());
        setApellidoAlumno(paramApellidos.getText());
        
        CConexion objetoCConexion = new CConexion();
       String consulta = "insert into alumnosdos(nombres, apellidos)values (?,?);";
       
        try {
            CallableStatement cs = objetoCConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getNombreAlumno());
            cs.setString(2, getApellidoAlumno());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se inseto correctamente el alumno");
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, "No se inserto correctamente el alumno, error:"+ e.toString()); 
        }
        
    }
    
}
