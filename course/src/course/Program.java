package course;

import java.util.Locale; //Locale.setDefault(Locale.US);
import java.util.Scanner; //Scanner sc = new Scanner(System.in);
//import entities.enums.Classe; // importa��o de enums
import entities.Cinema; // importa�ao de classes
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
		
		for(int i = 0; i < Cinema.nmrSalas ; i++) {
			Sala.n++;
			cine.addSala();
		}
		
		//cine.printSalas();
		
		while(out != true) {
			System.out.println("");
			System.out.println("[1] Adicionar Sessao");  //cria um filme e adiciona em N sessoes
			System.out.println("[2] Remover Sessao"); //remove N sessoes de uma sala espec�fica
			System.out.println("[3] Alterar Sessao"); //altera N sessoes de uma sala espec�fica
			System.out.println("[4] Comprar Ingresso"); //compra N ingressos apos uma procura nas salas e sessoes
			System.out.println("[5] Iniciar Sessao"); //altera N sessoes de uma sala espec�fica
			System.out.println("[6] Encerrar Sessao"); //compra N ingressos apos uma procura nas salas e sessoes
			System.out.println("[0] Sair"); //encerra o programa
			System.out.print("Opcao escolhida: ");
			int opcao = sc.nextInt();
			
			switch(opcao) {
				case 1:
					System.out.println("\n[OPCAO 1 - ADICIONAR SESSAO]\n");
					System.out.print("Digite o nome do filme: ");
					sc.nextLine();
					String nome = sc.nextLine();
					System.out.print("Digite a dura��o do filme(no formato hh:mm:ss): ");
					sc.nextLine();
					String duracao = sc.nextLine();
					Filme aux = new Filme(nome, new Time(duracao));
					System.out.print("Em quantas sessoes o filme ser� exibido?: ");
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
						System.out.print("Digite a dura��o do filme(no formato hh:mm:ss): ");
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
						System.out.println("Sala #" + salaS);
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
				case 5:
					System.out.println("\n[OPCAO 5 - INICIAR SESSAO]\n");
					cine.printSalas();
					System.out.print("Deseja iniciar a sessao de qual sala?: ");
					int salaI = sc.nextInt();
					cine.iniciaSessao(salaI);
					break;
				case 6:
					System.out.println("\n[OPCAO 6 - ENCERRA SESSAO]\n");
					cine.printSalas();
					System.out.print("Deseja encerrar a sessao de qual sala?: ");
					int salaE = sc.nextInt();
					cine.encerraSessao(salaE);
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
