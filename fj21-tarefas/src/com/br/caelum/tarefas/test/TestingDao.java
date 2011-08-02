package com.br.caelum.tarefas.test;

import java.util.Calendar;

import org.hibernate.Session;

import com.br.caelum.tarefas.dao.NTarefaDAO;
import com.br.caelum.tarefas.hibernate.HibernateUtil;
import com.br.caelum.tarefas.modelo.Tarefa;

public class TestingDao {
	public static void main(String[] args) {
		
		Tarefa t = new Tarefa();
		
		t.setDescricao("Dormir mais cedo");
		t.setFinalizado(false);
		t.setDataFinalizacao(Calendar.getInstance());
		
		Session session = new HibernateUtil().getSession();
		NTarefaDAO dao = new NTarefaDAO(session);
		
		session.beginTransaction();
		dao.salva(t);
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Tarefa de id=" + t.getId() + " salvo!");
	}
}
