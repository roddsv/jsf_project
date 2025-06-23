package com.rodrigo.jsfprimefaces.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.rodrigo.jsfprimefaces.model.Empresa;

public class SchemaGeneration {

	public static void main(String[] args) {
		try {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSFPrimefacesPU");
		
			EntityManager em = emf.createEntityManager();
		
			List<Empresa> lista = em.createQuery("from Empresa", Empresa.class).getResultList();
		
			System.out.println(lista);
		
			em.close();
			emf.close();
		} catch (Exception e) {
			System.out.println("Erro na criação do banco de dados: " + e.getMessage());
			System.out.println("Stack trace: /n");
			e.printStackTrace();
		}
	}
}
