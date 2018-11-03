package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class TipoDocumento {

    public static void insertar(Connection cnxn, String tp)
    {
        try{
            PreparedStatement stmt = cnxn.prepareStatement("INSERT INTO tipoDocumento (tipo) VALUES (?)");
            stmt.setString(1, tp);
            
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
            PreparedStatement stmt = cnxn.prepareStatement("UPDATE tipoDocumento SET borrado = true WHERE idTipoDocumento = ?");
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
            PreparedStatement stmt = cnxn.prepareStatement("UPDATE tipoDocumento SET borrado = false WHERE idTipoDocumento = ?");
            stmt.setInt(1, id);
            
            stmt.execute();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }

    public static void modificar(Connection cnxn, String tp, int id)
    {
        try{
            PreparedStatement stmt = cnxn.prepareStatement("UPDATE tipoDocumento SET tipo = ? WHERE idTipoDocumento = ?");
            stmt.setString(1, tp);
            stmt.setInt(2, id);
            
            stmt.execute();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }

    public static int leerId(Connection cnxn, String tp)
    {
        int id=0;
        ResultSet rs;
        
        try{
            PreparedStatement stmt = cnxn.prepareStatement("SELECT idTipoDocumento FROM tipoDocumento WHERE tipo = ? and borrado = false");
            stmt.setString(1, tp);
            
            rs = stmt.executeQuery();
            if(rs.next())
                id = rs.getInt("idTipoDocumento");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
        return id;
    }
    
    public static int leerIdBorrado(Connection cnxn, String tp)
    {
        int id=0;
        ResultSet rs;
        
        try{
            PreparedStatement stmt = cnxn.prepareStatement("SELECT idTipoDocumento FROM tipoDocumento WHERE tipo = ?");
            stmt.setString(1, tp);
            
            rs = stmt.executeQuery();
            if(rs.next())
                id = rs.getInt("idTipoDocumento");
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
            PreparedStatement stmt = cnxn.prepareStatement("SELECT borrado FROM tipoDocumento WHERE idTipoDocumento = ?");
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
    
    public static ResultSet leerTipos(Connection cnxn)
    {
        ResultSet rs = null;

        try{
            PreparedStatement stmt = cnxn.prepareStatement("SELECT tipo FROM tipoDocumento WHERE borrado = 0 ORDER BY tipo");
            
            rs = stmt.executeQuery();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
        return rs;
    }
     
}
