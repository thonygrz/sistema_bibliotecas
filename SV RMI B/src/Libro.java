import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;
import java.util.ArrayList;

public class Libro extends Thread{
    private String titulo;
    private String biblioteca;
    public ArrayList<String> libro = new ArrayList();

    public Libro(String titulo, String biblioteca) {
        this.titulo = titulo;
        this.biblioteca = biblioteca;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(String biblioteca) {
        this.biblioteca = biblioteca;
    }


    @Override
    public void run(){
        String biblioteca = this.getBiblioteca();
        if(biblioteca.equals("")){   
            this.setBiblioteca("B");
        }
        try {
            //Thread.sleep(8000);
            File file = new File("src/DB/books.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();  
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            //System.out.println("Root element: " + doc.getDocumentElement().getNodeName()); 
            
            NodeList nodeList = doc.getElementsByTagName("libro");
            
            for (int itr = 0; itr < nodeList.getLength(); itr++){
                Node node = nodeList.item(itr);
                //System.out.println("\nNode Name :" + node.getNodeName());  
                if (node.getNodeType() == Node.ELEMENT_NODE){  
                    Element eElement = (Element) node;
                    if (eElement.getElementsByTagName("titulo").item(0).getTextContent().contains(this.getTitulo())) {
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
            
        }
        catch (Exception e){  
            e.printStackTrace();
        } 
        
    }

    
}