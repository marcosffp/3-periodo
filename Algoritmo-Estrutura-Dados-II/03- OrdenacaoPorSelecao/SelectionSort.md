# **Resumo – Método de Ordenação por Seleção (Selection Sort)**

## **1. O que é Ordenação?**
- Processo de **organizar os elementos** de um conjunto de dados.
- Pode ser feita de forma **crescente** ou **decrescente**.
- Auxilia em buscas mais eficientes e melhora a estruturação dos dados.

## **2. Como Funciona o Selection Sort?**
### **Passo a passo:**
1. Para cada posição do vetor (**posição de referência**):
   - Encontra o menor elemento no restante do vetor.
   - Troca esse elemento com o da posição de referência.
2. Repete o processo até que todos os elementos estejam ordenados.

### **Exemplo:**
Ordenando o vetor `[23, 16, 4, 42, 8, 15]` de forma crescente:

| Iteração | Vetor Ordenado Parcialmente |
|----------|-----------------------------|
| 1ª Passagem | `[4, 16, 23, 42, 8, 15]`  |
| 2ª Passagem | `[4, 8, 23, 42, 16, 15]`  |
| 3ª Passagem | `[4, 8, 15, 42, 16, 23]`  |
| 4ª Passagem | `[4, 8, 15, 16, 42, 23]`  |
| 5ª Passagem | `[4, 8, 15, 16, 23, 42]`  |

---

## **3. Código em C – Selection Sort**
```c
#include <stdio.h>

// Função para trocar dois elementos de posição
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// Função de Ordenação por Seleção (Selection Sort)
void selectionSort(int arr[], int n) {
    int i, j, minIndex;

    for (i = 0; i < n - 1; i++) {
        minIndex = i; // Assume que o menor elemento está na posição atual

        // Encontra o menor elemento no restante do vetor
        for (j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }

        // Troca o menor elemento encontrado com o elemento na posição atual
        if (minIndex != i) {
            swap(&arr[i], &arr[minIndex]);
        }
    }
}

// Função para imprimir o vetor
void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

// Função principal
int main() {
    int arr[] = {23, 16, 4, 42, 8, 15};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("Array original:\n");
    printArray(arr, n);

    selectionSort(arr, n);

    printf("Array ordenado:\n");
    printArray(arr, n);

    return 0;
}
```

---

## **4. Complexidade do Selection Sort**
- **Número de operações realizadas:**  
  - Cada elemento é comparado com todos os seguintes → **O(n²)**
  - Número total de comparações: `(n-1) + (n-2) + ... + 1 = (n² - n)/2`
- **Melhor caso (já ordenado):** **O(n²)**
- **Pior caso (ordenado inversamente):** **O(n²)**
- **Caso médio:** **O(n²)**

📌 **Mesmo no melhor caso, o tempo de execução continua alto, tornando o algoritmo ineficiente para grandes conjuntos de dados.**

---

## **5. Comparação com Outros Métodos**
| Algoritmo       | Melhor Caso | Pior Caso | Caso Médio | Complexidade Espacial |
|----------------|------------|------------|------------|----------------------|
| **Selection Sort** | O(n²) | O(n²) | O(n²) | O(1) |
| **Bubble Sort** | O(n) | O(n²) | O(n²) | O(1) |
| **Insertion Sort** | O(n) | O(n²) | O(n²) | O(1) |
| **Merge Sort** | O(n log n) | O(n log n) | O(n log n) | O(n) |
| **Quick Sort** | O(n log n) | O(n²) | O(n log n) | O(log n) |

✅ **Vantagens do Selection Sort:**
- Simples de implementar.
- Não requer memória extra (**O(1)** de espaço).

❌ **Desvantagens do Selection Sort:**
- Ineficiente para grandes conjuntos de dados devido à sua complexidade **O(n²)**.
- Realiza muitas comparações, mesmo que os dados já estejam ordenados.

---

## **6. Conclusão**
- **Selection Sort é um algoritmo de ordenação simples**, mas **ineficiente para grandes conjuntos**.
- **Mais adequado para pequenos vetores** ou situações onde a troca de elementos seja custosa e o número de trocas deva ser minimizado.
- Para **grandes volumes de dados**, algoritmos como **Merge Sort e Quick Sort** são muito mais eficientes.

