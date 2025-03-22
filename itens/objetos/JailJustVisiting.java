package itens.objetos;

import java.util.Scanner;

public class JailJustVisiting extends Lugar {

    public JailJustVisiting(String nome, String posicao) {
        super(nome, posicao);
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println(
                "Nome: " + getNome() + ", Posição: " + getPosicao() + " - Você está apenas visitando a prisão.");
    }

    @Override
    public void Acao(Player jogadorAtual, Player[] jogadores, Scanner scanner) {
        System.out.println(jogadorAtual.getNome() + " caiu no " + getNome());

    }
}
