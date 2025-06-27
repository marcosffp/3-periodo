package recursivo;
import java.util.NoSuchElementException;

public class Fila<E> {
  private Celula<E> frente;
  private Celula<E> tras;

  public Fila() {
    Celula<E> sentinela = new Celula<>();
    frente = tras = sentinela;
  }

  public boolean vazia() {
    return frente == tras;
  }

  public void enfileirar(E item) {
    Celula<E> novaCelula = new Celula<>(item);
    tras.setProximo(novaCelula);
    tras = novaCelula;
  }

  public E desenfileirar() {
    E item = consultarPrimeiro();
    Celula<E> primeira = frente.getProximo();
    frente.setProximo(primeira.getProximo());
    primeira.setProximo(null);
    if (primeira == tras)
      tras = frente;
    return item;
  }

  public E consultarPrimeiro() {
    if (vazia())
      throw new NoSuchElementException("Nao há nenhum item na fila!");
    return frente.getProximo().getItem();
  }

  public void imprimir() {
    if (vazia()) {
      System.out.println("A fila está vazia!");
      return;
    }
    Celula<E> aux = frente.getProximo();
    while (aux != null) {
      System.out.println(aux.getItem());
      aux = aux.getProximo();
    }
  }

  /*
   * Implemente o método public void concatenar (Fila<E> fila), capaz de
   * concatenar, ao final da fila original, a fila passada como parâmetro para o
   * método.
   */
  public void concatenar(Fila<E> fila) {
    while (!fila.vazia()) {
      this.enfileirar(fila.desenfileirar());
    }
  }

  /*
   * Implemente a função public int obterNumeroItens(), que retorna o número de
   * itens na fila.
   */
  public int obterNumeroItens() {
    return contarItensRecursivo(frente.getProximo());
  }

  private int contarItensRecursivo(Celula<E> celula) {
    if (celula == null) {
      return 0;
    }
    return 1 + contarItensRecursivo(celula.getProximo());
  }

  /*
   * Implemente o método public boolean verificarExistencia(E item), que
   * verifica a existência, na fila, de item correspondente àquele que foi passado
   * como
   * parâmetro para esse método. Essa correspondência deve basear-se no(s)
   * critério(s)
   * empregado(s) na implementação do método de comparação do item. Se o item for
   * localizado na fila, esse método deve retornar true. Caso contrário, esse
   * método deve
   * retornar false.
   */
  public boolean verificarExistencia(E item) {
    return verificarExistenciaRecursivo(frente.getProximo(), item);
  }

  private boolean verificarExistenciaRecursivo(Celula<E> aux, E item) {
    if (aux == null) {
      return false;
    }
    if (aux.getItem().equals(item)) {
      return true;
    }
    return verificarExistenciaRecursivo(aux.getProximo(), item);
  }

  /*
   * Implemente o método public int obterNumItensAFrente(E item)
   * throws Exception, que retorna o número de itens que estão localizados, na
   * fila, a
   * frente do item correspondente àquele que foi passado como parâmetro para esse
   * método.
   * Essa correspondência deve basear-se no(s) critério(s) empregado(s) na
   * implementação do
   * método de comparação do item. Se o item não for localizado na fila, esse
   * método deve
   * lançar uma exceção.
   */
  public int obterNumItensAFrente(E item) throws Exception {
    return obterNumItensAFrenteRecursivo(frente.getProximo(), item);
  }

  private int obterNumItensAFrenteRecursivo(Celula<E> aux, E item) throws Exception {
    if (aux == null) {
      throw new NoSuchElementException("Não tem esse item");
    }
    if (aux.getItem().equals(item)) {
      return 0;
    }
    return 1 + obterNumItensAFrenteRecursivo(aux.getProximo(), item);
  }

  /*
   * Implemente a função public Fila<E> copiar(), capaz de criar e retornar uma
   * cópia exata da fila. Acrescente à assinatura desse método as exceções que
   * forem necessárias.
   */
  public Fila<E> copiar() {
    if (vazia()) {
      throw new NoSuchElementException("A fila está vazia!");
    }
    Fila<E> copia = new Fila<>();
    copiarRecursivo(this.frente.getProximo(), copia);
    return copia;
  }

