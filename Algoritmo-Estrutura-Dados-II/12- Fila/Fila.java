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

  public void concatenar(Fila<E> fila) {
    while (!fila.vazia()) {
      this.enfileirar(fila.desenfileirar());
    }
  }

  public int obterNumeroItens() {
    Celula<E> aux = this.frente.getProximo();
    int cont = 0;
    while (aux != null) {
      cont++;
      aux = aux.getProximo();
    }
    return cont;
  }

  public boolean verificarExistencia(E item) {
    Celula<E> aux = this.frente.getProximo();
    while (aux.getProximo() != null) {
      if (aux.getItem().equals(item)) {
        return true;
      }
    }
    return false;
  }

  public int obterNumItensAFrente(E item) throws Exception {
    Celula<E> aux = this.frente.getProximo();
    int cont = 0;

    while (aux != null) {
      if (aux.getItem().equals(item)) {
        return cont;
      }
      cont++;
      aux = aux.getProximo();
    }

    throw new Exception("Não tem esse item");
  }
  
  public Fila<E> copiar() {
    Fila<E> f = new Fila<>();
    Celula<E> c = this.frente.getProximo();

    while (c != null) {
      f.enfileirar(c.getItem());
      c = c.getProximo();
    }

    return f;
  }

  public Fila<E> dividir(){
    Fila<E> fila = new Fila<>();
    Celula<E> celY, celX;

    celY = this.frente;
    celX = celY.getProximo();

    while (celX != null) {
      fila.enfileirar(celX.getItem());
      celY.setProximo(celX.getProximo());
      celX.setProximo(null);
      if (celY.getProximo() != null) {
        celY = celY.getProximo();
        celX = celY.getProximo();
      } else {
        celX = null;
      }
    }
    
    this.tras = celY;
    return fila;
  }

}
