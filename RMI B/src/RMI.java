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

public interface RMI extends Remote{
    public int sumar(int n1, int n2) throws RemoteException;
    public String buscarTitulo(String valor) throws RemoteException;
    public String buscarAutor(String valor) throws RemoteException;
    public String getTitle(String value) throws RemoteException;
    public String getAuthor(String value) throws RemoteException;
}