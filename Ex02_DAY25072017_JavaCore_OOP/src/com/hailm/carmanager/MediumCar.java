package com.hailm.carmanager;

import java.util.Random;

public class MediumCar extends Car {
	private boolean havePowerSteering;
	private Random rd = new Random();
	public boolean isHavePowerSteering() {
		return havePowerSteering;
	}

	public void setHavePowerSteering(boolean havePowerSteering) {
		this.havePowerSteering = havePowerSteering;
	}

	public MediumCar() {
		super();
		havePowerSteering = rd.nextBoolean();
	}
	public void in() {
		super.in();
			System.out.print(" havePowerSteering = "+ havePowerSteering+ "]" +"\n");
	}

	
}
