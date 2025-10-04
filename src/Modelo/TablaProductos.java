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

	public void agregarProducto(String imagen, Mproductos p) {

		String nombreCategoria = p.getCategoriaDeProducto().isEmpty() ? ""
				: p.getCategoriaDeProducto().get(0).getNombre();
		String razonSocialProveedor = p.getProveedorDeProducto().isEmpty() ? ""
				: p.getProveedorDeProducto().get(0).getRazonSocial();

		modelo.addRow(new Object[] { imagen, p.getId(), nombreCategoria,

				p.getNombre(), razonSocialProveedor, p.getPrecioVenta(), p.getPrecioCompra(), p.getStock() });
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}
}
