package itens.objetos;

import java.util.Scanner;

public abstract class Lugar {
    String nome;
    String posicao;

    public Lugar(String nome, String posicao) {
        this.nome = nome;
        this.posicao = posicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public abstract void mostrarInformacoes();

    public abstract void Acao(Player jogadorAtual, Player[] jogadores, Scanner scanner);

}
