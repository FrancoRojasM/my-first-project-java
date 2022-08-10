/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Usser
 */
public class UserDao {
    
    public boolean validar(String nombre, String clave) {
        
        String userBD= "Empleado01";
        String passwordBD= "admin123";
        boolean val=false;
        
        if ((nombre.equals(userBD))&& (clave.equals(passwordBD))) {
            
            val=true;
            
        }
        return val;
        
    }
    
}
