package entities;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Cardapio {
	private List<Item> items;
	
	Scanner sc = new Scanner(System.in);
	
	public Cardapio() {
		items = new ArrayList<>();
	}
	
	public void addItems(Integer n) {
		for(int i = 0; i < n; i++) {
			System.out.printf("Item #%d: \n", (i+1));
			System.out.print("Nome do produto: ");
			String name = sc.nextLine();
			System.out.print("Preco: ");
			double price = sc.nextDouble();
			items.add(new Item(name, price));
			sc.nextLine();
		}
	}
	
	public double getPrice(String name) {
		double aux = 0.0;
		for(Item obj : items) {
			if(name.equals(obj.getName())) {
				aux = obj.getPrice();
			}
		}
		return aux;
	}
	
	public Integer getNmrItems() {
		return items.size();
	}
	
	public void printCardapio() {
		System.out.println("---Cardapio---");
		for(Item obj : items) {
			System.out.println(obj);
		}
	}
}
