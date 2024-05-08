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

  public String[][] adicionarValorItem(String[] item, Scanner scan) {
    String[][] newItensValor = new String[item.length][1];
    String[] newItens = new String[item.length];
    System.out.println("Adicione valor a qual item?");
    newItens = preencherArray(item, newItens);
    newItensValor = preencherMatriz(newItensValor, newItens);

    for (int i = 0; i < newItens.length; i++) {
      System.out.println((i + 1) + " - " + newItens[i]);
    }
    int opcao = scan.nextInt() - 1;
    scan.nextLine();

    System.out.println("Qual o valor para item " + newItensValor[opcao][0]);
    newItensValor[opcao][0] = scan.nextLine();

    return newItensValor;
  }

  public String[][] preencherMatriz(String[][] itensValor, String[] itens) {
    String[][] newItensValor = new String[itens.length][1];
    for (int i = 0; i < itens.length; i++) {
      newItensValor[i][0] = itens[i];
    }
    return newItensValor;
  }

  public void listarItens(String[][] itensValor) {
    for (int i = 0; i < itensValor.length; i++) {
      for (int j = 0; j < itensValor[i].length; j++) {
        System.out.println(itensValor[i][j] + " ");
      }
      System.out.println();
    }
  }

}
