package com.br.caelum.tarefas.dao;

import java.util.List;

import org.hibernate.Session;

public abstract class Dao<T> {
	
	private Session session;
	private Class<T> persistentClass;

	public Dao(Session session, Class<T> clazz){
		this.session = session;
		this.persistentClass = clazz;
	}
	
	public Class<T> getPersistentClass(){
		return persistentClass;
	}
	
	public Session getSession(){
		return session;
	}
	
	public void salva(T obj){
		session.save(obj);
		session.flush();
	}
	
	public void remove(T obj){
		session.delete(obj);
	}
	
	public T procura(Long id){
		return (T) session.load(persistentClass, id);
	}
	
	public void atualiza(T obj){
		session.update(obj);
	}
	
	public List<T> listaTudo(){
		return session.createCriteria(persistentClass).list();
	}
}
