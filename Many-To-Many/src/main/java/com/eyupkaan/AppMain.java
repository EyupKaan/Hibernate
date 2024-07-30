package com.eyupkaan;

import com.eyupkaan.entity.Address;
import com.eyupkaan.entity.Customer;
import com.eyupkaan.util.Hibernateutil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppMain {
    public static void main(String[] args) {

        Address ist = new Address("Turkey", "Istanbul", "Besiktas");
        Address ank = new Address("Turkey", "Ankara", "Cankaya");
        Address izm = new Address("Turkey", "Izmir", "Bornova");
        Address ant = new Address("Turkey", "Antalya", "Alanya");
        Address mug = new Address("Turkey", "Mugla", "Bodrum");
        Address ayd = new Address("Turkey", "Aydin", "Kusadasi");

        Customer me = new Customer("Eyüp Kaan", "Özteriş");
        Customer anil = new Customer("Anıl", "Düz");
        Customer ozan = new Customer("Ozan", "Belkeci");

        me.getAddresses().add(ist);
        me.getAddresses().add(izm);

        anil.getAddresses().add(mug);
        anil.getAddresses().add(ant);
        anil.getAddresses().add(ank);

        ozan.getAddresses().add(ank);
        ozan.getAddresses().add(ist);
        ozan.getAddresses().add(izm);
        ozan.getAddresses().add(ayd);




        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            transaction = session.beginTransaction();

            session.persist(me);
            session.persist(anil);
            session.persist(ozan);

            transaction.commit();

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }





    }
}