package itens.objetos;

public class Hotel extends Habitacao {
    private boolean temHotel;
    private String nomePropriedade; 

  
    public Hotel(int preco, String nomePropriedade) {
        this.preco = preco; 
        this.temHotel = false;
        this.casas = 4; 
        this.nomePropriedade = nomePropriedade; 
    }

    @Override
    public void removerHotel() {
        
        if (temHotel) {
            temHotel = false;
            casas = 4; 
        }
    }

    @Override
    public void removerCasa() {
        
    }

    @Override
    public void construir(Player jogador) {
        
        System.out.println("Não é possível construir uma casa em um hotel.");
    }

    @Override
    public boolean podeConstruir(Player jogador) {
       
        return false;
    }

    @Override
    public boolean podeConstruirHotel(Player jogador) {
      
      
        return !temHotel && casas == 4 && jogador.getSaldo() >= 200; 
    }

    @Override
    public void construirHotel(Player jogador) {
       
        if (!temHotel && casas == 4 && jogador.getSaldo() >= 200) {
            temHotel = true;
            jogador.fazerPagamento(200); 
            System.out.println(jogador.getNome() + " construiu um hotel em " + this.getNome());
        } else {
           
            System.out.println("Você já tem um hotel nesta propriedade ou não tem dinheiro suficiente.");
        }
    }

    @Override
    public int getCasas() {
        return casas; 
    }

    @Override
    public boolean temHotel() {
        return temHotel;
    }

   
    public String getNome() {
        return nomePropriedade;
    }
}
