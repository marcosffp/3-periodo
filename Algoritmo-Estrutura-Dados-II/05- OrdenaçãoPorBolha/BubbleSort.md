# **Resumo – Método de Ordenação por Bolha (Bubble Sort)**

## **1. O que é Ordenação?**
- Processo de **organizar os elementos** de um conjunto de dados.
- Pode ser feita de forma **crescente** ou **decrescente**.
- Auxilia em buscas mais eficientes e melhora a estruturação dos dados.

## **2. Como Funciona o Bubble Sort?**
### **Passo a passo:**
1. Percorre o vetor diversas vezes.
2. Em cada passagem, compara elementos adjacentes e os troca se estiverem fora de ordem.
3. A cada iteração, o maior elemento "flutua" para o final do vetor.
4. O processo se repete até que nenhum elemento precise ser trocado.

### **Exemplo:**
Ordenando o vetor `[23, 16, 4, 42, 8, 15]` de forma crescente:

| Iteração | Vetor Ordenado Parcialmente |
|------------|-----------------------------|
| 1ª Passagem | `[16, 4, 23, 8, 15, 42]`  |
| 2ª Passagem | `[4, 16, 8, 15, 23, 42]`  |
| 3ª Passagem | `[4, 8, 15, 16, 23, 42]`  |
| 4ª Passagem | `[4, 8, 15, 16, 23, 42]`  |

---

## **3. Código em Java – Bubble Sort**
```java
public class BubbleSort {
    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
}
```

---

## **4. Complexidade do Bubble Sort**
- **Melhor caso (vetor já ordenado):** **O(n)**
- **Pior caso (vetor ordenado inversamente):** **O(n²)**
- **Caso médio:** **O(n²)**
- **Espaço adicional usado:** **O(1)** (ordenamento feito "in-place", sem uso extra de memória)

📌 **O algoritmo é ineficiente para grandes conjuntos de dados, pois faz muitas comparações e trocas.**

---

## **5. Comparação com Outros Métodos**
| Algoritmo       | Melhor Caso | Pior Caso | Caso Médio | Complexidade Espacial |
|----------------|------------|------------|------------|----------------------|
| **Bubble Sort** | O(n) | O(n²) | O(n²) | O(1) |
| **Selection Sort** | O(n²) | O(n²) | O(n²) | O(1) |
| **Insertion Sort** | O(n) | O(n²) | O(n²) | O(1) |
| **Merge Sort** | O(n log n) | O(n log n) | O(n log n) | O(n) |
| **Quick Sort** | O(n log n) | O(n²) | O(n log n) | O(log n) |

✅ **Vantagens do Bubble Sort:**
- Simples de implementar.
- Funciona bem para pequenos conjuntos de dados ou listas quase ordenadas.

❌ **Desvantagens do Bubble Sort:**
- Ineficiente para grandes conjuntos de dados.
- Realiza muitas trocas desnecessárias.

---

## **6. Conclusão**
- **Bubble Sort é um algoritmo de ordenação simples**, mas **pouco eficiente para grandes conjuntos**.
- **É adequado apenas para pequenos vetores** ou casos onde a lista já está quase ordenada.
- Para **grandes volumes de dados**, algoritmos como **Merge Sort e Quick Sort** são muito mais eficientes.

