package com.caterwings.project;

import com.caterwings.project.models.Product;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class PresistenceSessionFactory {

    public static SessionFactory getSessionFactory() {
        Configuration configObj = new Configuration();
        configObj.addAnnotatedClass(Product.class);

        configObj.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        SessionFactory factoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return factoryObj;
    }
}
