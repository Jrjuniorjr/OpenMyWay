package br.unicap.c3.openmyway.openmyway.model;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="Usuario")
public class Usuario {

	@Id 
	@Column (name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "cpf", unique=true)
	private String cpf;
	
	@Column (name = "codigoIdentificacao", unique=true)
	private String codigoIdentificacao;
	

	@Column (name = "nome")
	private String nome;
	
	@Column (name = "sobrenome")
	private String sobrenome;
	
	@OneToMany (mappedBy = "usuario",
			fetch=FetchType.LAZY)
	private List<Acesso> acessos;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<Acesso> getAcessos() {
		return acessos;
	}

	public void setAcessos(List<Acesso> acessos) {
		this.acessos = acessos;
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
