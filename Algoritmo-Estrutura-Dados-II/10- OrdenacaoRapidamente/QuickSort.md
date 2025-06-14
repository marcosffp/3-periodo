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
`[33, 15, 10, 99, 12, 2, 50]`

---

### 📐 Etapas do Quicksort com Numeração das Passagens

### 🔹 **Etapa 1 – Divisão e Recursão**

#### 🟠 **Passagem 1:**
- Vetor: `[50, 15, 10, 99, 12, 2, 33]`
- **Pivô escolhido:** 33 
- Particiona:
  - Menores que 33: `[15 ,10 ,12 ,2]`
  - Pivô: `[33]`
  - Maiores que 33: `[50, 99]`
  - Inserir o Pivô na posição certa:[15,10,12,2,] 33 [,99,50]

---

#### 🟠 **Passagem 2**
- Vetor: `[15 , 10, 12, 2]`
- **Pivô escolhido:** 2 
- Particiona:  
  - Menores que 2: `[]`  
  - Pivô: `[2]`  
  - Maiores que 2: `[15, 10, 12]`
  - Inserir o Pivô na posição certa:[] 2 [,10,12,15]

---

#### 🟠 **Passagem 3**
- Vetor: `[10, 12, 15]`
- **Pivô escolhido:** 15   
- Particiona:
  - Menores que 15: `[10, 12]`  
  - Pivô: `[15]`  
  - Maiores que 15: `[]`
  - Inserir o Pivô na posição certa:[10,12,] 15 []

---

#### 🟠 **Passagem 4**
- Vetor: `[10, 12]`
- **Pivô escolhido:** 12   
- Particiona:
  - Menores que 12: `[10]`  
  - Pivô: `[12]`  
  - Maiores que 12: `[]`
  - Inserir o Pivô na posição certa:[10] 12 []

---

#### 🔹 **Casos-base (não são contados como passagens):**
- `[10]`→ já está ordenado (1 elemento)

---

#### 🟠 **Passagem 5:**
- Vetor: `[99, 50]`
- **Pivô escolhido:** 50 
- Particiona:
  - Menores que 50: `[]`
  - Pivô: `[50]`
  - Maiores que 50: `[99]`
  - Inserir o Pivô na posição certa:[] 50 [99]

---

#### 🔹 **Caso-base (não é contado como passagem):**
- `[99]` → já está ordenado

---

### 🔹 **Etapa 2 – Combinação dos Resultados (de volta da recursão)**

1. `[50] + [99]` → `[50, 99]`  
2. `[10] + [12]` → `[10, 12]`
3. `[10, 12] + [15]` → `[10, 12, 15]`   
4. Final: `[10, 12, 15] + [33] + [50, 99]` → ✅ **Resultado final: `[10, 12, 15, 33, 50, 99]`**

---

### 🧠 Resumo por Passagem:

| Passagem | Pivô | Vetor Atual                   | Menores que o Pivô | Pivô   | Maiores que o Pivô |
| -------- | ---- | ----------------------------- | ------------------ | ------ | ------------------ |
| 1        | 33   | `[50, 15, 10, 99, 12, 2, 33]` | `[15, 10, 12, 2]`  | `[33]` | `[50, 99]`         |
| 2        | 2    | `[15, 10, 12, 2]`             | `[]`               | `[2]`  | `[15, 10, 12]`     |
| 3        | 15   | `[15, 10, 12]`                | `[10, 12]`         | `[15]` | `[]`               |
| 4        | 12   | `[10, 12]`                    | `[10]`             | `[12]` | `[]`               |
| —        | —    | `[10]`                        | (casos-base)       |        |                    |
| 5        | 50   | `[99, 50]`                    | `[]`               | `[50]` | `[99]`             |
| —        | —    | `[99]`                        | (casos-base)       |        |                    |

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
