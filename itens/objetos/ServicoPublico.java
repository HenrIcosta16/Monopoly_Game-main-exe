package itens.objetos;

import java.util.Scanner;

public class ServicoPublico extends Lugar {
    private int preco;
    private Player dono;
    private int aluguel;

    public ServicoPublico(String nome, String posicao, int preco, int aluguel) {
        super(nome, posicao);
        this.preco = preco;
        this.dono = null;
        this.aluguel = aluguel;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Player getDono() {
        return dono;
    }

    public void setDono(Player dono) {
        this.dono = dono;
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: " + preco);
        if (dono != null) {
            System.out.println("Dono: " + dono.getNome());
        } else {
            System.out.println("Este serviço público não tem dono.");
        }
    }

    @Override
    public void Acao(Player jogadorAtual, Player[] jogadores, Scanner scanner) {
        if (dono == null) {
            System.out.println("Você caiu em " + getNome());
            System.out.println(
                    "Você deseja comprar esse serviço público pelo preço de " + this.getPreco() + " reais? (s/n)");
            String resposta = scanner.nextLine().trim().toLowerCase(); 

           
            if (resposta.equals("s") || resposta.equals("sim")) {
                if (jogadorAtual.getSaldo() >= preco) {
                    jogadorAtual.setSaldo(jogadorAtual.getSaldo() - preco);
                    this.dono = jogadorAtual;
                    System.out.println("Parabéns! Você comprou " + getNome());
                } else {
                    System.out.println("Você não tem dinheiro suficiente para comprar.");
                }
            } else {
                System.out.println("Você optou por não comprar " + getNome());
            }
        } else {
            int fator = (dono.getServicoPublico().size() == 1) ? 4 : 10; 
                                                                        
            int valorPagamento = dono.jogaDadoEMultiplica(fator);
            jogadorAtual.setSaldo(jogadorAtual.getSaldo() - valorPagamento);
            dono.setSaldo(dono.getSaldo() + valorPagamento);
            System.out.println("Você caiu em " + getNome() + " que pertence a " + dono.getNome() + ".");
            System.out.println("Você deve pagar " + valorPagamento + " ao dono.");
        }
    }
}
