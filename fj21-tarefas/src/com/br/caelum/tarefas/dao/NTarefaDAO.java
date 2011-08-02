package com.br.caelum.tarefas.dao;

import org.hibernate.Session;

import com.br.caelum.tarefas.modelo.Tarefa;

public class NTarefaDAO extends Dao<Tarefa> {

	public NTarefaDAO(Session session) {
		super(session, Tarefa.class);
	}

}
