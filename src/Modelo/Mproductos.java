package Modelo;

import javax.swing.DefaultComboBoxModel;

public class Mproductos {
	private String Nombre;
	private DefaultComboBoxModel<String> cat;
	private double precioCompra, PrecioVenta;
	private int Stook, AlertaStook;
	private DefaultComboBoxModel<String> provee;

	public Mproductos(String nombre, DefaultComboBoxModel<String> cat, double precioCompra, double precioVenta,
			int stook, int alertaStook, DefaultComboBoxModel<String> provee) {
		super();
		Nombre = nombre;
		this.cat = cat;
		this.precioCompra = precioCompra;
		PrecioVenta = precioVenta;
		Stook = stook;
		AlertaStook = alertaStook;
		this.provee = provee;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public DefaultComboBoxModel<String> getCat() {
		return cat;
	}

	public void setCat(DefaultComboBoxModel<String> cat) {
		this.cat = cat;
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
		return provee;
	}

	public void setProvee(DefaultComboBoxModel<String> provee) {
		this.provee = provee;
	}

}
