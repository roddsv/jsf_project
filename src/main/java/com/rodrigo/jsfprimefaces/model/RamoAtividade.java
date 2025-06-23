package com.rodrigo.jsfprimefaces.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ramo_atividade")
public class RamoAtividade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id // para sinalizar a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //o banco de dados vai atribuir o valor
	private Long id;
	
	@Column(nullable = false, length = 80)
	private String descricao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RamoAtividade other = (RamoAtividade) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "RamoAtividade [id=" + id + "]";
	}
	
	

}
