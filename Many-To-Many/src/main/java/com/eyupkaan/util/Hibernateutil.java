package com.eyupkaan.util;

import com.eyupkaan.entity.Address;
import com.eyupkaan.entity.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class Hibernateutil {
    private static ServiceRegistry serviceRegistry;

    static{

        try{
            Configuration configuration=new Configuration();
            configuration.configure();

            Properties settings = new Properties();

            settings.put(Environment.DRIVER, "org.postgresql.Driver");
            settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres?currentSchema=edudb");
            settings.put(Environment.USER, "postgres");
            settings.put(Environment.PASS, "postgres");

            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.FORMAT_SQL, "true");
            settings.put(Environment.HBM2DDL_AUTO, "create");
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

            configuration.setProperties(settings);

            configuration.addAnnotatedClass(Customer.class);
            configuration.addAnnotatedClass(Address.class);

            serviceRegistry= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            configuration.buildSessionFactory(serviceRegistry);

        }catch(Exception e){
            System.err.println("Hata: "+e);
        }

    }

    public static SessionFactory getSessionFactory(){
        return new Configuration().configure().buildSessionFactory();
    }
}
