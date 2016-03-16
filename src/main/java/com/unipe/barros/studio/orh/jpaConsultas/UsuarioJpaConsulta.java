package com.unipe.barros.studio.orh.jpaConsultas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unipe.barros.studio.orh.models.Usuario;

public interface UsuarioJpaConsulta extends JpaRepository<Usuario, Integer> {

	@Query("select u from Usuario u where u.login = :login and u.senha = :senha")
	Usuario findByLoginAndSenha(@Param("login") String login, @Param("senha") String senha);
	
	@Query("select u from Usuario u where u.matricula = ?1")
	Usuario findByMatricula(String matricula);

	@Query("select u from Usuario u where u.cpf = ?1")
	Usuario findByCpf(int cpf);

	@Query("select u from Usuario u where u.nome = ?1")
	Usuario findByNome(String nome);

	@Query("select u from Usuario u where u.nome = :nome and u.matricula = :matricula")
	Usuario findByNomeMatricula(@Param("nome") String nome, @Param("matricula") String matricula);
	
	@Query("select u from Usuario u where u.nome = :nome and u.cpf = :cpf")
	Usuario findByNomeCpf(@Param("nome") String nome, @Param("cpf") Integer cpf);
	
	@Query("select u from Usuario u where u.matricula = :matricula and u.cpf = :cpf")
	Usuario findByMatriculaCpf(@Param("matricula") String matricula, @Param("cpf")  int cpf);
	
	@Query("select u from Usuario u where u.nome = :nome and u.matricula = :matricula and u.cpf = :cpf")
	Usuario findByNomeMatriculaCpf(@Param("nome") String nome, @Param("matricula") String matricula, @Param("cpf") int cpf);

}
