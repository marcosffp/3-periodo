# 📚 FILA COM VETOR CIRCULAR — RESUMO AVANÇADO

## O que é uma Fila?

- Estrutura **FIFO** (*First In, First Out*): o primeiro elemento que entra é o primeiro a sair.
- Inserções são feitas **no final** (`tras`), remoções feitas **no início** (`frente`).
- **Ordem lógica** dos dados: mais antigo na frente, mais novo no final.

---

## Aplicações Clássicas
- **Atendimento bancário** (chamadas por ordem de chegada).
- **Reservas** (como pedidos de livros em bibliotecas).
- **Filas de processos** em sistemas operacionais.
- **Controle de impressão** (spoolers de impressora).
- **Buffers circulares** para comunicação de dados.

---

## Implementação de Fila com Vetor Circular

### Estrutura
- Usa-se um **vetor fixo** para armazenar os elementos.
- Dois **índices** controlam a fila:
  - `frente`: aponta para o primeiro elemento.
  - `tras`: aponta para a próxima posição livre.
- **Aritmética modular** (`%`) é usada para circular no vetor.

---

### Regras Gerais
- **Inicialização**:
  - `frente = 0`, `tras = 0`.
- **Enfileirar (`enfileirar`)**:
  - Se não estiver cheia, insere no índice `tras % vetor.length`.
  - Incrementa `tras`.
- **Desenfileirar (`desenfileirar`)**:
  - Consulta o item no índice `frente % vetor.length`.
  - Incrementa `frente`.
- **Consultar o primeiro**:
  - Acessa o item no índice `frente % vetor.length`.
- **Verificar se está vazia**:
  - Se `frente == tras`.
- **Verificar se está cheia**:
  - Se `(tras + 1) % vetor.length == frente % vetor.length`.

---

## Códigos de apoio

```java
import java.util.NoSuchElementException;

public class Fila<E> {
    private final E[] fila;
    private int frente;
    private int tras;

    Fila(int tamanho) {
        fila = (E[]) new Object[tamanho];
        frente = tras = 0;
    }

    public boolean cheia() {
        return (obterIndice(tras + 1) == obterIndice(frente));
    }

    public boolean vazia() {
        return (frente == tras);
    }

    private int obterIndice(int valor) {
        return (valor % fila.length);
    }

    public void enfileirar(E item) {
        if (cheia()) {
            throw new IllegalStateException("Erro ao tentar enfileirar um item. A fila está cheia!");
        }
        fila[obterIndice(tras)] = item;
        tras++;
    }

    public E desenfileirar() {
        E item = consultarPrimeiro();
        frente++;
        return item;
    }

    public E consultarPrimeiro() {
        if (vazia()) {
            throw new NoSuchElementException("Não há nenhum item na fila!");
        }
        return fila[obterIndice(frente)];
    }

    public void imprimir() {
        if (vazia()) {
            System.out.println("A fila está vazia!");
        } else {
            for (int i = frente; i < tras; i++) {
                System.out.println(fila[obterIndice(i)]);
            }
        }
    }
}
```

---

## Representação Visual

🔵 Vetor de 5 posições:

| Índice | Conteúdo |
|:------:|:--------:|
|   0    |    A     |
|   1    |    B     |
|   2    |    C     |
|   3    |  vazio   |
|   4    |  vazio   |

- `frente = 0`, `tras = 3` (3 elementos enfileirados).

**Enfileirar** → adiciona no índice `tras % tamanho_vetor`.

**Desenfileirar** → remove do índice `frente % tamanho_vetor`.

---

# 🚀 Big-O das Operações (O(1))

### O que é essa anotação?
- **O(1)** significa **tempo constante**.
- O tempo de execução não depende da quantidade de elementos.

### E na fila com vetor circular?

| Operação           | Complexidade | Por quê? |
|--------------------|--------------|----------|
| Enfileirar (enqueue) | O(1)         | Inserção direta no vetor. |
| Desenfileirar (dequeue) | O(1)      | Acesso direto e incremento do índice. |
| Consultar primeiro  | O(1)         | Acesso direto ao vetor. |
| Verificar vazio/cheio | O(1)       | Comparação simples de índices. |

✅ Todas as operações básicas são **O(1)**!

---

# 📌 Vantagens e Desvantagens

| Vantagens                             | Desvantagens                              |
|:--------------------------------------|:-----------------------------------------|
| Operações rápidas (O(1))              | Capacidade fixa: não cresce automaticamente. |
| Aproveitamento completo do vetor (circular) | Implementação exige atenção para índices. |
| Código limpo e eficiente              | Confusão entre fila cheia e fila vazia se não seguir as regras.|

---

# 🧠 Curiosidades Importantes

- **Buffers de áudio, vídeo, redes** usam exatamente **fila circular**.
- **Aritmética modular** (`%`) é crucial para circular corretamente.
- A estrutura pode ser facilmente adaptada para controlar **caches** e **pipelines**.

---

# 🔥 Resumo Final em uma frase:

> **"Fila circular com vetor é uma estrutura FIFO eficiente, com operações O(1), ideal para uso fixo e contínuo de espaço de memória."**

---
