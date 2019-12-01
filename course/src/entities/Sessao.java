package entities;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Sessao {
	private int nmrIng;
	private Date date;
	private Time inicio;
	private Time fim;
	private Filme filme;
	
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	
	public Sessao(int nmrIng, Date date, Time inicio, Filme filme) {
		this.nmrIng = nmrIng;
		this.date = date;
		this.inicio = new Time(inicio.toString());
		this.fim = new Time(inicio.toString());
		this.fim.somaTime(filme.getDuracao());
		this.filme = new Filme();
		this.filme.setNome(filme.getNome());
		this.filme.setDuracao(filme.getDuracao());
	}
	
	public Date getDate() {
		return date;
	}
	
	public int getNmrIng() {
		return nmrIng;
	}

	public Time getInicio() {
		return inicio;
	}

	public Time getFim() {
		return fim;
	}
	
	public Filme getFilme() {
		return filme;
	}
	
	public void setFilme(Filme aux) {
		this.filme.setNome(filme.getNome());
		this.filme.setDuracao(filme.getDuracao());
	}
	
	public void rmvFilme() {
		this.filme.setNome("removido");
	}

	public void setNmrIng(int nmrIng) {
		this.nmrIng = nmrIng;
	}
	
	public void comprarIngresso(int nmrIng) {
		if(nmrIng <= this.nmrIng) {
			System.out.print("Quantos ingressos são meias?: ");
			int meias = sc.nextInt();
			this.printIngresso(nmrIng, meias);
		}else {
			System.out.println("Esta sessao nao tem ingressos disponiveis suficientes para a compra!");
		}
	}
	
	public void printIngresso(int nmrIng, int nmrMeia) {
		System.out.println("\n[Ingresso]");
		System.out.println(sdf1.format(date));
		System.out.println("[" + filme.getNome() + "]");
		System.out.println("Duracao: " + filme.getDuracao());
		System.out.println("Horario: " + this.getInicio() + " - " + this.getFim());
		System.out.println("Inteiras: " + (nmrIng - nmrMeia));
		System.out.println("Meias: " + nmrMeia);
		this.nmrIng -= nmrIng;
	}
	
	@Override
	public String toString() {
		String aux = filme.getNome() + " - " + nmrIng + " Ingressos\n";
		aux += "Inicio: " + inicio + " - Fim: " + fim + "\n";
		return aux;
	}
	
}
