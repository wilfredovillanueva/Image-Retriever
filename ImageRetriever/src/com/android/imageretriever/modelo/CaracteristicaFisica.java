package com.android.imageretriever.modelo;

public class CaracteristicaFisica {
	
	private int codigoC;
	private String nombre;
	private String valor;
	
	public CaracteristicaFisica(int codigoC, String nombre, String valor) {
		super();
		this.codigoC = codigoC;
		this.nombre = nombre;
		this.valor = valor;
	}

	public int getCodigoC() {
		return codigoC;
	}

	public void setCodigoC(int codigoC) {
		this.codigoC = codigoC;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	

}
