package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.util.Cores;
import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class menu {

	
	public static void main(String[] args) {
		
		ContaController contas = new ContaController();
		
		Scanner ler = new Scanner(System.in);
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		
		System.out.println("\nCriar contas\n");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Joâo da Silva", 1000f, 100.0f);
		contas.Cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.Cadastrar(cc2);
		
		ContaCorrente cp1 = new ContaCorrente(contas.gerarNumero(), 125, 2, "Maria dos Santos", 4000f, 12);
		contas.Cadastrar(cp1);
		
		ContaCorrente cp2 = new ContaCorrente(contas.gerarNumero(), 126, 2, "Juliana Ramos", 8000f, 15);
		contas.Cadastrar(cp2);
		
		contas.ListaTodas();
		
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
			
			try {
				opcao = ler.nextInt();
			}catch(InputMismatchException e){
				System.out.println("\nDigite valores inteiros!");
				ler.nextLine();
				opcao=0;
			}

			if (opcao == 9) {
				System.out.println("\nBanco do Brazil com Z - O seu futuro começa aqui!");
				sobre();
                 		ler.close();
				System.exit(0);
			}
			
			switch(opcao) {
				case 1:
					System.out.println(Cores.TEXT_WHITE_BOLD + "Opção para criar a conta");
					
					System.out.println("Digite o número da Agência: ");
					agencia = ler.nextInt();
					System.out.println("Digite o nome do titular: ");
					ler.skip("\\R?");
					titular = ler.nextLine();
					
					do {
						System.out.println("Digite o Tipo de conta (1-CC ou 2-CP): ");
						tipo = ler.nextInt();
					}while(tipo < 1 && tipo > 2);
					
					System.out.println("Digite o saldo da conta (R$): ");
					saldo = ler.nextFloat();
					
					switch(tipo) {
					case 1 -> {
						System.out.println("Digite o limite do crédito (R$): ");
						limite = ler.nextFloat();
						contas.Cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o aniversário da conta: ");
						aniversario = ler.nextInt();
						contas.Cadastrar(new ContaPoupanca(contas.gerarNumero(),agencia, tipo, titular, saldo,aniversario));
						}
					}
					
					keyPress();
					break;
					
				case 2: 
					System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as contas");
					contas.ListaTodas();
					keyPress();
					break;
					
				case 3: 
					System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por números\n\n");
					
					System.out.println("Digite o número da conta: ");
					numero = ler.nextInt();
					
					contas.ProcurarPorNumero(numero);
					
					keyPress();
					break;
					
				case 4:
					System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar os dados da conta\n\n");
					
					System.out.println("Digite o número da conta: ");
					numero = ler.nextInt();
					
					var buscaConta = contas.buscarNaCollection(numero);
					
					if(buscaConta != null) {
						
						tipo = buscaConta.getTipo();
						
						System.out.println("Digite o número agência: ");
						agencia = ler.nextInt();
						System.out.println("Digite o nome do titular: ");
						ler.skip("\\R");
						titular = ler.nextLine();
						
						System.out.println("Digite o saldo da conta (R$): ");
						saldo = ler.nextFloat();
						
						switch (tipo) {
							case 1 ->  {
								System.out.println("Digite o limite de crédito (R$): ");
								limite = ler.nextFloat();
							
								contas.Atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
							}
						
							case 2 -> {
								System.out.println("Digite o dia do aniversário: ");
								aniversario = ler.nextInt();
							
								contas.Atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
							}
						
							default -> {
								System.out.println("Tipo inválido!");
							
								}
							
							}
						}else {
							System.out.println("A conta não foi encontrada!");
						}
					
					keyPress();
					break;
					
				case 5:
					System.out.println(Cores.TEXT_WHITE_BOLD + "\nApagar conta");
					
					System.out.println("Digite o número da conta: ");
					numero = ler.nextInt();
					
					contas.Deletar(numero);
					
					keyPress();
					break;
					
				case 6:
					System.out.println(Cores.TEXT_WHITE_BOLD + "Sacar\n\n");
					
					System.out.println("Digite o numero da conta: ");
					numero = ler.nextInt();
					
					do {
						System.out.println("Digite o valor do saque (R$): ");
						valor = ler.nextFloat();
					}while(valor <= 0);
					
					contas.sacar(numero, valor);
					
					keyPress();
					break;
					
				case 7:
					System.out.println(Cores.TEXT_WHITE_BOLD + "\nDepositar");
					
					System.out.println("Digite o numero da conta: ");
					numero = ler.nextInt();
					
					do {
						System.out.println("Digite o valor do deposito (R$): ");
						valor = ler.nextFloat();
					}while(valor <= 0);
					
					keyPress();
					break;
					
				case 8:
					System.out.println(Cores.TEXT_WHITE_BOLD + "\nTransferir valores entre Contas");
					
					System.out.println("Digite o numero da conta de Origem: ");
					numero = ler.nextInt();
					System.out.println("Digite o numero da conta de Destino: ");
					numeroDestino = ler.nextInt();
					
					do {
						System.out.println("Digite o valor da Transferência (R$)");
						valor = ler.nextFloat();
					}while(valor <= 0);
					
					keyPress();
					break;
			
					
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "Opção inválida!");
					
					break;
					
					}
				}
					
			}
			
			public static void sobre() {
				System.out.println("\n*********************************************************");
				System.out.println("Projeto Desenvolvido por: Gabriel Alves ");
				System.out.println("Generation Brasil - generation@generation.org");
				System.out.println("github.com/conteudoGeneration");
				System.out.println("*********************************************************");
		
			}
			
			public static void keyPress() {

				try {

					System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
					System.in.read();

				} catch (IOException e) {

					System.out.println("Você pressionou uma tecla diferente de enter!");

			}
		}
}
