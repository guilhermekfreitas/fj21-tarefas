package com.br.caelum.tarefas.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Session;

import com.br.caelum.tarefas.dao.UsuarioDAO;
import com.br.caelum.tarefas.hibernate.HibernateUtil;
import com.br.caelum.tarefas.modelo.Usuario;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction {

	private Usuario usuario;

	@Action(value="login", results={
		@Result(name="ok", location="/menu.jsp"),
		@Result(name="invalido", location="/login.jsp")
	})
	public String login(){
		Session session = new HibernateUtil().getSession();
		if (new UsuarioDAO(session).existe(usuario)){
			// gravar na sessão
			ActionContext.getContext().getSession().put("usuarioLogado", usuario);
			return "ok";
		}

		return "invalido";
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
