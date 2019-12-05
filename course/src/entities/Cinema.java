package entities;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Cinema {
	public static int nmrSalas = 5; 
	private List<Sala> salas;
	
	Scanner sc = new Scanner(System.in);
	
	public Cinema() {
		this.salas = new ArrayList<>();
	}
	
	public void addSala() {
		salas.add(new Sala());
	}
	
	public void addSessao(int nmrSala, Filme aux) {
		salas.get(nmrSala-1).addSessao(aux);
	}
	
	public void rmvSessao(int nmrSala, String nomeF) {
		salas.get(nmrSala-1).rmvSessao(nomeF);
	}
	
	public void alteraSessao(int nmrSala, String nomeF, Filme aux) {
		salas.get(nmrSala-1).alteraSessao(nomeF, aux);
	}
	
	public void printSessoes(int nmrSala) {
		salas.get(nmrSala-1).printSessoes();
	}
	
	public void printAllSessoes(int nmrSala) {
		salas.get(nmrSala-1).printAllSessoes();
	}
	
	public void comprarIngresso(int nmrSala, String nome, int nmrIng) {
		salas.get(nmrSala-1).comprarIngresso(nome, nmrIng);
	}
	
	public void iniciaSessao(int nmrSala) {
		salas.get(nmrSala-1).setFlag(true);
	}
	
	public void encerraSessao(int nmrSala) {
		salas.get(nmrSala-1).encerraSessao();
	}
	
	public void printSalas() {
		System.out.println("\nSalas.:");
		for(Sala obj : salas) {
			System.out.println(obj);
		}
		System.out.println();
	}
}
