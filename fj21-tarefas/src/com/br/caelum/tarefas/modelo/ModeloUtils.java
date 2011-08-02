package com.br.caelum.tarefas.modelo;

import java.util.Calendar;

public class ModeloUtils {
	public static java.sql.Date parseCal2SqlDate(Calendar c){
		return (c==null ? null : new java.sql.Date(c.getTimeInMillis()));
	}
}
