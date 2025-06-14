# 🔍 RESUMO — Pesquisa em Árvores Binárias de Busca (ABB)

## ✅ O que é a Pesquisa em ABB?

### 📌 Definição:

É a operação de **localizar um item** (registro) na árvore com base em sua **chave**, explorando a **ordem hierárquica** da ABB:

* Se a chave procurada for **menor**, busca na **subárvore esquerda**.
* Se for **maior**, busca na **subárvore direita**.
* Se for **igual**, o item foi **encontrado**.

---

## 🧠 Estrutura do Método

### ✅ Assinatura pública:

```java
@Override
public V pesquisar(K chave) {
    return pesquisar(raiz, chave);
}
```

### ✅ Método recursivo:

```java
private V pesquisar(No<K, V> raizArvore, K procurado) {
    if (raizArvore == null)
        throw new NoSuchElementException("O item não foi localizado na árvore!");

    int comparacao = comparador.compare(procurado, raizArvore.getChave());

    if (comparacao == 0)
        return raizArvore.getItem(); // Item encontrado
    else if (comparacao < 0)
        return pesquisar(raizArvore.getEsquerda(), procurado); // Busca à esquerda
    else
        return pesquisar(raizArvore.getDireita(), procurado); // Busca à direita
}
```

---

## ⚙️ Etapas da Pesquisa

1. **Início pela raiz** da árvore.
2. **Comparação** entre a chave procurada e a chave da raiz:

   * Igual → retorna o valor.
   * Menor → pesquisa na subárvore **esquerda**.
   * Maior → pesquisa na subárvore **direita**.
3. **Repetição recursiva** até:

   * A chave ser encontrada; ou
   * Chegar em `null` → item **não encontrado**.

---

## 🧪 Exemplo Visual (Chave: 19)

```text
          16
        /    \
       8      23
     /  \    /  \
    4   11  19  27
         \
         [19]
```

> 🔎 Comparações:
>
> * 19 > 16 → direita
> * 19 < 23 → esquerda
> * 19 == 19 → **item encontrado**

---

## 📊 Complexidade da Pesquisa

| Situação    | Comparações                        | Complexidade |
| ----------- | ---------------------------------- | ------------ |
| Melhor caso | 1 (primeira tentativa)             | O(1)         |
| Caso médio  | log₂(n)                            | O(log n)     |
| Pior caso   | n comparações (árvore linearizada) | O(n)         |

> ⚠️ O **pior caso** ocorre quando os elementos foram inseridos **em ordem crescente ou decrescente**, transformando a árvore em uma **lista encadeada**.

---

