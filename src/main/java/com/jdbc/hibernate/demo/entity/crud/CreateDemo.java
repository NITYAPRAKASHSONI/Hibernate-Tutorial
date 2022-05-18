package com.jdbc.hibernate.demo.entity.crud;

import com.jdbc.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        //create the seesion factory


        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        try {
            // use the session to save Java Object
            System.out.println("creating the student object");
            Student student=new Student("Pawan","Soni","pawan@soni21");
            Student student1=new Student("Ram","Singh","ram@singh21");
            Student student2=new Student("Shyam","Singh","shyam@singhi15");
            // start the transaction
            session.beginTransaction();

            //save student object
            System.out.println("Saving the Student");
session.save(student);
            session.save(student1);
            session.save(student2);
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