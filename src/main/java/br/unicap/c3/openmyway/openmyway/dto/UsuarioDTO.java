package br.unicap.c3.openmyway.openmyway.dto;

public class UsuarioDTO {
	private String cpf;
	private String codigoIdentificacao;
	private String nome;
	private String sobrenome;
	
	
	public UsuarioDTO(String cpf, String codigoIdentificacao, String nome, String sobrenome) {
		super();
		this.cpf = cpf;
		this.codigoIdentificacao = codigoIdentificacao;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}


	public UsuarioDTO() {
		
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getCodigoIdentificacao() {
		return codigoIdentificacao;
	}


	public void setCodigoIdentificacao(String codigoIdentificacao) {
		this.codigoIdentificacao = codigoIdentificacao;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSobrenome() {
		return sobrenome;
	}


	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	
}
