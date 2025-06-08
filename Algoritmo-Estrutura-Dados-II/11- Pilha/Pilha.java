import java.util.NoSuchElementException;

/**
 * Implementação de uma pilha genérica utilizando células encadeadas.
 * 
 * @param <E> o tipo dos elementos armazenados na pilha.
 */
public class Pilha<E> {

  private Celula<E> topo;
  private Celula<E> fundo;

  /**
   * Construtor da pilha.
   * Inicializa a pilha com uma célula sentinela.
   */
  public Pilha() {
    Celula<E> sentinela = new Celula<>();
    fundo = sentinela;
    topo = sentinela;
  }

  /**
   * Verifica se a pilha está vazia.
   * 
   * @return {@code true} se estiver vazia, {@code false} caso contrário.
   */
  public boolean vazia() {
    return fundo == topo;
  }

  /**
   * Insere um item no topo da pilha.
   * 
   * @param item o elemento a ser empilhado.
   */
  public void empilhar(E item) {
    topo = new Celula<>(item, topo);
  }

  /**
   * Remove e retorna o item do topo da pilha.
   * 
   * @return o item desempilhado.
   * @throws NoSuchElementException se a pilha estiver vazia.
   */
  public E desempilhar() {
    E item = consultarTopo();
    topo = topo.getProximo();
    return item;
  }

  /**
   * Retorna o item do topo da pilha sem removê-lo.
   * 
   * @return o item no topo.
   * @throws NoSuchElementException se a pilha estiver vazia.
   */
  public E consultarTopo() {
    if (vazia()) {
      throw new NoSuchElementException("Nao há nenhum item na pilha!");
    }
    return topo.getItem();
  }

  /**
   * Cria uma nova pilha contendo os primeiros {@code numItens} elementos da pilha
   * atual.
   * 
   * @param numItens o número de itens a incluir na subpilha.
   * @return a nova subpilha com os elementos especificados.
   * @throws IllegalArgumentException se {@code numItens} for inválido ou exceder
   *                                  o tamanho da pilha.
   */
  public Pilha<E> subPilha(int numItens) {
    if (numItens <= 0) {
      throw new IllegalArgumentException("Número de itens deve ser maior que zero.");
    }

    Pilha<E> subPilha = new Pilha<>();
    Celula<E> celulaAtual = topo;

    for (int i = 0; i < numItens; i++) {
      if (celulaAtual == fundo) {
        throw new IllegalArgumentException("Não há itens suficientes na pilha.");
      }
      subPilha.empilhar(celulaAtual.getItem());
      celulaAtual = celulaAtual.getProximo();
    }

    subPilha.inverter();
    return subPilha;
  }

  /**
   * Inverte a ordem dos elementos da pilha atual.
   */
  public void inverter() {
    Pilha<E> pilhaInvertida = new Pilha<>();
    Celula<E> celulaAtual = this.topo;

    while (celulaAtual != this.fundo) {
      pilhaInvertida.empilhar(celulaAtual.getItem());
      celulaAtual = celulaAtual.getProximo();
    }

    this.fundo = pilhaInvertida.fundo;
    this.topo = pilhaInvertida.topo;
  }

  /**
   * Cria uma cópia exata da pilha atual.
   * 
   * @return nova pilha com os mesmos elementos na mesma ordem.
   */
  public Pilha<E> clonar() {
    Pilha<E> clone = new Pilha<>();
    Celula<E> celulaAtual = this.topo;

    while (celulaAtual != this.fundo) {
      clone.empilhar(celulaAtual.getItem());
      celulaAtual = celulaAtual.getProximo();
    }

    Pilha<E> pilhaClonada = new Pilha<>();
    Celula<E> celulaClone = clone.topo;

    while (celulaClone != clone.fundo) {
      pilhaClonada.empilhar(celulaClone.getItem());
      celulaClone = celulaClone.getProximo();
    }

    return pilhaClonada;
  }

  /**
   * Verifica se esta pilha é igual a outra pilha.
   * 
   * @param outra a outra pilha a ser comparada.
   * @return {@code true} se ambas forem iguais, {@code false} caso contrário.
   */
  public boolean ehIgual(Pilha<E> outra) {
    if (this.obterNumeroItens() != outra.obterNumeroItens())
      return false;

    Pilha<E> copia1 = this.clonar();
    Pilha<E> copia2 = outra.clonar();

    while (!copia1.vazia()) {
      if (!copia1.desempilhar().equals(copia2.desempilhar())) {
        return false;
      }
    }

    return true;
  }

  /**
   * Inverte a ordem das palavras de uma frase.
   * 
   * @param frase a frase a ser invertida.
   * @return a frase com as palavras em ordem inversa.
   */
  public String inverterFrase(String frase) {
    String[] palavras = frase.split(" ");
    Pilha<String> pilha = new Pilha<>();

    for (String palavra : palavras) {
      pilha.empilhar(palavra);
    }

    StringBuilder fraseInvertida = new StringBuilder();
    while (!pilha.vazia()) {
      fraseInvertida.append(pilha.desempilhar()).append(" ");
    }

    return fraseInvertida.toString().trim();
  }

