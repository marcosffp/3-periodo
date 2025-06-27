# ⚔️ COMPARATIVO: PILHA COM VETOR vs PILHA COM LISTA ENCADEADA

## 📚 Estruturas

| Aspecto                | Vetor (Array)                            | Lista Encadeada                          |
|:------------------------|:----------------------------------------|:----------------------------------------|
| Armazenamento           | Vetor fixo em memória contínua           | Células ligadas por ponteiros            |
| Tamanho                 | **Fixo** (definido na criação)           | **Dinâmico** (cresce conforme necessário)|
| Memória extra           | Não precisa (só os dados)                | Precisa armazenar ponteiros extras       |

---

## 🔥 Operações Básicas

| Operação       | Vetor (Array) | Lista Encadeada |
|----------------|---------------|-----------------|
| Empilhar       | O(1)           | O(1)             |
| Desempilhar    | O(1)           | O(1)             |
| Consultar Topo | O(1)           | O(1)             |
| Verificar Vazio| O(1)           | O(1)             |

✅ Em ambos os casos, **todas as operações básicas têm tempo constante O(1)**.

---

## 🛠️ Implementação

| Critério             | Vetor (Array)                          | Lista Encadeada                        |
|:---------------------|:---------------------------------------|:---------------------------------------|
| Complexidade de código| Simples (índice `topo`)                | Um pouco mais complexa (objetos Celula)|
| Controle de limites   | Sim (verifica se vetor está cheio)     | Não precisa (crescimento automático)   |
| Tratamento de memória | Estático (sempre aloca o vetor inteiro)| Dinâmico (aloca células conforme uso)  |

---

## ⚡ Vantagens e Desvantagens

| Aspecto               | Vetor (Array)                         | Lista Encadeada                        |
|:-----------------------|:-------------------------------------|:--------------------------------------|
| Vantagens              | Rápido no acesso (cache-friendly); código simples | Cresce sem limite prévio; não desperdiça memória inicial |
| Desvantagens           | Limite fixo; pode desperdiçar memória | Mais uso de memória (ponteiros); acesso menos otimizado na CPU |

---

## 🎯 Quando usar qual?

- **Vetor**:  
  👉 Quando você sabe o tamanho máximo da pilha e precisa de **acesso ultrarrápido**.

- **Lista Encadeada**:  
  👉 Quando o tamanho da pilha é **imprevisível** ou pode variar muito durante o uso.

---

# 🧠 Resumo Final:

> **"Pilha com vetor é mais simples e rápida se o tamanho for conhecido; pilha com lista encadeada é mais flexível e cresce dinamicamente, mas usa mais memória."**

---