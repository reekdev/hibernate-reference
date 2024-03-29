/*
 * This demonstrates the create operation 
 */

package hibernate.thirdstep;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Student;

public class CreateStudent {
	
	private static SessionFactory factory;
	private static Session session;

	public static void main(String[] args) {
		
		// create the SessionFactory object
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		try {
			
			/* use the session object to perform various CRUD operations here */
			
			// create the Student object
			System.out.println("creating a new Student object");
			Student student = new Student("Reekdev", "Ray", "ray.reekdev@gmail.com");
			
			// start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// save the Student object
			System.out.println("saving the Student");
			session.save(student);
			
			// commit the current transaction
			session.getTransaction().commit();
			System.out.println("\n\nDONE.");
			
		} finally {
			factory.close();
		}
	}

}
