import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Item item = new Item();
        String[] itens = new String[0];
        System.out.printf("""
                Oque vc deseja fazer

                1- Adicionar um item
                2- Adicionar um valor item
                3- Listar os itens
                4- Criar no pedido
                5- Adicionar item no pedido
                6- Mostrar valor total
                0- Saida

                """);
        int opcao = scan.nextInt();
        scan.nextLine();
        switch (opcao) {
                case 1: {
                    itens = item.adicionaItem(itens, scan);
                    break;
                }
        }
    }
}
