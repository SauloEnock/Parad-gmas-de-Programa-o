package course;

import java.util.Locale; //Locale.setDefault(Locale.US);
import java.util.Scanner; //Scanner sc = new Scanner(System.in);
//import entities.enums.Classe; // importação de enums
import entities.Restaurante; // importaçao de classes
import entities.Cardapio;
import entities.Mesa;

public class Program {

	public static void main(String[] args){
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Restaurante rest = null;
		boolean out = false;
		
		while(out != true) {
			System.out.println("");
			System.out.println("[1] Registrar Restaurante");  
			System.out.println("[2] Inserir Cliente"); //um cliente pode sentar em uma mesa vazia, ou se juntar a uma já ocupada
			System.out.println("[3] Remover Cliente"); //o cliente sai da mesa e tem sua conta individual fechada automaticamente
			System.out.println("[4] Fazer pedido"); //printa o cardápio durante o pedido e adiciona um pedido
			System.out.println("[5] Cancelar pedido"); //remove um pedido de um cliente especifico
			System.out.println("[6] Fechar a conta"); //fecha a conta de uma mesa específica
			System.out.println("[7] Encerrar o dia"); //fecha a conta de todas as mesas ainda existentes
			System.out.print("Opcao escolhida: ");
			int opcao = sc.nextInt();
			
			switch(opcao) {
				case 1:
					System.out.println("\n[OPCAO 1 - RESGISTRAR RESTAURANTE]\n");
					if(rest == null) {
						System.out.print("Nome: ");
						sc.nextLine();
						String name = sc.nextLine();
						System.out.print("Estrelas(1-5): ");
						int stars = sc.nextInt();
						System.out.print("Quantas mesas o restaurante possui?: ");
						int mesas = sc.nextInt();
						Cardapio crdp = new Cardapio();
						System.out.print("Quantos items existem no cardapio?: ");
						int nmrCard = sc.nextInt();
						crdp.addItems(nmrCard);
						rest = new Restaurante(name, stars, mesas, crdp);
						if(rest != null) {
							System.out.println("\n[Restaurante registrado com sucesso!]");
						}
					}else {
						System.out.println("\n[Restaurante ja registrado!]");
					}
					break;
				case 2:
					System.out.println("\n[OPCAO 2 - ADICIONAR CLIENTE]\n");
					if(rest != null) {
						System.out.print("Nome do cliente: ");
						sc.nextLine();
						String name = sc.nextLine();
						System.out.println("O cliente ira.:");
						System.out.println("[1] Sentar-se em uma mesa vazia");
						System.out.println("[2] Juntar-se a uma mesa ocupada");
						System.out.print("Opcao escolhida.: ");
						int choice = sc.nextInt();
						if(choice == 1) {
							if(rest.getNmrTables() < rest.getMaxTables()) {
								System.out.print("Quantos lugares a mesa possui?: ");
								int lugares = sc.nextInt();
								Mesa.nmr++;
								Mesa mesa = new Mesa(lugares);
								mesa.addClientes(name);
								rest.addMesa(mesa);
								System.out.println("\n[Cliente adicionado com sucesso!]");
							}else {
								System.out.println("\n[Nao ha mesas vazias!]");
							}
						}else if(choice == 2){
							rest.printMesas();
							System.out.print("A qual mesa o cliente ira se juntar?: ");
							int nMesa = sc.nextInt();
							rest.addClienteMesaN(name, nMesa);
							System.out.println("\n[Cliente adicionado a mesa com sucesso!]");
						}else {
							System.out.println("[OPCAO INVALIDA!]");
						}
					}else {
						System.out.println("\n[Restaurante nao existe!]");
					}
					break;
				case 3:
					System.out.println("\n[OPCAO 3 - REMOVER CLIENTE]\n");
					if(rest != null) {
						rest.printMesas();
						System.out.print("Remover de qual mesa?: ");
						int nMesa = sc.nextInt();
						System.out.print("Quem ira sair?: ");
						sc.nextLine();
						String name = sc.nextLine();
						rest.removerCliente(nMesa, name);
					}
					break;
				case 4:
					System.out.println("\n[OPCAO 4 - FAZER PEDIDO]\n");
					if(rest != null) {
						rest.printMesas();
						System.out.print("\nO pedido sera feito em qual mesa?: ");
						int nMesa = sc.nextInt();
						System.out.print("Qual cliente ira fazer o pedido?: ");
						sc.nextLine();
						String name = sc.nextLine();
						rest.addPedido(nMesa, name);
						System.out.println("\n[Pedido realizado com sucesso!]");
					}else {
						System.out.println("\n[Restaurante nao existe!]");
					}
					break;
				case 5:
					System.out.println("\n[OPCAO 5 - CANCELAR PEDIDO]\n");
					if(rest != null) {
						rest.printMesas();
						System.out.print("O pedido sera removido em qual mesa?: ");
						int nMesa = sc.nextInt();
						System.out.print("Qual cliente ira remover o pedido?: ");
						sc.nextLine();
						String name = sc.nextLine();
						rest.rmvPedido(nMesa, name);
						System.out.println("\n[Pedido cancelado com sucesso!]");
					}else {
						System.out.println("\n[Restaurante nao existe!]");
					}
					break;
				case 6:
					System.out.println("\n[OPCAO 6 - FECHAR A CONTA]\n");
					if(rest != null) {
						rest.printMesas();
						System.out.print("Qual mesa ira fechar a conta?: ");
						int nMesa = sc.nextInt();
						rest.fechaConta(nMesa);
						System.out.println("\n[Conta fechada com sucesso!]");
					}else {
						System.out.println("\n[Restaurante nao existe!]");
					}
					break;
				case 7:
					System.out.println("\n[OPCAO 7 - ENCERRAR O DIA]\n");
					if(rest != null) {
						System.out.println("[Restaurante " + rest.getStars() +  " Estrelas - " + rest.getName() + "]");
						rest.encerraDia();
						System.out.println("[Dia encerrado com sucesso!]");
						out = true;
					}else {
						System.out.println("\n[Restaurante nao existe!]");
					}
					break;
				default:
					System.out.println("\n[OPCAO INVALIDA!]\n");
					break;
			}
		}
		sc.close();
	}
	
}
