package Modelo;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class Mproductos {
	private String Nombre;
	private DefaultComboBoxModel<String> modeloCategoria;
	private double precioCompra, PrecioVenta;
	private int Stook, AlertaStook, id;
	private DefaultComboBoxModel<String> Modelopprovee;
	private DefaultTableModel modeloTabla;

	public Mproductos(String imagen, int id, DefaultComboBoxModel<String> modeloCategoria, String nombre,
			double precioCompra, double precioVenta, int stook, int alertaStook,
			DefaultComboBoxModel<String> Modelopprovee) {
		super();
		Nombre = nombre;
		this.precioCompra = precioCompra;
		PrecioVenta = precioVenta;
		Stook = stook;
		AlertaStook = alertaStook;
		this.id = id;

		modeloTabla = new DefaultTableModel();

		modeloTabla.addColumn("Imagen");
		modeloTabla.addColumn("ID");
		modeloTabla.addColumn("Categoria");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Precio Venta");
		modeloTabla.addColumn("Precio Compra");
		modeloTabla.addColumn("Stook");

		if (Modelopprovee == null) {
			this.Modelopprovee = new DefaultComboBoxModel<>();
			this.Modelopprovee.addElement("Default");

		} else {
			this.Modelopprovee = Modelopprovee;
		}

		if (modeloCategoria == null) {
			this.modeloCategoria = new DefaultComboBoxModel<>();
			this.modeloCategoria.addElement("Todos");
			this.modeloCategoria.addElement("Sin Categoria");
		} else {
			this.modeloCategoria = modeloCategoria;
		}
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public void Agregar(String imagen, int id, String categoria, String nombre, double precioV, double precioC,
			int stook) {
		modeloTabla.addRow(new Object[] { imagen, id, categoria, nombre, precioV, precioC, stook

		});
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setModeloCategoria(DefaultComboBoxModel<String> modeloCategoria) {
		this.modeloCategoria = modeloCategoria;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
	}

	public void AgregarCategoria(String cat) {
		modeloCategoria.addElement(cat);
	}

	public void AgregarProveedor(String provee) {
		Modelopprovee.addElement(provee);
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public DefaultComboBoxModel<String> getModeloCategoria() {
		return this.modeloCategoria;
	}

	public void setCat(DefaultComboBoxModel<String> modeloCategoria) {
		this.modeloCategoria = modeloCategoria;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return PrecioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		PrecioVenta = precioVenta;
	}

	public int getStook() {
		return Stook;
	}

	public void setStook(int stook) {
		Stook = stook;
	}

	public int getAlertaStook() {
		return AlertaStook;
	}

	public void setAlertaStook(int alertaStook) {
		AlertaStook = alertaStook;
	}

	public DefaultComboBoxModel<String> getProvee() {
		return Modelopprovee;
	}

	public void setProvee(DefaultComboBoxModel<String> provee) {
		this.Modelopprovee = provee;
	}

}
