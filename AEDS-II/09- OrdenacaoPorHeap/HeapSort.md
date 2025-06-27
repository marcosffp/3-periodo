# 🏗️ HEAPSORT

## 📚 O que é o Heapsort?

- **Algoritmo de ordenação** baseado em uma estrutura de dados chamada **heap (ou montículo)**.
- Utiliza um **heap máximo** para garantir que o maior elemento esteja sempre na raiz.
- Ordena removendo a raiz (maior elemento) e reconstruindo o heap.

---

## ⚙️ Como funciona (conceitualmente):

1. **Constrói um heap máximo** a partir do vetor.
2. **Remove a raiz (o maior valor)** e coloca no final do vetor.
3. **Reconstrói o heap** com o restante e repete até ordenar todos os elementos.

---

## 💡 Características:

- **Complexidade:**
  - Melhor, pior e médio caso: **O(n log n)**
- **Não é estável**: pode mudar a ordem de elementos iguais.
- **Não requer espaço extra significativo**: é um algoritmo **in-place**.
- Muito eficiente e previsível em tempo de execução.

---

## 🧮 Exemplo com vetor pequeno

Vamos usar o vetor `[4, 10, 3, 5, 1]`.

---

### 📐 Etapas do Heapsort com Numeração das Passagens

### 🔹 **Etapa 1 – Construção do Heap Máximo**

#### 🟠 **Parte 1:**
- Vetor inicial: `[X, 4, 10, 3, 5, 1]`
- Começa do último nó pai: índice i/2= (valor 10)
  - Nada a fazer (10 > filhos)

#### 🟠 **Parte 2:**
- Índice 1 (valor 4)
  - Filhos: 10 (esq) e 3 (dir)
  - Maior filho: 10 → troca com 4  
  🔄 Vetor: `[X, 10, 4, 3, 5, 1]`
  - teve troca, chama o restaura para o índice 2

#### 🟠 **Parte 3:**
- Índice 2 (valor 4), após troca
  - Filhos: 5 (esq) e 1 (dir)
  - Maior filho: 5 → troca com 4  
  🔄 Vetor: `[X, 10, 5, 3, 4, 1]`
  - teve troca, chama o restaura para o índice 4

#### 🟠 **Parte 4:**
- Índice 4 (valor 4), após troca
  - Filhos: NULL (esq) e NULL (dir)
  - Não teve troca


✅ **Heap máximo construído:** `[X, 10, 5, 3, 4, 1]`

---

### 🔹 **Etapa 2 – Ordenação com Trocas e Reajustes**

#### 🟢 **Passagem 1:**
- Troca raiz (10) com último (1)  
  🔄 Vetor: `[X, 1, 5, 3, 4, 10]`
- Reajusta heap (tamanho 4):
  - Índice 1: 1 → filhos 5 e 3 → troca com 5
  🔄 Vetor: `[X, 5, 1, 3, 4, 10]`
    - teve troca, chama o restaura para o índice 2
    - Índice 2: 1 → filho 4 → troca com 4  
  🔄 Vetor: `[X, 5, 4, 3, 1, 10]`
      - teve troca, chama o restaura para o índice 4
      - Índice 4: 1 → sem filho, não teve troca 

#### 🟢 **Passagem 2:**
- Troca raiz (5) com último (1)
  🔄 Vetor: `[X, 1, 4, 3, 5, 10]`
- Reajusta heap (tamanho 3):
  - Índice 1: 1 → filhos 4 e 3 → troca com 4
  🔄 Vetor: `[X, 4, 1, 3, 5, 10]`
    - teve troca, chama o restaura para o índice 2
    - Índice 2: 1 → sem filho, não teve troca 

#### 🟢 **Passagem 3:**
- Troca raiz (4) com último (3)
  🔄 Vetor: `[X, 3, 1, 4, 5, 10]`
- Reajusta heap (tamanho 2):
  - Índice 1: 3 → filho 1 → sem troca
  🔄 Vetor: `[X, 3, 1, 4, 5, 10]`

#### 🟢 **Passagem 4:**
- Troca raiz (3) com último (1)
  🔄 Vetor: `[X, 1, 3, 4, 5, 10]`
- Reajusta heap (tamanho 1):
- Heap com 1 elemento → finalizado ✅

---

#### 🟠 **Parte 5:**
- Alterar o vetor para voltar à posição zero
[1, 3, 4, 5, 10]

### 🧠 Resumo por Passagem:

| Passagem | Operação                         | Vetores Envolvidos    | Resultado             |
| -------- | -------------------------------- | --------------------- | --------------------- |
| 1        | Verifica nó 3 (valor 10)         | `[X, 4, 10, 3, 5, 1]` | Nenhuma troca         |
| 2        | Ajuste no nó 1 (troca com 10)    | `[X, 4, 10, 3, 5, 1]` | `[X, 10, 4, 3, 5, 1]` |
| 3        | Ajuste no nó 2 (troca com 5)     | `[X, 10, 4, 3, 5, 1]` | `[X, 10, 5, 3, 4, 1]` |
| 4        | Troca 10↔1, reajustes (5↔1, 4↔1) | `[X, 10, 5, 3, 4, 1]` | `[X, 5, 4, 3, 1, 10]` |
| 5        | Troca 5↔1, reajuste (4↔1)        | `[X, 5, 4, 3, 1, 10]` | `[X, 4, 1, 3, 5, 10]` |
| 6        | Troca 4↔3, sem reajuste          | `[X, 4, 1, 3, 5, 10]` | `[X, 3, 1, 4, 5, 10]` |
| 7        | Troca 3↔1, fim                   | `[X, 3, 1, 4, 5, 10]` | `[X, 1, 3, 4, 5, 10]` |


