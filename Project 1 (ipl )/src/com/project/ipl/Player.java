package com.project.ipl;

public class Player {

	private String name;
	private double bidAmount;

	public Player(String name, double bidAmount) {
		this.name = name;
		this.bidAmount = bidAmount;
	}

	public String getName() {
		return name;
	}

	public double getBidAmount() {
		return bidAmount;
	}

	@Override
	public String toString() {
		return name + " - ₹" + bidAmount + " Cr";
	}
}