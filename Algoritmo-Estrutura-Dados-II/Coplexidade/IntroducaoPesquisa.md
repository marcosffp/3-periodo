# **Resumo – Introdução à Análise de Complexidade de Algoritmos**

## **1. O que é um Algoritmo?**
- **Definição:** Sequência de ações executáveis para resolver um problema específico.

## **2. Complexidade de Algoritmos**
- **Objetivo:** Estudar o consumo de recursos do algoritmo:
  - **Memória**
  - **Largura de banda**
  - **Tempo de execução**
- **Por que estudar complexidade?**
  - Limitações de memória e processamento.
  - O tempo de execução cresce conforme a entrada aumenta.

## **3. Como Avaliar o Custo de um Algoritmo?**
1. **Execução real do programa**  
   - Problemas: Depende do hardware, compilador e memória.
2. **Modelo matemático**  
   - Define operações e seu custo.
   - Foca nas operações mais significativas.

## **4. Função de Complexidade (`f(n)`)**
- **Representa o tempo de execução do algoritmo** com entrada de tamanho `n`.
- **Exemplo:**  
  ```c
  int max(int[] vetor) {
      int i, temp;
      temp = vetor[0];
      for (i = 1; i < vetor.length; i++)
          if (temp < vetor[i])
              temp = vetor[i];
      return temp;
  }
  ```
  - **Operação mais relevante:** Comparação (`if`).
  - **Número de execuções:** `n - 1` → **f(n) = n - 1` → O(n).**

## **5. Casos de Complexidade**
- **Melhor caso:** Menor tempo possível.
- **Pior caso:** Maior tempo possível.
- **Caso médio:** Média dos tempos de execução.

**Exemplo: Pesquisa Sequencial em um vetor de tamanho `n`**
- **Melhor caso:** `f(n) = 1` (Elemento encontrado no primeiro índice).
- **Pior caso:** `f(n) = n` (Elemento na última posição ou inexistente).
- **Caso médio:** `f(n) = (n + 1)/2`.

💡 **Geralmente, analisamos o pior caso para estimar o tempo máximo necessário.**

## **6. Exemplo 2 – Encontrar Máximo e Mínimo**
### **Código Original**
```c
int* maxMin_1(int vetor[], int tamVetor) {
    int i;
    int *temp = (int *) calloc(2, sizeof(int));
    temp[0] = vetor[0]; temp[1] = vetor[0];
    for (i = 1; i < tamVetor; i++) {
        if (temp[0] < vetor[i]) temp[0] = vetor[i];
        if (temp[1] > vetor[i]) temp[1] = vetor[i];
    }
    return temp;
}
```
- **Tempo de execução:** `f(n) = 2(n - 1)` → **O(n)**.
- **Sem caso médio**, pois sempre executa **duas comparações por iteração**.

### **Código Otimizado**
```c
int* maxMin_2(int vetor[], int tamVetor) {
    int i;
    int *temp = (int *) calloc(2, sizeof(int));
    temp[0] = vetor[0]; temp[1] = vetor[0];
    for (i = 1; i < tamVetor; i++) {
        if (temp[0] < vetor[i]) temp[0] = vetor[i];
        else if (temp[1] > vetor[i]) temp[1] = vetor[i];
    }
    return temp;
}
```
- **Melhor caso:** `f(n) = n - 1` → **O(n)** (vetor ordenado crescentemente).
- **Pior caso:** `f(n) = 2(n - 1)` → **O(n)** (vetor ordenado decrescentemente).
- **Caso médio:** `f(n) = (3n)/2 - 3/2` → **O(n)**.

### **Outra Otimização – Comparação por Pares**
- Compara elementos em pares, reduzindo operações.
- **Complexidade:** `f(n) = (3n)/2 - 2` → **O(n)**.

---

## **7. Conclusão**
- **A análise de complexidade ajuda a prever o desempenho do algoritmo.**
- **O(n)** é eficiente para encontrar máximo/mínimo.
- **Otimizações reduzem comparações, melhorando o tempo de execução.**


