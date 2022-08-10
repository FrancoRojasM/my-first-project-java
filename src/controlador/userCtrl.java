/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.UserDao;

/**
 *
 * @author Usser
 */
public class userCtrl {
  
    public boolean validar(String nombre, String clave){
            
            UserDao usuarioDao= new UserDao();
            return usuarioDao.validar(nombre,clave);
    
    }
}
