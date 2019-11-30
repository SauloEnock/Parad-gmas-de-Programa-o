package course;

import java.util.Locale; //Locale.setDefault(Locale.US);
import java.util.Scanner; //Scanner sc = new Scanner(System.in);
//import entities.enums.Classe; // importação de enums
import entities.Cinema; // importaçao de classes
import entities.Sala;
import entities.Time;
import entities.Filme;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		boolean out = false;
		Cinema cine = new Cinema();
		
		System.out.print("Qual o numero de salas do cinema?: ");
		int salas = sc.nextInt();
		
		for(int i = 0; i < salas; i++) {
			System.out.println("Sala #" + (i+1));
			Sala.n++;
			cine.addSala();
		}
		
		cine.printSalas();
		
		while(out != true) {
			System.out.println("");
			System.out.println("[1] Adicionar Sessao");  
			System.out.println("[2] Remover Sessao"); //um cliente pode sentar em uma mesa vazia, ou se juntar a uma já ocupada
			System.out.println("[3] Alterar Sessao"); //printa o cardápio durante o pedido e adiciona um pedido
			System.out.println("[4] Comprar Ingresso"); //printa o cardápio durante o pedido e adiciona um pedido
			System.out.println("[0] Sair"); //encerra o programa
			System.out.print("Opcao escolhida: ");
			int opcao = sc.nextInt();
			
			switch(opcao) {
				case 1:
					System.out.println("\n[OPCAO 1 - ADICIONAR SESSAO]\n");
					System.out.print("Digite o nome do filme: ");
					sc.nextLine();
					String nome = sc.nextLine();
					System.out.print("Digite a duração do filme(no formato hh:mm:ss): ");
					sc.nextLine();
					String duracao = sc.nextLine();
					Filme aux = new Filme(nome, new Time(duracao));
					System.out.print("Em quantas salas o filme será exibido?: ");
					int salasE = sc.nextInt(); int p = 0;
					while(p < salasE) {
						cine.printSalas();
						System.out.print("Qual sala voce deseja adicionar a sessao?: ");
						int choice = sc.nextInt();
						cine.addSessao(choice, aux);
						p++;
					}
					break;
				case 2:
					System.out.print("\n[OPCAO 2 - REMOVER SESSAO]\n");
					cine.printSalas();
					System.out.print("Deseja remover sessoes de qual sala?: ");
					int salaR = sc.nextInt();
					cine.printSessoes(salaR);
					System.out.print("Deseja remover quantas sessoes?: ");
					int nRmv = sc.nextInt(); int k = 0;
					while(k < nRmv) {
						System.out.print("Qual o filme o qual deseja que seja retirado das sessoes?: ");
						sc.nextLine();
						String nomeRmv = sc.nextLine();
						cine.rmvSessao(salaR, nomeRmv);
						k++;
					}
					break;
				case 3:
					System.out.println("\n[OPCAO 3 - ALTERAR SESSAO]\n");
					cine.printSalas();
					System.out.print("Deseja alterar sessoes de qual sala?: ");
					int salaA = sc.nextInt();
					cine.printAllSessoes(salaA);
					System.out.print("Deseja alterar quantas sessoes?: ");
					int nAlt = sc.nextInt(); int y = 0;
					while(y < nAlt) {
						System.out.print("Qual o filme o qual deseja que seja alterado?: ");
						sc.nextLine();
						String nomeAlt = sc.nextLine();
						System.out.print("Digite o nome do filme substituto: ");
						sc.nextLine();
						String nomeA = sc.nextLine();
						System.out.print("Digite a duração do filme(no formato hh:mm:ss): ");
						sc.nextLine();
						String duracaoA = sc.nextLine();
						cine.alteraSessao(salaA, nomeAlt, new Filme(nomeA, new Time(duracaoA)));
						y++;
					}
					break;
				case 4:
					System.out.println("\n[OPCAO 4 - COMPRAR INGRESSO]\n");
					char letra; String nome2;
					do{
						cine.printSalas();
						System.out.print("Deseja ver as sessoes de qual sala?: ");
						int salaS = sc.nextInt();
						cine.printSessoes(salaS);
						System.out.print("Desejar assistir qual filme?: ");
						sc.nextLine();
						nome2 = sc.nextLine();
						System.out.print("Quantos ingressos?: ");
						int nmrIng = sc.nextInt();
						cine.comprarIngresso(salaS, nome2, nmrIng);
						System.out.print("Continuar comprando(S/N)?: ");
						letra = sc.next().charAt(0);
					}while(letra != 'N' && letra != 'n');
					break;
				case 0:
					System.out.println("\n[SAIR]\n");
					out = true;
					break;
				default:
					System.out.println("\n[OPCAO INVALIDA!]\n");
					break;
			}
		}
		
		sc.close();
	}
	
}
