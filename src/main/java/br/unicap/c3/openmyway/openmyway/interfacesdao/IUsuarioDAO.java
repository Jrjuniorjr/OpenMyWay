package br.unicap.c3.openmyway.openmyway.interfacesdao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicap.c3.openmyway.openmyway.model.Usuario;


public interface IUsuarioDAO extends JpaRepository<Usuario, Integer>{
	public Usuario findByCodigoIdentificacao(String codigoIdentificacao);
	public Usuario findByCpf(String cpf);
}
