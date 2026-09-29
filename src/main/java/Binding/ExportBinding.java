/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Binding;

/**
 *
 * @author Alvaro
 */

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import java.io.File;

public class ExportBinding {
    public static void main(String[] args) {
        //Iniciamos el marhshalling
        File fichero = new File("rebelde.xml");
        Personaje luke = new Personaje("Luke Skywalker","Caballero jedi");
        
        try{
            // Instanciamos el contexto pasándole la clase objetivo
            JAXBContext contexto = JAXBContext.newInstance(Personaje.class);
            Marshaller marshaller = contexto.createMarshaller();
            
            // Configuración para que el XML de salida tenga tabulaciones y saltos de línea legibles
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            // Volcamos el objeto directamente al archivo físico
            marshaller.marshal(luke, fichero);
            System.out.println("Elemento xml creado con los datos de Luke");
            
            //Mostrar el contenido generado
            System.out.println("--- Contenido generado ---");
            marshaller.marshal(luke, System.out);
            
        } catch (Exception e){
            System.err.println("Error durante el Marshalling: " + e.getMessage());
        }
    }
}
