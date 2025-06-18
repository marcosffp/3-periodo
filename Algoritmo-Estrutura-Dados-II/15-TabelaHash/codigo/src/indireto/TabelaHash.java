package indireto;

import java.util.List;
import java.util.NoSuchElementException;

public class TabelaHash<K,V> implements IMapeamento<K, V> {
  private Lista<Entrada<K, V>>[] tabelaHash;
  private int capacidade;


  @SuppressWarnings("unchecked")
  public TabelaHash(int capacidade) {
    if (capacidade <= 1) {
      throw new IllegalArgumentException("Capacidade deve ser maior que 1.");

    }
    this.capacidade = capacidade;
    tabelaHash = (Lista<Entrada<K, V>>[]) new Lista[capacidade];
    for (int i = 0; i < capacidade; i++) {
      tabelaHash[i] = new Lista<>();
    }
  }
  
  public int funcaoHash(K chave) {
    return Math.abs(chave.hashCode() % capacidade);
  }

  @Override
  public int inserir(K chave, V item) {
    int posicao = funcaoHash(chave);
    Entrada<K, V> entrada = new Entrada<>(chave, item);
    try {
      entrada = tabelaHash[posicao].pesquisar(entrada);
      throw new IllegalArgumentException("Chave já existe na tabela.");
    } catch (NoSuchElementException e) {
      tabelaHash[posicao].inserirFinal(entrada);
      return posicao;
    }
  }

  @Override
  public V pesquisar(K chave) {
    int posicao = funcaoHash(chave);
    Entrada<K, V> entrada = new Entrada<>(chave, null);
    return tabelaHash[posicao].pesquisar(entrada).getValor();
  }

  @Override
  public V remover(K chave) {
    int posicao = funcaoHash(chave);
    Entrada<K, V> entrada = new Entrada<>(chave, null);
    entrada = tabelaHash[posicao].pesquisar(entrada);
    tabelaHash[posicao].remover(entrada);
    return entrada.getValor();
  }

  @Override
  public int tamanho() {
    int tamanho = 0;
    for (int i = 0; i < capacidade; i++) {
      tamanho += tabelaHash[i].tamanho();
    }
    return tamanho;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("TabelaHash{");
    for (int i = 0; i < capacidade; i++) {
      sb.append("Posição ").append(i).append(": ").append(tabelaHash[i].toString()).append("\n");
    }
    sb.append("}");
    return sb.toString();
  }


  /*
   * Implemente o método public boolean vazia(), que deve retornar
   * verdadeiro se a tabela hash estiver vazia, ou seja, não estiver armazenando
   * nenhum mapeamento chave-valor; e falso, no caso contrário.
   */
  public boolean vazia() {
    for (int i = 0; i < capacidade; i++) {
      if (!tabelaHash[i].vazia()) {
        return false;
      }
    }
    return true;
  }

  /*
   * Implemente o método public int obterTamanho(), que retorna o número
   * de mapeamentos chave-valor presentes na tabela hash. Realize as modificações
   * necessárias na classe para a correta execução desse método.
   */
  public int obterTamanho() {
    int tam = 0;
    for (int i = 0; i < capacidade; i++) {
      tam += tabelaHash[i].tamanho();
    }
    return tam;
  }
  
  /*
   * Implemente o método public boolean contemValor(V valor), que deve
   * retornar verdadeiro se a tabela hash estiver mapeando uma ou mais chaves
   * para o valor especificado como parâmetro para esse método; e falso, no caso
   * contrário. Implemente também os métodos que julgar necessários na classe
   * Lista<E>.
   */
  public boolean contemValor(V valor) {
    for (int i = 0; i < capacidade; i++) {
      for (int j = 0; j < tabelaHash[i].tamanho(); j++) {
        Entrada<K, V> entrada = tabelaHash[i].localizar(j);
        if (entrada.getValor().equals(valor)) {
          return true;
        }
      }
    }
    return false;
  }
   
