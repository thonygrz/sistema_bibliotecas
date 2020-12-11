package Main;
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;
import java.util.Date;
import java.util.ArrayList;

//Clase que contiene la zona excluida para buscar el autor y que se llama en la clase ServerRMI.java
public class Autor extends Thread{
    private String autor;
    private String biblioteca;
    public ArrayList<ArrayList<String>> libros = new ArrayList();

    // Constructor de la Clase
    public Autor(String autor, String biblioteca) {
        this.autor = autor;
        this.biblioteca = biblioteca;
    }

    //Getter del autor
    public String getAutor() {
        return autor;
    }

    //Setter del autor
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    //Getter de Bliblioteca
    public String getBiblioteca() {
        return biblioteca;
    }

    //Setter de Biblioteca
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
            this.setBiblioteca("A");
        }
        try {
            //Se busca el archivo
            //Se crea la clase para lectura
            File file = new File("src/DB/books.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();  
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName()); 
            
            NodeList nodeList = doc.getElementsByTagName("libro");
            
            //Bucle para correr el archivo XML y devolver los libros por autor
            for (int itr = 0; itr < nodeList.getLength(); itr++){
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE){  
                    Element eElement = (Element) node;
                    if (eElement.getElementsByTagName("autor").item(0).getTextContent().contains(this.getAutor())) {
                        ArrayList<String> libro = new ArrayList();
                        libro.add(eElement.getElementsByTagName("titulo").item(0).getTextContent());
                        libro.add(eElement.getElementsByTagName("autor").item(0).getTextContent());
                        libro.add(eElement.getElementsByTagName("editorial").item(0).getTextContent());
                        libro.add(eElement.getElementsByTagName("fecha").item(0).getTextContent());
                        libros.add(libro);

                    }
                }
            }
            System.out.println(libros);
            
            //Creamos la traza de movimientos
            if (this.getBiblioteca().contentEquals("A")) {
                tm = new TrazaMovimientos(this.getBiblioteca(), "pedirAutor", this.getAutor(), new Date());
            } else {
                tm = new TrazaMovimientos(this.getBiblioteca(), "getAuthor", this.getAutor(), new Date());
            }
            
            tm.guardarTraza();
            
        }
        catch (Exception e){  
            e.printStackTrace();
        }
    }

}