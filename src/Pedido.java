import java.util.Scanner;

public class Pedido {

  public int[][] criarPedido(int[][] pedidos, String[] itens) {
    // Verifica se existem itens disponíveis
    boolean temItem = itens.length > 0;

    if (temItem) {
      // Determina o número de colunas com base no array de pedidos existente
      int numeroDeColunas = pedidos.length > 0 ? pedidos[0].length : 0;

      // Cria um novo array de pedidos com uma linha adicional
      int[][] novosPedidos = new int[pedidos.length + 1][numeroDeColunas];

      copiarPedidosInt(pedidos, novosPedidos);

      // Inicializa a nova linha (opcional, já que o default é 0)
      for (int j = 0; j < numeroDeColunas; j++) {
        novosPedidos[pedidos.length][j] = 0;
      }

      System.out.println("Pedido Criado");
      return novosPedidos;
    } else {
      System.out.println("Não tem itens no cardápio!!!");
      return pedidos;
    }
  }

  private void copiarPedidosInt(int[][] pedidos, int[][] novosPedidos) {
    // Copia os pedidos existentes para o novo array
    for (int i = 0; i < pedidos.length; i++) {
      for (int j = 0; j < pedidos[i].length; j++) {
        novosPedidos[i][j] = pedidos[i][j];
      }
    }
  }

  public int[][] adicionaItemPedido(int[][] pedidos, Scanner scan, String[] itens) {

    if (pedidos.length == 0 ) {
      System.out.println("Não existe um pedido");
      return pedidos;
    }

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
