package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String arg[])
	{
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			Student theStudent = new Student("rahul","singh","rahulsingh@gmail.com");
			
			session.beginTransaction();
			
			session.save(theStudent);
			
			session.getTransaction().commit();
			
			System.out.println("save successful ");
			
		}finally {
		
			factory.close();
		}
	}
}
