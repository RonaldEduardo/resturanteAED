import java.util.Scanner;

public class Item {
  /*
   *
   * AMANHA COLOQUE OS COMENTEARIO DE PARAMETROS
   *
   *
   *
   */

  public String[] adicionaItem(String[] itens, Scanner scan) {
    // Copia a lista de itens existente para uma nova lista.
    String[] novosItens = preencherArrayExpandir(itens, 0);
    boolean adicionarItem = true;

    while (adicionarItem) {
      // Expande o array por um elemento a cada iteração.
      novosItens = preencherArrayExpandir(novosItens, 1);

      // Pede ao usuário para inserir o próximo item.
      System.out.println("Qual o próximo item?");
      novosItens[novosItens.length - 1] = scan.nextLine();

      adicionarItem = adicionarMais(scan);
    }
    return novosItens;
  }

  private String[] preencherArrayExpandir(String[] original, int expandir) {
    String[] novoArray = new String[original.length + expandir];
    for (int i = 0; i < original.length; i++) {
      novoArray[i] = original[i];
    }
    return novoArray;
  }

  public double[] adicionarValorItem(String[] itensCardapio, double[] valorItens, Scanner scan) {
    double[] novosValoresItens = new double[itensCardapio.length];
    String[] novosItensCardapio = new String[itensCardapio.length];
    boolean preencherValores = true;

    if (itensCardapio.length == 0) {
        System.out.println("Não tem itens, favor adicione!!!");
        return valorItens;
    }

    // Utilizando métodos personalizados para copiar arrays
    copiarArrayDouble(valorItens, novosValoresItens);
    copiarArrayString(itensCardapio, novosItensCardapio);

    while (preencherValores) {
      System.out.println("Qual o próximo item para adicionar o valor?");
      for (int i = 0; i < novosItensCardapio.length; i++) {
        System.out.println((i + 1) + " - " + novosItensCardapio[i]);
      }
      int escolhaItem = scan.nextInt();
      System.out.println("Digite um valor para o item: " + novosItensCardapio[(escolhaItem - 1)]);
      novosValoresItens[(escolhaItem - 1)] = scan.nextDouble();
      scan.nextLine(); // Limpar buffer

      preencherValores = adicionarMais(scan);
    }

    return novosValoresItens;
  }

  private boolean adicionarMais(Scanner scan) {
    boolean adicionarMais;
    System.out.println("Continuar adicionando? (S/N)");
    String opcaoEscolha = scan.nextLine().toUpperCase();
    adicionarMais = opcaoEscolha.equals("S") || opcaoEscolha.equals("N");

    // Inicialmente, verificar se a entrada é válida (S ou N)
    while (!adicionarMais) {
      System.out.println("Entrada inválida. Digite 'S' para Sim ou 'N' para Não:");
      opcaoEscolha = scan.nextLine().toUpperCase();
      adicionarMais = opcaoEscolha.equals("S") || opcaoEscolha.equals("N");
    }

    // Define a condição de parada baseada na entrada do usuário.
    adicionarMais = opcaoEscolha.equals("S");

    return adicionarMais;
  }

  /**
   * Copia um array de doubles para um novo array de mesmo tamanho.
   *
   * @param original O array de doubles original.
   * @param copia    O array de doubles destino.
   */
  private void copiarArrayDouble(double[] original, double[] copia) {
    for (int i = 0; i < original.length; i++) {
      copia[i] = original[i];
    }
  }

  /**
   * Copia um array de strings para um novo array de mesmo tamanho.
   *
   * @param original O array de strings original.
   * @param copia    O array de strings destino.
   */
  private void copiarArrayString(String[] original, String[] copia) {
    for (int i = 0; i < original.length; i++) {
      copia[i] = original[i];
    }
  }

  public void listarItens(String[] itens, double[] itensValor) {
    // Verifica se o array de valores está vazio ou se tem um tamanho diferente do
    // array de itens
    boolean exibirValores = itensValor.length == itens.length;

    for (int i = 0; i < itens.length; i++) {
      // Exibe o item
      System.out.print(itens[i]);

      // Se houver valores correspondentes, exibe-os ao lado de cada item
      if (exibirValores) {
        System.out.print(" - R$ " + itensValor[i]);
      }

      // Move para a próxima linha antes de continuar o loop
      System.out.println();
    }
  }

}
