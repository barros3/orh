package com.unipe.barros.studio.orh.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.unipe.barros.studio.orh.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	
	Usuario findByLoginAndSenha(String login, String senha);
	
	@Query("select u from Usuario u where u.nome = ?1")
	List<Usuario> findByNome(String nome);

	@Query("select u from Usuario u where u.matricula = ?1")
	List<Usuario> findByMatricula(String matricula);

	@Query("select u from Usuario u where u.cpf = ?1")
	List<Usuario> findByCpf(int cpf);

	@Query("select u from Usuario u where u.nome = ?1 and u.matricula = ?2")
	List<Usuario> findByNomeMatricula(@Param("nome") String nome, @Param("matricula") String matricula);
	
	@Query("select u from Usuario u where u.nome = ?1 and u.cpf = ?2")
	List<Usuario> findByNomeCpf(@Param("nome") String nome, @Param("cpf") Integer cpf);
	
	@Query("select u from Usuario u where u.matricula = ?1 and u.cpf = ?2")
	List<Usuario> findByMatriculaCpf(@Param("matricula") String matricula, @Param("cpf")  int cpf);
	
	@Query("select u from Usuario u where u.nome = ?1 and u.matricula = ?2 and u.cpf = ?3")
	List<Usuario> findByNomeMatriculaCpf(@Param("nome") String nome, @Param("matricula") String matricula, @Param("cpf") int cpf);

}
