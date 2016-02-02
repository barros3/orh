package com.unipe.barros.studio.orh.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.unipe.barros.studio.orh.enums.StatusVagasDisponiveis;

@Entity
@Table(name = "tb_treinamento")
public class Treinamento implements Serializable{
	
	private static final long serialVersionUID = 1149605058193355418L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String descricao;
	
	private String tema;
	
	private String hora;
	
	private String local;
	
	private Date dataTreinamento;
	
	private int quantidadeVagas;
	
	private StatusVagasDisponiveis statusVagasDisponiveis;

	public Integer getIdTreinamento() {
		return id;
	}

	public void setIdTreinamento(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getDataTreinamento() {
		return dataTreinamento;
	}

	public void setDataTreinamento(Date dataTreinamento) {
		this.dataTreinamento = dataTreinamento;
	}

	public int getQuantidadeVagas() {
		return quantidadeVagas;
	}

	public void setQuantidadeVagas(int quantidadeVagas) {
		this.quantidadeVagas = quantidadeVagas;
	}

	public StatusVagasDisponiveis getStatusVagasDisponiveis() {
		return statusVagasDisponiveis;
	}

	public void setStatusVagasDisponiveis(StatusVagasDisponiveis statusVagasDisponiveis) {
		this.statusVagasDisponiveis = statusVagasDisponiveis;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	
	
}