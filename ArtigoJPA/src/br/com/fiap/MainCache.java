package br.com.fiap;

import br.com.fiap.dao.Dao;
import br.com.fiap.dao.GenericDao;

public class MainCache {

	
	public static void main(String[] args) {

		Dao<Filme> dao = new GenericDao<>(Filme.class);
		Filme filme = new Filme();
		filme.setDuracao(2.0);
		dao.adicionar(filme);		
		
		Filme busca1 = dao.busca(1);
		System.out.println("BUSCOU NO BANCO");
		
		System.out.println("BUSCA NO CACHE");
		Filme busca2 = dao.busca(1);
		
		System.out.println("BUSCA NO CACHE");
		Filme busca3 = dao.busca(1);
		
		System.out.println("BUSCA NO CACHE");
		Filme busca4 = dao.busca(1);
		
		System.out.println("BUSCA NO CACHE");
		Filme busca5 = dao.busca(1);	
			
	}
	
}
