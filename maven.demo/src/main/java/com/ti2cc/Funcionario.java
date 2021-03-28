package com.ti2cc;

public class Funcionario {
	private int codigo;
	private int salario;
	private int departamento;
	private String p_nome;
	private String u_nome;
	private char sexo;
	
	//metodo construtor vazio
	public Funcionario() {
		codigo = -1;
		salario = -1;
		departamento = -1;
		p_nome = "";
		u_nome = "";
		sexo = '*';
		
	}
	//metodo construtor parametros
	public Funcionario(int codigo, int salario, int departamento, String p_nome, String u_nome, char sexo) {
		
		this.codigo = codigo;
		this.salario = salario;
		this.departamento = departamento;
		this.p_nome = p_nome;
		this.u_nome = u_nome;
		this.sexo = sexo;
		
	}
	
	//metodos set
	public void setCodigo(int codigo) {
		this.codigo = codigo;	
	}
	
	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}
	
	public void setPrimeiroNome(String p_nome) {
		this.p_nome = p_nome;
	}
	
	public void setUltimoNome(String u_nome) {
		this.u_nome = u_nome;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	//metodos get
	
	public int getCodigo() {
		return codigo;
	}
	
	public int getSalario() {
		return salario;
	}
	
	public int getDepartamento () {
		return departamento;
	}
	
	public String getPrimeiroNome() {
		return p_nome;
	}
	
	public String getUltimoNome() {
		return u_nome;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	//converter dados para String
	public String dataToString() {
		return "Funcionario [codigo=" + codigo + ", salario=" + salario + ", departamento=" + departamento + ", primeiro nome=" + p_nome + ", ultimo nome=" + u_nome + ", sexo=" + sexo + "]";
	}
}

