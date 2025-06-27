# 📚 FILA COM LISTA ENCADEADA — RESUMO AVANÇADO

## O que é uma Fila?

- Estrutura **FIFO** (*First In, First Out*): o primeiro a entrar é o primeiro a sair.
- Inserções são feitas no **final (trás)** da fila.
- Remoções são feitas no **início (frente)** da fila.
- **Ordem lógica** dos dados: o mais antigo é atendido primeiro.

---

## Aplicações Clássicas

- Atendimento bancário ou filas de bilheteria.
- Impressoras (documentos aguardando impressão).
- Processos no sistema operacional aguardando CPU.
- Atendimento em sistemas web (requisições em fila).
- Sistemas de reserva ou cadastro (biblioteca, matrícula).

---

## Implementação com Lista Encadeada (Auto-referenciada)

### Estrutura

- Usa **células encadeadas**, representadas pela classe `Celula<E>`.
- Cada célula possui:
  - Um **item** genérico.
  - Uma **referência para a próxima célula**.
- A fila possui dois ponteiros:
  - **`frente`** → aponta para a **célula sentinela** (início).
  - **`tras`** → aponta para a **última célula real** da fila.

---

### Regras Gerais

- **Inicialização**:
  - Cria-se uma **célula sentinela** (sem item).
  - `frente = tras = sentinela`.
- **Enfileirar**:
  - Cria nova célula com item.
  - Liga essa célula ao final da fila.
  - Atualiza `tras` para apontar para a nova célula.
- **Desenfileirar**:
  - Remove a célula logo após a sentinela.
  - Atualiza `frente` para apontar para a próxima.
  - Se a célula removida for a última, atualiza também `tras = frente`.
- **Consultar primeiro**:
  - Retorna o item da célula após a sentinela.
- **Verificar se está vazia**:
  - Compara se `frente == tras`.

---

## Código Base

```java
public class Fila<E> {
    private Celula<E> frente;
    private Celula<E> tras;

    public Fila() {
        Celula<E> sentinela = new Celula<>();
        frente = tras = sentinela;
    }

    public boolean vazia() {
        return frente == tras;
    }

    public void enfileirar(E item) {
        Celula<E> novaCelula = new Celula<>(item);
        tras.setProximo(novaCelula);
        tras = novaCelula;
    }

    public E desenfileirar() {
        E item = consultarPrimeiro();
        Celula<E> primeira = frente.getProximo();
        frente.setProximo(primeira.getProximo());
        primeira.setProximo(null);
        if (primeira == tras)
            tras = frente;
        return item;
    }

    public E consultarPrimeiro() {
        if (vazia())
            throw new NoSuchElementException("Nao há nenhum item na fila!");
        return frente.getProximo().getItem();
    }

    public void imprimir() {
        if (vazia()) {
            System.out.println("A fila está vazia!");
            return;
        }
        Celula<E> aux = frente.getProximo();
        while (aux != null) {
            System.out.println(aux.getItem());
            aux = aux.getProximo();
        }
    }
}
```

---

## Representação Visual

🔵 Fila com 3 elementos enfileirados:

```
[Sentinela] -> [A] -> [B] -> [C] -> null
     ↑                         ↑
  frente                    tras
```

- **Enfileirar**: adiciona após `tras`.
- **Desenfileirar**: remove após `frente`.

---

# 🚀 Big-O das Operações (O(1))

| Operação            | Complexidade | Justificativa                                 |
|---------------------|--------------|-----------------------------------------------|
| Enfileirar          | O(1)         | Insere no final, sem percorrer a lista.       |
| Desenfileirar       | O(1)         | Remove do início com acesso direto.           |
| Consultar primeiro  | O(1)         | Acesso direto ao próximo da sentinela.        |
| Verificar vazia     | O(1)         | Compara `frente == tras`.                     |

✅ Assim como na pilha, **todas as operações básicas da fila encadeada são O(1)**.

---

# 📌 Vantagens e Desvantagens

| Vantagens                                   | Desvantagens                                 |
|---------------------------------------------|----------------------------------------------|
| Sem tamanho fixo — crescimento dinâmico     | Uso de mais memória (referências/células).   |
| Operações em tempo constante                | Mais complexa que implementação com vetor.   |
| Evita necessidade de realocar ou mover dados| Menos cache-friendly que vetores.            |

---

# 🧠 Dica Visual de Fila com Sentinela

- A **sentinela não armazena item**, serve só para facilitar operações.
- Sempre que a fila estiver vazia: `frente == tras == sentinela`.

---

# 🔥 Resumo Final em uma frase:

> **"Fila com lista encadeada é uma estrutura FIFO, com operações O(1), crescimento dinâmico e sentinela para facilitar remoção mesmo quando vazia."**

---

