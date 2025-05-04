import java.util.NoSuchElementException;

public class Pilha<E> {

  private Celula<E> topo;
  private Celula<E> fundo;

  public Pilha() {

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

  public Pilha<E> subPilha(int numItens) {

    if (numItens <= 0)
      throw new IllegalArgumentException("Números de itens tem que ser maior que zero");
    Pilha<E> suPilha = new Pilha<>();
    Celula<E> aux = topo;

    for (int i = 0; i < numItens; i++) {
      if (aux == fundo)
        throw new IllegalArgumentException("Não há essa quantidade de itens");
      suPilha.empilhar(aux.getItem());
      aux = aux.getProximo();
    }
    suPilha.inverter();
    return suPilha;
  }

  public void inverter() {
    Pilha<E> pilhaInvertida = new Pilha<>();
    Celula<E> aux = this.topo;

    while (aux != this.fundo) {
      pilhaInvertida.empilhar(aux.getItem());
      aux = aux.getProximo();
    }
    this.fundo = pilhaInvertida.fundo;
    this.topo = pilhaInvertida.topo;
  }

  public Pilha<E> clonar() {
    Pilha<E> clone = new Pilha<>();
    Celula<E> aux = this.topo;

    while (aux != this.fundo) {
      clone.empilhar(aux.getItem());
      aux = aux.getProximo();
    }

    Pilha<E> clone2 = new Pilha<>();
    Celula<E> aux2 = clone.topo;
    while (aux2 != this.fundo) {
      clone2.empilhar(aux2.getItem());
      aux2 = aux2.getProximo();
    }

    return clone2;
  }

  public boolean ehIgual(Pilha<E> outra) {
    Celula<E> auxOutra = outra.topo;
    Celula<E> auxPrincipal = this.topo;
    int contOutra = 0;
    while (auxOutra != outra.fundo) {
      auxOutra = auxOutra.getProximo();
      contOutra++;
    }

    int contPrincipal = 0;
    while (auxPrincipal != this.fundo) {
      auxPrincipal = auxPrincipal.getProximo();
      contPrincipal++;
    }

    if (contOutra == contPrincipal) {
      auxOutra = outra.topo;
      auxPrincipal = this.topo;
      while (auxOutra != outra.fundo) {
        if (!this.desempilhar().equals(outra.desempilhar())) {
          return false;
        }
        auxOutra = auxOutra.getProximo();
      }

    } else {
      return false;
    }

    return true;

  }
  
  public String inverteFrase(String p) {
    String[] palavras = p.split(" ");
    Pilha<String> pilha = new Pilha<>();

    for (int i = 0; i < palavras.length; i++) {
      pilha.empilhar(palavras[i]);
    }
    String palavra = "";
    while (pilha.topo != pilha.fundo) {
      palavra += pilha.desempilhar() + " ";
    }

    return palavra;
  }

  public void removerNPrimeiros(int n) {
    Celula<E> aux = this.topo;
    int cont = 0;
    while (aux != this.fundo) {
      aux = aux.getProximo();
      cont++;
    }

    if (n > cont) {
      while (!this.vazia()) {
        this.desempilhar();
      }
    }

    for (int i = 0; i < n; i++) {
      this.desempilhar();
    }
  }
  
  public void concatenar(Pilha<E> pilha) {
    Pilha<E> p = new Pilha<>();
    Celula<E> aux = pilha.topo;

    while (aux != pilha.fundo) {
      p.empilhar(aux.getItem());
      aux = aux.getProximo();
    }

    while (this.topo != this.fundo) {
      this.empilhar(p.desempilhar());
    }
  }
  
  public int obterNumeroItens() {
    Celula<E> aux = this.topo;

    int cont = 0;
    while (aux != this.fundo) {
      aux = aux.getProximo();
      cont++;
    }

    return cont;
  }
  
  public boolean ePalindromo(String p) {
    Pilha<Character> pilha = new Pilha<>();
    String palavra = p.replaceAll("[^a-zA-Z]", "").toUpperCase();
    for (int i = 0; i < palavra.length(); i++) {
      pilha.empilhar(palavra.charAt(i));
    }

    for (int i = 0; i < palavra.length(); i++) {
      if ((palavra.charAt(i) != pilha.desempilhar())) {
        return false;
      }
    }

    return true;
  }
  
  public void removerOcorrencias(E valor) {
    Pilha<E> pilha = new Pilha<>();
    Celula<E> aux = this.topo;

    while (aux != this.fundo) {
      if (aux.getItem() != valor) {
        pilha.empilhar(aux.getItem());
      }
      aux = aux.getProximo();
    }

    Pilha<E> pilhaInvert = new Pilha<>();
    aux = pilha.topo;
    while (!pilha.vazia()) {
      pilhaInvert.empilhar(pilha.desempilhar());
    }
    this.fundo = pilhaInvert.fundo;
    this.topo = pilhaInvert.topo;
  }
  
  public void duplicarElementos() {
    Pilha<E> p = new Pilha<>();
    Celula<E> aux = this.topo;
    while (aux != this.fundo) {
      p.empilhar(aux.getItem());
      p.empilhar(aux.getItem());
      aux = aux.getProximo();
    }
    
    Pilha<E> pilhaInvert = new Pilha<>();
    aux = p.topo;
    while (!p.vazia()) {
      pilhaInvert.empilhar(p.desempilhar());
    }
    this.fundo = pilhaInvert.fundo;
    this.topo = pilhaInvert.topo;
  }




  

}