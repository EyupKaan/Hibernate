package com.eyupkaan;

import com.eyupkaan.entity.Customer;
import com.eyupkaan.util.Hibernateutil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class AppMain {
    public static void main(String[] args) {

        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            transaction = session.beginTransaction();

            transaction.commit();

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }





    }
}