package com.br.caelum.tarefas.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.br.caelum.tarefas.modelo.Tarefa;
import com.br.caelum.tarefas.modelo.Usuario;

public class HibernateUtil {

	private static SessionFactory factory;
	
	static {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Produto.class);
		cfg.addAnnotatedClass(Tarefa.class);
		cfg.addAnnotatedClass(Usuario.class);
		factory = cfg.buildSessionFactory();
	}
	
	public Session getSession(){
		return factory.openSession();
	}
}
