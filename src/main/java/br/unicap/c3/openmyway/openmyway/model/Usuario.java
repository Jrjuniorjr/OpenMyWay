package br.unicap.c3.openmyway.openmyway.model;

import javax.persistence.*;


@Entity
@Table(name="Usuario")
@PrimaryKeyJoinColumn(name="idPessoa")
public class Usuario {
	
	@Column(name = "matricula", nullable=false)
	private String matricula;
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}	
	
}
