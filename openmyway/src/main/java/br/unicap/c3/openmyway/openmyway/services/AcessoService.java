package br.unicap.c3.openmyway.openmyway.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.unicap.c3.openmyway.openmyway.interfacesdao.IAcessoDAO;
import br.unicap.c3.openmyway.openmyway.interfacesdao.IUsuarioDAO;
import br.unicap.c3.openmyway.openmyway.model.Acesso;
import br.unicap.c3.openmyway.openmyway.model.Usuario;

public class AcessoService {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private IAcessoDAO iAcessoDAO;
	
	public ResponseEntity acessar(String codigoIdentificacao) {
		
		ResponseEntity entity = usuarioService.consultarUsuarioPorCodigoIdentificacao(codigoIdentificacao);
		
		Usuario usuario = (Usuario) entity.getBody();
		
		if(usuario == null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		}
		
		else {
			
			Acesso acesso = new Acesso();
			
			acesso.setUsuario(usuario);
			
			acesso.converterCalendarToStringAcesso();
			
			iAcessoDAO.save(acesso);
			
			return ResponseEntity.ok("Sucesso!");
			
		}
		
	}
}
