package com.br.caelum.tarefas.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.br.caelum.tarefas.dao.TarefaDAO;
import com.br.caelum.tarefas.modelo.Tarefa;

public class MostraTarefaAction {

	private Tarefa tarefa;
	
	@Action(value="mostraTarefa", results = {
		@Result(name="ok", location="mostra-tarefa.jsp")
	})
	public String execute(){
		TarefaDAO dao = new TarefaDAO();
		tarefa = dao.buscaPorId(tarefa.getId());
		return "ok";
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
}
