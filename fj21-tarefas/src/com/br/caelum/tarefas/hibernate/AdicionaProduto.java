package com.br.caelum.tarefas.hibernate;

import java.util.Calendar;

import org.hibernate.Session;

public class AdicionaProduto {
	public static void main(String[] args) {
		
		Produto p = new Produto();
		p.setNome("Estante de Madeira");
		p.setDescricao("Uma estante super moderna!");
		
		Calendar data = Calendar.getInstance();
		data.set(Calendar.YEAR, 1991);
		data.set(Calendar.MONTH, Calendar.OCTOBER);
		data.set(Calendar.DATE, 11);
		
		p.setDataInicioVenda(data);
		p.setPreco(400.30);
		
		Session session = new HibernateUtil().getSession();
		session.beginTransaction();
		
		session.save(p);
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("ID do produto= " + p.getId());
		
	}
}
