# ⚡ QUICKSORT

## 📚 O que é o Quicksort?

- **Algoritmo recursivo** de ordenação.
- Usa o princípio de **dividir e conquistar**.
- Escolhe um **pivô**, **particiona** o vetor em elementos menores e maiores que ele, e **ordena recursivamente** cada parte.

---

## ⚙️ Como funciona (conceitualmente):

1. **Escolhe um pivô** (geralmente o primeiro, último, central ou aleatório).
2. **Particiona** o vetor: todos os menores que o pivô vão para um lado, os maiores para o outro.
3. **Recursivamente** aplica o processo nas duas subpartes.
4. Ao final, todos os elementos estão ordenados **em relação ao pivô**.

---

## 💡 Características:

- **Complexidade:**  
  - Melhor e médio caso: **O(n log n)**  
  - Pior caso (vetor já ordenado ou pivô mal escolhido): **O(n²)**
- **Não é estável** (pode mudar a ordem de elementos iguais).
- **Não requer espaço extra** significativo (in-place).
- Muito eficiente na prática e usado amplamente em implementações reais.

---

## 🧮 Exemplo com vetor

Vamos usar o vetor:  
`[33, 15, 10, 99, 27, 48, 12, 2, 50]`

---

### 📐 Etapas do Quicksort com Numeração das Passagens

### 🔹 **Etapa 1 – Divisão e Recursão**

#### 🟠 **Passagem 1:**
- Vetor: `[33, 15, 10, 99, 27, 48, 12, 2, 50]`
- **Pivô escolhido:** 33  
- Particiona:
  - Menores que 33: `[15, 10, 27, 12, 2]`
  - Pivô: `[33]`
  - Maiores que 33: `[99, 48, 50]`

---

#### 🟠 **Passagem 2 (Subvetor menor: `[15, 10, 27, 12, 2]`)**
- **Pivô:** 15  
- Menores: `[10, 12, 2]`  
- Pivô: `[15]`  
- Maiores: `[27]`

---

#### 🟠 **Passagem 3 (Subvetor `[10, 12, 2]`)**
- **Pivô:** 10  
- Menores: `[2]`  
- Pivô: `[10]`  
- Maiores: `[12]`

---

#### 🔹 **Casos-base (não são contados como passagens):**
- `[2]`, `[12]`, `[27]` → já estão ordenados (1 elemento)

---

#### 🟠 **Passagem 4 (Subvetor maior: `[99, 48, 50]`)**
- **Pivô:** 99  
- Menores: `[48, 50]`  
- Pivô: `[99]`  
- Maiores: `[]`

---

#### 🟠 **Passagem 5 (Subvetor `[48, 50]`)**
- **Pivô:** 48  
- Menores: `[]`  
- Pivô: `[48]`  
- Maiores: `[50]`

---

#### 🔹 **Caso-base (não é contado como passagem):**
- `[50]` → já está ordenado

---

### 🔹 **Etapa 2 – Combinação dos Resultados (de volta da recursão)**

1. `[2] + [10] + [12]` → `[2, 10, 12]`  
2. `[2, 10, 12] + [15] + [27]` → `[2, 10, 12, 15, 27]`  
3. `[48] + [50]` → `[48, 50]`  
4. `[48, 50] + [99]` → `[48, 50, 99]`  
5. Final: `[2, 10, 12, 15, 27] + [33] + [48, 50, 99]` → ✅ **Resultado final: `[2, 10, 12, 15, 27, 33, 48, 50, 99]`**

---

### 🧠 Resumo por Passagem:

| Passagem | Pivô | Vetor Atual                         | Partes (Menores | Pivô | Maiores)        |
|----------|------|--------------------------------------|------------------|------|------------------|
| 1        | 33   | `[33, 15, 10, 99, 27, 48, 12, 2, 50]` | `[15, 10, 27, 12, 2]` | `[33]` | `[99, 48, 50]` |
| 2        | 15   | `[15, 10, 27, 12, 2]`                | `[10, 12, 2]` | `[15]` | `[27]`      |
| 3        | 10   | `[10, 12, 2]`                        | `[2]` | `[10]` | `[12]`          |
| —        | —    | `[2]`, `[12]`, `[27]`                | (casos-base)           |
| 4        | 99   | `[99, 48, 50]`                       | `[48, 50]` | `[99]` | `[]`         |
| 5        | 48   | `[48, 50]`                           | `[]` | `[48]` | `[50]`         |
| —        | —    | `[50]`                               | (caso-base)            |

