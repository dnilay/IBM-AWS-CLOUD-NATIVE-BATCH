package org.example.dao;

import org.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CustomerDaoImpl implements CustomerDao{
    private SessionFactory sessionFactory;
    private Session session;
    {
        sessionFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).buildSessionFactory();
    }

    @Override
    public void createCustomer(Customer customer) {

        try{
            session=sessionFactory.openSession();
            session.getTransaction().begin();
            session.save(customer);
            session.getTransaction().commit();
        }
        catch(Exception e)
        {
            System.out.println("duplicate id.");
        }


    }
}
