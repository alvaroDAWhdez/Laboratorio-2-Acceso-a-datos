/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratorio2;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Alvaro
 */
public class ParseSAX {
    public static void main(String[] args) {
        try{
            
            // 1. Instanciamos la factoría
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            
            //2. Definimos el manejador
            DefaultHandler manejador = new DefaultHandler(){
                private boolean esNombre = false;
                
                //Primer evento,se encuentra la etiqueta de apertura
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
                    if(qName.equalsIgnoreCase("nave")){
                        String clase = attributes.getValue("clase");
                        System.out.println("---------");
                        System.out.println("Clase de la nave: " + clase);
                    } else if (qName.equalsIgnoreCase("nombre")){
                        esNombre = true;                        
                    }
                }
                
                //Segundo evento, se captura el texto plano de las etiquetas hijas (nombre de la nave)
                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if(esNombre){
                        System.out.println("Nombre: " + new String(ch,start,length));
                        esNombre = false;
                    }
                }
                
                // Evento: Se encuentra una etiqueta de cierre
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    
                }
                        
                
            };
            
            // Lanzamos el análisis secuencial del archivo
            saxParser.parse(new File("imperio.xml"), manejador);
        } catch (Exception e){
            System.err.println("Error al ejecturar el archivo xml");
        }
    }
}
