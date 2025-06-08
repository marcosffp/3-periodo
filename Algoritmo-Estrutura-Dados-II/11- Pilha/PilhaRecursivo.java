import java.util.NoSuchElementException;

/**
 * Implementação de uma pilha genérica utilizando células encadeadas.
 * 
 * @param <E> o tipo dos elementos armazenados na pilha.
 */
public class PilhaRecursivo<E> {
  private Celula<E> topo;
  private Celula<E> fundo;

  /**
   * Construtor da pilha.
   * Inicializa a pilha com uma célula sentinela.
   */
  public PilhaRecursivo() {
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
   * atual, utilizando recursão.
   *
   * @param numItens o número de itens a incluir na subpilha.
   * @return a nova subpilha com os elementos especificados.
   * @throws IllegalArgumentException se {@code numItens} for inválido ou exceder
   *                                  o tamanho da pilha.
   */
  public PilhaRecursivo<E> subPilha(int numItens) {
    if (numItens <= 0) {
      throw new IllegalArgumentException("Número de itens deve ser maior que zero.");
    }

    PilhaRecursivo<E> novaPilha = new PilhaRecursivo<>();
    construirSubPilhaRecursiva(topo, novaPilha, numItens);
    return novaPilha;
  }

  /**
   * Método auxiliar recursivo que constrói a subpilha.
   *
   * @param atual     a célula atual sendo analisada.
   * @param pilha     a pilha onde os elementos serão empilhados.
   * @param restantes o número de elementos restantes a serem incluídos.
   * @throws IllegalArgumentException se não houver elementos suficientes.
   */
  private void construirSubPilhaRecursiva(Celula<E> atual, PilhaRecursivo<E> pilha, int restantes) {
    if (restantes == 0) {
      return;
    }

    if (atual == fundo) {
      throw new IllegalArgumentException("Não há itens suficientes na pilha.");
    }

    construirSubPilhaRecursiva(atual.getProximo(), pilha, restantes - 1);
    pilha.empilhar(atual.getItem());
  }

  /**
   * Inverte a ordem dos elementos da pilha atual utilizando recursão.
   */
  public void inverter() {
    if (topo == fundo || topo.getProximo() == fundo) {
      return; // Pilha vazia ou com um único elemento já está invertida
    }

    // Nova pilha para armazenar a inversão
    PilhaRecursivo<E> pilhaAux = new PilhaRecursivo<>();
    inverterRecursivo(this.topo, pilhaAux);

    this.topo = pilhaAux.topo;
    this.fundo = pilhaAux.fundo;
  }

  /**
   * Método auxiliar recursivo para inverter os elementos da pilha.
   *
   * @param atual   a célula atual sendo analisada.
   * @param destino a pilha que receberá os elementos invertidos.
   */
  private void inverterRecursivo(Celula<E> atual, PilhaRecursivo<E> destino) {
    if (atual == fundo) {
      return;
    }

    inverterRecursivo(atual.getProximo(), destino);
    destino.empilhar(atual.getItem());
  }

  /**
   * Cria uma cópia exata da pilha atual utilizando recursão.
   * 
   * @return nova pilha com os mesmos elementos na mesma ordem.
   */
  public PilhaRecursivo<E> clonar() {
    PilhaRecursivo<E> pilhaClone = new PilhaRecursivo<>();
    clonarRecursivo(this.topo, pilhaClone);
    return pilhaClone;
  }

  /**
   * Método auxiliar recursivo que clona os elementos da pilha mantendo a ordem.
   *
   * @param atual      a célula atual da pilha original.
   * @param pilhaClone a pilha que está sendo construída como cópia.
   */
  private void clonarRecursivo(Celula<E> atual, PilhaRecursivo<E> pilhaClone) {
    if (atual == fundo) {
      return;
    }
    clonarRecursivo(atual.getProximo(), pilhaClone);
    pilhaClone.empilhar(atual.getItem());
  }

  /**
   * Verifica se esta pilha é igual a outra pilha, utilizando recursão.
   *
   * @param outra a outra pilha a ser comparada.
   * @return {@code true} se ambas forem iguais, {@code false} caso contrário.
   */
  public boolean ehIgual(PilhaRecursivo<E> outra) {
    if (this.obterNumeroItens() != outra.obterNumeroItens()) {
      return false;
    }

    return compararRecursivo(this.topo, outra.topo);
  }

  /**
   * Método auxiliar recursivo que compara os itens das duas pilhas.
   *
   * @param celula1 a célula atual da primeira pilha.
   * @param celula2 a célula atual da segunda pilha.
   * @return {@code true} se todos os elementos forem iguais até o fundo.
   */
  private boolean compararRecursivo(Celula<E> celula1, Celula<E> celula2) {
    if (celula1 == fundo && celula2 == fundo) {
      return true; // Ambas chegaram ao fim juntas
    }

    if (celula1 == fundo || celula2 == fundo) {
      return false; // Uma terminou antes da outra
    }

    if (!celula1.getItem().equals(celula2.getItem())) {
      return false; // Elementos diferentes
    }

    return compararRecursivo(celula1.getProximo(), celula2.getProximo());
  }

  /**
   * Retorna o número de elementos na pilha utilizando recursão.
   * 
   * @return a quantidade de elementos.
   */
  public int obterNumeroItens() {
    return contarRecursivo(this.topo);
  }

  /**
   * Método auxiliar recursivo que conta os elementos da pilha.
   *
   * @param atual a célula atual sendo analisada.
   * @return o número de elementos restantes a partir da célula atual.
   */
  private int contarRecursivo(Celula<E> atual) {
    if (atual == fundo) {
      return 0;
    }
    return 1 + contarRecursivo(atual.getProximo());
  }

}
