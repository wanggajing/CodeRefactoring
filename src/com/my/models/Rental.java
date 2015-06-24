package com.my.models;

public class Rental {
	private Moive moive;
	private int daysRented;
	
	public Rental(Moive moive,int daysRented){
		this.daysRented=daysRented;
		this.moive=moive; 
	}

	public Moive getMoive() {
		return moive;
	}

	public void setMoive(Moive moive) {
		this.moive = moive;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}
    
	
}
