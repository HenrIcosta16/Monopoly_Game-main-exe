package itens.objetos;

import java.util.Scanner;

public class FreeParking extends Lugar {

    public FreeParking(String nome, String posicao) {
        super(nome, posicao);
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Nome: " + getNome() + ", Posição: " + getPosicao() + " - Você está no Free Parking.");
    }

    @Override
    public void Acao(Player jogadorAtual, Player[] jogadores, Scanner scanner) {
        System.out.println(jogadorAtual.getNome() + " caiu no " + getNome() + "\n e nada aconteceu.");
    }
}
