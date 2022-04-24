package br.com.jloja.util;


//Importes necess�rios

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.com.jloja.entity.FabricanteEntity;
import br.com.jloja.entity.ProdutoEntity;
import br.com.jloja.entity.UsuarioEntity;

//Importes necess�rios

public class HibernateUtil {

    //Cria��o da f�brica de sess�o ou SessionFactory

    private static final SessionFactory sessionFactory = buildSessionFactory();

    //Cria��o da f�brica de sess�o ou SessionFactory

    //M�todo que constroi a sess�o

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
            // Certifique-se de criar a exce��o
            System.err.println("Falha ao criar SessionFactory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

   //M�todo que constroi a sess�o

    //M�todo que retorna a sess�o criada

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    //M�todo que retorna a sess�o criada

}