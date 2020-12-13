package Main;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Middleware extends Remote{
    public ArrayList pedirLibro(String valor,String biblioteca) throws RemoteException;
    public ArrayList pedirAutor(String valor,String biblioteca) throws RemoteException;
    public ArrayList getTitle(String value,String biblioteca) throws RemoteException;
    public ArrayList getAuthor(String value,String biblioteca) throws RemoteException;
}