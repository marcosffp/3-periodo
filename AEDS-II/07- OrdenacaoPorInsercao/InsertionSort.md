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

#### 🔹 Passagem 1 (`i = 0`):

* `menor = 0` (`7`)
* `j = 1`: compara `7` com `4` → `menor = 1`
* `j = 2`: compara `4` com `5` → nada muda
* `j = 3`: compara `4` com `2` → `menor = 3`
* **Troca `7` com `2`**
  ✅ Vetor após: `[2, 4, 5, 7]`

---

#### 🔹 Passagem 2 (`i = 1`):

* `menor = 1` (`4`)
* `j = 2`: compara `4` com `5` → nada muda
* `j = 3`: compara `4` com `7` → nada muda
* **Nenhuma troca**
  ✅ Vetor permanece: `[2, 4, 5, 7]`

---

#### 🔹 Passagem 3 (`i = 2`):

* `menor = 2` (`5`)
* `j = 3`: compara `5` com `7` → nada muda
* **Nenhuma troca**
  ✅ Vetor permanece: `[2, 4, 5, 7]`

---

### 🧠 Resumo correto com base no **Selection Sort**:

| Passagem | Elemento fixo (posição i) | Menor encontrado | Troca?      | Resultado      |
| -------- | ------------------------- | ---------------- | ----------- | -------------- |
| 1        | 7 (pos 0)                 | 2 (pos 3)        | Sim (0 ↔ 3) | `[2, 4, 5, 7]` |
| 2        | 4 (pos 1)                 | 4                | Não         | `[2, 4, 5, 7]` |
| 3        | 5 (pos 2)                 | 5                | Não         | `[2, 4, 5, 7]` |


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
