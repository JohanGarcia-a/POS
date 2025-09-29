package vista;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Mproductos;
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

		Mproductos Mproductos = new Mproductos("init", 0, null, null, 0, 0, 0, 0, null);
		DialogoAgregar DAgregar = new DialogoAgregar();
		PanelProductos Pproductos = new PanelProductos();

		DAgregar.getCcatgoria().setModel(Mproductos.getModeloCategoria());
		Pproductos.getCcatergoria().setModel(Mproductos.getModeloCategoria());

		DAgregar.getCproveedor().setModel(Mproductos.getProvee());
		Pproductos.getCproveedor().setModel(Mproductos.getProvee());

		Cproductos Cproductos = new Cproductos(Mproductos, DAgregar, Pproductos);

		Pestañas.addTab("Productos", Pproductos);
		contentPane.add(Pestañas, BorderLayout.CENTER);

	}
}
