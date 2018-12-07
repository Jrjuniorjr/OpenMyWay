package br.unicap.c3.openmyway.openmyway.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.unicap.c3.openmyway.openmyway.interfacesdao.IUsuarioDAO;
import br.unicap.c3.openmyway.openmyway.model.Usuario;

public class UsuarioService {
	
	@Autowired
	private IUsuarioDAO iUsuarioDAO;
	
	public ResponseEntity<Usuario> consultarUsuarioPorCodigoIdentificacao(String codigoIdentificacao){
	
		Usuario usuario = iUsuarioDAO.findByCodigoIdentificacao(codigoIdentificacao);
		
		if(usuario == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuario);
		}
		
		else {
			return ResponseEntity.ok(usuario);
		}
		
	}
}
