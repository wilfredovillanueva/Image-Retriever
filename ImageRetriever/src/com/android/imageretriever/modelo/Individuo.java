package com.android.imageretriever.modelo;

import android.graphics.drawable.Drawable;

public class Individuo {
	
	// Datos personales
	private String dni;
	
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String direccion = "N";
	
	private String fechaNacimiento;
	private String sexo = "Masculino";
	
	private String idimagen;
	private String imagen;
	private Drawable imagenDrawable;
	
	// Datos delictivos
	private String[] delitos;
	private String situacionActual;
	private String antecedentes;
		
	private boolean robo;
	private boolean narcotrafico;
	private boolean asesinato;
	
	// Características físicas
	private String cabelloTamanio;
	private String cabelloColor;
	private String cabelloForma;
	private String tieneTinte;
	private String rostroForma;
	private String rostroTamanio;
	private String rostroColor;
	private String rostroRaza;
	private String ojosTipo;
	private String ojosColor;
	private String ojosTamanio;
	private String ojosLesion;
	private String narizForma;
	private String narizRinomegalia;
	private String narizRaza;
	private String labios;
	private String cejas;
	private String orejas;
	private String frente;
	private String cabeza;

	private String pomulos;
	private String pecasgranos;
	private String cicatrices;
	private String bigotes;
	private String barba;
	
	//private int[] caracteristicas;
	
	public Individuo(String dni){
		this.dni = dni;
	}
	
	public Individuo(String dni, Drawable imagenDrawable, String nombres,
			String apellidoPaterno, String apellidoMaterno,
			String fechaNacimiento, String sexo, String direccion) {
		this.dni = dni;
		this.imagenDrawable = imagenDrawable;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getIdimagen() {
		return idimagen;
	}

	public void setIdimagen(String idimagen) {
		this.idimagen = idimagen;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Drawable getImagenDrawable() {
		return imagenDrawable;
	}

	public void setImagenDrawable(Drawable imagenDrawable) {
		this.imagenDrawable = imagenDrawable;
	}

	public String[] getDelitos() {
		return delitos;
	}

	public void setDelitos(String[] delitos) {
		this.delitos = delitos;
	}

	public String getSituacionActual() {
		return situacionActual;
	}

	public void setSituacionActual(String situacionActual) {
		this.situacionActual = situacionActual;
	}

	public String getAntecedentes() {
		return antecedentes;
	}

	public void setAntecedentes(String antecedentes) {
		this.antecedentes = antecedentes;
	}

	public boolean isRobo() {
		return robo;
	}

	public void setRobo(boolean robo) {
		this.robo = robo;
	}

	public boolean isNarcotrafico() {
		return narcotrafico;
	}

	public void setNarcotrafico(boolean narcotrafico) {
		this.narcotrafico = narcotrafico;
	}

	public boolean isAsesinato() {
		return asesinato;
	}

	public void setAsesinato(boolean asesinato) {
		this.asesinato = asesinato;
	}

	public String getCabelloTamanio() {
		return cabelloTamanio;
	}

	public void setCabelloTamanio(String cabelloTamanio) {
		this.cabelloTamanio = cabelloTamanio;
	}

	public String getCabelloColor() {
		return cabelloColor;
	}

	public void setCabelloColor(String cabelloColor) {
		this.cabelloColor = cabelloColor;
	}

	public String getCabelloForma() {
		return cabelloForma;
	}

	public void setCabelloForma(String cabelloForma) {
		this.cabelloForma = cabelloForma;
	}

	public String getTieneTinte() {
		return tieneTinte;
	}

	public void setTieneTinte(String tieneTinte) {
		this.tieneTinte = tieneTinte;
	}

	public String getRostroForma() {
		return rostroForma;
	}

	public void setRostroForma(String rostroForma) {
		this.rostroForma = rostroForma;
	}

	public String getRostroTamanio() {
		return rostroTamanio;
	}

	public void setRostroTamanio(String rostroTamanio) {
		this.rostroTamanio = rostroTamanio;
	}

	public String getRostroColor() {
		return rostroColor;
	}

	public void setRostroColor(String rostroColor) {
		this.rostroColor = rostroColor;
	}

	public String getRostroRaza() {
		return rostroRaza;
	}

	public void setRostroRaza(String rostroRaza) {
		this.rostroRaza = rostroRaza;
	}

	public String getOjosTipo() {
		return ojosTipo;
	}

	public void setOjosTipo(String ojosTipo) {
		this.ojosTipo = ojosTipo;
	}

	public String getOjosColor() {
		return ojosColor;
	}

	public void setOjosColor(String ojosColor) {
		this.ojosColor = ojosColor;
	}

	public String getOjosTamanio() {
		return ojosTamanio;
	}

	public void setOjosTamanio(String ojosTamanio) {
		this.ojosTamanio = ojosTamanio;
	}

	public String getOjosLesion() {
		return ojosLesion;
	}

	public void setOjosLesion(String ojosLesion) {
		this.ojosLesion = ojosLesion;
	}

	public String getNarizForma() {
		return narizForma;
	}

	public void setNarizForma(String narizForma) {
		this.narizForma = narizForma;
	}

	public String getNarizRinomegalia() {
		return narizRinomegalia;
	}

	public void setNarizRinomegalia(String narizRinomegalia) {
		this.narizRinomegalia = narizRinomegalia;
	}

	public String getNarizRaza() {
		return narizRaza;
	}

	public void setNarizRaza(String narizRaza) {
		this.narizRaza = narizRaza;
	}

	public String getLabios() {
		return labios;
	}

	public void setLabios(String labios) {
		this.labios = labios;
	}

	public String getCejas() {
		return cejas;
	}

	public void setCejas(String cejas) {
		this.cejas = cejas;
	}

	public String getOrejas() {
		return orejas;
	}

	public void setOrejas(String orejas) {
		this.orejas = orejas;
	}

	public String getFrente() {
		return frente;
	}

	public void setFrente(String frente) {
		this.frente = frente;
	}

	public String getCabeza() {
		return cabeza;
	}

	public void setCabeza(String cabeza) {
		this.cabeza = cabeza;
	}

	public String getPomulos() {
		return pomulos;
	}

	public void setPomulos(String pomulos) {
		this.pomulos = pomulos;
	}

	public String getPecasgranos() {
		return pecasgranos;
	}

	public void setPecasgranos(String pecasgranos) {
		this.pecasgranos = pecasgranos;
	}

	public String getCicatrices() {
		return cicatrices;
	}

	public void setCicatrices(String cicatrices) {
		this.cicatrices = cicatrices;
	}

	public String getBigotes() {
		return bigotes;
	}

	public void setBigotes(String bigotes) {
		this.bigotes = bigotes;
	}

	public String getBarba() {
		return barba;
	}

	public void setBarba(String barba) {
		this.barba = barba;
	}
	
	
	
	
}
