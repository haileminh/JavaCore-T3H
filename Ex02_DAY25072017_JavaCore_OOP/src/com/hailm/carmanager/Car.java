package com.hailm.carmanager;

import java.util.Random;

public class Car {
	protected int numberPlate, yearOfManufacture;
	protected String brand;
	protected boolean haveInsurance;
	private String arrBrand[] = new String[] { "TOYOTA", "BMW", "HUYNDAI" };

	Random rd;

	public Car() {
		rd = new Random();
		numberPlate = rd.ints(10000, 100000).findFirst().getAsInt();
		yearOfManufacture = rd.ints(1980, 2013).findFirst().getAsInt();
		brand = arrBrand[rd.nextInt(3)];
		haveInsurance = rd.nextBoolean();

	}

	public int getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(int numberPlate) {
		this.numberPlate = numberPlate;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public boolean isHaveInsurance() {
		return haveInsurance;
	}

	public void setHaveInsurance(boolean haveInsurance) {
		this.haveInsurance = haveInsurance;
	}

	public void in() {
		System.out.print("Car [numberPlate=" + numberPlate + ", yearOfManufacture=" + yearOfManufacture + ", brand="
				+ brand + ", haveInsurance=" + haveInsurance +", ");
	}

}