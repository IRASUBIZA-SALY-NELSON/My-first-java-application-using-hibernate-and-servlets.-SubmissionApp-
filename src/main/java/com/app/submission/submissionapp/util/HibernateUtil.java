package com.app.submission.submissionapp.util;

import com.app.submission.submissionapp.models.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.cfg.Configuration;
import java.util.Properties;
import org.hibernate.service.ServiceRegistry;
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            Properties settings = new Properties();
            //POSTGRESQL

            //settings.put(Environment.DRIVER, "org.postgresql.Driver");
            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            //Postgresql
            //	settings.put(Environment.URL, "jdbc:postgresql://localhost:3306/myapp");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/submission");
            settings.put(Environment.USER, "root");
            settings.put(Environment.PASS, "nelson");
            //PostgreSQL
            //settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
            settings.put(Environment.SHOW_SQL, true);
            settings.put(Environment.HBM2DDL_AUTO, "update");
            configuration.setProperties(settings);
            configuration.addAnnotatedClass(Student.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}
