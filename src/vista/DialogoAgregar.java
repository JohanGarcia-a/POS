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
import java.awt.Color;

public class DialogoAgregar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField Tnombre;
	private JTextField Tpcompra;
	private JTextField Tpventa;
	private JTextField textField;
	private JTextField txtAlertaDeStook;
	private JButton Baceptar, Bcancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoAgregar dialog = new DialogoAgregar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
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
		gbl_panelInfoBasica.rowHeights = new int[] { 0, 0, 0, 0, 0 };
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

		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 2;
		panelInfoBasica.add(comboBox_1, gbc_comboBox_1);
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
		gbl_panelEditarProducto.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelEditarProducto.columnWeights = new double[] { 0.0, 1.0, 1.0 };
		gbl_panelEditarProducto.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		panelEditarProducto.setLayout(gbl_panelEditarProducto);

		JLabel LprecioCompra = new JLabel("Precio Compra");
		GridBagConstraints gbc_LprecioCompra = new GridBagConstraints();
		gbc_LprecioCompra.insets = new Insets(0, 0, 5, 5);
		gbc_LprecioCompra.gridx = 1;
		gbc_LprecioCompra.gridy = 0;
		panelEditarProducto.add(LprecioCompra, gbc_LprecioCompra);

		Tpcompra = new JTextField();
		GridBagConstraints gbc_tpcompra = new GridBagConstraints();
		gbc_tpcompra.insets = new Insets(0, 0, 5, 5);
		gbc_tpcompra.fill = GridBagConstraints.HORIZONTAL;
		gbc_tpcompra.gridx = 1;
		gbc_tpcompra.gridy = 1;
		panelEditarProducto.add(Tpcompra, gbc_tpcompra);
		Tpcompra.setColumns(10);

		JLabel LprecioVenta = new JLabel("Precio Venta");
		GridBagConstraints gbc_LprecioVenta = new GridBagConstraints();
		gbc_LprecioVenta.insets = new Insets(0, 0, 5, 5);
		gbc_LprecioVenta.gridx = 1;
		gbc_LprecioVenta.gridy = 2;
		panelEditarProducto.add(LprecioVenta, gbc_LprecioVenta);

		Tpventa = new JTextField();
		Tpventa.setColumns(10);
		GridBagConstraints gbc_tpventa = new GridBagConstraints();
		gbc_tpventa.insets = new Insets(0, 0, 5, 5);
		gbc_tpventa.fill = GridBagConstraints.HORIZONTAL;
		gbc_tpventa.gridx = 1;
		gbc_tpventa.gridy = 3;
		panelEditarProducto.add(Tpventa, gbc_tpventa);

		JLabel Lproveedor = new JLabel("Proveedor");
		GridBagConstraints gbc_Lproveedor = new GridBagConstraints();
		gbc_Lproveedor.insets = new Insets(0, 0, 5, 5);
		gbc_Lproveedor.gridx = 1;
		gbc_Lproveedor.gridy = 4;
		panelEditarProducto.add(Lproveedor, gbc_Lproveedor);

		JComboBox Ccategoria = new JComboBox();
		GridBagConstraints gbc_Ccategoria = new GridBagConstraints();
		gbc_Ccategoria.insets = new Insets(0, 0, 5, 5);
		gbc_Ccategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_Ccategoria.gridx = 1;
		gbc_Ccategoria.gridy = 5;
		panelEditarProducto.add(Ccategoria, gbc_Ccategoria);

		JLabel Lstook = new JLabel("Stook");
		GridBagConstraints gbc_Lstook = new GridBagConstraints();
		gbc_Lstook.insets = new Insets(0, 0, 5, 5);
		gbc_Lstook.gridx = 1;
		gbc_Lstook.gridy = 6;
		panelEditarProducto.add(Lstook, gbc_Lstook);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 7;
		panelEditarProducto.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel LalertaStook = new JLabel("Stook minimo de alerta");
		GridBagConstraints gbc_LalertaStook = new GridBagConstraints();
		gbc_LalertaStook.insets = new Insets(0, 0, 5, 5);
		gbc_LalertaStook.gridx = 1;
		gbc_LalertaStook.gridy = 8;
		panelEditarProducto.add(LalertaStook, gbc_LalertaStook);

		txtAlertaDeStook = new JTextField();
		txtAlertaDeStook.setForeground(Color.BLACK);
		GridBagConstraints gbc_txtAlertaDeStook = new GridBagConstraints();
		gbc_txtAlertaDeStook.insets = new Insets(0, 0, 5, 5);
		gbc_txtAlertaDeStook.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAlertaDeStook.gridx = 1;
		gbc_txtAlertaDeStook.gridy = 9;
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

	public JTextField getTnombre() {
		return Tnombre;
	}

	public void setTnombre(JTextField tnombre) {
		Tnombre = tnombre;
	}

	public JTextField getTpcompra() {
		return Tpcompra;
	}

	public void setTpcompra(JTextField tpcompra) {
		Tpcompra = tpcompra;
	}

	public JTextField getTpventa() {
		return Tpventa;
	}

	public void setTpventa(JTextField tpventa) {
		Tpventa = tpventa;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTxtAlertaDeStook() {
		return txtAlertaDeStook;
	}

	public void setTxtAlertaDeStook(JTextField txtAlertaDeStook) {
		this.txtAlertaDeStook = txtAlertaDeStook;
	}

}
