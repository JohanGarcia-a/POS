package Modelo;

public class Proveedor {
	private int nit;
	private String razonSocial;

	public Proveedor(int nit, String razonSocial) {
		super();
		this.nit = nit;
		this.razonSocial = razonSocial;
	}

	public long getNit() {
		return nit;
	}

	public void setNit(int nit) {
		this.nit = nit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Override
	public String toString() {
		return razonSocial; // Muestra la razón social del proveedor
	}
}