package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class Localidad {

    public static void insertar(Connection cnxn, int nvl, String nmbr, int d)
    {
        try{
            PreparedStatement stmt = cnxn.prepareStatement("INSERT INTO Localidad (nivel, nombre, de) VALUES (?, ?, ?)");
            stmt.setInt(1, nvl);
            stmt.setString(2, nmbr);
            stmt.setInt(3,d);
            
            stmt.execute();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }

    public static void eliminar(Connection cnxn, int id)
    {
        try{
            PreparedStatement stmt = cnxn.prepareStatement("UPDATE Localidad SET borrado = true WHERE idLocalidad = ?");
            stmt.setInt(1, id);
            
            stmt.execute();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }

    public static void restaurar(Connection cnxn, int id)
    {
        try{
            PreparedStatement stmt = cnxn.prepareStatement("UPDATE Localidad SET borrado = false WHERE idLocalidad = ?");
            stmt.setInt(1, id);
            
            stmt.execute();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }

    public static void modificar(Connection cnxn, String nmbr, int id)
    {
        try{
            PreparedStatement stmt = cnxn.prepareStatement("UPDATE Localidad SET nombre = ? WHERE idLocalidad = ?");
            stmt.setString(1, nmbr);
            stmt.setInt(2, id);
            
            stmt.execute();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }

    public static int leerId(Connection cnxn, String lcldd, int d)
    {
        int id=0;
        ResultSet rs;
        
        try{
            PreparedStatement stmt = cnxn.prepareStatement("SELECT idLocalidad FROM Localidad WHERE nombre = ? and de = ? and borrado = false");
            stmt.setString(1, lcldd);
            stmt.setInt(2, d);
            
            rs = stmt.executeQuery();
            if(rs.next())
                id = rs.getInt("idLocalidad");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
        return id;
    }
    
    public static int leerIdBorrado(Connection cnxn, String lcldd, int d)
    {
        int id=0;
        ResultSet rs;
        
        try{
            PreparedStatement stmt = cnxn.prepareStatement("SELECT idLocalidad FROM Localidad WHERE nombre = ? and de = ?");
            stmt.setString(1, lcldd);
            stmt.setInt(2, d);
            
            rs = stmt.executeQuery();
            if(rs.next())
                id = rs.getInt("idLocalidad");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
        return id;
    }    
    public static boolean borrado(Connection cnxn, int id)
    {
        ResultSet rs;
        boolean borrado = false;
        
        try{
            PreparedStatement stmt = cnxn.prepareStatement("SELECT borrado FROM Localidad WHERE idLocalidad = ?");
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            if(rs.next())
                borrado = rs.getBoolean("borrado");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
        return borrado;
    }
    
    public static ResultSet leerLugares(Connection cnxn, int nvl)
    {
        ResultSet rs = null;

        try{
            PreparedStatement stmt = cnxn.prepareStatement("SELECT nombre FROM Localidad WHERE nivel = ? and borrado = false ORDER BY nombre");
            stmt.setInt(1, nvl);
            
            rs = stmt.executeQuery();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
        return rs;
    }
    
    public static ResultSet leerLugares(Connection cnxn, int nvl, int d)
    {
        ResultSet rs = null;

        try{
            PreparedStatement stmt = cnxn.prepareStatement("SELECT nombre FROM Localidad WHERE nivel = ? and de = ? and borrado = false ORDER BY nombre");
            stmt.setInt(1, nvl);
            stmt.setInt(2, d);
            
            rs = stmt.executeQuery();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
        return rs;
    }    
}
