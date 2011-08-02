package com.br.caelum.tarefas.action;

import org.apache.struts2.convention.annotation.*;

import com.br.caelum.tarefas.dao.TarefaDAO;

public class FinalizaTarefaAction {
	private Long id;

	@Action(value="finalizaTarefa", results={
		@Result(name="ok", type="httpheader", params={"status","200"})	
	})
	public String execute(){
		new TarefaDAO().finaliza(id);
		return "ok";
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
