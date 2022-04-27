package com.corso.hibernateEjpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class Main {
    private SessionFactory sessionFactory;

    public static void main(String[] args) throws Exception {
        Main m=new Main();
        m.setUp();
        m.testBasicUsage();
        m.shutDown();
    }


    protected void setUp() throws Exception {
        sessionFactory = new Configuration()
                .configure() // configura la SessionFactory utilizzando l' hibernate.cfg.xml
                .buildSessionFactory();
    }

    protected void shutDown() throws Exception {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public void testBasicUsage() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Archivio(1,"aaa","bbb"));
        session.save(new Archivio(2,"2aaa","2bbb"));
        session.getTransaction().commit();
        session.close();

        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        session1.save(new Brani(1,"Maneskin","Rock"));
        session1.save(new Brani(1,"Pluto","Rap"));
        session1.getTransaction().commit();
        session1.close();


        session = sessionFactory.openSession();
        session.beginTransaction();
        List<Archivio> result = session.createQuery("from Archivio").list();
        for (Archivio a : (List<Archivio>) result) {
            System.out.println("Numero Cd: (" +  a.getNumberCd() + ") : + IdBrani: ("+ a.getIdBrano() + ") : )");
        }
        session.getTransaction().commit();
        session.close();

        session1 = sessionFactory.openSession();
        session1.beginTransaction();
        List<Brani> result1 = session1.createQuery("from Brani").list();
        for (Brani b : (List<Brani>) result1) {
            System.out.println("Brani: (" + b.getArtista()+" "+b.getGenere() + ") : ");
        }
        session1.getTransaction().commit();
        session1.close();
    }


}

