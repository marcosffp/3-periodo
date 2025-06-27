# 📚 LISTA LINEAR COM LISTA ENCADEADA — RESUMO AVANÇADO

## O que é uma Lista?

* Estrutura **sequencial e ordenada** que armazena elementos.
* Cada elemento ocupa uma **posição lógica** na lista: 0, 1, 2, ..., *n-1*.
* Permite inserções e remoções **em qualquer posição**.
* **Ordem dos dados** é determinada por sua posição na estrutura.

---

## Aplicações Clássicas

* Lista de alunos matriculados em uma turma.
* Gerência de memória em sistemas operacionais.
* Índice de palavras em documentos.
* Cadastro de usuários ou produtos em sistemas.
* Tabelas de símbolos em compiladores.

---

## Implementação com Lista Encadeada (Auto-referenciada)

### Estrutura

* Usa **células encadeadas**, representadas pela classe `Celula<E>`.
* Cada célula possui:

  * Um **item** genérico.
  * Uma **referência para a próxima célula**.
* A lista possui dois ponteiros:

  * **`primeiro`** → aponta para a **célula sentinela** (início).
  * **`ultimo`** → aponta para a **última célula real** da lista.

---

### Regras Gerais

* **Inicialização**:

  * Cria-se uma **célula sentinela** (sem item).
  * `primeiro = ultimo = sentinela`.

* **Inserir**:

  * Localiza a **posição** desejada.
  * Cria nova célula com o item.
  * Ajusta os ponteiros para incluir a nova célula.
  * Se a inserção for no final, atualiza `ultimo`.

* **Remover**:

  * Localiza a **posição** do item a ser removido.
  * Ajusta os ponteiros para **desencadear** a célula.
  * Se a célula removida for a última, atualiza `ultimo`.

* **Verificar se está vazia**:

  * Compara se `primeiro == ultimo`.

---

## Código Base

```java
public class Lista<E> {
    private Celula<E> primeiro;
    private Celula<E> ultimo;
    private int tamanho;

    public Lista() {
        Celula<E> sentinela = new Celula<>();
        this.primeiro = this.ultimo = sentinela;
        this.tamanho = 0;
    }

    public boolean vazia() {
        return (this.primeiro == this.ultimo);
    }

    public void inserir(E novo, int posicao) {
        if ((posicao < 0) || (posicao > this.tamanho))
            throw new IndexOutOfBoundsException("Posição inválida!");

        Celula<E> anterior = this.primeiro;
        for (int i = 0; i < posicao; i++)
            anterior = anterior.getProximo();

        Celula<E> novaCelula = new Celula<>(novo);
        novaCelula.setProximo(anterior.getProximo());
        anterior.setProximo(novaCelula);

        if (posicao == this.tamanho)
            this.ultimo = novaCelula;

        this.tamanho++;
    }

    public E remover(int posicao) {
        if (vazia())
            throw new IllegalStateException("Lista está vazia!");
        if ((posicao < 0) || (posicao >= this.tamanho))
            throw new IndexOutOfBoundsException("Posição inválida!");

        Celula<E> anterior = this.primeiro;
        for (int i = 0; i < posicao; i++)
            anterior = anterior.getProximo();

        Celula<E> removida = anterior.getProximo();
        anterior.setProximo(removida.getProximo());
        removida.setProximo(null);

        if (removida == this.ultimo)
            this.ultimo = anterior;

        this.tamanho--;
        return removida.getItem();
    }
}
```

---

## Representação Visual

🔵 Lista com 3 elementos: inseridos nas posições 0, 1 e 2

```
[Sentinela] -> [A] -> [B] -> [C] -> null
     ↑                         ↑
  primeiro                  ultimo
```

* **Inserção**: pode ocorrer em **qualquer posição**.
* **Remoção**: remove o item de **posição específica**.
* **Sentinela** não armazena item — facilita operações.

---

# 🚀 Big-O das Operações (Encadeada)

| Operação           | Complexidade | Justificativa                                              |
| ------------------ | ------------ | ---------------------------------------------------------- |
| Inserir no início  | O(1)         | Acesso direto ao ponteiro após a sentinela.                |
| Inserir no fim     | O(1)         | Acesso direto ao ponteiro `ultimo`.                        |
| Inserir no meio    | O(n)         | Precisa percorrer até a posição desejada.                  |
| Remover início/fim | O(1)/O(n)    | Fim exige atualização do ponteiro `ultimo`, se necessário. |
| Remover no meio    | O(n)         | Precisa percorrer até a posição anterior.                  |
| Verificar vazia    | O(1)         | Compara `primeiro == ultimo`.                              |

✅ Operações no **início ou fim** são eficientes, mas no **meio exigem percurso**.

---

# 📌 Vantagens e Desvantagens

| Vantagens                                    | Desvantagens                                     |
| -------------------------------------------- | ------------------------------------------------ |
| Crescimento dinâmico (sem tamanho fixo)      | Uso de mais memória (ponteiros adicionais).      |
| Inserções e remoções sem deslocamento físico | Acesso sequencial — sem índice direto.           |
| Boa para inserções/remoções frequentes       | Mais difícil de debugar e manipular que vetores. |

---

# 🧠 Dica Visual de Lista com Sentinela

* A **sentinela** ajuda a **padronizar inserções e remoções**, inclusive em listas vazias.
* Quando vazia: `primeiro == ultimo == sentinela`.

---

# 🔥 Resumo Final em uma frase:

> **"Lista linear encadeada permite crescimento dinâmico, inserções/remoções eficientes nas extremidades e usa sentinela para simplificar operações — ideal quando o tamanho da estrutura é imprevisível."**

---



