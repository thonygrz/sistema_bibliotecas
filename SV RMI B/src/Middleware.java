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

public interface Middleware extends Remote{
    public String[] buscarTitulo(String valor) throws RemoteException;
    public String[] buscarAutor(String valor) throws RemoteException;
    public String[] getTitle(String value) throws RemoteException;
    public String[] getAuthor(String value) throws RemoteException;
}