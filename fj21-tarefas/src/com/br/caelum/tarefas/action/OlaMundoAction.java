package com.br.caelum.tarefas.action;

import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

public class OlaMundoAction {
	
	@Action(value= "olaMundoStruts", results = {
			@Result(location= "/WEB-INF/content/olaMundoStruts.jsp", name="ok") }
	)
	public String execute(){
		System.out.println("Executando a lógica com Struts2");
		return "ok";
	}
}
