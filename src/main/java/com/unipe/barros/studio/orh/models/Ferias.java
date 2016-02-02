package com.unipe.barros.studio.orh.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.unipe.barros.studio.orh.enums.StatusFerias;

@Entity
@Table(name = "tb_ferias")
//@SequenceGenerator(name="FERIAS_SEQUENCE", sequenceName="FERIAS_SEQUENCE", allocationSize=1, initialValue=0)
public class Ferias implements Serializable {

	private static final long serialVersionUID = -4349190162933594781L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFerias;
	
	private Date dataAdmissao;
	
	private String ferias;
	
	private Date dataInicio;

	private Date dataFim;

	private StatusFerias statusFerias;

	public long getIdFerias() {
		return idFerias;
	}

	public void setIdFerias(long idFerias) {
		this.idFerias = idFerias;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getFerias() {
		return ferias;
	}

	public void setFerias(String ferias) {
		this.ferias = ferias;
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

	public StatusFerias getStatusFerias() {
		return statusFerias;
	}

	public void setStatusFerias(StatusFerias statusFerias) {
		this.statusFerias = statusFerias;
	}
	
}