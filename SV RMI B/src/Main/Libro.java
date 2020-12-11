package Main;

import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

//Clase que contiene la zona excluida para buscar el libro y que se llama en la clase ServerRMI.java
public class Libro extends Thread{
    private String titulo;
    private String biblioteca;
    public ArrayList<String> libro = new ArrayList();

    //Constructor de la clase
    public Libro(String titulo, String biblioteca) {
        this.titulo = titulo;
        this.biblioteca = biblioteca;
    }

    //Getter del titulo
    public String getTitulo() {
        return titulo;
    }

    //Setter del titulo
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    //Getter de la biblioteca
    public String getBiblioteca() {
        return biblioteca;
    }

    //Setter de la biblioteca
    public void setBiblioteca(String biblioteca) {
        this.biblioteca = biblioteca;
    }

    //Metodo run engloba la zona excluida
    //Lectura de archivo XML (Base de Datos)
    @Override
    public void run(){
        String biblioteca = this.getBiblioteca();
        TrazaMovimientos tm;

        //Si es vacio se setea el valor de la biblioteca a la que pertenece
        if(biblioteca.equals("")){   
            this.setBiblioteca("B");
        }
        try {
            //Se busca el archivo
            //Se crea la clase para lectura
            File file = new File("src/DB/books.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();  
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            
            NodeList nodeList = doc.getElementsByTagName("libro");
            //Bucle para correr el archivo XML y devolver los libros por titlulo
            for (int itr = 0; itr < nodeList.getLength(); itr++){
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE){  
                    Element eElement = (Element) node;
                    if (eElement.getElementsByTagName("titulo").item(0).getTextContent().contentEquals(this.getTitulo())) {
                        System.out.println("Libro solicitado por cliente de la biblioteca "+this.getBiblioteca()+" : \n");
                        libro.add(eElement.getElementsByTagName("titulo").item(0).getTextContent());
                        libro.add(eElement.getElementsByTagName("autor").item(0).getTextContent());
                        libro.add(eElement.getElementsByTagName("editorial").item(0).getTextContent());
                        libro.add(eElement.getElementsByTagName("fecha").item(0).getTextContent());
                        System.out.println("Titulo: "+ eElement.getElementsByTagName("titulo").item(0).getTextContent());  
                        System.out.println("Autor: "+ eElement.getElementsByTagName("autor").item(0).getTextContent());  
                        System.out.println("Editorial: "+ eElement.getElementsByTagName("editorial").item(0).getTextContent());  
                        System.out.println("Fecha: "+ eElement.getElementsByTagName("fecha").item(0).getTextContent()+"\n");
                    }
                }
            }
            
            //Creamos la traza de movimientos
            if (this.getBiblioteca().contentEquals("B")) {
                tm = new TrazaMovimientos(this.getBiblioteca(), "buscarTitulo", this.getTitulo(), new Date());
            } else {
                tm = new TrazaMovimientos(this.getBiblioteca(), "getTitle", this.getTitulo(), new Date());
            }
            
            tm.guardarTraza();
            
        }
        catch (Exception e){  
            e.printStackTrace();
        } 
        
    }

    
}