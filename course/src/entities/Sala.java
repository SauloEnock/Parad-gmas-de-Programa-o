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
			if(obj.getFilme().getNome().length() < 7) {
				return i;
			}else {
				if(aux.equals(obj.getFilme().getNome().substring(0, 8)) == false) {
					return i;
				}
			}
			i++;
		}
		return -1;
	}

	public void addSessao(Filme filme) {
		boolean verif = false; String aux = "removido";
		for(Sessao obj : sessoes) {
			if(obj.getFilme().getNome().length() >= 8) {
				if(aux.equals(obj.getFilme().getNome().substring(0, 8)) == true) {
					if(obj.getFilme().getDuracao().menorIgual(filme.getDuracao())) {
						obj.getFilme().setNome(filme.getNome());
						obj.getFilme().setDuracao(filme.getDuracao());
						verif = true;
					}
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
					obj.getFilme().setNome(filme.getNome());
					obj.getFilme().setDuracao(filme.getDuracao());
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
					obj.comprarIngresso(nmrIng, this.nmr);
				}else {
					System.out.println("A sessao nao tem mais ingressos disponiveis!");
				}
			}
		}
	}
	
	public void encerraSessao() {
		this.setFlag(false);
		sessoes.remove(this.getFirst());
	}
	
	public void printSessoes() {
		String aux = "removido";
		System.out.println("\nSessoes.: ");
		for(Sessao obj : sessoes) {
			if(obj.getFilme().getNome().length() >= 8) {
				if(aux.equals(obj.getFilme().getNome().substring(0, 8)) == false) {
					System.out.println(obj);
				}
			}else {
				System.out.println(obj);
			}
		}
		System.out.println();
	}
	
	public void printAllSessoes() {
		System.out.println("\nSessoes.: ");
		for(Sessao obj : sessoes) {
			System.out.println(obj);
		}
	}
	
	public int nmrSessoes() {
		int i = 0; String aux = "removido";
		for(Sessao obj : sessoes) {
			if(obj.getFilme().getNome().length() >= 8) {
				if(aux.equals(obj.getFilme().getNome().substring(0, 8)) == false) {
					i++;
				}
			}else {
				i++;
			}
		}
		return i;
	}
	
	@Override
	public String toString() {
		String aux = "\nSala " + nmr + " - " + lugares +" lugares - " + this.nmrSessoes() + " Sess(ao/oes)";
		if(sessoes.size() > 0 && this.getFirst() > -1) {
			Filme auxF = sessoes.get(this.getFirst()).getFilme();
			if(this.flag == true) { aux += "\n[Sessao Em Andamento]"; }
			aux += "\nSessao Atual: " + auxF.getNome() + " - Duracao: " + auxF.getDuracao().toString();
			aux += "\nInicio: " + sessoes.get(this.getFirst()).getInicio() + " - Fim: " + sessoes.get(this.getFirst()).getFim();
		}
		return aux;
	}
	
}
