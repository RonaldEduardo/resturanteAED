import java.util.Scanner;

public class Item {

  public String[] adicionaItem(String[] itens, Scanner scan) {
    String[] newItens = new String[itens.length + 1];

    preencherArray(itens, newItens);

    System.out.println("Qual o proximo item?");
    newItens[newItens.length - 1] = scan.nextLine();
    return newItens;
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

      System.out.println("Continuar adicionando valor?");
      String opcaoEscolha = scan.nextLine();
      preencherValores = opcaoEscolha.toUpperCase().equals("S") ? false : true;

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
    for (int i = 0; i < itens.length; i++) {
      System.out.print(itens[i] + " ");
      System.out.print(itensValor[i] + " ");
      System.out.println();
    }

  }

}
