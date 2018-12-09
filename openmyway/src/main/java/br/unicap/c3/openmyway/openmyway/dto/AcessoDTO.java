package br.unicap.c3.openmyway.openmyway.dto;

public class AcessoDTO {
	private String cpf;
	private String codigoIdentificacao;
	private String nomeUsuario;
	private String sobrenomeUsuario;
	private String data;
	private String hora;
	
	public AcessoDTO(String cpf, String codigoIdentificacao, String nomeUsuario, String sobrenomeUsuario, String data,
			String hora) {
		super();
		this.cpf = cpf;
		this.codigoIdentificacao = codigoIdentificacao;
		this.nomeUsuario = nomeUsuario;
		this.sobrenomeUsuario = sobrenomeUsuario;
		this.data = data;
		this.hora = hora;
	}
	
	public AcessoDTO() {
		
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
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
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSobrenomeUsuario() {
		return sobrenomeUsuario;
	}
	public void setSobrenomeUsuario(String sobrenomeUsuario) {
		this.sobrenomeUsuario = sobrenomeUsuario;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
}
