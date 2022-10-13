package com.StoreProcedure_model;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class Hibernateutil 
{
	    private static SessionFactory sessionfactory;
		private static StandardServiceRegistry registry;
		
		public static SessionFactory getsessionfactory()
		{
			Map<String,Object> m=new HashMap<>();
			m.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			m.put(Environment.URL, "jdbc:mysql://localhost:3306/storeprocedure");
			m.put(Environment.USER, "root");
			m.put(Environment.PASS, "root");
			m.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			m.put(Environment.HBM2DDL_AUTO, "update");
			m.put(Environment.SHOW_SQL, "true");
			
			if(sessionfactory==null)
			{
				registry=new StandardServiceRegistryBuilder().applySettings(m).build();
				MetadataSources msd=new MetadataSources(registry);
				msd.addAnnotatedClass(Student.class);
				Metadata md=msd.getMetadataBuilder().build();
				sessionfactory=md.getSessionFactoryBuilder().build();
			}
			
			
			return sessionfactory;
		}
	}



