package entities;

public class Time {
	private int horas;
	private int minutos;
	private int segundos;
	
	public Time(String aux) {
		String[] vet = aux.split(":");
		this.horas = Integer.parseInt(vet[0]);
		this.minutos = Integer.parseInt(vet[1]);
		this.segundos = Integer.parseInt(vet[2]);
	}
	
	public int getHoras() {
		return horas;
	}

	public int getMinutos() {
		return minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void copiaTime(Time aux) {
		this.segundos = aux.getSegundos();
		this.minutos = aux.getMinutos();
		this.horas = aux.getHoras();
	}
	
	public boolean menorIgual(Time aux) {
		if(this.horas > aux.getHoras()) {
			return true;
		}else if(this.horas == aux.getHoras()) {
			if(this.minutos > aux.getMinutos()){
				return true;
			}else if(this.minutos == aux.getMinutos()){
				if(this.segundos >= aux.getSegundos()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void somaTime(Time aux) {
		int auxN = aux.getSegundos();
		this.segundos += auxN;
		if(this.segundos > 60) {
			this.segundos -= 60;
			this.minutos++;
		}
		auxN = aux.getMinutos();
		this.minutos += auxN;
		if(this.minutos > 60) {
			this.minutos -= 60;
			this.horas++;
		}
		auxN = aux.getHoras();
		this.horas += auxN;
		if(this.horas > 24) {
			this.horas -= 24;
		}
	}

	@Override
	public String toString() {
		String aux = "";
		if(this.horas < 10) { 
			aux += "0" + this.horas;
		}else {
			aux += this.horas;
		}
		aux += ":";
		if(this.minutos < 10) { 
			aux += "0" + this.minutos;
		}else {
			aux += this.minutos;
		}
		aux += ":";
		if(this.segundos < 10) { 
			aux += "0" + this.segundos;
		}else {
			aux += this.segundos;
		}
		return aux;
	}
	
	
}
