package br.com.fiap;

import br.com.fiap.dao.Dao;
import br.com.fiap.dao.GenericDao;

public class MainLock {

	public static void main(String[] args) {

		Dao<Local> dao = new GenericDao<>(Local.class);
		Local local1 = new Local();
		local1.setLocal("Aricanduva");
		dao.adicionar(local1);
	
		Local busca1 = dao.busca(1);
		busca1.setLocal("Aricanduva2");
		
		Local busca2 = dao.busca(1);
		busca1.setLocal("Aricanduva3");
		
		dao.atualizar(busca1);
		dao.atualizar(busca2);
		
	}
	
}
