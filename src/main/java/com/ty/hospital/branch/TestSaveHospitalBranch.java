package com.ty.hospital.branch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveHospitalBranch {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ajay");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Hospital hospital = new Hospital();
		hospital.setName("Fortis");
		hospital.setGstNumber("fotir2324234wfnejrfn");
		hospital.setWebsite("www.fortis.com");

		Branch branch1 = new Branch();
		branch1.setName("Bannerghatta ");
		branch1.setAddress("Banglore");
		branch1.setPhone(8852741963l);

		Branch branch2 = new Branch();
		branch2.setName(" Wlison garden");
		branch2.setAddress("Banglore");
		branch2.setPhone(8852741963l);

		Branch branch3 = new Branch();
		branch3.setName("  richmond road");
		branch3.setAddress("Banglore");
		branch3.setPhone(8852741963l);

		
		 List<Branch > branches=new ArrayList();
		 branches.add(branch3);
		 branches.add(branch2);
		 branches.add(branch1);
		 
		 hospital.setBranch(branches);
		 branch1.setHospital(hospital);
		 branch2.setHospital(hospital);
		 branch3.setHospital(hospital);
		 
		 entityTransaction.begin();
	     entityManager.persist(hospital);
	     entityManager.persist(branch1);
         entityManager.persist(branch2);
		    entityManager.persist(branch3);
		    entityTransaction.commit();
	}
}
