package com.ti2cc;


import spark.Request;
import spark.Response;


public class Principal {
	
	public static DAO DAO() {
		DAO dao = new DAO();
		return dao;
		
		
	}
	
	public Object listarBD(Request request, Response response) {
		DAO dao = DAO();
		
		dao.conectar();
		
		StringBuffer returnValue = new StringBuffer();
		

		Funcionario[] funcionarios = dao.getFuncionarios();
		returnValue.append("Funcionários:   \n\n\n");
		for (int i = 0; i < funcionarios.length; i++) {
			if (i < (funcionarios.length - 1)) {
				returnValue.append(funcionarios[i].dataToString()+";   ");
			}
			else {
				returnValue.append(funcionarios[i].dataToString());
			}
		}
				
		
		return returnValue.toString();		
	}
	
	public Object inserirBD(Request request, Response response){
		DAO dao = DAO();
		
		dao.conectar();
		
		int codigo = Integer.parseInt(request.queryParams("codigo"));
		int salario = Integer.parseInt(request.queryParams("salario"));
		int departamento = Integer.parseInt(request.queryParams("departamento"));
		String p_nome =  request.queryParams("p_nome");
		String u_nome =  request.queryParams("u_nome");
		char sexo = request.queryParams("sexo").charAt(0);
		
		Funcionario funcionario = new Funcionario(codigo,salario,departamento,p_nome,u_nome,sexo);
		
		dao.inserirFuncionario(funcionario);
		
		response.status(201);
		
		return "Novo funcionário:   " + funcionario.dataToString();
	}
	
	public Object excluirBD(Request request, Response response) {
		DAO dao = DAO();
		
		dao.conectar();
		
		int codigo = Integer.parseInt(request.queryParams("codigo"));
		Funcionario funcionario = new Funcionario();
		funcionario.setCodigo(codigo);
		dao.excluirFuncionario(funcionario.getCodigo());
		response.status(201);
		
		return "O funcionário identificado por: "+ codigo + " foi removido.";
	}
	
	
	public Object atualizarBD(Request request, Response response) {
		DAO dao = DAO();
		
		dao.conectar();
		
		int codigo = Integer.parseInt(request.queryParams("codigo"));
		int salario = Integer.parseInt(request.queryParams("salario"));
		int departamento = Integer.parseInt(request.queryParams("departamento"));
		String p_nome =  request.queryParams("p_nome");
		String u_nome =  request.queryParams("u_nome");
		char sexo = request.queryParams("sexo").charAt(0);
		
		Funcionario funcionario = new Funcionario(codigo,salario,departamento,p_nome,u_nome,sexo);
		
		dao.atualizarFuncionario(funcionario);
		
		response.status(201);
		
		return "O funcionário identificado por: "+ codigo + " foi atualizado.";
	}

	
}

/*	public Object listarBD(Request request, Response response) {
DAO dao = DAO();

dao.conectar();

StringBuffer returnValue = new StringBuffer("<funcionarios type=\"array\">");
for(Funcionario funcionario : dao.getFuncionarios()) {
	returnValue.append("\n<funcionario>\n" +
			"\t<codigo>" + funcionario.getCodigo() + "</codigo>\n" +
			"\t<salario>" + funcionario.getSalario() + "</salario>\n" +
			"\t<departamento>" + funcionario.getDepartamento() + "</departamento>\n" +
			"\t<primeiro_nome>" + funcionario.getPrimeiroNome() + "</primeiro_nome>\n" +
			"\t<ultimo_nome>" + funcionario.getUltimoNome() + "</ultimo_nome>\n" +
			"\t<sexo>" + funcionario.getSexo() + "</sexo>\n"
			);
	returnValue.append("</funcionarios>");
	response.header("Content-Type", "application/xml");
	response.header("Content-Encoding", "UTF-8");
	
	
}
		
return returnValue.toString();
}*/
