package Main;
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

//Contiene la logica de los metodos remotos que se van a llamar desde el cliente
public class ServerRMI extends UnicastRemoteObject implements Middleware {
    public ServerRMI() throws RemoteException {
        super();
    }
    
    //metodo con lenguaje de la biblioteca para encontrar el libro por volumen
    @Override
    public ArrayList buscarTitulo(String valor,String biblioteca) throws RemoteException {
        Libro libro = new Libro(valor,biblioteca);
        try{
            //Crear el hilo
            //Ejecutamos el hilo en un bloque de synchronized para que el monitor maneje la cola de procesos
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
    
    //metodo con lenguaje de la biblioteca para encontrar el autor por volumen
    @Override
    public ArrayList buscarAutor(String valor, String biblioteca) throws RemoteException {
        Autor autor = new Autor(valor,biblioteca);
        try{
            //Crear el hilo
            //Ejecutamos el hilo en un bloque de synchronized para que el monitor maneje la cola de procesos
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
    
    //Lenguaje Z39 transforma la llegada del metodo por RMI a lenguaje de la biblioteca 
    //llamando al metodo del lenguaje habitual para conseguir el libro por titulo
    @Override
    synchronized public ArrayList getTitle(String value, String biblioteca) throws RemoteException {
        ArrayList libro = new ArrayList();
        libro = this.buscarTitulo(value,biblioteca);
        return libro; 

    }
    
    //Lenguaje Z39 transforma la llegada del metodo por RMI a lenguaje de la biblioteca 
    //llamando al metodo del lenguaje habitual para conseguir el libro por autor
    @Override
    synchronized public ArrayList getAuthor(String value, String biblioteca) throws RemoteException {
        ArrayList<String> libro = new ArrayList();
        libro = this.buscarAutor(value,biblioteca);
        return libro;
    }   
    
    //Configuracion del RMI
    public static void main(String[] args) {
        InetAddress ip;
        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            
            //Obligamos al RMI a usar una IP especifica
            java.lang.System.setProperty("java.rmi.server.hostname", "10.2.126.84");
            //Seleccionamos el puerto TCP para escuchar
            Registry registro = LocateRegistry.createRegistry(7779);
            registro.rebind("RemoteRMIB", new ServerRMI());
            //mantenemos el servidor en escucha
            System.out.println("Servidor Corriendo en: " + ip);
            System.out.println("Servidor Corriendo en: " + hostname);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}