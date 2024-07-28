package com.eyupkaan;

import com.eyupkaan.entity.Customer;
import com.eyupkaan.util.Hibernateutil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.descriptor.java.spi.JsonJavaType;

public class Main {
    public static void main(String[] args) {
        Customer me = new Customer("Eyüp Kaan", "Özteriş");

        Session session = Hibernateutil.getSessionFactory().openSession();

        try (session) {
            Transaction transaction = null;
            transaction = session.beginTransaction();
            session.persist(me);
            transaction.commit();

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }

    }
}