package entities;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Mesa { //BlackMesa 
	private Integer number;
	private Integer maxClients;
	private List<Cliente> clientes;
	
	Scanner sc = new Scanner(System.in);
	
	public Mesa() {
	}
	
	public Mesa(Integer number, Integer maxClients) {
		this.number = number;
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
		Cliente a = new Cliente(name);
		clientes.add(a);
	}
	
	public Integer getNmrClientes() {
		int i = 0;
		for(Cliente obj : clientes) {
			i++;
		}
		return i;
	}
	
	public boolean addPedido(String name, Cardapio cardapio) {
		for(Cliente obj : clientes) {
			if(name.equals(obj.getName())) {
				return obj.addPedido(cardapio);
			}
		}
		return false;
	}
	
	public boolean rmvPedido(String name, Cardapio cardapio) {
		for(Cliente obj : clientes) {
			if(name.equals(obj.getName())) {
				return obj.rmvPedido(cardapio);
			}
		}
		return false;
	}
	
	public boolean removerCliente(String name) {
		for(Cliente obj : clientes) {
			if(name.equals(obj.getName())) {
				System.out.println("Conta do cliente: R$" + obj.getContaC());
				clientes.remove(obj);
				return true;
			}
		}
		return false;
	}
	
	public Double fechaConta() {
		double contaMesa = 0.0;
		if(this.getNmrClientes() > 0) {
			for(Cliente obj : clientes) {
				contaMesa += obj.getContaC();
				obj.esvaziaPedido();
			}
			for(int i = this.getNmrClientes(); i > 0; i--) {
				clientes.remove(i-1);
			}
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
