package com.br.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection(){
		try 
		{
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "admin");
		} catch (SQLException exc ){
			throw new RuntimeException(exc);
		}
	}
}
