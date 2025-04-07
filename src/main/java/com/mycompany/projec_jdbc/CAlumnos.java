/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projec_jdbc;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
        setNombreAlumno(paramNombres.getText());
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
    public void MostrarAlumnos(JTable paramTablaTotalAlumnos){
       CConexion objetoCConexion = new CConexion();
       
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel>OrdenarTabla = new TableRowSorter<TableModel>(modelo);
        paramTablaTotalAlumnos.setRowSorter(OrdenarTabla);
        
        String sql = "select * from alumnosdos";
        
        modelo.addColumn("ID");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        
        String[] datos =  new String[3];
        Statement st;
        
        try {
            st = objetoCConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
            
            modelo.addRow(datos);
            
            }
            paramTablaTotalAlumnos.setModel(modelo);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros error:"+ e.toString());
            
        }
    }
    
}
