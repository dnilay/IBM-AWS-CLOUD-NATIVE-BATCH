package org.example.dao;

import org.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component

public class CustomerDaoImpl implements CustomerDao{

    private SessionFactory sessionFactory;

    public CustomerDaoImpl() {

        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        sessionFactory=context.getBean("sessionFactory",SessionFactory.class);
    }

    @Override

    public Customer createCustomer(Customer customer) {
        Session session=sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(customer);
        session.getTransaction().commit();
        return customer;
    }
}
