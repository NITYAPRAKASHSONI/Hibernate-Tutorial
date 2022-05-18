package com.jdbc.hibernate.demo.entity.crud;

import com.jdbc.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryDemo {
    public static void main(String[] args) {
        //create the seesion factory


        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        try {


            // start the transaction
            session.beginTransaction();

            //query student

            List<Student> studentList=session.createQuery("from Student").getResultList();
            // display student
            displayStudent(studentList);

            // query whose last name is soni
            System.out.println("Displaying student name whose  lastname star with Singh");
            studentList=session.createQuery("from Student s where s.lastName='Singh'").getResultList();
            // display student
            displayStudent(studentList);

            // query whose last name is soni or patil
            System.out.println("Displaying student name whose  lastname star with Soni or first name sejal");
            studentList=session.createQuery("from Student s where s.lastName='Soni' OR s.firstName='Sejal'").getResultList();
            // diplaying student
            displayStudent(studentList);
            // commit the transaction
            session.getTransaction().commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            factory.close();
        }
    }

    private static void displayStudent(List<Student> studentList) {
        for(Student tempStudent: studentList){
            System.out.println(tempStudent);
        }
    }
}
