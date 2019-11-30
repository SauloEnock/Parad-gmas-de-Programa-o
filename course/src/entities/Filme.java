package entities;

public class Filme {
	private String nome;
	private Time duracao;
	
	public Filme() {
	}
	
	public Filme(String nome, Time duracao) {
		this.nome = nome;
		this.duracao = duracao;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Time getDuracao() {
		return duracao;
	}
	
	public void setDuracao(Time aux) {
		this.duracao = aux;
	}
}
