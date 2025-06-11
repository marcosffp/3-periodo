package arvore;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

public class ABB<K, V> implements IMapeamento<K, V> {

  private No<K, V> raiz;
  private int tamanho;
  private Comparator<K> comparador;

  public ABB(Comparator<K> comparador) {
    this.comparador = comparador;
    raiz = null;
    tamanho = 0;
  }

  public boolean vazia() {
    return raiz == null;
  }

  @Override
  public int inserir(K chave, V item) {
    this.raiz = inserir(chave, item, raiz);
    tamanho++;
    return tamanho;
  }

  protected No<K, V> inserir(K chave, V item, No<K, V> raizArvore) {
    if (raizArvore == null) {
      raizArvore = new No<>(chave, item);
    } else {
      int comparacao = comparador.compare(chave, raizArvore.getChave());
      if (comparacao == 0) {
        throw new IllegalArgumentException("Já tem essa chave inserido");
      } else if (comparacao > 0) {
        raizArvore.setDireita(inserir(chave, item, raizArvore.getDireita()));
      } else {
        raizArvore.setEsquerda(inserir(chave, item, raizArvore.getEsquerda()));
      }
    }
    return raizArvore;
  }

  @Override
  public V pesquisar(K chave) {
    return pesquisar(chave, raiz);
  }

  private V pesquisar(K chave, No<K, V> raizArvore) {
    if (raizArvore == null) {
      throw new NoSuchElementException("Não encontrado o elemento");
    } else {
      int comparacao = comparador.compare(chave, raizArvore.getChave());
      if (comparacao == 0) {
        return raizArvore.getItem();
      } else if (comparacao > 0) {
        return pesquisar(chave, raizArvore.getDireita());
      } else {
        return pesquisar(chave, raizArvore.getEsquerda());
      }
    }
  }

  @Override
  public V remover(K chave) {
    V removido = pesquisar(chave);
    this.raiz = remover(chave, raiz);
    tamanho--;
    return removido;
  }

  protected No<K, V> remover(K chave, No<K, V> raizArvore) {
    if (raizArvore == null) {
      throw new NoSuchElementException("Sem elementos");
    } else {
      int comparacao = comparador.compare(chave, raizArvore.getChave());
      if (comparacao == 0) {
        if (raizArvore.getDireita() == null) {
          raizArvore = raizArvore.getEsquerda();
        } else if (raizArvore.getEsquerda() == null) {
          raizArvore = raizArvore.getDireita();
        } else {
          raizArvore.setEsquerda(removerAntecessor(raizArvore, raizArvore.getEsquerda()));
        }
      } else if (comparacao > 0) {
        raizArvore.setDireita(remover(chave, raizArvore.getDireita()));
      } else {
        raizArvore.setEsquerda(remover(chave, raizArvore.getEsquerda()));
      }
    }
    return raizArvore;
  }

  private No<K, V> removerAntecessor(No<K, V> itemRemover, No<K, V> raizArvore) {
    if (raizArvore.getDireita() != null) {
      return removerAntecessor(itemRemover, raizArvore.getDireita());
    } else {
      itemRemover.setChave(raizArvore.getChave());
      itemRemover.setItem(raizArvore.getItem());
      raizArvore = raizArvore.getEsquerda();
    }
    return raizArvore;
  }

  @Override
  public int tamanho() {
    return tamanho;
  }

  /*
   * EXERCÍCIOS DA LISTA DE SOBRE ÁRVORES BINÁRIAS DE BUSCA
   */

  /*
   * Implemente o método public String caminhamentoPreOrdem()
   * que percorre a árvore binária de busca em pré-ordem, retornando uma string
   * com os valores de seus elementos.
   * Se a árvore estiver vazia, deve lançar uma exceção.
   * Sugestão: V deve sobrescrever o método toString(), para que ABB<K, V>
   * permaneça genérica.
   */

  public String caminhamentoPreOrdem() {
    if (vazia()) {
      throw new IllegalStateException("A árvore está vazia");
    }
    return caminhamentoPreOrdem(raiz);
  }

