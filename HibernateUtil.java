package br.com.jloja.util;


//Importes necessários

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.com.jloja.entity.FabricanteEntity;
import br.com.jloja.entity.ProdutoEntity;
import br.com.jloja.entity.UsuarioEntity;

//Importes necessários

public class HibernateUtil {

    //Criação da fábrica de sessão ou SessionFactory

    private static final SessionFactory sessionFactory = buildSessionFactory();

    //Criação da fábrica de sessão ou SessionFactory

    //Método que constroi a sessão

    private static SessionFactory buildSessionFactory() {
        try {
            // Criar a SessionFactory de hibernate.cfg.xml
        	Configuration  configuration = new Configuration();
        	configuration.addAnnotatedClass(FabricanteEntity.class);
        	configuration.addAnnotatedClass(ProdutoEntity.class);
        	configuration.addAnnotatedClass(UsuarioEntity.class);
        	configuration.configure("hibernate.cfg.xml");
        	
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	
            return sessionFactory;
        }
        catch (Throwable ex) {
            // Certifique-se de criar a exceção
            System.err.println("Falha ao criar SessionFactory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

   //Método que constroi a sessão

    //Método que retorna a sessão criada

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    //Método que retorna a sessão criada

}