package com.gjaras.pojos;
// Generated Oct 3, 2018 5:29:38 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Unidad generated by hbm2java
 */
public class Unidad  implements java.io.Serializable {


     private BigDecimal idUnidad;
     private Funcionario funcionario;
     private Unidad unidad;
     private String nombreUnidad;
     private String descripcionUnidad;
     private String direccionUnidad;
     private boolean habilitado;
     private Set funcionarios = new HashSet(0);
     private Set unidads = new HashSet(0);

    public Unidad() {
    }

	
    public Unidad(BigDecimal idUnidad, String nombreUnidad, String descripcionUnidad, String direccionUnidad, boolean habilitado) {
        this.idUnidad = idUnidad;
        this.nombreUnidad = nombreUnidad;
        this.descripcionUnidad = descripcionUnidad;
        this.direccionUnidad = direccionUnidad;
        this.habilitado = habilitado;
    }
    public Unidad(BigDecimal idUnidad, Funcionario funcionario, Unidad unidad, String nombreUnidad, String descripcionUnidad, String direccionUnidad, boolean habilitado, Set funcionarios, Set unidads) {
       this.idUnidad = idUnidad;
       this.funcionario = funcionario;
       this.unidad = unidad;
       this.nombreUnidad = nombreUnidad;
       this.descripcionUnidad = descripcionUnidad;
       this.direccionUnidad = direccionUnidad;
       this.habilitado = habilitado;
       this.funcionarios = funcionarios;
       this.unidads = unidads;
    }
   
    public BigDecimal getIdUnidad() {
        return this.idUnidad;
    }
    
    public void setIdUnidad(BigDecimal idUnidad) {
        this.idUnidad = idUnidad;
    }
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public Unidad getUnidad() {
        return this.unidad;
    }
    
    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
    public String getNombreUnidad() {
        return this.nombreUnidad;
    }
    
    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }
    public String getDescripcionUnidad() {
        return this.descripcionUnidad;
    }
    
    public void setDescripcionUnidad(String descripcionUnidad) {
        this.descripcionUnidad = descripcionUnidad;
    }
    public String getDireccionUnidad() {
        return this.direccionUnidad;
    }
    
    public void setDireccionUnidad(String direccionUnidad) {
        this.direccionUnidad = direccionUnidad;
    }
    public boolean isHabilitado() {
        return this.habilitado;
    }
    
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    public Set getFuncionarios() {
        return this.funcionarios;
    }
    
    public void setFuncionarios(Set funcionarios) {
        this.funcionarios = funcionarios;
    }
    public Set getUnidads() {
        return this.unidads;
    }
    
    public void setUnidads(Set unidads) {
        this.unidads = unidads;
    }




}


