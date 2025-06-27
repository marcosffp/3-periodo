# 🔁 TABELA HASH COM ENDEREÇAMENTO DIRETO (EM ABERTO)

---

## 📚 O que é?

* Estrutura que armazena dados diretamente em **posições de um vetor fixo**.
* Usa uma **função hash combinada com rehashing (sondagem linear)** para calcular e ajustar posições.
* Trata colisões **sem listas encadeadas** — apenas usando o vetor e realocação sequencial.

---

## 🔩 Principais Conceitos:

| Conceito                        | Explicação                                                                                       |
| ------------------------------- | ------------------------------------------------------------------------------------------------ |
| **Função Hash**                 | Mapeia uma chave para um índice dentro do vetor.                                                 |
| **Rehashing (sondagem)**        | Estratégia para recalcular posições em caso de colisão, geralmente com base nas tentativas.      |
| **Área de Reserva**             | Parte do vetor usada para realocar itens em caso de colisão, garantindo espaço adicional.        |
| **Bucket (conceito lógico)**    | Cada posição da tabela pode ser vista como um *"balde lógico"*, mas com **capacidade unitária**. |
| **Marcação lógica de exclusão** | Uma flag `boolean` marca se uma posição foi *removida logicamente*, sem liberar o espaço.        |

---

## 📦 Estrutura da Tabela

```java
private Entrada<K, V>[] tabelaHash;
private int capacidade;
```

### 🎯 Tabela é um vetor fixo:

* Cada posição contém no máximo uma `Entrada<K,V>`.
* Estado de uma posição:

  * `null` (vaga),
  * um item ativo (`Entrada`),
  * um item marcado como *removido* (`removida == true`).

---

## 🧠 Espaço de Reserva

Apesar de ser um vetor simples (`Entrada[]`), sua organização pode ser pensada como uma **matriz unidimensional** com uma **área de reserva** interna:

```
+--------+--------+--------+--------+--------+
| Index0 | Index1 | Index2 | Index3 | Index4 |
+--------+--------+--------+--------+--------+
|  null  |  João  | remov. | Maria  |  null  |
```

* A **área de reserva** representa os espaços livres ou reaproveitáveis do vetor.
* Ela **é utilizada dinamicamente durante as tentativas de rehash**.
* Isso evita colisões com alocação externa e mantém os dados compactos.

---

## 🪣 Bucket (na prática)

* Embora buckets geralmente sejam **listas em implementações com encadeamento**, aqui cada bucket é **apenas uma posição simples** no vetor.
* A função hash define o bucket inicial, e a sondagem determina qual bucket alternativo será usado em caso de colisão.

---

## 🔄 Função de Transformação com Rehashing

```java
private int funcaoHash(K chave, int tentativas) {
  return (Math.abs(chave.hashCode() + tentativas)) % capacidade;
}
```

* A variável `tentativas` controla a posição relativa na **sondagem linear**.
* Cada nova tentativa gera uma nova posição dentro da área de reserva.

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

✔️ Detalhes:

* **Posições marcadas como removidas** podem ser reutilizadas.
* Se a chave já existir, **lança exceção para evitar duplicidade**.

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

* Posições marcadas como **removidas** não encerram a busca.
* A pesquisa continua sondando até encontrar ou esgotar as tentativas.

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

A classe `Entrada` armazena uma flag lógica para remoção:

```java
private boolean removida;

public boolean isRemovida() {
  return removida;
}

public void setRemovida(boolean removida) {
  this.removida = removida;
}
```

📌 Por quê?

* **Evita quebra do rehashing** durante buscas.
* Permite reutilizar o espaço com segurança durante inserções futuras.

---

## 📈 Complexidade (com rehashing)

| Operação | Melhor Caso | Pior Caso |
| -------- | ----------- | --------- |
| Inserção | O(1)        | O(n)      |
| Pesquisa | O(1)        | O(n)      |
| Remoção  | O(1)        | O(n)      |

> Performance altamente dependente do **fator de carga** e da **qualidade da função hash**.

---

## ⚠️ Rehash Global e Fator de Carga

* Ao ultrapassar um limite (ex: **70%** de ocupação), o vetor deve ser **expandido**.
* Esse processo é chamado de **Rehash Global**:

  * Novo vetor maior.
  * Todos os itens são reinseridos com nova função hash.
* Custo alto, mas necessário para manter desempenho.

---

## ✅ Conclusão

A Tabela Hash com endereçamento direto é:

* 💡 **Rápida** para inserção, busca e remoção (em condições ideais).
* 🛠️ **Sutil** no tratamento de colisões com sondagem linear.
* 🚫 **Sem listas ou buckets múltiplos** — um item por posição.
* 🧠 Usa **flag de remoção** para preservar integridade da sondagem.
* 📦 **Organiza dados de forma compacta**, com reaproveitamento da área de reserva.
* 🧪 Ideal para **estruturas pequenas ou controladas**, onde o fator de carga pode ser monitorado.

---

