package itens.objetos;

import java.util.Scanner;

public class Go extends Lugar {

    public Go(String nome, String posicao) {
        super(nome, posicao);
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println(
                "Nome: " + getNome() + ", Posição: " + getPosicao() + " - Você ganhou 200 reais ao cair no 'Go'.");
    }

    @Override
    public void Acao(Player jogadorAtual, Player[] jogadores, Scanner scanner) {
        System.out.println(jogadorAtual.getNome() + " caiu no " + getNome() + " e ganhou 200 reais");
        jogadorAtual.ganharDinheiro(200);
    }
}
