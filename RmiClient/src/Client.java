
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import commonPackage.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author azza
 */
public class Client {
    public static void main(String[] args) {
        new Client();
    }

    public Client() {
        try {
            Registry reg = LocateRegistry.getRegistry(5005);
            EmployeeInterface addEmp = (EmployeeInterface) reg.lookup("inser Employee");
            Employee emp = new Employee();
            emp.setName("RMI");
            emp.setId(1000);
            Address add = new Address();
            add.setHomeId(2);
            add.setStreet("smar");
            emp.setAdd(add);
            addEmp.add(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
