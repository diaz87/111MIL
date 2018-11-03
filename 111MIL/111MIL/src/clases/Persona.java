package clases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class Persona {

    public static void insertar(Connection cnxn, int tpDcmnt, String nrDcmnt, String plld, String nmbr, Date fchNcmnt, String tlfn, String ml, String dmcl, int lcldd)
    {
        try{
            PreparedStatement stmt = cnxn.prepareStatement("INSERT INTO Persona (tipoDocumento, nroDocumento, apellido, nombre, fechaNacimiento, telefono, email, domicilio, localidad) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, tpDcmnt);
            stmt.setString(2, nrDcmnt);
            stmt.setString(3, plld);
            stmt.setString(4, nmbr);
            stmt.setDate(5, fchNcmnt);
            stmt.setString(6, tlfn);
            stmt.setString(7, ml);
            stmt.setString(8, dmcl);
            stmt.setInt(9, lcldd);
            
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
            PreparedStatement stmt = cnxn.prepareStatement("UPDATE Persona SET borrado = true WHERE idPersona = ?");
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
            PreparedStatement stmt = cnxn.prepareStatement("UPDATE Persona SET borrado = false WHERE idPersona = ?");
            stmt.setInt(1, id);
            
            stmt.execute();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }

    public static void modificar(Connection cnxn, int tpDcmnt, String nrDcmnt, String plld, String nmbr, Date fchNcmnt, String tlfn, String ml, String dmcl, int lcldd, int id)
    {
        try{
            PreparedStatement stmt = cnxn.prepareStatement("UPDATE Persona SET tipoDocumento = ?, nroDocumento = ?, apellido = ?, nombre = ?, fechaNacimiento = ?, telefono = ?, email = ?, domicilio = ?, localidad = ? WHERE idPersona = ?");
            stmt.setInt(1, tpDcmnt);
            stmt.setString(2, nrDcmnt);
            stmt.setString(3, plld);
            stmt.setString(4, nmbr);
            stmt.setDate(5, fchNcmnt);
            stmt.setString(6, tlfn);
            stmt.setString(7, ml);
            stmt.setString(8, dmcl);
            stmt.setInt(9, lcldd);
            stmt.setInt(10, id);
            
            stmt.execute();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }

    public static int leerId(Connection cnxn, int tpDcmnt, String nrDcmnt)
    {
        int id=0;
        ResultSet rs;
        
        try{
            PreparedStatement stmt = cnxn.prepareStatement("SELECT idPersona FROM Persona WHERE tipoDocumento = ? and nroDocumento = ? and borrado = false");
            stmt.setInt(1, tpDcmnt);
            stmt.setString(2, nrDcmnt);
            
            rs = stmt.executeQuery();
            if(rs.next())
                id = rs.getInt("idPersona");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
        return id;
    }
    
    public static int leerIdBorrado(Connection cnxn, int tpDcmnt, String nrDcmnt)
    {
        int id=0;
        ResultSet rs;
        
        try{
            PreparedStatement stmt = cnxn.prepareStatement("SELECT idPersona FROM Persona WHERE tipoDocumento = ? and nroDocumento = ?");
            stmt.setInt(1, tpDcmnt);
            stmt.setString(2, nrDcmnt);
            
            rs = stmt.executeQuery();
            if(rs.next())
                id = rs.getInt("idPersona");
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
            PreparedStatement stmt = cnxn.prepareStatement("SELECT borrado FROM Persona WHERE idPersona = ?");
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
    
    public static ResultSet leerPersona(Connection cnxn, int id)
    {
        ResultSet rs = null;

        try{
            PreparedStatement stmt = cnxn.prepareStatement("SELECT tipo, nroDocumento, apellido, nombre, fechaNacimiento, domicilio, Localidad.Nombre FROM Persona INNER JOIN tipoDocumento ON idTipoDocumento INNER JOIN Localidad ON idLocalidad = localidad WHERE idPersona = ? and borrado = 0");
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
        return rs;
    }
    
}
