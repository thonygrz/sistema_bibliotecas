package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexis
 */

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ServerRMI extends UnicastRemoteObject implements Middleware {
    
    public ServerRMI() throws RemoteException {
        super();
    }
    
    @Override
    public String[] pedirLibro(String valor) throws RemoteException {
        String[] libro = new String[4];
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
                System.out.println("\nNode Name :" + node.getNodeName());  
                if (node.getNodeType() == Node.ELEMENT_NODE){  
                    Element eElement = (Element) node;
                    if (eElement.getElementsByTagName("titulo").item(0).getTextContent().matches(valor)) {
                        libro[0] = eElement.getElementsByTagName("titulo").item(0).getTextContent();
                        libro[1] = eElement.getElementsByTagName("autor").item(0).getTextContent();
                        libro[2] = eElement.getElementsByTagName("editorial").item(0).getTextContent();
                        libro[3] = eElement.getElementsByTagName("fecha").item(0).getTextContent();
                        System.out.println("Titulo: "+ eElement.getElementsByTagName("titulo").item(0).getTextContent());  
                        System.out.println("Autor: "+ eElement.getElementsByTagName("autor").item(0).getTextContent());  
                        System.out.println("Editorial: "+ eElement.getElementsByTagName("editorial").item(0).getTextContent());  
                        System.out.println("Fecha: "+ eElement.getElementsByTagName("fecha").item(0).getTextContent()); 
                    }
                }
            }
        }
        catch (Exception e){  
            e.printStackTrace();
        }
        
        return libro;
    }
    
    @Override
    public String[] pedirAutor(String valor) throws RemoteException {
        String[] libro = new String[1];
        return libro;
    }
    
    @Override
    public String[] getTitle(String value) throws RemoteException {
        String[] libro;
        libro = this.pedirLibro(value);
        return libro;
    }
    
    @Override
    public String[] getAuthor(String value) throws RemoteException {
        return this.pedirAutor(value);
    } 
    
    public static void main(String[] args) {
        InetAddress ip;
        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            
            Registry registro = LocateRegistry.createRegistry(7777);
            registro.rebind("RemoteRMI", new ServerRMI()); //mantenemos el servidor en escucha
            System.out.println("Servidor Corriendo en: " + ip);
            System.out.println("Servidor Corriendo en: " + hostname);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }  catch (UnknownHostException e) {
 
            e.printStackTrace();
        }
    }
}
