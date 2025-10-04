package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane; // NECESARIO para mostrar mensajes al usuario

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

				String id = vistaAgregar.getTid().getText();
				String nombre = vistaAgregar.getTnombre().getText();
				double precioC = Double.parseDouble(vistaAgregar.getTpcompra().getText());
				double precioV = Double.parseDouble(vistaAgregar.getTpventa().getText());
				int stock = Integer.parseInt(vistaAgregar.getTstook().getText());
				int alerta = Integer.parseInt(vistaAgregar.getTxtAlertaDeStook().getText());

				Object catItem = vistaAgregar.getCcatgoria().getSelectedItem();
				Object provItem = vistaAgregar.getCproveedor().getSelectedItem();

				Categoria cat;
				Proveedor prov;

				// --- 1. Manejo y Guardado de Categoría ---
				if (catItem instanceof String) {
					// Nueva categoría (escrita por el usuario)
					int nuevoIdCat = modeloProductos.getCategoria().size() + 100;
					cat = new Categoria(nuevoIdCat, (String) catItem);
					modeloProductos.agregarCategoria(cat); // Guarda localmente (lista estática)
				} else if (catItem instanceof Categoria) {
					cat = (Categoria) catItem;
				} else {
					throw new IllegalArgumentException("Selección de Categoría no válida.");
				}

				// --- 2. Manejo y Guardado de Proveedor ---
				if (provItem instanceof String) {
					// Nuevo proveedor (escrito por el usuario)
					int nuevoNitProv = modeloProductos.getProveedor().size() + 200;
					prov = new Proveedor(nuevoNitProv, (String) provItem);
					modeloProductos.agregarProveedor(prov); // Guarda localmente (lista estática)
				} else if (provItem instanceof Proveedor) {
					prov = (Proveedor) provItem;
				} else {
					throw new IllegalArgumentException("Selección de Proveedor no válida.");
				}

				cargarComboBoxes(); // Recarga los combos si se agregaron elementos nuevos

				// 3. Crear el objeto Mproductos para la inserción
				Mproductos prod = new Mproductos(id, nombre, List.of(cat), List.of(prov), precioC, precioV, stock,
						alerta);

				this.modeloTabla.agregarProducto("sin-imagen.png", prod);

				// 5. Limpiar, cerrar y notificar
				limpiarCampos();
				vistaAgregar.dispose();
				JOptionPane.showMessageDialog(vistaAgregar, "", "Guardado Exitoso", JOptionPane.INFORMATION_MESSAGE);

			} catch (NumberFormatException error) {
				System.err.println("ERROR: Campos de ID, Stock o Precios no contienen números válidos.");
				JOptionPane.showMessageDialog(vistaAgregar,
						"Error de formato. Verifique que los campos numéricos sean correctos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (IllegalArgumentException error) {
				System.err.println("ERROR: " + error.getMessage());
				JOptionPane.showMessageDialog(vistaAgregar, "Error de selección: " + error.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (Exception error) {
				System.err.println("ERROR desconocido al guardar: " + error.getMessage());
				JOptionPane.showMessageDialog(vistaAgregar,
						"Ocurrió un error al guardar el producto. Detalles: " + error.getMessage(), "Error de BD",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == vistaAgregar.getBcancelar()) {
			System.out.println("INFO: Botón Cancelar presionado. Cerrando diálogo.");
			limpiarCampos();
			vistaAgregar.dispose();
		}
	}
}