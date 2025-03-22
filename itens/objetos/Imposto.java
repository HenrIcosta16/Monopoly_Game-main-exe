package itens.objetos;

import java.util.Scanner;

public abstract class Imposto extends Lugar {
    protected int valor;

    public Imposto(String nome, String posicao, int valor) {
        super(nome, posicao);
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public abstract void mostrarInformacoes();

    @Override
    public abstract void Acao(Player jogadorAtual, Player[] jogadores, Scanner scanner);

}
