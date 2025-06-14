# 🌳 RESUMO — AVL (Árvore Binária de Busca Balanceada): Altura, Nível, Criação e Balanceamento

## ✅ O que é uma Árvore AVL?

### 📌 Definição:

A **AVL (Adelson-Velskii e Landis)** é uma variação da árvore binária de busca (ABB) que mantém o **balanceamento automático** após cada inserção ou remoção, garantindo boa performance.

* Para **cada nó**, a diferença entre a **altura das subárvores esquerda e direita** deve ser **no máximo 1**.
* Essa propriedade permite manter a **altura da árvore próxima de log₂(n)**.

---

## 🧱 Conceitos Fundamentais

### 🪜 Nível de um Nó

* Indica **a distância da raiz até o nó**.
* A **raiz** está no nível **0**, seus filhos diretos no nível 1, e assim por diante.

### 🌲 Altura de um Nó

* É a **distância da folha mais profunda até aquele nó**.
* Uma **folha tem altura 0**.
* A **altura de um nó** é:

  ```
  altura = 1 + máximo entre a altura da subárvore esquerda e da subárvore direita
  ```

### ⚖️ Fator de Balanceamento (FB)

* É uma medida que indica se o nó está equilibrado.
* Calculado como:

  ```
  FB = altura(esquerda) - altura(direita)
  ```
* Valores possíveis:

  * `FB = -1, 0 ou 1`: nó **está balanceado**
  * `FB = -2 ou 2`: nó **está desbalanceado**

> 📌 Apenas os **nós no caminho** da operação (inserção/remoção) são afetados no balanceamento.

---

## 🛠️ Como é Criada uma Árvore AVL?

### 🔧 Reutilização da ABB com `super`

A AVL é criada estendendo a ABB:

```java
public class AVL<K, V> extends ABB<K, V> {
    public AVL() {
        super();
    }

    public AVL(Comparator<K> comparador) {
        super(comparador);
    }
}
```

> ✅ Isso permite **reaproveitar a lógica básica** da ABB (como inserção, remoção e busca), usando o `super`.

---

### 📥 Inserção com Balanceamento

```java
@Override
protected No<K, V> inserir(No<K, V> raizArvore, K chave, V item) {
    return balancear(super.inserir(raizArvore, chave, item));
}
```

* Primeiro, o item é inserido **como em uma ABB comum**, usando `super.inserir`.
* Em seguida, o **resultado é passado ao método `balancear`**, que verifica se houve desbalanceamento e aplica as correções se necessário.
* O balanceamento **garante que a árvore continue eficiente**, mantendo a propriedade AVL.

---

### 🗑️ Remoção com Balanceamento

```java
@Override
protected No<K, V> remover(No<K, V> raizArvore, K chaveRemover) {
    return balancear(super.remover(raizArvore, chaveRemover));
}
```

* Após a remoção, `balancear` é chamado para verificar e corrigir desequilíbrios.
* **Mesma lógica vale** para a remoção do antecessor.

---

## ✅ Benefícios do Balanceamento Automático

* Garante **boa performance mesmo com inserções e remoções frequentes**.
* Mantém a árvore com **altura logarítmica**.
* Evita que a árvore se degrade para uma estrutura de **lista**.

---

## ⚠️ Considerações

* A árvore AVL **não permite que um nó tenha fator de balanceamento maior que 1 ou menor que -1**.
* O custo de manter esse balanceamento é compensado pela **eficiência nas operações de busca**.
* Apesar do ajuste automático, o **processo de balanceamento só afeta os nós no caminho da modificação** — a árvore **não é reestruturada inteira**.

---

