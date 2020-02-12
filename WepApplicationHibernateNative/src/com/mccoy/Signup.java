package com.mccoy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class Signup 
{ 
	 public void addUserDetails(String firstName, String lastName, String phoneNo) { 
		 
	
	
	
		 System.out.println(firstName+""+lastName);
			
	        // 1. configuring hibernate
	        Configuration configuration = new Configuration().configure();

	        // 2. create sessionfactory
	        SessionFactory sessionFactory = configuration.buildSessionFactory();

	        // 3. Get Session object
	        Session session = sessionFactory.openSession();

	        // 4. Starting Transaction
	        Transaction transaction = session.beginTransaction();
	        
			// String sql = "	insert into signupusers (id,firstName,lastName,phoneNo) values (?,?,?,?) ";
			 String sql = "	select * from signupusers  ";
			 
			  Signupcreationtodb sCDb = new Signupcreationtodb();
			  sCDb.setFirstName(firstName);
			  sCDb.setLastName(lastName);
			 sCDb.setPhoneNo(phoneNo);
			 System.out.println(firstName);
			 session.createSQLQuery(sql).setParameter(1, firstName).setParameter(2, lastName).setParameter(3, phoneNo);
			  session.save(sCDb);
			  transaction.commit();
			  session.close();
		 
						
			 
}

}
