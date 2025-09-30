package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Mproductos {
	private int id;
	private String nombre;
	private List<Categoria> categoria;
	private List<Proveedor> proveedor;
	private double precioCompra;
	private double precioVenta;
	private int stock;
	private int alertaStock;

	private static List<Categoria> todasCategorias = new ArrayList<>();
	private static List<Proveedor> todosProveedores = new ArrayList<>();

	static {
		if (todasCategorias.isEmpty()) {
			todasCategorias.add(new Categoria(1, "Electrónica"));
			todasCategorias.add(new Categoria(2, "Ropa"));
		}
		if (todosProveedores.isEmpty()) {
			todosProveedores.add(new Proveedor(101, "Proveedor A"));
			todosProveedores.add(new Proveedor(102, "Proveedor B"));
		}
	}

	public Mproductos() {
		super();
		this.categoria = new ArrayList<>();
		this.proveedor = new ArrayList<>();
	}

	public Mproductos(int id, String nombre, List<Categoria> categoria, List<Proveedor> proveedor, double precioCompra,
			double precioVenta, int stock, int alertaStock) {
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.proveedor = proveedor;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.stock = stock;
		this.alertaStock = alertaStock;
	}

	/**
	 * Obtiene la lista de Categoría asignada específicamente a esta instancia de
	 * producto.
	 */
	public List<Categoria> getCategoriaDeProducto() {
		return this.categoria;
	}

	/**
	 * Obtiene la lista de Proveedor asignada específicamente a esta instancia de
	 * producto.
	 */
	public List<Proveedor> getProveedorDeProducto() {
		return this.proveedor;
	}

	public List<Categoria> getCategoria() {
		return todasCategorias;
	}

	public List<Proveedor> getProveedor() {
		return todosProveedores;
	}

	public void agregarCategoria(Categoria cat) {
		if (!todasCategorias.contains(cat)) {
			todasCategorias.add(cat);
		}
	}

	public void agregarProveedor(Proveedor prov) {

		if (!todosProveedores.contains(prov)) {
			todosProveedores.add(prov);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

	public void setProveedor(List<Proveedor> proveedor) {
		this.proveedor = proveedor;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getAlertaStock() {
		return alertaStock;
	}

	public void setAlertaStock(int alertaStock) {
		this.alertaStock = alertaStock;
	}
}