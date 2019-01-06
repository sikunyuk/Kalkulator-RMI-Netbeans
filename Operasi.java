/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulatorrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author ASUS
 */
public class Operasi extends UnicastRemoteObject implements Fungsi{
    int hasil;
    
    public Operasi ()throws RemoteException{
    
    }

    @Override
    public int tambah(int a, int b) throws RemoteException {
        hasil = a+b;
        return hasil;
    }

    @Override
    public int kurang(int a, int b) throws RemoteException {
       hasil = a-b;
        return hasil;
    }

    @Override
    public int bagi(int a, int b) throws RemoteException {
        hasil = a/b;
        return hasil;
        
    }

    @Override
    public int kali(int a, int b) throws RemoteException {
        hasil = a*b;
        return hasil;
    }
    
}

