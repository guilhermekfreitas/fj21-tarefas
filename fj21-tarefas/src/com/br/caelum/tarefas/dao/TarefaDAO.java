package com.br.caelum.tarefas.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.br.caelum.tarefas.modelo.ModeloUtils;

import com.br.caelum.tarefas.modelo.Tarefa;

public class TarefaDAO {

	private Connection connection;

	public TarefaDAO() {
		connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Tarefa tarefa){
		String sql = "insert into Tarefas (descricao,finalizado,dataFinalizacao) values (?,?,?)";

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			stmt.setDate(3, ModeloUtils.parseCal2SqlDate(tarefa.getDataFinalizacao()));

			stmt.execute();
			stmt.close();

		} catch( SQLException exc ){
			throw new RuntimeException(exc);
		}
	}

	public List<Tarefa> lista() {
		String sql = "select * from tarefas";

		List<Tarefa> tarefas = null;

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			tarefas = new ArrayList<Tarefa>();
			while( rs.next() ){
				Tarefa tarefa = new Tarefa();

				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));

				java.sql.Date date = rs.getDate("dataFinalizacao");
				if (date != null){
					Calendar dataFinalizacao = Calendar.getInstance();
					dataFinalizacao.setTimeInMillis(date.getTime());
					tarefa.setDataFinalizacao(dataFinalizacao);
				}
				tarefas.add(tarefa);
			}

		} catch (SQLException exc){
			throw new RuntimeException(exc);
		} finally {

		}
		return tarefas;

	}

	public void remove(Tarefa tarefa){
		String sql = "delete from tarefas where id = ?";

		try
		{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, tarefa.getId());
			stmt.execute();

			stmt.close();

		} catch (SQLException exc ){
			throw new RuntimeException(exc);
		}
	}


	public Tarefa buscaPorId(Long id) {
		String sql = "select * from tarefas where id = ?";

		Tarefa tarefa = null;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));

				Date date = rs.getDate("dataFinalizacao");
				if (date != null){
					Calendar dataFinalizacao = Calendar.getInstance();
					dataFinalizacao.setTime(date);
					tarefa.setDataFinalizacao(dataFinalizacao);
				}
			}
		} catch (SQLException exc){
			exc.printStackTrace();
		}
		return tarefa;
	}

	public void altera(Tarefa tarefa) {
		String sql = "update tarefas set descricao=?, finalizado=?, dataFinalizacao=? where id=?";

		try
		{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());

			java.sql.Date dataFinalizacao = null;
			if (tarefa.getDataFinalizacao() != null){
				dataFinalizacao = new java.sql.Date(tarefa.getDataFinalizacao().getTimeInMillis());
			}
			stmt.setDate(3, dataFinalizacao);

			stmt.setLong(4, tarefa.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException exc ){
			throw new RuntimeException(exc);
		}
	}

	public void finaliza(Long id) {
		String sql = "UPDATE tarefas SET finalizado = true, dataFinalizacao=? WHERE id=?";

		System.out.println("Finalizando tarefa de id="+id);
		
		try
		{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			long time = Calendar.getInstance().getTimeInMillis();
			java.sql.Date dataFinalizacao = new java.sql.Date(time);
			stmt.setDate(1, dataFinalizacao);
			stmt.setLong(2, id);
			stmt.execute();
			stmt.close();

		} catch (SQLException exc ){
			throw new RuntimeException(exc);
		}		
	}
}
