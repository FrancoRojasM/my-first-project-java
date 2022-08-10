/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Usser
 */
public class Conexion {
    private static Connection con;
    private static final String driver="com.mysql.jdbc.Driver";
    private static  final String url="jdbc:mysql://localhost:3306/bd_ventas";
    private static final String user="root";
    private static final String pass="";
    
    //prueba de conexion
    public Connection Conectar(){
        con=null;
        try {
            
            Class.forName(driver);
            con=DriverManager.getConnection(url,user,pass);
            if(con!=null){
                System.out.println("Conexion establecida");
            }
        } catch (ClassNotFoundException | SQLException e) {
            
            System.out.println("Error al conectar" +e);
            
        }
        return con;
    
    
    }
   
    
}
