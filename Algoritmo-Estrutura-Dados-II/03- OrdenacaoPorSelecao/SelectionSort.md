# 🔽 SELECTIONSORT

## 📚 O que é o Selection Sort?

- **Algoritmo iterativo** de ordenação.
- Baseado na ideia de **selecionar o menor (ou maior) elemento** e colocá-lo na posição correta.
- **Não usa recursão**, diferente do Mergesort.

---

## ⚙️ Como funciona (conceitualmente):

1. Percorre o vetor para **encontrar o menor elemento**.
2. Troca esse menor elemento com o elemento da **posição atual**.
3. Repete o processo para o restante do vetor até o final.

---

## 💡 Características:

- **Complexidade:**  
  - Melhor, pior e médio caso: **O(n²)**
- **Não estável:** pode alterar a ordem de elementos iguais.
- **Não requer espaço extra**: é feito **in-place**, ou seja, sem vetores auxiliares.
- Simples de implementar, porém **ineficiente em grandes volumes** de dados.

---

## 🧮 Exemplo com vetor pequeno

### Vetor inicial: `[23, 16, 4, 42]`

---

### 🧩 Etapas do Selection Sort com Numeração das Passagens

#### 🔵 **Passagem 1 (i = 0):**
- Subvetor analisado: `[23, 16, 4, 42]`
- Menor valor encontrado: `4` (índice 2)
- Troca `23` com `4`
- ✅ Vetor após troca: `[4, 16, 23, 42]`

#### 🔵 **Passagem 2 (i = 1):**
- Subvetor analisado: `[16, 23, 42]`
- Menor valor: `16` (já está na posição certa)
- ✅ Nenhuma troca: `[4, 16, 23, 42]`

#### 🔵 **Passagem 3 (i = 2):**
- Subvetor analisado: `[23, 42]`
- Menor valor: `23` (já está na posição certa)
- ✅ Nenhuma troca: `[4, 16, 23, 42]`

#### 🔵 **Passagem 4 (i = 3):**
- Último elemento já está no lugar.
- ✅ Fim do algoritmo: `[4, 16, 23, 42]`

---

### 🧠 Resumo por Passagem:

| Passagem | Operação               | Menor Encontrado | Troca Realizada?        | Vetor Atual             |
|----------|------------------------|------------------|--------------------------|--------------------------|
| 1        | Procura menor em `[23, 16, 4, 42]` | 4                | Sim (`23` ↔ `4`)          | `[4, 16, 23, 42]`        |
| 2        | Procura menor em `[16, 23, 42]`    | 16               | Não                       | `[4, 16, 23, 42]`        |
| 3        | Procura menor em `[23, 42]`        | 23               | Não                       | `[4, 16, 23, 42]`        |
| 4        | Último elemento já ordenado        | -                | Não                       | `[4, 16, 23, 42]`        |

---

## 🧑‍💻 Código Java Explicado

### Método principal:
```java
public T[] ordenar() {
  for (int i = 0; i < dados.length - 1; i++) {
    int menor = i;
    for (int j = i + 1; j < dados.length; j++) {
      comparacoes++;
      if (comparador.compare(dados[j], dados[menor]) < 0) {
        menor = j;
      }
    }
    if (menor != i) {
      trocar(i, menor);
      movimentacoes += 3;
    }
  }
  return dados;
}
```
> Percorre o vetor, selecionando o menor elemento e trocando com a posição atual.

---

### Método `trocar`:
```java
private void trocar(int i, int j) {
  T temp = dados[i];
  dados[i] = dados[j];
  dados[j] = temp;
}
```
> Realiza a troca entre os elementos das posições `i` e `j`.

---

## 🧠 Comparações e Movimentações

Durante o processo:

- Cada verificação `if (dados[j] < dados[menor])` conta como **comparação**.
- Cada troca entre elementos conta como **3 movimentações** (leitura e escrita das 3 posições envolvidas).

---

## 📌 Resumo Visual do Fluxo:

```
[29, 10, 14, 37, 13]
 ↓
[10, 29, 14, 37, 13]
      ↓
[10, 13, 14, 37, 29]
           ↓
[10, 13, 14, 29, 37]
               ↓
```
> Em cada passo, o menor elemento do restante do vetor é colocado na posição correta.

---

## ✅ Vantagens

- **Simples de implementar**.
- **Poucas trocas**, útil quando a troca de elementos é custosa.
- Não requer memória adicional (algoritmo in-place).

---

## ⚠️ Desvantagens

- Desempenho ruim em vetores grandes (**O(n²)** no melhor, médio e pior caso).
- Ineficiente comparado a algoritmos mais avançados.
- **Não é estável** (pode alterar a ordem de elementos iguais).

---

## 🕐 Quando usar o Selection Sort?

- Quando o **custo de movimentação** for alto, e o de comparação for baixo.
- Para **vetores pequenos ou quase ordenados** (embora Insertion Sort ainda seja mais eficiente nesse cenário).
- Quando **simples implementação** for mais importante que desempenho.

---

## ✅ Conclusão

- Selection Sort é **fácil de entender e codificar**.
- Realiza **poucas movimentações**, mas muitas comparações.
- Ideal apenas para **casos simples ou didáticos**.
- Seu desempenho é **O(n²)** em todos os casos, o que o torna inviável para grandes volumes de dados.

---

