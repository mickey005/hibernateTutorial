package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 2;

			session.beginTransaction();
			
			Student theStudent = session.get(Student.class, studentId);
			
			System.out.println("=="+theStudent);
			
			session.delete(theStudent);
			
			session.getTransaction().commit();
			
			// alternative
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			session.createQuery("delete from  Student where id = 3").executeUpdate();
			
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
	}

}
