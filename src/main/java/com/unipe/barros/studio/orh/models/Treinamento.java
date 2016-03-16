package com.unipe.barros.studio.orh.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.unipe.barros.studio.orh.enums.EnumStatusVagasDisponiveis;

@Entity
@Table(name = "tb_treinamento")
public class Treinamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String descricao;
	
	private String tema;
	
	private String hora;
	
	private String local;
	
	private Date dataTreinamento;
	
	private int quantidadeVagas;
	
	private String palestrante;
	
	private EnumStatusVagasDisponiveis statusVagasDisponiveis;

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

	public EnumStatusVagasDisponiveis getStatusVagasDisponiveis() {
		return statusVagasDisponiveis;
	}

	public void setStatusVagasDisponiveis(EnumStatusVagasDisponiveis statusVagasDisponiveis) {
		this.statusVagasDisponiveis = statusVagasDisponiveis;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPalestrante() {
		return palestrante;
	}

	public void setPalestrante(String palestrante) {
		this.palestrante = palestrante;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataTreinamento == null) ? 0 : dataTreinamento.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result
				+ ((palestrante == null) ? 0 : palestrante.hashCode());
		result = prime * result + quantidadeVagas;
		result = prime
				* result
				+ ((statusVagasDisponiveis == null) ? 0
						: statusVagasDisponiveis.hashCode());
		result = prime * result + ((tema == null) ? 0 : tema.hashCode());
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
		Treinamento other = (Treinamento) obj;
		if (dataTreinamento == null) {
			if (other.dataTreinamento != null)
				return false;
		} else if (!dataTreinamento.equals(other.dataTreinamento))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (palestrante == null) {
			if (other.palestrante != null)
				return false;
		} else if (!palestrante.equals(other.palestrante))
			return false;
		if (quantidadeVagas != other.quantidadeVagas)
			return false;
		if (statusVagasDisponiveis != other.statusVagasDisponiveis)
			return false;
		if (tema == null) {
			if (other.tema != null)
				return false;
		} else if (!tema.equals(other.tema))
			return false;
		return true;
	} 	
}