  /*
   * Implemente o método public Lista<Entrada<K, V>>
   * obterTodasEntradas(), capaz de retornar uma lista encadeada simples com
   * todos os mapeamentos chave-valor contidos na tabela hash. Implemente também
   * os métodos que julgar necessários na classe Lista<E>, assim como a classe
   * Entrada<K, V>.
   */
  public Lista<Entrada<K, V>> obterTodasEntradas() {
    Lista<Entrada<K, V>> lista = new Lista<>();

    for (int i = 0; i < capacidade; i++) {
      Lista<Entrada<K, V>> bucket = tabelaHash[i];
      for (int j = 0; j < bucket.tamanho(); j++) {
        Entrada<K, V> entrada = bucket.localizar(j);
        lista.inserirFinal(entrada);
      }
    }
    return lista;
  }
  
  /*
   * Implemente o método public Lista<K> obterTodasChaves(), responsável
   * por retornar uma lista encadeada simples com todas as chaves presentes na
   * tabela hash. Implemente também os métodos que julgar necessários na classe
   * Lista<E>.
   */
  public Lista<K> obterTodasChaves() {
    Lista<K> listaChaves = new Lista<>();
    for (int i = 0; i < capacidade; i++) {
      Lista<Entrada<K, V>> bucket = tabelaHash[i];
      for (int j = 0; j < bucket.tamanho(); j++) {
        Entrada<K, V> entrada = bucket.localizar(j);
        listaChaves.inserirFinal(entrada.getChave());
      }
    }
    return listaChaves;
  }
  /*
   * Implemente o método public Lista<V> obterTodosValores(),
   * responsável por retornar uma lista encadeada simples com todos os valores
   * presentes na tabela hash. Implemente também os métodos que julgar necessários
   * na classe Lista<E>.
   */
  public Lista<V> obterTodosValores() {
    Lista<V> listaValores = new Lista<>();
    for (int i = 0; i < capacidade; i++) {
      Lista<Entrada<K, V>> bucket = tabelaHash[i];
      for (int j = 0; j < bucket.tamanho(); j++) {
        Entrada<K, V> entrada = bucket.localizar(j);
        listaValores.inserirFinal(entrada.getValor());
      }
    }
    return listaValores;
  }

  /*
   * Implemente o método public void substituir(K chave, V
   * novoValor), que substitui o valor associado à chave passada como parâmetro
   * para o valor especificado no parâmetro novoValor.
   */
  public void substituir(K chave, V novoValor) {
    int posicao = funcaoHash(chave);
    Entrada<K, V> entrada = new Entrada<>(chave, novoValor);
    entrada = tabelaHash[posicao].pesquisar(entrada);
    entrada.setValor(novoValor);
    }

  public static void main(String[] args) {
    TabelaHash<Integer, Integer> hash = new TabelaHash<>(8);
    hash.inserir(1, 10);
    hash.inserir(2, 20);
    hash.inserir(3, 30);
    hash.inserir(4, 40);
    hash.inserir(5, 50);
    hash.inserir(6, 60);
    hash.inserir(7, 70);
    hash.inserir(8, 80);

    System.out.println("==Verificando se a tabela está vazia==");
    System.out.println(hash.vazia());

    System.out.println("\n==Tamanho da tabela==");
    System.out.println(hash.obterTamanho());

    System.out.println("\n==Contendo valor 30?==");
    System.out.println(hash.contemValor(30));
    System.out.println("\n==Contendo valor 100?==");
    System.out.println(hash.contemValor(100));

    Lista<Entrada<Integer, Integer>> entradas = hash.obterTodasEntradas();
    System.out.println("\n==Todas as entradas na tabela==");
    entradas.imprimir();

    Lista<Integer> chaves = hash.obterTodasChaves();
    System.out.println("\n==Todas as chaves na tabela==");
    chaves.imprimir();

    Lista<Integer> valores = hash.obterTodosValores();
    System.out.println("\n==Todos os valores na tabela==");
    valores.imprimir();

    System.out.println("\n==Substituindo o valor da chave 3==");
    hash.substituir(3, 99);
    System.out.println(hash.pesquisar(3));
  }
  
}
