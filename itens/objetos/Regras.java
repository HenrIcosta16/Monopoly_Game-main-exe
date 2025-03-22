package itens.objetos;

import itens.objetos.Player;

public interface Regras {

    boolean corEscolhida(String corEscolhida, Player[] jogadores);

    boolean digiteCorValida(String corEscolhida);

}
