package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student theStudent = new Student("123","gullyboy","ranveer@gmail.com");
			
			session.beginTransaction();
			
			session.save(theStudent);
			
			session.getTransaction().commit();
			
			System.out.println(theStudent.getId());
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			Student tempStudent = session.get(Student.class, theStudent.getId());
			System.out.println(theStudent.getId());
			tempStudent.setFirstName("Ranveer");
			
			session.getTransaction().commit();
		}finally {
			
			factory.close();
		}
	}

}
