# 📚 PILHA COM LISTA ENCADEADA — RESUMO AVANÇADO

## O que é uma Pilha?

- Estrutura **LIFO** (*Last In, First Out*): o último elemento adicionado é o primeiro a ser removido.
- Só é possível acessar, inserir ou remover **no topo** da pilha.
- **Ordem lógica** dos dados: o mais recente no topo, o mais antigo no fundo.

---

## Aplicações Clássicas
- **Undo/redo** em editores (Word, Photoshop...).
- **Histórico** de navegação.
- **Pilha de chamadas recursivas**.
- **Validação de expressões** (parênteses balanceados).
- **Backtracking** em algoritmos (labirintos, Sudoku).

---

## Implementação de Pilha com Lista Encadeada

### Estrutura
- Usa-se **nós encadeados** (objetos `Celula`) para armazenar os elementos.
- Cada célula guarda:
  - Um **item** (o dado).
  - Uma **referência** para a próxima célula.
- Dois ponteiros:
  - **`topo`** → aponta para o **primeiro elemento** da pilha.
  - **`fundo`** → aponta para a **sentinela** (inicialização).

---

### Regras Gerais
- **Inicialização**:
  - Cria uma **célula sentinela** (vazia).
  - `topo = fundo = sentinela`.
- **Empilhar (`push`)**:
  - Cria nova célula com o item.
  - Liga nova célula ao `topo` atual.
  - Atualiza `topo` para a nova célula.
- **Desempilhar (`pop`)**:
  - Lê o item do `topo`.
  - Atualiza `topo` para o próximo.
- **Consultar topo**:
  - Retorna o item do `topo`.
- **Verificar se está vazia**:
  - Se `topo == fundo`.

---

## Códigos de apoio

```java
import java.util.NoSuchElementException;

public class Pilha<E> {
    private Celula<E> topo;
    private Celula<E> fundo;

    public Pilha() {
        Celula<E> sentinela = new Celula<>();
        topo = sentinela;
        fundo = sentinela;
    }

    public boolean vazia() {
        return topo == fundo;
    }

    public void empilhar(E item) {
        topo = new Celula<>(item, topo);
    }

    public E desempilhar() {
        E desempilhado = consultarTopo();
        topo = topo.getProximo();
        return desempilhado;
    }

    public E consultarTopo() {
        if (vazia()) {
            throw new NoSuchElementException("Nao há nenhum item na pilha!");
        }
        return topo.getItem();
    }
}
```

```java
public class Celula<T> {
    private final T item;
    private Celula<T> proximo;

    public Celula() {
        this.item = null;
        this.proximo = null;
    }

    public Celula(T item) {
        this.item = item;
        this.proximo = null;
    }

    public Celula(T item, Celula<T> proximo) {
        this.item = item;
        this.proximo = proximo;
    }

    public T getItem() {
        return item;
    }

    public Celula<T> getProximo() {
        return proximo;
    }

    public void setProximo(Celula<T> proximo) {
        this.proximo = proximo;
    }
}
```

---

## Representação Visual

🔵 Pilha com 3 elementos empilhados:

```
Topo -> [C] -> [B] -> [A] -> [Sentinela] (fundo)
```

**Empilhar**: cria nova célula que aponta para o `topo` anterior.

**Desempilhar**: move o `topo` para o próximo nó.

---

# 🚀 Big-O das Operações (O(1))

### O que é essa anotação?
- **O(1)** significa **tempo constante**.
- Não importa o número de elementos: a operação sempre leva **o mesmo tempo**.

### E na pilha com lista encadeada?

| Operação         | Complexidade | Por quê? |
|------------------|--------------|----------|
| Empilhar (push)  | O(1)          | Cria célula e atualiza ponteiro. |
| Desempilhar (pop)| O(1)          | Atualiza ponteiro `topo`. |
| Consultar topo   | O(1)          | Acesso direto ao `topo`. |
| Verificar vazio  | O(1)          | Compara ponteiros `topo` e `fundo`. |

✅ Portanto, **todas as operações básicas da pilha com lista encadeada são O(1)**.

---

# 📌 Vantagens e Desvantagens

| Vantagens                             | Desvantagens                            |
|:--------------------------------------|:----------------------------------------|
| Sem limite fixo (cresce dinamicamente) | Pequeno overhead de memória (ponteiros). |
| Tempo garantido O(1)                  | Acesso não é contíguo na memória (menos cache-friendly). |
| Código modular com células            | Um pouco mais complexo que vetor. |

---

# 🧠 Curiosidades Importantes

- A pilha da **linguagem Scheme** (e outras linguagens funcionais) é modelada internamente **como lista ligada**!
- Como não há vetor fixo, **não ocorre StackOverflow** pelo tamanho da pilha em si — mas pode estourar a memória heap se abusar.

---

# 🔥 Resumo Final em uma frase:

> **"Pilha com lista encadeada é uma estrutura LIFO, de operações O(1), sem limite fixo de tamanho, mas com leve custo extra de memória por ponteiro."**

---
