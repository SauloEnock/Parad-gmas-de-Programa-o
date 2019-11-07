package entities;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
	private String name;
	private Double contaC;
	private List<String> pedidos;
	
	Scanner sc = new Scanner(System.in);
	
	public Cliente() {
	}
	
	public Cliente(String name) {
		this.name = name;
		this.contaC = 0.0;
		pedidos = new ArrayList<>();
	}

	public String getName() {
		return name;
	}
	
	public Double getContaC() {
		return contaC;
	}
	
	public void addPedido(Cardapio card) {
		if(card.getNmrItems() > 0) {
			card.printCardapio();
			System.out.print("Quantos items deseja pedir?: ");
			int n = sc.nextInt();
			double price = 0.0;
			for(int i = 0; i < n; i++) {
				System.out.printf("Item #%d: \n", (i+1));
				sc.nextLine();
				System.out.print("Nome do produto: ");
				String name = sc.nextLine();
				System.out.print("Quantidade: ");
				int quant = sc.nextInt();
				price = card.getPrice(name);
				this.contaC += (price * quant);
				if(quant > 0 && price > 0.0) { 
					for(int j = 0; j < quant; j++) {
						pedidos.add(name);
					}
				}
			}
		}
	}
	
	public void esvaziaPedido() {
		pedidos.clear();
	}
	
	public void printPedidos() {
		System.out.println("Cliente " + name);
		System.out.println("Pedidos.:");
		for(String obj : pedidos) {
			System.out.println(">" + obj);
		}
	}
	
	public Integer getNmrPedidos() {
		return pedidos.size();
	}
	
	public void rmvPedido(Cardapio card) {
		double price = 0.0;
		if(this.getNmrPedidos() > 0) {
			this.printPedidos();
			System.out.println("Qual dos items deve ser cancelado?: ");
			sc.nextLine();
			String name = sc.nextLine();
			price = card.getPrice(name);
			this.contaC -= price;
			pedidos.remove(name);
		}
	}

	@Override
	public String toString() {
		return name;
	}
}
