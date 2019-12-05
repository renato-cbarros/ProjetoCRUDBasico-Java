/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionariaWtt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ProfAlexandre
 */
public class ConexaoDB {
    public static ConexaoDB testeBD;
    
    public static ConexaoDB getInstace(){
        if (testeBD == null) {
            testeBD = new ConexaoDB();
        }
        return testeBD;
        
    }
    
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/concessionaria_wtt?serverTimezone=UTC";
            String usuario = "root";
            String senha = "1234567";
            return DriverManager.getConnection(url,usuario,senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public static void main(String[] args) {
        try {
            System.out.print(getInstace().getConnection());
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}