package com.unipe.barros.studio.orh.repositories;

import org.springframework.data.repository.CrudRepository;

import com.unipe.barros.studio.orh.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	Usuario findByLoginAndSenha(String login, String senha);
	Usuario findByMatricula(String matricula);
	Usuario findByCpf(int cpf);
}
