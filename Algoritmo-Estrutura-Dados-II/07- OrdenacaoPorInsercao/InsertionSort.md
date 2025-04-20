# 🧩 INSERTIONSORT

## 📚 O que é o Insertion Sort?

- **Algoritmo simples** de ordenação.
- Funciona como se você estivesse **organizando cartas na mão**.
- A cada passo, **insere o elemento atual** na posição correta **em relação aos anteriores**.

---

## ⚙️ Como funciona (conceitualmente):

1. Começa do **segundo elemento** e o compara com os anteriores.
2. **Desloca** os maiores para a direita para **abrir espaço**.
3. **Insere o elemento atual** na posição correta.
4. Repete até o vetor estar ordenado.

---

## 💡 Características:

- **Complexidade:**
  - Melhor caso (vetor já ordenado): **O(n)**
  - Pior caso (vetor invertido): **O(n²)**
- **Estável**: mantém ordem de elementos iguais.
- **Não precisa de memória extra**: ordenação **in-place**.
- **Eficiente para vetores pequenos** ou **quase ordenados**.

---

## 🧮 Exemplo com vetor pequeno

Vamos usar o vetor `[7, 4, 5, 2]` como exemplo, com **iterações numeradas** para visualizar claramente o que acontece a cada passo.

---

### 📐 Etapas do Insertion Sort com Numeração das Passagens

#### 🟢 **Passagem 1:**
- Vetor atual: `[7, 4, 5, 2]`
- Elemento analisado: `4`
  - 4 < 7 → desloca 7
  - Insere 4 na posição 0  
- ✅ Resultado: `[4, 7, 5, 2]`

#### 🟢 **Passagem 2:**
- Vetor atual: `[4, 7, 5, 2]`
- Elemento analisado: `5`
  - 5 < 7 → desloca 7
  - 5 > 4 → insere depois de 4  
- ✅ Resultado: `[4, 5, 7, 2]`

#### 🟢 **Passagem 3:**
- Vetor atual: `[4, 5, 7, 2]`
- Elemento analisado: `2`
  - 2 < 7 → desloca 7  
  - 2 < 5 → desloca 5  
  - 2 < 4 → desloca 4  
  - Insere 2 na posição 0  
- ✅ Resultado final: `[2, 4, 5, 7]`

---

### 🧠 Resumo por Passagem:

| Passagem | Elemento analisado | Ação                                     | Resultado            |
|----------|--------------------|------------------------------------------|----------------------|
| 1        | `4`                | Desloca `7`, insere `4`                  | `[4, 7, 5, 2]`       |
| 2        | `5`                | Desloca `7`, insere `5` após `4`         | `[4, 5, 7, 2]`       |
| 3        | `2`                | Desloca `7`, `5`, `4`, insere `2`        | `[2, 4, 5, 7]`       |

---

## 🧑‍💻 Código Java Explicado – Insertion Sort

### Método principal:
```java
public T[] ordenar() {
  for (int i = 1; i < dados.length; i++) {
    T chave = dados[i];
    int j = i - 1;

    while (j >= 0 && comparador.compare(dados[j], chave) > 0) {
      dados[j + 1] = dados[j];
      movimentacoes++;
      comparacoes++;
      j--;
    }

    dados[j + 1] = chave;
    movimentacoes++;

    if (j >= 0) comparacoes++;
  }

  return dados;
}
```

> Percorre o vetor da esquerda para a direita, **inserindo cada elemento na posição correta** em relação aos anteriores já ordenados.

---

## ⚙️ Como o algoritmo funciona?

- Começa do **índice 1**, assume que o índice 0 já está ordenado.
- Salva o elemento atual como **chave**.
- Compara com os anteriores, **desloca para direita os maiores**.
- Quando acha a posição certa, **insere a chave**.

---

## 🧠 Comparações e Movimentações

- Cada verificação `dados[j] > chave` conta como **comparação**.
- Cada deslocamento ou inserção de valor conta como **movimentação**.

---

## 📌 Exemplo Visual do Fluxo:

Ordenando o vetor `[7, 4, 5, 2]`:

```
Passo 1: chave = 4
[7, 7, 5, 2]   → desloca 7
[4, 7, 5, 2]   → insere 4

Passo 2: chave = 5
[4, 7, 7, 2]   → desloca 7
[4, 5, 7, 2]   → insere 5

Passo 3: chave = 2
[4, 5, 7, 7]   → desloca 7
[4, 5, 5, 7]   → desloca 5
[4, 4, 5, 7]   → desloca 4
[2, 4, 5, 7]   → insere 2
```

---

## ✅ Vantagens

- **Simples de implementar**.  
- **Estável**: mantém a ordem de elementos com valores iguais.  
- Ótimo desempenho em **vetores pequenos** ou **quase ordenados**.  
- Ordenação **in-place**: não usa memória extra.

---

## ⚠️ Desvantagens

- **Desempenho ruim em grandes vetores desordenados**:  
  - Pior caso é **O(n²)**.  
- Ineficiente para conjuntos de dados muito grandes.  
- **Não recomendado para volumes de dados extensos**, especialmente se estiverem fora da memória principal.

---

## 🕐 Quando usar o Insertion Sort?

- Quando o **vetor é pequeno**.  
- Quando o vetor está **quase ordenado**.  
- Em **sistemas com pouca memória** (não aloca espaço extra).  
- Quando **estabilidade** é desejada sem sobrecarga de memória.

---

## ✅ Conclusão

- Insertion Sort é um **algoritmo direto, estável e eficiente** em cenários menores.  
- Ideal para situações com **pouca complexidade ou quase ordenação**.  
- Embora seja **O(n²)** no pior caso, tem ótimo desempenho no melhor caso (**O(n)**).  
- **Não consome memória extra** e pode ser útil como base em algoritmos híbridos.

---
