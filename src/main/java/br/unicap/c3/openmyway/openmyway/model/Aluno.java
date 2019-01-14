package br.unicap.c3.openmyway.openmyway.model;

import javax.persistence.*;

@Entity
public class Aluno extends Usuario{
	
	@Column (name = "matricula", nullable=false, unique=true)
	private String matricula;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
}
