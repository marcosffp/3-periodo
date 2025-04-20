# 📚 RESUMO COMPLETO: NOTAÇÕES DE COMPLEXIDADE DE ALGORITMOS

---

## ✳️ O que são?

As **notações de complexidade** descrevem como o tempo (ou espaço) de execução de um algoritmo **cresce em função da entrada `n`**, principalmente quando `n` tende ao infinito. São fundamentais para **comparar algoritmos** e entender sua escalabilidade.

---

## 🔢 Principais Notações Assintóticas

### 📏 **1. Notação O (Big-O) – Limite Superior**
> Representa o **pior caso**, ou seja, o tempo máximo de execução.

### 📌 Definição:
`g(n)` é **O(f(n))** se existem constantes `c > 0` e `m ≥ 0` tais que:
\[
|g(n)| \leq c \cdot |f(n)| \quad \text{para todo } n \geq m
\]

✅ **Exemplo**:  
Provar que `g(n) = 3n² + 5n + 1` é `O(n²)`

📍 Passos:
- Escolher `f(n) = n²`
- Mostrar que:  
  \[
  3n² + 5n + 1 \leq c \cdot n²
  \]
- Para `c = 5` e `m = 6`, a desigualdade é satisfeita.  
✅ Logo: `g(n) = O(n²)`

---

### 📉 **2. Notação Ω (Ômega) – Limite Inferior**
> Representa o **melhor caso**, ou seja, o tempo mínimo que pode ser gasto.

### 📌 Definição:
`g(n)` é **Ω(f(n))** se existem constantes `c > 0` e `m ≥ 0` tais que:
\[
|g(n)| \geq c \cdot |f(n)| \quad \text{para todo } n \geq m
\]

✅ **Exemplo**:  
Provar que `g(n) = n² + 10` é `Ω(n²)`

📍 Passos:
- Escolher `f(n) = n²`
- Mostrar que:  
  \[
  n² + 10 \geq c \cdot n²
  \]
- Para `c = 1` e `m = 1`, é sempre verdadeiro.  
✅ Logo: `g(n) = Ω(n²)`

---

### ⚖️ **3. Notação Θ (Teta) – Limite Justo**
> Indica que a função **cresce exatamente igual** à função de referência.

### 📌 Definição:
`g(n)` é **Θ(f(n))** se existem constantes `c₁`, `c₂` e `m ≥ 0` tais que:
\[
c_1 \cdot f(n) \leq g(n) \leq c_2 \cdot f(n) \quad \text{para todo } n \geq m
\]

✅ **Exemplo**:  
Provar que `g(n) = n² + 10` é `Θ(n²)`

📍 Passos:
- Já vimos que:  
  `n² + 10 ≤ 2n²` (Big-O) e `n² + 10 ≥ n²` (Ω)
- Então, `c₁ = 1`, `c₂ = 2`, `m = 4`  
✅ Logo: `g(n) = Θ(n²)`

---

## 📈 Crescimento das Funções – Do mais lento ao mais rápido

1. `O(1)` – Constante  
2. `O(log n)` – Logarítmica  
3. `O(n)` – Linear  
4. `O(n log n)` – Linearítmica  
5. `O(n²)` – Quadrática  
6. `O(n³)` – Cúbica  
7. `O(n^k)` – Polinomial  
8. `O(2^n)` – Exponencial  
9. `O(n!)` – Fatorial

---

## ⏱️ Tabela com tempos estimados (para n crescente)

| Função       | n = 10    | n = 20    | n = 50     | n = 60            |
|--------------|-----------|-----------|------------|-------------------|
| `n`          | 0,00001 s | 0,00002 s | 0,00005 s  | 0,00006 s         |
| `n²`         | 0,0001 s  | 0,0004 s  | 0,0025 s   | 0,0036 s          |
| `n³`         | 0,001 s   | 0,008 s   | 0,125 s    | 0,316 s           |
| `n⁵`         | 0,1 s     | 3,2 s     | 5,2 min    | 13 min            |
| `2^n`        | 0,001 s   | 1 s       | 35,7 anos  | 366 séculos (!😱) |

---

## 🧠 Dicas para Provas

- **Big-O**: mostre que a função nunca ultrapassa `c·f(n)`
- **Ω**: mostre que ela **sempre** está acima de `c·f(n)`
- **Θ**: mostre os dois ao mesmo tempo: inferior e superior

---

## ⚙️ Classes de Complexidade e Exemplos

| Classe           | Exemplo de algoritmo            | Complexidade      |
|------------------|----------------------------------|-------------------|
| Constante        | Leitura de variável              | O(1)              |
| Logarítmica      | Busca binária                    | O(log n)          |
| Linear           | Busca sequencial                 | O(n)              |
| Linearítmica     | Mergesort, Heapsort              | O(n log n)        |
| Quadrática       | Insertion, Selection, Bubble     | O(n²)             |
| Exponencial      | Força bruta, Caixeiro Viajante   | O(2ⁿ)             |
| Fatorial         | Permutação exaustiva             | O(n!)             |

---

## 📌 Exemplos Práticos de Classificação

| Função                        | O       | Ω       | Θ       |
|-----------------------------|---------|---------|---------|
| `5n + 1`                    | O(n)    | Ω(n)    | Θ(n)    |
| `3n² + 2n`                  | O(n²)   | Ω(n²)   | Θ(n²)   |
| `2n³ + log n`               | O(n³)   | Ω(n³)   | Θ(n³)   |
| `5n log n + 2n`             | O(n log n) | Ω(n log n) | Θ(n log n) |
| `21`                        | O(1)    | Ω(1)    | Θ(1)    |

---

## 📋 Resumo com analogia

| Notação | Interpretação       | Analogia simplificada                        |
|---------|---------------------|----------------------------------------------|
| **O**   | Pior caso           | "Até quanto tempo pode demorar?"             |
| **Ω**   | Melhor caso         | "Pelo menos quanto tempo vai demorar?"       |
| **Θ**   | Caso médio/exato    | "Tempo vai crescer mais ou menos assim..."   |

---

## ⚠️ Problemas Intratáveis

Problemas com crescimento **exponencial** ou **fatorial** rapidamente se tornam inviáveis:
- Ex: O **Caixeiro Viajante**, com 16 cidades → pode levar **8,6 séculos** com abordagem força bruta!

