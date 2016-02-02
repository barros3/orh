package com.unipe.barros.studio.orh.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.unipe.barros.studio.orh.enums.EnumPermissoes;

@Entity
@Table(name="tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Coloca um login porra")
	private String login;

	@NotEmpty(message = "Coloca uma senha porra")
	private String senha;

	@NotEmpty(message = "Coloca uma nome porra")
	private String nome;

	private String telefone;

	private String email;

	private String celular;

	private int cpf;

	private String rg;

	private String matricula;

	private String cpts;

	@Temporal(value=TemporalType.TIMESTAMP)
	@DateTimeFormat(style="dd/MM/yyyy")
	private Date dataAdmissao;

	@Enumerated(EnumType.STRING)
	private EnumPermissoes permissao;
	
	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER, orphanRemoval = true)
	private Endereco endereco;
	
	@ManyToMany
	private List<Aviso> avisoList = new ArrayList<Aviso>();

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public EnumPermissoes getPermissao() {
		return permissao;
	}

	public void setPermissao(EnumPermissoes permissao) {
		this.permissao = permissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpts() {
		return cpts;
	}

	public void setCpts(String cpts) {
		this.cpts = cpts;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Aviso> getAvisoList() {
		return avisoList;
	}

	public void setAvisoList(List<Aviso> avisoList) {
		this.avisoList = avisoList;
	}
	
}
