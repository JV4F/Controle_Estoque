package produtos;

public class Produtos {
    
    //Atributos
            
    public int cod; 
    public int quantidade; 
    public String descricao;

    //Construtor

    public Produtos(int cod, String descricao, int quantidade) {
        this.cod = cod;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
