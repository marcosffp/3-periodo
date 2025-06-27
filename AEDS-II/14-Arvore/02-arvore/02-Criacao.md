# 🌳 RESUMO — ABB (Árvore Binária de Busca): Criação, Vantagens e Funcionamento

## ✅ O que é uma ABB?

### 📌 Definição:

A **Árvore Binária de Busca (ABB)** é uma estrutura onde:

* Cada **nó** tem até **dois filhos**;
* A **chave do filho esquerdo é menor** que a do pai;
* A **chave do filho direito é maior** que a do pai.

---

## 🛠️ Como é Criada uma ABB?

### 🔧 Classe `No<K, V>`

```java
public class No<K, V> {
    private K chave;
    private V item;
    private No<K, V> esquerda, direita;
    private int altura;

    public No(K chave, V item) {
        this.chave = chave;
        this.item = item;
        this.esquerda = null;
        this.direita = null;
        this.altura = 0;
    }

    // Getters e setters omitidos para clareza
}
```

> 🔎 **Cada nó** da árvore contém:
>
> * A **chave** usada para ordenação
> * O **item** (valor armazenado)
> * Referências para os **filhos esquerdo e direito**
> * A **altura** (usada para balanceamento, se necessário)

---

### 🧱 Classe `ABB<K, V>`

```java
public class ABB<K, V> implements IMapeamento<K, V> {
    private No<K, V> raiz;
    private Comparator<K> comparador;
    private int tamanho;

    public ABB() {
        init(null);
    }

    public ABB(Comparator<K> comparador) {
        init(comparador);
    }

    private void init(Comparator<K> comparador) {
        raiz = null;
        tamanho = 0;
        if (comparador == null)
            comparador = (Comparator<K>) Comparator.naturalOrder();
        this.comparador = comparador;
    }

    public boolean vazia() {
        return raiz == null;
    }
}
```

> ✅ A classe ABB:
>
> * Mantém a **raiz da árvore**
> * Usa um **comparador** para ordenar os elementos
> * Armazena o **tamanho da árvore**
> * Permite inicializar a árvore **vazia** com `raiz = null`

---

## 🧠 Estrutura Recursiva

> Uma árvore ABB é composta por:
>
> * Sua **raiz**
> * Suas **subárvores esquerda e direita**
> * Cada subárvore **também é uma ABB**

---

## ✅ Vantagens da ABB

* Permite **organização ordenada** de dados;
* Estrutura **dinâmica** que cresce conforme os elementos são inseridos;
* Permite **caminhamentos ordenados** (in-ordem);
* Otimiza operações como **inserção e remoção** (em árvores balanceadas).

---

## ❌ Desvantagens

* Pode se tornar **desequilibrada** (forma de lista);
* Consome **mais memória** que arrays (devido aos ponteiros);
* Pode ter **baixa eficiência** se usada incorretamente (dados sempre em ordem).

---

## 🧠 Quando Usar ABB?

| Situação                            | Usar ABB?            |
| ----------------------------------- | -------------------- |
| Precisa manter dados **ordenados**  | ✅ Sim                |
| Inserções e remoções frequentes     | ✅ Sim                |
| Estrutura pequena e estática        | ❌ Melhor usar array  |
| Dados chegam **em ordem crescente** | ⚠️ Pode desbalancear |

---

