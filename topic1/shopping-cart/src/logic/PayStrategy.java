package logic;

import java.util.ArrayList;

import entities.Appliance;

public interface PayStrategy {

	public double getFinalPrice(ArrayList<Appliance> appliances);
}