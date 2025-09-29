package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;

import Modelo.Mproductos;
import vista.DialogoAgregar;
import vista.PanelProductos;

public class Cproductos implements ActionListener {

	Mproductos modelo;
	DialogoAgregar vistaAgregar;
	PanelProductos vista;

	public Cproductos(Mproductos modelo, DialogoAgregar vistaAgregar, PanelProductos vista) {
		super();
		this.modelo = modelo;
		this.vistaAgregar = vistaAgregar;
		this.vista = vista;

		vistaAgregar.getBaceptar().addActionListener(this);
		modelo.getModeloTabla();

		vista.getBagregar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaAgregar.setVisible(true);
			}
		});

	}

	public void limpiarCampos() {
		vistaAgregar.setTnombre("");
		vistaAgregar.setTid("");
		vistaAgregar.setTpcompra("");
		vistaAgregar.setTpventa("");
		vistaAgregar.setTstook("");
		vistaAgregar.setTxtAlertaDeStook("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vistaAgregar.getBaceptar()) {

			String catselect = (String) vistaAgregar.getCcatgoria().getSelectedItem();
			String proveeSelect = (String) vistaAgregar.getCproveedor().getSelectedItem();

			DefaultComboBoxModel modeloCat = modelo.getModeloCategoria();
			DefaultComboBoxModel modeloProvee = modelo.getProvee();

			boolean Existe = false;
			// para categorias
			for (int i = 0; i < modeloCat.getSize(); i++) {
				if (((String) modeloCat.getElementAt(i)).equalsIgnoreCase(catselect)) {
					Existe = true;
					break;
				}
			}
			// para aaproveedor
			for (int i = 0; i < modeloProvee.getSize(); i++) {
				if (((String) modeloProvee.getElementAt(i)).equalsIgnoreCase(proveeSelect)) {
					Existe = true;
					break;
				}
			}

			if (!Existe && catselect != null && !catselect.trim().isEmpty()) {

				modelo.AgregarCategoria(catselect);

			}

			if (!Existe && proveeSelect != null && !proveeSelect.trim().isEmpty()) {

				modelo.AgregarProveedor(proveeSelect);
				;

			}
		
			vista.getTablaInvenario().setModel(modelo.getModeloTabla());
			modelo.Agregar("imaegen", Integer.parseInt(vistaAgregar.getTid().getText()), catselect,
					vistaAgregar.getTnombre().getText(), Double.parseDouble(vistaAgregar.getTpcompra().getText()),
					Double.parseDouble(vistaAgregar.getTpventa().getText()),
					Integer.parseInt(vistaAgregar.getTstook().getText()));
			limpiarCampos();
			vistaAgregar.dispose();

		} else if (e.getSource() == vistaAgregar.getBcancelar()) {
			vistaAgregar.dispose();
		}
	}

}