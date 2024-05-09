import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Item item = new Item();
        String[] itens = new String[0];
        double[] itensValor = new double[itens.length];
        boolean finalizar = false;
        do {
            System.out.printf("""
                    Oque vc deseja fazer

                    1- Adicionar um item
                    2- Adicionar um valor item
                    3- Listar os itens
                    4- Criar novo pedido
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
                case 2: {
                    itensValor = item.adicionarValorItem(itens, itensValor, scan);
                    break;
                }
                case 3: {
                    itens = new String[] { "Ronakd", "NSdas" };
                    // itensValor = new double[] { 21, 23 };
                    item.listarItens(itens, itensValor);
                    break;
                }
                case 0: {
                    finalizar = true;
                }
            }
        } while (!finalizar);

    }
}
