package com.parking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParkingOperations {
	
	public static void main(String arg[])throws IOException {
		int levels, slots;
		String c, vehicleNumber, type;
		BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please setup the garage layout");
		System.out.println("Enter the number of levels in the parking:");
		levels=Integer.valueOf(obj.readLine());
		System.out.println("Enter the number of slots at each level:");
		slots=Integer.valueOf(obj.readLine());
		Garage garage=new Garage();
		Vehicle vehicle=new Vehicle();
		garage.setLayout(levels, slots);
		while(true) {
			System.out.println("Available Operations:");
			System.out.println("1. Enter a vehicle to garage");
			System.out.println("2. Exit a vehicle from garage");
			System.out.println("3. Get location of a vehicle in parking lot");
			System.out.println("4. Exit");
			System.out.println("Enter choice: ");
			c=obj.readLine();
			switch(c) {
			case "1":
				System.out.println("Enter vehicle number to enter: ");
				vehicleNumber=obj.readLine();
				System.out.println("Enter type of vehicle(Car/Motorcycle)");
				type=obj.readLine();
				if(!vehicle.getBikes().contains(vehicleNumber) && !vehicle.getCars().contains(vehicleNumber)) {
				garage.entry(vehicleNumber);
				if(type.equalsIgnoreCase("motorcycle"))
					vehicle.addBike(vehicleNumber);
				else if(type.equalsIgnoreCase("car"))
					vehicle.addCar(vehicleNumber);
				}
				else
					System.out.println("Vehicle already present in parking lot");
				break;
			case "2":
				System.out.println("Enter vehicle number to exit from garage: ");
				vehicleNumber=obj.readLine();
				garage.exit(vehicleNumber);
				vehicle.removeVehicle(vehicleNumber);
				break;
			case "3":
				System.out.println("Enter vehicle number to search in the garage: ");
				vehicleNumber=obj.readLine();
				garage.search(vehicleNumber);
				break;
			case "4":
				System.out.println("Exiting the parking system");
				System.exit(0);
			default:
				System.out.println("The option is unavailable");
			}
		}	
	}
}
