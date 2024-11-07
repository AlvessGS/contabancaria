package conta;

import java.util.Scanner;
import conta.util.Cores;
import conta.model.Conta;

public class menu {
	
	public static void main(String[] args) {
		
		//Teste de conta
		Conta c1 = new Conta(1, 123, 1, "Adriana", 10000.0f);
		c1.visualizar();
		c1.sacar(12000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();
		
		Scanner ler = new Scanner(System.in);
		int opcao;
		
		while(true) {
			
			System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND
					           + "************************************************************************************");
			System.out.println("                                                                                    ");
			System.out.println("                                 BANCO DO BRAZIL COM Z                              ");
			System.out.println("                                                                                    ");
			System.out.println("************************************************************************************");
			System.out.println("                                                                                    ");
			System.out.println("                               1 - Criar conta                                      ");
			System.out.println("                               2 - Listar todas as contas                           ");
			System.out.println("                               3 - Buscar conta por número                          ");
			System.out.println("                               4 - Atualizar dados da conta                         ");
			System.out.println("                               5 - Apagar conta                                     ");
			System.out.println("                               6 - Sacar                                            ");
			System.out.println("                               7 - Depositar                                        ");
			System.out.println("                               8 - Transferir valores entre contas                  ");
			System.out.println("                               9 - Sair                                             ");
			System.out.println("                                                                                    ");
			System.out.println("************************************************************************************");
			System.out.println("Entre com a opção:                                                                  ");
			System.out.println("                                                                                    "+Cores.TEXT_RESET);
														
			opcao = ler.nextInt();
			ler.nextLine();
			
			switch(opcao) {
				case 1:
					System.out.println(Cores.TEXT_WHITE_BOLD + "Opção para criar a conta");
					break;
					
				case 2: 
					System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as contas");
					break;
					
				case 3: 
					System.out.println(Cores.TEXT_WHITE_BOLD + "Buscar conta pior número");
					break;
					
				case 4:
					System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar os dados da conta");
					break;
					
				case 5:
					System.out.println(Cores.TEXT_WHITE_BOLD + "\nApagar conta");
					break;
					
				case 6:
					System.out.println(Cores.TEXT_WHITE_BOLD + "\nSacar");
					break;
					
				case 7:
					System.out.println(Cores.TEXT_WHITE_BOLD + "\nDepositar");
					break;
					
				case 8:
					System.out.println(Cores.TEXT_WHITE_BOLD + "\nTransferir valores entre Contas");
					break;
					
				case 9:
					System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND); 
					System.out.println("                                                                                    ");
					System.out.println("Banco do Brazil com Z - O seu futuro começa aqui!                                   ");
					System.out.println("                                                                                    ");
					System.out.println("************************************************************************************");
					System.out.println("                                                                                    ");
					System.out.println(" Projeto Desenvolvido por: Gabriel Alves                                            ");
					System.out.println(" Generation Brasil - generation@generation.org                                      ");
					System.out.println(" github/conteudo                                                                    ");
					System.out.println("                                                                                    ");
					System.out.println("************************************************************************************");
					System.out.println("                                                                                    "+Cores.TEXT_RESET);
					ler.close();
					return;
					
					
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "Opção inválida!");
			}
			System.out.println("************************************************************************************");
			System.out.println("                                                                                    ");
			System.out.println("Projeto Desenvolvido por: Gabriel Alves                                                                                    ");
			System.out.println("Generation Brasil - generation@generation.org ");
			System.out.println("github/conteudo                                                                                  ");
			System.out.println("                                                                                    ");
			System.out.println("************************************************************************************");
		}
		
	}
}
