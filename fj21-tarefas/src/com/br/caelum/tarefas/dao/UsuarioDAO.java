package com.br.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import org.hibernate.Query;
import org.hibernate.Session;

import com.br.caelum.tarefas.modelo.Tarefa;
import com.br.caelum.tarefas.modelo.Usuario;

public class UsuarioDAO extends Dao<Usuario> {

	public UsuarioDAO(Session session){
		super(session, Usuario.class);
	}
	
	public boolean existe(Usuario usuario){
		
		String sql = "from usuarios where login = :login and senha = :senha";
		Query query = getSession().createQuery(sql);
		query.setString("login", usuario.getLogin());
		query.setString("senha", usuario.getSenha());
		
		return (query.list().size() > 0);
			
		}
		
//		boolean existe = false;
//		try {
//			PreparedStatement ps = connection.prepareStatement(sql);
//			ps.setString(1, usuario.getLogin());
//			ResultSet rs = ps.executeQuery();
//
//			if(rs.next()){
//				existe = true;
//			}
//		} catch (SQLException exc){
//			exc.printStackTrace();
//		}
//		return existe;
//	} 
}
