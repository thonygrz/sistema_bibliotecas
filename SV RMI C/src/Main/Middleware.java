package Main;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

//Interfaz que define los metodos en Z39 y el del lenguaje de la biblioteca.
public interface Middleware extends Remote{
    public ArrayList encontrarVol(String valor, String biblioteca) throws RemoteException;
    public ArrayList encontrarAutor(String valor, String biblioteca) throws RemoteException;
    public ArrayList getTitle(String value, String biblioteca) throws RemoteException;
    public ArrayList getAuthor(String value, String biblioteca) throws RemoteException;
}