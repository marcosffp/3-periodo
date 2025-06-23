

import java.util.NoSuchElementException;

public class Lista<E> {
  private int tamanho;
  private Celula<E> primeiro;
  private Celula<E> ultimo;


  public Lista() {
    Celula<E> sentinela = new Celula<>();
    primeiro = ultimo = sentinela;
    tamanho = 0;
  }

  public boolean vazia() {
    return primeiro == ultimo;
  }

  public void inserir(E item, int pos) {
    if (pos < 0 || pos > tamanho) {
      throw new NoSuchElementException();
    }

    Celula<E> anterior = this.primeiro;
    for (int i = 0; i < pos; i++) {
      anterior = anterior.getProximo();
    }
    Celula<E> posterior = anterior.getProximo();
    Celula<E> novaCelula = new Celula<E>(item, posterior);
    anterior.setProximo(novaCelula);
    if (pos == tamanho) {
      ultimo = novaCelula;
    }
    tamanho++;
  }
  
  public E remover(int pos) {
    if (vazia()) {
      throw new NoSuchElementException();
    }

    if (pos < 0 || pos >= tamanho) {
      throw new NoSuchElementException();
    }

    Celula<E> anterior = this.primeiro;
    for (int i = 0; i < pos; i++) {
      anterior = anterior.getProximo();
    }

    Celula<E> removido = anterior.getProximo();
    Celula<E> posterior = removido.getProximo();

    anterior.setProximo(posterior);
    removido.setProximo(null);
    if (removido == ultimo) {
      ultimo = anterior;
    }
    tamanho--;
    return removido.getItem();
  }

  public int getTamanho() {
    return tamanho;
  }
















  public void inserirFinal(E novo) {
    Celula<E> novoItem = new Celula<E>(novo);
    ultimo.setProximo(novoItem);
    ultimo = ultimo.getProximo();
    tamanho++;

  }
  
  public E removerInicio() {
    if (vazia()) {
      throw new NoSuchElementException();
    }

    Celula<E> removido = this.primeiro.getProximo();
    primeiro.setProximo(removido.getProximo());
    tamanho--;
    return removido.getItem();
  }

  public E removerr(E itemProcurado) {
    if (vazia()) {
      throw new NoSuchElementException();
    }

    Celula<E> aux = this.primeiro.getProximo();
    int i = 0;
    while (aux != null) {
      if (aux.getItem().equals(itemProcurado)) {
        return remover(i);
      }
      aux = aux.getProximo();
      i++;
    }
    throw new NoSuchElementException("Item não encontrado na fila");
  }

  public int obterNumeroItens() {
    return tamanho;
  }

  public E localizar(int pos) {
    if (vazia()) {
      throw new NoSuchElementException();
    }
    if (pos < 0 || pos >= tamanho) {
      throw new NoSuchElementException();
    }

    Celula<E> anterior = this.primeiro;
    for (int i = 0; i < pos; i++) {
      anterior = anterior.getProximo();
    }

    Celula<E> localizado = anterior.getProximo();
    return localizado.getItem();

  }

  public E localizar(E procurado) throws Exception {
    if (vazia()) {
      throw new IllegalStateException("A Lista está vazia");
    }

    Celula<E> aux = this.primeiro.getProximo();
    while (aux != null) {
      if (aux.getItem().equals(procurado)) {
        return aux.getItem();
      }
      aux = aux.getProximo();
    }

    throw new NoSuchElementException("Não encontrado o item procurado");
  }
  

  
  public void trocar(E itemX, E itemY) {
    if (!existe(itemY) || !existe(itemX)) {
      throw new NoSuchElementException();
    }

    int posX = posicao(itemX);
    int posY = posicao(itemY);

    Celula<E> aux = this.primeiro.getProximo();
    for (int i = 0; i < tamanho; i++) {
      if (i == posX) {
        aux.setItem(itemY);
      }
      if (i == posY) {
        aux.setItem(itemX);
      }
      aux = aux.getProximo();
    }

  }
  
