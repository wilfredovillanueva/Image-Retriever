package com.android.imageretriever.modelo;

public class Usuario {
	
	private int codigo;
	private String username;
	private String password;
	
	public Usuario(int codigo, String username, String password) {
		this.codigo = codigo;
		this.username = username;
		this.password = password;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
