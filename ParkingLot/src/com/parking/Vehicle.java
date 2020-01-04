package com.parking;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
	
	private List<String> cars=new ArrayList<String>();
	private List<String> bikes=new ArrayList<String>();
	
	public List getCars() {
		return cars;
	}
	public List getBikes() {
		return bikes;
	}
	public void addCar(String number) {
		cars.add(number);
	}
	public void addBike(String number) {
		bikes.add(number);
	}
	public void removeVehicle(String number) {
		if(cars.contains(number))
		cars.remove(number);
		else if(bikes.contains(number))
			bikes.remove(number);
		else {
			System.out.println("Vehicle not present");
		}
	}
}
