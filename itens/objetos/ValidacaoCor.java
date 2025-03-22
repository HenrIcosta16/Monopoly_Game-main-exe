package itens.objetos;

import itens.objetos.Player;

import java.util.Arrays;
import java.util.List;

public class ValidacaoCor implements Regras {

    @Override
    public boolean corEscolhida(String corEscolhida, Player[] jogadores) {
        for (Player jogador : jogadores) {
            if (jogador != null && jogador.getCor().equals(corEscolhida)) {
                System.out.println("\nA cor já foi escolhida por outro jogador.\n");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean digiteCorValida(String corEscolhida) {
        List<String> coresValidas = Arrays.asList(
                "preto", "branco", "vermelho", "verde", "azul", "amarelo", "laranja", "rosa");

        if (!coresValidas.contains(corEscolhida)) {
            System.out.println("\nCor inválida! Escolha uma das cores disponíveis abaixo.\n");
            return false;
        }

        return true;
    }
}
