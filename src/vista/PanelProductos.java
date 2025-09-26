package vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
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

	/**
	 * Create the panel.
	 */
	public PanelProductos() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Tbuscar = new JTextField();
		Tbuscar.setForeground(UIManager.getColor("Button.shadow"));

		Tbuscar.setText("Buscar por nombre o codigo");
		panel.add(Tbuscar);
		Tbuscar.setColumns(15);

		Ccatergoria = new JComboBox();
		Ccatergoria.addItem("Categoria: Todos");
		panel.add(Ccatergoria);

		Cproveedor = new JComboBox();
		Cproveedor.addItem("Proveedor: Todos");
		panel.add(Cproveedor);

		Cstook = new JComboBox();
		Cstook.addItem("Nivel de Stook: Todos");
		panel.add(Cstook);

		Bagregar = new JButton("Agregar producto");
		Bagregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DialogoAgregar dialogo = new DialogoAgregar();
				dialogo.setVisible(true);
			}
		});
		panel.add(Bagregar);

		DefaultTableModel modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("Imagen");
		modeloTabla.addColumn("Categoria");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Precio Venta");
		modeloTabla.addColumn("Precio Compra");
		modeloTabla.addColumn("Stook");

		JTable tablaInvenario = new JTable(modeloTabla);

		modeloTabla.addRow(new Object[] { 1, 1, 1, 1, 1, 1 });
		tablaInvenario.setVisible(true);
		Panelinventario = new JScrollPane(tablaInvenario);
		add(Panelinventario, BorderLayout.CENTER);

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

}
