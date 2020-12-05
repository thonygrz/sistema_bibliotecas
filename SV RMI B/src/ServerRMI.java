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
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ServerRMI extends UnicastRemoteObject implements Middleware {
    public ServerRMI() throws RemoteException {
        super();
    }
    
    @Override
    public ArrayList buscarTitulo(String valor,String biblioteca) throws RemoteException {
        try{
            
            //Crear el hilo
            Libro libro = new Libro(valor,biblioteca);
            //Ejecutamos el hilo en un bloque de synchronized
            synchronized(this){
                libro.start();
                libro.join();
            }
    
            return libro.libro;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    @Override
    synchronized public ArrayList buscarAutor(String valor, String biblioteca) throws RemoteException {
        ArrayList<ArrayList<String>> libros = new ArrayList();
        
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
                    if (eElement.getElementsByTagName("autor").item(0).getTextContent().contains(valor)) {
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
        return libros;
    }
    
    @Override
    synchronized public ArrayList getTitle(String value, String biblioteca) throws RemoteException {
        ArrayList libro = new ArrayList();
        libro = this.buscarTitulo(value,biblioteca);
        return libro; 

    }
    
    @Override
    synchronized public ArrayList getAuthor(String value, String biblioteca) throws RemoteException {
        ArrayList<String> libro = new ArrayList();
        libro = this.buscarAutor(value,biblioteca);
        return libro;
    }   
    
    public static void main(String[] args) {
        InetAddress ip;
        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            
            java.lang.System.setProperty("java.rmi.server.hostname", "10.0.0.4");
            Registry registro = LocateRegistry.createRegistry(7778);
            registro.rebind("RemoteRMIB", new ServerRMI()); //mantenemos el servidor en escucha
            System.out.println("Servidor Corriendo en: " + ip);
            System.out.println("Servidor Corriendo en: " + hostname);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
