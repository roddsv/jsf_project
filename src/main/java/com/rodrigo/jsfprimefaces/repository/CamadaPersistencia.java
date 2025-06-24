package com.rodrigo.jsfprimefaces.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.rodrigo.jsfprimefaces.model.Empresa;
import com.rodrigo.jsfprimefaces.model.RamoAtividade;
import com.rodrigo.jsfprimefaces.model.TipoEmpresa;

public class CamadaPersistencia {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSFPrimefacesPU");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//Declarando os repositórios
		RamoAtividades ramoAtividades = new RamoAtividades(em);
		Empresas empresas = new Empresas(em);
		
		//Buscando as informções do banco
		List<RamoAtividade> listaDeRamoAtividades = ramoAtividades.pesquisar("");
		System.out.println("Listando Ramos: " + listaDeRamoAtividades);
		List<Empresa> listaDeEmpresas = empresas.pesquisar("");
		System.out.println(listaDeEmpresas);
		
		//Criando uma empresa
		Empresa empresa = new Empresa();
		empresa.setNomeFantasia("João da Silva");
		empresa.setCnpj("41.952.519/0001-57");
		empresa.setRazaoSocial("João da Silva 41952519000157");
		empresa.setTipo(TipoEmpresa.MEI);
		empresa.setDataFundacao(new Date());
		empresa.setRamoAtividade(listaDeRamoAtividades.get(0));
		
		//Salvando a empresa
		empresas.guardar(empresa);
		
		em.getTransaction().commit();
		
		//Verificando se a inserção funcionou
		List<Empresa> listaDeEmpresas2 = empresas.pesquisar("");
		
		System.out.println(listaDeEmpresas2);
		
		em.close();
		emf.close();
		
	}
}
