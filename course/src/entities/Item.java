package entities;

public class Item {
	private String name;
	private Double price;
	
	public Item() {
	}
	
	public Item(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public Double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return name + " - R$" + price;
	}
}
