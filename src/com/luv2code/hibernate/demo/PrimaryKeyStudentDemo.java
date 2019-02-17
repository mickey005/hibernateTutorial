package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class PrimaryKeyStudentDemo {

	public static void main(String arg[])
	{
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			
			Student theStudent = new Student("snajy","yadav","sanjayyadav@gmail.com");
			Student theStudent1 = new Student("gotam","yadav","gotam@gmail.com");
			Student theStudent2 = new Student("rajan","anand","rjanand@gmail.com");
			
			session.beginTransaction();
			session.save(theStudent);
			session.save(theStudent1);
			session.save(theStudent2);
			
			session.getTransaction().commit();
			
			
		}finally {
			factory.close();
		}
	}
}
