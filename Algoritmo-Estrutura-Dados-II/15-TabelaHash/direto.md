# 🔁 TABELA HASH COM ENDEREÇAMENTO DIRETO (EM ABERTO)

---

## 📚 O que é?

* Estrutura que armazena dados diretamente em **posições de um vetor**.
* Usa uma **função hash + rehash** para calcular posições.
* Trata colisões sem listas encadeadas, usando o **próprio vetor com sondagem**.

---

## 🔩 Principais Conceitos:

| Conceito                        | Explicação                                                                             |
| ------------------------------- | -------------------------------------------------------------------------------------- |
| **Função Hash**                 | Mapeia chave para índice do vetor.                                                     |
| **Rehashing (sondagem)**        | Estratégia para encontrar nova posição após colisão.                                   |
| **Espaço de reserva**           | O vetor da tabela é um tipo de “matriz 1D” com posições reservadas.                    |
| **Marcação lógica de exclusão** | Um campo `boolean` marca posições como *“removidas”* para manter a sequência de busca. |

---

## 📦 Estrutura da Tabela

```java
private Entrada<K, V>[] tabelaHash;
private int capacidade;
```

### 🎯 Tabela é um vetor fixo:

* Cada posição pode conter uma única `Entrada<K,V>`.
* Pode conter: um item, `null`, ou um item *removido* (com flag `true`).

---

## 🧠 Espaço de Reserva (Matriz)

Embora a estrutura seja um vetor (`Entrada[]`), você pode pensar como uma **matriz unidimensional de tamanho fixo**:

```
+--------+--------+--------+--------+--------+
| Index0 | Index1 | Index2 | Index3 | Index4 |
+--------+--------+--------+--------+--------+
|  null  |  João  | remov. | Maria  |  null  |
```

* Esse espaço é **pré-alocado no construtor** com tamanho `capacidade`.
* **Reutilizado** durante sondagens.

---

## 🔄 Função de Transformação com Rehashing

```java
private int funcaoHash(K chave, int tentativas) {
  return (Math.abs(chave.hashCode() + tentativas)) % capacidade;
}
```

* O `tentativas` define a estratégia de sondagem linear.
* Colisões são tratadas por reavaliação sucessiva da posição.

---

## 🗃️ Inserção com Rehash

```java
public int inserir(K chave, V item) {
  int tentativas = 0;
  int posicao = funcaoHash(chave, tentativas);

  while (tentativas < capacidade) {
    if (tabelaHash[posicao] == null || tabelaHash[posicao].isRemovida()) {
      tabelaHash[posicao] = new Entrada<>(chave, item);
      return posicao;
    } else if (tabelaHash[posicao].getChave().equals(chave)) {
      throw new IllegalArgumentException("Já existe!");
    }
    tentativas++;
    posicao = funcaoHash(chave, tentativas);
  }
  throw new IllegalStateException("Tabela cheia");
}
```

✔️ Importante:

* A **posição removida** é válida para inserção.
* Se a **chave já existir**, exceção é lançada.

---

## 🔍 Pesquisa com Rehash + Flag

```java
public V pesquisar(K chave) {
  int tentativas = 0;
  int posicao = funcaoHash(chave, tentativas);

  while (tentativas < capacidade) {
    if (tabelaHash[posicao] == null) throw new NoSuchElementException();
    else if (tabelaHash[posicao].getChave().equals(chave) && !tabelaHash[posicao].isRemovida()) {
      return tabelaHash[posicao].getValor();
    }
    tentativas++;
    posicao = funcaoHash(chave, tentativas);
  }

  throw new NoSuchElementException();
}
```

* Busca considera que **itens removidos ainda ocupam espaço** (são ignorados, mas mantêm o fluxo da sondagem).
* Isso evita que a busca pare prematuramente.

---

## ❌ Remoção com Marcação (Flag Booleano)

```java
public V remover(K chave) {
  int tentativas = 0;
  int posicao = funcaoHash(chave, tentativas);

  while (tentativas < capacidade) {
    if (tabelaHash[posicao] == null) throw new NoSuchElementException();
    else if (tabelaHash[posicao].getChave().equals(chave) && !tabelaHash[posicao].isRemovida()) {
      tabelaHash[posicao].setRemovida(true);
      return tabelaHash[posicao].getValor();
    }
    tentativas++;
    posicao = funcaoHash(chave, tentativas);
  }

  throw new NoSuchElementException();
}
```

---

## 🔐 O boolean `isRemovida`

Classe `Entrada` usa uma flag lógica:

```java
private boolean removida;

public boolean isRemovida() {
  return removida;
}

public void setRemovida(boolean removida) {
  this.removida = removida;
}
```

📌 **Motivo de usar o boolean**:

* Em vez de apagar o item da tabela, **marca como “removido”**.
* Evita interromper pesquisas e **mantém integridade do rehashing**.

---

## 📈 Complexidade (com rehashing)

| Operação | Melhor Caso | Pior Caso |
| -------- | ----------- | --------- |
| Inserção | O(1)        | O(n)      |
| Pesquisa | O(1)        | O(n)      |
| Remoção  | O(1)        | O(n)      |

> Performance depende do **fator de carga** e da **qualidade da função hash**.

---

## ⚠️ Rehash e Fator de Carga

* Quando o número de elementos ultrapassa certo limite (ex: 70% da capacidade), é necessário **refazer a tabela maior** e reinserir os dados.
* Isso é chamado de **Rehashing Global** (não confundir com `tentativas`).
* **Rehash global** = criar novo vetor maior + reinserir cada elemento com nova função hash.

---

## ✅ Conclusão

A tabela hash com endereçamento direto é:

* **Eficiente** para acessos rápidos.
* **Delicada com colisões**: exige cuidado na função hash.
* **Elegante com marcação lógica**: evita quebrar o rehash.
* Usa o **espaço de forma compacta**, sem listas encadeadas.
* Ideal para **estruturas fixas e pequenas**.

---

