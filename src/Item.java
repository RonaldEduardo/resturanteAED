import java.util.Scanner;

public class Item {

  public String[] adicionaItem(String[] itens, Scanner scan) {
    // Copia a lista de itens existente para uma nova lista.
    String[] novosItens = preencherArrayExpandir(itens, 0);

    // Flag para controle do loop. Enquanto for 'true', novos itens podem ser
    // adicionados.
    boolean adicionarMais = true;

    while (adicionarMais) {
      // Expande o array por um elemento a cada iteração.
      novosItens = preencherArrayExpandir(novosItens, 1);

      // Pede ao usuário para inserir o próximo item.
      System.out.println("Qual o próximo item?");
      novosItens[novosItens.length - 1] = scan.nextLine();

      // Pergunta ao usuário se deseja adicionar mais itens.
      System.out.println("Deseja adicionar mais itens? (S/N)");
      String escolhaUsuario = scan.nextLine().toUpperCase();
      adicionarMais = escolhaUsuario.equals("N") || escolhaUsuario.equals("S");

      while (!adicionarMais) {
        System.out.println("Digite S/N");
        escolhaUsuario = scan.nextLine().toUpperCase();
        adicionarMais = escolhaUsuario.equals("N") || escolhaUsuario.equals("S");
      }

      // Define a condição de parada baseada na entrada do usuário.
      adicionarMais = escolhaUsuario.equals("S") || escolhaUsuario.equals("SIM");
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
    boolean preencherValores = false;

    // Utilizando métodos personalizados para copiar arrays
    copiarArrayDouble(valorItens, novosValoresItens);
    copiarArrayString(itensCardapio, novosItensCardapio);

    while (!preencherValores) {
      System.out.println("Qual o próximo item para adicionar o valor?");
      for (int i = 0; i < novosItensCardapio.length; i++) {
        System.out.println((i + 1) + " - " + novosItensCardapio[i]);
      }
      int escolhaItem = scan.nextInt();
      System.out.println("Digite um valor para o item: " + novosItensCardapio[(escolhaItem - 1)]);
      novosValoresItens[(escolhaItem - 1)] = scan.nextDouble();
      scan.nextLine(); // Limpar buffer

      System.out.println("Continuar adicionando valor? (S/N)");
      String opcaoEscolha = scan.nextLine();
      preencherValores = !(opcaoEscolha.equalsIgnoreCase("S") || opcaoEscolha.equalsIgnoreCase("SIM"));
    }

    return novosValoresItens;
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
    if (itensValor.length >= 0) {
      for (int i = 0; i < itens.length; i++) {
        System.out.print(itens[i] + " ");
        System.out.println();
      }
    } else {
      for (int i = 0; i < itens.length; i++) {
        System.out.print(itens[i] + " ");
        System.out.print(itensValor[i] + " ");
        System.out.println();
      }
    }

  }

}
