package br.unicap.c3.openmyway.openmyway.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.unicap.c3.openmyway.openmyway.dto.AcessoDTO;
import br.unicap.c3.openmyway.openmyway.dto.UsuarioDTO;
import br.unicap.c3.openmyway.openmyway.interfacesdao.IUsuarioDAO;
import br.unicap.c3.openmyway.openmyway.model.Acesso;
import br.unicap.c3.openmyway.openmyway.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioDAO iUsuarioDAO;

	public ResponseEntity<String> cadastrarUsuario(String cpf, String codigoIdentificacao, String nome,
			String sobrenome) {
		Usuario usuarioPorCodigo = iUsuarioDAO.findByCodigoIdentificacao(codigoIdentificacao);
		Usuario usuarioPorCpf = iUsuarioDAO.findByCpf(cpf);

		if (usuarioPorCodigo != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Usuario com o codigo de identificação passado já cadastrado");
		} else if (usuarioPorCpf != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuario com o cpf passado já cadastrado");
		} else {
			Usuario usuario = new Usuario();
			usuario.setCpf(cpf);
			usuario.setCodigoIdentificacao(codigoIdentificacao);
			usuario.setNome(nome);
			usuario.setSobrenome(sobrenome);
			iUsuarioDAO.save(usuario);
			return ResponseEntity.ok("O usuario foi cadastrado com sucesso!");
		}
	}

	public ResponseEntity<UsuarioDTO> consultarUsuarioPorCodigoIdentificacaoParaExibicao(String codigoIdentificacao) {

		Usuario usuario = iUsuarioDAO.findByCodigoIdentificacao(codigoIdentificacao);

		UsuarioDTO usuarioDTO = null;
		if (usuario == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuarioDTO);
		}

		else {
			usuarioDTO = new UsuarioDTO(usuario.getCpf(), usuario.getCodigoIdentificacao(), usuario.getNome(),
					usuario.getSobrenome());
			return ResponseEntity.ok(usuarioDTO);
		}

	}

	public ResponseEntity<UsuarioDTO> consultarUsuarioPorCpfParaExibicao(String cpf) {
		Usuario usuario = iUsuarioDAO.findByCpf(cpf);
		UsuarioDTO usuarioDTO = null;
		if (usuario == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuarioDTO);
		}

		else {
			usuarioDTO = new UsuarioDTO(usuario.getCpf(), usuario.getCodigoIdentificacao(), usuario.getNome(),
					usuario.getSobrenome());
			return ResponseEntity.ok(usuarioDTO);
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

	public ResponseEntity<String> deletarUsuarioPorCodigoIdentificacao(String codigoIdentificacao) {

		Usuario usuario = iUsuarioDAO.findByCodigoIdentificacao(codigoIdentificacao);

		if (usuario == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado!");
		} else {
			// Pesquisar caso der erro ao deletar
			iUsuarioDAO.delete(usuario);
			return ResponseEntity.ok("O usuario foi deletado com sucesso!");
		}
	}

	public ResponseEntity<String> deletarUsuarioPorCpf(String cpf) {
		Usuario usuario = iUsuarioDAO.findByCpf(cpf);

		if (usuario == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado!");
		} else {
			// Pesquisar caso der erro ao deletar
			iUsuarioDAO.delete(usuario);
			return ResponseEntity.ok("O usuario foi deletado com sucesso!");
		}
	}

	public ResponseEntity<List<AcessoDTO>> gerarRelatorioAcessoPorCodigoIdentificacao(String codigoIdentificacao) {
		Usuario usuario = iUsuarioDAO.findByCodigoIdentificacao(codigoIdentificacao);
		List<AcessoDTO> acessosDTO = new ArrayList<>();

		if (usuario == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(acessosDTO);
		}

		if (usuario.getAcessos().isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(acessosDTO);
		}

		else {
			for (Acesso acesso : usuario.getAcessos()) {
				AcessoDTO acessoDTO = new AcessoDTO(acesso.getUsuario().getCpf(),
						acesso.getUsuario().getCodigoIdentificacao(), acesso.getUsuario().getNome(),
						acesso.getUsuario().getSobrenome(), acesso.getTipoAcesso(), acesso.getData(), acesso.getHora());
				acessosDTO.add(acessoDTO);
			}

			return ResponseEntity.ok(acessosDTO);
		}
	}
	
	public ResponseEntity<List<AcessoDTO>> gerarRelatorioAcessoPorCpf(String cpf) {
		Usuario usuario = iUsuarioDAO.findByCpf(cpf);
		List<AcessoDTO> acessosDTO = new ArrayList<>();

		if (usuario == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(acessosDTO);
		}

		if (usuario.getAcessos().isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(acessosDTO);
		}

		else {
			for (Acesso acesso : usuario.getAcessos()) {
				AcessoDTO acessoDTO = new AcessoDTO(acesso.getUsuario().getCpf(),
						acesso.getUsuario().getCodigoIdentificacao(), acesso.getUsuario().getNome(),
						acesso.getUsuario().getSobrenome(), acesso.getTipoAcesso(), acesso.getData(), acesso.getHora());
				acessosDTO.add(acessoDTO);
			}

			return ResponseEntity.ok(acessosDTO);
		}
	}
}
