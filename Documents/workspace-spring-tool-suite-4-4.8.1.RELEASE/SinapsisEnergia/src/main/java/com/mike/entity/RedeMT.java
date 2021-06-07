package com.mike.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_REDE_MT")

public class RedeMT implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long idRedeMT;
	
	@Column(length = 5, unique = true)
	private String codigo;
	
	@Column(length = 100)
	private String nome;
	
	@Column(precision = 5, scale = 2)
	private BigDecimal tensaoNominal;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name="ID_SUBESTACAO", referencedColumnName = "idSubestacao", nullable = false ) 
	private Subestacao subestacao;
	
	
	
	
	
	public RedeMT() {
		
	}

	public RedeMT(Long idRedeMT, String codigo, String nome, BigDecimal tensaoNominal, Subestacao subestacao) {
		super();
		this.idRedeMT = idRedeMT;
		this.codigo = codigo;
		this.nome = nome;
		this.tensaoNominal = tensaoNominal;
		this.subestacao = subestacao;
	}
	   /*
		public Long getSubestacao() {
			return subestacao.getIdSubestacao();
		}
	   */
	public Long getSubestacao() {
		
		
		return subestacao.getIdSubestacao();
	}

	public void setSubestacao(Long num) {
		subestacao = new Subestacao();
		this.subestacao.setIdSubestacao(num);
	}

	public Long getIdRedeMT() {
		return idRedeMT;
	}

	public void setIdRedeMT(Long idRedeMT) {
		this.idRedeMT = idRedeMT;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getTensaoNominal() {
		return tensaoNominal;
	}

	public void setTensaoNominal(BigDecimal tensaoNominal) {
		this.tensaoNominal = tensaoNominal;
	}
	
	
	
	
}
