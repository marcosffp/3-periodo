# 📚 LISTA LINEAR COM VETOR — RESUMO AVANÇADO

## O que é uma Lista Linear?

* Estrutura **sequencial**: armazena elementos de forma ordenada em um vetor.
* Cada elemento ocupa uma **posição indexada** no vetor (0, 1, 2, ..., n-1).
* Modelo **não circular** e **não encadeado**.
* Suporta inserções e remoções em **qualquer posição válida**.

---

## Aplicações Clássicas

* **Cadastro de alunos** (em ordem de chegada ou alfabética).
* **Listagens temporárias** de dados em memória.
* **Índice de palavras** em documentos.
* **Simulações** que exigem reordenação (como filas com prioridade).
* **Buffer linear** para leitura sequencial.

---

## Implementação de Lista Linear com Vetor

### Estrutura

* Usa-se um **vetor fixo** de elementos genéricos `E[] lista`.
* Dois campos principais controlam a estrutura:

  * `primeiro`: fixo em `0`, marca o início da lista.
  * `ultimo`: marca o fim lógico da lista (a próxima posição livre).

---

### Regras Gerais

* **Inicialização**:

  * `primeiro = 0`, `ultimo = 0`.
* **Verificar se está vazia (`vazia`)**:

  * Se `primeiro == ultimo`.
* **Verificar se está cheia (`cheia`)**:

  * Se `ultimo == lista.length`.
* **Inserir (`inserir`)**:

  * Valida posição (`0 ≤ posicao ≤ ultimo`) e se há espaço.
  * Desloca elementos à direita, da `posicao` até `ultimo - 1`.
  * Insere o novo elemento na `posicao`.
  * Incrementa `ultimo`.
* **Remover (`remover`)**:

  * Valida posição (`0 ≤ posicao < ultimo`) e se a lista não está vazia.
  * Armazena o item a ser removido.
  * Desloca os elementos seguintes à esquerda, da `posicao + 1` até `ultimo - 1`.
  * Decrementa `ultimo`.

---

## Código de Apoio

```java
public class Lista<E> {
    private final E[] lista;
    private final int primeiro;
    private int ultimo;

    @SuppressWarnings("unchecked")
    public Lista(int tamanho) {
        lista = (E[]) new Object[tamanho];
        primeiro = ultimo = 0;
    }

    public boolean vazia() {
        return (primeiro == ultimo);
    }

    public boolean cheia() {
        return (ultimo == lista.length);
    }

    public void inserir(E novo, int posicao) {
        if (cheia())
            throw new IllegalStateException("Lista cheia!");

        if (posicao < 0 || posicao > ultimo)
            throw new IndexOutOfBoundsException("Posição inválida!");

        for (int i = ultimo; i > posicao; i--) {
            lista[i] = lista[i - 1];
        }

        lista[posicao] = novo;
        ultimo++;
    }

    public E remover(int posicao) {
        if (vazia())
            throw new IllegalStateException("Lista vazia!");

        if (posicao < 0 || posicao >= ultimo)
            throw new IndexOutOfBoundsException("Posição inválida!");

        E removido = lista[posicao];

        for (int i = posicao; i < ultimo - 1; i++) {
            lista[i] = lista[i + 1];
        }

        ultimo--;
        return removido;
    }
}
```

---

## 📊 Representação Visual

🔷 Vetor de 5 posições (lista linear com 3 elementos):

| Índice | Conteúdo |
| :----: | :------: |
|    0   |     A    |
|    1   |     B    |
|    2   |     C    |
|    3   |   vazio  |
|    4   |   vazio  |

* `primeiro = 0`, `ultimo = 3` (3 itens na lista).
* Inserção **no final**: índice `ultimo`.
* Inserção **no meio**: desloca itens para a direita.
* Remoção: desloca itens subsequentes para a esquerda.

---

# 🚀 Big-O das Operações (Complexidade)

### O que é essa anotação?

* **O(1)** → tempo constante, não depende da quantidade de dados.
* **O(n)** → tempo linear, cresce proporcional ao número de elementos.

### E na lista linear com vetor?

| Operação                | Complexidade | Por quê?                               |
| ----------------------- | ------------ | -------------------------------------- |
| Inserir no final        | O(1)         | Basta inserir no índice `ultimo`.      |
| Inserir no meio/início  | O(n)         | Necessário deslocar itens.             |
| Remover do final        | O(1)         | Só decrementa `ultimo`.                |
| Remover do meio/início  | O(n)         | Desloca todos os elementos à esquerda. |
| Consultar por índice    | O(1)         | Acesso direto ao vetor.                |
| Verificar se está vazia | O(1)         | Comparação entre índices.              |

✅ Inserção e remoção no **final** são eficientes.
⚠️ Inserções/remoções em posições internas são custosas.

---

# 📌 Vantagens e Desvantagens

| Vantagens                              | Desvantagens                                      |
| :------------------------------------- | :------------------------------------------------ |
| Acesso rápido a qualquer índice (O(1)) | Custo alto para inserções/remoções no meio (O(n)) |
| Estrutura simples e direta             | Tamanho fixo: exige alocação prévia               |
| Não precisa de ponteiros               | Requer deslocamento manual dos itens              |

---

# 🧠 Curiosidades Importantes

* A lista linear com vetor é **semelhante à fila**, mas:

  * Permite inserções/remoções **em qualquer posição**.
  * Não utiliza aritmética modular.
* Usada internamente em várias estruturas como **pilhas**, **filas** e **arrays dinâmicos** (em linguagens como Python ou JavaScript).
* **Versões dinâmicas** (como `ArrayList`) resolvem a limitação de tamanho, com realocação automática.

---

# 🔥 Resumo Final em uma frase:

> **"Lista linear com vetor é uma estrutura sequencial eficiente para acesso direto, mas exige deslocamento de elementos em inserções e remoções fora do final."**

---


