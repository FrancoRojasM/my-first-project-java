/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author Usser
 */
public interface CRUD {
    public List listar();
    public int add(Object[] o);//arreglo
    public int actualizar(Object[] o);
    public void eliminar(int id);
}
