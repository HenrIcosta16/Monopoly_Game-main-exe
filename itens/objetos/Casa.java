package itens.objetos;

public class Casa extends Habitacao {
    private int casasConstruidas;
    private String nomePropriedade; 

   
    public Casa(String nomePropriedade) {
        this.preco = 200; 
        this.casasConstruidas = 0;
        this.nomePropriedade = nomePropriedade; 
    }

    @Override
    public void construir(Player jogador) {
        if (jogador.getSaldo() < this.preco) {
            System.out.println(jogador.getNome() + " não tem saldo suficiente para construir uma casa.");
            return; 
        }

        casasConstruidas++; 
        jogador.fazerPagamento(this.preco); 
        System.out.println(jogador.getNome() + " construiu uma casa em " + this.getNome());
    }

    @Override
    public boolean podeConstruir(Player jogador) {
        return jogador.getSaldo() >= this.preco; 
                                                
    }

    @Override
    public boolean podeConstruirHotel(Player jogador) {
        return casasConstruidas >= 4 && !temHotel() && jogador.getSaldo() >= 200;
    }

    @Override
    public void removerCasa() {
        if (casasConstruidas > 0) {
            casasConstruidas--;
        }
    }

    @Override
    public void removerHotel() {
        
    }

    @Override
    public int getCasas() {
        return casasConstruidas;
    }

    @Override
    public boolean temHotel() {
        return false; 
    }

    @Override
    public void construirHotel(Player jogador) {
        
        if (casasConstruidas >= 4 && jogador.getSaldo() >= 200) {
            System.out.println(jogador.getNome() + " construiu um hotel em " + this.getNome());
            jogador.fazerPagamento(200); 
        } else {
            if (casasConstruidas < 4) {
                System.out.println("Você precisa de 4 casas para construir um hotel nesta propriedade.");
            } else if (temHotel()) {
                System.out.println("Já existe um hotel nesta propriedade.");
            } else {
                System.out.println("Você não tem saldo suficiente para construir um hotel.");
            }
        }
    }

    public String getNome() {
        return nomePropriedade;
    }
}
