# 🔀 MERGESORT 

## 📚 O que é o Mergesort?

- **Algoritmo recursivo** de ordenação.
- Usa o princípio de **dividir e conquistar**.
- Divide o vetor em subpartes, **ordena cada metade** recursivamente e depois **intercala** os resultados em ordem.

---

## ⚙️ Como funciona (conceitualmente):

1. **Divide** recursivamente o vetor ao meio até que cada subvetor tenha 1 elemento.
2. **Intercala** os subvetores, comparando os elementos e ordenando.
3. Retorna o vetor final ordenado.

---

## 💡 Características:

- **Complexidade:**  
  - Melhor, pior e médio caso: **O(n log n)**
- **Estável:** mantém a ordem de elementos iguais.
- **Requer espaço extra**: utiliza vetores auxiliares na intercalação.
- Muito eficiente para **grandes volumes de dados**.

---

## 🧮 Exemplo com vetor pequeno
Perfeito! Aqui está a mesma explicação, **com as iterações numeradas** para deixar claro **em qual passagem (ou chamada recursiva) cada divisão e intercalação acontece**. Assim, você visualiza **a ordem de execução do Mergesort** com mais clareza.

---

### 📐 Etapas do Mergesort com Numeração das Passagens

### 🔹 **Etapa 1 – Divisão**

#### 🟠 **Passagem 1:**
- Vetor completo: `[23, 16, 4, 42]`
  - Divide em `[23, 16]` e `[4, 42]`

#### 🟠 **Passagem 2:**
- Subvetor esquerdo: `[23, 16]`
  - Divide em `[23]` e `[16]`  
  🔸 *Parou aqui, pois são unidades*

#### 🟠 **Passagem 3:**
- Subvetor direito: `[4, 42]`
  - Divide em `[4]` e `[42]`  
  🔸 *Também parou aqui*

---

### 🔹 **Etapa 2 – Intercalação**

#### 🟢 **Passagem 4 (Intercala `[23]` e `[16]`):**
- Comparação: 23 > 16 → 16 vai primeiro
- Depois: 23 é inserido
- ✅ Resultado: `[16, 23]`

#### 🟢 **Passagem 5 (Intercala `[4]` e `[42]`):**
- Comparação: 4 < 42 → 4 vai primeiro
- Depois: 42 é inserido
- ✅ Resultado: `[4, 42]`

#### 🟢 **Passagem 6 (Intercala `[16, 23]` e `[4, 42]`):**
- Compara 16 e 4 → 4 vai primeiro
- Compara 16 e 42 → 16 vai
- Compara 23 e 42 → 23 vai
- 42 restante é inserido
- ✅ Resultado final: `[4, 16, 23, 42]`

---

### 🧠 Resumo por Passagem:

| Passagem | Operação           | Vetores Envolvidos      | Resultado            |
|----------|--------------------|--------------------------|----------------------|
| 1        | Divisão inicial     | `[23, 16, 4, 42]`        | `[23, 16]` e `[4, 42]` |
| 2        | Subdivisão à esquerda | `[23, 16]` → `[23]`, `[16]` | -                  |
| 3        | Subdivisão à direita | `[4, 42]` → `[4]`, `[42]` | -                  |
| 4        | Intercalação        | `[23]` + `[16]`          | `[16, 23]`           |
| 5        | Intercalação        | `[4]` + `[42]`           | `[4, 42]`            |
| 6        | Intercalação final  | `[16, 23]` + `[4, 42]`   | `[4, 16, 23, 42]`    |

---

## 🧑‍💻 Código Java Explicado

### Método principal:
```java
public T[] ordenar() {
  mergesort(0, dados.length - 1);
  return dados;
}
```
> Chama o método recursivo `mergesort`.

---

### Método `mergesort`:
```java
void mergesort(int esq, int dir) {
  if (esq < dir) {
    int meio = (esq + dir) / 2;
    mergesort(esq, meio);
    mergesort(meio + 1, dir);
    intercalar(esq, meio, dir);
  }
}
```
> Divide o vetor até que cada subparte tenha um único elemento.

---

### Método `intercalar`:
```java
 private void intercalar(int esq, int meio, int dir) {
    int n1 = meio - esq + 1;
    int n2 = dir - meio;

    @SuppressWarnings("unchecked")
    T[] a1 = (T[]) new Comparable[n1];
    @SuppressWarnings("unchecked")
    T[] a2 = (T[]) new Comparable[n2];

    for (int i = 0; i < n1; i++) {
      a1[i] = dados[esq + i];
    }
    for (int j = 0; j < n2; j++) {
      a2[j] = dados[meio + 1 + j];
    }

    int i = 0, j = 0, k = esq;
    while (i < n1 && j < n2) {
      comparacoes++;
      if (comparador.compare(a1[i], a2[j]) <= 0) {
        dados[k] = a1[i++];
      } else {
        dados[k] = a2[j++];
      }
      movimentacoes++;
      k++;
    }

    while (i < n1) {
      dados[k++] = a1[i++];
      movimentacoes++;
    }
    while (j < n2) {
      dados[k++] = a2[j++];
      movimentacoes++;
    }
  }
```

> Aqui está o “segredo” do Mergesort: comparar os elementos dos subvetores e **mesclar em ordem crescente**.

---

## 🧠 Comparações e Movimentações

Durante a intercalação:

- Cada comparação entre `a1[i]` e `a2[j]` conta como **comparação**.
- Cada inserção no vetor `dados` conta como **movimentação**.

---

## 📌 Resumo Visual do Fluxo:

```
           [23, 16, 4, 42]
             /         \
         [23,16]     [4,42]
         /    \       /   \
      [23]  [16]   [4]   [42]
         \    /       \    /
      [16, 23]     [4, 42]
           \        /
       [4, 16, 23, 42]
```

---

## ✅ Vantagens

- **Desempenho consistente** mesmo no pior caso (O(n log n)).  
- **Estável**, ideal para ordenações em que a posição relativa importa (ex: objetos com chaves iguais).  
- Excelente para **grandes conjuntos de dados**, especialmente aqueles armazenados em disco ou distribuídos.

---

## ⚠️ Desvantagens

- **Uso elevado de memória**: precisa de espaço auxiliar proporcional ao tamanho do vetor.  
- **Não é ideal para vetores pequenos**, onde algoritmos como Insertion Sort podem ser mais rápidos.  
- Pode ter **desempenho inferior** a algoritmos in-place (como Quicksort) em ambientes com pouca memória.

---

## 🕐 Quando usar o Mergesort?

- Quando **estabilidade é importante**.  
- Em situações com **grandes volumes de dados**, especialmente quando a ordenação é feita fora da memória RAM.  
- Quando o **tempo de execução previsível** é essencial.  
- **Não recomendado** se o espaço extra for uma limitação (como em sistemas embarcados ou com pouca RAM).

---

## ✅ Conclusão

- Mergesort é **eficiente e estável**.
- Usa o princípio de **dividir para conquistar**.
- **Ideal para grandes vetores**, apesar de consumir memória adicional.
- Executa em tempo **O(n log n)** mesmo no pior caso.




