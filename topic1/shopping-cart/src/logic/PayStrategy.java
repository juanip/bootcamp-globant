package logic;

import java.util.ArrayList;

import entities.Item;

public interface PayStrategy {

	public double getFinalPrice(ArrayList<Item> appliances);
}