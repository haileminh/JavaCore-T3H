package com.hailm.insurancemanager;

import java.util.Random;

public class InsurancePackage {
	private static final int AB = 10;
	private String nameInsurance;
	private String packageType;
	private Random rd;
	private String arrPackageType[] = new String[] { "A", "B", "C" };

	
	public InsurancePackage() {
		
	}

	public InsurancePackage(int a) {
		rd = new Random();
		nameInsurance = "nameInsurance" + (AB + 1 +  a);
		packageType = arrPackageType[rd.nextInt(3)];
	}

	@Override
	public String toString() {
		return "InsurancePackage [nameInsurance=" + nameInsurance + ", packageType=" + packageType + "]" + "\n";
	}

}
