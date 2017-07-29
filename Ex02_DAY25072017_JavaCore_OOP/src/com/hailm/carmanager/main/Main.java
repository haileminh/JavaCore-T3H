package com.hailm.carmanager.main;

import com.hailm.carmanager.CarManager;
import com.hailm.insurancemanager.InsuranceManager;

public class Main {
	public static void main(String[] args) {
		CarManager carManager = new CarManager();
		InsuranceManager insuranceManager = new InsuranceManager();
		carManager.printListCar();
		insuranceManager.printListInsurancePackage();
		carManager.test("B");
		carManager.showCarInfo();
	}
}
