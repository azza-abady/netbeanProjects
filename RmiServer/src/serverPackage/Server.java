package serverPackage;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author azza
 */
public class Server {
    public Server() {
        try {
            EmployeeEmpl obj = new EmployeeEmpl();
            Registry reg = LocateRegistry.createRegistry(5005);
            reg.rebind("inser Employee", obj);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
