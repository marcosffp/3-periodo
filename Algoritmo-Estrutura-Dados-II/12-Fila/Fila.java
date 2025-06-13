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

  public void inverter() {
    Fila<E> f = new Fila<>();
    Pilha<E> p = new Pilha<>();
    Celula<E> c = this.frente.getProximo();

    while (c != null) {
      p.empilhar(c.getItem());
      c = c.getProximo();
    }

    c = this.frente.getProximo();
    while (c != null) {
      f.enfileirar(p.desempilhar());
      c = c.getProximo();
    }

    this.frente = f.frente;
    this.tras = f.tras;
  }

  public void removerOcorrencias(E item) {
    Fila<E> f = new Fila<>();
    Celula<E> c = this.frente.getProximo();

    while (c != null) {
      if (c.getItem() != item) {
        f.enfileirar(c.getItem());
      }
      c = c.getProximo();
    }

    this.frente = f.frente;
    this.tras = f.tras;
  }
  
  public E obterItemNaPosicao(int posicao) throws Exception {
    Celula<E> c = this.frente.getProximo();
    int cont = 0;
    while (c != null) {
      if (cont == posicao) {
        return c.getItem();
      }
      cont++;
      c = c.getProximo();
    }
    throw new Exception();
  }

  public Fila<E> intercalar(Fila<E> outraFila) {
    Fila<E> f = new Fila<>();
    Celula<E> c = this.frente.getProximo();
    Celula<E> c2 = outraFila.frente.getProximo();

    int countC2, countC;
    countC = countC2 = 0;

    while (c != null) {
      c = c.getProximo();
      countC++;
    }

    while (c2 != null) {
      c2 = c2.getProximo();
      countC2++;
    }

    c = this.frente.getProximo();
    c2 = outraFila.frente.getProximo();
    if (countC == countC2) {
      while (c != null && c2 != null) {
        f.enfileirar(c.getItem());
        c = c.getProximo();
        f.enfileirar(c2.getItem());
        c2 = c2.getProximo();
      }
    } else if (countC < countC2) {
      while (c2 != null) {
        if (c != null) {
          f.enfileirar(c.getItem());
          c = c.getProximo();
        }
        f.enfileirar(c2.getItem());
        c2 = c2.getProximo();
      }
    } else {
      while (c != null) {
        f.enfileirar(c.getItem());
        c = c.getProximo();
        if (c2 != null) {
          f.enfileirar(c2.getItem());
          c2 = c2.getProximo();
        }
      }
    }

    return f;
  }
  /*
   * public Fila<E> intercalar(Fila<E> outraFila) {
   * Fila<E> f = new Fila<>();
   * Celula<E> c1 = this.frente.getProximo();
   * Celula<E> c2 = outraFila.frente.getProximo();
   * 
   * while (c1 != null || c2 != null) {
   * if (c1 != null) {
   * f.enfileirar(c1.getItem());
   * c1 = c1.getProximo();
   * }
   * if (c2 != null) {
   * f.enfileirar(c2.getItem());
   * c2 = c2.getProximo();
   * }
   * }
   * 
   * return f;
   * }
   * 
   */

  public boolean comparar(Fila<E> outraFila) {
    Celula<E> c = this.frente.getProximo();
    Celula<E> c2 = outraFila.frente.getProximo();

    while (c != null && c2 != null) {
      if (c.getItem() != c2.getItem()) {
        return false;
      }
      c = c.getProximo();
      c2 = c2.getProximo();
    }

    if (c != null || c2 != null) {
      return false;
    }

    return true;
  }
}
