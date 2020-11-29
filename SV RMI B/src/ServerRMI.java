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
        return "Metodo buscar titulo B";
    }
    
    @Override
    public String buscarAutor(String valor) throws RemoteException {
        return "Metodo buscar autor B";
    }
    
    @Override
    public String getTitle(String value) throws RemoteException {
        return "Metodo getTitle Z39 Biblioteca B";
    }
    
    @Override
    public String getAuthor(String value) throws RemoteException {
        return "Metodo getAuthor Z39 Biblioteca B";
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
