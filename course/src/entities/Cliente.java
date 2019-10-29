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
	
	public boolean addPedido(Cardapio card) {
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
			return true;
		}
		return false;
	}
	
	public void esvaziaPedido() {
		for(int i = this.getNmrPedidos(); i > 0; i--) {
			pedidos.remove(i-1);
		}
	}
	
	public void printPedidos() {
		System.out.println("Cliente " + name);
		System.out.println("Pedidos.:");
		for(String obj : pedidos) {
			System.out.println(">" + obj);
		}
	}
	
	public Integer getNmrPedidos() {
		int i = 0;
		for(String obj : pedidos) {
			i++;
		}
		return i;
	}
	
	public boolean rmvPedido(Cardapio card) {
		double price = 0.0;
		if(this.getNmrPedidos() > 0) {
			this.printPedidos();
			System.out.println("Qual dos items deve ser cancelado?: ");
			sc.nextLine();
			String name = sc.nextLine();
			price = card.getPrice(name);
			this.contaC -= price;
			pedidos.remove(name);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return name;
	}
}
