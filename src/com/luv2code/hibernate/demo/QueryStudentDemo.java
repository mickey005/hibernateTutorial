package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
				session.beginTransaction();
				
				List<Student> theStudent = session.createQuery(" from Student ").getResultList();
			
					displayStudent(theStudent);
			
					theStudent = session.createQuery("from Student s where s.lastName ='chopra' or s.firstName='mickey'").getResultList();
					System.out.println("chopra last name"+ theStudent);
					displayStudent(theStudent);
					
					session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

	private static void displayStudent(List<Student> theStudent) {
		for(Student tempStudent:theStudent)
		{
			System.out.println("student=="+ tempStudent);
		}
	}

}
