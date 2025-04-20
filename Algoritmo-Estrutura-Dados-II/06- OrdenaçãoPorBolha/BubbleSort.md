# 🫧 BUBBLESORT

## 📚 O que é o Bubblesort?

- **Algoritmo de ordenação simples** e intuitivo.
- Compara **pares de elementos adjacentes** e os troca de lugar se estiverem na ordem errada.
- Repete o processo até que **nenhuma troca** seja necessária (vetor ordenado).

---

## ⚙️ Como funciona (conceitualmente):

1. Percorre o vetor várias vezes.
2. Em cada passagem, compara elementos **lado a lado**.
3. Se o elemento da esquerda for maior que o da direita, **troca**.
4. Após cada passagem, o **maior elemento “borbulha” para o final**.
5. O processo repete até que nenhuma troca aconteça.

---

## 💡 Características:

- **Complexidade:**
  - Melhor caso (vetor já ordenado): **O(n)**
  - Médio e pior caso: **O(n²)**
- **Estável:** mantém a ordem de elementos iguais.
- **Não requer espaço extra**: ordena no próprio vetor.
- **Pouco eficiente para grandes volumes de dados**, mas fácil de entender e implementar.

---

## 🧮 Exemplo com vetor pequeno

Vamos usar o vetor `[23, 16, 4, 42]`.

---

### 📐 Etapas do Bubblesort com Numeração das Passagens

---

### 🔹 **Passagem 1:**

- Vetor: `[23, 16, 4, 42]`  
  - Compara 23 e 16 → troca → `[16, 23, 4, 42]`  
  - Compara 23 e 4 → troca → `[16, 4, 23, 42]`  
  - Compara 23 e 42 → ok (sem troca)  
  ✅ Após Passagem 1: `[16, 4, 23, 42]`  

---

### 🔹 **Passagem 2:**

- Vetor: `[16, 4, 23, 42]`  
  - Compara 16 e 4 → troca → `[4, 16, 23, 42]`  
  - Compara 16 e 23 → ok  
  - Compara 23 e 42 → ok  
  ✅ Após Passagem 2: `[4, 16, 23, 42]`

---

### 🔹 **Passagem 3:**

- Vetor: `[4, 16, 23, 42]`  
  - Compara 4 e 16 → ok  
  - Compara 16 e 23 → ok  
  - Compara 23 e 42 → ok  
  🔸 Nenhuma troca feita → algoritmo finaliza

---

### 🧠 Resumo por Passagem:

| Passagem | Comparações                    | Trocas realizadas? | Resultado parcial      |
|----------|--------------------------------|---------------------|------------------------|
| 1        | 23>16, 23>4, 23<42             | Sim                 | `[16, 4, 23, 42]`      |
| 2        | 16>4, 16<23, 23<42             | Sim                 | `[4, 16, 23, 42]`      |
| 3        | 4<16, 16<23, 23<42             | Não                 | `[4, 16, 23, 42]` ✅    |

---

## 🧑‍💻 Código Java Explicado

### Método principal:
```java
public T[] ordenar() {
  bubbleSort();
  return dados;
}
```
> Chama o método `bubbleSort`, responsável por ordenar o vetor.

---

### Método `bubbleSort`:
```java
private void bubbleSort() {
  boolean trocou;
  for (int i = 0; i < dados.length - 1; i++) {
    trocou = false;
    for (int j = 0; j < dados.length - 1 - i; j++) {
      comparacoes++;
      if (comparador.compare(dados[j], dados[j + 1]) > 0) {
        T temp = dados[j];
        dados[j] = dados[j + 1];
        dados[j + 1] = temp;
        movimentacoes++;
        trocou = true;
      }
    }
    if (!trocou) break; // Otimização: para se já estiver ordenado
  }
}
```

> O algoritmo **varre o vetor várias vezes**, trocando elementos adjacentes fora de ordem, “empurrando” os maiores para o final a cada iteração.

---

## 🧠 Comparações e Movimentações

Durante o Bubble Sort:

- Cada verificação `if (dados[j] > dados[j+1])` é uma **comparação**.
- Cada troca de posição entre dois elementos é uma **movimentação**.

---

## 📌 Resumo Visual do Fluxo:

```
Inicial:      [5, 1, 4, 2]
1ª passada:   [1, 4, 2, 5]
2ª passada:   [1, 2, 4, 5]
3ª passada:   [1, 2, 4, 5] ✅
```

> Elementos vão “subindo” como bolhas para o final do vetor.  
> A cada iteração, o maior elemento restante vai para a posição correta.

---

## ✅ Vantagens

- **Simples e fácil de implementar**, ideal para fins educacionais.  
- **Estável**, ou seja, mantém a ordem de elementos iguais.  
- Pode ser **otimizado** com verificação de trocas para encerrar cedo se já estiver ordenado.

---

## ⚠️ Desvantagens

- **Desempenho ruim** com vetores grandes.  
- Complexidade de tempo **O(n²)** no pior e no caso médio.  
- **Pouco eficiente**, mesmo se comparado com outros algoritmos simples como o Insertion Sort.

---

## 🕐 Quando usar o Bubble Sort?

- Quando o vetor é **muito pequeno**.  
- Para fins **educacionais**, para ilustrar lógica de ordenação.  
- Quando **estabilidade** for necessária e o desempenho não for um problema.  
- **Não recomendado** para grandes volumes de dados.

---

## ✅ Conclusão

- Bubble Sort é **intuitivo, mas ineficiente** para uso prático com grandes conjuntos.  
- Realiza trocas sucessivas de pares vizinhos até ordenar tudo.  
- Seu melhor uso é **didático ou em situações extremamente simples**.  
- Complexidade:  
  - Pior caso: **O(n²)**  
  - Melhor caso (já ordenado): **O(n)** com a otimização

---