  private String caminhamentoPreOrdem(No<K, V> raizArvore) {
    if (raizArvore == null) {
      return "";
    } else {
      String caminho = "";
      caminho += raizArvore.getItem().toString() + " ";
      caminho += caminhamentoPreOrdem(raizArvore.getEsquerda());
      caminho += caminhamentoPreOrdem(raizArvore.getDireita());
      return caminho;
    }
  }

  /*
   * QUESTÃO EXTRA: Implemente o método public String caminhamentoEmOrdem()
   * que percorre a árvore binária de busca em ordem, retornando uma string com os
   * valores de seus elementos.
   * Se a árvore estiver vazia, deve lançar uma exceção.
   * Sugestão: V deve sobrescrever o método toString(), para que ABB<K, V>
   * permaneça genérica.
   */
  public String caminhamentoEmOrdem() {
    if (vazia()) {
      throw new IllegalStateException("A árvore está vazia");
    }
    return caminhamentoEmOrdem(raiz);
  }

  private String caminhamentoEmOrdem(No<K, V> raizArvore) {
    if (raizArvore == null) {
      return "";
    } else {
      String caminho = "";
      caminho += caminhamentoEmOrdem(raizArvore.getEsquerda());
      caminho += raizArvore.getItem().toString() + " ";
      caminho += caminhamentoEmOrdem(raizArvore.getDireita());
      return caminho;
    }
  }
  
  /*
   * QUESTÃO EXTRA: Implemente o método public String caminhamentoEmNivel()
   * que percorre a árvore binária de busca em nível, retornando uma string com os
   * valores de seus elementos.
   * Se a árvore estiver vazia, deve lançar uma exceção.
   * Sugestão: V deve sobrescrever o método toString(), para que ABB<K, V>
   * permaneça genérica.
   */
  public String caminhamentoEmNivel() {
    if (vazia()) {
      throw new IllegalStateException("A árvore está vazia");
    }
    return caminhamentoEmNivel(raiz);
  }

  private String caminhamentoEmNivel(No<K, V> raizArvore) {
    Lista<No<K, V>> lista = new Lista<>();
    No<K, V> atual = null;
    String caminho = "";
    lista.inserir(raiz, lista.getTamanho());
    while (!lista.vazia()) {
      atual = lista.remover(0);
      caminho += atual.getItem().toString() + " ";
      if (atual.getEsquerda() != null) {
        lista.inserir(atual.getEsquerda(), lista.getTamanho());
      }
      if (atual.getDireita() != null) {
        lista.inserir(atual.getDireita(), lista.getTamanho());
      }
    }
    return caminho;
    
  }

  /*
   * Implemente o método public String caminhamentoPosOrdem(), capaz de
   * percorrer a árvore binária de busca em pós-ordem, retornando uma string com
   * os valores de seus elementos. Se a árvore binária de busca estiver vazia, uma
   * exceção
   * deve ser lançada.
   * Sugestão: V deve sobrescrever a função public String toString(), de forma que
   * a classe ABB<K, V> permaneça genérica
   */
  public String caminhamentoPosOrdem() {
    if (vazia()) {
      throw new IllegalStateException("A árvore está vazia");
    }
    return caminhamentoPosOrdem(raiz);
  }

  private String caminhamentoPosOrdem(No<K, V> raizArvore) {
    if (raizArvore == null) {
      return "";
    }
    String caminho = "";
    caminho += caminhamentoPosOrdem(raizArvore.getEsquerda());
    caminho += caminhamentoPosOrdem(raizArvore.getDireita());
    caminho += raizArvore.getItem().toString() + " ";
    return caminho;
  }

  /*
   * Implemente o método public String caminhamentoDecrescente(), capaz de
   * percorrer a árvore binária de busca retornando uma string com os valores de
   * seus elementos, em ordem decrescente. Se a árvore binária de busca estiver
   * vazia,
   * uma exceção deve ser lançada.
   * Sugestão: V deve sobrescrever a função public String toString(), de forma que
   * a classe ABB<K, V> permaneça genérica.
   */
  public String caminhamentoDecrescente() {
    if (vazia()) {
      throw new IllegalStateException("A árvore está vazia");
    }
    return caminhamentoDecrescente(raiz);
  }

