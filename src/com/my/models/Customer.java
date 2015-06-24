package com.my.models;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class Customer {
	private String name;
	private Vector rentals=new Vector();
	
	public Customer(){
		this.name=name;
 		}
	public String getName(){
		return name;
	}
	public void addRental(Rental rental){
		rentals.addElement(rental);
	}
	
	public String statement(){
		double totalAmount=0;
		int frequentPointer=0;
		List<Rental> rentals=new ArrayList<Rental>();
		String result="Rental result for "+getName()+"\n";
		for(Rental rental:rentals){
			double thisAmount=0;
			switch(rental.getMoive().getPriceCode()){
			case Moive.REGULAR:
				thisAmount+=2;
				if(rental.getDaysRented()>2)
					thisAmount+=(rental.getDaysRented()-2)*1.5;break;
			case Moive.CHILDRENS:
				thisAmount+=1.5;
				if(rental.getDaysRented()>3)
					thisAmount+=(rental.getDaysRented()-3)*1.5;break;
			case Moive.NEW_RELEASE:
				thisAmount+=rental.getDaysRented()*3;break;
		    }
			//add frequent renter point
			frequentPointer++;
			//add bonus for new_realease movie over 2 days
			if(rental.getMoive().getPriceCode()==Moive.NEW_RELEASE && rental.getDaysRented()>1)
				frequentPointer++;
			result+="\t"+rental.getMoive().getTitle()+"\t"+thisAmount;
			totalAmount+=thisAmount;
		}
		result+="Amount owed is: "+totalAmount;
		result+="You earned: "+frequentPointer+" credit point";
		return result;
	}

}
