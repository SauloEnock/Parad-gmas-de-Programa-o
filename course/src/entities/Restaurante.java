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
		int i = 0;
		for(Mesa obj : mesas) {
			i++;
		}
		return i;
	}

	@Override
	public String toString() {
		return "\nRestaurante " + name + " - " + stars + " Estrelas";
	}
	
	public void printCardapio() {
		cardapio.printCardapio();
	}
	
	public void addMesa(Mesa table) {
		mesas.add(table);
	}
	
	public boolean addClienteMesaN(String name, Integer nmrMesa) {
		for(Mesa obj : mesas) {
			if(obj.getTableNumber() == nmrMesa) {
				obj.addClientes(name);
				return true;
			}
		}
		return false;
	}
	
	public boolean removerCliente(Integer nmrMesa, String name) {
		for(Mesa obj : mesas) {
			if(obj.getTableNumber() == nmrMesa) {
				return obj.removerCliente(name);
			}
		}
		return false;
	}
	
	public boolean addPedido(Integer nmrMesa, String name) {
		for(Mesa obj : mesas) {
			if(obj.getTableNumber() == nmrMesa) {
				return obj.addPedido(name, cardapio);
			}
		}
		return false;
	}
	
	public boolean rmvPedido(Integer nmrMesa, String name) {
		for(Mesa obj : mesas) {
			if(obj.getTableNumber() == nmrMesa) {
				return obj.rmvPedido(name, cardapio);
			}
		}
		return false;
	}
	
	public boolean fechaConta(Integer nmrMesa) {
		double contaMesa = 0.0;
		if(this.getNmrTables() > 0) {
			for(Mesa obj : mesas) {
				if(obj.getTableNumber() == nmrMesa) {
					contaMesa = obj.fechaConta();
					System.out.println("Conta Mesa [" + nmrMesa + "] - R$" + contaMesa);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean encerraDia() {
		double contaMesa = 0.0;
		if(this.getNmrTables() > 0) {
			for(Mesa obj : mesas) {
				if(obj.getNmrClientes() > 0) {
					contaMesa = obj.fechaConta();
					System.out.println("Conta Mesa [" + obj.getTableNumber() + "] - R$" + contaMesa);
				}
			}
			return true;
		}
		return false;
	}
	
	public void printMesas() {
		for(Mesa obj : mesas) {
			System.out.println(obj);
			obj.printClientes();
		}
	}
}