---


## 🧑‍💻 Código Java Explicado

### Método principal:
```java
@Override
public T[] ordenar(T[] dados) {

  dadosOrdenados = dados;

  comparacoes = 0;
  movimentacoes = 0;
  iniciar();

  quicksort(0, dadosOrdenados.length - 1);

  terminar();

  return dadosOrdenados;
}
```

> O método principal inicializa as variáveis, chama o `quicksort` para ordenar os dados e retorna o vetor ordenado. A ordenação acontece **in-place**, ou seja, no próprio vetor.

---

### 🔁 Passo 1: Método `quicksort` recursivo

```java
private void quicksort(int esq, int dir) {
  int part;
  if (esq < dir) {
    part = particao(esq, dir);
    quicksort(esq, part - 1);
    quicksort(part + 1, dir);
  }
}
```

> O vetor é dividido em duas partes em torno do **pivô**. O algoritmo chama a si mesmo recursivamente até que todos os elementos estejam ordenados.

---

### 📍 Passo 2: Método `particao`

```java
private int particao(int inicio, int fim) {
  T pivot = dadosOrdenados[fim];
  int part = inicio - 1;

  for (int i = inicio; i < fim; i++) {
    if (comparador.compare(dadosOrdenados[i], pivot) < 0) {
      part++;
      swap(part, i);
    }
  }

  part++;
  swap(part, fim);
  return part;
}
```

> Usa o **último elemento como pivô**. Elementos menores que ele vão para a esquerda e os maiores para a direita. O pivô é colocado na posição correta ao final do processo.

---

### 🔄 Método `swap`

```java
private void swap(int i, int j) {
  movimentacoes++;

  T temp = dadosOrdenados[i];
  dadosOrdenados[i] = dadosOrdenados[j];
  dadosOrdenados[j] = temp;
}
```

> Realiza a troca entre dois elementos no vetor e incrementa o contador de movimentações.

---

## 🧠 Comparações e Movimentações

Durante o particionamento:

- Cada `comparador.compare(...)` é uma **comparação**.
- Cada chamada de `swap(...)` representa uma **movimentação**.

---

## 📌 Resumo Visual do Fluxo:

```
Vetor inicial: [8, 4, 7, 3, 10, 2, 6, 5, 1, 9]

1. Escolhe pivô (ex: 9)
   Particiona em:
   [8, 4, 7, 3, 2, 6, 5, 1] 9 [10]

2. Repete nas subpartes:
   [1, 4, 7, 3, 2, 6, 5, 8]
   [10]

3. Continua até ordenar tudo:
   [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
```

---

## ✅ Vantagens

- **Muito rápido na prática**, geralmente mais eficiente que o Heapsort.
- **In-place**, não precisa de memória extra significativa.
- Ideal para grandes volumes de dados.

---

## ⚠️ Desvantagens

- **Pior caso é O(n²)** (ex: vetor já ordenado e pivô ruim).
- **Não é estável**, pode alterar a ordem de elementos iguais.
- Pode ser necessário aplicar otimizações (como escolher pivô mediana) para garantir desempenho consistente.

---

## 🕐 Quando usar o Quicksort?

- Quando **rapidez é prioridade**.
- Quando **a estabilidade não é necessária**.
- Quando há **memória suficiente para a pilha de chamadas recursivas**.
- Ótimo para **dados grandes e aleatórios**.

---

## ✅ Conclusão

- Quicksort é **rápido, eficiente e in-place**.
- Usa o conceito de **divisão e conquista** com pivôs.
- É o algoritmo de ordenação mais usado na prática.
- Requer cuidado com **escolha do pivô** para evitar pior desempenho.

---
