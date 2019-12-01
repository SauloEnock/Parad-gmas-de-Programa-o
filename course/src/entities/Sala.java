package entities;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Sala {
	public static int n = 0;
	private int nmr;
	private int lugares;
	private boolean flag;
	private Time lastSession;
	private List<Sessao> sessoes;
	
	Scanner sc = new Scanner(System.in);
	
	public Sala(int lugares) {
		this.nmr = n;
		this.lugares = lugares;
		this.flag = false;
		lastSession = new Time("13:20:00");
		this.sessoes = new ArrayList<>();
	}
	
	public int getNmr() {
		return nmr;
	}

	public int getLugares() {
		return lugares;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public int getFirst() {
		int i = 0; String aux = "removido";
		for(Sessao obj : sessoes) {
			if(aux.equals(obj.getFilme().getNome()) == false) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public void addSessao(Filme filme) {
		boolean verif = false; String aux = "removido";
		for(Sessao obj : sessoes) {
			if(aux.equals(obj.getFilme().getNome()) == true) {
				if(obj.getFilme().getDuracao().menorIgual(filme.getDuracao())) {
					obj.setFilme(filme);
					verif = true;
				}
			}
		}
		if(verif == false) {
			sessoes.add(new Sessao(lugares, new Date(), lastSession, filme));
			lastSession = sessoes.get(sessoes.size()-1).getFim();
		}
	}
	
	public void rmvSessao(String nomeF) {
		for(Sessao obj : sessoes) {
			if(nomeF.equals(obj.getFilme().getNome())) {
				obj.rmvFilme();
				break;
			}
		}
	}
	
	public void alteraSessao(String nomeF, Filme filme) {
		for(Sessao obj : sessoes) {
			if(nomeF.equals(obj.getFilme().getNome())) {
				if(obj.getFilme().getDuracao().menorIgual(filme.getDuracao())) {
					obj.setFilme(filme);
				}else {
					System.out.println("A duração do filme é maior que o limite!");
				}
				return;
			}
		}
	}
	
	public void comprarIngresso(String nome, int nmrIng) {
		for(Sessao obj : sessoes) {
			if(nome.equals(obj.getFilme().getNome())) {
				if(obj.getNmrIng() > 0) {
					obj.comprarIngresso(nmrIng);
				}else {
					System.out.println("A sessao nao tem mais ingressos disponiveis!");
				}
			}
		}
	}
	
	public void printSessoes() {
		String aux = "removido";
		System.out.println("Sessoes.: ");
		for(Sessao obj : sessoes) {
			if(aux.equals(obj.getFilme().getNome()) == false) {
				System.out.println(obj);
			}
		}
		System.out.println();
	}
	
	public void printAllSessoes() {
		for(Sessao obj : sessoes) {
			System.out.println(obj);
		}
	}
	
	@Override
	public String toString() {
		String aux = "\nSala " + nmr + " - " + lugares +" lugares - " + (sessoes.size()) + " Sess(ao/oes)";
		if(sessoes.size() > 0 && this.getFirst() > -1) {
			Filme auxF = sessoes.get(this.getFirst()).getFilme();
			aux += "\nSessao Atual: " + auxF.getNome() + " - Duracao: " + auxF.getDuracao().toString();
			aux += "\nInicio: " + sessoes.get(this.getFirst()).getInicio() + " - Fim: " + sessoes.get(this.getFirst()).getFim();
		}
		return aux;
	}
	
}
