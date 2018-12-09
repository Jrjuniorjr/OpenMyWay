package br.unicap.c3.openmyway.openmyway.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.unicap.c3.openmyway.openmyway.interfacesdao.IAcessoDAO;
import br.unicap.c3.openmyway.openmyway.interfacesdao.IUsuarioDAO;
import br.unicap.c3.openmyway.openmyway.model.Acesso;
import br.unicap.c3.openmyway.openmyway.model.Usuario;
import br.unicap.c3.openmyway.openmyway.dto.*;

@Service
public class AcessoService {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private IAcessoDAO iAcessoDAO;

	public ResponseEntity solicitarAcesso(String codigoIdentificacao) {

		ResponseEntity entity = usuarioService.consultarUsuarioPorCodigoIdentificacao(codigoIdentificacao);

		Usuario usuario = (Usuario) entity.getBody();

		if (usuario == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O usuario não foi encontrado!");

		}

		else {

			Acesso acesso = new Acesso();

			acesso.setUsuario(usuario);

			acesso.converterCalendarToStringAcesso();

			iAcessoDAO.save(acesso);

			return ResponseEntity.ok("Sucesso!");

		}

	}

	public ResponseEntity<List<AcessoDTO>> gerarRelatorioAcesso() {
		List<Acesso> acessos = iAcessoDAO.findAll();
		List<AcessoDTO> acessosDTO = new ArrayList<>();

		if (acessos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(acessosDTO);
		}

		else {
			for (Acesso acesso : acessos) {
				AcessoDTO acessoDTO = new AcessoDTO(acesso.getUsuario().getCpf(),
						acesso.getUsuario().getCodigoIdentificacao(), acesso.getUsuario().getNome(),
						acesso.getUsuario().getSobrenome(), acesso.getData(), acesso.getHora());
				acessosDTO.add(acessoDTO);
			}

			return ResponseEntity.ok(acessosDTO);
		}
	}

	public ResponseEntity<List<AcessoDTO>> gerarRelatorioAcessoPorData(String data) {
		List<Acesso> acessos = iAcessoDAO.findAll();
		List<AcessoDTO> acessosDTO = new ArrayList<>();

		if (acessos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(acessosDTO);
		}

		else {
			for (Acesso acesso : acessos) {
				if (acesso.getData().equals(data)) {
					AcessoDTO acessoDTO = new AcessoDTO(acesso.getUsuario().getCpf(),
							acesso.getUsuario().getCodigoIdentificacao(), acesso.getUsuario().getNome(),
							acesso.getUsuario().getSobrenome(), acesso.getData(), acesso.getHora());
					acessosDTO.add(acessoDTO);
				}
			}

			return ResponseEntity.ok(acessosDTO);
		}
	}
	

}