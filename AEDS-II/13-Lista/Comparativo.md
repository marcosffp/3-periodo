# ⚔️ COMPARATIVO: LISTA SIMPLES vs LISTA DUPLAMENTE ENCADEADA vs LISTA COM VETOR

## 📚 Estruturas

| Aspecto          | Lista Encadeada (Simples)                 | Lista Duplamente Encadeada                           | Lista com Vetor                  |
| ---------------- | ----------------------------------------- | ---------------------------------------------------- | -------------------------------- |
| Armazenamento    | Células ligadas com 1 ponteiro (próximo)  | Células ligadas com 2 ponteiros (próximo e anterior) | Vetor fixo em posições contíguas |
| Tamanho          | **Dinâmico** (cresce conforme necessário) | **Dinâmico**                                         | **Fixo** (definido na criação)   |
| Memória extra    | Sim (1 ponteiro por célula)               | Sim (2 ponteiros por célula)                         | Não (apenas os dados)            |
| Uso de sentinela | Sim                                       | Sim                                                  | Não se aplica                    |
| Percurso         | Apenas do início ao fim                   | Nos dois sentidos (início ↔ fim)                     | Apenas por índice direto         |

---

## 🔥 Operações Básicas

| Operação             | Lista Simples | Lista Dupla | Lista com Vetor |
| -------------------- | ------------- | ----------- | --------------- |
| Inserir no início    | O(1)          | O(1)        | O(n)            |
| Inserir no meio      | O(n)          | O(n)        | O(n)            |
| Inserir no fim       | O(1)          | O(1)        | O(1)\*          |
| Remover do início    | O(1)          | O(1)        | O(n)            |
| Remover no meio      | O(n)          | O(n)        | O(n)            |
| Remover do fim       | O(n)\*        | O(1)        | O(1)            |
| Consultar por índice | O(n)          | O(n)        | O(1)            |
| Verificar vazia      | O(1)          | O(1)        | O(1)            |

> \* Inserção no fim em vetor é O(1) apenas se houver espaço.
> \* Remoção do fim em lista simples é O(n) por falta de ponteiro para o anterior.

---

## 🛠️ Implementação

| Critério               | Lista Simples                       | Lista Dupla                           | Lista com Vetor                               |
| ---------------------- | ----------------------------------- | ------------------------------------- | --------------------------------------------- |
| Complexidade de código | Moderada (um ponteiro)              | Alta (dois ponteiros, lógica reversa) | Baixa (índices simples)                       |
| Realocação de memória  | Não precisa (crescimento dinâmico)  | Não precisa                           | Pode precisar (ArrayList)                     |
| Deslocamento de dados  | Não há (apenas ajuste de ponteiros) | Não há                                | Sim, exige deslocamento à direita ou esquerda |
| Percurso reverso       | Não                                 | Sim                                   | Não                                           |

---

## ⚡ Vantagens e Desvantagens

| Aspecto      | Lista Simples                             | Lista Dupla                                         | Lista com Vetor                                       |
| ------------ | ----------------------------------------- | --------------------------------------------------- | ----------------------------------------------------- |
| Vantagens    | Estrutura simples, leve e dinâmica        | Percurso em duas direções; remoção eficiente no fim | Acesso rápido por índice; estrutura simples           |
| Desvantagens | Sem acesso reverso; remoção do fim é O(n) | Mais memória e código mais complexo                 | Tamanho fixo; inserções/remoções no meio são custosas |

---

## 🎯 Quando usar qual?

* **Lista Encadeada Simples**
  👉 Quando há muitas inserções/remoções **no início** ou em posições variadas e **crescimento imprevisível**.
  👉 Simples e econômica para listas unidirecionais.

* **Lista Duplamente Encadeada**
  👉 Quando você precisa **navegar para frente e para trás**.
  👉 Ideal para aplicações como editores, navegadores e sistemas de histórico.

* **Lista com Vetor**
  👉 Quando o número de elementos é **conhecido** e o acesso por índice precisa ser **muito rápido**.
  👉 Simples, mas menos flexível.

---

# 🧠 Resumo Final:

> **"Use vetor para acesso rápido por índice com tamanho fixo. Use lista simples para crescer dinamicamente. Use lista duplamente encadeada para percursos bidirecionais e remoções eficientes no fim."**

---
