package direto;


import java.util.NoSuchElementException;

public class Lista<E> {

  private Celula<E> primeiro;
  private Celula<E> ultimo;
  private int tamanho;

  public Lista() {

    Celula<E> sentinela = new Celula<>();

    this.primeiro = this.ultimo = sentinela;
    this.tamanho = 0;
  }

  public boolean vazia() {

    return (this.primeiro == this.ultimo);
  }

  public void inserir(E novo, int posicao) {

    Celula<E> anterior, novaCelula, proximaCelula;

    if ((posicao < 0) || (posicao > this.tamanho))
      throw new IndexOutOfBoundsException("Não foi possível inserir o item na lista: "
          + "a posição informada é inválida!");

    anterior = this.primeiro;
    for (int i = 0; i < posicao; i++)
      anterior = anterior.getProximo();

    novaCelula = new Celula<>(novo);

    proximaCelula = anterior.getProximo();

    anterior.setProximo(novaCelula);
    novaCelula.setProximo(proximaCelula);

    if (posicao == this.tamanho) 
      this.ultimo = novaCelula;

    this.tamanho++;
  }

  public E remover(int posicao) {

    Celula<E> anterior, celulaRemovida, proximaCelula;

    if (vazia())
      throw new IllegalStateException("Não foi possível remover o item da lista: "
          + "a lista está vazia!");

    if ((posicao < 0) || (posicao >= this.tamanho))
      throw new IndexOutOfBoundsException("Não foi possível remover o item da lista: "
          + "a posição informada é inválida!");

    anterior = this.primeiro;
    for (int i = 0; i < posicao; i++)
      anterior = anterior.getProximo();

    celulaRemovida = anterior.getProximo();

    proximaCelula = celulaRemovida.getProximo();

    anterior.setProximo(proximaCelula);
    celulaRemovida.setProximo(null);

    if (celulaRemovida == this.ultimo)
      this.ultimo = anterior;

    this.tamanho--;

    return (celulaRemovida.getItem());
  }

  public E pesquisar(E itemProcurado) {

    Celula<E> aux = primeiro.getProximo();

    for (int i = 0; i < tamanho; i++) {
      if (aux.getItem().equals(itemProcurado)) {
        return aux.getItem();
      }
      aux = aux.getProximo();
    }

    throw new NoSuchElementException("Item não encontrado na lista!");
  }

  public int tamanho() {
    return this.tamanho;
  }





  /*
   * Implemente o método public void inserirFinal(E novo), que insere, o item
   * passado como parâmetro para esse método, no final da lista encadeada
   */
  public void inserirFinal(E novo) {
    Celula<E> novaCelula = new Celula<>(novo);
    this.ultimo.setProximo(novaCelula);
    this.ultimo = novaCelula;
    this.tamanho++;
  }

  /*
   * Implemente o método public E removerInicio(), capaz de remover e retornar o
   * item que ocupa a posição 0 da lista encadeada. Caso a lista encadeada esteja
   * vazia, esse método deve lançar uma exceção.
   */
  public E removerInicio() {
    if (vazia()) {
      throw new IllegalStateException("Não foi possível remover o item da lista: a lista está vazia!");
    }

    Celula<E> celulaRemovida = this.primeiro.getProximo();
    this.primeiro.setProximo(celulaRemovida.getProximo());
    celulaRemovida.setProximo(null);

    if (celulaRemovida == this.ultimo) {
      this.ultimo = this.primeiro;
    }

    this.tamanho--;

    return celulaRemovida.getItem();
  }

  /*
   * Implemente o método public E remover(E itemProcurado), capaz de localizar
   * na lista encadeada o item correspondente àquele que foi passado como
   * parâmetro para esse
   * método, removê-lo e retorná-lo. Essa correspondência deve basear-se no(s)
   * critério(s)
   * empregado(s) na implementação do método equals do item. Se a lista encadeada
   * estiver
   * vazia, ou o item correspondente àquele que foi passado como parâmetro para
   * esse método
   * não for localizado na lista encadeada, esse método deve lançar uma exceção.
   */

  public E remover(E itemProcurado) {
    if (vazia()) {
      throw new IllegalStateException("Não foi possível remover o item: a lista está vazia!");
    }

    Celula<E> aux = primeiro.getProximo();

    for (int i = 0; i < tamanho; i++) {
      if (aux.getItem().equals(itemProcurado)) {
        return remover(i);
      }
      aux = aux.getProximo();
    }
    throw new NoSuchElementException("Item não encontrado na lista!");
  }

  /*
   * Implemente a função public int obterNumeroItens(), que retorna o número de
   * itens presentes na lista encadeada.
   */
  public int obterNumeroItens() {
    return this.tamanho;
  }

  /*
   * Implemente o método public E localizar(int posição), que localiza na lista
   * encadeada o item que ocupa a posição indicada pelo parâmetro desse método e
   * retorna-o.
   * Se a lista encadeada estiver vazia, ou a posição informada for inválida, esse
   * método deve
   * lançar uma exceção. Lembre-se que o primeiro item da lista encadeada (item
   * localizado
   * logo após a célula sentinela), ocupa a posição 0.
   */
  public E localizar(int posicao) {
    if (vazia()) {
      throw new IllegalStateException("Não foi possível localizar o item: a lista está vazia!");
    }

    if (posicao < 0 || posicao >= tamanho) {
      throw new IndexOutOfBoundsException("Posição inválida: " + posicao);
    }

    Celula<E> aux = primeiro;
    for (int i = 0; i <= posicao; i++) {
      aux = aux.getProximo();
    }

    return aux.getItem();
  }

