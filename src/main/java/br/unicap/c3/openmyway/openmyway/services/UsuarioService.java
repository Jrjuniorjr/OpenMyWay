package br.unicap.c3.openmyway.openmyway.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.unicap.c3.openmyway.openmyway.interfacesdao.IUsuarioDAO;
import br.unicap.c3.openmyway.openmyway.model.IntegranteUniversidade;
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

	private boolean validarMatricula(String matricula) {

		if (matricula == null) {

			return false;
		}

		else {

			return true;

		}

	}

	public ResponseEntity<String> validarCadastro(Usuario usuario) {

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

		}

		else {

			return ResponseEntity.ok().build();
		}

	}

	public ResponseEntity<String> cadastrarUsuario(Usuario usuario) {

		ResponseEntity entity = validarCadastro(usuario);

		if (entity.getStatusCode() != HttpStatus.OK) {

			return entity;

		}

		else {

			iUsuarioDAO.save(usuario);

			return ResponseEntity.ok("O usuario foi cadastrado com sucesso.");

		}

	}

	public ResponseEntity<String> cadastrarIntegranteUniversidade(IntegranteUniversidade integranteUniversidade) {

		ResponseEntity entity = validarCadastro(integranteUniversidade);

		if (entity.getStatusCode() != HttpStatus.OK) {

			return entity;

		}

		else if (!validarMatricula(integranteUniversidade.getMatricula())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Matricula invalida.");

		}

		else {

			iUsuarioDAO.save(integranteUniversidade);

			return ResponseEntity.ok("O usuario foi cadastrado com sucesso.");

		}

	}

	public ResponseEntity<String> alterarUsuario(Usuario usuario) {

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

		iUsuarioDAO.save(usuario);

		return ResponseEntity.ok("O usuario foi alterado com sucesso.");

	}

	public ResponseEntity<String> alterarIntegranteUniversidade(IntegranteUniversidade integranteUniversidade) {

		if (!validarCpf(integranteUniversidade.getCpf())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("CPF invalido.");

		}

		if (!validarCodigoIdentificacao(integranteUniversidade.getCodigoIdentificacao())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Codigo de identificacao invalido.");

		}

		if (!validarNome(integranteUniversidade.getNome())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Nome invalido.");

		}

		if (!validarSobrenome(integranteUniversidade.getSobrenome())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Sobrenome invalido.");

		}
		
		if (!validarMatricula(integranteUniversidade.getMatricula())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Matricula invalida.");

		}
		
		iUsuarioDAO.save(integranteUniversidade);

		return ResponseEntity.ok("O usuario foi alterado com sucesso.");

	}
	
	public ResponseEntity<?> consultarUsuarioPorCodigoIdentificacao(String codigoIdentificacao) {

		if (!validarCodigoIdentificacao(codigoIdentificacao)) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Codigo de identificacao invalido.");

		}

		Usuario usuario = iUsuarioDAO.findByCodigoIdentificacao(codigoIdentificacao);

		if (usuario == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado.");

		}

		return ResponseEntity.ok(usuario);

	}

	public ResponseEntity<?> consultarUsuarioPorCpf(String cpf) {

		if (!validarCpf(cpf)) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("CPF invalido.");

		}

		Usuario usuario = iUsuarioDAO.findByCpf(cpf);

		if (usuario == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado.");

		}

		return ResponseEntity.ok(usuario);

	}

	public ResponseEntity<String> deletarUsuarioPorCodigoIdentificacao(String codigoIdentificacao) {

		if (!validarCodigoIdentificacao(codigoIdentificacao)) {

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

		if (!validarCpf(cpf)) {

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

		if (!validarCodigoIdentificacao(codigoIdentificacao)) {

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

			return ResponseEntity.ok(usuario);

		}

	}

	public ResponseEntity<?> gerarRelatorioAcessoPorCpf(String cpf) {

		if (!validarCpf(cpf)) {

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

			return ResponseEntity.ok(usuario);

		}

	}

}
