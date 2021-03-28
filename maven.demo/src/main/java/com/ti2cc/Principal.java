package com.ti2cc;

import java.util.Scanner;

public class Principal {
	
	public static void listarBD(DAO dao, Scanner sc) {
		int menu_listar = 0;
		
		
		
		do {
			System.out.println("\nMENU LISTAR FUNCIONARIOS: \n1. TODOS \n2. MASCULINOS \n3. FEMININOS \n4. SAIR\n");
			menu_listar = sc.nextInt();
			switch(menu_listar) {
				case 1:
					Funcionario[] funcionarios = dao.getFuncionarios();
					System.out.println("Dados Tabela Funcionários: ");
					for (int i = 0; i < funcionarios.length; i++) {
						System.out.println(funcionarios[i].dataToString());
					}
					break;
				case 2:
					Funcionario[] funcionariosM = dao.getFuncionariosMasculinos();
					System.out.println("Dados Tabela Funcionários(Masculinos): ");
					for (int i = 0; i < funcionariosM.length; i++) {
						System.out.println(funcionariosM[i].dataToString());
					}
					break;
				case 3:
					Funcionario[] funcionariosF = dao.getFuncionariosFemininos();
					System.out.println("Dados Tabela Funcionários(Masculinos): ");
					for (int i = 0; i < funcionariosF.length; i++) {
						System.out.println(funcionariosF[i].dataToString());
					}
					break;
				case 4:
					break;
				default:
					System.out.println("OPÇÃO INVÁLIDA.");
					break;
			}
		}while(menu_listar != 4);

		
		
	}
	
	public static void inserirBD(DAO dao,Scanner sc) {
		System.out.println("Código do funcionário: ");
		int codigo = sc.nextInt();
		System.out.println("Salário do funcionário: ");
		int salario = sc.nextInt();
		System.out.println("Departamento do funcionário: ");
		int departamento = sc.nextInt();
		System.out.println("Primeiro do funcionário: ");
		String p_nome = sc.next();
		System.out.println("Último do funcionário: ");
		String u_nome = sc.next();
		System.out.println("Sexo do funcionário(M, F ou *): ");
		char sexo = sc.next().charAt(0);
		Funcionario funcionario = new Funcionario (codigo,salario,departamento,p_nome,u_nome,sexo);
		if (dao.inserirFuncionario(funcionario) == true) {
			System.out.println("Sucesso ao inserir funcionario... -> " + funcionario.dataToString());
		}
		
	}
	
	public static void excluirBD(DAO dao, Scanner sc) {
		System.out.println("Codigo do funcionario: ");
		int codigo = sc.nextInt();
		Funcionario funcionario = new Funcionario();
		funcionario.setCodigo(codigo);
		dao.excluirFuncionario(funcionario.getCodigo());
		System.out.println("Sucesso ao excluir funcionario...");
	}
	
	public static void atualizarBD(DAO dao, Scanner sc) {
		System.out.println("Código do funcionário que será atualizado: ");
		int pk = sc.nextInt();
		System.out.println("Salário atualizado: ");
		int salario = sc.nextInt();
		System.out.println("Departamento atualizado: ");
		int departamento = sc.nextInt();
		System.out.println("Primeiro nome atualizado: ");
		String p_nome = sc.next();
		System.out.println("Último nome atualizado: ");
		String u_nome = sc.next();
		System.out.println("Sexo atualizado (M, F ou *): ");
		char sexo = sc.next().charAt(0);
		Funcionario funcionario = new Funcionario(pk, salario, departamento, p_nome, u_nome, sexo);
		dao.atualizarFuncionario(funcionario);
		System.out.println("Sucesso ao atualizar funcionario... ->" + funcionario.dataToString());
	}
	
	public static void main(String[] args) {
		DAO dao = new DAO();
		
		dao.conectar();
		
		Scanner sc = new Scanner(System.in);
		int menu_option = 0;
		
		do {
			System.out.println("MENU: \n1. LISTAR \n2. INSERIR \n3. EXCLUIR \n4. ATUALIZAR \n5. SAIR");
				menu_option = sc.nextInt();
				switch(menu_option) {
				    case 1:
				    	listarBD(dao,sc);
				    	break;
				    case 2:
				    	inserirBD(dao,sc);
				    	break;
				    case 3:
				    	excluirBD(dao,sc);
				    	break;
				    case 4:
				    	atualizarBD(dao,sc);
				    	break;
				    case 5:
				    	break;
				    default:
				    	System.out.println("Número inválido");
				    	break;
				}
		} while (menu_option != 5);
		
		sc.close();
		//inserir funcionario na tabela
		
		
		//apagar funcionario da tabela
		
	}

}
