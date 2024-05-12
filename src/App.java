import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("\033[H\033[2J"); // Limpa a tela
        System.out.flush();// limpa o buffer de saida
        
        Scanner scan = new Scanner(System.in);
        Item item = new Item();
        Pedido pedido = new Pedido();
        String[] itens = new String[0];
        int[][] pedidos = new int[0][0];
        double[] itensValor = new double[itens.length];
        double valorTotal;
        boolean finalizar = false;

        do {
            int opcao = listarMenu(scan);

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
                   item.listarItens(itens, itensValor);
                   break;
                }
                case 4:{
                    pedidos = pedido.criarPedido(pedidos,itens);
                    break;
                }
                case 5:{
                    pedidos = pedido.adicionaItemPedido(pedidos,scan,itens);
                    break;
                }
                case 6: {
                    valorTotal = pedido.listarTotal(pedidos, scan, itensValor);
                    System.out.println(valorTotal);
                    break;
                }
                case 0: {
                    finalizar = true;
                }
            }
        } while (!finalizar);

    }

    private static int listarMenu(Scanner scan) {
        System.out.printf("""
                \n\nOque vc deseja fazer

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
        return opcao;
    }
}
