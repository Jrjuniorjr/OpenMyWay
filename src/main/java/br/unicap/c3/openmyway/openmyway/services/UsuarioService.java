package br.unicap.c3.openmyway.openmyway.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.unicap.c3.openmyway.openmyway.interfacesdao.IUsuarioDAO;
import br.unicap.c3.openmyway.openmyway.model.Acesso;
import br.unicap.c3.openmyway.openmyway.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioDAO iUsuarioDAO;

	private boolean validarCpf(String cpf) {

		if (cpf == null) {

			return false;
		}

		else {

			return true;

		}

	}

	private boolean validarCodigoIdentificacao(String codigoIdentificacao) {

		if (codigoIdentificacao == null) {

			return false;
		}

		else {

			return true;

		}

	}

	private boolean validarNome(String nome) {

		if (nome == null) {

			return false;
		}

		else {

			return true;

		}

	}

	private boolean validarSobrenome(String sobrenome) {

		if (sobrenome == null) {

			return false;
		}

		else {

			return true;

		}

	}

	public ResponseEntity<String> cadastrarUsuario(Usuario usuario) {

		if (!validarCpf(usuario.getCpf())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("CPF invalido.");

		}

		if (!validarCodigoIdentificacao(usuario.getCodigoIdentificacao())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Codigo de identificacao invalido.");

		}

		if (!validarNome(usuario.getNome())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Nome invalido.");

		}

		if (!validarSobrenome(usuario.getSobrenome())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Sobrenome invalido.");

		}
		
		Usuario usuarioPorCodigo = iUsuarioDAO.findByCodigoIdentificacao(usuario.getCodigoIdentificacao());

		Usuario usuarioPorCpf = iUsuarioDAO.findByCpf(usuario.getCpf());

		if (usuarioPorCodigo != null) {

			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Usuario com o codigo de identificacao passado ja cadastrado.");

		} else if (usuarioPorCpf != null) {

			return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuario com o cpf passado ja cadastrado.");

		} else {

			iUsuarioDAO.save(usuario);

			return ResponseEntity.ok("O usuario foi cadastrado com sucesso.");

		}

	}

	public ResponseEntity<String> alterarUsuario(Usuario usuario){
	
		if(!validarCpf(usuario.getCpf())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("CPF invalido.");

		}

		if (!validarCodigoIdentificacao(usuario.getCodigoIdentificacao())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Codigo de identificacao invalido.");

		}

		if (!validarNome(usuario.getNome())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Nome invalido.");

		}

		if (!validarSobrenome(usuario.getSobrenome())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Sobrenome invalido.");

		}

		iUsuarioDAO.save(usuario);

		return ResponseEntity.ok("O usuario foi alterado com sucesso.");
		
	}
	
	public ResponseEntity<?> consultarUsuarioPorCodigoIdentificacao(String codigoIdentificacao) {

		if(!validarCodigoIdentificacao(codigoIdentificacao)) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Codigo de identificacao invalido.");

			
		}
		
		Usuario usuario = iUsuarioDAO.findByCodigoIdentificacao(codigoIdentificacao);

		if (usuario == null) {
		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado.");
		
		}

		return ResponseEntity.ok(usuario);

	}

	public ResponseEntity<?> consultarUsuarioPorCpf(String cpf) {
		
		if(!validarCpf(cpf)) {
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("CPF invalido.");
			
		}
		
		Usuario usuario = iUsuarioDAO.findByCpf(cpf);
				
		if (usuario == null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado.");
		
		}
		
		return ResponseEntity.ok(usuario);
		
	}


	public ResponseEntity<String> deletarUsuarioPorCodigoIdentificacao(String codigoIdentificacao) {

		if(!validarCodigoIdentificacao(codigoIdentificacao)) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Codigo de identificacao invalido.");

		}
		
		Usuario usuario = iUsuarioDAO.findByCodigoIdentificacao(codigoIdentificacao);

		if (usuario == null) {
		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado.");
		
		} else {

			iUsuarioDAO.delete(usuario);
			
			return ResponseEntity.ok("O usuario foi deletado com sucesso!");
		
		}
	
	}

	public ResponseEntity<String> deletarUsuarioPorCpf(String cpf) {

		if(!validarCpf(cpf)) {
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("CPF invalido.");
			
		}	
		
		Usuario usuario = iUsuarioDAO.findByCpf(cpf);

		if (usuario == null) {
		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado.");
		
		} else {
			
			iUsuarioDAO.delete(usuario);
		
			return ResponseEntity.ok("O usuario foi deletado com sucesso.");
	
		}

	}

	public ResponseEntity<?> gerarRelatorioAcessoPorCodigoIdentificacao(String codigoIdentificacao) {
		
		if(!validarCodigoIdentificacao(codigoIdentificacao)) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Codigo de identificacao invalido.");

		}
		
		Usuario usuario = iUsuarioDAO.findByCodigoIdentificacao(codigoIdentificacao);
		
		if (usuario == null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado.");
		
		}

		if (usuario.getAcessos().isEmpty()) {
		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao possui acessos.");
		
		}

		else {
			
			return ResponseEntity.ok(usuario.getAcessos());
	
		}
	
	}

	public ResponseEntity<?> gerarRelatorioAcessoPorCpf(String cpf) {

		if(!validarCpf(cpf)) {
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("CPF invalido.");
			
		}	
		
		Usuario usuario = iUsuarioDAO.findByCpf(cpf);
		
		if (usuario == null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado.");
		
		}

		if (usuario.getAcessos().isEmpty()) {
		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao possui acessos.");
		
		}

		else {
			
			return ResponseEntity.ok(usuario.getAcessos());
	
		}
	
	}
	
}
