package itens.objetos;

import java.util.List;
import java.util.Scanner;

public class GrupoDePropriedades extends Propriedade {
    private List<Propriedade> propriedadesDoGrupo;

    public GrupoDePropriedades(String nome, String posicao, int preco, int aluguel,
            List<Propriedade> propriedadesDoGrupo) {
        super(nome, posicao, preco, aluguel);
        this.propriedadesDoGrupo = propriedadesDoGrupo;
    }

    public boolean temMonopolio(Player jogador) {
        for (Propriedade propriedade : propriedadesDoGrupo) {
            if (!jogador.possuiPropriedade(propriedade)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void Acao(Player jogadorAtual, Player[] jogadores, Scanner scanner) {
        super.Acao(jogadorAtual, jogadores, scanner); 
        if (temMonopolio(jogadorAtual)) {
            System.out.println("Você tem monopólio neste grupo e pode construir com mais facilidade.");
        } else {
            System.out.println("Você não tem monopólio neste grupo.");
        }
    }

    
    public List<Propriedade> getPropriedadesDoGrupo() {
        return propriedadesDoGrupo;
    }

    public void setPropriedadesDoGrupo(List<Propriedade> propriedadesDoGrupo) {
        this.propriedadesDoGrupo = propriedadesDoGrupo;
    }

    public void adicionarPropriedadeAoGrupo(Propriedade propriedade) {
        this.propriedadesDoGrupo.add(propriedade);
    }
}
