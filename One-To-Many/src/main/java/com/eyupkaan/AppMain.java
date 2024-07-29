package com.eyupkaan;

import com.eyupkaan.entity.Customer;
import com.eyupkaan.entity.Order;
import com.eyupkaan.util.Hibernateutil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class AppMain {
    public static void main(String[] args) {
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();

        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();

        customer1.setFirstName("Eyüp Kaan");
        customer1.setLastName("Özteriş");

        customer2.setFirstName("Anıl");
        customer2.setLastName("Düz");

        customer3.setFirstName("Ozan");
        customer3.setLastName("Belkeci");

        order1.setProduct("Honda");
        order1.setCode("333");
        order1.setCreateDate(new Date());
        order1.setAmount(32.5F);

        order2.setProduct("Yamaha");
        order2.setCode("463");
        order2.setCreateDate(new Date());
        order2.setAmount(29.8F);

        order3.setProduct("Suzuki");
        order3.setCode("147");
        order3.setCreateDate(new Date());
        order3.setAmount(46.7F);

        /*
        customer1.getOrders().add(order1);
        customer1.getOrders().add(order2);
        customer2.getOrders().add(order2);
        customer2.getOrders().add(order3);
        customer3.getOrders().add(order3);
        customer3.getOrders().add(order1);

        order1.setCustomer(customer1);
        order2.setCustomer(customer1);

        order2.setCustomer(customer2);
        order3.setCustomer(customer2);
        */

        //FIXED
        customer1.addOrder(order1);
        customer1.addOrder(order2);

        customer2.addOrder(order2);
        customer2.addOrder(order3);

        customer3.addOrder(order1);
        customer3.addOrder(order3);

        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            transaction = session.beginTransaction();

            session.persist(customer1);
            session.persist(customer2);
            session.persist(customer3);

            session.persist(order1);
            session.persist(order2);
            session.persist(order3);

            transaction.commit();

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }





    }
}