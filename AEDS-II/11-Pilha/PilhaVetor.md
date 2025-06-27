# 📚 PILHA COM VETOR — RESUMO AVANÇADO

## O que é uma Pilha?

- Estrutura **LIFO** (*Last In, First Out*): o último elemento adicionado é o primeiro a ser removido.
- Só é possível acessar, inserir ou remover **no topo** da pilha.
- **Ordem lógica** dos dados: o mais recente no topo, o mais antigo no fundo.

---

## Aplicações Clássicas
- **Undo/redo** em editores (Word, Photoshop...).
- **Histórico** de navegação.
- **Execução de chamadas recursivas** (pilha de execução no processador).
- **Análise de expressões aritméticas** e **verificação de parênteses balanceados**.
- **Backtracking** em algoritmos (ex: labirintos, Sudoku).

---

## Implementação de Pilha com Vetor

### Estrutura
- Usa-se um **vetor fixo** (array) para armazenar os elementos.
- Um **índice `topo`** aponta para a **próxima posição livre** no vetor.
- O vetor é contíguo na memória → **acessos rápidos**.

---

### Regras Gerais
- **Inicialização**: `topo = 0`.
- **Empilhar (`push`)**:
  - Se o vetor não estiver cheio, coloca o item na posição `topo`.
  - Incrementa `topo`.
- **Desempilhar (`pop`)**:
  - Decrementa `topo`.
  - Retorna o item da posição anterior.
- **Consultar topo**:
  - Retorna o item na posição `topo - 1`.
- **Verificar se está vazia**:
  - Se `topo == 0`.
- **Verificar se está cheia**:
  - Se `topo == vetor.length`.

---

## Códigos de apoio

```java
public class Pilha<E> {
    private final E[] pilha;
    private int topo;

    public Pilha(int tamanho) {
        pilha = (E[]) new Object[tamanho];
        topo = 0;
    }

    public boolean vazia() {
        return topo == 0;
    }

    private boolean cheia() {
        return topo == pilha.length;
    }

    public void empilhar(E item) {
        if (cheia()) {
            throw new IllegalStateException("Pilha cheia!");
        }
        pilha[topo++] = item;
    }

    public E desempilhar() {
        if (vazia()) {
            throw new NoSuchElementException("Pilha vazia!");
        }
        return pilha[--topo];
    }

    public E consultarTopo() {
        if (vazia()) {
            throw new NoSuchElementException("Pilha vazia!");
        }
        return pilha[topo - 1];
    }
}
```

---

## Representação Visual

🔵 Vetor de 5 posições — topo = 3 (3 elementos empilhados):

| Índice | Conteúdo |
|:------:|:--------:|
|   0    |    A     |
|   1    |    B     |
|   2    |    C     |
|   3    |   vazio  |
|   4    |   vazio  |

**Empilhar** → adiciona no índice 3 → `topo = 4`.

**Desempilhar** → remove do índice 2 → `topo = 2`.

---

# 🚀 Big-O das Operações (O(1))

### O que é essa anotação?
- **O(1)** significa **tempo constante**.
- Não importa o **número de elementos**: a operação sempre leva **o mesmo tempo**.
  
### E na pilha com vetor?

| Operação       | Complexidade | Por quê? |
|----------------|--------------|----------|
| Empilhar (push)  | O(1)          | Atribuir valor no vetor + incrementar `topo`. Nenhum loop. |
| Desempilhar (pop) | O(1)         | Decrementar `topo` e acessar vetor. |
| Consultar topo | O(1)          | Acesso direto ao índice `topo - 1`. |
| Verificar vazio/cheio | O(1)  | Só compara o valor de `topo`. |

✅ Portanto, **todas as operações básicas da pilha com vetor são O(1)**.

### Exceção prática
- **Caso especial**: se precisasse aumentar o vetor dinamicamente (como em uma `ArrayList`), a realocação seria **O(n)** (porque precisa copiar todos os elementos).  
- Mas **nesta pilha**, como o vetor é **fixo**, não há custo extra.

---

# 📌 Vantagens e Desvantagens

| Vantagens                             | Desvantagens                              |
|:--------------------------------------|:-----------------------------------------|
| Tempo garantido O(1)                  | Tamanho do vetor fixo. Não cresce sozinho. |
| Código muito simples                  | Pode desperdiçar memória se superdimensionado. |
| Alta velocidade de acesso             | Pode gerar **overflow** se ultrapassar o tamanho.|

---

# 🧠 Curiosidades Importantes

- A **pilha de chamadas** da JVM (Java Virtual Machine) funciona **exatamente** como uma pilha com vetor!
- Quando ocorre o erro "**StackOverflowError**", é porque ultrapassamos o limite da pilha da JVM — exatamente como uma pilha vetorial cheia.

---

# 🔥 Resumo Final em uma frase:

> **"Pilha com vetor é uma estrutura LIFO, de acesso e modificação O(1), simples, rápida, porém limitada em tamanho fixo."**

---
