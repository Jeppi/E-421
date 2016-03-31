/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
/**
 *
 * @author lp
 */
public class DAOConnexion implements IDAOConstantes {
    Connection dbcon;

    public DAOConnexion() {
        this.dbcon = getConnexion();
    }
    
    public Connection getConnexion() {
        try {
            Class.forName(driver);
            dbcon = DriverManager.getConnection(dbUrl,user,password);
        }
        catch(ClassNotFoundException | SQLException e){}
        return dbcon;
    }
    
    public void closeConnnexion() throws SQLException {
        if(dbcon!=null) dbcon.close();
    }
        
}
   
