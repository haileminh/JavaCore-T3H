package com.hailm.carmanager;

import java.util.Calendar;

public class OldCar extends Car {
	private int actionDuration;
	Calendar cal = Calendar.getInstance();
	public int getActionDuration() {
		return actionDuration;
	}

	public void setActionDuration(int actionDuration) {
		this.actionDuration = actionDuration;
	}

	public OldCar() {
		super();
		actionDuration = cal.get(Calendar.YEAR) - yearOfManufacture;
	}
	public void in() {
		super.in();
			System.out.print(" actionDuration = "+ actionDuration+ "]" +"\n");
	}

	
}
