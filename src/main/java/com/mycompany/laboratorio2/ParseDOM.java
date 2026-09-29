/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratorio2;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Alvaro
 */
public class ParseDOM {
    public static void main(String[] args) {
        try{
            // 1. Instanciamos la factoría y el constructor de documentos DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // 2. Parseamos el archivo cargándolo en memoria por completo y lo normalizamos
            Document doc = builder.parse(new File("imperio.xml"));
            doc.getDocumentElement().normalize();
            
            NodeList listaNaves = doc.getElementsByTagName("nave");
            
            for (int i = 0; i < listaNaves.getLength(); i++) {
                Node nodo = listaNaves.item(i);
                
                if(nodo.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) nodo;
                    
                    //Extraigo los atributos
                    String id = element.getAttribute("id");
                    String clase = element.getAttribute("clase");
                    
                    //Extraigo los elementos hijos
                    String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
                    String piloto = element.getElementsByTagName("piloto").item(0).getTextContent();
                    
                    System.out.println("Nombre de la nave: " + nombre + "\n" 
                            + "Id de la nave: " + id + "\n" + "Clase de la nave: " + clase + "\n"
                            + "Nombre del piloto: " + piloto);
                    System.out.println("-------------------------");

                }
                
            }
            
            
            
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }
}
