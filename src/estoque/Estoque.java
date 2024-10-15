package estoque;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import produtos.Produtos;

public class Estoque extends Produtos{

    //Atributos
    private int codigo;
    private int quant;
    private int quantMenos;
    private int codRemove;
    private int codFiltro;
    private int repeat;
    private boolean aux;
    private String desc;
    private Scanner scan = new Scanner(System.in);
    private Scanner scan2 = new Scanner(System.in);
    private Scanner scan3 = new Scanner(System.in);
    List<Produtos> lista = new ArrayList<Produtos>();
    List<Produtos> listaUrgente = new ArrayList<Produtos>();
    Produtos prod = new Produtos(0, null, 0);

    //Construtor
    public Estoque(int cod, String descricao, int quantidade) {
        super(cod, descricao, quantidade);
    }


    //Metodos

    //=========NVPRODUTO==================================================================================
    public void adicionar(){

        System.out.print("\nInforme o código do produto: ");
        codigo = scan.nextInt();
        this.setCod(codigo);

        for(Produtos p : lista){
            if(p.getCod() == codigo){
                System.out.println("\nEsse produto ja está cadastrado");
                System.out.print("\nInforme a quantidade que deseja adicionar: ");
                quant = scan.nextInt();
                p.quantidade += quant; 
                System.out.println("\nAdicionado com sucesso!!");
                return;

            }
        }

        System.out.print("\nInforme a descrição do produto: ");
        desc = scan2.nextLine();
        this.setDescricao(desc);

        System.out.print("\nInforme a quantidade do produto: ");
        quant = scan.nextInt();
        this.setQuantidade(quant);

        prod = new Produtos(this.getCod(), this.getDescricao(), this.getQuantidade());

        lista.add(prod);

        System.out.println("\nAdicionado com sucesso!!");
    
    }
    
    //============REMOVER===========================================================================================
    public void remover(){

        Produtos pAux = null; 


        if(lista.size() == 0){
            System.out.println("\nNenhum item cadastrado!!");
            return;
        }

        do{   
            
            System.out.print("\n\nInforme o codigo do produto: ");
            codRemove = scan.nextInt();


            for(Produtos p : lista){
                
                if(p.getCod() == codRemove){
                    aux = true;
                    pAux = p;
                    break;
                }
                    aux = false;
                    pAux = null; 
            }
                
                if(aux){
                    System.out.print("\nInforme a quantidade que deseja retirar: ");
                    quantMenos = scan.nextInt();
                    if(pAux.getQuantidade() >= quantMenos){
                        pAux.quantidade -= quantMenos;
                        System.out.println("\nRemovido com sucesso!!");
                        if(pAux.getQuantidade() < 20){
                            listaUrgente.add(pAux);    
                        } 
                        System.out.println("\n\nDeseja remover mais algum produto? Sim[1] ou Não[0]");
                        repeat = scan3.nextInt();  
                        
                    }
                    else{
                        System.out.println("\nQuantidade insuficiente!!");
                    }
                }    
                else{
                    System.out.println("\nItem não cadastrado!!");
                }     
        }while(repeat == 1);
            
    }

    //==========EXIBIR==================================================================================================
     public void exibir(){
        System.out.println("\nProdutos: \n");
        System.out.print("COD\t\t\t");
        System.out.print("DESC\t\t\t");
        System.out.println("QUANT");
        for(Produtos p : lista){
            System.out.print("\n" + p.cod + "\t\t\t" + p.descricao + "\t\t\t" + p.quantidade); 
        }
    }

    //=============FILTRO=========================================================================================================
    public void filtro(){

        if(lista.size() == 0){
            System.out.println("\nNenhum item cadastrado!!");
            return;
        }

        System.out.print("\nInforme o codigo do produto: ");
        codFiltro = scan3.nextInt();

        if(this.getCod() != codFiltro){
            System.out.println("\nItem não cadastrado!!");
        }

        for(Produtos p : lista){

            if(p.getCod() == codFiltro){
                System.out.print("\nCOD\t\t\t");
                System.out.print("DESC\t\t\t");
                System.out.println("QUANT\n");
                System.out.print("\n" + p.cod + "\t\t\t" + p.descricao + "\t\t\t" + p.quantidade); 
            } 
        }
    }

    //============LISTA URGENTE==================================================================================================
    public void urgente(){

        if(listaUrgente.size() != 0){
            for(Produtos p : listaUrgente){
                if(p.getQuantidade() >= 20){
                    listaUrgente.remove(p);
                }
            }

            System.out.println("\nProdutos: \n");
            System.out.print("COD\t\t\t");
            System.out.print("DESC\t\t\t");
            System.out.println("QUANT\n");
    
            for(Produtos p : listaUrgente){
                System.out.print("\n" + p.cod + "\t\t\t" + p.descricao + "\t\t\t" + p.quantidade + "\tURGENTE"); 
            }

        }
        else{
            System.out.println("\nNenhum item está em urgencia!!");
            return;
        }

      
    }

}


        

    



