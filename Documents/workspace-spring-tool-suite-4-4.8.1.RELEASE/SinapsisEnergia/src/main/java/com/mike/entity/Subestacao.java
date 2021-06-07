package com.mike.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TB_SUBESTACAO")
public class Subestacao implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long idSubestacao;
	
	@Column(length = 3, unique = true)
	private String codigo;
	
	@Column(length = 100, nullable = false)
	private String nome;
	
	@Column(precision = 15, scale = 13)
	private BigDecimal latitude;
	
	@Column(precision = 15, scale = 13)
	private BigDecimal longitude;
	
	@OneToMany(orphanRemoval = true, mappedBy = "subestacao")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<RedeMT> redeMT = new HashSet<>();
	
	
	public Subestacao() {
		
	}

	
	public Subestacao(Long idSubestacao, String codigo, String nome, BigDecimal latitude, BigDecimal longitude,
			Set<RedeMT> redeMT) {
		super();
		this.idSubestacao = idSubestacao;
		this.codigo = codigo;
		this.nome = nome;
		this.latitude = latitude;
		this.longitude = longitude;
		this.redeMT = redeMT;
	}


	public Long getIdSubestacao() {
		return idSubestacao;
	}

	public void setIdSubestacao(Long idSubestacao) {
		this.idSubestacao = idSubestacao;
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

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public Set<RedeMT> getRedeMT() {
		return redeMT;
	}

	public void setRedeMT(Set<RedeMT> redeMT) {
		this.redeMT = redeMT;
	}
	
	
	
	

}