  private void copiarRecursivo(Celula<E> atual, Fila<E> copia) {
    if (atual == null) {
      return;
    }
    copia.enfileirar(atual.getItem());
    copiarRecursivo(atual.getProximo(), copia);
  }
  
  /*
   * Implemente a função public Fila<E> dividir(), capaz de dividir a fila
   * original
   * em duas, da seguinte forma: devem permanecer na fila atual os itens que
   * ocupam,
   * atualmente, posição ímpar nessa fila. Devem ser enfileirados, na fila que
   * será retornada por
   * esse método, os itens que ocupam, atualmente, posição par na fila original.
   * Considere que
   * o primeiro item da fila (item localizado após a célula sentinela), ocupa a
   * posição 0.
   */
  public Fila<E> dividir() {
    Fila<E> filaPares = new Fila<>();
    dividirRecursivo(this.frente, filaPares, 0);
    return filaPares;
  }

  private void dividirRecursivo(Celula<E> anterior, Fila<E> filaPares, int pos) {
    if (anterior == null || anterior.getProximo() == null) {
      this.tras = anterior;
      return;
    }

    Celula<E> atual = anterior.getProximo();
    if (pos % 2 == 0) {
      filaPares.enfileirar(atual.getItem());
      anterior.setProximo(atual.getProximo());
      atual.setProximo(null);
      dividirRecursivo(anterior, filaPares, pos + 1);
    } else {
      dividirRecursivo(atual, filaPares, pos + 1);
    }
  }

  /*
   * Implemente o método public void inverter(), capaz de inverter a fila.
   */
  public void inverter() {
    if (vazia())
      return;
    E item = desenfileirar();
    inverter(); 
    enfileirar(item); 
  }



  public static void main(String[] args) {
    Fila<Integer> fila1 = new Fila<>();
    fila1.enfileirar(1);
    fila1.enfileirar(2);
    fila1.enfileirar(3);

    Fila<Integer> fila2 = new Fila<>();
    fila2.enfileirar(4);
    fila2.enfileirar(5);
    fila2.enfileirar(6);

    System.out.println("\n== Fila 1 antes da concatenação ==");
    fila1.imprimir();
    System.out.println("\n== Fila 2 antes da concatenação ==");
    fila2.imprimir();
    fila1.concatenar(fila2);
    System.out.println("\n== Fila 1 após a concatenação com Fila 2 ==");
    fila1.imprimir();

    System.out.println("\n== Número de itens na Fila 1 ==");
    System.out.println("Número de itens na Fila 1: " + fila1.obterNumeroItens());

    System.out.println("\n== Verificando se o número 2 existe na Fila 1 ==");
    System.out.println("O número 2 existe na Fila 1? " + fila1.verificarExistencia(2));
    System.out.println("\n== Verificando se o número 7 existe na Pilha 1 ==");
    System.out.println("O número 7 existe na Fila 1? " + fila1.verificarExistencia(7));

    try {
      System.out.println("\n== Número de itens a frente do número 2 na Fila 1 ==");
      System.out.println("Número de itens a frente do número 2: " + fila1.obterNumItensAFrente(2));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    Fila<Integer> copiaPilha = fila1.copiar();
    System.out.println("\n== Cópia da Fila 1 ==");
    copiaPilha.imprimir();

    System.out.println("\n== Dividindo a Fila 1 ==");
    Fila<Integer> filaDividida = fila1.dividir();

    System.out.println("\n== Fila 1 após divisão (itens em posições ímpares) ==");
    fila1.imprimir();

    System.out.println("\n== Fila dividida retornada (itens em posições pares) ==");
    filaDividida.imprimir();

    System.out.println("\n== Invertendo Fila 1 ==");
    fila1.inverter();
    fila1.imprimir();
  }
}

