import java.util.Scanner;
import estoque.Estoque;

public class App  {
    public static void main(String[] args) throws Exception {
        
        int nums;
        Estoque estoque = new Estoque(0, null, 0);
        Scanner scan = new Scanner(System.in);

        do{   
            System.out.println("\n-----------------------------------\n"); 
            System.out.print("\n1)Adicionar\n2)Remover\n3)Exibir Produtos\n4)Exibir Urgente\n5)Filtrar\n0)Sair\n:"); 
            nums = scan.nextInt();

            switch (nums) {
                case 1:     
                    estoque.adicionar();
                    break;

                case 2:
                   estoque.remover();
                    break;

                case 3:
                    estoque.exibir();
                    break;

                case 4: 
                    estoque.urgente();
                    break;

                case 5: 
                    estoque.filtro();
                    break;

                case 0:
                    scan.close();
                    break;
            
                default:
                    break;
            }

        }while(nums != 0);
    }
}
