package com.ty.mobile.sim;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveMobileSim {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ajay");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Mobile mobile=new Mobile();
		mobile.setName("MI");
	    mobile.setCost(80000);
	    
	    Sim sim1=new Sim();
	    sim1.setProvider("Airtel");
	    sim1.setType("4G");
	    sim1.setImei("veqvev");
	    

	    Sim sim2=new Sim();
	    sim2.setProvider("idea");
	    sim2.setType("3g");
	    sim2.setImei("vqevereg");
	    
	    
	    List<Sim> sims=new ArrayList<Sim>();
	    sims.add(sim1);
	    sims.add(sim2);
	
	sim1.setMobile(mobile);
	sim2.setMobile(mobile);
	    mobile.setSim(sims);

	    entityTransaction.begin();
	    entityManager.persist(mobile);
	    entityManager.persist(sim1);
	    entityManager.persist(sim2);
	    entityTransaction.commit();
	    
	}

}
