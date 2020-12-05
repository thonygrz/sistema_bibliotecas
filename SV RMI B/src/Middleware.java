/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexis
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Middleware extends Remote{
    public ArrayList buscarTitulo(String valor, String biblioteca) throws RemoteException;
    public ArrayList buscarAutor(String valor, String biblioteca) throws RemoteException;
    public ArrayList getTitle(String value, String biblioteca) throws RemoteException;
    public ArrayList getAuthor(String value, String biblioteca) throws RemoteException;
}