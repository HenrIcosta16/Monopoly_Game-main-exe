package itens.objetos;

import java.util.Scanner;

public class ImpostoDeRenda extends Imposto {

    public ImpostoDeRenda(String nome, String posicao, int valor) {
        super(nome, posicao, valor);
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome + ", Posição: " + posicao);
    }

    @Override
    public void Acao(Player jogadorAtual, Player[] jogadores, Scanner scanner) {
        System.out.println(jogadorAtual.getNome() + " caiu no " + this.getNome() + " e perdeu " + getValor()
                + " reais para o banco.");
        jogadorAtual.fazerPagamento(getValor());
    }
}