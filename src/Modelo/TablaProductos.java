package Modelo;

import javax.swing.table.DefaultTableModel;

public class TablaProductos {
	private DefaultTableModel modelo;

	public TablaProductos() {
		modelo = new DefaultTableModel();
		modelo.addColumn("Imagen");
		modelo.addColumn("ID");
		modelo.addColumn("Categoria");
		modelo.addColumn("Nombre");
		modelo.addColumn("Proveedor");
		modelo.addColumn("Precio Venta");
		modelo.addColumn("Precio Compra");
		modelo.addColumn("Stock");
	}

	// Agregar un producto a la tabla
	public void agregarProducto(String imagen, Mproductos p) {

		// Asumiendo que las listas tienen al menos 1 elemento
		 String nombreCategoria = p.getCategoriaDeProducto().isEmpty() ? "" : p.getCategoriaDeProducto().get(0).getNombre();
	        String razonSocialProveedor = p.getProveedorDeProducto().isEmpty() ? "" : p.getProveedorDeProducto().get(0).getRazonSocial();

		modelo.addRow(new Object[] { imagen, p.getId(), nombreCategoria, // <-- CORREGIDO: Accede al primer elemento de
																			// la lista
				p.getNombre(), razonSocialProveedor, // <-- CORREGIDO: Accede al primer elemento de la lista
				p.getPrecioVenta(), p.getPrecioCompra(), p.getStock() });
	}

	// Devolver el modelo para asignarlo al JTable
	public DefaultTableModel getModelo() {
		return modelo;
	}
}
