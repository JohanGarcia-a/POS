package vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelProductos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField Tbuscar;
	private JButton Bagregar;
	private JComboBox Ccatergoria, Cproveedor, Cstook;
	private JScrollPane Panelinventario;
	private JPanel panelAcciones;
	private JButton Beditar;
	private JButton Beliminar;
	private JButton BactivarDesactivar;
	private JTable tablaInvenario;
	private JLabel Lcategoria;
	private JLabel LnivelStook;
	private JLabel Lproveedor;

	/**
	 * Create the panel.
	 */
	public PanelProductos() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();

		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 72, 117, 30, 112, 130, 117, 0 };
		gbl_panel.rowHeights = new int[] { 0, 23, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0 };
		panel.setLayout(gbl_panel);

		Lcategoria = new JLabel("Categoria");
		GridBagConstraints gbc_Lcategoria = new GridBagConstraints();
		gbc_Lcategoria.insets = new Insets(0, 0, 5, 5);
		gbc_Lcategoria.gridx = 2;
		gbc_Lcategoria.gridy = 0;
		panel.add(Lcategoria, gbc_Lcategoria);

		Lproveedor = new JLabel("Proveedor");
		GridBagConstraints gbc_lproveedor = new GridBagConstraints();
		gbc_lproveedor.insets = new Insets(0, 0, 5, 5);
		gbc_lproveedor.gridx = 3;
		gbc_lproveedor.gridy = 0;
		panel.add(Lproveedor, gbc_lproveedor);

		LnivelStook = new JLabel("Nivel de stook");
		GridBagConstraints gbc_lnivelStook = new GridBagConstraints();
		gbc_lnivelStook.insets = new Insets(0, 0, 5, 5);
		gbc_lnivelStook.gridx = 4;
		gbc_lnivelStook.gridy = 0;
		panel.add(LnivelStook, gbc_lnivelStook);

		Tbuscar = new JTextField();
		Tbuscar.setForeground(UIManager.getColor("Button.shadow"));

		Tbuscar.setText("Buscar por nombre o codigo");
		GridBagConstraints gbc_tbuscar = new GridBagConstraints();
		gbc_tbuscar.anchor = GridBagConstraints.WEST;
		gbc_tbuscar.insets = new Insets(0, 0, 5, 5);
		gbc_tbuscar.gridx = 1;
		gbc_tbuscar.gridy = 1;
		panel.add(Tbuscar, gbc_tbuscar);
		Tbuscar.setColumns(15);

		Ccatergoria = new JComboBox();
		GridBagConstraints gbc_ccatergoria = new GridBagConstraints();
		gbc_ccatergoria.anchor = GridBagConstraints.NORTHWEST;
		gbc_ccatergoria.insets = new Insets(0, 0, 5, 5);
		gbc_ccatergoria.gridx = 2;
		gbc_ccatergoria.gridy = 1;
		panel.add(Ccatergoria, gbc_ccatergoria);

		Cproveedor = new JComboBox();
		Cproveedor.addItem("Proveedor: Todos");
		GridBagConstraints gbc_cproveedor = new GridBagConstraints();
		gbc_cproveedor.anchor = GridBagConstraints.WEST;
		gbc_cproveedor.insets = new Insets(0, 0, 5, 5);
		gbc_cproveedor.gridx = 3;
		gbc_cproveedor.gridy = 1;
		panel.add(Cproveedor, gbc_cproveedor);

		Cstook = new JComboBox();
		Cstook.addItem("Nivel de Stook: Todos");
		GridBagConstraints gbc_cstook = new GridBagConstraints();
		gbc_cstook.anchor = GridBagConstraints.WEST;
		gbc_cstook.insets = new Insets(0, 0, 5, 5);
		gbc_cstook.gridx = 4;
		gbc_cstook.gridy = 1;
		panel.add(Cstook, gbc_cstook);

		Bagregar = new JButton("Agregar producto");

		GridBagConstraints gbc_bagregar = new GridBagConstraints();
		gbc_bagregar.insets = new Insets(0, 0, 5, 5);
		gbc_bagregar.anchor = GridBagConstraints.NORTHWEST;
		gbc_bagregar.gridx = 5;
		gbc_bagregar.gridy = 1;
		panel.add(Bagregar, gbc_bagregar);

		tablaInvenario = new JTable();

		Panelinventario = new JScrollPane(tablaInvenario);
		add(Panelinventario, BorderLayout.CENTER);
		tablaInvenario.setVisible(true);

		panelAcciones = new JPanel();
		add(panelAcciones, BorderLayout.SOUTH);
		panelAcciones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Beliminar = new JButton("Eliminar");
		panelAcciones.add(Beliminar);

		Beditar = new JButton("Editar");
		Beditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DialogoAgregar dialogo = new DialogoAgregar();
				dialogo.setVisible(true);
			}
		});
		panelAcciones.add(Beditar);

		BactivarDesactivar = new JButton("Desactivar");
		panelAcciones.add(BactivarDesactivar);

	}

	public JTextField getTbuscar() {
		return Tbuscar;
	}

	public void setTbuscar(JTextField tbuscar) {
		Tbuscar = tbuscar;
	}

	public JButton getBagregar() {
		return Bagregar;
	}

	public void setBagregar(JButton bagregar) {
		Bagregar = bagregar;
	}

	public JComboBox getCcatergoria() {
		return Ccatergoria;
	}

	public void setCcatergoria(JComboBox ccatergoria) {
		Ccatergoria = ccatergoria;
	}

	public JComboBox getCproveedor() {
		return Cproveedor;
	}

	public void setCproveedor(JComboBox cproveedor) {
		Cproveedor = cproveedor;
	}

	public JComboBox getCstook() {
		return Cstook;
	}

	public void setCstook(JComboBox cstook) {
		Cstook = cstook;
	}

	public JScrollPane getPanelinventario() {
		return Panelinventario;
	}

	public void setPanelinventario(JScrollPane panelinventario) {
		Panelinventario = panelinventario;
	}

	public JPanel getPanelAcciones() {
		return panelAcciones;
	}

	public void setPanelAcciones(JPanel panelAcciones) {
		this.panelAcciones = panelAcciones;
	}

	public JButton getBeditar() {
		return Beditar;
	}

	public void setBeditar(JButton beditar) {
		Beditar = beditar;
	}

	public JButton getBeliminar() {
		return Beliminar;
	}

	public void setBeliminar(JButton beliminar) {
		Beliminar = beliminar;
	}

	public JButton getBactivarDesactivar() {
		return BactivarDesactivar;
	}

	public void setBactivarDesactivar(JButton bactivarDesactivar) {
		BactivarDesactivar = bactivarDesactivar;
	}

	public JTable getTablaInvenario() {
		return tablaInvenario;
	}

	public void setTablaInvenario(JTable tablaInvenario) {
		this.tablaInvenario = tablaInvenario;
	}

}
