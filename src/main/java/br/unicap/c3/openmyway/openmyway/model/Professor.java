package br.unicap.c3.openmyway.openmyway.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity

public class Professor extends Usuario{

	@Column (name = "cfe", nullable = false, unique = true)
	private String cfe;

	public String getCfe() {
		return cfe;
	}

	public void setCfe(String cfe) {
		this.cfe = cfe;
	}
	
	
}
