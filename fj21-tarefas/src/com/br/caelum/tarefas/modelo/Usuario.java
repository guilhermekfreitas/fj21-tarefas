package com.br.caelum.tarefas.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	private String login;
	private String senha;
		
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
