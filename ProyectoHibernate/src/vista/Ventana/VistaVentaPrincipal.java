package vista.Ventana;

import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.ModeloTablaPersonal;

@SuppressWarnings("serial")
public class VistaVentaPrincipal extends javax.swing.JPanel {

    private static final String URL_AGREGAR = "recursos/add.png";
    private static final String URL_ELIMINAR = "recursos/eliminar.png";
    private static final String URL_ARRIBA = "recursos/flechaazul.png";
    private static final String URL_ABAJO = "recursos/flechaazul2.png";
	
    private ModeloTablaPersonal modeloTablaCola;
    
    /**
     * Creates new form VistaAlmacen
     * @param barra
     */
    public VistaVentaPrincipal() {
        initComponents();
        cargarAjustesComponentes();
    }
    
    private void cargarAjustesComponentes() {
    	this.setBorder(new EmptyBorder(80, 80, 80, 80));
    }
    
    public void setControlador(ActionListener e){
    	jButtonBuscarArticulo.addActionListener(e);
        jButtonBuscar.addActionListener(e);
        jButtonCobrar.addActionListener(e);
        jButtonLimpiar.addActionListener(e);
        jButtonAniadirArticulo.addActionListener(e);
        jButtonSubir.addActionListener(e);
        jButtonBajar.addActionListener(e);
        jButtonEliminar.addActionListener(e);
        jTextFieldFiltro.addActionListener(e);
    	
    	jButtonBuscarArticulo.setActionCommand("buscarArticulo");
        jButtonBuscar.setActionCommand("buscarUsuario");
        jButtonCobrar.setActionCommand("cobrar");
        jButtonLimpiar.setActionCommand("limpiar");
        jButtonAniadirArticulo.setActionCommand("aniadirArticulo");
        jButtonSubir.setActionCommand("aumentarCantidad");
        jButtonBajar.setActionCommand("disminuirCanitdad");
        jButtonEliminar.setActionCommand("eliminar");
        jTextFieldFiltro.setActionCommand("buscarArticulo");
        
    }
    
    public void setFiltroCliente(String texto){
    	jTextFieldFiltroNombre.setText(texto);
    }
    
    public int getCantidad(){
    	return Integer.valueOf(jSpinField1.getToolTipText().toString());
    }
    
    public String getFiltro(){
    	return jComboBox1.getSelectedItem().toString();
    }
    public String getTextoFiltro(){
    	return jTextFieldFiltro.getText().toString();
    }
    
    public String getJuegoNombre(){
    	String nombre = null;
    	int linea = jTable3.getSelectedRow();
    	if (linea != -1){
    		nombre = jTable3.getValueAt(linea, 0).toString();
    	}
    	
    	return nombre;
    }
    
    public void cargarFiltro(String[] filtro){
    	jComboBox1.setModel(new DefaultComboBoxModel<String>(filtro));
    }
    public void cargarTabla1(Object[][] Juegos, String[] cabecera, @SuppressWarnings("rawtypes") Class[] types){ 
    	ModeloTablaPersonal myModeloTabla = new ModeloTablaPersonal(cabecera, Juegos, types);
        jTable3.setModel(myModeloTabla);
    }

    public void cargarTabla2(Object[][] Juegos, @SuppressWarnings("rawtypes") Class[] types){ 
    	modeloTablaCola = new ModeloTablaPersonal(null, Juegos, types);
        jTable4.setModel(modeloTablaCola);
    }
    
	public void limpiarTablaCompra() {
		DefaultTableModel modelo = (DefaultTableModel) jTable4.getModel();
		while (modelo.getRowCount()>0) modelo.removeRow(0);
		
	}
    
    public ModeloTablaPersonal getModeloTabla(){
    	return modeloTablaCola;
    }

	public int getSizeRowTablaCompra() {
		return jTable4.getRowCount();
	}
	
	public int getselectedRowTablaCompra() {
		return jTable4.getSelectedRow();
	}

