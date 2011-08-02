package com.br.caelum.tarefas.hibernate;

import org.hibernate.Session;

public class TestaHibernate {
	public static void main(String[] args) {
		
		Session session = new HibernateUtil().getSession();
		ProdutoDAO dao = new ProdutoDAO(session);
		
		Produto p = dao.procura(4L);
		
		System.out.println(p);
	}
}
