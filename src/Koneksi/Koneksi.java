/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author LordAxl
 */
public class Koneksi {
    private Connection conn;
    private Statement stm;
    ResultSet rs;
    public Koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection
                    ("jdbc:mysql://localhost/tugasbesar","root","");
            stm = conn.createStatement();
        }catch(SQLException ex) {
            System.err.print(ex);
        }catch(ClassNotFoundException ex) {
            System.err.print(ex);
        }
    }
    
public ResultSet getData(String SQLString)
{
    try
    {
        rs = stm.executeQuery(SQLString);
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, "Error : "+e.getMessage(),"Communication Error Pada Method GetData",JOptionPane.WARNING_MESSAGE);
        
    }
    return rs;
}
public void query(String SQLString)
{
    try {
        stm.execute(SQLString);
    }
    catch (Exception e)
    {
        JOptionPane.showMessageDialog(null,"Error "+e.getMessage()," Communication Error Pada Method Query",JOptionPane.WARNING_MESSAGE);
    }
}
}
