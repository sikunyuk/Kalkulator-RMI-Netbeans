/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulatorrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/**
 *
 * @author ASUS
 */
public class CalServer {
    public static void main(String[] args) throws RemoteException {
        //membuat port server agar nantinya dipanggil di sisi client.
        Registry registry = LocateRegistry.createRegistry(1099);
        
        //pertama kita menjalankan server dulu agar sisi client dapat berjalan.
        Operasi op = new Operasi();
        registry.rebind("data", (Remote) op);
        
        
        System.out.println("Server Is runinng");
        
    }
    
}
   