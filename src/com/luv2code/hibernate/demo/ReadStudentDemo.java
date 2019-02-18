package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String arg[])
	{
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			Student theStudent = new Student("mi","redmi","devesh@gmail.com");
			
			session.beginTransaction();
			System.out.println(theStudent);
			session.save(theStudent);
			
			session.getTransaction().commit();
			
			System.out.println("save successful ");
			
			System.out.println("get the id for the student======" +theStudent.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("get the id for the student======" +theStudent.getId());
			 Student tempStudent = session.get(Student.class,theStudent.getId());
			
			System.out.println("data for student"+tempStudent);
			
			session.getTransaction().commit();
			
		}finally {
		
			factory.close();
		}
	}
}
