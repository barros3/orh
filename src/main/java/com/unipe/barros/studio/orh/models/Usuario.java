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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
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
	
	@Email
	private String email;

//	@Pattern(regexp = "\\(?\\b([0-9]{2})\\)?[-. ]?([0-9]{4})[-. ]?([0-9]{4})\\b", 
//			message="Telefone em formato incorreto")
	private String celular;

	private int cpf;

	private String rg;

	private String matricula;

	private String cpts;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past @NotNull
	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;

	@Enumerated(EnumType.STRING)
	private EnumPermissoes permissao;
	
	@JoinColumn(name = "id_endereco")
	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER, orphanRemoval = true)
	private Endereco endereco;
	
	@OneToMany
	private List<Falta> faltaList = new ArrayList<Falta>();
	
	@OneToMany
	private List<Treinamento> treinamentoList = new ArrayList<Treinamento>();
	
	@OneToMany
	private List<Ferias> feriasList = new ArrayList<Ferias>();

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

	public List<Falta> getFaltaList() {
		return faltaList;
	}

	public void setFaltaList(List<Falta> faltaList) {
		this.faltaList = faltaList;
	}

	public List<Treinamento> getTreinamentoList() {
		return treinamentoList;
	}

	public void setTreinamentoList(List<Treinamento> treinamentoList) {
		this.treinamentoList = treinamentoList;
	}

	public List<Ferias> getFeriasList() {
		return feriasList;
	}

	public void setFeriasList(List<Ferias> feriasList) {
		this.feriasList = feriasList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + cpf;
		result = prime * result + ((cpts == null) ? 0 : cpts.hashCode());
		result = prime * result
				+ ((dataAdmissao == null) ? 0 : dataAdmissao.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result
				+ ((faltaList == null) ? 0 : faltaList.hashCode());
		result = prime * result
				+ ((feriasList == null) ? 0 : feriasList.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((permissao == null) ? 0 : permissao.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result
				+ ((treinamentoList == null) ? 0 : treinamentoList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (cpf != other.cpf)
			return false;
		if (cpts == null) {
			if (other.cpts != null)
				return false;
		} else if (!cpts.equals(other.cpts))
			return false;
		if (dataAdmissao == null) {
			if (other.dataAdmissao != null)
				return false;
		} else if (!dataAdmissao.equals(other.dataAdmissao))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (faltaList == null) {
			if (other.faltaList != null)
				return false;
		} else if (!faltaList.equals(other.faltaList))
			return false;
		if (feriasList == null) {
			if (other.feriasList != null)
				return false;
		} else if (!feriasList.equals(other.feriasList))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (permissao != other.permissao)
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (treinamentoList == null) {
			if (other.treinamentoList != null)
				return false;
		} else if (!treinamentoList.equals(other.treinamentoList))
			return false;
		return true;
	}
}