  private String caminhamentoDecrescente(No<K, V> raizArvore) {
    if (raizArvore == null) {
      return "";
    } else {
      String caminho = "";
      caminho += caminhamentoDecrescente(raizArvore.getDireita());
      caminho += raizArvore.getItem().toString() + " ";
      caminho += caminhamentoDecrescente(raizArvore.getEsquerda());
      return caminho;
    }
  }

  /*
   * Implemente o método public V obterMenor(), método responsável por recuperar e
   * retornar o menor elemento armazenado na árvore binária de busca. Se a árvore
   * binária de busca estiver vazia, uma exceção deve ser lançada.
   */
  public V obterMenor() {
    if (vazia()) {
      throw new IllegalStateException("A árvore está vazia");
    }
    return obterMenor(raiz);
  }

  private V obterMenor(No<K, V> raizArvore) {
    if (raizArvore.getEsquerda() != null) {
      return obterMenor(raizArvore.getEsquerda());
    } else {
      return raizArvore.getItem();
    }
  }

  /*
   * QUESTÃO EXTRA: Implemente o método public V obterMaior(), método responsável
   * por recuperar e
   * retornar o maior elemento armazenado na árvore binária de busca. Se a árvore
   * binária de busca estiver vazia, uma exceção deve ser lançada.
   */
  public V obterMaior() {
    if (vazia()) {
      throw new IllegalStateException("A árvore está vazia");
    }
    return obterMaior(raiz);
  }

