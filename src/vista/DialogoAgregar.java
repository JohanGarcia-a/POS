package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.UIManager;

import Modelo.Categoria;
import Modelo.Mproductos;
import Modelo.Proveedor;

import java.awt.Color;

public class DialogoAgregar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField Tnombre;
	private JTextField Tpcompra;
	private JTextField Tpventa;
	private JTextField Tstook;
	private JTextField txtAlertaDeStook;
	private JButton Baceptar, Bcancelar;
	private JComboBox<Categoria> Ccatgoria;
	private JComboBox<Proveedor> Cproveedor;
	private JTextField Tid;

	public DialogoAgregar() {
		setResizable(false);
		setBounds(100, 100, 538, 395);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(600, 600));
		// --Informacion basica
		JPanel panelInfoBasica = new JPanel();
		panelInfoBasica.setBorder(BorderFactory.createTitledBorder("Informacion basica" + ""));
		pack();
		getContentPane().add(panelInfoBasica, BorderLayout.NORTH);
		GridBagLayout gbl_panelInfoBasica = new GridBagLayout();
		gbl_panelInfoBasica.columnWidths = new int[] { 0, 0, 232, 0 };
		gbl_panelInfoBasica.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panelInfoBasica.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0 };
		gbl_panelInfoBasica.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		panelInfoBasica.setLayout(gbl_panelInfoBasica);

		JLabel Lnombre = new JLabel("Nombre");
		GridBagConstraints gbc_Lnombre = new GridBagConstraints();
		gbc_Lnombre.anchor = GridBagConstraints.EAST;
		gbc_Lnombre.insets = new Insets(0, 0, 5, 5);
		gbc_Lnombre.gridx = 1;
		gbc_Lnombre.gridy = 1;
		panelInfoBasica.add(Lnombre, gbc_Lnombre);

		Tnombre = new JTextField();
		GridBagConstraints gbc_tnombre = new GridBagConstraints();
		gbc_tnombre.insets = new Insets(0, 0, 5, 5);
		gbc_tnombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tnombre.gridx = 2;
		gbc_tnombre.gridy = 1;
		panelInfoBasica.add(Tnombre, gbc_tnombre);
		Tnombre.setColumns(10);

		JLabel Lcategoria = new JLabel("Categoria");
		GridBagConstraints gbc_Lcategoria = new GridBagConstraints();
		gbc_Lcategoria.anchor = GridBagConstraints.EAST;
		gbc_Lcategoria.insets = new Insets(0, 0, 5, 5);
		gbc_Lcategoria.gridx = 1;
		gbc_Lcategoria.gridy = 2;
		panelInfoBasica.add(Lcategoria, gbc_Lcategoria);

		Ccatgoria = new JComboBox<Categoria>();
		Ccatgoria.setEditable(true);
		GridBagConstraints gbc_Ccatgoria = new GridBagConstraints();
		gbc_Ccatgoria.insets = new Insets(0, 0, 5, 5);
		gbc_Ccatgoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_Ccatgoria.gridx = 2;
		gbc_Ccatgoria.gridy = 2;
		panelInfoBasica.add(Ccatgoria, gbc_Ccatgoria);
		// --proveedor y caracteristicas

		JPanel panelProveedor = new JPanel();
		pack();
		panelProveedor.setBorder(BorderFactory.createTitledBorder("Proveedor y Caracteristicas"));
		getContentPane().add(panelProveedor, BorderLayout.CENTER);
		panelProveedor.setLayout(new BorderLayout(0, 0));

		// --imagen
		JPanel panelimagen = new JPanel();
		pack();
		panelimagen.setPreferredSize(new Dimension(300, 250));
		panelProveedor.add(panelimagen, BorderLayout.WEST);
		panelimagen.setLayout(new BorderLayout(0, 0));

		JTextArea Areaimagen = new JTextArea();
		panelimagen.add(Areaimagen, BorderLayout.CENTER);

		JButton BeditarImagen = new JButton("Cambiar Imagen");
		panelimagen.add(BeditarImagen, BorderLayout.SOUTH);

		// --editar producto
		JPanel panelEditarProducto = new JPanel();
		panelEditarProducto.setPreferredSize(new Dimension(250, 150));
		panelProveedor.add(panelEditarProducto, BorderLayout.EAST);
		GridBagLayout gbl_panelEditarProducto = new GridBagLayout();
		gbl_panelEditarProducto.columnWidths = new int[] { 43, 0, 0 };
		gbl_panelEditarProducto.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelEditarProducto.columnWeights = new double[] { 0.0, 1.0, 1.0 };
		gbl_panelEditarProducto.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0 };
		panelEditarProducto.setLayout(gbl_panelEditarProducto);

		JLabel Lid = new JLabel("ID");
		GridBagConstraints gbc_Lid = new GridBagConstraints();
		gbc_Lid.insets = new Insets(0, 0, 5, 5);
		gbc_Lid.gridx = 1;
		gbc_Lid.gridy = 0;
		panelEditarProducto.add(Lid, gbc_Lid);

		Tid = new JTextField();
		GridBagConstraints gbc_tid = new GridBagConstraints();
		gbc_tid.insets = new Insets(0, 0, 5, 5);
		gbc_tid.fill = GridBagConstraints.HORIZONTAL;
		gbc_tid.gridx = 1;
		gbc_tid.gridy = 1;
		panelEditarProducto.add(Tid, gbc_tid);
		Tid.setColumns(10);

		JLabel LprecioCompra = new JLabel("Precio Compra");
		GridBagConstraints gbc_LprecioCompra = new GridBagConstraints();
		gbc_LprecioCompra.insets = new Insets(0, 0, 5, 5);
		gbc_LprecioCompra.gridx = 1;
		gbc_LprecioCompra.gridy = 2;
		panelEditarProducto.add(LprecioCompra, gbc_LprecioCompra);

		Tpcompra = new JTextField();
		GridBagConstraints gbc_tpcompra = new GridBagConstraints();
		gbc_tpcompra.insets = new Insets(0, 0, 5, 5);
		gbc_tpcompra.fill = GridBagConstraints.HORIZONTAL;
		gbc_tpcompra.gridx = 1;
		gbc_tpcompra.gridy = 3;
		panelEditarProducto.add(Tpcompra, gbc_tpcompra);
		Tpcompra.setColumns(10);

		JLabel LprecioVenta = new JLabel("Precio Venta");
		GridBagConstraints gbc_LprecioVenta = new GridBagConstraints();
		gbc_LprecioVenta.insets = new Insets(0, 0, 5, 5);
		gbc_LprecioVenta.gridx = 1;
		gbc_LprecioVenta.gridy = 4;
		panelEditarProducto.add(LprecioVenta, gbc_LprecioVenta);

		Tpventa = new JTextField();
		Tpventa.setColumns(10);
		GridBagConstraints gbc_tpventa = new GridBagConstraints();
		gbc_tpventa.insets = new Insets(0, 0, 5, 5);
		gbc_tpventa.fill = GridBagConstraints.HORIZONTAL;
		gbc_tpventa.gridx = 1;
		gbc_tpventa.gridy = 5;
		panelEditarProducto.add(Tpventa, gbc_tpventa);

		JLabel Lproveedor = new JLabel("Proveedor");
		GridBagConstraints gbc_Lproveedor = new GridBagConstraints();
		gbc_Lproveedor.insets = new Insets(0, 0, 5, 5);
		gbc_Lproveedor.gridx = 1;
		gbc_Lproveedor.gridy = 6;
		panelEditarProducto.add(Lproveedor, gbc_Lproveedor);

		Cproveedor = new JComboBox<Proveedor>();
		Cproveedor.setEditable(true);
		GridBagConstraints gbc_Cproveedor = new GridBagConstraints();
		gbc_Cproveedor.insets = new Insets(0, 0, 5, 5);
		gbc_Cproveedor.fill = GridBagConstraints.HORIZONTAL;
		gbc_Cproveedor.gridx = 1;
		gbc_Cproveedor.gridy = 7;
		panelEditarProducto.add(Cproveedor, gbc_Cproveedor);

		JLabel Lstook = new JLabel("Stook");
		GridBagConstraints gbc_Lstook = new GridBagConstraints();
		gbc_Lstook.insets = new Insets(0, 0, 5, 5);
		gbc_Lstook.gridx = 1;
		gbc_Lstook.gridy = 8;
		panelEditarProducto.add(Lstook, gbc_Lstook);

		Tstook = new JTextField();
		GridBagConstraints gbc_tstook = new GridBagConstraints();
		gbc_tstook.insets = new Insets(0, 0, 5, 5);
		gbc_tstook.fill = GridBagConstraints.HORIZONTAL;
		gbc_tstook.gridx = 1;
		gbc_tstook.gridy = 9;
		panelEditarProducto.add(Tstook, gbc_tstook);
		Tstook.setColumns(10);

		JLabel LalertaStook = new JLabel("Stook minimo de alerta");
		GridBagConstraints gbc_LalertaStook = new GridBagConstraints();
		gbc_LalertaStook.insets = new Insets(0, 0, 5, 5);
		gbc_LalertaStook.gridx = 1;
		gbc_LalertaStook.gridy = 10;
		panelEditarProducto.add(LalertaStook, gbc_LalertaStook);

		txtAlertaDeStook = new JTextField();
		txtAlertaDeStook.setForeground(Color.BLACK);
		GridBagConstraints gbc_txtAlertaDeStook = new GridBagConstraints();
		gbc_txtAlertaDeStook.insets = new Insets(0, 0, 5, 5);
		gbc_txtAlertaDeStook.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAlertaDeStook.gridx = 1;
		gbc_txtAlertaDeStook.gridy = 11;
		panelEditarProducto.add(txtAlertaDeStook, gbc_txtAlertaDeStook);
		txtAlertaDeStook.setColumns(10);
		JPanel paneBotones = new JPanel();
		getContentPane().add(paneBotones, BorderLayout.SOUTH);
		paneBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// panel botones
		Baceptar = new JButton("aceptar y guardar");
		paneBotones.add(Baceptar);

		Bcancelar = new JButton("Cancelar");
		paneBotones.add(Bcancelar);

	}

	public JTextField getTid() {
		return Tid;
	}

	public void setTid(String tid) {
		Tid.setText(tid);
	}

	public JTextField getTnombre() {
		return Tnombre;
	}

	public void setTnombre(String tnombre) {
		Tnombre.setText(tnombre);
	}

	public JTextField getTpcompra() {
		return Tpcompra;
	}

	public void setTpcompra(String tpcompra) {
		Tpcompra.setText(tpcompra);
	}

	public JTextField getTpventa() {
		return Tpventa;
	}

	public void setTpventa(String tpventa) {
		Tpventa.setText(tpventa);
	}

	public JTextField getTstook() {
		return Tstook;
	}

	public void setTstook(String tstook) {
		Tstook.setText(tstook);
	}

	public JTextField getTxtAlertaDeStook() {
		return txtAlertaDeStook;
	}

	public void setTxtAlertaDeStook(String txtAlertaDeStook) {
		this.txtAlertaDeStook.setText(txtAlertaDeStook);
	}

	public JButton getBaceptar() {
		return Baceptar;
	}

	public void setBaceptar(JButton baceptar) {
		Baceptar = baceptar;
	}

	public JButton getBcancelar() {
		return Bcancelar;
	}

	public void setBcancelar(JButton bcancelar) {
		Bcancelar = bcancelar;
	}

	public JComboBox getCcatgoria() {
		return Ccatgoria;
	}

	public void setCcatgoria(JComboBox ccatgoria) {
		Ccatgoria = ccatgoria;
	}

	public JComboBox getCproveedor() {
		return Cproveedor;
	}

	public void setCproveedor(JComboBox cproveedor) {
		Cproveedor = cproveedor;
	}

}
