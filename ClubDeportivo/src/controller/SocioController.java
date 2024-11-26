/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Bd.Conexion;
import Controller.HelperController;
import java.util.ArrayList;
import java.util.List;
import models.Socio;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.Action;

/**
 *
 * @author Cetecom
 */
public class SocioController {
    Conexion cx;
    
    HelperController helper = new HelperController();

    public SocioController() {
        cx= new Conexion();
        cx.conectar();
    }
    
    public List<Socio>obtenerSocios(){
        List<Socio> socios = new ArrayList<>();
        String query = "SELECT * FROM SOCIO";
        
        try {
            ResultSet rs = cx.EjecutarQuery(query);
            while(rs.next()){
                socios.add(new Socio(
                       rs.getInt("id"),
                       rs.getString("rut"),
                       rs.getString("nombre"),
                       rs.getString("fecha_nacimiento"),
                       rs.getString("direccion"),
                       rs.getBoolean("membresia_activa")

                ));
                helper.showInformation("Socios cargador");
            }
            
        } catch (Exception e) {
            helper.showError(e.getMessage());
        }
        return socios;
    }
    
    public void agregarSocio(String rut,String nombre, String fechaNacimiento,String direccion, boolean membresiaActiva){
        String query = "INSERT INTO `SOCIO`(rut,nombre,fecha_nacimiento,direccion,memebresia_activa) VALUES(?,?,?,?,?) ";
        try {
            PreparedStatement st = cx.getConnection().prepareStatement(query);
            st.setString(1,rut);
            st.setString(2, nombre);
            st.setString(3, fechaNacimiento);
            st.setString(4,direccion);
            st.setBoolean(5, membresiaActiva);
            st.executeUpdate();
            
            helper.showInformation("Socios agregado");
            
        } catch (Exception e) {
            helper.showError(e.getMessage());
        }
        
    }
    
    public Socio BuscarSocioPorId(int id){
        Socio socioEncontrado=null;
        String query="SELECT * FROM SOCIO WHERE ID = "+ id+";";
        try {
            ResultSet rs = cx.EjecutarQuery(query);
           if(rs.next()){
               socioEncontrado= new Socio();
               //socioEncontrado.setId(rs.getString("nombre")):
           }
            
        } catch (Exception e) {
        }
        return socioEncontrado;
    }
    
    public void editarSocio(int id,String rut, String nombre,String fechaNacimiento,String direccion, boolean membresiaActiva){
        String query ="UPDATE SOCIO SET rut = "+ ""+rut+
                       ",nombre ="+ nombre+
                       ",fecha_nacimiento =" + fechaNacimiento+
                       ",direccion =" + direccion+
                       ",membresia_activa="+ membresiaActiva+
                       ",WHERE id = "+ id + ";";
        try {
            Socio socioEncontrado = BuscarSocioPorId(id);
            if(socioEncontrado != null){
                Statement st=cx.getConnection().createStatement();
                st.executeUpdate(query);
                helper.showInformation("Socio encontrado");
                
            }else{
                helper.showError("Socio no encontrado");
            }
            
        } catch (Exception e) {
            helper.showError(e.getMessage());
        }
                
    }
    
    public void eliminarSocio(int id){
        String query = "DELETE FROM SOCIO WHERE id = " + id + ";";
        try {
            Socio socioEncontrado= BuscarSocioPorId(id);
            if(socioEncontrado != null){
                Statement st = cx.getConnection().createStatement();
                st.executeUpdate(query);
                helper.showInformation("Socio eliminado");
            }else{
                helper.showError("No se pudo eliminar el Socio");
            }
        } catch (Exception e) {
            helper.showError(e.getMessage());
        }
        
        
    }




    
    
    
}
