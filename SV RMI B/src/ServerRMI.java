/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexis
 */

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;

public class ServerRMI extends UnicastRemoteObject implements RMI {
    
    public ServerRMI() throws RemoteException {
        super();
    }
    
    @Override
    public int sumar(int n1, int n2) throws RemoteException {
        return n1 + n2;
    }
    
    @Override
    public String buscarTitulo(String valor) throws RemoteException {
        this.buscarLibroPorTitulo();
        return "Metodo buscar titulo B";
    }
    
    @Override
    public String buscarAutor(String valor) throws RemoteException {
        return "Metodo buscar autor B";
    }
    
    @Override
    public String getTitle(String value) throws RemoteException {
        return this.buscarTitulo(value);
    }
    
    @Override
    public String getAuthor(String value) throws RemoteException {
        return this.buscarAutor(value);
    }
    
    private void buscarLibroPorTitulo() {
        try {  
            File file = new File("C:\\Users\\Alexis\\Documents\\NetBeansProjects\\sistema_bibliotecas\\DataBase\\books.xml");  
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
                    System.out.println("Titulo: "+ eElement.getElementsByTagName("titulo").item(0).getTextContent());  
                    System.out.println("Autor: "+ eElement.getElementsByTagName("autor").item(0).getTextContent());  
                    System.out.println("Editorial: "+ eElement.getElementsByTagName("editorial").item(0).getTextContent());  
                    System.out.println("Fecha: "+ eElement.getElementsByTagName("fecha").item(0).getTextContent()); 
                }  
            }  
        }   
        catch (Exception e){  
            e.printStackTrace();
        }  
    }
    
    private void buscoarLibrosPorAutor() {
    }
    
    private static void printNodeList(NodeList nodeList)  {  
        for (int count = 0; count < nodeList.getLength(); count++){  
            Node elemNode = nodeList.item(count);  
            if (elemNode.getNodeType() == Node.ELEMENT_NODE){  
                // get node name and value  
                System.out.println("\nNode Name =" + elemNode.getNodeName()+ " [OPEN]");  
                System.out.println("Node Content =" + elemNode.getTextContent());  
                if (elemNode.hasChildNodes()){  
                    //recursive call if the node has child nodes  
                    printNodeList(elemNode.getChildNodes());  
                }  
                    System.out.println("Node Name =" + elemNode.getNodeName()+ " [CLOSE]");  
            }  
        }  
    }  
    
    public static void main(String[] args) {
        InetAddress ip;
        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            
            Registry registro = LocateRegistry.createRegistry(7778);
            registro.rebind("RemoteRMIB", new ServerRMI()); //mantenemos el servidor en escucha
            System.out.println("Servidor Corriendo en: " + ip);
            System.out.println("Servidor Corriendo en: " + hostname);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }  catch (UnknownHostException e) {
 
            e.printStackTrace();
        }
    }
}
