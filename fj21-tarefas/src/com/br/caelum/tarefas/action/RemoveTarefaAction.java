package com.br.caelum.tarefas.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.br.caelum.tarefas.dao.TarefaDAO;
import com.br.caelum.tarefas.modelo.Tarefa;

public class RemoveTarefaAction {
	
	private Tarefa tarefa;

	
	@Action(value="removeTarefa", results={
			@Result(name="ok", type="redirectAction", params={"actionName", "listaTarefas"})
	})
	public String execute(){
		new TarefaDAO().remove(tarefa);
		return "ok";
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
}
