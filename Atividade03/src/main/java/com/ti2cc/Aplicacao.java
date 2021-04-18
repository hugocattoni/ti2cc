package com.ti2cc;
import static spark.Spark.*;

	public class Aplicacao {
		
		private static Principal funcionarioService = new Principal();
		
		public static void main(String[] args){
			port(4567);
			post("/funcionario", (request, response) -> funcionarioService.inserirBD(request, response));
			get("/funcionarios", (request, response) -> funcionarioService.listarBD(request, response));
			get("/funcionario/delete/", (request, response) -> funcionarioService.excluirBD(request, response));
			get("/funcionario/update/", (request, response) -> funcionarioService.atualizarBD(request, response)); 

		}
}