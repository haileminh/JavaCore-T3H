package com.hailm.carmanager;

import java.util.Random;

public class ModernCar extends Car {
	private boolean havePositioningDevice;
	private Random rd = new Random();

	public boolean isHavePositioningDevice() {
		return havePositioningDevice;
	}

	public void setHavePositioningDevice(boolean havePositioningDevice) {
		this.havePositioningDevice = havePositioningDevice;
	}

	public ModernCar() {
		super();
		havePositioningDevice = rd.nextBoolean();
	}
	public void in() {
		super.in();
			System.out.print(" havePositioningDevice = "+ havePositioningDevice + "]" +"\n");
	}

}
