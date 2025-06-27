package duplamente;

public class ListaDuplamenteEncadeada<E> {

  private Celula<E> primeiro;
  private Celula<E> ultimo;
  private int tamanho;

  public ListaDuplamenteEncadeada() {

    Celula<E> sentinela = new Celula<>();

    this.primeiro = this.ultimo = sentinela;
    this.tamanho = 0;
  }

  public boolean vazia() {

    return (this.primeiro == this.ultimo);
  }

  public void inserirFinal(E novo) {

    Celula<E> novaCelula = new Celula<>(novo, this.ultimo, null);

    this.ultimo.setProximo(novaCelula);
    this.ultimo = novaCelula;

    this.tamanho++;

  }

  public E removerFinal() {

    Celula<E> removida, penultima;

    if (vazia())
      throw new IllegalStateException("Não foi possível remover o último item da lista: "
          + "a lista está vazia!");

    removida = this.ultimo;

    penultima = this.ultimo.getAnterior();
    penultima.setProximo(null);

    removida.setAnterior(null);

    this.ultimo = penultima;

    this.tamanho--;

    return (removida.getItem());
  }

  /*
   * Implemente o método public void inserirInicio(E novo), que insere, o item
   * passado como parâmetro para esse método, no final da lista encadeada
   */
  public void inserirInicio(E novo) {
    Celula<E> primeiraReal = this.primeiro.getProximo();
    Celula<E> novaCelula = new Celula<>(novo, this.primeiro, primeiraReal);
    this.primeiro.setProximo(novaCelula);
    if (vazia()) {
      this.ultimo = novaCelula;
    } else {
      primeiraReal.setAnterior(novaCelula);
    }
    this.tamanho++;
  }

  /*
   * Implemente o método public E removerInicio(), capaz de remover e retornar o
   * item que ocupa a posição 0 da lista encadeada. Caso a lista encadeada esteja
   * vazia, esse método deve lançar uma exceção.
   */
  public E removerInicio() {
    if (vazia()) {
      throw new IllegalStateException("Não foi possível remover o item do início: a lista está vazia!");
    }
    Celula<E> removida = this.primeiro.getProximo();
    Celula<E> novaPrimeira = removida.getProximo();
    this.primeiro.setProximo(novaPrimeira);
    if (novaPrimeira != null) {
      novaPrimeira.setAnterior(this.primeiro);
    } else {
      this.ultimo = this.primeiro;
    }
    removida.setAnterior(null);
    removida.setProximo(null);
    this.tamanho--;
    return removida.getItem();
  }

  public static void main(String[] args) {
    ListaDuplamenteEncadeada<Double> lista = new ListaDuplamenteEncadeada<>();

    lista.inserirFinal(1.1);
    lista.inserirFinal(2.2);
    lista.inserirFinal(3.3);
    lista.inserirFinal(4.4);
    lista.inserirFinal(5.5);
    lista.inserirFinal(6.6);

    System.out.println("\n== Lista 1 antes da inserção final,7.7, 8.8 ,9.9 e 10.10 ==");
    lista.imprimir();
    lista.inserirFinal(7.7);
    lista.inserirFinal(8.8);
    lista.inserirFinal(9.9);
    lista.inserirFinal(10.10);
    System.out.println("\n== Lista 1 após a inserção final ==");
    lista.imprimir();

    System.out.println("\n== remoção do início da Lista 1 ==");
    lista.removerInicio();
    lista.imprimir();

    System.out.println("\n== inserção do início da Lista 1, 0.0 ==");
    lista.inserirInicio(0.0);
    lista.imprimir();

    System.out.println("\n== remoção do final da Lista 1 ==");
    lista.removerFinal();
    lista.imprimir();

  }

  public void imprimir() {
    Celula<E> atual = this.primeiro.getProximo();
    while (atual != null) {
      System.out.print(atual.getItem() + " ");
      atual = atual.getProximo();
    }
    System.out.println();
  }

}
