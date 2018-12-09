package br.unicap.c3.openmyway.openmyway.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.unicap.c3.openmyway.openmyway.interfacesdao.IUsuarioDAO;
import br.unicap.c3.openmyway.openmyway.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioDAO iUsuarioDAO;

	public ResponseEntity cadastrarUsuario(String cpf, String codigoIdentificacao, String nome, String sobrenome) {
		Usuario usuario = iUsuarioDAO.findByCodigoIdentificacao(codigoIdentificacao);

		if (usuario != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuario já cadastrado");
		} else {
			usuario = new Usuario();
			usuario.setCpf(cpf);
			usuario.setCodigoIdentificacao(codigoIdentificacao);
			usuario.setNome(nome);
			usuario.setSobrenome(sobrenome);
			iUsuarioDAO.save(usuario);
			return ResponseEntity.ok("O usuario foi cadastrado com sucesso!");
		}
	}

	public ResponseEntity<Usuario> consultarUsuarioPorCodigoIdentificacao(String codigoIdentificacao) {

		Usuario usuario = iUsuarioDAO.findByCodigoIdentificacao(codigoIdentificacao);

		if (usuario == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuario);
		}

		else {
			return ResponseEntity.ok(usuario);
		}

	}

	public ResponseEntity<Usuario> consultarUsuarioPorCpf(String cpf) {
		Usuario usuario = iUsuarioDAO.findByCpf(cpf);

		if (usuario == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuario);
		}

		else {
			return ResponseEntity.ok(usuario);
		}

	}

	public ResponseEntity deletarUsuarioPorCodigoIdentificacao(String codigoIdentificacao) {

		Usuario usuario = iUsuarioDAO.findByCodigoIdentificacao(codigoIdentificacao);

		if (usuario == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado!");
		} else {
			// Pesquisar caso der erro ao deletar
			iUsuarioDAO.delete(usuario);
			return ResponseEntity.ok("O usuario foi deletado com sucesso!");
		}
	}

	public ResponseEntity deletarUsuarioPorCpf(String cpf) {
		Usuario usuario = iUsuarioDAO.findByCpf(cpf);

		if (usuario == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado!");
		} else {
			// Pesquisar caso der erro ao deletar
			iUsuarioDAO.delete(usuario);
			return ResponseEntity.ok("O usuario foi deletado com sucesso!");
		}
	}
}
