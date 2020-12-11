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
    public ArrayList encontrarVol(String valor,String biblioteca) throws RemoteException {
        Libro libro = new Libro(valor,biblioteca);
        try{
            //Crear el hilo
            
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
        return libro.libro;
    }
    
    @Override
    public ArrayList encontrarAutor(String valor, String biblioteca) throws RemoteException {
        Autor autor = new Autor(valor,biblioteca);
        try{
            //Crear el hilo
            //Ejecutamos el hilo en un bloque de synchronized
            synchronized(this){
                autor.start();
                autor.join();
            }
    
            return autor.libros;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return autor.libros;
    }
    
    @Override
    synchronized public ArrayList getTitle(String value, String biblioteca) throws RemoteException {
        ArrayList libro = new ArrayList();
        libro = this.encontrarVol(value,biblioteca);
        return libro; 

    }
    
    @Override
    synchronized public ArrayList getAuthor(String value, String biblioteca) throws RemoteException {
        ArrayList<String> libro = new ArrayList();
        libro = this.encontrarAutor(value,biblioteca);
        return libro;
    }   
    
    public static void main(String[] args) {
        InetAddress ip;
        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            
            java.lang.System.setProperty("java.rmi.server.hostname", "10.0.0.4");
//            java.lang.System.setProperty("java.rmi.server.hostname", "127.0.0.4");
            Registry registro = LocateRegistry.createRegistry(7779);
            registro.rebind("RemoteRMIC", new ServerRMI()); //mantenemos el servidor en escucha
            System.out.println("Servidor Corriendo en: " + ip);
            System.out.println("Servidor Corriendo en: " + hostname);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
