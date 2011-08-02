package com.br.caelum.tarefas.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.br.caelum.tarefas.dao.TarefaDAO;
import com.br.caelum.tarefas.modelo.Tarefa;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@Validations(requiredStrings = {
		@RequiredStringValidator(fieldName="tarefa.descricao", message="Valor obrigatório")},
		stringLengthFields = {
		@StringLengthFieldValidator(fieldName="tarefa.descricao", message="Minimo de 5 caracteres", minLength="5")
})
public class AdicionaTarefasAction extends ActionSupport{

	private Tarefa tarefa;
	
	@Action(value="adicionaTarefa", results= {
		@Result(name="ok", location="/WEB-INF/content/tarefa-adicionada.jsp"),
		@Result(name="input", location="/formulario-tarefas.jsp")
	})
	public String execute(){
		new TarefaDAO().adiciona(tarefa);
		return "ok";
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	@VisitorFieldValidator(key="tarefa")
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
}
