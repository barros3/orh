package com.unipe.barros.studio.orh.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="falta")
public class Falta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Date dataInicio;
	
	private Date dataFim;
	
	private boolean foiJustificado = false;
	
	private String descricaoJustificativa;
	
	// LEMBRAR: CALCULAR A QUANTIDADE DE FALTAS
	
	private int quatidadeFalta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public boolean isFoiJustificado() {
		return foiJustificado;
	}

	public void setFoiJustificado(boolean foiJustificado) {
		this.foiJustificado = foiJustificado;
	}

	public String getDescricaoJustificativa() {
		return descricaoJustificativa;
	}

	public void setDescricaoJustificativa(String descricaoJustificativa) {
		this.descricaoJustificativa = descricaoJustificativa;
	}

	public int getQuatidadeFalta() {
		return quatidadeFalta;
	}

	public void setQuatidadeFalta(int quatidadeFalta) {
		this.quatidadeFalta = quatidadeFalta;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result
				+ ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime
				* result
				+ ((descricaoJustificativa == null) ? 0
						: descricaoJustificativa.hashCode());
		result = prime * result + (foiJustificado ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + quatidadeFalta;
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
		Falta other = (Falta) obj;
		if (dataFim == null) {
			if (other.dataFim != null)
				return false;
		} else if (!dataFim.equals(other.dataFim))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (descricaoJustificativa == null) {
			if (other.descricaoJustificativa != null)
				return false;
		} else if (!descricaoJustificativa.equals(other.descricaoJustificativa))
			return false;
		if (foiJustificado != other.foiJustificado)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quatidadeFalta != other.quatidadeFalta)
			return false;
		return true;
	}
	
}
