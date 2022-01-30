package postgres;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory session = buildSessionFactory();


    private static SessionFactory buildSessionFactory() {

        Properties prop = new Properties();

        prop.setProperty("connection.driver_class", "com.postgresql.Driver");
        prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        prop.setProperty("hibernate.connection.username", "postgres");
        prop.setProperty("hibernate.connection.password", "zyinatullo");
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        prop.setProperty("hibernate.show_sql", "true");
        prop.setProperty("hibernate.hbm2ddl.auto", "validate");
        org.hibernate.cfg.Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Student.class);
        cfg.setProperties(prop);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(cfg.getProperties()).build();
        System.out.println("Connected to hibernate");
        return cfg.buildSessionFactory( serviceRegistry);

    }

    public static SessionFactory getSession() {
        return session;
    }

    public static void shutDown() {
        getSession().close();
    }
}
