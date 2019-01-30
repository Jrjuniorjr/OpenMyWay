package br.unicap.c3.openmyway.openmyway.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.unicap.c3.openmyway.openmyway.interfacesdao.IAcessoDAO;
import br.unicap.c3.openmyway.openmyway.model.Acesso;
import br.unicap.c3.openmyway.openmyway.model.Usuario;
import br.unicap.c3.openmyway.openmyway.validacoes.Validacoes;
import br.unicap.c3.openmyway.openmyway.model.TipoAcesso;

@Service
public class AcessoService {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private IAcessoDAO iAcessoDAO;

	@Autowired
	private Validacoes validacoes;

	public ResponseEntity<?> solicitarAcessoEntrada(String codigoIdentificacao) {

		if (!validacoes.validarCodigoIdentificacao(codigoIdentificacao)) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Codigo de identificacao invalido.");

		}

		ResponseEntity<?> entity = usuarioService.consultarUsuarioPorCodigoIdentificacao(codigoIdentificacao);

		if (entity.getStatusCode() != HttpStatus.OK) {

			return entity;
		}

		Usuario usuario = (Usuario) entity.getBody();

		if (usuario == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado.");

		}

		else {

			Acesso acesso = new Acesso();

			acesso.setUsuario(usuario);
			;

			// acesso.setTipoAcesso(TipoAcesso.Entrada);

			acesso.setTipoAcesso("Entrada");

			acesso.converterCalendarToStringAcesso();

			iAcessoDAO.save(acesso);

			return ResponseEntity.ok().body("Bem vindo!");

		}

	}

	public ResponseEntity<?> solicitarAcessoSaida(String codigoIdentificacao) {

		if (!validacoes.validarCodigoIdentificacao(codigoIdentificacao)) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Codigo de identificacao invalido.");

		}

		ResponseEntity<?> entity = usuarioService.consultarUsuarioPorCodigoIdentificacao(codigoIdentificacao);

		if (entity.getStatusCode() != HttpStatus.OK) {
			return entity;
		}

		Usuario usuario = (Usuario) entity.getBody();

		if (usuario == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado.");

		}

		else {

			Acesso acesso = new Acesso();

			acesso.setUsuario(usuario);

			// acesso.setTipoAcesso(TipoAcesso.Saida);

			acesso.setTipoAcesso("Saida");

			acesso.converterCalendarToStringAcesso();

			iAcessoDAO.save(acesso);

			return ResponseEntity.ok().body("Ate a proxima!");

		}

	}

	public ResponseEntity<List<Acesso>> gerarRelatorioAcesso() {

		List<Acesso> acessos = iAcessoDAO.findAll();

		if (acessos.isEmpty()) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(acessos);

		}

		else {

			for (Acesso acesso : acessos) {

				acesso.getUsuario().setAcessos(null);

			}

			return ResponseEntity.ok(acessos);

		}
	}

	public ResponseEntity<?> gerarRelatorioAcessoPorData(String data) {

		if (!validacoes.validarData(data)) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Data invalida.");

		}

		List<Acesso> acessos = iAcessoDAO.findByData(data);

		if (acessos.isEmpty()) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(acessos);

		}

		for (Acesso acesso : acessos) {

			acesso.getUsuario().setAcessos(null);

		}

		return ResponseEntity.ok(acessos);

	}

	public ResponseEntity<?> gerarRelatorioAcessosPorDataEHora(String data, String hora) {

		if (!validacoes.validarData(data)) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Data invalida.");

		}

		if (!validacoes.validarHora(hora)) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Hora invalida.");

		}

		List<Acesso> acessos = iAcessoDAO.findByDataInAndHoraIn(data, hora);

		if (acessos.isEmpty()) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(acessos);

		}

		for (Acesso acesso : acessos) {

			acesso.getUsuario().setAcessos(null);

		}

		return ResponseEntity.ok(acessos);

	}

}
