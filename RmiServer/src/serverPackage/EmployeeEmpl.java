package serverPackage;


import commonPackage.Employee;
import commonPackage.EmployeeInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleDriver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author azza
 */
public class EmployeeEmpl extends UnicastRemoteObject implements EmployeeInterface{
    Connection con;

    public EmployeeEmpl() throws RemoteException {
        try {

            DriverManager.registerDriver(new OracleDriver());
            con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "azza", "aza");

            Statement stmR = con.createStatement();
            String queryString = new String("select EMPNO,ENAME,JOB from Emp");
            ResultSet rsR = stmR.executeQuery(queryString);
            while (rsR.next()) {
                System.out.println(rsR.getString(1)+" "+rsR.getString(2)+" "+rsR.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(Employee empl) throws RemoteException {
        PreparedStatement  stmI;

        try {
            stmI = con.prepareStatement("insert into Emp(EMPNO,ENAME,JOB) values(?,?,?)");
            stmI.setInt(1, empl.getId());
            stmI.setString(2, empl.getName());
            stmI.setString(3, empl.getAdd().toString());

            stmI.executeUpdate();
            /*rsI.first();
            rsI.moveToInsertRow();
            rsI.updateInt(1, empl.getId());
            rsI.updateString("ENAME", empl.getName());
            rsI.updateString("JOB", empl.getAdd().toString());
            rsI.insertRow();*/
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
