package com.br.caelum.tarefas.hibernate;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GeraTabelas {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Produto.class);
		
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
		
	}
}
