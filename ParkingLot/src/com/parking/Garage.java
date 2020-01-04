package com.parking;

public class Garage {
	private String parking[][];
	int levels;
	int slots;
	public void setLayout(int levels, int slots) {
		parking=new String[levels][slots];
		this.levels=levels;
		this.slots=slots;
		for (int i=0;i<levels;i++) {
			for (int j=0;j<slots;j++) {
				parking[i][j]="blank";
			}
		}
		
	}
	public void entry(String number) {
		int i=0,j=0,flag=0;
		for (i=0;i<levels;i++) {
			for (j=0;j<slots;j++) {
				if(parking[i][j].equals("blank")) {
					parking[i][j]=number;
					flag=1;
					System.out.println("Parking slot: "+(j+1)+" at level: "+(i+1)+" now alotted to vehicle number: "+number);
					break;
				}
			}
			if (flag==1)
				break;
		}
		if(i>=levels && j>=slots)
			System.out.println("Parking lot full");
	}
	
	public void exit(String number) {
		int i=0,j=0,flag=0;
		for ( i=0;i<levels;i++) {
			for ( j=0;j<slots;j++) {
				if(parking[i][j].equals(number)) {
					parking[i][j]="blank";
					flag=1;
					System.out.println("Parking slot: "+(j+1)+" now empty on level: "+(i+1));
					break;
				}
			}
			if (flag==1)
				break;
		}
		if(i>=levels && j>=slots)
			System.out.println("Vehicle not found in parking lot for exit");
	}
	public void search(String number) {
		int i=0,j=0,flag=0;
		for ( i=0;i<levels;i++) {
			for ( j=0;j<slots;j++) {
				if(parking[i][j].equals(number)) {
					flag=1;
					System.out.println("Vehicle present at parking slot: "+(j+1)+" on level: "+(i+1));
					break;
				}
			}
			if (flag==1)
				break;
		}
		if(i>=levels && j>=slots)
			System.out.println("Vehicle not found in parking lot");
	}
}
