package br.unicap.c3.openmyway.openmyway.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.unicap.c3.openmyway.openmyway.interfacesdao.IUsuarioDAO;
import br.unicap.c3.openmyway.openmyway.model.IntegranteUniversidade;
import br.unicap.c3.openmyway.openmyway.model.*;
import br.unicap.c3.openmyway.openmyway.validacoes.Validacoes;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioDAO iUsuarioDAO;

	@Autowired
	private Validacoes validacoes;

	public ResponseEntity<String> cadastrarUsuario(Usuario usuario) {

		ResponseEntity entity = validacoes.validarCadastro(usuario);

		if (entity.getStatusCode() != HttpStatus.OK) {

			return entity;

		}

		else {

			/*
			 * Comentado apenas para o uso de postgresql
			 * usuario.setTipoUsuario(TipoUsuario.Convidado);
			 */

			usuario.setTipoUsuario("Convidado");

			iUsuarioDAO.save(usuario);

			return ResponseEntity.ok("O usuario foi cadastrado com sucesso.");

		}

	}

	public ResponseEntity<String> cadastrarIntegranteUniversidade(IntegranteUniversidade integranteUniversidade) {

		ResponseEntity entity = validacoes.validarCadastro(integranteUniversidade);

		if (entity.getStatusCode() != HttpStatus.OK) {

			return entity;

		}

		else if (!validacoes.validarMatricula(integranteUniversidade.getMatricula())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Matricula invalida.");

		}

		else if (!validacoes.validarTipoUsuarioIntegranteUniversidade(integranteUniversidade.getTipoUsuario())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Tipo usuario invalido.");

		}

		else {

			iUsuarioDAO.save(integranteUniversidade);

			return ResponseEntity.ok("O usuario foi cadastrado com sucesso.");

		}

	}

	public ResponseEntity<String> alterarUsuario(Usuario usuario) {

		if (!validacoes.validarCpf(usuario.getCpf())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("CPF invalido.");

		}

		if (!validacoes.validarCodigoIdentificacao(usuario.getCodigoIdentificacao())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Codigo de identificacao invalido.");

		}

		if (!validacoes.validarNome(usuario.getNome())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Nome invalido.");

		}

		if (!validacoes.validarSobrenome(usuario.getSobrenome())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Sobrenome invalido.");

		}

		iUsuarioDAO.save(usuario);

		return ResponseEntity.ok("O usuario foi alterado com sucesso.");

	}

	public ResponseEntity<String> alterarIntegranteUniversidade(IntegranteUniversidade integranteUniversidade) {

		if (!validacoes.validarCpf(integranteUniversidade.getCpf())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("CPF invalido.");

		}

		if (!validacoes.validarCodigoIdentificacao(integranteUniversidade.getCodigoIdentificacao())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Codigo de identificacao invalido.");

		}

		if (!validacoes.validarNome(integranteUniversidade.getNome())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Nome invalido.");

		}

		if (!validacoes.validarSobrenome(integranteUniversidade.getSobrenome())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Sobrenome invalido.");

		}

		if (!validacoes.validarMatricula(integranteUniversidade.getMatricula())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Matricula invalida.");

		}

		iUsuarioDAO.save(integranteUniversidade);

		return ResponseEntity.ok("O usuario foi alterado com sucesso.");

	}

	public ResponseEntity<?> consultarUsuarioPorCodigoIdentificacao(String codigoIdentificacao) {

		if (!validacoes.validarCodigoIdentificacao(codigoIdentificacao)) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Codigo de identificacao invalido.");

		}

		Usuario usuario = iUsuarioDAO.findByCodigoIdentificacao(codigoIdentificacao);

		if (usuario == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado.");

		}

		return ResponseEntity.ok(usuario);

	}

	public ResponseEntity<?> consultarUsuarioPorCpf(String cpf) {

		if (!validacoes.validarCpf(cpf)) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("CPF invalido.");

		}

		Usuario usuario = iUsuarioDAO.findByCpf(cpf);

		if (usuario == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado.");

		}

		return ResponseEntity.ok(usuario);

	}

	public ResponseEntity<String> deletarUsuarioPorCodigoIdentificacao(String codigoIdentificacao) {

		if (!validacoes.validarCodigoIdentificacao(codigoIdentificacao)) {

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

		if (!validacoes.validarCpf(cpf)) {

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

	public ResponseEntity<List<Usuario>> listarUsuarios() {

		List<Usuario> usuarios = iUsuarioDAO.findAll();

		if (usuarios.isEmpty()) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuarios);

		}

		else {

			for (Usuario usuario : usuarios) {

				for (Acesso acesso : usuario.getAcessos()) {

					acesso.setUsuario(null);

				}

			}

			return ResponseEntity.ok(usuarios);

		}

	}

	public ResponseEntity<?> gerarRelatorioAcessoPorCodigoIdentificacao(String codigoIdentificacao) {

		if (!validacoes.validarCodigoIdentificacao(codigoIdentificacao)) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Codigo de identificacao invalido.");

		}

		Usuario usuario = iUsuarioDAO.findByCodigoIdentificacao(codigoIdentificacao);

		if (usuario == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado.");

		}

		if (usuario.getAcessos().isEmpty()) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuario);

		}

		else {

			for (Acesso acesso : usuario.getAcessos()) {

				acesso.setUsuario(null);

			}

			return ResponseEntity.ok(usuario);

		}

	}

	public ResponseEntity<?> gerarRelatorioAcessoPorCpf(String cpf) {

		if (!validacoes.validarCpf(cpf)) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("CPF invalido.");

		}

		Usuario usuario = iUsuarioDAO.findByCpf(cpf);

		if (usuario == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado.");

		}

		if (usuario.getAcessos().isEmpty()) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuario);

		}

		else {

			for (Acesso acesso : usuario.getAcessos()) {

				acesso.setUsuario(null);

			}

			return ResponseEntity.ok(usuario);

		}

	}

}
