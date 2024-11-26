/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Cetecom
 */
public class Socio {
    private int id;
    private String rut;
    private String nombre;
    private String fechaNacimiento;
    private String direccion;
    private Boolean membresiaActiva;
 
    public Socio() {
    }

    public Socio(int id, String rut, String nombre, String fechaNacimiento, String direccion, Boolean membresiaActiva) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.membresiaActiva = membresiaActiva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getMembresiaActiva() {
        return membresiaActiva;
    }

    public void setMembresiaActiva(Boolean membresiaActiva) {
        this.membresiaActiva = membresiaActiva;
    }

    @Override
    public String toString() {
        return "Socio{" + "id=" + id + ", rut=" + rut + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + ", membresiaActiva=" + membresiaActiva + '}';
    }
    
    
    
    
}
