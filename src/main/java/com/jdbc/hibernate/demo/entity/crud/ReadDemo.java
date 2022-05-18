package com.jdbc.hibernate.demo.entity.crud;

import com.jdbc.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{
            // create a new Student object
            System.out.println("creating new Student");
            Student student=new Student("Sejal","patil","sejal@patil");
            // start the transaction
            session.beginTransaction();
            //save student object
            System.out.println("saving student "+student);
            session.save(student);
            // commit the transaction
            session.getTransaction().commit();
            // find out student id
            System.out.println("student id is "+student.getId());

            // now get new session and start transactions

         session=factory.getCurrentSession();
         session.beginTransaction();
         //retrieve student based on id
            System.out.println("\n Getting Student "+student.getId());
Student myStudent= session.get(Student.class,student.getId());
            System.out.println("Student Detail is "+myStudent);
            System.out.println("Done!!!");

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
