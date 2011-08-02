package com.br.caelum.tarefas.hibernate;

import java.util.Calendar;
import javax.persistence.*;

@Entity
public class Produto {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String descricao;
	private double preco;
	private Calendar dataInicioVenda;
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public double getPreco() {
		return preco;
	}
	public Calendar getDataInicioVenda() {
		return dataInicioVenda;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public void setDataInicioVenda(Calendar dataInicioVenda) {
		this.dataInicioVenda = dataInicioVenda;
	}
}
