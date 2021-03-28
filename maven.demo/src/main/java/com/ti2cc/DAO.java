package com.ti2cc;

import java.sql.*;

public class DAO {
	private Connection conexao;
	
	
	// metodo construtor
	public DAO() {
		conexao = null;
	}
	
	//metodo para conectar c banco de dados
	public boolean conectar() {
		String driverName = "org.postgresql.Driver";
		String serverName = "localhost";
		String mydatabase = "empresa";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta + "/" + mydatabase;
		String username = "postgres";
		String password = "Bacon1000";
		boolean status = false;
		
		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexao com postgres efetuada!");
		}
		catch (ClassNotFoundException e){
			System.err.println("Conexao nao efetuada com o postgres... driver nao encontrado..." + e.getMessage());
		}
		catch (SQLException e) { 
			System.err.println("Conexao nao efetuada com o postgres..." + e.getMessage());
		}
		
		return status;
	}
	
	
	//metodo para fechar conexao
	public boolean close() {
		boolean status = false;
		try {
			conexao.close();
			status = true;			
		} 
		catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
		
	}
	
	//metodo para inserir funcionario na tabela
	public boolean inserirFuncionario(Funcionario funcionario) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO funcionario VALUES (" + funcionario.getCodigo() + ", " 
			+ funcionario.getSalario() + ", " + funcionario.getDepartamento() + ", '" 
			+ funcionario.getPrimeiroNome() + "', '" + funcionario.getUltimoNome() + "', '" + funcionario.getSexo() + "')";
			
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	
	//metodo atualizar valores de funcionario na tabela
	public boolean atualizarFuncionario (Funcionario funcionario) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE funcionario SET salario = " + funcionario.getSalario() + ", departamento = " + funcionario.getDepartamento() + ", p_nome = '" + funcionario.getPrimeiroNome() + "', u_nome = '" + funcionario.getUltimoNome() + "', sexo = '" + funcionario.getSexo() + "' WHERE codigo = " + funcionario.getCodigo();
			st.executeUpdate(sql);
			
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	
	//metodo para excluir funcionario da tabela
	public boolean excluirFuncionario (int codigo) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM funcionario WHERE codigo =" + codigo;		
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public Funcionario[]  getFuncionarios() {
		Funcionario[] funcionarios = null;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM funcionario");
			if (rs.next()) {
				rs.last();
				funcionarios = new Funcionario[rs.getRow()];
				rs.beforeFirst();
				
				for (int i = 0; rs.next(); i++) {
					funcionarios[i] = new Funcionario(rs.getInt("codigo"), rs.getInt("salario"), rs.getInt("departamento"),
					rs.getString("p_nome"), rs.getString("u_nome"), rs.getString("sexo").charAt(0));
				}
			}
			st.close();
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return funcionarios;
		
	}
	
	public Funcionario[]  getFuncionariosMasculinos() {
		Funcionario[] funcionarios = null;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM funcionario WHERE funcionario.sexo LIKE 'M'");
			if (rs.next()) {
				rs.last();
				funcionarios = new Funcionario[rs.getRow()];
				rs.beforeFirst();
				
				for (int i = 0; rs.next(); i++) {
					funcionarios[i] = new Funcionario(rs.getInt("codigo"), rs.getInt("salario"), rs.getInt("departamento"),
					rs.getString("p_nome"), rs.getString("u_nome"), rs.getString("sexo").charAt(0));
				}
			}
			st.close();
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return funcionarios;
		
	}
	
	public Funcionario[]  getFuncionariosFemininos() {
		Funcionario[] funcionarios = null;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM funcionario WHERE funcionario.sexo LIKE 'F'");
			if (rs.next()) {
				rs.last();
				funcionarios = new Funcionario[rs.getRow()];
				rs.beforeFirst();
				
				for (int i = 0; rs.next(); i++) {
					funcionarios[i] = new Funcionario(rs.getInt("codigo"), rs.getInt("salario"), rs.getInt("departamento"),
					rs.getString("p_nome"), rs.getString("u_nome"), rs.getString("sexo").charAt(0));
				}
			}
			st.close();
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return funcionarios;
		
	}
	

	
	
	
}