  public int posicao(E item) {
    int count = 0;
    Celula<E> aux = this.primeiro.getProximo();
    while (!aux.getItem().equals(item)) {
      count++;
      aux = aux.getProximo();
    }
    return count;
  }
  
  public boolean existe(E item) {
    Celula<E> aux = this.primeiro.getProximo();
    while (aux != null) {
      if (aux.getItem().equals(item)) {
        return true;
      }
      aux = aux.getProximo();
    }
    return false;
  }


















  public void concatenar(Lista<E> lista) {
    while (!lista.vazia()) {
      this.inserir(lista.remover(0), tamanho);
    }
  }

  public void inverter() {
    int n = tamanho - 1;
    for (int i = 0; i < n; i++) {
      E item = remover(tamanho - 1);
      inserir(item, i);
    }
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Celula<E> aux = primeiro.getProximo();
    while (aux != null) {
      sb.append(aux.getItem()).append(" ");
      aux = aux.getProximo();
    }
    return sb.toString().trim();
  }
  
  public static void main(String[] args) {
    Lista<Integer> l = new Lista<>();
    l.inserir(1, 0);
    l.inserir(2, 1);
    l.inserir(3, 2);
    l.inserir(4, 3);

    l.inverter();
    while (!l.vazia()) {
      System.out.println(l.remover(0));
    }
  }
  
  public boolean isPalindromo(String p) {
    String palavra = p.replaceAll(" ", "").toUpperCase();
    Lista<Character> lista = new Lista<>();

    for (int i = 0; i < palavra.length(); i++) {
      lista.inserir(palavra.charAt(i), i);
    }

    for (int i = palavra.length() - 1; i >= 0; i--) {
      if (!(lista.remover(0) == palavra.charAt(i))) {
        return false;
      }
    }

    return true;
  }























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

  public int obterNumItensAFrente(E item) {
    int count = 0;
    Celula<E> aux = primeiro.getProximo();
    while (aux != null) {
      if (aux.getItem().equals(item)) {
        return count;
      }
      count++;
      aux = aux.getProximo();
    }

    throw new NoSuchElementException();
  }

  public Lista<E> copiar() {
    Lista<E> lista = new Lista<>();
    Celula<E> aux = primeiro.getProximo();
    while (aux != null) {
      lista.inserir(aux.getItem(), lista.tamanho);
      aux = aux.getProximo();
    }
    return lista;
  }

  public Lista<E> dividir() {
    Lista<E> pares = new Lista<>();
    Lista<E> impares = new Lista<>();
    Celula<E> aux = this.primeiro.getProximo();

   for (int i = 0; i < tamanho; i++) {
    if (i%2==0) {
      pares.inserir(aux.getItem(), i);
    } else {
      impares.inserir(aux.getItem(), i);
    }
    aux = aux.getProximo();
   }
    this.primeiro = pares.primeiro;
    this.ultimo = pares.ultimo;
    this.tamanho = pares.tamanho;

    return impares;
  }


















  public E obterUltimo() {
    if (vazia()) {
      throw new NoSuchElementException();
    }

    return ultimo.getItem();
  }
  

  public E obterInicio() {
    if (vazia()) {
      throw new NoSuchElementException();
    }

    return primeiro.getProximo().getItem();
  }

  public void removerDuplicados() {
    Celula<E> atual = primeiro.getProximo();
    int posAtual = 0;

    while (atual != null) {
      E itemAtual = atual.getItem();
      Celula<E> comparador = atual.getProximo();
      int posComparador = posAtual + 1;

      while (comparador != null) {
        if (itemAtual.equals(comparador.getItem())) {
          remover(posComparador);
          comparador = atual.getProximo();
        } else {
          comparador = comparador.getProximo();
          posComparador++;
        }
      }

      atual = atual.getProximo();
      posAtual++;
    }
  }
}