  /*
   * Implemente o método public void trocar(E itemX, E itemY), capaz de
   * trocar, os itens correspondentes àqueles passados como parâmetros para esse
   * método, de lugar na lista encadeada. Essa correspondência deve basear-se
   * no(s)
   * critério(s) empregado(s) na implementação do método equals do item. Se a
   * lista encadeada
   * estiver vazia, ou pelo menos um dos itens correspondente àqueles que foram
   * passados
   * como parâmetros para esse método não for localizado na lista encadeada, esse
   * método deve lançar uma exceção. Sugestão: retire o modificador final do
   * atributo item da
   * classe Celula<T>.
   */

  public void trocar(E itemX, E itemY) {
    if (vazia()) {
      throw new IllegalStateException("Lista vazia: não é possível trocar itens.");
    }

    Celula<E> celulaX = null;
    Celula<E> celulaY = null;

    Celula<E> aux = primeiro.getProximo();

    while (aux != ultimo.getProximo()) {
      if (aux.getItem().equals(itemX)) {
        celulaX = aux;
      }
      if (aux.getItem().equals(itemY)) {
        celulaY = aux;
      }
      aux = aux.getProximo();
    }

    if (celulaX == null || celulaY == null) {
      throw new NoSuchElementException("Um ou ambos os itens não foram encontrados na lista.");
    }

    E temp = celulaX.getItem();
    celulaX.setItem(celulaY.getItem());
    celulaY.setItem(temp);
  }

  /*
   * Implemente o método public void concatenar (Lista<E> lista), capaz de
   * concatenar, ao final da lista original, a lista passada como parâmetro para o
   * método.
   */
  public void concatenar(Lista<E> lista) {
    if (lista.vazia()) {
      return;
    }

    Celula<E> aux = lista.primeiro.getProximo();
    while (aux != null) {
      this.inserirFinal(aux.getItem());
      aux = aux.getProximo();
    }
  }

  /*
   * Implemente o método public boolean verificarExistencia(E item), que
   * verifica a existência, na lista, de item correspondente àquele que foi
   * passado
   * como
   * parâmetro para esse método. Essa correspondência deve basear-se no(s)
   * critério(s)
   * empregado(s) na implementação do método de comparação do item. Se o item for
   * localizado na lista, esse método deve retornar true. Caso contrário, esse
   * método deve
   * retornar false.
   */
  public boolean verificarExistencia(E item) {
    Celula<E> aux = primeiro.getProximo();
    while (aux != null) {
      if (aux.getItem().equals(item)) {
        return true;
      }
      aux = aux.getProximo();
    }
    return false;
  }

  /*
   * Implemente a função public Lista<E> copiar(), capaz de criar e retornar uma
   * cópia exata da lista. Acrescente à assinatura desse método as exceções que
   * forem necessárias.
   */
  public Lista<E> copiar() {
    Lista<E> copia = new Lista<>();
    Celula<E> aux = this.primeiro.getProximo();

    while (aux != null) {
      copia.inserirFinal(aux.getItem());
      aux = aux.getProximo();
    }
    return copia;
  }



  public static void main(String[] args) {
    Lista<Double> lista = new Lista<>();

    lista.inserir(1.1, 0);
    lista.inserir(2.2, 1);
    lista.inserir(3.3, 2);
    lista.inserir(4.4, 3);
    lista.inserir(5.5, 4);
    lista.inserir(6.6, 5);

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

    System.out.println("\n== remoção do item 5.5 e 2.2 da Lista 1 ==");
    lista.remover(5.5);
    lista.remover(2.2);
    lista.imprimir();

    System.out.println("\n== número de itens da Lista 1 ==");
    System.out.println(lista.obterNumeroItens());

    System.out.println("\n== Localizando o item na posição 2 da Lista 1 ==");
    try {
      System.out.println(lista.localizar(2));
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    }
    System.out.println("\n== Localizando o item na posição 6 da Lista 1 ==");
    try {
      System.out.println(lista.localizar(6));
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    }

    System.out.println("\n== Trocando os itens 3.3 e 9.9 da Lista 1 ==");
    try {
      lista.trocar(3.3, 9.9);
      lista.imprimir();
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }

    Lista<Double> lista2 = new Lista<>();
    lista2.inserir(11.11, 0);
    lista2.inserir(12.12, 1);
    lista2.inserir(13.13, 2);
    System.out.println("\n== Lista 2 antes da concatenação ==");
    lista2.imprimir();
    System.out.println("\n== Concatenando Lista 2 na Lista 1 ==");
    lista.concatenar(lista2);
    System.out.println("\n== Lista 1 após a concatenação ==");
    lista.imprimir();

    System.out.println("\n== Verificando existência do item 4.4 na Lista 1 ==");
    boolean existe = lista.verificarExistencia(4.4);
    System.out.println("Item 4.4 existe na lista? " + existe);
    System.out.println("\n== Verificando existência do item 20.20 na Lista 1 ==");
    existe = lista.verificarExistencia(20.20);
    System.out.println("Item 20.20 existe na lista? " + existe);

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
