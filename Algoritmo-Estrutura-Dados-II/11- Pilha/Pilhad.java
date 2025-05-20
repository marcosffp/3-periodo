import java.util.NoSuchElementException;

public class Pilhad<E> {

  private Celula<E> topo;
  private Celula<E> fundo;

  public Pilhad() {

    Celula<E> sentinela = new Celula<E>();
    fundo = sentinela;
    topo = sentinela;

  }

  public boolean vazia() {
    return fundo == topo;
  }

  public void empilhar(E item) {

    topo = new Celula<E>(item, topo);
  }

  public E desempilhar() {

    E desempilhado = consultarTopo();
    topo = topo.getProximo();
    return desempilhado;

  }

  public E consultarTopo() {

    if (vazia()) {
      throw new NoSuchElementException("Nao há nenhum item na pilha!");
    }

    return topo.getItem();

  }

  public void concatenar(Pilhad<E> pilha) {
    Pilhad<E> p = new Pilhad<>();
    Celula<E> aux = pilha.topo;

    while (aux != pilha.fundo) {
      p.empilhar(aux.getItem());
      aux = aux.getProximo();
    }

    aux = p.topo;
    while (aux != p.fundo) {
      this.empilhar(aux.getItem());
      aux = aux.getProximo();
    }

  }
  
  public int obterNumeroItens() {
    Celula<E> aux = this.topo;
    int count = 0;
    while (aux != fundo) {
      count++;
      aux = aux.getProximo();
    }
    return count;
  }

  public void inverter() {
    Celula<E> aux = this.topo;
    Pilhad<E> p = new Pilhad<>();

    while (aux != fundo) {
      p.empilhar(aux.getItem());
      aux = aux.getProximo();
    }

    this.fundo = p.fundo;
    this.topo = p.topo;
  }

  public boolean isPalindrono(String p) {
    String palavra = p.replaceAll(" ", "").toUpperCase();
    Pilhad<Character> pilha = new Pilhad<>();
    for (int i = 0; i < palavra.length(); i++) {
      pilha.empilhar(palavra.charAt(i));
    }

    for (int i = 0; i < palavra.length(); i++) {
      if (!(palavra.charAt(i) == pilha.desempilhar())) {
        return false;
      }
    }

    return true;

  }
}