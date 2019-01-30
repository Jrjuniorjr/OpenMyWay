package br.unicap.c3.openmyway.openmyway.validacoes;

import org.springframework.stereotype.Component;

@Component
public class Validacoes {
	
	private ResponseEntity<String> validarCadastro(Usuario usuario) {
	
		if (!validacoes.validarCpf(usuario.getCpf())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("CPF invalido.");

		}

		if (!validacoes.validarCodigoIdentificacao(usuario.getCodigoIdentificacao())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Codigo de identificacao invalido.");

		}

		if (!validacoes.validarNome(usuario.getNome())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Nome invalido.");

		}

		if (!validacoes.validarSobrenome(usuario.getSobrenome())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Sobrenome invalido.");

		}

		Usuario usuarioPorCodigo = iUsuarioDAO.findByCodigoIdentificacao(usuario.getCodigoIdentificacao());

		Usuario usuarioPorCpf = iUsuarioDAO.findByCpf(usuario.getCpf());

		if (usuarioPorCodigo != null) {

			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Usuario com o codigo de identificacao passado ja cadastrado.");

		} else if (usuarioPorCpf != null) {

			return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuario com o cpf passado ja cadastrado.");

		}

		else {

			return ResponseEntity.ok().build();
		}

	}

	public boolean validarCpf(String cpf) {

		if (cpf == null) {

			return false;
		}
		
		else if(!isValidCPF(cpf)) {
			
			return false;
			
		}

		else {

			return true;

		}

	}

	public boolean validarCodigoIdentificacao(String codigoIdentificacao) {

		if (codigoIdentificacao == null) {

			return false;
		}

		else {

			return true;

		}

	}

	public boolean validarNome(String nome) {

		if (nome == null) {

			return false;
		}

		else {

			return true;

		}

	}

	public boolean validarSobrenome(String sobrenome) {

		if (sobrenome == null) {

			return false;
		}

		else {

			return true;

		}

	}

	public boolean validarMatricula(String matricula) {

		if (matricula == null) {

			return false;
		}

		else {

			return true;

		}

	}
	
	public boolean validarTipoUsuarioIntegranteUniversidade(String tipoUsuario){
	
		/*
		if(tipoUsuario == null){
		
			return false;
			
		}
		
		else if(tipoUsuario != TipoUsuario.Aluno  && tipoUsuario != TipoUsuario.Funcionario
			&& tipoUsuario != TipoUsuario.Professor){
			
			return false;
		
		}
		
		else{
		
			return true;
			
		}*/
		
		if(tipoUsuario == null){
		
			return false;
			
		}
		
		else if(!tipoUsuario.equals("Aluno") && !tipoUsuario.equals("Funcionario")
			&& !tipoUsuario.equals("Professor")){
			
			return false;
		
		}
		
		else{
		
			return true;
			
		}
		
	}

	public boolean validarData(String data) {

		if (data == null) {

			return false;
		}

		else {

			return true;

		}

	}
	
	public boolean validarHora(String hora) {

		if (hora == null) {

			return false;
		}

		else {

			return true;

		}

	}

	private int calcularDigito(String cpf) {

		int[] peso = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

		int soma = 0;

		for (int indice = cpf.length() - 1, digito; indice >= 0; indice--) {

			digito = Integer.parseInt(cpf.substring(indice, indice + 1));

			soma += digito * peso[peso.length - cpf.length() + indice];

		}
		soma = 11 - soma % 11;

		return soma > 9 ? 0 : soma;
	}

	public boolean isValidCPF(String cpf) {

		if ((cpf == null) || (cpf.length() != 11)) {
		
			return false;
		
		}

		Integer digito1 = calcularDigito(cpf.substring(0, 9));

		Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1);

		return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());

	}
	
}
