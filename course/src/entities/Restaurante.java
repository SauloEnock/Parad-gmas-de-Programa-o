package entities;

import java.util.List;
import java.util.ArrayList;
import entities.Cardapio;

public class Restaurante {
	private String name;
	private Integer stars;
	private Integer maxTables;
	private Cardapio cardapio;
	private List<Mesa> mesas;

	public Restaurante() {
	}
	
	public Restaurante(String name, Integer stars, Integer maxTables, Cardapio cardapio) {
		this.name = name;
		this.stars = stars;
		this.maxTables = maxTables;
		this.cardapio = cardapio;
		mesas = new ArrayList<>();
	}

	public String getName() {
		return name;
	}
	
	public Integer getStars() {
		return stars;
	}

	public Integer getMaxTables() {
		return maxTables;
	}
	
	public Integer getNmrTables() {
		return mesas.size();
	}
	
	public void printCardapio() {
		cardapio.printCardapio();
	}
	
	public void addMesa(Mesa table) {
		mesas.add(table);
	}
	
	public void addClienteMesaN(String name, Integer nmrMesa) {
		mesas.get(nmrMesa - 1).addClientes(name);
	}
	
	public void removerCliente(Integer nmrMesa, String name) {
		mesas.get(nmrMesa - 1).removerCliente(name);
	}
	
	public void addPedido(Integer nmrMesa, String name) {
		mesas.get(nmrMesa - 1).addPedido(name, cardapio);
	}
	
	public void rmvPedido(Integer nmrMesa, String name) {
		mesas.get(nmrMesa - 1).rmvPedido(name, cardapio);
	}
	
	public void fechaConta(Integer nmrMesa) {
		double contaMesa = 0.0;
		if(this.getNmrTables() > 0) {
			contaMesa = mesas.get(nmrMesa - 1).fechaConta();
			System.out.println("Conta Mesa [" + nmrMesa + "] - R$" + contaMesa);
		}
	}
	
	public void encerraDia() {
		double contaMesa;
		if(this.getNmrTables() > 0) {
			for(Mesa obj : mesas) {
				contaMesa = 0.0;
				if(obj.getNmrClientes() > 0) {
					contaMesa = obj.fechaConta();
					System.out.println("Conta Mesa [" + obj.getTableNumber() + "] - R$" + contaMesa);
				}
			}
		}
	}
	
	public void printMesas() {
		for(Mesa obj : mesas) {
			System.out.println(obj);
			obj.printClientes();
		}
	}
	
	@Override
	public String toString() {
		return "\nRestaurante " + name + " - " + stars + " Estrelas";
	}
	
}
