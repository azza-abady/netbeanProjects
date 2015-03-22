/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datsbaseoracle;

import java.sql.*;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author azza
 */
public class DatasBaseOracle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new DatasBaseOracle();
    }
    public DatasBaseOracle(){
        try{
        
            DriverManager.registerDriver(new OracleDriver());
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","azza","aza");
            Statement stmU=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rsU = stmU.executeQuery("select ENAME,EMPNO from Emp");
            rsU.first();
            rsU.updateInt(2, 2345);
            rsU.updateRow();
            Statement stmI=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rsI = stmI.executeQuery("select ENAME,EMPNO from Emp");
            rsI.first();
            rsI.moveToInsertRow();
            rsI.updateString("EMPNO", "66");
            rsI.updateString("ENAME", "AZZA");
//            rsI.insertRow();
            
            Statement stmR=con.createStatement();
            //String queryString = new String("select EMPNO,ENAME from Emp");
            String queryString = new String("select count(*) AS rowcount from Emp");
            ResultSet rsR = stmR.executeQuery(queryString);
            
            rsR.next();

// Get the rowcount column value.
            int ResultCount = rsR.getInt("rowcount") ;

            rsR.close() ;
            System.out.println(ResultCount);
            //System.out.println(rsR.getString(2));
            
            //rsR.last();
            //rsR.deleteRow();
            PreparedStatement pst = con.prepareStatement("select * from Emp where JOB=?");
            pst.setString(1, "CLERK");
            ResultSet rs1=pst.executeQuery();
            while(rs1.next()){
                System.err.println(rs1.getString("ENAME"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
