# 🗑️ RESUMO — **Remoção em Árvores Binárias de Busca (ABB)**

## ✅ O que é Remoção em ABB?

### 📌 Definição:

Remover um item de uma **ABB** significa **eliminar um nó** mantendo a **propriedade de ordenação** da árvore:

* Chaves **menores** → subárvore **esquerda**
* Chaves **maiores** → subárvore **direita**

A complexidade da remoção depende do **grau** do nó a ser removido.

---

## 🧱 Casos de Remoção

| Grau do Nó | Situação                           | Estratégia                                   |
| ---------- | ---------------------------------- | -------------------------------------------- |
| 0          | Nó folha (sem filhos)              | Apenas remove                                |
| 1          | Um filho (esquerdo **ou** direito) | Substitui pelo filho único                   |
| 2          | Dois filhos                        | Substitui por **antecessor** ou **sucessor** |

---

## 🔄 Etapas do Método `remover`

### ✅ Método público

```java
@Override
public V remover(K chave) {
    V removido = pesquisar(chave);
    raiz = remover(raiz, chave);
    tamanho--;
    return removido;
}
```

### ✅ Método recursivo

```java
  protected No<K, V> remover(K chave, No<K, V> raizArvore) {
    if (raizArvore == null) {
      throw new NoSuchElementException("O item a ser removido não foi localizado na árvore!");
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
```

---

# 🔁 Remoção com Antecessor e Sucessor

## ✅ Quando usar?

Ao remover um nó com **dois filhos**, temos duas estratégias:

| Estratégia     | Caminho                            | Quando usar |
| -------------- | ---------------------------------- | ----------- |
| **Antecessor** | Maior nó da **subárvore esquerda** | Mais comum  |
| **Sucessor**   | Menor nó da **subárvore direita**  | Alternativa |

---

## ⏮️ Caminhamento até o Antecessor

### 🔽 Etapas:

```text
       50
      /
    30
      \
      45  ← antecessor
```

1. A partir do nó a ser removido (50), vá para sua **subárvore esquerda** (30)
2. Caminhe **à direita até não haver mais filhos direitos**
3. O último nó visitado é o **antecessor**

### 🔧 Código

```java
protected No<K, V> removerNoAntecessor(No<K, V> alvo, No<K, V> raizArvore) {
    if (raizArvore.getDireita() != null) {
        raizArvore.setDireita(removerNoAntecessor(alvo, raizArvore.getDireita()));
    } else {
        alvo.setChave(raizArvore.getChave());
        alvo.setItem(raizArvore.getItem());
        raizArvore = raizArvore.getEsquerda(); // remove o antecessor
    }
    return raizArvore;
}
```

---

## ⏭️ Caminhamento até o Sucessor

### 🔼 Etapas:

```text
       50
         \
         70
        /
       60  ← sucessor
```

1. A partir do nó a ser removido (50), vá para sua **subárvore direita** (70)
2. Caminhe **à esquerda até não haver mais filhos esquerdos**
3. O último nó visitado é o **sucessor**

### 🔧 Código

```java
protected No<K, V> removerNoSucessor(No<K, V> alvo, No<K, V> raizArvore) {
    if (raizArvore.getEsquerda() != null) {
        raizArvore.setEsquerda(removerNoSucessor(alvo, raizArvore.getEsquerda()));
    } else {
        alvo.setChave(raizArvore.getChave());
        alvo.setItem(raizArvore.getItem());
        raizArvore = raizArvore.getDireita(); // remove o sucessor
    }
    return raizArvore;
}
```

---

## 📊 Exemplo Visual — Removendo 16 com Antecessor

```text
       16
     /    \
    8      23
   / \    /  \
  4  11  19  27
```

1. Localiza 16
2. Subárvore esquerda → 8
3. Vai à direita → 11
4. **Antecessor = 11**
5. Substitui 16 por 11
6. Remove 11 da esquerda

---

## 📊 Exemplo Visual — Removendo 50 com Sucessor

```text
       50
      /  \
    30    70
         /  \
       60    90
```

1. Localiza 50
2. Subárvore direita → 70
3. Vai à esquerda → 60
4. **Sucessor = 60**
5. Substitui 50 por 60
6. Remove 60 da direita

---

## ✅ Dicas

| Situação                             | Estratégia recomendada      |
| ------------------------------------ | --------------------------- |
| Nó folha                             | Retorna `null`              |
| Nó com 1 filho                       | Retorna o filho             |
| Nó com 2 filhos (mais comum em raiz) | Usar antecessor ou sucessor |

---

## ❌ Possíveis Erros

* Chave **não existe** → lançar `NoSuchElementException`
* **Inserções ordenadas** → árvore **desequilibrada**

---

## 📊 Complexidade da Remoção

| Situação    | Complexidade |
| ----------- | ------------ |
| Melhor caso | O(1)         |
| Caso médio  | O(log n)     |
| Pior caso   | O(n)         |

---

