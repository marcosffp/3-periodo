# ➕ RESUMO — Inserção em Árvores Binárias de Busca (ABB)

## ✅ O que é Inserção em ABB?

### 📌 Definição:

Inserir um item em uma **Árvore Binária de Busca (ABB)** significa colocá-lo **na posição correta**, obedecendo à propriedade de ordenação da ABB:

* Chaves **menores** → subárvore **esquerda**
* Chaves **maiores** → subárvore **direita**
* Chave **igual** → **não pode** inserir (duplicata)

---

## 🛠️ Estrutura do Método de Inserção

### ✅ Método público:

```java
@Override
public int inserir(K chave, V item) {
    this.raiz = inserir(this.raiz, chave, item);
    tamanho++;
    return tamanho;
}
```

### ✅ Método recursivo:

```java
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
```

---

## 🧪 Exemplo Visual — Inserindo 11

```text
       16
     /    \
    8      23
   / \    /  \
  4   11 19  27
```

> 🔍 Caminho da inserção de `11`:
>
> * 11 < 16 → esquerda
> * 11 > 8 → direita
> * Direita de 8 é null → **inserir aqui**

---

## 🔄 Etapas da Inserção

1. **Começa pela raiz** da árvore.
2. Compara a chave a ser inserida:

   * Menor → tenta inserir na **subárvore esquerda**.
   * Maior → tenta inserir na **subárvore direita**.
   * Igual → **erro** (duplicata não permitida).
3. Quando atingir uma **referência nula**, insere o novo nó ali.
4. A chamada recursiva **retorna a subárvore modificada** até alcançar a raiz.

---

## 📊 Complexidade da Inserção

| Situação    | Complexidade |
| ----------- | ------------ |
| Melhor caso | O(1)         |
| Caso médio  | O(log n)     |
| Pior caso   | O(n)         |

> ⚠️ O pior caso acontece quando os dados são inseridos em **ordem crescente ou decrescente**, tornando a árvore **linear (tipo lista)**.

---

## ✅ Vantagens da Inserção em ABB

* Fácil de implementar com **recursividade**.
* Mantém a estrutura **ordenada** da árvore.
* Inserções são rápidas em **árvores balanceadas**.

---

## ❌ Desvantagens

* Pode causar **desequilíbrio**, prejudicando desempenho.
* Não permite **chaves duplicadas**.
* Pode virar **lista encadeada** sem balanceamento.

---

## 🧠 Dica de Uso

| Situação                               | Inserção ABB é indicada? |
| -------------------------------------- | ------------------------ |
| Inserções frequentes e ordenadas       | ⚠️ Só se for balanceada  |
| Precisa evitar duplicidade de chaves   | ✅ Sim                    |
| Lista de registros dinâmica e ordenada | ✅ Sim                    |

---

