import java.util.Scanner;

public class Pedido {

  public int[][] criarPedido(int[][] pedidos, String[]itens) {
    //[linhas][colunas]
    boolean temItem = itens.length > 0;

    if(temItem) {
      int[][] newPedidos = new int[pedidos.length+1][0];
      System.out.println("Pedido Criado");
      return newPedidos;
    }else{
      System.out.println("Não tem itens no cardapio!!!");
    }
    return pedidos;
  }

  public int[][] adicionaItemPedido(int[][] pedidos, Scanner scan, String[] itens) {
    // Imprime todos os pedidos para que o usuário possa escolher qual modificar
    for (int i = 0; i < pedidos.length; i++) {
      System.out.println((i + 1) + ") Pedido " + (i + 1));
    }

    // Usuário faz sua escolha
    int pedidoEscolha = scan.nextInt() - 1; // Ajusta para índice baseado em zero

    // Verifica se a escolha está dentro do intervalo válido
    if (pedidoEscolha < 0 || pedidoEscolha >= pedidos.length) {
      System.out.println("Escolha inválida. Retornando pedidos originais.");
      return pedidos; // Retorna os pedidos originais se a escolha for inválida
    }

    // Listar itens disponíveis
    for (int i = 0; i < itens.length; i++) {
      System.out.println((i + 1) + ") " + itens[i]);
    }

    // Solicita ao usuário que escolha um item para adicionar ao pedido
    System.out.println("Escolha um item para adicionar ao pedido:");
    int itemEscolhido = scan.nextInt() - 1; // Ajusta para índice baseado em zero

    // Verifica se a escolha do item é válida
    if (itemEscolhido < 0 || itemEscolhido >= itens.length) {
      System.out.println("Escolha de item inválida. Retornando pedidos originais.");
      return pedidos; // Retorna os pedidos originais se a escolha de item for inválida
    }

    // Adiciona o novo item ao pedido selecionado
    int[] novoPedido = new int[pedidos[pedidoEscolha].length + 1];
    novoPedido[novoPedido.length-1] = itemEscolhido;

     System.out.println(novoPedido.length);

    // Atualiza o pedido na matriz de pedidos
    pedidos[pedidoEscolha] = novoPedido;

    return pedidos;
  }

  public double listarTotal(int[][]pedidos,Scanner scan,double[]itensValor){
    double valorTotal = 0;
    for (int i = 0; i < pedidos.length; i++) {
      System.out.println((i + 1) + ") Pedido " + (i + 1));
    }
    // Usuário faz sua escolha
    int pedidoEscolha = scan.nextInt() - 1; // Ajusta para índice baseado em zero

    // Verifica se a escolha está dentro do intervalo válido
    if (pedidoEscolha < 0 || pedidoEscolha >= pedidos.length) {
      System.out.println("Escolha inválida. Retornando pedidos originais.");
      return 0; // Retorna os pedidos originais se a escolha for inválida
    }

    for (int i = 0; i < pedidos[pedidoEscolha].length; i++) {
      valorTotal += itensValor[pedidos[pedidoEscolha][i]];
    }

    return valorTotal;
  }


}
