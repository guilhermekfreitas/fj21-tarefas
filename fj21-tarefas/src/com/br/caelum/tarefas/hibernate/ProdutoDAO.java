package com.br.caelum.tarefas.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

public class ProdutoDAO {

	private Session session;
	
	public ProdutoDAO(Session session){
		this.session = session;
	}
	
	public List<Produto> listaTudo(int inicio, int quantia){
		List<Produto> list = session.createCriteria(Produto.class)
		.setMaxResults(quantia).setFirstResult(inicio).list();
		return list;
	}
	
	public List<Produto> precoMaiorQue(double preco){
		Query query = session.createQuery("from Produto where preco > :preco");
		query.setDouble("preco", preco);
		return query.list();
	}
	
	public void salva (Produto p){
		session.save(p);
	}
	
	public void remove(Produto p){
		session.delete(p);
	}
	
	public Produto procura(Long id){
		return (Produto) session.load(Produto.class, id);
	}
	
	public void atualiza(Produto p){
		session.update(p);
	}
}
