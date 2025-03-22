package itens.objetos;

import java.util.Scanner;

public class IrparAprisao extends Lugar {

    
    public IrparAprisao(String nome, String posicao, int preco, int aluguel) {
        super(nome, posicao); 
    }

    @Override
    public void mostrarInformacoes() {
       
        System.out.println(this.getNome() + " foi levado para a prisão.");

    }

    @Override
    public void Acao(Player jogadorAtual, Player[] jogadores, Scanner scanner) {
        
        System.out.println(jogadorAtual.getNome() + " caiu no " + this.getNome());
        System.out.println(jogadorAtual.getNome() + " foi levado para a prisão.");
       
        jogadorAtual.setNaPrisao(true);
        jogadorAtual.setPosicao(30); 

    }

}
