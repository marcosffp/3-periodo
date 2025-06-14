# 🌳 RESUMO — Estrutura de Árvores (Conceitos, Vantagens, Desvantagens e Complexidade)

## ✅ O que é uma Árvore?

### 📌 Definição:

Estrutura de dados **não-linear e hierárquica**, onde:

* Um elemento é chamado de **nó (ou nodo)**;
* Cada nó pode ter **filhos**, exceto a **raiz**, que não tem pai;
* Representa relações de **pai e filho**, **nível**, **altura**, etc.

---

## 🔍 Conceitos Fundamentais

| Conceito             | Definição                                               |
| -------------------- | ------------------------------------------------------- |
| **Nó (Nodo)**        | Unidade básica da árvore que contém um dado.            |
| **Raiz**             | Primeiro nó da árvore. Não possui pai.                  |
| **Filhos**           | Nós diretamente conectados abaixo de um nó.             |
| **Pai**              | Nó imediatamente acima de outro nó.                     |
| **Folha**            | Nó **sem filhos** (grau 0).                             |
| **Grau de um nó**    | Número de filhos que o nó possui.                       |
| **Grau da árvore**   | Maior grau entre todos os nós.                          |
| **Nível**            | Distância da raiz até o nó (raiz = nível 0).            |
| **Altura do nó**     | Número de arestas do **nó até a folha mais distante**.  |
| **Altura da árvore** | Altura da raiz.                                         |
| **Subárvore**        | Qualquer árvore originada de um nó e seus descendentes. |

---

## 🌲 Tipos de Árvores

### 🔹 Árvore Binária

* Cada nó pode ter **no máximo 2 filhos**: esquerdo e direito.

### 🔹 Árvore Binária de Busca (ABB ou BST)

* Estrutura **ordenada** onde:

  * Nó da **esquerda < raiz**
  * Nó da **direita > raiz**

---

## ✅ Vantagens das Árvores

* Representam **relacionamentos hierárquicos** naturalmente;
* Operações como busca, inserção e remoção são **eficientes em ABBs balanceadas**;
* São **flexíveis** para organização e agrupamento de dados.

---

## ❌ Desvantagens das Árvores

* Podem se tornar **desequilibradas**, virando listas lineares no pior caso;
* Consomem mais memória que vetores/listas (referências para filhos);
* Operações são **mais complexas** que em listas simples.

---

## 📊 Complexidade — ABB (Árvore Binária de Busca)

| Operação | Melhor Caso | Caso Médio | Pior Caso (desbalanceada) |
| -------- | ----------- | ---------- | ------------------------- |
| Busca    | O(log n)    | O(log n)   | O(n)                      |
| Inserção | O(log n)    | O(log n)   | O(n)                      |
| Remoção  | O(log n)    | O(log n)   | O(n)                      |

> ⚠️ Se a árvore for construída com dados ordenados (crescente ou decrescente), ela vira uma **lista linear**, piorando todas as operações.

---

## 🧠 Quando Usar Árvores?

| Situação                                  | Melhor Abordagem          |
| ----------------------------------------- | ------------------------- |
| Relacionamento hierárquico (ex: arquivos) | Árvores genéricas         |
| Busca eficiente em dados ordenados        | ABB / Árvore Balanceada   |
| Inserção e remoção frequente              | ABB                       |
| Prioridade entre elementos                | Heaps (não abordado aqui) |

---

