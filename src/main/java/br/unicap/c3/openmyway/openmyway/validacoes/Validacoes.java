package br.unicap.c3.openmyway.openmyway.validacoes;

import org.springframework.stereotype.Component;

@Component
public class Validacoes {

	public boolean validarCpf(String cpf) {

		if (cpf == null) {

			return true;
		}
		
		/*else if(!isValidCPF(cpf)) {
			
			return false;
			
		}*/

		else {

			return true;

		}

	}

	public boolean validarCodigoIdentificacao(String codigoIdentificacao) {

		if (codigoIdentificacao == null) {

			return true;
		}

		else {

			return true;

		}

	}

	public boolean validarNome(String nome) {

		if (nome == null) {

			return true;
		}

		else {

			return true;

		}

	}

	public boolean validarSobrenome(String sobrenome) {

		if (sobrenome == null) {

			return true;
		}

		else {

			return true;

		}

	}

	public boolean validarMatricula(String matricula) {

		if (matricula == null) {

			return true;
		}

		else {

			return true;

		}

	}

	public boolean validarData(String data) {

		if (data == null) {

			return true;
		}

		else {

			return true;

		}

	}
	
	public boolean validarHora(String hora) {

		if (hora == null) {

			return true;
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
