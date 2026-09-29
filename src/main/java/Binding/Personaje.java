/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Binding;

/**
 *
 * @author Alvaro
 */

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.io.Serializable;

//1. Definir el elemento raiz de xml
@XmlRootElement(name="personaje")
//2. Definir el orden de elementos hijos
@XmlType(propOrder = {"nombre","rango"})
public class Personaje implements Serializable{
    
    private String nombre; //Etiqueta hija
    private String rango; //Etiqueta hija
    
    //Constructor vacio obligatorio para el estándar JavaBean y JAXB
    public Personaje(){
        
    }

    public Personaje(String nombre, String rango) {
        this.nombre = nombre;
        this.rango = rango;
    }

    // Anotamos los getters para transformarlos en elementos/etiquetas XML
    @XmlElement(name="nombre")
    public String getNombre() {
        return nombre;
    }

    @XmlElement(name="rango")
    public String getRango() {
        return rango;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }
    
    @Override
    public String toString(){
        return "Nombre: " + this.nombre + ", rango:" + this.rango;
    }
    
    
    
    
    
    
}
