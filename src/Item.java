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
}