---

## 🧑‍💻 Código Java Explicado

### Método principal:
```java
@Override
public T[] ordenar(T[] dados) {
  // Prepara o heap com posição 1 baseada
  // Constrói o heap
  // Ordena por remoção da raiz
  // Retorna o vetor ordenado
}
```
> O método principal prepara o heap, ordena os dados e retorna o vetor ordenado.

---

### 🧱 Passo 1: Criar vetor auxiliar com deslocamento

```java
T[] tmp = (T[]) new Comparable[dados.length + 1];
for(int i = 0; i < dados.length; i++) {
  tmp[i+1] = dados[i];
}
```

> Cria um novo vetor (`tmp`) deslocando os elementos para começar na posição 1. Isso facilita o cálculo de pai e filhos no heap:
- Pai de `i`: `i/2`
- Filhos de `i`: `2*i` e `2*i + 1`

---

### 🔨 Passo 2: Construir o Heap

```java
for(int tamHeap = (tmp.length - 1)/2; tamHeap >= 1; tamHeap--) {
  restaura(tmp, tamHeap, tmp.length - 1);
}
```

> Começa do meio até o início do vetor, aplicando `restaura()` para garantir a propriedade de **heap máximo**.

---

### 🔁 Passo 3: Ordenar por remoção da raiz

```java
int tamHeap = tmp.length - 1;
swap(tmp, 1, tamHeap--);
while(tamHeap > 1) {
  restaura(tmp, 1, tamHeap);
  swap(tmp, 1, tamHeap--);
}
```

> Troca a raiz com o último elemento, reduz o heap e aplica `restaura()` para manter a estrutura de heap. Repete até o vetor estar ordenado.

---

### 📥 Passo 4: Copiar de volta para posição 0

```java
for(int i = 0; i < dados.length; i++) {
  dados[i] = tmp[i+1];
}
```

> Remove o deslocamento e volta a preencher o vetor original.

---

### Método `restaura`:
```java
private void restaura(T[] tmp, int i, int tamHeap) {
  int maior = i;
  int filho = getMaiorFilho(tmp, i, tamHeap);

  if (comparador.compare(tmp[i], tmp[filho]) < 0) {
    maior = filho;
  }

  if (maior != i) {
    swap(tmp, i, maior);
    if (maior <= tamHeap / 2) {
      restaura(tmp, maior, tamHeap);
    }
  }
}
```

> Garante a propriedade de heap, comparando o pai com seu maior filho e realizando trocas se necessário, de forma recursiva.

---

### Método `getMaiorFilho`:
```java
private int getMaiorFilho(T[] tmp, int i, int tamHeap) {
  if (2*i == tamHeap || comparador.compare(tmp[2*i], tmp[2*i+1]) > 0) {
    return 2*i;
  } else {
    return 2*i + 1;
  }
}
```

> Retorna o **maior filho** entre `2*i` e `2*i + 1` para decidir com quem comparar.

---

### Método `swap`:
```java
private void swap(T[] dados, int i, int j) {
  movimentacoes++;
  T temp = dados[i];
  dados[i] = dados[j];
  dados[j] = temp;
}
```

> Troca dois elementos e conta uma movimentação.

---

## 🧠 Comparações e Movimentações

Durante a construção e manutenção do heap:

- Cada `compare(...)` conta como **comparação**.
- Cada `swap(...)` conta como **movimentação**.

---

## 📌 Resumo Visual do Fluxo:

```
Vetor inicial: [16, 4, 10, 14, 7, 9, 3, 2, 8, 1]
Constrói o Heap Máximo:
              16
            /    \
          14      10
         /  \     / \
        8    7   9   3
       / \
      2   1

Remove a raiz (16), coloca no final e reconstrói o heap:
[14, 8, 10, 2, 7, 9, 3, 1, 4, 16]

Repete o processo até o vetor estar ordenado:
[1, 2, 3, 4, 7, 8, 9, 10, 14, 16]
```

---

## ✅ Vantagens

- **Tempo garantido de O(n log n)**, mesmo no pior caso.  
- **Não usa memória extra**, é um algoritmo in-place.  
- Muito útil em sistemas com **limitações de memória**.  
- **Independe da ordem inicial dos dados** (estável em desempenho).

---

## ⚠️ Desvantagens

- **Não é estável**, ou seja, pode alterar a ordem relativa de elementos iguais.  
- Implementação mais **complexa** comparada a algoritmos simples como Insertion Sort.  
- Pode ser mais **lento que o Quicksort** em média, devido ao custo da reconstrução do heap.

---

## 🕐 Quando usar o Heapsort?

- Quando **memória extra não pode ser usada**.  
- Em sistemas **embarcardos ou de tempo real** que exigem previsibilidade.  
- Quando a **estabilidade não é uma prioridade**.  
- Ideal em situações que exigem **robustez no pior caso**.

---

## ✅ Conclusão

- Heapsort é **eficiente e in-place**.
- Usa o conceito de **árvore binária (heap máximo)**.
- Sempre roda em **O(n log n)**, com uso mínimo de memória.
- **Ideal para situações com restrição de espaço**, mesmo que não preserve a ordem de elementos iguais.

---
