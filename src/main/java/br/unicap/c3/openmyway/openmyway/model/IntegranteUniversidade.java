package br.unicap.c3.openmyway.openmyway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="IntegranteUniversidade")
@PrimaryKeyJoinColumn(name="idUsuario")
public class IntegranteUniversidade extends Usuario{

	@Column(name="matricula", nullable=false, unique=true)
	private String matricula;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
}
