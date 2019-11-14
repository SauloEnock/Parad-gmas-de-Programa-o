package entities;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Mesa { //BlackMesa 
	private Integer number;
	private Integer maxClients;
	public static int nmr = 0;
	private List<Cliente> clientes;
	
	Scanner sc = new Scanner(System.in);
	
	public Mesa() {
	}
	
	public Mesa(Integer maxClients) {
		this.number = nmr;
		this.maxClients = maxClients;
		clientes = new ArrayList<>();
	}
	
	public Integer getTableNumber() {
		return number;
	}
	
	public Integer getMaxClients() {
		return maxClients;
	}
	
	public void addClientes(String name) {
		clientes.add(new Cliente(name));
	}
	
	public Integer getNmrClientes() {
		return clientes.size();
	}
	
	public void addPedido(String name, Cardapio cardapio) {
		for(Cliente obj : clientes) {
			if(name.equals(obj.getName())) {
				obj.addPedido(cardapio);
			}
		}
	}
	
	public void rmvPedido(String name, Cardapio cardapio) {
		for(Cliente obj : clientes) {
			if(name.equals(obj.getName())) {
				obj.rmvPedido(cardapio);
			}
		}
	}
	
	public void removerCliente(String name) {
		Cliente aux = null;
		for(Cliente obj : clientes) {
			if(name.equals(obj.getName())) {
				System.out.println("Conta do cliente: R$" + obj.getContaC());
				aux = obj;
			}
		}
		if(aux != null){ clientes.remove(aux); }
	}
	
	public Double fechaConta() {
		double contaMesa = 0.0;
		if(this.getNmrClientes() > 0) {
			for(Cliente obj : clientes) {
				contaMesa += obj.getContaC();
				obj.esvaziaPedido();
			}
			clientes.clear();
		}
		return contaMesa;
	}
	
	public void printClientes() {
		System.out.println("Clientes.:");
		for(Cliente obj : clientes) {
			System.out.println(">" + obj);
		}
	}

	@Override
	public String toString() {
		return "Mesa [" + number + "] - Lugares Vagos:" + (maxClients - this.getNmrClientes());
	}
}
