package com.hailm.insurancemanager;

import java.util.ArrayList;
import java.util.List;

public class InsuranceManager {
	
	private static final int AB = 10;
	private List<InsurancePackage> listInsurancePackage;

	public InsuranceManager() {
		listInsurancePackage = new ArrayList<>();
		initInsurance();
	}

	private void initInsurance() {
		for (int i = 0; i < AB; i++) {
			listInsurancePackage.add(new InsurancePackage(i));
		}
	}
	
	public void printListInsurancePackage() {
		System.out.println(listInsurancePackage.toString());
	}
}