  /**
   * Remove os {@code n} primeiros elementos da pilha.
   * 
   * @param n o número de elementos a remover.
   */
  public void removerNPrimeiros(int n) {
    int total = this.obterNumeroItens();

    if (n >= total) {
      while (!this.vazia())
        this.desempilhar();
    } else {
      for (int i = 0; i < n; i++) {
        this.desempilhar();
      }
    }
  }

  /**
   * Concatena outra pilha ao topo da pilha atual, preservando a ordem.
   * 
   * @param pilha a pilha a ser concatenada.
   */
  public void concatenar(Pilha<E> pilha) {
    Pilha<E> pilhaTemporaria = new Pilha<>();
    Celula<E> celulaAtual = pilha.topo;

    while (celulaAtual != pilha.fundo) {
      pilhaTemporaria.empilhar(celulaAtual.getItem());
      celulaAtual = celulaAtual.getProximo();
    }

    while (!pilhaTemporaria.vazia()) {
      this.empilhar(pilhaTemporaria.desempilhar());
    }
  }

  /**
   * Retorna o número de elementos na pilha.
   * 
   * @return a quantidade de elementos.
   */
  public int obterNumeroItens() {
    int contador = 0;
    Celula<E> celulaAtual = this.topo;

    while (celulaAtual != this.fundo) {
      contador++;
      celulaAtual = celulaAtual.getProximo();
    }

    return contador;
  }

  /**
   * Verifica se a palavra informada é um palíndromo.
   * 
   * @param palavra a palavra a ser testada.
   * @return {@code true} se for palíndromo, {@code false} caso contrário.
   */
  public boolean ePalindromo(String palavra) {
    String texto = palavra.replaceAll("[^a-zA-Z]", "").toUpperCase();
    Pilha<Character> pilha = new Pilha<>();

    for (char c : texto.toCharArray()) {
      pilha.empilhar(c);
    }

    for (int i = 0; i < texto.length(); i++) {
      if (texto.charAt(i) != pilha.desempilhar()) {
        return false;
      }
    }

    return true;
  }

  /**
   * Remove todas as ocorrências de um determinado valor da pilha.
   * 
   * @param valor o valor a ser removido.
   */
  public void removerOcorrencias(E valor) {
    Pilha<E> pilhaFiltrada = new Pilha<>();
    Celula<E> celulaAtual = this.topo;

    while (celulaAtual != this.fundo) {
      if (!celulaAtual.getItem().equals(valor)) {
        pilhaFiltrada.empilhar(celulaAtual.getItem());
      }
      celulaAtual = celulaAtual.getProximo();
    }

    pilhaFiltrada.inverter();
    this.topo = pilhaFiltrada.topo;
    this.fundo = pilhaFiltrada.fundo;
  }

  /**
   * Duplica todos os elementos da pilha, mantendo a ordem.
   */
  public void duplicarElementos() {
    Pilha<E> pilhaDuplicada = new Pilha<>();
    Celula<E> celulaAtual = this.topo;

    while (celulaAtual != this.fundo) {
      pilhaDuplicada.empilhar(celulaAtual.getItem());
      pilhaDuplicada.empilhar(celulaAtual.getItem());
      celulaAtual = celulaAtual.getProximo();
    }

    pilhaDuplicada.inverter();
    this.topo = pilhaDuplicada.topo;
    this.fundo = pilhaDuplicada.fundo;
  }

  /**
   * Verifica se um item existe na pilha.
   * 
   * @param item o item a ser verificado.
   * @return {@code true} se o item existir, {@code false} caso contrário.
   */
  public boolean verificarExistencia(E item) {
    Celula<E> aux = this.topo;
    while (aux != this.fundo) {
      if (aux.getItem().equals(item)) {
        return true;
      }
      aux = aux.getProximo();
    }
    return false;
  }

  /**
   * Obtém o número de itens que estão à frente de um item específico na pilha.
   * 
   * @param item o item a ser verificado.
   * @return o número de itens à frente do item especificado.
   * @throws Exception se o item não for encontrado na pilha.
   */
  public int obterNumItensAFrente(E item) throws Exception {
    Celula<E> aux = this.topo;
    int contador = 0;

    while (aux != this.fundo) {
      if (aux.getItem().equals(item)) {
        return contador;
      }
      contador++;
      aux = aux.getProximo();
    }

    throw new IllegalArgumentException("Item não encontrado na pilha.");
  }

  /**
   * Divide a pilha em duas: esta pilha manterá os elementos nas posições pares
   * (0, 2, 4...),
   * e será retornada uma nova pilha com os elementos nas posições ímpares (1, 3,
   * 5...).
   *
   * @return uma nova pilha contendo os elementos nas posições ímpares.
   */
  public Pilha<E> dividir() {
    Pilha<E> pilhaReversa = new Pilha<>();
    Pilha<E> pares = new Pilha<>();
    Pilha<E> impares = new Pilha<>();

    Celula<E> celulaAtual = this.topo;
    while (celulaAtual != this.fundo) {
      pilhaReversa.empilhar(celulaAtual.getItem());
      celulaAtual = celulaAtual.getProximo();
    }

    int indice = 0;
    while (!pilhaReversa.vazia()) {
      E item = pilhaReversa.desempilhar();
      if (indice % 2 == 0) {
        pares.empilhar(item);
      } else {
        impares.empilhar(item);
      }
      indice++;
    }

    this.topo = pares.topo;
    this.fundo = pares.fundo;

    return impares;
  }

}
