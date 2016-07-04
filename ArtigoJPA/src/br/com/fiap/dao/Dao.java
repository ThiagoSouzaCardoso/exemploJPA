package br.com.fiap.dao;

import java.util.List;

public interface Dao<T> {
	
	void adicionar(T entidade);
	void atualizar(T entidade);
	void remover(T entidade);
	T busca(int id);
	List<T> listar();

}
