package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void ProcurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta!= null)
			conta.visualizar();
		else
			System.out.println("\nA conta número: "+numero+" não foi encontrada!");
		
	}

	@Override
	public void ListaTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nA conta número "+ conta.getNumero() + " foi criada com sucesso!");
		
	}

	@Override
	public void Atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if(buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("\nA conta numero: "+conta.getNumero() + " foi atualizada com sucesso!");
		}else
			System.out.println("\nA conta numero: "+conta.getNumero() + " não foi encontrada!");
		
	}

	@Override
	public void Deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			if (listaContas.remove(conta) == true)
				System.out.println("\nA conta numero: "+numero+ " foi deletada com sucesso!");
		}else {
			System.out.println("\nA conta numero: "+numero+ " não foi encontrada!");
			
		}
		
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			
			if(conta.sacar(valor) == true) {
				System.out.println("\nO saque da Conta numero: "+numero+ " foi efetuado com sucesso!");
			
			}else {
				System.out.println("\nA conta numero: "+numero+ " não foi encontrada!");
			}
		}
		
	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			conta.depositar(valor);
			System.out.println("\nO deposito na conta número: "+numero+ " foi efetuado com sucesso!");
		}else {
			System.out.println("\nA conta número: "+numero+ " não foi encontrada ou a conta destino não é uma conta corrente!");
		}
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if (contaOrigem != null && contaDestino != null) {
			
			if (contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.println("\nA transferência foi efetuada com sucesso!");
			}
			
		}else
			System.out.println("\nA conta de Origem e /ou destino não foram encontradas!");
		
	}
	
	public int gerarNumero() {
		return ++ numero;
	}
	
	public Conta buscarNaCollection (int  numero) {
		for (var conta: listaContas) {
			if(conta.getNumero()== numero) {
				return conta;
			}
		}
		return null;
	}

}
