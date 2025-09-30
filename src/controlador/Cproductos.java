package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Modelo.Categoria;
import Modelo.ModeloCombobox;
import Modelo.Mproductos;
import Modelo.Proveedor;
import Modelo.TablaProductos;
import vista.DialogoAgregar;
import vista.PanelProductos;

public class Cproductos implements ActionListener {

	Mproductos modeloProductos;
	TablaProductos modeloTabla;
	DialogoAgregar vistaAgregar;
	PanelProductos vista;

	public Cproductos(TablaProductos tablaProductos, DialogoAgregar dialogo, PanelProductos panel) {
		this.modeloTabla = tablaProductos;
		this.vistaAgregar = dialogo;
		this.vista = panel;

		modeloProductos = new Mproductos();

		vistaAgregar.getBaceptar().addActionListener(this);
		vistaAgregar.getBcancelar().addActionListener(this);
		vista.getBagregar().addActionListener(this);

		modeloTabla.getModelo();

		cargarComboBoxes();
	}

	// NUEVO MÉTODO: Centraliza la lógica de carga de ComboBox para las dos vistas.
	private void cargarComboBoxes() {
		List<Categoria> categorias = modeloProductos.getCategoria();
		List<Proveedor> proveedores = modeloProductos.getProveedor();

		// 1. Recargar ComboBox de PanelProductos (vista principal)
		ModeloCombobox.cargarComboBox(vista.getCcatergoria(), categorias);
		ModeloCombobox.cargarComboBox(vista.getCproveedor(), proveedores);

		// 2. Recargar ComboBox de DialogoAgregar (el diálogo)
		ModeloCombobox.cargarComboBox(vistaAgregar.getCcatgoria(), categorias);
		ModeloCombobox.cargarComboBox(vistaAgregar.getCproveedor(), proveedores);
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

		System.out.println("DEBUG: Evento recibido en Cproductos. Fuente: " + e.getSource().getClass().getSimpleName());

		if (e.getSource() == vista.getBagregar()) {
			System.out.println("INFO: Botón Agregar presionado. Abriendo diálogo.");

			cargarComboBoxes();
			vistaAgregar.setVisible(true);
		}

		if (e.getSource() == vistaAgregar.getBaceptar()) {
			System.out.println("INFO: Botón Aceptar presionado. Guardando producto.");
			try {
				int id = Integer.parseInt(vistaAgregar.getTid().getText());
				String nombre = vistaAgregar.getTnombre().getText();
				double precioC = Double.parseDouble(vistaAgregar.getTpcompra().getText());
				double precioV = Double.parseDouble(vistaAgregar.getTpventa().getText());
				int stock = Integer.parseInt(vistaAgregar.getTstook().getText());
				int alerta = Integer.parseInt(vistaAgregar.getTxtAlertaDeStook().getText());

				Object catItem = vistaAgregar.getCcatgoria().getSelectedItem();
				Object provItem = vistaAgregar.getCproveedor().getSelectedItem();

				Categoria cat;
				Proveedor prov;

				if (catItem instanceof String) {

					int nuevoIdCat = modeloProductos.getCategoria().size() + 100;
					cat = new Categoria(nuevoIdCat, (String) catItem);
					modeloProductos.agregarCategoria(cat); // GUARDAR CENTRALMENTE
				} else if (catItem instanceof Categoria) {
					cat = (Categoria) catItem;
				} else {
					throw new IllegalArgumentException("Selección de Categoría no válida.");
				}

				if (provItem instanceof String) {
					// Si es String, el usuario escribió una nueva entrada.
					int nuevoNitProv = modeloProductos.getProveedor().size() + 200;
					prov = new Proveedor(nuevoNitProv, (String) provItem);
					modeloProductos.agregarProveedor(prov); // GUARDAR CENTRALMENTE
				} else if (provItem instanceof Proveedor) {
					prov = (Proveedor) provItem;
				} else {
					throw new IllegalArgumentException("Selección de Proveedor no válida.");
				}

				cargarComboBoxes();

				Mproductos prod = new Mproductos(id, nombre, List.of(cat), List.of(prov), precioC, precioV, stock,
						alerta);
				this.modeloTabla.agregarProducto("sin-imagen.png", prod);

				limpiarCampos();
				vistaAgregar.dispose();

			} catch (NumberFormatException error) {
				System.err.println("ERROR: Campos de ID, Stock o Precios no contienen números válidos.");
			} catch (IllegalArgumentException error) {
				System.err.println("ERROR: " + error.getMessage());
			} catch (Exception error) {
				System.err.println("ERROR desconocido al guardar: " + error.getMessage());
			}
		}

		if (e.getSource() == vistaAgregar.getBcancelar()) {
			System.out.println("INFO: Botón Cancelar presionado. Cerrando diálogo.");
			limpiarCampos();
			vistaAgregar.dispose();
		}
	}
}