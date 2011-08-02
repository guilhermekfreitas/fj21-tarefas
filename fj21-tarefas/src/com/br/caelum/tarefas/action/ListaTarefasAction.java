package com.br.caelum.tarefas.action;

import java.util.List;

import org.apache.struts2.convention.annotation.*;
import org.hibernate.Session;


import com.br.caelum.tarefas.dao.NTarefaDAO;
import com.br.caelum.tarefas.dao.TarefaDAO;
import com.br.caelum.tarefas.hibernate.HibernateUtil;
import com.br.caelum.tarefas.modelo.Tarefa;

@ParentPackage("default")
public class ListaTarefasAction {

	private List<Tarefa> tarefas;

	@Action(value="listaTarefas", results= {
		@Result(name="ok", location="/WEB-INF/content/lista-tarefas.jsp")
	}, interceptorRefs={
		@InterceptorRef("autorizador")
	})
	public String execute(){
		Session session = new HibernateUtil().getSession();
		tarefas = new NTarefaDAO(session).listaTudo();
		return "ok";
	}
	
	
	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	
	
}
