import java.util.Arrays;
import java.util.Scanner;

public class Item {

  public String[] adicionaItem(String[] itens, Scanner scan) {
    // Copia a lista de itens existente para uma nova lista.
    String[] novosItens = Arrays.copyOf(itens, itens.length);

    // Flag para controle do loop. Enquanto for 'false', novos itens podem ser adicionados.
    boolean adicionarMais = true;

    while (adicionarMais) {
        // Cria um novo array com tamanho um maior que o anterior para adicionar novo item.
        novosItens = Arrays.copyOf(novosItens, novosItens.length + 1);

        // Pede ao usuário para inserir o próximo item.
        System.out.println("Qual o próximo item?");
        novosItens[novosItens.length - 1] = scan.nextLine();

        // Pergunta ao usuário se deseja adicionar mais itens.
        System.out.println("Deseja adicionar mais itens? (S/N)");
        String escolhaUsuario = scan.nextLine().toUpperCase();

        // Define a condição de parada baseada na entrada do usuário.
        adicionarMais = escolhaUsuario.equals("S") || escolhaUsuario.equals("SIM");
    }
    return novosItens;
}

  private String[] preencherArray(String[] itens, String[] newItens) {
    for (int i = 0; i < itens.length; i++) {
      newItens[i] = itens[i];
    }
    return newItens;
  }

  public double[] adicionarValorItem(String[] itensCardapio, double[] valorItens, Scanner scan) {
    double[] newValorItens = new double[itensCardapio.length];
    String[] newItensCardapio = new String[itensCardapio.length];
    boolean preencherValores = false;

    preencherArrayDouble(valorItens, newValorItens);
    preencherArray(itensCardapio, newItensCardapio);

    while (!preencherValores) {

      System.out.println("Qual o proximo item para adicionar o valor?");
      for (int i = 0; i < newItensCardapio.length; i++) {
        System.out.println((i + 1) + " - " + newItensCardapio[i]);
      }
      int itemEscolha = scan.nextInt();
      System.out.println("Digite um valor para o item: " + newItensCardapio[(itemEscolha - 1)]);
      newValorItens[(itemEscolha - 1)] = scan.nextDouble();
      scan.nextLine();//limpar buffer

      System.out.println("Continuar adicionando valor? (S/N)");
      String opcaoEscolha = scan.nextLine();
      preencherValores = opcaoEscolha.toUpperCase().equals("S") || opcaoEscolha.toUpperCase().equals("SIM") ? false : true;

    }

    return newValorItens;
  }

  private double[] preencherArrayDouble(double[] itens, double[] newItens) {
    for (int i = 0; i < itens.length; i++) {
      newItens[i] = itens[i];
    }
    return newItens;
  }

  public void listarItens(String[] itens, double[] itensValor) {
    if (itensValor.length >= 0) {
      for (int i = 0; i < itens.length; i++) {
        System.out.print(itens[i] + " ");
        System.out.println();
      }
    }else{
      for (int i = 0; i < itens.length; i++) {
        System.out.print(itens[i] + " ");
        System.out.print(itensValor[i] + " ");
        System.out.println();
      }
    }

  }

}
