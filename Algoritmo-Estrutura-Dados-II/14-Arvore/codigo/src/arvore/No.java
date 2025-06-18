package arvore;


public class No<K,V> {
  private K chave;
  private V item;
  private No<K, V> direita;
  private No<K, V> esquerda;
  private int altura;

  public No(K chave, V item) {
    this.chave = chave;
    this.item = item;
    direita = esquerda = null;
    altura = 0;
  }

  public int getAltura(No<K, V> no) {
    if (no!=null) {
      return no.getAltura();
    } else {
      return -1;
    }
  }

  public int getAltura() {
    return altura;
  }

  public void setAltura(int altura) {
    this.altura = altura;
  }

  public K getChave() {
    return chave;
  }

  public void setChave(K chave) {
    this.chave = chave;
  }

  public V getItem() {
    return item;
  }

  public void setItem(V item) {
    this.item = item;
  }

  public No<K, V> getDireita() {
    return direita;
  }

  public void setDireita(No<K, V> direita) {
    this.direita = direita;
  }

  public No<K, V> getEsquerda() {
    return esquerda;
  }

  public void setEsquerda(No<K, V> esquerda) {
    this.esquerda = esquerda;
  }

  public void setAltura() {
    int alturaEsquerda = getAltura(esquerda);
    int alturaDireita = getAltura(direita);
    altura = Math.max(alturaEsquerda, alturaDireita) + 1;
  }

  public int getFatorBalanceamento() {
    int alturaEsquerda = getAltura(esquerda);
    int alturaDireita = getAltura(direita);

    return alturaEsquerda - alturaDireita;
  }

  /*
   * Implemente a função public ABB<K, V> clone(), capaz de criar e retornar uma
   * cópia exata da árvore binária de busca. A árvore binária de busca original e
   * sua cópia, retornada por esse método, podem compartilhar os mesmos itens. No
   * entanto,
   * elas não devem compartilhar os mesmos nós, ou seja, cada uma das duas árvores
   * binárias
   * de busca deve apresentar seus próprios nós.
   * Implemente também, na classe No<K, V> o método public No<K, V> clone(),
   * capaz de criar e retornar uma cópia exata do nó em questão.
   * Utilize o método clone do nó para implementar a função clone da árvore
   * binária de busca.
   */
  @Override
  public No<K, V> clone() {
    return new No<>(this.getChave(), this.getItem());
  }  
  
  

}
