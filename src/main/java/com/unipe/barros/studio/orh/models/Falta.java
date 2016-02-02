package com.unipe.barros.studio.orh.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_falta")
//@SequenceGenerator(name="FALTA_SEQUENCE", sequenceName="FALTA_SEQUENCE", allocationSize=1, initialValue=0)
public class Falta implements Serializable {

	private static final long serialVersionUID = 4512012595117274600L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Date data;
	
	private boolean foiJustificado = false;
	
	private String descricaoJustificativa;
	
	private int quatidadeFalta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
