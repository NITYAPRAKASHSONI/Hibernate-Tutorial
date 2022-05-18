package com.jdbc.hibernate.demo.entity.crud;

import com.jdbc.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class UpdateDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        try {
            int studentId=5;
            // start the transaction
            session.beginTransaction();

            //retrieve the student base on id
            System.out.println("\n Getting student id" + studentId);
            Student myStudent=session.get(Student.class,studentId);

            System.out.println("updating student...");
            myStudent.setFirstName("Kali");


            // commit the transaction
            session.getTransaction().commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            factory.close();
        }
    }
    }

