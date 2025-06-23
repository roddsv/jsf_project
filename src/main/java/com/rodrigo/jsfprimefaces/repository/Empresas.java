package com.rodrigo.jsfprimefaces.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;

import com.rodrigo.jsfprimefaces.model.Empresa;

public class Empresas implements Serializable {

	public static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public Empresas() {
		
	}
	
	public Empresas(EntityManager manager) {
		this.manager = manager;
	}
	
	public Empresa porId(Long id) {
		return manager.find(Empresa.class, id);
	}
	
	public List<Empresa> pesquisar(String nome) {
		TypedQuery<Empresa> query = manager.createQuery("from Empresa WHERE nomeFantasia like :nomeFantasia", Empresa.class);
		query.setParameter("nomeFantasia", nome + "%");
		return query.getResultList();
	}
	
	//insert
	public Empresa guardar(Empresa empresa) {
		return manager.merge(empresa);
	}
	
	public void remover(Empresa empresa) {
		empresa = porId(empresa.getId());
		manager.remove(empresa);
		
	}	
}
