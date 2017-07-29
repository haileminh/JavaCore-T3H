package com.hailm.carmanager;

import java.util.ArrayList;
import java.util.List;

import com.hailm.insurancemanager.InsurancePackage;

public class CarManager {
	private static final int XY = 10;
	private List<Car> listCar;

	public CarManager() {
		listCar = new ArrayList<>();
		initCar();
	}

	private void initCar() {
		for (int i = 0; i < XY; i++) {
			Car car = new Car();
			if (car.getYearOfManufacture() >= 2005) {
				Car a = new ModernCar();
				a.setYearOfManufacture(car.getYearOfManufacture());
				listCar.add(a);
			} else if (car.getYearOfManufacture() <= 1995) {
				Car a = new OldCar();
				a.setYearOfManufacture(car.getYearOfManufacture());
				listCar.add(a);
			} else if (car.getYearOfManufacture() >= 1996 && car.getYearOfManufacture() <= 2004) {
				Car a = new MediumCar();
				a.setYearOfManufacture(car.getYearOfManufacture());
				listCar.add(a);
			}
		}
	}

	public void printListCar() {
		for (int i = 0; i < XY; i++) {

			listCar.get(i).in();
		}
	}

	private boolean ktra(String nameInsurance, Car car) {
		boolean kq = false;
		if ((nameInsurance == "A") && (car instanceof ModernCar)) {
			kq = true;
		}
		if ((nameInsurance == "B") && (car instanceof MediumCar)) {
			kq = true;
		}
		if ((nameInsurance == "C") && (car instanceof OldCar)) {
			kq = true;
		}
		return kq;
	}

	public void assignAssurance(String nameInsurance, Car car) {
		// InsurancePackage insurancePackage = new InsurancePackage();
		if (car.isHaveInsurance() == true) {
			System.out.println("Unavailable Buying!”");
		} else if (ktra(nameInsurance, car) == false) {
			System.out.println("“Invalid Package!”");
		} else if (ktra(nameInsurance, car) == true) {
			System.out.println("“Successful Buying”");
			car.setHaveInsurance(true);
		} else {
			System.out.println("“Unsuccessful Buying ”");
		}
	}

	public void test(String A) {
		for (int i = 0; i < XY; i++) {
			assignAssurance(A, listCar.get(i));
		}
	}

	public void showCarInfo() {
		System.out.println("Modern Car:");
		for (int i = 0; i < 10; i++) {
			if (listCar.get(i).getYearOfManufacture() >= 2005) {
				listCar.get(i).in();
			}
		}
		System.out.println("Medium Car:");
		for (int i = 0; i < 10; i++) {
			if (listCar.get(i).getYearOfManufacture() >=1996 && listCar.get(i).getYearOfManufacture() <= 2004) {
				listCar.get(i).in();
			}
		}
		System.out.println("Old Car:");
		for (int i = 0; i < 10; i++) {
			if (listCar.get(i).getYearOfManufacture() <= 1995) {
				listCar.get(i).in();
			}
		}
	}
}