	public void setCantidadTablaCompraMas(int fila) {
		DefaultTableModel modelo = (DefaultTableModel) jTable4.getModel();
		int valor = (int) modelo.getValueAt(fila, 1) + 1;
		
		jTable4.setValueAt(valor, fila, 1);
	}
	
	public void setCantidadTablaCompraMenos(int fila) {
		DefaultTableModel modelo = (DefaultTableModel) jTable4.getModel();
		int valor = (int) modelo.getValueAt(fila, 1) + 1;
		
		jTable4.setValueAt(valor, fila, 1);
	}
	
	public void eliminarFilaTablaCompra(int fila) {
		DefaultTableModel modelo = (DefaultTableModel) jTable4.getModel();
		modelo.removeRow(fila);
	}

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPaneArticulos = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPaneCompra = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonCobrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelSeleccionarUsuario = new javax.swing.JLabel();
        jTextFieldFiltroNombre = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextFieldFiltro = new javax.swing.JTextField();
        jButtonBuscarArticulo = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jButtonAniadirArticulo = new javax.swing.JButton();
        jButtonSubir = new javax.swing.JButton();
        jButtonBajar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jSpinField1 = new com.toedter.components.JSpinField();

        setLayout(new java.awt.BorderLayout());

        this.setLayout(new java.awt.GridBagLayout());

        
        jScrollPaneArticulos.setViewportView(jTable3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.9;
        this.add(jScrollPaneArticulos, gridBagConstraints);

        
        jScrollPaneCompra.setViewportView(jTable4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.6;
        add(jScrollPaneCompra, gridBagConstraints);

        jButtonLimpiar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonLimpiar.setText("LIMPIAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        add(jButtonLimpiar, gridBagConstraints);

        jButtonCobrar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonCobrar.setText("COBRAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        add(jButtonCobrar, gridBagConstraints);
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(40, 0, 40, 0);
        add(jSeparator1, gridBagConstraints);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 0, 40);
        add(jSeparator2, gridBagConstraints);

        jLabelSeleccionarUsuario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelSeleccionarUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSeleccionarUsuario.setText("Seleccionar usuario ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.0;
        gridBagConstraints.weighty = 0.1;
        add(jLabelSeleccionarUsuario, gridBagConstraints);

        jTextFieldFiltroNombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 5.0;
        add(jTextFieldFiltroNombre, gridBagConstraints);

        jButtonBuscar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonBuscar.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jButtonBuscar, gridBagConstraints);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jComboBox1.setEditable(true);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jComboBox1, gridBagConstraints);

        jTextFieldFiltro.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        add(jTextFieldFiltro, gridBagConstraints);

        jButtonBuscarArticulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonBuscarArticulo.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        add(jButtonBuscarArticulo, gridBagConstraints);
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(40, 0, 40, 0);
        add(jSeparator3, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista de compra de art�culos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabel1, gridBagConstraints);

        jButtonAniadirArticulo.setIcon(new ImageIcon(URL_AGREGAR));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.5;
        add(jButtonAniadirArticulo, gridBagConstraints);

        jButtonSubir.setIcon(new ImageIcon(URL_ARRIBA));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.2;
        add(jButtonSubir, gridBagConstraints);

        jButtonBajar.setIcon(new ImageIcon(URL_ABAJO));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        add(jButtonBajar, gridBagConstraints);

        jButtonEliminar.setIcon(new ImageIcon(URL_ELIMINAR));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        add(jButtonEliminar, gridBagConstraints);

        jSpinField1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jSpinField1.setValue(1);
        jSpinField1.setMinimum(1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        add(jSpinField1, gridBagConstraints);

    }// </editor-fold>                        

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonSubir;
    private javax.swing.JButton jButtonBajar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonAniadirArticulo;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonBuscarArticulo;
    private javax.swing.JButton jButtonCobrar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelSeleccionarUsuario;
    private javax.swing.JScrollPane jScrollPaneArticulos;
    private javax.swing.JScrollPane jScrollPaneCompra;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private com.toedter.components.JSpinField jSpinField1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextFieldFiltro;
    private javax.swing.JTextField jTextFieldFiltroNombre;
    // End of variables declaration                   

}