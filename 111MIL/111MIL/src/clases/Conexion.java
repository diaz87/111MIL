package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ing. Javier Agustín Zamar
 */
public class Conexion {
   public static Connection conectar()
   {
       Connection conexion = null;
       String servidor = "jdbc:mysql://localhost/111MIL";
       String usuario = "admin";
       String pass = "admin";
       try
       {
           Class.forName("com.mysql.jdbc.Driver");
           conexion = (Connection) DriverManager.getConnection(servidor, usuario, pass);
       }
       catch(ClassNotFoundException ex)
       {
            JOptionPane.showMessageDialog(null, ex.getMessage());
       }
       catch(Exception ex)
       {
            JOptionPane.showMessageDialog(null, ex.getMessage());
       }
       finally
       {
           return conexion;
       }
   }
}
