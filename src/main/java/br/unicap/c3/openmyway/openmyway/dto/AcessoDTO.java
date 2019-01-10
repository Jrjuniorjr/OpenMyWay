package br.unicap.c3.openmyway.openmyway.dto;

import br.unicap.c3.openmyway.openmyway.model.TipoAcesso;

public class AcessoDTO {
	private String cpf;
	private String codigoIdentificacao;
	private String nomeUsuario;
	private String sobrenomeUsuario;
	/*
	 * Comentado o enum, pois o postgresql não tem enum.
	 */
	private TipoAcesso tipoAcesso;
	/*
	 * Só utilizar se tiver com postgresql private String tipoAcesso;
	 */
	private String data;
	private String hora;

	public AcessoDTO(String cpf, String codigoIdentificacao, String nomeUsuario, String sobrenomeUsuario,
			TipoAcesso tipoAcesso, String data, String hora) {
		super();
		this.cpf = cpf;
		this.codigoIdentificacao = codigoIdentificacao;
		this.nomeUsuario = nomeUsuario;
		this.sobrenomeUsuario = sobrenomeUsuario;
		this.tipoAcesso = tipoAcesso;
		this.data = data;
		this.hora = hora;
	}

	public AcessoDTO() {

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

	public String getNomeUsuario() {
		return nomeUsuario;
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

	public TipoAcesso getTipoAcesso() {
		return tipoAcesso;
	}

	public void setTipoAcesso(TipoAcesso tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}

	/*
	 * public String getTipoAcesso() { return tipoAcesso; }
	 * 
	 * 
	 * public void setTipoAcesso(String tipoAcesso) { this.tipoAcesso = tipoAcesso;
	 * }
	 */

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
