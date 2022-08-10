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
public class ProductoDao implements CRUD{
    Connection con;
    Conexion cn= new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public Producto listarID(int id){
        Producto p=new Producto();
        String sql="select*from producto where IdProducto=?";
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while (rs.next()) {                
                p.setId(rs.getInt(1));
                p.setNompro(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return p;
    }
    
    
    

    @Override
    public List listar() {
        List<Producto> lista=new ArrayList<>();
        String sql="select*from producto";
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Producto p=new Producto();
                p.setId(rs.getInt(1));
                p.setNompro(rs.getString(2));
                p.setPrecio(rs.getDouble(3));               
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
                lista.add(p);
            }
            
        } catch (Exception e) {
        }
        
        return lista;
    }

    @Override
    public int add(Object[] o) {
        
        int r=0;
        String sql="insert into producto(IdProducto,Nombres,Precio,Stock,Estado)values(?,?,?,?,?)";
        
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r=ps.executeUpdate();
                     
                      
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r=0;
        String sql="update producto set IdProducto=?,Nombres=?,Precio=?,Stock=?,Estado=? where IdProducto=?";
     
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1,o[0]);
            ps.setObject(2,o[1]);
            ps.setObject(3,o[2]);
            ps.setObject(4,o[3]);
            ps.setObject(5,o[4]);
            r=ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql="delete from producto where IdProducto=?";
        
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }

    public Producto listarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
