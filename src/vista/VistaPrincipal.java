package vista;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Categoria;
import Modelo.Mproductos;
import Modelo.Proveedor;
import Modelo.TablaProductos;
import controlador.Cproductos;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTabbedPane;

public class VistaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal frame = new VistaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setPreferredSize(new Dimension(900, 768));
		pack();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JTabbedPane Pestañas = new JTabbedPane(JTabbedPane.TOP);

		// 1. Crear las Vistas y Modelos necesarios
		TablaProductos modeloTabla = new TablaProductos(); // <-- NECESARIO
		DialogoAgregar DAgregar = new DialogoAgregar();
		PanelProductos Pproductos = new PanelProductos();

		// 2. CREAR Y CONECTAR EL CONTROLADOR
		Cproductos controlador = new Cproductos(modeloTabla, DAgregar, Pproductos);

		// 3. Conectar el JTable de la vista al modelo de la tabla
		Pproductos.getTablaInvenario().setModel(modeloTabla.getModelo());

		// 4. Agregar vistas a la ventana
		Pestañas.addTab("Productos", Pproductos);
		contentPane.add(Pestañas, BorderLayout.CENTER);

	}
}