  private V obterMaior(No<K, V> raizArvore) {
    if (raizArvore.getDireita() != null) {
      return obterMaior(raizArvore.getDireita());
    } else {
      return raizArvore.getItem();
    }
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
  public ABB<K, V> clone() {
    ABB<K, V> copia = new ABB<>(this.comparador);
    if (this.raiz != null) {
      copia.raiz = this.raiz.clone();
    }
    return copia;
  }

  /*
   * Implemente a função public ABB<K, V> obterSubconjuntoMaiores(K
   * chave), capaz de criar e retornar um subconjunto da árvore binária de busca
   * formado apenas pelos elementos da ABB original cujas chaves são maiores ou
   * iguais àquela passada como parâmetro para esse método.
   * Se não for encontrado, na árvore binária de busca, nenhum elemento cuja chave
   * corresponde àquela passada como parâmetro para esse método, uma exceção deve
   * ser lançada.
   * Sugestão: empregue os métodos clone, do nó e da árvore binária de busca,
   * implementados anteriormente
   */

  public ABB<K, V> obterSubconjuntoMaiores(K chave) {
    if (!contemChave(chave, raiz)) {
      throw new NoSuchElementException("Chave não encontrada na árvore: " + chave);
    }
    ABB<K, V> abb = new ABB<>(comparador);
    abb.raiz = obterSubconjuntoMaiores(chave, raiz);
    return abb;
  }

  private No<K, V> obterSubconjuntoMaiores(K chave, No<K, V> raizArvore) {
    if (raizArvore == null) {
      return null;
    } else {
      int comparacao = comparador.compare(chave, raizArvore.getChave());
      if (comparacao <= 0) {
        No<K, V> novoNo = new No<>(raizArvore.getChave(), raizArvore.getItem());
        if (raizArvore.getDireita() != null) {
          novoNo.setDireita(raizArvore.getDireita().clone());
        }
        novoNo.setEsquerda(obterSubconjuntoMaiores(chave, raizArvore.getEsquerda()));
        return novoNo;
      } else {
        return obterSubconjuntoMaiores(chave, raizArvore.getDireita());
      }
    }
  }

  private boolean contemChave(K chave, No<K, V> noAtual) {
    if (noAtual == null)
      return false;

    int comp = comparador.compare(chave, noAtual.getChave());
    if (comp == 0)
      return true;
    if (comp < 0)
      return contemChave(chave, noAtual.getEsquerda());
    else
      return contemChave(chave, noAtual.getDireita());
  }

  /*
   * QUESTÃO EXTRA: Implemente a função public ABB<K, V> obterSubconjuntoMenores(K
   * chave), capaz de criar e retornar um subconjunto da árvore binária de busca
   * formado apenas pelos elementos da ABB original cujas chaves são menores ou
   * iguais àquela passada como parâmetro para esse método.
   * Se não for encontrado, na árvore binária de busca, nenhum elemento cuja chave
   * corresponde àquela passada como parâmetro para esse método, uma exceção deve
   * ser lançada.
   * Sugestão: empregue os métodos clone, do nó e da árvore binária de busca,
   * implementados anteriormente
   */

  public ABB<K, V> obterSubconjuntoMenores(K chave) {
    if (!contemChave(chave, raiz)) {
      throw new NoSuchElementException("Chave não encontrada na árvore: " + chave);
    }
    ABB<K, V> abb = new ABB<>(comparador);
    abb.raiz = obterSubconjuntoMenores(chave, raiz);
    return abb;
  }

  private No<K, V> obterSubconjuntoMenores(K chave, No<K, V> raizArvore) {
    if (raizArvore == null) {
      return null;
    } else {
      int comparacao = comparador.compare(chave, raizArvore.getChave());
      if (comparacao >= 0) {
        No<K, V> novoNo = new No<>(raizArvore.getChave(), raizArvore.getItem());
        novoNo.setEsquerda(obterSubconjuntoMenores(chave, raizArvore.getEsquerda()));
        novoNo.setDireita(obterSubconjuntoMenores(chave, raizArvore.getDireita()));
        return novoNo;
      } else {
        return obterSubconjuntoMenores(chave, raizArvore.getEsquerda());
      }
    }
  }

  /*
   * Implemente a função public boolean ehRaiz(K chave), capaz verificar e
   * retornar se o item, cuja chave foi informada como parâmetro para esse método,
   * corresponde à raiz da árvore binária de busca.
   * Se a árvore binária de busca estiver vazia, uma exceção deve ser lançada.
   */
  public boolean ehRaiz(K chave) {
    if (vazia()) {
      throw new IllegalStateException("A árvore está vazia");
    }
    return chave.equals(this.raiz.getChave());
  }

  /*
   * Implemente o método public V obterAntecessor(K chave), capaz de
   * recuperar e retornar o maior elemento armazenado na árvore binária de busca
   * que seja
   * menor do que a chave informada como parâmetro para esse método. Se não for
   * encontrado, na árvore binária de busca, nenhum elemento cuja chave
   * corresponde àquela
   * passada como parâmetro para esse método; ou o item, cuja chave corresponde à
   * informada
   * como parâmetro, não apresentar antecessor na árvore binária de busca, uma
   * exceção deve
   * ser lançada.
   */
  public V obterAntecessor(K chave) {
    if (!contemChave(chave, raiz)) {
      throw new NoSuchElementException("Chave não encontrada na árvore: " + chave);
    }
    No<K, V> no = obterAntecessor(chave, raiz, null);
    if (no == null) {
      throw new NoSuchElementException("Não há antecessor para a chave: " + chave);
    }
    return no.getItem();
  }

  private No<K, V> obterAntecessor(K chave, No<K, V> raizArvore, No<K, V> antecessorProximo) {
    if (raizArvore == null) {
      return null;
    } else {
      int comparacao = comparador.compare(chave, raizArvore.getChave());
      if (comparacao == 0) {
        if (raizArvore.getEsquerda() != null) {
          return encontrarAntecessor(raizArvore.getEsquerda());
        } else {
          return antecessorProximo;
        }
      } else if (comparacao > 0) {
        return obterAntecessor(chave, raizArvore.getDireita(), raizArvore);
      } else {
        return obterAntecessor(chave, raizArvore.getEsquerda(), antecessorProximo);
      }
    }
  }

  private No<K, V> encontrarAntecessor(No<K, V> raizArvore) {
    if (raizArvore.getDireita() != null) {
      return encontrarAntecessor(raizArvore.getDireita());
    } else {
      return raizArvore;
    }
  }

  /*
   * QUESTÃO EXTRA: Implemente o método public V obterSucessor(K chave), capaz de
   * recuperar e retornar o maior elemento armazenado na árvore binária de busca
   * que seja
   * maior do que a chave informada como parâmetro para esse método. Se não for
   * encontrado, na árvore binária de busca, nenhum elemento cuja chave
   * corresponde àquela
   * passada como parâmetro para esse método; ou o item, cuja chave corresponde à
   * informada
   * como parâmetro, não apresentar antecessor na árvore binária de busca, uma
   * exceção deve
   * ser lançada.
   */

  public V obterSucessor(K chave) {
    if (!contemChave(chave, raiz)) {
      throw new NoSuchElementException("Chave não encontrada na árvore: " + chave);
    }
    No<K, V> no = obterSucessor(chave, raiz, null);
    if (no == null) {
      throw new NoSuchElementException("Não há antecessor para a chave: " + chave);
    }
    return no.getItem();
  }

  private No<K, V> obterSucessor(K chave, No<K, V> raizArvore, No<K, V> sucessorProximo) {
    if (raizArvore == null) {
      return null;
    } else {
      int comparacao = comparador.compare(chave, raizArvore.getChave());
      if (comparacao == 0) {
        if (raizArvore.getDireita() != null) {
          return encontrarSucessor(raizArvore.getDireita());
        } else {
          return sucessorProximo;
        }
      } else if (comparacao > 0) {
        return obterSucessor(chave, raizArvore.getDireita(), sucessorProximo);
      } else {
        return obterSucessor(chave, raizArvore.getEsquerda(), raizArvore);
      }
    }
  }

  private No<K, V> encontrarSucessor(No<K, V> raizArvore) {
    if (raizArvore.getEsquerda() != null) {
      return encontrarSucessor(raizArvore.getEsquerda());
    } else {
      return raizArvore;
    }
  }

  /*
   * Implemente o método public Double calcularValorMedio(Function<V,
   * Double> extrator), responsável por calcular e retornar a média de valores
   * numéricos do tipo Double extraídos dos elementos armazenados na árvore
   * binária de
   * busca. Para isso, utilize a função extrator fornecida como parâmetro, que
   * deverá ser
   * aplicada a cada elemento da árvore binária de busca para obter os valores do
   * tipo Double
   * sobre os quais a média será calculada.
   */
  public Double calcularValorMedio(Function<V, Double> extrator) {
    if (vazia()) {
      return 0.0;
    }
    return calcularValorMedio(extrator, raiz) / tamanho;
  }

  private Double calcularValorMedio(Function<V, Double> extrator, No<K, V> raizArvore) {
    if (raizArvore == null) {
      return 0.0;
    } else {
      Double soma = 0.0;
      soma += calcularValorMedio(extrator, raizArvore.getEsquerda());
      soma += extrator.apply(raizArvore.getItem());
      soma += calcularValorMedio(extrator, raizArvore.getDireita());
      return soma;
    }
  }

  /*
   * Implemente o método public int contarSe(Predicate<V> condicional),
   * capaz de verificar, contar e retornar quantos elementos armazenados na árvore
   * binária de
   * busca satisfazem uma determinada condição indicada pelo predicado
   * condicional,
   * passado como parâmetro para esse método.
   */
  public int contarSe(Predicate<V> condicional) {
    return contarSe(condicional, raiz);
  }

  private int contarSe(Predicate<V> condicional, No<K, V> raizArvore) {
    if (raizArvore == null) {
      return 0;
    } else {
      int cont = 0;
      cont += contarSe(condicional, raizArvore.getEsquerda());
      if (condicional.test(raizArvore.getItem())) {
        cont++;
      }
      cont += contarSe(condicional, raizArvore.getDireita());
      return cont;
    }
  }

  public static void main(String[] args) {
    ABB<Integer, Integer> abb = new ABB<>((a, b) -> a.compareTo(b));
    abb.inserir(16, 16); // raiz
    abb.inserir(8, 8); // filho esquerdo da raiz
    abb.inserir(23, 23); // filho direito da raiz
    abb.inserir(4, 4); // filho esquerdo de 8
    abb.inserir(11, 11); // filho direito de 8
    abb.inserir(19, 19); // filho esquerdo de 23
    abb.inserir(27, 27); // filho direito de 23
    abb.inserir(5, 5); // filho direito de 4

    System.out.println("== CAMINHAMENTOS NA ÁRVORE ORIGINAL ==");

    System.out.println("\nPré-Ordem (raiz, esquerda, direita):");
    System.out.println(abb.caminhamentoPreOrdem());

    System.out.println("\nEm Ordem (esquerda, raiz, direita):");
    System.out.println(abb.caminhamentoEmOrdem());

    System.out.println("\nPós-Ordem (esquerda, direita, raiz):");
    System.out.println(abb.caminhamentoPosOrdem());

    System.out.println("\nOrdem Decrescente (direita, raiz, esquerda):");
    System.out.println(abb.caminhamentoDecrescente());

    System.out.println("\nOrdem em Nível (percurso por largura):");
    System.out.println(abb.caminhamentoEmNivel());

    System.out.println("\n== VALORES EXTREMOS NA ÁRVORE ORIGINAL ==");
    System.out.println("Menor valor na árvore: " + abb.obterMenor());
    System.out.println("Maior valor na árvore: " + abb.obterMaior());

    ABB<Integer, Integer> clone = abb.clone();

    System.out.println("\n== CAMINHAMENTOS NA ÁRVORE CLONADA ==");

    System.out.println("\nPré-Ordem (raiz, esquerda, direita):");
    System.out.println(clone.caminhamentoPreOrdem());

    System.out.println("\nEm Ordem (esquerda, raiz, direita):");
    System.out.println(clone.caminhamentoEmOrdem());

    System.out.println("\n== COMPARAÇÃO ENTRE OBJETOS ==");
    System.out.println("Raiz original == Raiz clone? " + (abb.raiz == clone.raiz));

    System.out.println("\n== SUBCONJUNTO DE CHAVES MAIORES OU IGUAIS A 11 ==");
    ABB<Integer, Integer> maiores = abb.obterSubconjuntoMaiores(11);
    System.out.println("Caminhamento em ordem do subconjunto:");
    System.out.println(maiores.caminhamentoEmOrdem());

    System.out.println("\n== SUBCONJUNTO DE CHAVES MENORES OU IGUAIS A 11 ==");
    ABB<Integer, Integer> menores = abb.obterSubconjuntoMenores(11);
    System.out.println("Caminhamento em ordem do subconjunto:");
    System.out.println(menores.caminhamentoEmOrdem());

    System.out.println("\n== TESTE DO MÉTODO ehRaiz ==");
    System.out.println("Chave 16 é raiz? " + abb.ehRaiz(16));
    System.out.println("Chave 11 é raiz? " + abb.ehRaiz(11));

    System.out.println("\n== ANTECESSOR ==");
    System.out.println("Antecessor de 11: " + abb.obterAntecessor(11));
    System.out.println("Antecessor de 16: " + abb.obterAntecessor(16));
    System.out.println("\n== SUCESSOR ==");
    System.out.println("Sucessor de 11: " + abb.obterSucessor(11));
    System.out.println("Sucessor de 16: " + abb.obterSucessor(16));

    System.out.println("\n== VALOR MÉDIO DOS ELEMENTOS DA ÁRVORE");
    System.out.println("Valor médio: " + abb.calcularValorMedio(v -> v.doubleValue()));

    System.out.println("\n== NÚMEROS DE ELEMENTOS CUMPRIR A CONDIÇÃO");
    System.out.println("Números de elementos pares na árvore: " + abb.contarSe(v -> v % 2 == 0));
  }

}