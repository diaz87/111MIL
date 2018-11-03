package interfaces;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import javafx.scene.input.KeyCode;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.table.DefaultTableModel;

public class Provincia extends javax.swing.JInternalFrame {

    DefaultTableModel modeloTabla;
    boolean modificar = false;
    int idProvincia = 0;
    int idModificar = 0;
    Connection conexion;
    
    public Provincia(Connection cnx) {
        initComponents();
        conexion = cnx;
        modeloTabla = (DefaultTableModel) tablaProvincias.getModel();
        cargarProvincias();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtProvincia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProvincias = new javax.swing.JTable();
        btnGrabar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblModificando = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Administrar PROVINCIAS");
        setPreferredSize(new java.awt.Dimension(340, 315));

        txtProvincia.setNextFocusableComponent(btnGrabar);
        txtProvincia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProvinciaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProvinciaFocusLost(evt);
            }
        });
        txtProvincia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProvinciaKeyPressed(evt);
            }
        });

        tablaProvincias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane1.setViewportView(tablaProvincias);

        btnGrabar.setText("GRABAR");
        btnGrabar.setNextFocusableComponent(btnModificar);
        btnGrabar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnModificar.setText("MODIFICAR");
        btnModificar.setNextFocusableComponent(btnBorrar);
        btnModificar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBorrar.setText("BORRAR");
        btnBorrar.setNextFocusableComponent(btnSalir);
        btnBorrar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnSalir.setText("SALIR");
        btnSalir.setNextFocusableComponent(txtProvincia);
        btnSalir.setPreferredSize(new java.awt.Dimension(90, 30));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblModificando.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGrabar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblModificando, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblModificando)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarProvincias()
    {
        String[] provincia = new String[1];
        ResultSet rsProvincias = null;
        rsProvincias = clases.Localidad.leerLugares(conexion, 1);
        
        modeloTabla.setColumnCount(0);
        modeloTabla.setRowCount(0);
        modeloTabla.addColumn("PROVINCIAS");
        
        try{
            while(rsProvincias.next())
            {
                provincia[0] = rsProvincias.getString("nombre");
                modeloTabla.addRow(provincia);
            }
            tablaProvincias.setModel(modeloTabla);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
    }
    
    private void existe()
    {
        btnGrabar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnBorrar.setEnabled(true);
    }
    
    private void noExiste()
    {
        btnGrabar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnBorrar.setEnabled(false);
    }
    
    private void apagarBotones()
    {
        btnGrabar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnBorrar.setEnabled(false);
    }

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificar = true;
        lblModificando.setText("* Modificando la Provincia "+txtProvincia.getText().trim().toUpperCase());
        lblModificando.setVisible(true);
        txtProvincia.requestFocus();
        idModificar = idProvincia;
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if(modificar == false)
        {
            if(clases.Localidad.borrado(conexion, idProvincia))
                clases.Localidad.restaurar(conexion, clases.Localidad.leerIdBorrado(conexion, txtProvincia.getText().trim(), 0));
            else
                clases.Localidad.insertar(conexion, 1, txtProvincia.getText().toUpperCase(), 0);
        }
        else
        {
            clases.Localidad.modificar(conexion, txtProvincia.getText().toUpperCase(), idModificar);
            modificar = false;
            lblModificando.setVisible(false);
        }
        txtProvincia.setText("");
        txtProvincia.requestFocus();
        cargarProvincias();
        apagarBotones();
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void txtProvinciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProvinciaFocusLost
        idProvincia = clases.Localidad.leerId(conexion, txtProvincia.getText().trim(), 0);
        
        if(idProvincia == 0)
            noExiste();
        else
            existe();
    }//GEN-LAST:event_txtProvinciaFocusLost

    private void txtProvinciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProvinciaFocusGained
        apagarBotones();
    }//GEN-LAST:event_txtProvinciaFocusGained

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Eliminar la provincia "+txtProvincia.getText().toUpperCase(), "¡ATENCION!...", YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            clases.Localidad.eliminar(conexion, idProvincia);
            txtProvincia.setText("");
            cargarProvincias();
        }
        else
            JOptionPane.showMessageDialog(null, "Operación cancelada", "¡ATENCIÓN!", INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txtProvinciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProvinciaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            idProvincia = clases.Localidad.leerId(conexion, txtProvincia.getText().trim(), 0);
        
            if(idProvincia == 0)
            {
                noExiste();
                btnGrabar.requestFocus();
            }
            else
            {
                existe();
                btnModificar.requestFocus();
            }
        }
    }//GEN-LAST:event_txtProvinciaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblModificando;
    private javax.swing.JTable tablaProvincias;
    private javax.swing.JTextField txtProvincia;
    // End of variables declaration//GEN-END:variables
}