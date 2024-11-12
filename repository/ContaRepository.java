package conta.repository;

import conta.model.Conta;

public interface ContaRepository {
	
	//CRUD da conta
	public void ProcurarPorNumero(int numero);
	public void ListaTodas();
	public void Cadastrar(Conta conta);
	public void Atualizar(Conta conta);
	public void Deletar(int numero);
	
	//Métodos bancários
	public void sacar(int numero, float valor);
	public void depositar(int numero, float valor);
	public void transferir(int numeroOrigem, int numeroDestino, float valor);

}
