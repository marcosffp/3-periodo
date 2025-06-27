# 📚 LISTA DUPLAMENTE ENCADEADA — RESUMO AVANÇADO

## O que é uma Lista Duplamente Encadeada?

* Estrutura **sequencial e flexível** que armazena elementos interligados.
* Cada elemento ocupa uma **posição lógica** na lista: 0, 1, 2, ..., *n-1*.
* Cada célula possui referências para **o anterior e o próximo**.
* Permite inserções e remoções em **qualquer posição** com maior eficiência em ambas as extremidades.

---

## Aplicações Clássicas

* Navegadores (botões “voltar” e “avançar”).
* Editores de texto (comando "desfazer/refazer").
* Tabelas e listas dinâmicas (como em bancos de dados).
* Sistemas com **percursos em ambas direções** (jogos, árvores binárias balanceadas).
* Manipulação de grandes volumes de dados sem realocação de memória.

---

## Implementação com Lista Duplamente Encadeada

### Estrutura

* Usa **células auto-referenciadas** com dois ponteiros:

  * Um **item** genérico.
  * Uma **referência para a próxima célula**.
  * Uma **referência para a célula anterior**.
* A lista possui dois ponteiros principais:

  * **`primeiro`** → aponta para a **célula sentinela** (início lógico).
  * **`ultimo`** → aponta para a **última célula real** da lista.

---

### Regras Gerais

* **Inicialização**:

  * Cria-se uma **célula sentinela** (sem item).
  * `primeiro = ultimo = sentinela`.

* **Inserir no final**:

  * Cria nova célula com o item.
  * Liga essa célula ao final da lista via `setProximo()` e `setAnterior()`.
  * Atualiza `ultimo` para apontar para a nova célula.

* **Remover do final**:

  * Acessa diretamente a última célula e seu anterior.
  * Atualiza ponteiros e redefine `ultimo`.
  * Remove a célula final sem precisar percorrer a lista.

* **Verificar se está vazia**:

  * Compara se `primeiro == ultimo`.

---

## Código Base

```java
public class ListaDuplamenteEncadeada<E> {
    private Celula<E> primeiro;
    private Celula<E> ultimo;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        Celula<E> sentinela = new Celula<>();
        this.primeiro = this.ultimo = sentinela;
        this.tamanho = 0;
    }

    public boolean vazia() {
        return (this.primeiro == this.ultimo);
    }

    public void inserirFinal(E novo) {
        Celula<E> novaCelula = new Celula<>(novo, this.ultimo, null);
        this.ultimo.setProximo(novaCelula);
        this.ultimo = novaCelula;
        this.tamanho++;
    }

    public E removerFinal() {
        if (vazia())
            throw new IllegalStateException("Lista está vazia!");

        Celula<E> removida = this.ultimo;
        Celula<E> penultima = removida.getAnterior();

        penultima.setProximo(null);
        removida.setAnterior(null);
        this.ultimo = penultima;
        this.tamanho--;

        return removida.getItem();
    }
}
```

---

## Representação Visual

🔵 Lista com 3 elementos encadeados em **duas direções**:

```
null <- [A] <-> [B] <-> [C] -> null
           ↑              ↑
        primeiro        ultimo
```

* Cada célula tem **ponteiros duplos**.
* **Sentinela** facilita controle da lista vazia.
* **Inserção/remoção** no final são otimizadas com acesso direto.

---

# 🚀 Big-O das Operações (Duplamente Encadeada)

| Operação                | Complexidade | Justificativa                                           |
| ----------------------- | ------------ | ------------------------------------------------------- |
| Inserir no final        | O(1)         | Usa ponteiro `ultimo` diretamente.                      |
| Remover do final        | O(1)         | Acessa anterior da última célula sem percorrer a lista. |
| Inserir/remover início  | O(1)\*       | (Necessita método adicional para início)                |
| Inserir/remover no meio | O(n)         | Precisa percorrer até a posição desejada.               |
| Verificar vazia         | O(1)         | Compara `primeiro == ultimo`.                           |

✅ Destaque: **remoção eficiente do fim**, que seria O(n) em lista simplesmente encadeada.

---

# 📌 Vantagens e Desvantagens

| Vantagens                                       | Desvantagens                                        |
| ----------------------------------------------- | --------------------------------------------------- |
| Permite percorrer a lista nos **dois sentidos** | Maior uso de memória (duas referências por célula). |
| Remoção eficiente no final (sem percurso)       | Código mais complexo que lista simples.             |
| Acesso direto ao vizinho anterior e próximo     | Mais propenso a erros com manipulação de ponteiros. |

---

# 🧠 Dica Visual de Lista Duplamente Encadeada

* Cada célula sabe **quem vem antes e quem vem depois**.
* A **sentinela** ajuda a padronizar operações em listas vazias.
* Ideal quando se precisa **acessar ou remover o último elemento frequentemente**.

---

# 🔥 Resumo Final em uma frase:

> **"A lista duplamente encadeada é uma estrutura dinâmica e bidirecional, que permite inserções e remoções eficientes em ambas as extremidades com uso de ponteiros anterior e próximo."**

---

