# ⚔️ COMPARATIVO: FILA COM LISTA ENCADEADA vs FILA COM VETOR CIRCULAR

## 📚 Estruturas

| Aspecto                | Lista Encadeada                              | Vetor Circular                                   |
|:-----------------------|:---------------------------------------------|:-------------------------------------------------|
| Armazenamento          | Células ligadas por ponteiros (estrutura dinâmica) | Vetor fixo em memória contígua (estrutura estática) |
| Tamanho                | **Dinâmico** (cresce conforme necessário)    | **Fixo** (definido na criação)                  |
| Memória extra          | Sim (precisa de ponteiros em cada célula)   | Não (apenas os dados e dois índices)            |
| Uso de sentinela       | Sim (facilita operações)                     | Não                                              |

---

## 🔥 Operações Básicas

| Operação           | Lista Encadeada | Vetor Circular |
|--------------------|-----------------|----------------|
| Enfileirar         | O(1)            | O(1)           |
| Desenfileirar      | O(1)            | O(1)           |
| Consultar primeiro | O(1)            | O(1)           |
| Verificar vazia    | O(1)            | O(1)           |
| Verificar cheia    | Não se aplica   | O(1)           |

✅ Ambas realizam as operações básicas em **tempo constante O(1)**.

---

## 🛠️ Implementação

| Critério               | Lista Encadeada                              | Vetor Circular                                    |
|:-----------------------|:---------------------------------------------|:--------------------------------------------------|
| Complexidade de código | Moderada (ponteiros, sentinela)              | Simples (controle por índices + módulo)           |
| Controle de limites    | Não precisa (cresce conforme uso)            | Sim (verifica se está cheia com aritmética modular) |
| Tratamento de memória  | Dinâmico (aloca células sob demanda)         | Estático (aloca vetor completo na criação)        |

---

## ⚡ Vantagens e Desvantagens

| Aspecto              | Lista Encadeada                                    | Vetor Circular                                                |
|:---------------------|:---------------------------------------------------|:---------------------------------------------------------------|
| Vantagens            | Crescimento ilimitado; facilita inserções/remoções | Operações rápidas; uso eficiente do vetor via aritmética modular |
| Desvantagens         | Maior uso de memória por célula; menos cache-friendly | Tamanho limitado; precisa cuidar da lógica circular (índices)   |

---

## 🎯 Quando usar qual?

- **Lista Encadeada**:  
  👉 Quando o número de elementos pode variar muito ou crescer indefinidamente.

- **Vetor Circular**:  
  👉 Quando se sabe o limite máximo de elementos e se deseja **eficiência e simplicidade**.

---

# 🧠 Resumo Final:

> **"Fila com vetor circular é eficiente e simples se o tamanho máximo for conhecido; fila com lista encadeada é flexível e cresce dinamicamente, mas usa mais memória."**

---

