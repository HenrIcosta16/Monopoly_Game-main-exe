package itens.Interfaces;

import itens.objetos.Lugar;

public interface TabuleiroInterface {
    Lugar getLugar(int posicao);

    int getLugarSeguinte(int posicao);
}

// package itens.Interfaces;

// import itens.objetos.Tabuleiro;

// public interface TabuleiroInterface {
// PropriedadeInterface getPropriedade(int posicao);

// int getLugarSeguinte(int posicao);
// }