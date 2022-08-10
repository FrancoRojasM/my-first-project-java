/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usser
 */
public class ClienteDao implements CRUD{
    Connection con;
    Conexion cn=new Conexion() {};
    PreparedStatement ps;
    ResultSet rs;
    Cliente co=new Cliente();

    
    //metodo buscar cliente
   public Cliente listarID(String dni){
       
       Cliente c=new Cliente();
       
       String sql="select*from cliente where Dni=?";
       try {
           con=cn.Conectar();
           ps=con.prepareStatement(sql);
           ps.setString(1,dni);
           rs=ps.executeQuery();//ejecutra la consulta
           
           while (rs.next()) {               
               c.setId(rs.getInt(1));
               c.setDni(rs.getString(2));
               c.setNom(rs.getString(3));
               c.setDir(rs.getString(4));
               c.setEstado(rs.getString(5));
                              
           }
           
       } catch (Exception e) {
       }
   
       return c;
   }
    
    
    //metodo para listar
    @Override
    public List listar() {
        List<Cliente> lista =new ArrayList<>();
        String sql="select*from cliente";
        try {
            //conexion
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();//ejecutar la consulta               
            
            while (rs.next()) {     
                //instanciar obj cliente
                Cliente c=new Cliente();
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDir(rs.getString(4));
                c.setEstado(rs.getString(5));
                lista.add(c);//listar el objeto cliente
                
            }
            
        } catch (Exception e) {
        }
        return lista;
    }

    /**********metodo agregar*************/
    @Override
    public int add(Object[] o) {
        int r=0;
        String sql="insert into cliente(Dni,Nombres,Direccion,Estado)values(?,?,?,?)";
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);//posicion, en elobjeto dnetor del array
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            r=ps.executeUpdate();//ejecutar laos cambios
            
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r=0;
        String sql="update cliente set Dni=?,Nombres=?,Direccion=?,Estado=? where IdCliente=?";
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r=ps.executeUpdate();//ejecutar la actualizacion
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public void eliminar(int id) {

        String sql="delete from cliente where IdCliente=?";
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();//ejcutar los cambios
        } catch (Exception e) {
            
        }
        
    }
    
}
