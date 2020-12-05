import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;
import java.util.ArrayList;

public class Autor extends Thread{
    private String autor;
    private String biblioteca;
    public ArrayList<ArrayList<String>> libros = new ArrayList();

    public Autor(String autor, String biblioteca) {
        this.autor = autor;
        this.biblioteca = biblioteca;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(String biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public void run(){
        try {
            File file = new File("src/DB/books.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();  
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName()); 
            
            NodeList nodeList = doc.getElementsByTagName("libro");
            
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
            
        }
        catch (Exception e){  
            e.printStackTrace();
        }
    }

}