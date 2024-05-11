import java.util.Scanner;

public class Pedido {

  public int[][] criarPedido(int[][] pedidos, String[]itens) {
    //[linhas][colunas]
    boolean temItem = itens.length > 0;
    System.out.println(temItem);

    if(temItem) {
      int[][] newPedidos = new int[pedidos.length+1][];
      System.out.println("Pedido Criado");
      return newPedidos;
    }else{
      System.out.println("Não tem itens no cardapio!!!");
    }
    return pedidos;
  }

  public int[][] adicionaItemPedido(int[][] pedidos, Scanner scan, String[]itens){
    int[][] newPedidos = pedidos;
    String[] newItens = itens;

   for (int i = 0; i < newPedidos.length; i++) {
    System.out.println("Qual pedido deseja selecionar?\n" + (i+1) + ")");
   }
   int pedidoEscolha = scan.nextInt();
   pedidoEscolha = pedidoEscolha -1;
   boolean adicionaItemPedido = pedidoEscolha > 0;
   while (adicionaItemPedido) {
    if(newPedidos[pedidoEscolha].length > 1){
      
    }
   }


    return pedidos;
  }


}
