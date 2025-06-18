# 🧮 TABELA HASH COM ENDEREÇAMENTO INDIRETO

## 📚 O que é uma Tabela Hash?

* Estrutura de dados eficiente para **armazenar pares chave-valor**.
* Utiliza uma **função de transformação (hash)** para mapear uma chave a um **índice de vetor**.
* Acesso, inserção e remoção são operações **rápidas**, com **tempo médio O(1)**.
* Conhecida também como:

  * **Tabela de Dispersão**
  * **Tabela de Espalhamento**

---

## 🔀 Hash Indireta com Lista Encadeada

* Também chamada de **endereçamento em separado**.
* Cada posição da tabela hash armazena **uma lista encadeada de entradas** (pares chave-valor).
* Resolve **colisões** ligando múltiplos elementos que caem no mesmo índice da tabela.

### 📦 Como funciona:

1. A **função hash** mapeia a chave a uma posição do vetor.
2. Caso essa posição já esteja ocupada, o novo elemento é **inserido no final da lista**.
3. A pesquisa e a remoção percorrem a lista encadeada daquela posição até encontrar a chave.

---

## ⚙️ Como a Tabela é Estruturada (Código)

```java
private Lista<Entrada<K, V>>[] tabelaHash;
```

* Vetor de listas encadeadas.
* Cada posição é uma **"caixinha" com uma lista** de elementos que caíram ali por colisão.

```java
public TabelaHash(int capacidade) {
  if (capacidade < 1)
    throw new NoSuchElementException("Capacidade inválida.");
  this.capacidade = capacidade;
  tabelaHash = (Lista<Entrada<K, V>>[]) new Lista[capacidade];
  for (int i = 0; i < capacidade; i++)
    tabelaHash[i] = new Lista<>();
}
```

* Inicializa o vetor com listas vazias.
* A capacidade da tabela deve ser um **número primo** (para melhor distribuição das chaves).

---

## 🧠 A Função de Transformação (Hash)

```java
private int funcaoHash(K chave) {
  return Math.abs(chave.hashCode() % capacidade);
}
```

### 🎯 Objetivos de uma boa função hash:

* **Uniformizar a distribuição** dos dados.
* **Evitar colisões**.
* Ser **simples e rápida** de calcular.
* Garantir que todas as posições tenham **chance similar de serem usadas**.

---

## ➕ Inserção

```java
public int inserir(K chave, V item) {
  int posicao = funcaoHash(chave);
  Entrada<K, V> entrada = new Entrada<>(chave, item);
  try {
    tabelaHash[posicao].pesquisar(entrada);  // Já existe?
    throw new IllegalArgumentException("Item já inserido!");
  } catch (NoSuchElementException e) {
    tabelaHash[posicao].inserirFinal(entrada);
    return posicao;
  }
}
```

📌 **Resumo da inserção**:

* A função hash define a posição.
* Se já houver entrada com a mesma chave → erro.
* Se não houver → adiciona no fim da lista.

---

## 🔍 Pesquisa

```java
public V pesquisar(K chave) {
  int posicao = funcaoHash(chave);
  Entrada<K, V> procurado = new Entrada<>(chave, null);
  procurado = tabelaHash[posicao].pesquisar(procurado);
  return procurado.getValor();
}
```

✔️ **Passos**:

1. Calcula a posição com a função hash.
2. Busca pela chave na lista daquela posição.
3. Retorna o valor correspondente.

---

## ❌ Remoção

```java
public V remover(K chave) {
  int posicao = funcaoHash(chave);
  Entrada<K, V> procurado = new Entrada<>(chave, null);
  procurado = tabelaHash[posicao].remover(procurado);
  return procurado.getValor();
}
```

💥 Remove a entrada da lista encadeada da posição indicada pela função hash.

---

## 📄 Classe `Entrada<K, V>`

```java
public class Entrada<K, V> {
  private final K chave;
  private V valor;

  public Entrada(K chave, V item) {
    this.chave = chave;
    this.valor = item;
  }

  public K getChave() { return chave; }
  public V getValor() { return valor; }
  public void setValor(V valor) { this.valor = valor; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || o.getClass() != this.getClass()) return false;
    Entrada<?, ?> outra = (Entrada<?, ?>) o;
    return outra.getChave().equals(this.chave);
  }

  @Override
  public int hashCode() {
    return Objects.hash(chave);
  }

  @Override
  public String toString() {
    return chave + " --> " + valor;
  }
}
```

🔑 **Por que `equals` compara só a chave?**

* Para facilitar busca e remoção por chave, **sem depender do valor**.

---

## 🧮 Exemplo Visual (Distribuição com Hash Indireta)

Imagine uma tabela com `M = 5`:

```
h("João") = 3
h("Maria") = 3
h("Ana") = 1

Tabela:
[0] → vazia
[1] → Ana
[2] → vazia
[3] → João → Maria
[4] → vazia
```

---

## 📊 Complexidade

| Operação | Melhor Caso | Pior Caso (colisões) |
| -------- | ----------- | -------------------- |
| Inserção | O(1)        | O(n/M)               |
| Pesquisa | O(1)        | O(n/M)               |
| Remoção  | O(1)        | O(n/M)               |

> Onde `M` é o tamanho da tabela e `n` é o número de elementos.

---

## ✅ Vantagens

* **Simples e robusta**.
* **Boa performance média**, mesmo com colisões.
* Permite **tamanho dinâmico** de listas por posição.
* Evita o "clustering" do endereçamento aberto.

---

## ⚠️ Desvantagens

* Pode haver **desequilíbrio** entre listas (listas muito cheias em poucos índices).
* **Gasto de memória extra** com as listas encadeadas.

---

## 🧠 Conclusão

A tabela hash com **endereçamento indireto** (lista encadeada) é uma solução poderosa para armazenar dados de forma rápida e eficiente, mesmo com colisões. O sucesso da sua eficiência depende fortemente de:

* Uma **função hash bem feita**.
* Um **tamanho de tabela apropriado** (de preferência primo).
* Implementação correta das **estruturas auxiliares** (como a classe `Entrada`).


