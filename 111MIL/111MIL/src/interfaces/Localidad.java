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

public class Localidad extends javax.swing.JInternalFrame {

    DefaultTableModel modeloTabla;
    boolean modificar = false;
    int idLocalidad = 0;
    int idProvincia = 0;
    int idModificar = 0;
    Connection conexion;
    
    public Localidad(Connection cnx) {
        initComponents();
        conexion = cnx;
        modeloTabla = (DefaultTableModel) tablaLocalidades.getModel();
        cargarProvincias();
        cargarLocalidades();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtLocalidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLocalidades = new javax.swing.JTable();
        btnGrabar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblModificando = new javax.swing.JLabel();
        cbxProvincias = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Administrar LOCALIDADES");
        setPreferredSize(new java.awt.Dimension(340, 360));

        txtLocalidad.setNextFocusableComponent(btnGrabar);
        txtLocalidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLocalidadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLocalidadFocusLost(evt);
            }
        });
        txtLocalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLocalidadKeyPressed(evt);
            }
        });

        tablaLocalidades.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaLocalidades.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(tablaLocalidades);

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
        btnSalir.setNextFocusableComponent(txtLocalidad);
        btnSalir.setPreferredSize(new java.awt.Dimension(90, 30));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblModificando.setForeground(java.awt.Color.red);

        cbxProvincias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxProvincias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxProvinciasItemStateChanged(evt);
            }
        });
        cbxProvincias.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbxProvinciasFocusGained(evt);
            }
        });

        jLabel1.setText("Provincia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(txtLocalidad, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGrabar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblModificando, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxProvincias, 0, 231, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxProvincias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblModificando, javax.swing.GroupLayout.DEFAULT_SIZE, 8, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Administrar LOCALIDADES");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarLocalidades()
    {
        String[] localidad = new String[1];
        ResultSet rsLocalidades;

        
        idProvincia = clases.Localidad.leerId(conexion, cbxProvincias.getSelectedItem().toString(), 0);
        rsLocalidades = clases.Localidad.leerLugares(conexion, 2, idProvincia);
        
        modeloTabla.setColumnCount(0);
        modeloTabla.setRowCount(0);
        modeloTabla.addColumn("Localidades");
        
        try{
            while(rsLocalidades.next())
            {
                localidad[0] = rsLocalidades.getString("nombre");
                modeloTabla.addRow(localidad);
            }
            tablaLocalidades.setModel(modeloTabla);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
    }
    
    private void cargarProvincias()
    {
        ResultSet rsProvincias = null;
        cbxProvincias.removeAllItems();
        rsProvincias = clases.Localidad.leerLugares(conexion, 1);
        
        try{
            while(rsProvincias.next())
                cbxProvincias.addItem(rsProvincias.getString("nombre"));
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
        lblModificando.setText("* Modificando la Localidad "+txtLocalidad.getText().trim().toUpperCase());
        lblModificando.setVisible(true);
        txtLocalidad.requestFocus();
        idModificar = idLocalidad;
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if(modificar == false)
        {
            if(clases.Localidad.borrado(conexion, idLocalidad))
                clases.Localidad.restaurar(conexion, clases.Localidad.leerIdBorrado(conexion, txtLocalidad.getText().trim(), idProvincia));
            else
                clases.Localidad.insertar(conexion, 2, txtLocalidad.getText().toUpperCase(), idProvincia);
        }
        else
        {
            clases.Localidad.modificar(conexion, txtLocalidad.getText().toUpperCase(), idModificar);
            modificar = false;
            lblModificando.setVisible(false);
        }
        txtLocalidad.setText("");
        txtLocalidad.requestFocus();
        cargarLocalidades();
        apagarBotones();
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void txtLocalidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLocalidadFocusLost
        idLocalidad = clases.Localidad.leerId(conexion, txtLocalidad.getText().trim(), idProvincia);
        
        if(idLocalidad == 0)
            noExiste();
        else
            existe();
    }//GEN-LAST:event_txtLocalidadFocusLost

    private void txtLocalidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLocalidadFocusGained
        apagarBotones();
    }//GEN-LAST:event_txtLocalidadFocusGained

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Eliminar la localidad "+txtLocalidad.getText().toUpperCase(), "¡ATENCION!...", YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            clases.Localidad.eliminar(conexion, idLocalidad);
            txtLocalidad.setText("");
            cargarLocalidades();
        }
        else
            JOptionPane.showMessageDialog(null, "Operación cancelada", "¡ATENCIÓN!", INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txtLocalidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalidadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            idLocalidad = clases.Localidad.leerId(conexion, txtLocalidad.getText().trim(), idProvincia);
        
            if(idLocalidad == 0)
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
    }//GEN-LAST:event_txtLocalidadKeyPressed

    private void cbxProvinciasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxProvinciasFocusGained
        apagarBotones();
    }//GEN-LAST:event_cbxProvinciasFocusGained

    private void cbxProvinciasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxProvinciasItemStateChanged
        if(cbxProvincias.getSelectedItem() != null)
            cargarLocalidades();
    }//GEN-LAST:event_cbxProvinciasItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxProvincias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblModificando;
    private javax.swing.JTable tablaLocalidades;
    private javax.swing.JTextField txtLocalidad;
    // End of variables declaration//GEN-END:variables
}