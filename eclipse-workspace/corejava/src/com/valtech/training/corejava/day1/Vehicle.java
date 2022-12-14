package com.valtech.training.corejava.day1;

public abstract class Vehicle {
	public void start()
	{
		System.out.println("Start Button Pressed....");
	}
	public void stop()
	{
		System.out.println("Stop Button Pressed....");
	};
	public abstract void accelerate();
	public abstract void applyBrakes();
	public final void driveSomeDistance()
	{
		start();
		accelerate();
		applyBrakes();
		stop();
	}
	public static void main(String[] args) {
		Vehicle es=new ElectricScooter();
		es.driveSomeDistance();
	}

}
