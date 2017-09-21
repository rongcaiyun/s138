package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

//读取配置文件
public class HibernateUtil {
	//读取配置文件
	static Configuration conf=new Configuration().configure();
	static SessionFactory sessionFactory;
	
	static {
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		sessionFactory=conf.buildSessionFactory(serviceRegistry);
	}
	public static Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
